package fr.isen.albergucci.androidcontactds

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterList(private val context: Context) : RecyclerView.Adapter<AdapterList.ViewHolder>() {

    private val contacts = arrayListOf(
        Contact(context.getString(R.string.contact_first_name),
            context.getString(R.string.contact_last_name),
            context.getString(R.string.contact_address),
            context.getString(R.string.contact_mail)),
        Contact(context.getString(R.string.contact_first_name_2),
            context.getString(R.string.contact_last_name_2),
            context.getString(R.string.contact_address_2),
            context.getString(R.string.contact_email_2))
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.liste_views, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mFirstNameView: TextView = itemView.findViewById(R.id.FirstName)
        private val mLastNameView: TextView = itemView.findViewById(R.id.LastName)
        private val mAddressView: TextView = itemView.findViewById(R.id.Address)
        private val mEmailView: TextView = itemView.findViewById(R.id.Mail)


        fun bind(contact: Contact) {
            mFirstNameView.text = contact.firstName
            mLastNameView.text = contact.lastName
            mAddressView.text = contact.address
            mEmailView.text = contact.email
        }
    }

    data class Contact(val firstName: String, val lastName: String, val address: String, val email: String)
}
