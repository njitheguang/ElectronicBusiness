package com.njit.demo.mapper;

import java.util.List;

import com.njit.demo.entity.User;

public interface UserMapper {

	public List<User> selectUser(User user);

	public List<User> selectUsers();

	public void insertUser(User user);

	public List<User> selectUserByUserName(String username);
	
	public User selectUserById(String id);
	
	public void deleteOne(User user);

	public void deleteBatch(List<String> list);
	
	public void updateUser(User user);
}
