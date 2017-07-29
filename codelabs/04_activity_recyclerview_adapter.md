# Activity, RecyclerView, and Adapter
Commit number: f06424f

We know a little bit of Kotlin now, it's time for some code! We'll now bind our views with our code and make
it display the content we want.

## Activity

Our activity looks by default like this:

```java
package com.ivanebernal.summertalksapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

```

Let's analyze the code. 

As you can see, we are overriding a function named `onCreate`, it is executed at the very start of the 
[activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle.html). Here we need to set
up our views.

Before going further on the activity, let's create a new Kotlin class named Contact.kt:

```kotlin
data class Contact(
        val name: String, 
        val phoneNumber: String, 
        val picture: Int,
        val address: String) {
}
```

Data classes are a special type of classes that allow us to manipulate info more easily. Data classes would be something like 
[POJOs in Java](https://en.wikipedia.org/wiki/Plain_old_Java_object).

For now, let's modify our MainActivity a little:

```kotlin
package com.ivanebernal.summertalksapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val contactList = findViewById<RecyclerView>(R.id.contact_list)
        val layoutManager = LinearLayoutManager(this)
        val adapter = ContactsAdapter(this, getContacts())
        contactList.layoutManager = layoutManager
        contactList.adapter = adapter
    }
    
    fun getContacts(): List<Contact>{
        val ivan = Contact("Ivan", "6622222222", R.drawable.ic_launcher_background, "Narnia 123")
        val cassandra = Contact("Cassandra", "6621111111", R.drawable.ic_launcher_background, "Hyrule 345")
        val fulanito = Contact("Cosme Fulanito", "6621212121", R.drawable.ic_launcher_background, "Mision Juriquilla 242")
        val menganito = Contact("Mengano", "6622212121", R.drawable.ic_launcher_background, "Macondo 100")
        return listOf(ivan, cassandra, fulanito, menganito)
    }
}
```

As you can see, we are adding a function that returns a list of contacts, binding our RecyclerView with `findViewById<ViewType>(id)`
and creating an instance of a class we don't have yet. We are also adding a LayoutManager to our RecyclerView... What's that? Well,
a RecyclerView can arrange items in linear form, in a grid, or in other forms, a LinearLayoutManager simply tells the RecyclerView
that we want to arrange things linearly.

Let's create that ContactsAdapter we haven't created.

## RecyclerView Adapter

We told the RecyclerView how it must align its items. Now we have to tell it which items to align and how to arrange the information.

We are going to create a class called ContactsAdapter:

```kotlin
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
```

That's a lot to process! What did we just do?? I'll break down the code:

### ContactHolder

We created an inner class that represents the item that will be holding our information. As you can see we are
making reference to the items we declared in `holder_contact`. We are also defining a function named `bindData` that simply
empties the information in Contact to the views. Finally we define what the holder will do when we click on it.

### ContactsListener

This interface will let our activity define what to do when a contact is selected. 

### Overriden methods

* `onCreateViewHolder`: in this method we need to return an instance of our ContactsHolder, we use a LayoutInflater to 
create the holder_contact Layout.
* `getItemCount`: in this method we need to tell the adapter how many items will be displayed.
* `onBindViewHolder`: here is where we need to tell the adapter which contact of the list to display in the holder.

We only need to implement `ContactsListener` on `MainActivity`, we will need to override `onContactSelected`:

```kotlin
    override fun onContactSelected(contact: Contact) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
```

Wait... TODO?? What do we have to do??

Let's continue to the next codelab to find out!
