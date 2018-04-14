package com.njit.demo.service;

import java.util.List;

import com.njit.demo.entity.User;

public interface UserService {

	// �����û�
	public void insertUser(User user);

	// ����ָ�������������û�
	public List<User> selectUser(User user);

	// ���������û�
	public List<User> selectUsers();

	// �����û������ж��û����Ƿ��Ѿ�����
	public boolean existUser(String username);
	
	//�����û�ID�������û�
	public User selectUserById(String id);

	// �����û�ID��ɾ����������
	public void deleteOne(User user);

	// ����ɾ������
	public void deleteBatch(List<String> list);

	// �޸��û�����
	public void updateUser(User user);
}
