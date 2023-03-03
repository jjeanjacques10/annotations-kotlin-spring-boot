package com.jjeanjacques.bookstore.controller

import com.jjeanjacques.bookstore.controller.dto.BookRequest
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@Service
class BookController {

    @PostMapping("/book")
    fun create(@Valid @RequestBody book: BookRequest): Map<String, Any?> {
        return mapOf(
            "status" to 200,
            "details" to "Book created - ".plus(book.title)
        )
    }
}
