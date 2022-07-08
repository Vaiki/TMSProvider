package com.example.tmsprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmsprovider.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding
    val contactList: MutableList<Contact> = ArrayList<Contact>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}