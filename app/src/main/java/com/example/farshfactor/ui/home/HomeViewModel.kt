package com.example.farshfactor.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.farshfactor.database.FactorDao
import com.example.farshfactor.database.FactorDetailDao
import com.example.farshfactor.database.UserDao
import com.example.farshfactor.ui.notifications.NotificationsViewModel


class HomeViewModel(
    userDao: UserDao,
    factorDao: FactorDao,
    factorDetailDao: FactorDetailDao
): ViewModel() {

    fun viewModelCreated(){
        Log.i("Log1","view model is created")
    }



    /*private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text*/
}

class HomeViewModelFactory(
    private val userDao: UserDao,
    private val factorDao: FactorDao,
    private val factorDetailDao: FactorDetailDao
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            @Suppress("UNCHECKED_STATEMENT")
            return HomeViewModel(userDao,factorDao,factorDetailDao) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}