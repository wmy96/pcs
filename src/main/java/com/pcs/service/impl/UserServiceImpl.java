package com.pcs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pcs.dao.UserMapper;
import com.pcs.pojo.User;
import com.pcs.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userDao;

	@Override
	public int deleteByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return this.userDao.deleteByPrimaryKey(uId);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return this.userDao.insert(record);

	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return this.userDao.insertSelective(record);

	}

	@Override
	public User selectByPrimaryKey(Integer uId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(uId);

	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKey(record);

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userDao.findAll();
	}

	@Override
	public User selectByuNumber(String uNumber) {
		// TODO Auto-generated method stub
		return this.userDao.selectByuNumber(uNumber);
	}

}
