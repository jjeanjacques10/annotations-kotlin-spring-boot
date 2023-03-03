package com.jjeanjacques.bookstore.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class BookExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<ErrorMessageResponse?> {
        val details = ex.bindingResult.fieldErrors
            .map { error -> error.defaultMessage ?: "" }
            .toList()

        return ResponseEntity(
            ErrorMessageResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), details), HttpStatus.UNPROCESSABLE_ENTITY
        )
    }

    class ErrorMessageResponse(
        val code: Int,
        val details: List<String>
    )


}