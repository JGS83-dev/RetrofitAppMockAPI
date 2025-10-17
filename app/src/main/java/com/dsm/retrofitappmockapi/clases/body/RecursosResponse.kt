package com.dsm.retrofitappmockapi.clases.body

class RecursosResponse {
    var createdAt: String = ""
    var titulo: String = ""
    var descripcion: String = ""
    var tipo: String = ""
    var enlace: String = ""
    var imagen: String = ""
    var id: String = ""

    constructor(
        createdAt: String,
        titulo: String,
        descripcion: String,
        tipo: String,
        enlace: String,
        imagen: String,
        id: String
    ) {
        this.createdAt = createdAt
        this.titulo = titulo
        this.descripcion = descripcion
        this.tipo = tipo
        this.enlace = enlace
        this.imagen = imagen
        this.id = id
    }

    constructor()

    override fun toString(): String {
        return "RecursosResponse(createdAt='$createdAt', titulo='$titulo', descripcion='$descripcion', tipo='$tipo', enlace='$enlace', imagen='$imagen', id='$id')"
    }
}