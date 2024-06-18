package com.example.post.service

import com.example.post.dto.PostRequestDto
import com.example.post.dto.PostResponseDto
import com.example.post.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository
) {
    /**
     * 게시글 전체 조회
     */
    fun getAllPost() : List<PostResponseDto> {
        val result = postRepository.findAll()
        return result.map { it.toResponse() }
    }

    /**
     * 특정 게시글 조회
     */
    fun getPostById(id : Long) : PostResponseDto {
        val result = postRepository.findByIdOrNull(id)
            ?: throw RuntimeException("존재하지 않는 게시글입니다.")

        return result.toResponse()
    }

    /**
     * 게시글 생성
     */
    fun createPost(postRequestDto: PostRequestDto) : PostResponseDto {
        val result = postRepository.save(postRequestDto.toEntity())
        return result.toResponse()
    }

    /**
     * 게시글 삭제
     */
    fun deletePost(id : Long) : Unit {
        postRepository.deleteById(id)
    }
}