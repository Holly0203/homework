package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;

import com.connext.model.SmsRecord;
import com.connext.model.User;
import com.connext.util.DBUtil;

public class SmsDao {
	public void save(String phone,int rand,String password) throws SQLException{
		Connection conn = DBUtil.getConnection();
		String sql="insert into smsrecord(phone,code,time,password)  values(?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		try {
			pst.setString(1, phone);
			pst.setInt(2, rand);
			pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pst.setString(4, password);
			pst.execute();
		}finally {
			pst.close();
			conn.close();
		}
	}
}