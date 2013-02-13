package com.studentProfile.DAO;

import com.studentProfile.model.entity.AdminModel;
import com.studentProfile.util.DatabaseUtil;
import com.studentProfile.util.LogMessage;

public class AdminDAO {
	// This method validates the admin credentials. If valid, it will return a
	// admin object else returns null
	public AdminModel login(String userName, String password) {
		AdminModel admin = null;
		int flag = -1;
		try {
			DatabaseUtil.connect();
			DatabaseUtil.ps = DatabaseUtil.con
					.prepareStatement("SELECT * FROM admin WHERE adminName=? AND password=?");
			LogMessage
					.log("Message From AdminDAO.login : Arguments ::username is--"
							+ userName + " password is--" + password);
			DatabaseUtil.ps.setString(1, userName);
			DatabaseUtil.ps.setString(2, password);
			DatabaseUtil.rs = DatabaseUtil.ps.executeQuery();
			while (DatabaseUtil.rs.next()) {
				admin = new AdminModel();
				admin.setAdminID(DatabaseUtil.rs.getInt("adminID"));
				admin.setAdminName(DatabaseUtil.rs.getString("adminName"));
				admin.setPassword(DatabaseUtil.rs.getString("password"));
				flag = 1;// setting flag = 1 says that a admin credentials are
							// validated and there is an admin with the given
							// credentials
				LogMessage.log("Message From AdminDAO.login : username is "
						+ admin.getAdminName());
			}

		} catch (Exception e) {
			LogMessage.log("Exception Caught in AdminDAO.login");
			e.printStackTrace();
			admin = null;
		} finally {
			if (flag != 1)
				admin = null;
			DatabaseUtil.connectionClose();
		}

		return admin;
	}
}
