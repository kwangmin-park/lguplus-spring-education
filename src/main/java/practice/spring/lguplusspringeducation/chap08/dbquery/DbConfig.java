package practice.spring.lguplusspringeducation.chap08.dbquery;


import org.apache.tomcat.jdbc.pool.DataSource;

public class DbConfig {
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring5fs?characterEncoding=utf-8");
        ds.setUsername("spring5");
        ds.setPassword("spring5");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setMinEvictableIdleTimeMillis(1000*60*3);
        ds.setTimeBetweenEvictionRunsMillis(1000 * 10);

        return ds;
    }
}
