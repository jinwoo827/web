package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class OracleDao implements Dao{
	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public OracleDao(DataSource dataSource){
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		String sql = "insert into member values(?,?,?,?)";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getMsg());
			int result = pstmt.executeUpdate();
			if(result == 0){
				System.out.println("회원가입 실패");
			} else {
				System.out.println(m+"가입 성공");
			}
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
		
	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		Member m = null;
		String sql = "select * from member where id=?";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				m = new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
		return m;
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		String sql = "update member set pwd=?, msg=? where id=?";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getMsg());
			pstmt.setString(3, m.getId());
			int result = pstmt.executeUpdate();
			if(result == 0){
				System.out.println("수정 실패");
			} else {
				System.out.println(m+"수정 성공");
			}
			pstmt.close();			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete member where id=?";
		try{
			con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			if(result == 0){
				System.out.println("삭제 실패");
			} else {
				System.out.println(id+"삭제성공");
			}
			pstmt.close();
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			discon();
		}
	}

	@Override
	public void con() {
		// TODO Auto-generated method stub
		conn = DataSourceUtils.getConnection(dataSource);
		
	}

	@Override
	public void discon() {
		// TODO Auto-generated method stub
		DataSourceUtils.releaseConnection(conn, dataSource);
	}

}
