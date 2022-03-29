package com.nnk.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nnk.springboot.DTOs.UserDTO;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.services.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
	
	Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Mock
	private User user;
	
	@Mock
	private UserDTO userDto;
	
	@BeforeEach
	private void setUp () {
		user = new User("userTest", "passwordTest","FullnameTest", "RoleTest");
		userRepository.save(user);
		userDto = new UserDTO("UserDtoTest", "PasswordDtoTest", "FullNameDtoTest", "RoleDTOTest");
	}
	@AfterEach
	private void tearDown (){
		user = null;
		userDto = null;
		userRepository.deleteAll();
	}
	
	@Test
	public void saveUserTest() {
		User userToSave = userService.saveUser(userDto);
		assertNotNull(userToSave);
	
	}

	@Test
	public void findAllUserTest() {
		
		List<User> userLs = userService.findAllUsers();
		assertNotNull(userLs);
		assertThat(userLs.contains(user));
	}

	@Test
	@Transactional
	public void updateUserTest() {
		userService.updateUser(user.getId(), userDto);
		User retriveModifiedUser = userRepository.getById(user.getId());
		assertThat(retriveModifiedUser.getFullname().equals(userDto.getFullname()));
	}

	@Test
	public void deleteRatingTest() throws Exception{
		userService.deleteUser(user.getId());
		assertFalse(userRepository.existsById(user.getId()));

	}

}
