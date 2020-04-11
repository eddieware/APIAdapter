package com.example.apiadapter

class Results(id:Int,name:String,description:String,image_url:String,ebc:Int) {
    var id                  : Int = 0
    var name                : String = ""
    var description         : String = ""
    var image_url          : String = ""
    var ebc                 : Int = 0


    init {
        this.id                 = id
        this.name               = name
        this.description        = description
        this.image_url          = image_url
        this.ebc                = ebc

    }
}