package com.microsrv.users_service.repository;


import com.microsrv.users_service.dto.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "posts-service")
public interface IPostAPI {
    @GetMapping("/posts/{user_id}")
    public List<PostDTO> getPostByUserId(@PathVariable("user_id") Long user_id);
}
