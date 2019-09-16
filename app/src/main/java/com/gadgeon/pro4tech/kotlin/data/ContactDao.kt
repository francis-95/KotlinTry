package com.gadgeon.pro4tech.kotlin.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * The Data Access Object for the Contact class.
 */
@Dao
interface ContactDao {
    @Query("SELECT * FROM contacts ORDER BY id DESC")
    fun getContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts WHERE id = :contactId")
    fun getContact(contactId: Long): LiveData<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(contacts: List<Contact>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)
}
