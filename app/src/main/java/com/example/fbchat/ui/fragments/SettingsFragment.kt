package com.example.fbchat.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.fbchat.MainActivity
import com.example.fbchat.R
import com.example.fbchat.activities.RegisterActivity
import com.example.fbchat.utils.AUTH
import com.example.fbchat.utils.USER
import com.example.fbchat.utils.replaceActivity
import com.example.fbchat.utils.replaceFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        settings_bio.text = USER.bio
        settings_phone_number.text = USER.phone
        setting_user_full_name.text = USER.userfullname
        settings_user_status.text = USER.status
        settings_username.text = USER.username
        btn_set_username.setOnClickListener() {
            replaceFragment(ChangeUsernameFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}