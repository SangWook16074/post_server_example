package com.example.post.entity

import com.example.post.dto.PostResponseDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id : Long?,

    @Column(nullable = false, length = 100)
    val title : String,

    @Column(nullable = false, length = 1000)
    val content : String,
) {
    fun toResponse() : PostResponseDto = PostResponseDto(
        id = id!!,
        title = title,
        content = content
    )
}