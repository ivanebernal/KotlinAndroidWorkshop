package com.ivanebernal.summertalksapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by welcome1 on 7/29/17.
 */
class ContactsAdapter(val listener: ContactsListener, val contacts: List<Contact>): RecyclerView.Adapter<ContactsAdapter.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.holder_contact, parent, false)
        return ContactHolder(view)
    }

    override fun getItemCount(): Int = contacts.size

    override fun onBindViewHolder(holder: ContactHolder?, position: Int) { holder?.bindData(contacts[position]) }

    interface ContactsListener{
        fun onContactSelected(contact: Contact)
    }

    inner class ContactHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val contactPicture = itemView.findViewById<ImageView>(R.id.contact_picture)!!
        val contactName = itemView.findViewById<TextView>(R.id.contact_name)!!
        val contactPhone = itemView.findViewById<TextView>(R.id.contact_phone)!!

        fun bindData(contact: Contact){
            contactPicture.setImageResource(contact.picture)
            contactName.text = contact.name
            contactPhone.text = contact.phoneNumber
            itemView.setOnClickListener { listener.onContactSelected(contact) }
        }
    }
}