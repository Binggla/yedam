package com.blog;

import java.util.List;
import java.util.Scanner;

public class BlogApp {

	Scanner scan = new Scanner(System.in);

	public void execute() {

		BlogService bs = new BlogServiceOracle();
		User user;

		// 로그인
		while (true) {

			printLogin();
			int inputLogin = scan.nextInt();

			if (inputLogin == 1) { // 로그인

				System.out.print("아이디 입력 >> ");
				String inputId = scan.next();
				System.out.print("비밀번호 입력 >> ");
				String inputPw = scan.next();

				user = new User(inputId, inputPw);

				if (bs.login(user) == true) {

					System.out.println("\t로그인 성공!");
					
					// 메인 메뉴
					while (true) {

						printMenu();
						int inputMenu = scan.nextInt();

						if (inputMenu == 1) { // 전체 리스트 조회
							List<Writing> getList = bs.getList();
							
							for(Writing w : getList) {
								System.out.println(w.toString());
							}
							
						} else if (inputMenu == 2) { // 게시글 조회
							printSelect();
							int inputSelect = scan.nextInt();
							
							if (inputSelect == 1) {		// 게시판 이름 조회
								
								String selectBoardName = null;
								while (true) {
									
									System.out.print("조회할 게시판 선택 > 1. diary 2. life info 3. food info >> ");
									int inputBoardName = scan.nextInt();
									
									if (inputBoardName == 1) { // diary
										selectBoardName = "diary";
										break;
									} else if (inputBoardName == 2) {	// life info
										selectBoardName = "life_info";
										break;
									} else if (inputBoardName == 3) {	// food info
										selectBoardName = "food_info";
										break;
									} else {
										System.out.println("\t잘못 입력하셨습니다.");
									}
								}
								
								List<Writing> getList = bs.selectListName(selectBoardName);
								for(Writing w : getList) {
									System.out.println(w.toString());
								}
	
							} else if (inputSelect == 2) { // 게시글 번호 조회
								System.out.print("조회할 게시글 번호 입력 >> ");
								int inputWritingNo = scan.nextInt();
								
								List<Writing> getList = bs.selectListNo(inputWritingNo);
								
								for(Writing w : getList) {
									System.out.println(w.toString());
								}
								
							} else if (inputSelect == 3) { // 게시글 제목 조회
								System.out.print("조회할 게시글 제목 입력 >> ");
								String inputWritingSub = scan.next();
								
								List<Writing> getList = bs.selectListSubject(inputWritingSub);
								
								for(Writing w : getList) {
									System.out.println(w.toString());
								}
								
							} else if (inputSelect == 4) { // 게시글 날짜 조회 
								System.out.print("첫 번째 날짜 설정 ex.00-00-00 >> ");
								String inputWritingDate1 = scan.next();
								System.out.print("두 번째 날짜 설정 ex.00-00-00 >> ");
								String inputWritingDate2 = scan.next();
								
								List<Writing> getList = bs.selectListDate(inputWritingDate1, inputWritingDate2);
								
								for(Writing w : getList) {
									System.out.println(w.toString());
								}
							} 
							
						} else if (inputMenu == 3) { // 게시글 등록
							//(board_name, writing_no, writing_date, user_id, writing_sub, writing)
							
							
							String selectBoardName = null;
							while (true) {
								
								System.out.print("게시판 선택 > 1. diary 2. life info 3. food info >> ");
								int inputBoardName = scan.nextInt();
								
								if (inputBoardName == 1) { // diary
									selectBoardName = "diary";
									break;
								} else if (inputBoardName == 2) {	// life info
									selectBoardName = "life_info";
									break;
								} else if (inputBoardName == 3) {	// food info
									selectBoardName = "food_info";
									break;
								} else {
									System.out.println("\t잘못 입력하셨습니다.");
								}
							}
							
							int inputWritingNo = 0;
							while (true) {
								System.out.print("게시글 번호 > ");
								inputWritingNo = scan.nextInt();
								
								if (bs.searchWriting(inputWritingNo) == true) {
									System.out.println("\t중복되는 게시글 번호가 있습니다.");
								} else {
									break;
								}
							}
							
							System.out.print("등록 날짜 ex.00-00-00 > ");
							String inputWritingDate = scan.next();
							
							System.out.print("글 제목 > ");							
							String inputWritingSub = scan.nextLine();
							inputWritingSub = scan.nextLine();
							
							System.out.print("글 > ");
							String inputWriting = scan.nextLine();
							
							Writing writing = new Writing(selectBoardName, inputWritingNo, inputWritingSub, user.getUserId(), inputWritingDate, inputWriting);
							
							if (bs.insertPost(writing) == true) {
								System.out.println("\t작성 완료!");
							} else {
								System.out.println("\t정상적으로 처리되지 않았습니다.");
							}
							
						} else if (inputMenu == 4) { // 게시글 수정

							int inputWritingNo = 0;
							while (true) {
								System.out.print("수정할 게시글 번호 입력 >> ");
								inputWritingNo = scan.nextInt();
								
								if (bs.searchWriting(inputWritingNo) == false) {
									System.out.println("\t해당하는 게시글 번호가 없습니다.");
								} else {
									
									if (bs.checkUser(user, inputWritingNo) == true) {
										
										System.out.print("글 제목 >> ");							
										String inputWritingSub = scan.nextLine();
										inputWritingSub = scan.nextLine();
										
										System.out.print("글 >> ");
										String inputWriting = scan.nextLine();
										
										Writing writing = new Writing(null, inputWritingNo, inputWritingSub, user.getUserId(), null, inputWriting);
										
										if (bs.updatePost(writing) == true) {
											System.out.println("\t수정 완료!");
										} else {
											System.out.println("\t정상적으로 처리되지 않았습니다.");
										}
									} else {
										System.out.println("\t본인이 작성한 글만 수정할 수 있습니다.");
									}
									
									break;
									
								}
							}

							
							
						} else if (inputMenu == 5) { // 게시글 삭제
							
							int inputWritingNo = 0;
							while (true) {
								System.out.print("삭제할 게시글 번호 입력 >> ");
								inputWritingNo = scan.nextInt();
								
								if (bs.searchWriting(inputWritingNo) == false) {
									System.out.println("\t해당하는 게시글 번호가 없습니다.");
								} else {
									if (bs.checkUser(user, inputWritingNo) == true) {
										
										if (bs.deletePost(inputWritingNo) == true) {
											System.out.println("\t삭제 완료!");
										} else {
											System.out.println("\t정상적으로 처리되지 않았습니다.");
										}
										
									} else {
										System.out.println("\t본인이 작성한 글만 삭제할 수 있습니다.");
									}
									break;
								}
							}
							
							

						} else if (inputMenu == 9) { // 메인 메뉴 종료
							break;
						} else {
							System.out.println("\t잘못 입력하셨습니다.");
						}

					} // end of while

					break;

				} else {
					System.out.println("\t입력한 아이디, 비밀번호를 찾을 수 없습니다.");
					continue;
				}

			} else if (inputLogin == 2) { // 회원가입

				System.out.print("아이디 입력 >> ");
				String inputId = scan.next();
				System.out.print("비밀번호 입력 >> ");
				String inputPw = scan.next();

				User newUser = new User(inputId, inputPw);
				
				if (bs.insertUser(newUser) == true) {
					
					System.out.println("\t회원가입 완료!");
					System.out.println("\t다시 실행하여 로그인해 주세요.");
					
				} else {
					
					System.out.println("\t정상적으로 처리되지 않았습니다.");
					
				}

			} else if (inputLogin == 3) {	// 로그인 종료
				break;
				
			} else {
				System.out.println("\t잘못 입력하셨습니다.");
				continue;
			}
			break;

		}

		System.out.println("End of Program");

	} // end of main()

	public void printLogin() {
		String str ="\t--------------\n" //
				+ "\t   1. 로그인\n" //
				+ "\t   2. 회원가입\n" //
				+ "\t   3. 종료\n" //
				+ "\t--------------\n" //
				+ "선택 > ";
		System.out.print(str);
	}

	public void printMenu() {
		String str = "\n\t      메인\n" //
				+ "\t--------------\n" //
				+ "\t 1. 전체 게시글\n" //
				+ "\t 2. 게시글 조회\n" //
				+ "\t 3. 게시글 등록\n" //
				+ "\t 4. 게시글 수정\n" //
				+ "\t 5. 게시글 삭제\n" //
				+ "\t 9. 로그아웃\n" //
				+ "\t--------------\n" //
				+ "선택 > ";
		System.out.print(str);
	}
	
	public void printSelect() {
		String str = "\n\t   게시글 조회\n" //
				+ "\t--------------\n" //
				+ "\t 1. 게시판 이름\n" //
				+ "\t 2. 게시글 번호\n" //
				+ "\t 3. 게시글 제목\n" //
				+ "\t 4. 게시글 날짜\n" //
				+ "\t--------------\n" //
				+ "선택 > ";
		System.out.print(str);
	}
	

}
