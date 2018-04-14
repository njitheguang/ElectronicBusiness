package com.njit.demo.service;

import java.util.List;

import com.njit.demo.entity.User;

public interface UserService {

	// 插入用户
	public void insertUser(User user);

	// 根据指定条件，检索用户
	public List<User> selectUser(User user);

	// 检索所有用户
	public List<User> selectUsers();

	// 根据用户名，判断用户名是否已经存在
	public boolean existUser(String username);
	
	//根据用户ID，检索用户
	public User selectUserById(String id);

	// 根据用户ID，删除单条数据
	public void deleteOne(User user);

	// 批量删除数据
	public void deleteBatch(List<String> list);

	// 修改用户密码
	public void updateUser(User user);
}
