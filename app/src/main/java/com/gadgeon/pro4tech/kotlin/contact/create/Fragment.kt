package com.gadgeon.pro4tech.kotlin.contact.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.gadgeon.pro4tech.kotlin.R
import com.gadgeon.pro4tech.kotlin.data.AppDatabase
import com.gadgeon.pro4tech.kotlin.databinding.FragmentContactCreateBinding

class Fragment : Fragment() {

    private lateinit var contactViewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application

        val contactDao = AppDatabase.getInstance(application).contactDao()

        val factory = ViewModelFactory(contactDao)

        contactViewModel = ViewModelProviders.of(this, factory)
            .get(ViewModel::class.java)

        val binding: FragmentContactCreateBinding = FragmentContactCreateBinding.inflate(
            inflater, container,false)

        binding.contactViewModel = contactViewModel

        binding.lifecycleOwner = this

        binding.save.setOnClickListener {
            contactViewModel.onSaveClicked()
        }

        contactViewModel.navigateToContactList.observe(viewLifecycleOwner, Observer {
            if (it) this.findNavController().
                navigate(R.id.action_contactCreateFragment_to_contactListFragment)
        })

        contactViewModel.emptyField.observe(viewLifecycleOwner, Observer {
            if (it) binding.name.error = "Empty"
        })

        return binding.root

    }

}
