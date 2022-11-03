package com.example.storeapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.storeapp.R

open class BaseActivity : AppCompatActivity() {
    public open fun replaceFragment(fragment: Fragment,bundle: Bundle? =null) {

    }
}