package com.java155.shop.service.impl;

import com.java155.shop.exception.LoginException;
import com.java155.shop.mapper.TbUserMapper;
import com.java155.shop.pojo.TbUser;
import com.java155.shop.pojo.TbUserExample;
import com.java155.shop.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbUserServiceImpl implements TbUserService {

	@Autowired
	private TbUserMapper tbUserMapper;

	@Override
	public TbUser findByidUser(TbUser tbUser) {
		TbUserExample example=new TbUserExample();
		example.createCriteria().andUsernameEqualTo(tbUser.getUsername());
		List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
		if(tbUser!=null && tbUsers.size()>0){
			TbUser user = tbUsers.get(0);
			 if(user.getPassword().equals(tbUser.getPassword())){
				//登录成功
				return user;
			}
			 throw new LoginException("密码错误");
		}
		throw new LoginException("账号错误");
	}
}
