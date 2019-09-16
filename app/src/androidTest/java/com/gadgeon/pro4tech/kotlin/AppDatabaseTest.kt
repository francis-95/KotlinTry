package com.gadgeon.pro4tech.kotlin

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.gadgeon.pro4tech.kotlin.data.AppDatabase
import com.gadgeon.pro4tech.kotlin.data.Contact
import com.gadgeon.pro4tech.kotlin.data.ContactDao
import com.gadgeon.pro4tech.kotlin.utilities.OneTimeObserver
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {
    private lateinit var contactDao: ContactDao
    private lateinit var db: AppDatabase

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        contactDao = db.contactDao()

    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeContactAndReadInList() {
        val contact = Contact(0,"Francis", "Frank", "9895",
            "frank@gmail.com", "hello there")

        contactDao.getContacts().observeOnce {
            assertEquals("Success",0, it.size)
            Log.i("message", it.size.toString())
        }

        contactDao.insert(contact)

        contactDao.getContacts().observeOnce {
            Log.i("message", it.size.toString())
            assertEquals("Success", 1, it.size) }

    }

    private fun <T> LiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
        val observer = OneTimeObserver(handler = onChangeHandler)
        observe(observer, observer)
    }
}