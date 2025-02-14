package com.microsrv.users_service.service;


import com.microsrv.users_service.dto.UserDTO;

public interface IUserService {
    public UserDTO getUserAndPosts(Long user_id);
}
