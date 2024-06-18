package com.example.post.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class PostExceptionHandler {
    @ExceptionHandler(Exception::class)
    protected fun exceptionHandler(exception: Exception)
    : ResponseEntity<Map<String, String>> {
        val errors = mapOf("error" to (exception.message ?: "에러가 발생했습니다!"))
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors)
    }
}