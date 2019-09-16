package com.gadgeon.pro4tech.kotlin

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.gadgeon.pro4tech.kotlin.contact.create.ViewModel
import com.gadgeon.pro4tech.kotlin.data.AppDatabase
import com.gadgeon.pro4tech.kotlin.data.ContactDao
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateViewModelTest {

    @get:Rule val testRule = InstantTaskExecutorRule()

    private lateinit var contactDao: ContactDao
    private lateinit var viewModel: ViewModel

    @Before
    fun before() {
        val application = ApplicationProvider.getApplicationContext<Context>()
        contactDao = AppDatabase.getInstance(application).contactDao()
        viewModel = ViewModel(contactDao)
    }

    @After
    fun after(){

    }

    @Test
    @Throws(Exception::class)
    fun isFormFieldsAreNotEmpty() {
        Assert.assertEquals("Success", 1 )
    }



}