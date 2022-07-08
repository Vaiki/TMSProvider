package com.example.tmsprovider

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmsprovider.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)

        binding.btnReadContacts.setOnClickListener {
            val contactList: MutableList<Contact> = ArrayList()
            val contacts = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null
            )
            while (contacts!!.moveToNext()) {
                val name =
                    contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number =
                    contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                val obj = Contact()
                obj.name = name
                obj.number = number
                val photo_uri =
                    contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))
                if (photo_uri != null) {
                    obj.image =
                        MediaStore.Images.Media.getBitmap(contentResolver, Uri.parse(photo_uri))
                }
                contactList.add(obj)
            }
            binding.rvContacts.adapter = ContactsAdapter(contactList)
            contacts.close()
        }
    }
}