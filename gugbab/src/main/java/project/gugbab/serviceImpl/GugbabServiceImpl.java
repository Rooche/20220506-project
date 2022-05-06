package project.gugbab.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.gugbab.dao.DataSource;
import project.gugbab.service.GugbabService;
import project.gugbab.service.GugbabVO;

public class GugbabServiceImpl implements GugbabService{
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection(); // connection
	private PreparedStatement psmt; // sql명령문을 실행
	private ResultSet rs; // select결과물을 담음

	@Override
	public List<GugbabVO> selectListGugbab() {
		// 전체 유저 목록가져오기
		
		List<GugbabVO> gugbabs = new ArrayList<GugbabVO>(); // 자기자신을 초기화하지 못하기에 ArrayList로 초기화한다
		GugbabVO gugbab;
		String sql = "SELECT * FROM USERID";
		try {
			psmt = conn.prepareStatement(sql); // 커넥션객체를 통해서 sql을 보내고 명령실행을 해줄수있도록
			rs = psmt.executeQuery(); // sql을 실행하고 결과를 담음
			while (rs.next()) { // 아무것도 읽을게 없으면 빠져나간다 읽을게 있으면
				gugbab = new GugbabVO(); //인스턴스를 깨끗하게 비운다(초기화)
				gugbab.setUserId(rs.getString("userId"));
				gugbab.setName(rs.getString("name"));
				gugbab.setPassword(rs.getString("password"));
				gugbab.setGender(rs.getString("gender"));
				// 다 읽었으면
				gugbabs.add(gugbab); //리스트 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gugbabs;
	}

	@Override
	public GugbabVO selectGugbab(GugbabVO gugbab) {
		// 한명조회
		GugbabVO vo = new GugbabVO();
		String sql = "SELECT * FROM GUGBAB WHERE USERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gugbab.getUserId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setUserId(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setGender(rs.getString("gender"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertGugbab(GugbabVO gugbab) {
		//한명추가
		int n = 0;
		String sql = "INSERT INTO GUGBAB VALUES(?,?,?,?)";
		try {
			psmt = conn.prepareCall(sql);
			psmt.setString(1, gugbab.getUserId());
			psmt.setString(2, gugbab.getName());
			psmt.setString(3, gugbab.getPassword());
			psmt.setString(4, gugbab.getGender());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int updateGugbab(GugbabVO gugbab) {
		//한명 정보 변경
		int n = 0;
		String sql = "UPDATE GUGBAB SET USERID = ?, PASSWORD = ?, "
				+ "GENDER = ? WHERE NAME = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gugbab.getUserId());
			psmt.setString(2, gugbab.getPassword());
			psmt.setString(3, gugbab.getGender());
			psmt.setString(4, gugbab.getName());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int deleteGugbab(GugbabVO gugbab) {
		//한명 삭제
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, gugbab.getUserId());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

}
