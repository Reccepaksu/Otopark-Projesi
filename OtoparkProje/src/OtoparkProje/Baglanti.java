package OtoparkProje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Baglanti {
	static String url = "jdbc:postgresql://localhost:5432/otopark";
	static Connection conn ;
	static Statement mystat;
	
		static void baglan() {
			try {
				conn=DriverManager.getConnection(url,"postgres","1234");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		static ResultSet sorgu(String sql_sorgu) {
			Statement st;
			ResultSet rs=null;
			
			try {
				st=conn.createStatement();
				rs = st.executeQuery(sql_sorgu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
	
	
	
	
	
	
	
	
}
