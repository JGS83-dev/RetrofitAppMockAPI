package com.dsm.retrofitappmockapi.clases

import java.io.Serializable

class ejemplo: Serializable {
    var name :String = ""
    var avatar: String = ""
    var city: String =""
    var id : String = ""

    constructor(
        name:String,
        avatar: String,
        city: String,
        id:String
    ){
        this.name =  name
        this.avatar = avatar
        this.city = city
        this.id  =  id
    }

    constructor()

    override fun toString(): String {
        return "ejemplo => (name='$name', avatar='$avatar', city='$city')"
    }
}