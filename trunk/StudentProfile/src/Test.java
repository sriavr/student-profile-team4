import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.stream.FileImageInputStream;

import java.io.InputStream;

import java.sql.Connection;
import com.studentProfile.DAO.BaseDAO;


public class Test extends BaseDAO {
	public static void main(String[] args) throws IOException,SQLException {
		
		insertImage();
	}
		public static void insertImage() throws IOException, SQLException {
			
			PreparedStatement statement = null;
			FileInputStream inputStream = null;
            Connection connection;
			
				File image = new File("D:\\Koala.jpg");
				inputStream = new FileInputStream(image);
				connection = getConnection();
				System.out.println(image.length());
				statement = connection.prepareStatement("update student set stuPhoto = ?");
			
				statement.setBinaryStream(1, (InputStream) inputStream,
						(int) (image.length()));

				statement.executeUpdate();
		

		}

		/***
		 * Execute Program
		 * 
		 * @param args
		 * @throws SQLException
		 */
		
	
	

}
