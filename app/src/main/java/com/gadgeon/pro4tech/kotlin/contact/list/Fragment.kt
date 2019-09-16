package com.gadgeon.pro4tech.kotlin.contact.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.gadgeon.pro4tech.kotlin.R
import com.gadgeon.pro4tech.kotlin.data.AppDatabase
import com.gadgeon.pro4tech.kotlin.databinding.FragmentContactListBinding

class Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentContactListBinding = FragmentContactListBinding.inflate(
            inflater, container,false)

        val application = requireNotNull(this.activity).application

        val contactDao = AppDatabase.getInstance(application).contactDao()

        val contactViewModelFactory = ViewModelFactory(contactDao)

        val contactViewModel = ViewModelProviders.of(
            this, contactViewModelFactory).get(ViewModel::class.java)

        binding.lifecycleOwner = this

        contactViewModel.navigateToContactDetail.observe(this, Observer { contact ->
            contact?.let {

                this.findNavController().navigate(
                    R.id.action_contactListFragment_to_contactDetailFragment)

            }
        })

        val adapter = ContactAdapter(ContactListener { contactId ->
            contactViewModel.onContactClicked(contactId)
        })

        binding.contactList.adapter = adapter

        contactViewModel.allContacts.observe(viewLifecycleOwner, Observer { contacts ->
            binding.hasContacts = !contacts.isNullOrEmpty()

            if (!contacts.isNullOrEmpty()) {
                adapter.addHeaderAndSubmitList(contacts)
            }
        })

        return binding.root
    }

}
