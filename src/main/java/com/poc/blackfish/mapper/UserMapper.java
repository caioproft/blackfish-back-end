package com.poc.blackfish.mapper;

import com.poc.blackfish.domain.dto.UserDTO;
import com.poc.blackfish.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping( target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    User userDtoToUser(UserDTO userDTO);

    @Mapping( target = "dateOfBirth", dateFormat = "dd/MM/yyyy")
    UserDTO userToUserDto(User user);
}
