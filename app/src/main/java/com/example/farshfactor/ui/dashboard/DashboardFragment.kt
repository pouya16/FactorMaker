package com.example.farshfactor.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farshfactor.MyApp
import com.example.farshfactor.R
import com.example.farshfactor.database.User
import com.example.farshfactor.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    val viewModel: DashboardViewModel by viewModels {
        DashBoardViewModelFactory((activity?.application as MyApp).database.userDao())
    }

    lateinit var user: User

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UsersListAdapter{
            user = it
            viewModel.updateNeedUpdate(true)
            binding.apply {
                txtName.setText(user.name)
                txtPhon.setText(user.phone)
            }
        }

        binding.btnAdd.setOnClickListener{ addNewUser() }

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = adapter

        binding.btnCancel.setOnClickListener{
            viewModel.updateNeedUpdate(false)
            clearData()
        }

        binding.btnDelete.setOnClickListener{
            viewModel.deleteUser(user)
            clearData()
        }

        binding.btnUpdate.setOnClickListener{
            viewModel.updateUser(user)
            clearData()
        }

        viewModel.needUpdate.observe(this.viewLifecycleOwner){
            if(it){
                binding.layoutUpdate.visibility = View.VISIBLE
                binding.btnAdd.visibility = View.GONE
            }else{
                binding.layoutUpdate.visibility = View.GONE
                binding.btnAdd.visibility = View.VISIBLE
            }
        }

        viewModel.allUser.observe(this.viewLifecycleOwner){users ->
            users.let {
                adapter.submitList(it)
            }
        }



    }



    private fun addNewUser(){
        if(isEntryValid()){
            val user =  User(
                name = binding.txtName.text.toString(),
                phone = binding.txtName.text.toString()
            )
            viewModel.insertUser(user)
            clearData()
        }else{
            Toast.makeText(context,context?.getString(R.string.toast_error_data), Toast.LENGTH_SHORT).show()
        }
    }

    private fun isEntryValid():Boolean{
        if(viewModel.isUserValid(binding.txtName.text.toString(),binding.txtPhon.text.toString())){
            return true
        }
        return false
    }


    private fun clearData(){
        binding.apply {
            txtName.setText("")
            txtPhon.setText("")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}