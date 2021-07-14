package com.kelly.userapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kelly.userapp.api.RetroFitProvider
import com.kelly.userapp.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val usersLiveData = MutableLiveData<List<User>>()

    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            usersLiveData.postValue(RetroFitProvider.placeHolderAPI.getUsers())
        }
    }
}