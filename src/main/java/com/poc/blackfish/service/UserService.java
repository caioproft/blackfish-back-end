package com.poc.blackfish.service;

import com.poc.blackfish.domain.dto.UserDTO;
import com.poc.blackfish.domain.model.User;
import com.poc.blackfish.exceptions.DuplicateResourceException;
import com.poc.blackfish.exceptions.ResourceNotFound;
import com.poc.blackfish.mapper.UserMapper;
import com.poc.blackfish.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper userMapper;


    public List<UserDTO> findAll() {
        List<User> userList = repository.findAll();
        if(userList.isEmpty()){
            throw new ResourceNotFound("Sem usuários cadastrados");
        }
        List<UserDTO> userDTOList = new ArrayList<>();

        for(User user : userList){
            userDTOList.add(userMapper.userToUserDto(user));
        }

        return userDTOList;
    }

    public void createUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUser(userDTO);
        if(repository.existsByCpf(user.getCpf())){
            throw new DuplicateResourceException("Usuário já cadastrado");
        }
        repository.save(user);
    }
}
