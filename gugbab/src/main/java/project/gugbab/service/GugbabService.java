package project.gugbab.service;

import java.util.List;

public interface GugbabService {
	
	List<GugbabVO> selectListGugbab();

	GugbabVO selectGugbab(GugbabVO vo); // 조회

	int insertGugbab(GugbabVO vo); // 추가

	int updateGugbab(GugbabVO vo); // 변경

	int deleteGugbab(GugbabVO vo); // 삭제

}
