package com.gadgeon.pro4tech.kotlin.contact.create

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gadgeon.pro4tech.kotlin.data.Contact
import com.gadgeon.pro4tech.kotlin.data.ContactDao
import com.gadgeon.pro4tech.kotlin.repository.ContactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ViewModel(contactDao: ContactDao) : ViewModel() {

    val name = MutableLiveData<String>()
    val nickname = MutableLiveData<String>()
    val mobileNumber = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val address = MutableLiveData<String>()

    private val _emptyField = MutableLiveData<Boolean>()
    val emptyField: LiveData<Boolean>
        get() = _emptyField

    private val _navigateToContactList = MutableLiveData<Boolean>()
    val navigateToContactList: LiveData<Boolean>
        get() = _navigateToContactList

    fun onSaveClicked() {

        if (TextUtils.isEmpty(name.value)) _emptyField.value = true

        else {
            _emptyField.value = false

            val contact = Contact(0,
                name.value?:"",
                nickname.value?:"",
                mobileNumber.value?:"",
                email.value?:"",
                address.value?:"")

            insert(contact)
            _navigateToContactList.value = true
        }
    }

    private var job = Job()
    private val context: CoroutineContext = job + Dispatchers.Main
    private val scope = CoroutineScope(context)

    private val repository: ContactRepository = ContactRepository(contactDao)

    private fun insert(contact: Contact) = scope.launch(Dispatchers.IO) {
        repository.insert(contact)
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}