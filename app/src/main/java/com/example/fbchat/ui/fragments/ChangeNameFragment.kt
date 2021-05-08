package com.example.fbchat.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.example.fbchat.MainActivity
import com.example.fbchat.R
import com.example.fbchat.utils.*
import kotlinx.android.synthetic.main.fragment_change_name.*

class ChangeNameFragment : BaseFragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        val fullNameList = USER.userfullname.split(" ")
        change_name_field_name.setText(fullNameList[0])
        change_name_field_lastname.setText(fullNameList[1])
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_confirm_change_name -> changeName()
        }
        return true
    }

    private fun changeName() {
        val name = change_name_field_name.text.toString()
        val lastName = change_name_field_lastname.text.toString()

        if (name.isEmpty()) {
            showToast(getString(R.string.change_name_fragm_toast_empty_name))
        } else {
            val userfullname = "$name $lastName"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USERFULLNAME)
                .setValue(userfullname).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast(getString(R.string.toast_update_data))
                        USER.userfullname = userfullname
                        fragmentManager?.popBackStack()
                    }
                }
        }
    }
}
