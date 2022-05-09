package project.gugbab.service;

import java.util.List;

public interface GugbabService {
	
	List<GugbabVO> selectListGugbab();

	GugbabVO selectGugbab(String sId); // 조회

	int insertGugbab(GugbabVO vo); // 추가

	int updateGugbab(String sId); // 변경

	int deleteGugbab(String sId); // 삭제

	int login(String userID, String password);
	
	int savingMoney(int Money, String id);

	GugbabVO selectGugbab();


}
