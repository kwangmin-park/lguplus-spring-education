package practice.spring.lguplusspringeducation.chap11.spring;

import java.util.Collection;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {

	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/*
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from member where email = ?",
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("email"), rs.getString("password"),
						rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));
				
				return member;
			}
		}, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	*/
	
	/*
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from member where email = ?",
			(ResultSet rs, int rowNum) -> {
				Member member = new Member(rs.getString("email"), rs.getString("password"),
						rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));
				
				return member;
			}, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	*/

	public Member selectByEmail(String email) {
		Member member = null;
		
		try {
			member = jdbcTemplate.queryForObject("select * from member where email = ?", new MemberRowMapper(), email);
		}
		catch(Exception e) {
		}
		
		return member;
	}
	
	/*
	public Collection<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from member",
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("email"), rs.getString("password"),
						rs.getString("name"), rs.getTimestamp("regdate").toLocalDateTime());
				member.setId(rs.getLong("id"));
				
				return member;
			}
		});
		
		return results;
	}
	*/
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from member", new MemberRowMapper());
		return results;
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		return count;
	}
	
	public void update(Member member) {
		jdbcTemplate.update("update member set name = ?, password=? where email = ?",
				member.getName(), member.getPassword(), member.getEmail());
	}
	
	/*
	public void insert(Member member) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = "insert into member(email, password. name, regdate) values(?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				
				return pstmt;
			}
		});	
	}
	*/
	
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				String sql = "insert into member(email, password, name, regdate) values(?, ?, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "ID" });
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
}
