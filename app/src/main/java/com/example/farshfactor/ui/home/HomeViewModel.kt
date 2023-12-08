package com.example.farshfactor.ui.home

import androidx.lifecycle.*
import com.example.farshfactor.database.*
import com.example.farshfactor.ui.notifications.NotificationsViewModel


class HomeViewModel(
    itemsSettingDao: ItemsSettingDao,
    userDao: UserDao,
    factorDao: FactorDao,
    factorDetailDao: FactorDetailDao
): ViewModel() {


    val allSetting: LiveData<List<Settings>> = itemsSettingDao.getAllItems().asLiveData()
    val allUsers : LiveData<List<User>> = userDao.getUsers().asLiveData()


    /*private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text*/
}

class HomeViewModelFactory(
    private val itemsSettingDao: ItemsSettingDao,
    private val userDao: UserDao,
    private val factorDao: FactorDao,
    private val factorDetailDao: FactorDetailDao
):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            @Suppress("UNCHECKED_STATEMENT")
            return HomeViewModel(itemsSettingDao,userDao,factorDao,factorDetailDao) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}