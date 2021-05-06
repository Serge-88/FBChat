package com.example.fbchat.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fbchat.R
import com.example.fbchat.databinding.ActivityRegisterBinding
import com.example.fbchat.ui.fragments.EnterPhoneNumberFragment
import com.example.fbchat.utils.initFirebase
import com.example.fbchat.utils.replaceFragment

class RegisterActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolBar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneNumberFragment(), false)
    }
}
