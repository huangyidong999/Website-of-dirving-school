package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.bean.User;
import com.toolkit.DBtoolkit;



public class UserDao {
	/**
	 * 用户在线报名注册
	 */
	public int registUser(User user){
		Connection con = null;
		PreparedStatement ps =null;
		con = DBtoolkit.getConnection();
		String sql = "INSERT INTO yellowriver VALUES(default,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getProfession());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getTel());
			ps.setString(6, user.getRemark());
			int i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBtoolkit.closeAll(null, ps, con);
		}
		return 0;
	}

}
