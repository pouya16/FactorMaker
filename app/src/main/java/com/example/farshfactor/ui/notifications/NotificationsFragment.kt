package com.example.farshfactor.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.farshfactor.MyApp
import com.example.farshfactor.R
import com.example.farshfactor.database.Settings
import com.example.farshfactor.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    var needUpdate:Boolean = false


    private val viewModel: NotificationsViewModel by viewModels {
        NotificationViewModelFactory((activity?.application as MyApp).database.itemSettingsDao())
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var settings: Settings

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!needUpdate){
            addNewItem()
        }

        val adapter = SettingListAdapter{
            settings = it
            viewModel.updateNeedUpdate(true)
            binding.apply {
                txtName.setText(settings.type)
                txtPrice.setText(settings.price)
                txtCountType.setText(settings.count_kind)
            }
        }
        binding.btnAdd.setOnClickListener { addNewItem()}
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = adapter

        binding.btnCancel.setOnClickListener{ viewModel.updateNeedUpdate(false)
        clearData()}
        binding.btnDelete.setOnClickListener{
            viewModel.deleteSetting(settings)
            viewModel.updateNeedUpdate(false)
            clearData()
        }
        binding.btnUpdate.setOnClickListener{
            viewModel.updateSetting(settings)
            viewModel.updateNeedUpdate(false)
            clearData()
        }


        viewModel.needUpdate.observe(this.viewLifecycleOwner){
            needUpdate = it
            if(it){
                binding.layoutUpdate.visibility = View.VISIBLE
                binding.btnAdd.visibility = View.GONE
            }else{
                 binding.layoutUpdate.visibility = View.GONE
                binding.btnAdd.visibility = View.VISIBLE
            }
        }

        viewModel.allSetting.observe(this.viewLifecycleOwner){settings ->
            settings.let {
                adapter.submitList(it)
            }

        }
    }

    private fun clearData(){
        binding.apply {
            txtName.setText("")
            txtPrice.setText("")
            txtCountType.setText("")
        }
    }


    private fun addNewItem(){
        if(isEntryValid()){
            val setting = Settings(type = binding.txtName.text.toString(),
            count_kind = binding.txtCountType.text.toString(),
            price = binding.txtPrice.text.toString())
            viewModel.addNewSetting(setting)
            clearData()
        }else{
            Toast.makeText(context,context?.getString(R.string.toast_error_data),Toast.LENGTH_SHORT).show()
        }
    }


    private fun isEntryValid():Boolean{
        if(viewModel.isEntryValid(binding.txtName.text.toString(),
            binding.txtPrice.text.toString(),
            binding.txtCountType.text.toString())){
            return true
        }
        return false
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}