package com.example.farshfactor.ui.notifications

import androidx.lifecycle.*
import com.example.farshfactor.database.*
import com.example.farshfactor.ui.home.HomeViewModel
import kotlinx.coroutines.launch

class NotificationsViewModel(private val settingDao: ItemsSettingDao) : ViewModel() {

    private fun insertSetting(settings: Settings){
        viewModelScope.launch {
            settingDao.saveSetting(settings)
        }
    }

    private fun getNewItemEntry(itemName:String,itemPrice:String,itemCount:String): Settings{
        return Settings(
            type = itemName,
            price = itemPrice,
            count_kind = itemCount
        )
    }

    fun addNewSetting(settings: Settings){
            insertSetting(settings)
    }

    val _needUpdate = MutableLiveData<Boolean>()

    val needUpdate: LiveData<Boolean>
        get() = _needUpdate

    fun updateNeedUpdate(newValue: Boolean){
        _needUpdate.value = newValue
    }

    val allSetting: LiveData<List<Settings>> = settingDao.getAllItems().asLiveData()

    fun updateSetting(settings: Settings){
        viewModelScope.launch {
            settingDao.updateSetting(settings)
        }
    }

    fun deleteSetting(settings: Settings){
        viewModelScope.launch {
            settingDao.deleteSetting(settings)
        }
    }

    fun retrieveSetting(id: Int): LiveData<Settings>{
        return settingDao.getSetting(id).asLiveData()
    }

    fun isEntryValid(settingName:String,settingPrice:String,settingType:String):Boolean{
        if(settingName.isBlank()||settingPrice.isBlank()||settingType.isBlank()){
            return false
        }
        return true
    }

}

class NotificationViewModelFactory(
    private val settingDao: ItemsSettingDao
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NotificationsViewModel::class.java)){
            @Suppress("UNCHECKED_STATEMENT")
            return NotificationsViewModel(settingDao) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}