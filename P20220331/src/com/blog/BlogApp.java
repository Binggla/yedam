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

					System.out.println("\n\t로그인 성공!");

					// 메인 메뉴
					while (true) {

						List<Writing> getList = bs.getList();

						System.out.println("\n\t게시판\t 번호\t날짜\t\t작성자\t제목");
						System.out.println("\t----------------------------------------------------------------");

						for (Writing w : getList) {
							System.out.println(w.writingList());
						}
						System.out.print("\n1. 게시글 상세보기 2. 게시글 조회 3. 게시글 등록 9. 로그아웃 > ");
						int inputMenu = scan.nextInt();

						if (inputMenu == 1) { // 게시글 상세보기

							System.out.print("글 번호 입력 > ");
							int inputWritingNo = scan.nextInt();

							while (true) {

								System.out.println(bs.getWriting(inputWritingNo).toString());
								System.out.println("\n\t댓글");
								List<ReComment> comments = bs.getComment(inputWritingNo);
								for (ReComment c : comments) {
									if (c.getReUserId() == null) {
										System.out.println(c.printComment());
									} else {
										System.out.println(c.printReComment());
									}
								}
								System.out.print("\n1. 수정 2. 삭제 3. 댓글 등록 4. 댓글 수정 5. 댓글 삭제 9. 뒤로가기 > ");
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
												System.out.println("\n\t수정 완료!");
												break;
											} else {
												System.out.println("\n\t정상적으로 처리되지 않았습니다.");
											}
										} else {
											System.out.println("\n\t본인이 작성한 글만 수정할 수 있습니다.");
										}
										break;

									}

								} else if (inputWritingMenu == 2) { // 게시글 삭제

									if (bs.checkUser(user, inputWritingNo) == true) {

										System.out.print("\n\t정말로 글을 삭제하시겠습니까? (Y/N) > ");
										String inputAnswer = scan.next();

										if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {

											if (bs.deletePost(inputWritingNo) == true) {

												System.out.println("\t삭제 완료!\n");
												break;

											} else {
												System.out.println("\n\t정상적으로 처리되지 않았습니다.");
											}

										} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
											continue;
										} else {
											System.out.println("\n\t잘못 입력하셨습니다.");
										}

									} else {
										System.out.println("\n\t본인이 작성한 글만 삭제할 수 있습니다.");
									}

								} else if (inputWritingMenu == 3) { // 댓글 등록
									
									System.out.println("1. 새 댓글 등록 2. 답글 등록");
									int inputAnswer = scan.nextInt();
									
									if (inputAnswer == 1) {
										
										System.out.print("댓글 등록 > ");
										String inputComment = scan.nextLine();
										inputComment = scan.nextLine();
										
										Comment com = new Comment(inputWritingNo, user.getUserId(), inputComment);
										bs.commenting(com);
										
										System.out.println("\n\t새 댓글 등록 완료!");
					
									} else if (inputAnswer == 2) {
										
										System.out.print("답글을 달 댓글 번호 > ");
										int inputCommentNo = scan.nextInt();
										System.out.print("답글 등록 > ");
										String inputReComment = scan.nextLine();
										inputReComment = scan.nextLine();
										
										
										ReComment reCom = new ReComment(user.getUserId(), inputCommentNo, inputReComment);
										if (bs.reCommenting(reCom) == true) {
											System.out.println("\n\t답글 등록 완료!");
										} else {
											System.out.println("\\n\\t정상적으로 처리되지 않았습니다.");
										}
										
									} else {
										System.out.println("\n\t잘못 입력하셨습니다.");
									}
									

								} else if (inputWritingMenu == 4) { // 댓글 수정

									while (true) {

										System.out.print("수정할 댓글 번호 > ");
										int inputCommentNo = scan.nextInt();

										if (bs.searchComment(inputWritingNo, inputCommentNo) == true) {

											if (bs.checkUserComment(user, inputCommentNo) == true) {

												System.out.print("댓글 수정 > ");
												String inputComment = scan.nextLine();
												inputComment = scan.nextLine();

												Comment com = new Comment(inputWritingNo, user.getUserId(),
														inputCommentNo, inputComment);

												if (bs.updateComment(com) == true) {

													System.out.println("\n\t댓글 수정 완료!");
													break;

												} else {
													System.out.println("\n\t정상적으로 처리되지 않았습니다.");
												}

											} else {
												System.out.println("\n\t본인이 작성한 댓글만 수정할 수 있습니다.");
												break;
											}

										} else {
											System.out.println("\n\t해당하는 댓글 번호가 없습니다.");
										}
									}

								} else if (inputWritingMenu == 5) { // 댓글 삭제

									while (true) {

										System.out.print("삭제할 댓글 번호 > ");
										int inputCommentNo = scan.nextInt();

										if (bs.searchComment(inputWritingNo, inputCommentNo) == true) {

											if (bs.checkUserComment(user, inputCommentNo) == true) {

												System.out.print("\n\t정말로 댓글을 삭제하시겠습니까? (Y/N) > ");
												String inputAnswer = scan.next();

												if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {

													if (bs.deleteComment(inputCommentNo) == true) {

														System.out.print("\t댓글 삭제 완료!\n");
														break;

													} else {
														System.out.println("\\n\\t정상적으로 처리되지 않았습니다.");
													}

												} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
													break;
												}

											} else {
												System.out.println("\n\t본인이 작성한 댓글만 삭제할 수 있습니다.");
												break;
											}

										} else {
											System.out.println("\n\t해당하는 댓글 번호가 없습니다.");
										}

									}

								} else if (inputWritingMenu == 9) { // 뒤로가기
									break;
								} else {
									System.out.println("\n\t잘못 입력하셨습니다.");
								}
							}

						} else if (inputMenu == 2) { // 게시글 조회
							System.out.print("게시글 조회 > 1. 게시판별 조회 2. 작성자 조회 3. 날짜 조회 > ");
							int inputSelect = scan.nextInt();

							if (inputSelect == 1) { // 게시판 이름 조회

								String selectBoardName = null;
								while (true) {

									System.out.print("게시판별 조회 > 1. 일기 2. 생활정보 3. 음식정보 > ");
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

								System.out.println("\n\t게시판\t 번호\t날짜\t\t작성자\t제목");
								System.out
										.println("\t----------------------------------------------------------------");
								getList = bs.selectListName(selectBoardName);
								for (Writing w : getList) {
									System.out.println(w.writingList());
								}

								System.out.print("\n9. 뒤로가기 > ");
								int inputAnswer = scan.nextInt();

								if (inputAnswer == 9) {
									continue;
								} else {
									System.out.println("잘못 입력하셨습니다.");
								}

							} else if (inputSelect == 2) { // 게시글 작성자 조회
								System.out.print("작성자 조회 > 작성자 ID > ");
								String inputUserId = scan.next();

								System.out.println("\n\t게시판\t 번호\t날짜\t\t작성자\t제목");
								System.out
										.println("\t----------------------------------------------------------------");
								getList = bs.selectListUser(inputUserId);
								for (Writing w : getList) {
									System.out.println(w.writingList());
								}

								System.out.print("\n9. 뒤로가기 > ");
								int inputAnswer = scan.nextInt();

								if (inputAnswer == 9) {
									continue;
								} else {
									System.out.println("잘못 입력하셨습니다.");
								}

							} else if (inputSelect == 3) { // 게시글 날짜 조회
								System.out.print("날짜 조회 > 첫 번째 날짜부터 조회합니다. ex.00-00-00 > ");
								String inputWritingDate1 = scan.next();
								System.out.print("날짜 조회 > 두 번째 날짜까지 조회합니다. ex.00-00-00 > ");
								String inputWritingDate2 = scan.next();

								System.out.println("\n\t게시판\t 번호\t날짜\t\t작성자\t제목");
								System.out
										.println("\t----------------------------------------------------------------");
								getList = bs.selectListDate(inputWritingDate1, inputWritingDate2);

								for (Writing w : getList) {
									System.out.println(w.writingList());
								}

								System.out.print("\n9. 뒤로가기 > ");
								int inputAnswer = scan.nextInt();

								if (inputAnswer == 9) {
									continue;
								} else {
									System.out.println("\t잘못 입력하셨습니다.");
								}
							}

						} else if (inputMenu == 3) { // 게시글 등록
							// (board_name, writing_no, writing_date, user_id, writing_sub, writing)

							String selectBoardName = null;
							while (true) {

								System.out.print("등록할 게시판 > 1. 일기 2. 생활정보 3. 맛집정보 > ");
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
									System.out.println("\n\t잘못 입력하셨습니다.");
								}
							}

							System.out.print("글 제목 > ");
							String inputWritingSub = scan.nextLine();
							inputWritingSub = scan.nextLine();

							System.out.print("글 > ");
							String inputWriting = scan.nextLine();

							Writing writing = new Writing(selectBoardName, inputWritingSub, user.getUserId(),
									inputWriting);

							if (bs.insertPost(writing) == true) {
								System.out.println("\n\t작성 완료!");
							} else {
								System.out.println("\n\t정상적으로 처리되지 않았습니다.");
							}

						} else if (inputMenu == 9) { // 로그아웃
							break;
						} else {
							System.out.println("\n\t잘못 입력하셨습니다.");
						}

					} // end of while

				} else {
					System.out.println("\n\t입력한 아이디, 비밀번호를 찾을 수 없습니다.");
					continue;
				}

			} else if (inputLogin == 2) { // 회원가입

				while (true) {
					System.out.print("아이디 입력 >> ");
					String inputId = scan.next();
					System.out.print("비밀번호 입력 >> ");
					String inputPw = scan.next();

					if (bs.checkUser(inputId) == true) {
						System.out.println("중복된 아이디가 있습니다.");
					} else {
						User newUser = new User(inputId, inputPw);
						if (bs.insertUser(newUser) == true) {

							System.out.println("\n\t회원가입 완료!");
							System.out.println("\t다시 실행하여 로그인해 주세요.");

						} else {

							System.out.println("\n\t정상적으로 처리되지 않았습니다.");

						}
						break;
					}

				}

			} else if (inputLogin == 3) { // 프로그램 종료
				break;

			} else {
				System.out.println("\n\t잘못 입력하셨습니다.");
				continue;
			}

		}

		System.out.println("End of Program");

	} // end of main()

	public void printLogin() {
		String str = "\t------------\n" //
				+ "\t  1. 로그인\n" //
				+ "\t  2. 회원가입\n" //
				+ "\t  3. 종료\n" //
				+ "\t------------\n" //
				+ "선택 > ";
		System.out.print(str);
	}

}
