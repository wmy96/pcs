package com.pcs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcs.pojo.Person;
import com.pcs.pojo.User;
import com.pcs.pojo.UserVerification;
import com.pcs.service.IPersonService;
import com.pcs.service.IUserService;
import com.pcs.service.IUserVerificationService;
import com.pcs.utils.JWTUtil;
import com.pcs.utils.MD5Encryption;
import com.pcs.utils.ResponseData;

@Controller
@RequestMapping("/userVerification")
public class UserVerificationController {
	@Resource
	private IUserVerificationService userVerificationService;
	@Resource
	private IUserService userService;
	@Resource
	private IPersonService personService;

	/**
	 * 获取单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/selectByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody UserVerification selectByPrimaryKey(@RequestBody UserVerification userVerification) {
		return this.userVerificationService.selectByPrimaryKey(userVerification.getUvId());
	}

	/**
	 * 删除单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/deleteByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer deleteByPrimaryKey(@RequestBody UserVerification userVerification) {
		return this.userVerificationService.deleteByPrimaryKey(userVerification.getUvId());
	}

	/**
	 * 修改单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/updateByPrimaryKey.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updateByPrimaryKeySelective(@RequestBody UserVerification userVerification) {
		return this.userVerificationService.updateByPrimaryKeySelective(userVerification);
	}

	/**
	 * 添加单个用户权限信息
	 * 
	 * @param userVerification
	 * @return
	 */
	@RequestMapping(value = "/insert.do", method = { RequestMethod.POST })
	public @ResponseBody Integer insertSelective(@RequestBody UserVerification userVerification) {
		return this.userVerificationService.insertSelective(userVerification);
	}

	/**
	 * 查找全部用户权限信息
	 */
	// @CrossOrigin(origins = "/*", maxAge = 3600)
	@RequestMapping(value = "/findAll.do", method = { RequestMethod.GET })
	public @ResponseBody List<UserVerification> findAll() {
		return this.userVerificationService.findAll();
	}

	/**
	 * 登录
	 */
	// @CrossOrigin(origins = "/*", maxAge = 3600)
	@RequestMapping(value = "/login.do", method = { RequestMethod.POST })
	public @ResponseBody ResponseData login(@RequestBody UserVerification userVerification) {
		userVerification.setPasswordToken(MD5Encryption.createPassword(userVerification.getPasswordToken()));
		userVerification = this.userVerificationService.login(userVerification);

		ResponseData responseData = ResponseData.ok();
		if (userVerification != null) {
			// 生成token
			String token = JWTUtil.generToken("1", "Jersey-Security-Basic", userVerification.getLoginToken());
			// 向浏览器返回token，客户端受到此token后存入cookie中，或者h5的本地存储中
			responseData.putDataValue("token", token);
			// 以及用户信息
			User user = this.userService.selectByPrimaryKey(userVerification.getuId());
			responseData.putDataValue("user", user);

			// 师生信息
			Person person = this.personService.selectByuId(userVerification.getuId());
			responseData.putDataValue("person", person);

			// 以及用户账号密码信息
			responseData.putDataValue("userVerification", userVerification);
		} else {
			// 用户或者密码错误
			responseData = ResponseData.customerError();
		}
		return responseData;
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/updatePassword.do", method = { RequestMethod.POST })
	public @ResponseBody Integer updatePassword(@RequestBody UserVerification userVerification) {
		// 根据uId修改用户的密码
		userVerification.setPasswordToken(MD5Encryption.createPassword(userVerification.getPasswordToken()));
		Integer result = this.userVerificationService.updatePassword(userVerification);
		return result;

	}

	/**
	 * 重置密码
	 */
	@RequestMapping(value = "/passwordReset.do", method = { RequestMethod.POST })
	public @ResponseBody Integer passwordReset(@RequestBody UserVerification userVerification) {
		userVerification.setPasswordToken(MD5Encryption.createPassword("123456"));
		Integer result = this.userVerificationService.updateByPrimaryKeySelective(userVerification);
		return result;

	}

}