package fr.isen.mignottetheo.androidcontactds

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.example.Results


class ContactAdapter(var contacts: ArrayList<Results>, val onItemClickListener: (contactName: Results?) -> Unit): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(view: View):RecyclerView.ViewHolder(view){
        val cellName =  view.findViewById<TextView>(R.id.cellName)
        val cellAddress =  view.findViewById<TextView>(R.id.cellAddress)
        val cellMail =  view.findViewById<TextView>(R.id.cellMail)
        val cellImage = view.findViewById<ImageView>(R.id.cellImage)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_cell, parent, false)

        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.cellName.text = contact.name?.first + " " + contact.name?.last
        holder.cellAddress.text = contact.location?.street?.number.toString() + " " + contact.location?.street?.name.toString() + ", " + contact.location?.city.toString()
        holder.cellMail.text = contact?.email

        val foodPhoto = contact.picture?.medium
        Picasso.get().load(foodPhoto).into(holder.cellImage)

        holder.itemView.setOnClickListener{
            onItemClickListener(contact)
        }
    }
    override fun getItemCount(): Int = contacts.size

    fun refreshList(contactsFromAPI: ArrayList<Results>){
        contacts = contactsFromAPI
        notifyDataSetChanged()
    }
}