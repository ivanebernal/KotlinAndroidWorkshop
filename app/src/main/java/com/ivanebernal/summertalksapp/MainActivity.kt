package com.ivanebernal.summertalksapp

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity(), ContactsAdapter.ContactsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactList = findViewById<RecyclerView>(R.id.contact_list)
        val layoutManager = LinearLayoutManager(this)
        val adapter = ContactsAdapter(this, getContacts())
        contactList.layoutManager = layoutManager
        contactList.adapter = adapter
    }

    override fun onContactSelected(contact: Contact) {
        val phoneNumber = contact.phoneNumber
        val phoneIntent = Intent(Intent.ACTION_DIAL)
        phoneIntent.data = Uri.parse( "tel:$phoneNumber")
        startActivity(phoneIntent)
    }

    fun getContacts(): List<Contact>{
        val ivan = Contact("Ivan", "6622222222", R.drawable.dolores, "Narnia 123")
        val cassandra = Contact("Cassandra", "6621111111", R.drawable.dolores, "Hyrule 345")
        val fulanito = Contact("Cosme Fulanito", "6621212121", R.drawable.dolores, "Mision Juriquilla 242")
        val menganito = Contact("Mengano", "6622212121", R.drawable.dolores, "Macondo 100")
        return listOf(ivan, cassandra, fulanito, menganito)
    }
}
