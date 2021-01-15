package com.valko.scoot.extensions

import androidx.fragment.app.Fragment
import com.valko.scoot.R

fun Fragment.startFragment(fragment: Fragment,
                           containerID: Int,
                           setAnimation: Boolean = false,
                           addToBackStack: Boolean = true,
                           backStackTag: String? = null,
                           reverseAnimation: Boolean = false) {

    val transaction = fragmentManager!!.beginTransaction()
    if (setAnimation)
        if (reverseAnimation) {
            transaction.setCustomAnimations(R.anim.left_in, R.anim.right_out, R.anim.right_out, R.anim.left_out)
        } else transaction.setCustomAnimations(R.anim.right_in, R.anim.left_out, R.anim.left_in, R.anim.right_out)
    transaction.replace(containerID, fragment)
    if (addToBackStack) transaction.addToBackStack(backStackTag)
    transaction.commit()
}