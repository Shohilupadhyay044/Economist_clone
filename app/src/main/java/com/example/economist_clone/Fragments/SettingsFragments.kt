package com.example.economist_clone.Fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.economist_clone.R

import java.util.*

import com.example.economist_clone.firebase.LoginActivity
import com.example.economist_clone.firebase.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragments : Fragment(R.layout.fragment_settings){
    var auth: FirebaseAuth? = null

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth=FirebaseAuth.getInstance()
        val user = auth!!.currentUser
        if(user!=null){
            btnLogin.text = "Log out"
           btnLogin.setOnClickListener {
               val builder= AlertDialog.Builder(requireContext())
               builder.setTitle("Wait a sec...")
               builder.setMessage("Siging out from the device?\n\nYour data on this device will be deleted, " +
                       "but you can always get them back once you sign in again.")
               builder.setPositiveButton("SIGN OUT"){ dialog: DialogInterface?, which: Int ->
                   auth!!.signOut()
                   val intent = Intent(activity, LoginActivity::class.java)
                   startActivity(intent)
                   requireActivity().finish()
               }
               builder.setNegativeButton("CANCEL"){dialogInterface, which ->

               }
               // Create the AlertDialog
               val alertDialog: AlertDialog = builder.create()
               // Set other dialog properties
               alertDialog.setCancelable(true)
               alertDialog.show()
           }
        }
       else {
            btnLogin.setOnClickListener {
                val intent = Intent(activity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}