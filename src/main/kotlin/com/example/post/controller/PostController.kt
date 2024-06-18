package com.example.post.controller

import com.example.post.dto.PostRequestDto
import com.example.post.dto.PostResponseDto
import com.example.post.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/posts")
class PostController(
    private val postService: PostService
) {
    /**
     * 게시글 전체 조회 Api
     */
    @GetMapping
    private fun getAllPosts() : List<PostResponseDto> {
        val result = postService.getAllPost()
        return result
    }

    /**
     * 게시글 조회 Api
     */
    @GetMapping("/{id}")
    private fun getPostsById(@PathVariable id : Long) : PostResponseDto {
        val result = postService.getPostById(id)
        return result
    }

    /**
     * 게시글 생성 Api
     */
    @PostMapping
    private fun createPost(@RequestBody postRequestDto: PostRequestDto)
    : ResponseEntity<PostResponseDto> {
        val result = postService.createPost(postRequestDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(result)
    }

    /**
     * 게시글 삭제 Api
     */
    @DeleteMapping("/{id}")
    private fun deletePost(@PathVariable id : Long) : ResponseEntity<Any> {
        postService.deletePost(id)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

}