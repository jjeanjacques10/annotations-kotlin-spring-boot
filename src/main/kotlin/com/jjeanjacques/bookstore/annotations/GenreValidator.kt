package com.jjeanjacques.bookstore.annotations

import com.jjeanjacques.bookstore.enums.GenreType
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class GenreValidator : ConstraintValidator<Genre, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) false
        return try {
            GenreType.valueOf(value!!)
            true
        } catch (e: IllegalArgumentException) {
            false
        }
    }
}
