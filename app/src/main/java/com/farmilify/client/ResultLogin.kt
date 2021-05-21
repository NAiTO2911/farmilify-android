package com.farmilify.client

data class ResultLogin(
    val message : String ? = null,
    val status : Int ? = null,
    val user : User ? = null
)

data class User(
    val id : String ? = null,
    val username : String ? = null,
    val nama : String ? = null,
    val email : String ? = null,
    val password : String ? = null,

)