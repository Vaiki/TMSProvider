package com.example.tmsprovider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmsprovider.databinding.ItemContactBinding


// TODO("передать в параметры адаптера лист объектов Contact")
class ContactsAdapter(private val contacts: MutableList<Contact>) : RecyclerView.Adapter<ContactsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactsHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsHolder, position: Int) {
//        TODO("в переменной holder вызвать метод bind и передать в параметры" +
//                " элемент листа контактов с помощью position ")
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int = contacts.size
    // TODO("вернуть размер листа контактов")
}

class ContactsHolder(private val binding: ItemContactBinding) :
    RecyclerView.ViewHolder(binding.root) {
    //    TODO("в переменной holder вызвать метод bind и передать в параметры" +
//    " элемент листа контактов с помощью position ")
    fun bind(contact: Contact) {
        with(binding){
            tvName.text = contact.name
            tvNumber.text = contact.number.toString()
            Glide.with(itemView.context)
                .load(contact.image)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(ivAvatar)
        }
    }
}