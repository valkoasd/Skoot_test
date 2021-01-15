package com.valko.scoot.viewmodels

import android.app.Application
import android.os.Bundle
import com.valko.scoot.constants.REG_NUM_KEY
import com.valko.scoot.helpers.BaseEventType
import com.valko.scoot.helpers.Event

class Step1ViewModel: BaseViewModel() {

    enum class Step1Events: BaseEventType{
        START_NEXT_FRAGMENT
    }

//    --------------------------------------------------------------------
    fun init(){

    }

    fun onNextClick(regNumber: String){
        if(regNumber.isNotBlank()){
            val args = Bundle()
            args.putString(REG_NUM_KEY, regNumber)
            event.value = Event(Step1Events.START_NEXT_FRAGMENT, args)
        }
    }

}