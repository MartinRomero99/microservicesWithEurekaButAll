package com.microsrv.users_service.service;


import com.microsrv.users_service.dto.PostDTO;
import com.microsrv.users_service.dto.UserDTO;
import com.microsrv.users_service.model.User;
import com.microsrv.users_service.repository.IPostAPI;
import com.microsrv.users_service.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepo;

    @Autowired
    private IPostAPI apiPost;

    @Override
    public UserDTO getUserAndPosts(Long user_id) {
        User user= userRepo.findById(user_id).orElse(null);

        List<PostDTO> postList = apiPost.getPostByUserId(user_id);

        UserDTO userDTO = new UserDTO(user.getUser_id(), user.getName(),
        user.getSurname(), user.getCellphone(), postList);
        return userDTO;
    }
}
