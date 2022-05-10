package project.gugbab.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.gugbab.dao.DataSource;
import project.gugbab.service.GugbabService;
import project.gugbab.service.GugbabVO;

public class GugbabServiceImpl implements GugbabService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection(); // connection
	private PreparedStatement psmt; // sql명령문을 실행
	private ResultSet rs; // select결과물을 담음
	private Scanner sc = new Scanner(System.in);

	@Override
	public List<GugbabVO> selectListGugbab() {
		// 전체 유저 목록가져오기

		List<GugbabVO> gugbabs = new ArrayList<GugbabVO>(); // 자기자신을 초기화하지 못하기에 ArrayList로 초기화한다
		GugbabVO gugbab;
		String sql = "SELECT * FROM GUGBABUSER";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql); // 커넥션객체를 통해서 sql을 보내고 명령실행을 해줄수있도록
			rs = psmt.executeQuery(); // sql을 실행하고 결과를 담음
			while (rs.next()) { // 아무것도 읽을게 없으면 빠져나간다 읽을게 있으면
				gugbab = new GugbabVO(); // 인스턴스를 깨끗하게 비운다(초기화)
				gugbab.setUserId(rs.getString("userId"));
				gugbab.setName(rs.getString("name"));
				gugbab.setPassword(rs.getString("password"));
				// 다 읽었으면
				gugbabs.add(gugbab); // 리스트 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return gugbabs;
	}

	@Override
	public GugbabVO selectGugbab(String sId) {
		// 한명조회
		GugbabVO vo = new GugbabVO();
		String sql = "SELECT * FROM GUGBABUSER WHERE ID = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setUserId(rs.getString("userid"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertGugbab(GugbabVO gugbab) {
		// 한명추가
		int n = 0;
		String sql = "INSERT INTO GUGBABUSER VALUES(?,?,?)";
		try {
			psmt = conn.prepareCall(sql);
			psmt.setString(1, gugbab.getUserId());
			psmt.setString(2, gugbab.getName());
			psmt.setString(3, gugbab.getPassword());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int updateGugbab(String sId) {
		// 한명 정보 변경
		int n = 0;
		String sql = "UPDATE GUGBABUSER SET PW = ?, ID = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println("비밀번호를 변경합니다.");
			String upPassword = sc.next();
			psmt.setString(1, upPassword);
			psmt.setString(2, sId);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int deleteGugbab(String sId) {
		// 한명 삭제
		int n = 0;
		String sql = "DELETE FROM GUGBABUSER WHERE ID = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sId);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	@Override
	public int login(String userID, String password) {
		ResultSet rs;
		String sql = "SELECT PW FROM GUGBABUSER WHERE ID = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userID);
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println();
				if (rs.getString(1).equals(password))
					return 1;
				else
					return 0;
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return -2;
	}

	public int savingMoney(int money, String sId) {
		String sql = "UPDATE GUGBABUSER SET MONEY = MONEY + ? WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, money);
			psmt.setString(2, sId);
			psmt.executeQuery();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return -2;

	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
