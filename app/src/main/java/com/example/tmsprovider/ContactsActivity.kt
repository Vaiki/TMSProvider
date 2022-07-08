package com.example.tmsprovider

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmsprovider.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contact_list.layoutManager = LinearLayoutManager(this)

        btn_read_contacts.setOnClickListener {
            val contactList: MutableList<Contact> = ArrayList()
            val contacts = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                null,
                null,
                null
            )
            while (contacts.moveToNext()) {
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
            contact_list.adapter = ContactsAdapter(contactList, this)
            contacts.close()
        }
    }
}