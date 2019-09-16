package com.gadgeon.pro4tech.kotlin.contact.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gadgeon.pro4tech.kotlin.data.Contact
import com.gadgeon.pro4tech.kotlin.data.ContactDao
import com.gadgeon.pro4tech.kotlin.repository.ContactRepository

class ViewModel(contactDao: ContactDao) : ViewModel() {

    private val _navigateToContactDetail = MutableLiveData<Long>()
    val navigateToContactDetail
        get() = _navigateToContactDetail

    fun onContactClicked(id: Long) {
        _navigateToContactDetail.value = id
    }

    val allContacts: LiveData<List<Contact>> = ContactRepository(contactDao).allContacts

}