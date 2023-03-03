package com.jjeanjacques.bookstore.controller.dto

import com.jjeanjacques.bookstore.annotations.Genre
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class BookRequest(

    @field:NotEmpty(message = "Título não deve estar vazio")
    val title: String? = "",

    @field:NotBlank(message = "Descrição não deve estar vazia")
    val description: String? = "",

    @field:Genre
    val genre: String,

    val number: Number
)

