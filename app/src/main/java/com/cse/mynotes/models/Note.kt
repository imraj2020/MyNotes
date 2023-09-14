package com.cse.mynotes.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var title: String,
    var body: String,
    var time: String
) : Parcelable