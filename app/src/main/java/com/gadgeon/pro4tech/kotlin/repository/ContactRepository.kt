package com.gadgeon.pro4tech.kotlin.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.gadgeon.pro4tech.kotlin.data.Contact
import com.gadgeon.pro4tech.kotlin.data.ContactDao

class ContactRepository(private val contactDao: ContactDao) {
    val allContacts: LiveData<List<Contact>> = contactDao.getContacts()

    @WorkerThread
    fun insert(contact: Contact) {
        contactDao.insert(contact)
    }
}