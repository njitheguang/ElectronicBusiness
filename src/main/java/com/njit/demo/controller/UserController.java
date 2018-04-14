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

	// 登录
	@RequestMapping("/login.do")
	public ModelAndView login(String username, String password, HttpServletRequest request) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		List<User> userList = userService.selectUser(user);
		request.setAttribute("message", "登录");
		if (userList.size() > 0) {
			request.setAttribute("userList", userList);
			return new ModelAndView("success");
		} else
			return new ModelAndView("fail");
	}

	// 注册
	@RequestMapping("/register.do")
	public ModelAndView regist(String username, String password, HttpServletRequest request) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		boolean flag = true;
		flag = userService.existUser(username);
		request.setAttribute("message", "注册");
		if (!flag) {
			userService.insertUser(user);
			return new ModelAndView("success");
		} else {
			return new ModelAndView("fail");
		}
	}

	// 显示用户列表
	@RequestMapping("/viewList.do")
	public ModelAndView viewList(HttpServletRequest request) {
		List<User> list = userService.selectUsers();
		request.setAttribute("messageList", list);
		request.setAttribute("message", "注册");
		return new ModelAndView("viewList");
	}

	// 根据ID，删除单条数据
	@RequestMapping("/deleteOne.do/{id}")
	public String deleteOne(@PathVariable long id, HttpServletRequest request) {
		User u = new User();
		u.setId(String.valueOf(id));
		userService.deleteOne(u);
		return "redirect:/user/viewList.do";
	}

	// 批量删除数据
	@RequestMapping("/deleteBatch.do")
	public String deleteBatch(HttpServletRequest request) {
		// 接受页面的值
		String[] ids = request.getParameterValues("id");
		userService.deleteBatch(Arrays.asList(ids));
		return "redirect:/user/viewList.do";
	}

	// 修改页面
	@RequestMapping("/modifyView.do/{id}")
	public ModelAndView modifyView(@PathVariable Long id, HttpServletRequest request) {
		User user = userService.selectUserById(String.valueOf(id));
		request.setAttribute("message", user);
		return new ModelAndView("modify");
	}

	// 修改
	@RequestMapping("/modify.do/{id}")
	public String modify(@PathVariable long id, HttpServletRequest request) {
		User user = new User();
		user.setId(String.valueOf(id));
		user.setPassword(request.getParameter("passwordNew"));
		userService.updateUser(user);
		return "redirect:/user/viewList.do";
	}
}
