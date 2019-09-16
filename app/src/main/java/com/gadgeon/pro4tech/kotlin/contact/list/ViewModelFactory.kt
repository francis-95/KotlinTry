package com.gadgeon.pro4tech.kotlin.contact.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gadgeon.pro4tech.kotlin.data.ContactDao

class ViewModelFactory(
    private val contactDao: ContactDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModel(contactDao) as T
    }
}