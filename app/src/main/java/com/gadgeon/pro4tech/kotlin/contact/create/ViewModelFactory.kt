package com.gadgeon.pro4tech.kotlin.contact.create

import androidx.lifecycle.ViewModelProvider
import com.gadgeon.pro4tech.kotlin.data.Contact
import com.gadgeon.pro4tech.kotlin.data.ContactDao
import com.gadgeon.pro4tech.kotlin.repository.ContactRepository

/**
 * Factory for creating a [ViewModel] with a constructor that takes a [ContactRepository]
 * and an ID for the current [Contact].
 */
class ViewModelFactory(
    private val contactDao: ContactDao
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return ViewModel(contactDao) as T
    }
}