package practice.spring.lguplusspringeducation.chap08.dbquery;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {
    private DataSource dataSource;

    public DbQuery(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public int count(){
        Connection conn = null;

        try{
            conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) from member");
            rs.next();

            return rs.getInt(1);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally {
            if(conn != null){
                try{
                    conn.close(); // 커넥션을 닫는것이 아닌 반납하는 것.
                }catch (SQLException e){

                }
            }
        }
    }
}
