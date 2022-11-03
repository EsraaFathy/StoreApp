package com.example.storeapp.base

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity : AppCompatActivity() {
    var currentFragment : BaseFragment? = null
    var currentActivity : Activity? =null

    open fun replaceFragment(fragment: Fragment,bundle: Bundle? =null) {

    }
}