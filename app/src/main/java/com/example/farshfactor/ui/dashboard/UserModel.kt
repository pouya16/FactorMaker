package com.example.farshfactor.ui.dashboard

import androidx.lifecycle.Transformations
import com.example.farshfactor.database.User

data class UserModel(
     val id: Int,
     val name: String,
     val phone: String,
     val orders : Int,
     val is_checked: Boolean = false
)
