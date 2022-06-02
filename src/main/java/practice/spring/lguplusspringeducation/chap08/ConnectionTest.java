package practice.spring.lguplusspringeducation.chap08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args){
        Connection conn = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/spring5fs";
            conn = DriverManager.getConnection(url, "spring5", "spring5");
            System.out.println("연결 성공");
        }catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch (SQLException e){
            System.out.println("Error : " + e);
        }
        finally {
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
