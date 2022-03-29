package com.nnk.springboot.util;

import com.nnk.springboot.DTOs.UserDTO;
import com.nnk.springboot.domain.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-29T12:56:01+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public void updateUserWithUserDto(UserDTO userDto, User user) {
        if ( userDto == null ) {
            return;
        }

        if ( userDto.getUsername() != null ) {
            user.setUsername( userDto.getUsername() );
        }
        if ( userDto.getPassword() != null ) {
            user.setPassword( userDto.getPassword() );
        }
        if ( userDto.getFullname() != null ) {
            user.setFullname( userDto.getFullname() );
        }
        if ( userDto.getRole() != null ) {
            user.setRole( userDto.getRole() );
        }
    }

    @Override
    public User mapToUser(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setRole( userDto.getRole() );
        user.setFullname( userDto.getFullname() );

        return user;
    }
}
