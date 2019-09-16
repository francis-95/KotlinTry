package com.gadgeon.pro4tech.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class HomeActivity : AppCompatActivity() {

    /*val vm: UserViewModel by lazy {
        ViewModelProviders.of(this, UserViewModelFactory(intent.getIntExtra(USER_ID, -1))).get(UserViewModel::class.java)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.i("Timber message example")
    }

    /*class UserViewModelFactory(val userId: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return UserViewModel(userId) as T
        }
    }*/


}
