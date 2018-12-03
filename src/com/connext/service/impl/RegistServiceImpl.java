package com.connext.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.connext.model.User;
import com.connext.util.DBUtil;

public class RegistServiceImpl implements RegistService {

	@Override
	public int saveUser(User user) {
		String sql = "insert into user values(?,?);";
		try(Connection conn = DBUtil.getConnection();)
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(user.getPhone()));
			ps.setString(2, user.getPwd());
			
			int result = ps.executeUpdate();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
