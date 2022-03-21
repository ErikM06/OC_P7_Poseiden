package com.nnk.springboot.util;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.nnk.springboot.DTOs.UserDTO;
import com.nnk.springboot.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	@BeanMapping (nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public void updateUserWithUserDto (UserDTO userDto, @MappingTarget User user);
	
	@Mappings({
	@Mapping(target = "username", source = "userDto.username"),
	@Mapping(target = "password", source ="userDto.password"),
	@Mapping(target ="role", source ="userDto.role")
	})
	User mapToUser (UserDTO userDto);

}
