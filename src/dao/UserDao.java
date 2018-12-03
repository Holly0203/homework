package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connext.model.User;
import com.connext.util.DBUtil;

public class UserDao {
	User user = null;
	//查询数据库中有无重复的手机号
	public Integer ifexist(String phone) {
		int flag=0;
		Connection conn = DBUtil.getConnection();
		User user=new User();
		String sql="select phone,pwd from user where phone=?";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, phone);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				user.setPhone(rs.getString("phone"));
				user.setPwd(rs.getString("pwd"));
			}
			if(user.getPhone()==null) {
				flag=1;
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	//增加进数据库
	public void add(User user) {
		System.out.println("获取"+user.getPhone());
		Connection conn = DBUtil.getConnection();
		String sql = "insert into user(phone,pwd) values(?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getPhone());
			pst.setString(2, user.getPwd());
			pst.executeUpdate();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
