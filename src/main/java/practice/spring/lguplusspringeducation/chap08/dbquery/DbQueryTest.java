package practice.spring.lguplusspringeducation.chap08.dbquery;

public class DbQueryTest {
    public static void main(String[] args){
        DbConfig config = new DbConfig();
        DbQuery query = new DbQuery(config.dataSource());

        System.out.println("전체 회원 수 : "+query.count());
    }
}
