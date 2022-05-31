package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	
	// 2개 이상의 매개변수를 받아야할 경우
	// 넘어오는 state 변수를 String 타입의 state 변수로 쓸 거야.
	List<NoticeVO> noticeSelectList(@Param("state") int state, @Param("key") String key);
	
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(int id); // 조회수 업데이트
}
