package com.connext.service.impl;

import java.sql.SQLException;

import com.connext.model.SmsRecord;

import dao.SmsDao;

public class SmsServiceImpl implements SmsService{
	
	@Override
	public void save(String phone, int rand,String password) {
		try {
			new SmsDao().save(phone, rand,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
