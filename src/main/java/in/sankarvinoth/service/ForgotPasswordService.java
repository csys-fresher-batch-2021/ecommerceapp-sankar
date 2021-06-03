package in.sankarvinoth.service;

import java.sql.SQLException;

import in.sankarvinoth.dao.UserDao;
import in.sankarvinoth.model.User;

public class ForgotPasswordService {

	private ForgotPasswordService() {

	}

	/**
	 * method to check whether the password is updated or not
	 * 
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean userPasswordService(User user) throws ClassNotFoundException, SQLException {
		boolean isUpdated = UserDao.passwordUpdate(user);
		return isUpdated;

	}

}
