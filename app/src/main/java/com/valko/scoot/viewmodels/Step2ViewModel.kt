package com.valko.scoot.viewmodels

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.valko.scoot.constants.REG_NUM_KEY
import com.valko.scoot.datamodels.Car
import com.valko.scoot.helpers.BaseEventType
import com.valko.scoot.helpers.Event

class Step2ViewModel : BaseViewModel() {

    enum class Step2Events: BaseEventType{
        RETURN_TO_PREV_FRAGMENT,
        REFRESH_CAR,
        START_NEXT_FRAGMENT
    }

    val car = MutableLiveData<Car>()


    //------------------------------------------------------------------------
    fun init(args: Bundle?) {

        args?.let {
            setDummyData(args.getString(REG_NUM_KEY, ""))
        }
    }
//    ----------------------------------------------------------------------------

    private fun setDummyData(regNumber: String) {
        car.value = Car(
            regNumber,
            "https://www.jimbars.co.uk/wp-content/uploads/2020/01/vw-logo-1.png",
            "VOLKSWAGEN - TIGUAN",
            "23-07-2017",
            "SILVER",
            true,
            "20-02-2021",
            true,
            "05-05-2022"
        )
    }

    fun onBackPressed(){
        event.value = Event(Step2Events.RETURN_TO_PREV_FRAGMENT)
    }

    fun onRefreshClick(){
        event.value = Event(Step2Events.REFRESH_CAR)
    }

    fun onNextClick(){
        event.value = Event(Step2Events.START_NEXT_FRAGMENT)
    }
}