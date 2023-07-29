package com.example.farshfactor.ui.dashboard

import androidx.lifecycle.*
import com.example.farshfactor.database.ItemsSettingDao
import com.example.farshfactor.database.User
import com.example.farshfactor.database.UserDao
import com.example.farshfactor.ui.notifications.NotificationsViewModel
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch

class DashboardViewModel(private val userDao: UserDao) : ViewModel() {

    val allUser:LiveData<List<User>> = userDao.getUsers().asLiveData()
    val _needUpdate = MutableLiveData(false)
    val needUpdate: LiveData<Boolean>
        get() = _needUpdate
    fun updateNeedUpdate(newVal : Boolean){
        _needUpdate.value = newVal
    }


    fun insertUser(user:User){
        viewModelScope.launch {
            userDao.insertUser(user)
        }
    }

    fun deleteUser(user:User){
        viewModelScope.launch {
            userDao.deleteUser(user)
            updateNeedUpdate(false)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch {
            userDao.updateUser(user)
            updateNeedUpdate(false)
        }
    }

    fun isUserValid(name:String,mobile:String):Boolean{
        if(name.isBlank()||mobile.length!=11){
            return false
        }
        return true
    }


}

class DashBoardViewModelFactory(
    private val userDao: UserDao
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DashboardViewModel::class.java)){
            @Suppress("UNCHECKED_STATEMENT")
            return DashboardViewModel(userDao) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}