package com.example.storeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.storeapp.R
import com.example.storeapp.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        currentActivity = this
    }
     override fun replaceFragment(fragment: Fragment,bundle: Bundle?,addToBackStack :Boolean) {
         if (bundle!=null)
         fragment.arguments = bundle

         val transaction = supportFragmentManager.beginTransaction()
         transaction.replace(R.id.fragment, fragment)
         if (addToBackStack)
         transaction.addToBackStack(fragment.javaClass.name)

         transaction.commit()
    }

}