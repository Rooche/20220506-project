package project.gugbab.service;

import java.util.List;

public interface GugbabService {
	
	List<GugbabVO> selectListGugbab();

	GugbabVO selectGugbab(String sId); // 조회

	int insertGugbab(GugbabVO vo); // 추가

	int updateGugbab(String sId); // 변경

	int deleteGugbab(String sId); // 삭제

	int login(String userID, String password); // 로그인
	
	int savingMoney(int Money, String id); // 게임종료할때 돈 저장

//	int changeStore(String sId); // 아이디값으로 가게확장 저장


}
