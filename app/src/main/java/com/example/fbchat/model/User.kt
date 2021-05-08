package com.example.fbchat.model

data class User(
    val id: String = "",
    var username: String = "",
    var bio: String = "",
    var userfullname: String = "Name Lastname",
    var status: String = "",
    var phone: String = "",
    var photoUrl: String = ""
)