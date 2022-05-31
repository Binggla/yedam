package co.micol.prj.notice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

/*
 * Program Name : 공지사항 VO
 * Write by : 지수빈
 * Date : 2022.05.31
 * Version : 1.0
 */

@Setter
@Getter
public class NoticeVO {
	private int noticeId;	// 순번
	private String noticeName;	// 작성자
	private String noticeTitle;	// 제목
	private String noticeContents;	// 내용
	
	private Date noticeDate;	// 작성일자
	private int noticeHit;	// 조회수
	private String noticeAttech;	// 첨부파일
	private String noticeDir;	// 첨부파일 저장 경로
}
