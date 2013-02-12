package com.studentProfile.DAO;

import com.studentProfile.model.UserModel;
import com.studentProfile.util.DatabaseUtil;
import com.studentProfile.util.LogMessage;

public class UserDAO {
	public UserModel login(String userName, String password) {
		UserModel user = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("select usrID, usrName, role, password from user WHERE usrName=? AND password=?");
			LogMessage
					.log("Message From UserDAO.login : Arguments ::username is--"
							+ userName + " password is--" + password);
			DatabaseUtil.ps.setString(1, userName);
			DatabaseUtil.ps.setString(2, password);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();

			user = new UserModel();
			while (DatabaseUtil.rs.next()) {
				user.setUsrID(DatabaseUtil.rs.getInt("usrID"));
				user.setUsrName(DatabaseUtil.rs.getString("usrName"));
				user.setPassword(DatabaseUtil.rs.getString("password"));
				user.setRole(DatabaseUtil.rs.getString("role"));
				flag = 1;// setting flag = 1 says that at least one record has
							// been found
				LogMessage.log("Message From UserDAO.login : username is "
						+ user.getUsrName() + " password:" + user.getPassword()
						+ " role:" + user.getRole());
			}

		} catch (Exception e) {
			LogMessage.log("Exception Caught in AdminDAO.login");
			e.printStackTrace();
			user = null;
		} finally {
			if (flag != 1)
				user = null;
			DatabaseUtil.connectionClose();
		}

		return user;
	}
}