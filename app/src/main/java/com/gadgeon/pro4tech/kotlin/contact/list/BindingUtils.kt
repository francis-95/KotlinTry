package com.gadgeon.pro4tech.kotlin.contact.list

import android.text.TextUtils
import android.widget.EditText
import androidx.databinding.BindingAdapter


@BindingAdapter("isNameEmpty")
fun EditText.isNameEmpty(item: String?) {

    item?.let {
        if (TextUtils.isEmpty(item)) this.error = "Empty"
    }

}