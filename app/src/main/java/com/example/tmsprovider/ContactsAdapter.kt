package com.example.tmsprovider

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmsprovider.databinding.ItemContactBinding


// TODO("передать в параметры адаптера лист объектов Contact")
class ContactsAdapter() : RecyclerView.Adapter<ContactsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactsHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsHolder, position: Int) {
        TODO("в переменной holder вызвать метод bind и передать в параметры" +
                " элемент листа контактов с помощью position ")
    }

    override fun getItemCount(): Int {
        TODO("вернуть размер листа контактов")
    }
}


class ContactsHolder(private val binding: ItemContactBinding) :
    RecyclerView.ViewHolder(binding.root) {


// TODO("метод bind должен принимать в параметры объект Contact
//  внутри метода сетить данные из полученого объекта в ItemContactBinding ")
    fun bind() {

    }
}