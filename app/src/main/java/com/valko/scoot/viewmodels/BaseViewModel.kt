package com.valko.scoot.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.valko.scoot.helpers.Event

open class BaseViewModel(): ViewModel() {

    val event = MutableLiveData<Event>()
}