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

				System.out.print("아이디 입력 > ");
				String inputId = scan.next();
				System.out.print("비밀번호 입력 > ");
				String inputPw = scan.next();

				user = new User(inputId, inputPw);

				if (bs.login(user) == true) {

					System.out.println("\t로그인 성공!");

					// 메인 메뉴
					while (true) {

						List<Writing> getList = bs.getList();

						System.out.println("\t================================================================");
						System.out.println("\n\t 게시판\t 번호\t날짜\t\t작성자\t제목\r\n");
						for (Writing w : getList) {
							System.out.println(w.writingList());
						}
						System.out.println("\n\t================================================================");

						System.out.print("\n1. 게시글 보기 2. 게시글 조회 3. 게시글 등록 9. 로그아웃 >> ");
						int inputMenu = scan.nextInt();

						if (inputMenu == 1) { // 게시글 상세보기

							System.out.print("글 번호 입력 > ");
							int inputWritingNo = scan.nextInt();

							System.out.println(bs.getWriting(inputWritingNo).toString());

							System.out.print("\n1. 수정 2. 삭제 3. 댓글 달기 4. 댓글 수정 5. 댓글 삭제 6. 뒤로가기 > ");
							int inputWritingMenu = scan.nextInt();

							if (inputWritingMenu == 1) { // 게시글 수정

								while (true) {

									if (bs.checkUser(user, inputWritingNo) == true) {

										System.out.print("글 제목 수정 > ");
										String inputWritingSub = scan.nextLine();
										inputWritingSub = scan.nextLine();

										System.out.print("글 수정 > ");
										String inputWriting = scan.nextLine();

										Writing writing = new Writing(null, inputWritingNo, inputWritingSub,
												user.getUserId(), inputWriting);

										if (bs.updatePost(writing) == true) {
											System.out.println("\t수정 완료!");
											break;
										} else {
											System.out.println("\t정상적으로 처리되지 않았습니다.");
										}
									} else {
										System.out.println("\t본인이 작성한 글만 수정할 수 있습니다.");
									}
									break;

								}

							} else if (inputWritingMenu == 2) { // 게시글 삭제

		
								while (true) {

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

							} else if (inputWritingMenu == 3) { // 댓글 달기

							} else if (inputWritingMenu == 4) { // 댓글 수정

							} else if (inputWritingMenu == 5) { // 댓글 삭제

							} else if (inputWritingMenu == 6) { // 뒤로가기
								continue;
							} else {
								System.out.println("\t잘못 입력하셨습니다.");
							}

						} else if (inputMenu == 2) { // 게시글 조회
							System.out.print("1. 게시판별 조회 2. 단어 조회 3. 날짜 조회 > ");
							int inputSelect = scan.nextInt();

							if (inputSelect == 1) { // 게시판 이름 조회

								String selectBoardName = null;
								while (true) {

									System.out.print("1. 일기 2. 생활정보 3. 음식정보 > ");
									int inputBoardName = scan.nextInt();

									if (inputBoardName == 1) {
										selectBoardName = "일기";
										break;
									} else if (inputBoardName == 2) {
										selectBoardName = "생활정보";
										break;
									} else if (inputBoardName == 3) {
										selectBoardName = "음식정보";
										break;
									} else {
										System.out.println("\t잘못 입력하셨습니다.");
									}
								}

								getList = bs.selectListName(selectBoardName);
								for (Writing w : getList) {
									System.out.println(w.writingList());
								}

							} else if (inputSelect == 2) { // 게시글 제목 조회
								System.out.print("제목에 포함된 단어 > ");
								String inputWritingSub = scan.next();

								getList = bs.selectListSubject(inputWritingSub);

								for (Writing w : getList) {
									System.out.println(w.writingList());
								}

							} else if (inputSelect == 3) { // 게시글 날짜 조회
								System.out.print("첫 번째 날짜 ex.00-00-00 >> ");
								String inputWritingDate1 = scan.next();
								System.out.print("두 번째 날짜 ex.00-00-00 >> ");
								String inputWritingDate2 = scan.next();

								getList = bs.selectListDate(inputWritingDate1, inputWritingDate2);

								for (Writing w : getList) {
									System.out.println(w.writingList());
								}
							}

						} else if (inputMenu == 3) { // 게시글 등록
							// (board_name, writing_no, writing_date, user_id, writing_sub, writing)

							String selectBoardName = null;
							while (true) {

								System.out.print("게시판 선택 > 1. 일기 2. 생활정보 3. 맛집정보 >> ");
								int inputBoardName = scan.nextInt();

								if (inputBoardName == 1) { // diary
									selectBoardName = "일기";
									break;
								} else if (inputBoardName == 2) { // life info
									selectBoardName = "생활정보";
									break;
								} else if (inputBoardName == 3) { // food info
									selectBoardName = "맛집정보";
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

							System.out.print("글 제목 > ");
							String inputWritingSub = scan.nextLine();
							inputWritingSub = scan.nextLine();

							System.out.print("글 > ");
							String inputWriting = scan.nextLine();

							Writing writing = new Writing(selectBoardName, inputWritingNo, inputWritingSub,
									user.getUserId(), inputWriting);

							if (bs.insertPost(writing) == true) {
								System.out.println("\t작성 완료!");
							} else {
								System.out.println("\t정상적으로 처리되지 않았습니다.");
							}

						} else if (inputMenu == 9) { // 로그아웃
							break;
						} else {
							System.out.println("\t잘못 입력하셨습니다.");
						}

					} // end of while


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

			} else if (inputLogin == 3) { // 프로그램 종료
				break;

			} else {
				System.out.println("\t잘못 입력하셨습니다.");
				continue;
			}

		}

		System.out.println("End of Program");

	} // end of main()

	public void printLogin() {
		String str = "\t--------------\n" //
				+ "\t   1. 로그인\n" //
				+ "\t   2. 회원가입\n" //
				+ "\t   3. 종료\n" //
				+ "\t--------------\n" //
				+ "선택 > ";
		System.out.print(str);
	}

}
