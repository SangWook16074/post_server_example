package com.example.post.dto

import com.example.post.entity.Post

data class PostRequestDto(
    val title : String,
    val content : String,
) {

    fun toEntity() : Post = Post(
        id = null,
        title = title,
        content = content,
    )
}

data class PostResponseDto(
    val id : Long,
    val title : String,
    val content : String,
)