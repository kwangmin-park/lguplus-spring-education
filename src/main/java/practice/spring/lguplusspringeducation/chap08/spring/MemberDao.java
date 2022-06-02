package practice.spring.lguplusspringeducation.chap08.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class MemberDao {
	JdbcTemplate jdbcTemplate;
	public MemberDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public Member selectByEmail(String email){
		//case1. 익명클래스를 이용한 인터페이스(RowMapper) 구현
//		List<Member> results = jdbcTemplate.query("select count(*) from member where email = ?", new RowMapper<Member>(){
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
//				Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
//				member.setId(rs.getLong("id"));
//				return member;
//			}
//		}, email);
		//case2. lambda expression
//		Member results = jdbcTemplate.queryForObject("select count(*) from member where EMAIL = ?",
//				(ResultSet rs, int rowNum) -> {
//					Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
//					member.setId(rs.getLong("id"));
//					return member;
//				}, email);
		Member member = null;
		try{
			member = jdbcTemplate.queryForObject("select * from member where email = ?", new MemberRowMapper(), email);
		}catch (Exception e){

		}
		return member;
	}

	public void insert(Member member){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = "insert into member(email, password, name, regdate) values (?,?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		}, keyHolder);

		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
	public void update(Member member){
		jdbcTemplate.update("update member set name = ?, password = ? where email = ?", member.getName(), member.getPassword(), member.getEmail());
	}

	public int count(){
//		단일행 쿼리는 queryForObject 를 이용
		Integer count = jdbcTemplate.queryForObject("select count(*) from member",Integer.class);
		return count;
	}

	public List<Member> selectAll(){
//		case1. 익명클래스 구현
		List<Member> results = jdbcTemplate.query("select * from member", new RowMapper<Member>(){
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
				Member member = new Member(rs.getString("email"), rs.getString("password"), rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));
				return member;
			}
		});
//		case2. 클래스 직접 구현
//		List<Member> results = jdbcTemplate.query("select * from member", new MemberRowMapper());
		return results;
	}
}
