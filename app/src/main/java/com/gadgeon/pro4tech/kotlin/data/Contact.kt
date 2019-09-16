package com.gadgeon.pro4tech.kotlin.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")
    var contactId: Long = 0,
    var name: String,
    var nickname: String,
    var mobileNumber: String,
    var email: String,
    var address: String
) {
    override fun toString() = name
}
