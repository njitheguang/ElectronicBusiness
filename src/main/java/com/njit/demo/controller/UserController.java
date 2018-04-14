package com.njit.demo.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hamcrest.core.IsInstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.njit.demo.entity.User;
import com.njit.demo.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	// ��¼
	@RequestMapping("/login.do")
	public ModelAndView login(String username, String password, HttpServletRequest request) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		List<User> userList = userService.selectUser(user);
		request.setAttribute("message", "��¼");
		if (userList.size() > 0) {
			request.setAttribute("userList", userList);
			return new ModelAndView("success");
		} else
			return new ModelAndView("fail");
	}

	// ע��
	@RequestMapping("/register.do")
	public ModelAndView regist(String username, String password, HttpServletRequest request) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean flag = true;
		flag = userService.existUser(username);
		request.setAttribute("message", "ע��");
		if (!flag) {
			userService.insertUser(user);
			return new ModelAndView("success");
		} else {
			return new ModelAndView("fail");
		}
	}

	// ��ʾ�û��б�
	@RequestMapping("/viewList.do")
	public ModelAndView viewList(HttpServletRequest request) {
		List<User> list = userService.selectUsers();
		request.setAttribute("messageList", list);
		request.setAttribute("message", "ע��");
		return new ModelAndView("viewList");
	}

	// ����ID��ɾ����������
	@RequestMapping("/deleteOne.do/{id}")
	public String deleteOne(@PathVariable long id, HttpServletRequest request) {
		User u = new User();
		u.setId(String.valueOf(id));
		userService.deleteOne(u);
		return "redirect:/user/viewList.do";
	}

	// ����ɾ������
	@RequestMapping("/deleteBatch.do")
	public String deleteBatch(HttpServletRequest request) {
		// ����ҳ���ֵ
		String[] ids = request.getParameterValues("id");
		userService.deleteBatch(Arrays.asList(ids));
		return "redirect:/user/viewList.do";
	}

	// �޸�ҳ��
	@RequestMapping("/modifyView.do/{id}")
	public ModelAndView modifyView(@PathVariable Long id, HttpServletRequest request) {
		User user = userService.selectUserById(String.valueOf(id));
		request.setAttribute("message", user);
		return new ModelAndView("modify");
	}

	// �޸�
	@RequestMapping("/modify.do/{id}")
	public String modify(@PathVariable long id, HttpServletRequest request) {
		User user = new User();
		user.setId(String.valueOf(id));
		user.setPassword(request.getParameter("passwordNew"));
		userService.updateUser(user);
		return "redirect:/user/viewList.do";
	}
}
