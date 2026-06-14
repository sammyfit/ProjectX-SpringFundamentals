package com.codingshuttle.prod_ready_features.services;

import com.codingshuttle.prod_ready_features.dto.PostDto;
import com.codingshuttle.prod_ready_features.entities.PostEntity;
import com.codingshuttle.prod_ready_features.exceptions.ResourceNotFoundException;
import com.codingshuttle.prod_ready_features.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDto.class))
                .toList();
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("post not found with id" + postId)
                );
        return modelMapper.map(postEntity, PostDto.class);
    }
}
