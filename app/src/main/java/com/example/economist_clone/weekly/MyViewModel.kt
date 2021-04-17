package com.example.economist_clone.weekly

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MyViewModel :ViewModel(){
    val repository=MyRepository()

    fun getData(): LiveData<List<ResponseModel>> {
        return liveData (Dispatchers.IO) {
            val result = repository.getData()
            emit(result.data!!)
        }
    }


}