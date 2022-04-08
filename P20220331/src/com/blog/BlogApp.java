package com.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BlogApp {

	Scanner scan = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BlogService bs = new BlogServiceOracle();
	User loginUser;

	public void execute() {


		// 로그인
		while (true) {

			int inputLogin = 0;
			while (true) {
				try {
					printLogin();
					inputLogin = scan.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("\n\t- 숫자를 입력하세요. -");
					scan.next();
					continue;
				}
			}

			if (inputLogin == 1) { // 로그인

				int cnt = 0;
				System.out.println("\n[ 로그인 ]");
				System.out.print("아이디 입력 > ");
				String inputId = scan.next();
				System.out.print("비밀번호 입력 > ");
				String inputPw = scan.next();

				loginUser = new User(inputId, inputPw);

				if (bs.login(loginUser) == true) {

					System.out.println("\n\t- 로그인 성공! -");
					loginUser = bs.selectMyInfo(loginUser.getUserId());

					// 메인 메뉴
					while (true) {

						List<Writing> getList = bs.getList();

						System.out.println("\n----------------------------------------------------------------");
						System.out.printf(" %-10s%-5s%-15s%-15s%-20s\n", "말머리", "번호", "작성일", "작성자", "제목");
						System.out.println("----------------------------------------------------------------");

						for (Writing w : getList) {
							w.writingList();
						}

						int inputMenu = 0;
						while (true) {
							try {
								System.out.print("\n1 게시글 상세보기  2 게시글 조회  3 게시글 등록  4 마이페이지  9 로그아웃    선택 > ");
								inputMenu = scan.nextInt();
								break;
							} catch (InputMismatchException e) {
								System.out.println("\n\t- 숫자를 입력하세요. -");
								scan.next();
								continue;
							}
						}

						if (inputMenu == 1) { // 게시글 상세보기

							int inputWritingNo = 0;
							while (true) {

								while (true) {
									try {
										System.out.print("글 번호 입력 > ");
										inputWritingNo = scan.nextInt();
										break;
									} catch (InputMismatchException e) {
										System.out.println("\n\t- 숫자를 입력하세요. -\n");
										scan.next();
										continue;
									}
								}

								if (bs.getWriting(inputWritingNo) == null) {
									System.out.println("\n\t- 입력한 번호의 글을 찾을 수 없습니다. -\n");
									continue;
								}
								break;

							}

							while (true) {

								System.out.println(bs.getWriting(inputWritingNo).toString());
								List<Comment> comments = bs.getComment(inputWritingNo);
								System.out.println("");
								for (Comment c : comments) {
									System.out.println(c);
									List<ReComment> recomments = bs.getReComment(c.getCommentNo());
									if (recomments == null) {
										continue;
									}
									for (ReComment rc : recomments) {
										System.out.println(rc);
									}
								}

								int inputWritingMenu = 0;
								while (true) {
									try {
										System.out.print("\n1 수정  2 삭제  3 댓글 등록  4 댓글 수정  5 댓글 삭제  9 뒤로가기    선택 > ");
										inputWritingMenu = scan.nextInt();
										break;
									} catch (InputMismatchException e) {
										System.out.println("\n\t- 숫자를 입력하세요. -");
										scan.next();
										continue;
									}
								}

								if (inputWritingMenu == 1) { // 게시글 수정

									while (true) {

										if (bs.checkUser(loginUser, inputWritingNo) == true) {

											System.out.print("게시글 제목 수정 > ");
											String inputWritingSub = scan.nextLine();
											inputWritingSub = scan.nextLine();

											System.out.println("게시글 수정 (마지막 줄에 -를 입력하여 저장) > ");
											String inputWritingAll = "";
											String inputWriting = "";

											while (scan.hasNext()) {

												if ((inputWriting = scan.nextLine()).equals("-")) {
													break;
												}
												inputWritingAll += (" " + inputWriting + "\r\n");

											}

											Writing writing = new Writing(null, inputWritingNo, inputWritingSub,
													loginUser.getUserId(), inputWritingAll,
													loginUser.getUserNickname());

											if (bs.updatePost(writing) == true) {
												System.out.println("\n\t- 수정 완료! -");
												break;
											} else {
												System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
											}
										} else {
											System.out.println("\n\t- 본인이 작성한 글만 수정할 수 있습니다. -");
										}
										break;

									}

								} else if (inputWritingMenu == 2) { // 게시글 삭제

									if (bs.checkUser(loginUser, inputWritingNo) == true) {

										System.out.print("\n\t 정말로 게시글을 삭제하시겠습니까? (Y/N)  > ");
										String inputAnswer = scan.next();

										if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {

											if (bs.deletePost(inputWritingNo) == true) {

												System.out.println("\t- 삭제 완료! -");
												break;

											} else {
												System.out.println("\t- 정상적으로 처리되지 않았습니다. -");
											}

										} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
											continue;
										} else {
											System.out.println("\t- 잘못 입력하셨습니다. -");
										}

									} else {
										System.out.println("\n\t- 본인이 작성한 글만 삭제할 수 있습니다. -");
									}

								} else if (inputWritingMenu == 3) { // 댓글 등록

									int inputAnswer = 0;

									while (true) {
										try {
											System.out.print("1 새 댓글 등록  2 답글 등록    선택 > ");
											inputAnswer = scan.nextInt();
											break;
										} catch (InputMismatchException e) {
											System.out.println("\n\t- 숫자를 입력하세요. -\n");
											scan.next();
											continue;
										}
									}

									if (inputAnswer == 1) {

										System.out.print("댓글 등록 > ");
										String inputComment = scan.nextLine();
										inputComment = scan.nextLine();

										Comment com = new Comment(inputWritingNo, loginUser.getUserId(), inputComment,
												loginUser.getUserNickname());
										bs.commenting(com);

										System.out.println("\n\t- 새 댓글 등록 완료! -");

									} else if (inputAnswer == 2) {

										int inputCommentNo = 0;

										while (true) {
											try {
												System.out.print("답글을 달 댓글 번호 > ");
												inputCommentNo = scan.nextInt();
												break;
											} catch (InputMismatchException e) {
												System.out.println("\n\t- 숫자를 입력하세요. -\n");
												scan.next();
												continue;
											}
										}

										System.out.print("답글 등록 > ");
										String inputReComment = scan.nextLine();
										inputReComment = scan.nextLine();

										ReComment reCom = new ReComment(loginUser.getUserId(), inputCommentNo,
												inputReComment, loginUser.getUserNickname());
										if (bs.reCommenting(reCom) == true) {
											System.out.println("\n\t- 답글 등록 완료! -");
										} else {
											System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
										}

									} else {
										System.out.println("\n\t- 잘못 입력하셨습니다. -");
									}

								} else if (inputWritingMenu == 4) { // 댓글 수정

									while (true) {

										int inputCommentNo = 0;

										while (true) {
											try {
												System.out.print("수정할 댓글 번호 > ");
												inputCommentNo = scan.nextInt();
												break;
											} catch (InputMismatchException e) {
												System.out.println("\n\t- 숫자를 입력하세요. -\n");
												scan.next();
												continue;
											}
										}

										if (bs.checkUserComment(loginUser, inputCommentNo) == true
												|| bs.checkUserReComment(loginUser, inputCommentNo) == true) {

											System.out.print("댓글 수정 > ");
											String inputComment = scan.nextLine();
											inputComment = scan.nextLine();

											Comment com = new ReComment(inputWritingNo, loginUser.getUserId(),
													inputCommentNo, inputComment);

											if (bs.updateComment(com) == true) {

												System.out.println("\n\t- 댓글 수정 완료! -\n");
												break;

											} else {

												if (bs.updateReComment(com) == true) {
													System.out.println("\n\t- 답글 수정 완료! -\n");
													break;
												} else {
													System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
													break;
												}
											}
										} else {
											System.out.println("\n\t- 본인이 작성한 댓글만 수정할 수 있습니다. -\n");
											continue;
										}

									}

									continue;

								} else if (inputWritingMenu == 5) { // 댓글 삭제

									while (true) {

										int inputCommentNo = 0;

										while (true) {
											try {
												System.out.print("삭제할 댓글 번호 > ");
												inputCommentNo = scan.nextInt();
												break;
											} catch (InputMismatchException e) {
												System.out.println("\n\t- 숫자를 입력하세요. -\n");
												scan.next();
												continue;
											}
										}

										if (bs.checkUserComment(loginUser, inputCommentNo) == true
												|| bs.checkUserReComment(loginUser, inputCommentNo) == true) {

											System.out.print("\n\t 정말로 댓글을 삭제하시겠습니까? (Y/N)  > ");
											String inputAnswer = scan.next();

											if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {

												if (bs.deleteComment(inputCommentNo) == true) {

													System.out.print("\t- 댓글 삭제 완료! -\n");
													break;

												} else {

													if (bs.deleteReComment(inputCommentNo) == true) {

														System.out.print("\t- 댓글 삭제 완료! -\n");
														break;

													} else {
														System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
														break;
													}
												}

											} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
												break;
											}
										} else {
											System.out.println("\n\t- 본인이 작성한 댓글만 삭제할 수 있습니다. -\n");
											continue;
										}

									}
									continue;

								} else if (inputWritingMenu == 9) { // 뒤로가기
									break;
								} else {
									System.out.println("\n\t- 잘못 입력하셨습니다. -\t");
								}
							}

						} else if (inputMenu == 2) { // 게시글 조회

							int inputSelect = 0;
							while (true) {
								try {
									System.out.print("1 말머리 조회  2 제목 조회  3 작성자 조회  4 작성일 조회    선택 > ");
									inputSelect = scan.nextInt();
									break;
								} catch (InputMismatchException e) {
									System.out.println("\n\t- 숫자를 입력하세요. -\n");
									scan.next();
									continue;
								}
							}

							if (inputSelect == 1) {	// 조회 > 말머리 조회
								String selectBoardName = null;
								int inputBoardName = 0;

								System.out.println("\n[ 말머리 조회 ]");
								
								while (true) {
									while (true) {

										try {
											System.out.print("1 일기  2 생활정보  3 맛집정보    선택 > ");
											inputBoardName = scan.nextInt();
											break;
										} catch (InputMismatchException e) {
											System.out.println("\n\t- 숫자를 입력하세요. -\n");
											scan.next();
											continue;
										}
									}

									if (inputBoardName == 1) {
										selectBoardName = "일기";
										break;
									} else if (inputBoardName == 2) {
										selectBoardName = "생활정보";
										break;
									} else if (inputBoardName == 3) {
										selectBoardName = "맛집정보";
										break;
									} else {
										System.out.println("\n\t- 잘못 입력하셨습니다. -\n");
									}
								}
								

								while (true) {

									System.out.println(
											"\n----------------------------------------------------------------");
									System.out.printf(" %-10s%-5s%-15s%-15s%-20s\n", "말머리", "번호", "작성일", "작성자", "제목");
									System.out.println(
											"----------------------------------------------------------------");
									getList = bs.selectListName(selectBoardName);
									for (Writing w : getList) {
										w.writingList();
									}

									selectBoard(getList);
									break;

								}

							} else if (inputSelect == 2) { // 조회 > 제목 조회

								System.out.println("\n[ 제목 조회 ]");
								System.out.print("조회할 단어 입력 > ");
								String inputWord = scan.next();

								while (true) {

									System.out.println(
											"\n----------------------------------------------------------------");
									System.out.printf(" %-10s%-5s%-15s%-15s%-20s\n", "말머리", "번호", "작성일", "작성자", "제목");
									System.out.println(
											"----------------------------------------------------------------");
									getList = bs.selectListSub(inputWord);
									for (Writing w : getList) {
										w.writingList();
									}

									selectBoard(getList);
									break;

								}

							} else if (inputSelect == 3) { // 조회 > 작성자 조회

								System.out.println("\n[ 작성자 조회 ]");
								System.out.print("작성자 닉네임 입력 > ");
								String inputUserNick = scan.next();

								while (true) {

									System.out.println(
											"\n----------------------------------------------------------------");
									System.out.printf(" %-10s%-5s%-15s%-15s%-20s\n", "말머리", "번호", "작성일", "작성자", "제목");
									System.out.println(
											"----------------------------------------------------------------");
									getList = bs.selectListUser(inputUserNick);
									for (Writing w : getList) {
										w.writingList();
									}

									selectBoard(getList);
									break;

								}

							} else if (inputSelect == 4) { // 조회 > 작성일 조회

								System.out.println("\n[ 작성일 조회 ]");
								System.out.print("입력 날짜부터 조회 ex.00-00-00 > ");
								String inputWritingDate1 = scan.next();
								System.out.print("입력 날짜까지 조회 ex.00-00-00 > ");
								String inputWritingDate2 = scan.next();

								while (true) {
									
									System.out.println(
											"\n----------------------------------------------------------------");
									System.out.printf(" %-10s%-5s%-15s%-15s%-20s\n", "말머리", "번호", "작성일", "작성자", "제목");
									System.out.println(
											"----------------------------------------------------------------");
									getList = bs.selectListDate(inputWritingDate1, inputWritingDate2);

									for (Writing w : getList) {
										w.writingList();
									}
									
									selectBoard(getList);
									break;
									
								}

							} else {
								System.out.println("\n\t- 잘못 입력하셨습니다. -");
							}

						} else if (inputMenu == 3) { // 게시글 등록

							String selectBoardName = null;
							while (true) {

								System.out.println("\n[ 게시글 등록 ]");
								int inputBoardName = 0;

								while (true) {
									try {
										System.out.print("1 일기  2 생활정보  3 맛집정보    말머리 선택 > ");
										inputBoardName = scan.nextInt();
										break;
									} catch (InputMismatchException e) {
										System.out.println("\n\t- 숫자를 입력하세요. -\n");
										scan.next();
										continue;
									}
								}

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
									System.out.println("\n\t- 잘못 입력하셨습니다. -\n");
								}
							}

							System.out.print("글 제목 입력 > ");
							String inputWritingSub = scan.nextLine();
							inputWritingSub = scan.nextLine();

							System.out.println("글 입력 (마지막 줄에 -를 입력하여 저장) > ");
							String inputWritingAll = "";
							String inputWriting = "";

							while (scan.hasNext()) {

								if ((inputWriting = scan.nextLine()).equals("-")) {
									break;
								}
								inputWritingAll += (" " + inputWriting + "\r\n");

							}

							Writing writing = new Writing(selectBoardName, inputWritingSub, loginUser.getUserId(),
									inputWritingAll, loginUser.getUserNickname());

							if (bs.insertPost(writing) == true) {
								System.out.println("\n\t- 게시글 등록 완료! -");
							} else {
								System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
							}

						} else if (inputMenu == 4) { // 마이페이지

							while (true) {

								int inputAnswer = 0;

								while (true) {
									try {
										printMyPage();
										inputAnswer = scan.nextInt();
										break;
									} catch (InputMismatchException e) {
										System.out.println("\n\t- 숫자를 입력하세요. -");
										scan.next();
										continue;
									}
								}

								if (inputAnswer == 1) { // 내 정보
									System.out.println(bs.selectMyInfo(loginUser.getUserId()));

									while (true) {
										try {
											System.out.print("\n1 내 정보 수정  2 비밀번호 수정  3 회원 탈퇴  9 뒤로가기    선택 > ");
											inputAnswer = scan.nextInt();
											break;
										} catch (InputMismatchException e) {
											System.out.println("\n\t- 숫자를 입력하세요. -");
											scan.next();
											continue;
										}
									}

									while (true) {

										if (inputAnswer == 1) { // 내 정보 수정

											System.out.println("\n[ 내 정보 수정 ]");
											System.out.print("이름 입력 > ");
											String inputName = scan.next();
											System.out.print("닉네임 입력 > ");
											String inputNickname = scan.nextLine();
											inputNickname = scan.nextLine();
											System.out.print("생년월일 입력 ex.00-00-00 > ");
											String inputBirth = scan.next();
											System.out.print("휴대폰 번호 입력 ex.000-0000-0000 > ");
											String inputPhone = scan.next();
											String[] phoneAry = inputPhone.split("-");
											inputPhone = "";
											for (int i = 0; i < phoneAry.length; i++) {
												inputPhone += phoneAry[i];
											}

											User updateUser = new User(loginUser.getUserId(), inputName, inputBirth,
													inputPhone, inputNickname);

											if (bs.updateMyInfo(updateUser) == true) {
												System.out.println("\n\t- 내 정보 수정 완료! -");
											} else {
												System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
											}
											break;

										} else if (inputAnswer == 2) { // 비밀번호 수정

											System.out.println("\n[ 비밀번호 수정 ]");
											System.out.print("현재 비밀번호 입력 > ");
											String currentPw = scan.next();

											if (bs.checkMyPw(loginUser, currentPw) == true) {

												System.out.print("수정할 비밀번호 입력 > ");
												String changePw = scan.next();
												loginUser.setUserPw(changePw);

												if (bs.updateMyPw(loginUser) == true) {
													cnt = 1;
													System.out.println("\n\t- 비밀번호 수정 완료! -");
													System.out.println("\t- 다시 로그인해 주세요. -");
												} else {
													System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
												}

											} else {
												System.out.println("\n\t- 틀린 비밀번호입니다. -");
											}
											break;

										} else if (inputAnswer == 3) { // 회원 탈퇴

											System.out.print("\n\t정말로 탈퇴하시겠습니까? (Y/N)  > ");
											String inputYesNo = scan.next();

											if (inputYesNo.equals("Y") || inputYesNo.equals("y")) {

												System.out.print("\t비밀번호 입력 > ");
												inputPw = scan.next();

												if (bs.checkMyPw(loginUser, inputPw) == true) {

													bs.deleteUser(loginUser, inputPw);
													cnt = 1;
													System.out.println("\n\t- 회원 탈퇴 완료! -");

												} else {
													System.out.println("\n\t- 틀린 비밀번호입니다. -");
													break;
												}

											} else if (inputYesNo.equals("N") || inputYesNo.equals("n")) {
												break;
											}

											break;

										} else if (inputAnswer == 9) {
											break;
										} else {
											System.out.println("\n\t- 잘못 입력하셨습니다. -\n");
										}
									}

									if (cnt == 1) {
										break;
									}

								} else if (inputAnswer == 2) { // 내 게시글

									while (true) {

										List<Writing> userList = bs.selectMyPost(loginUser);

										System.out.println(
												"\n----------------------------------------------------------------");
										System.out.printf(" %-10s%-5s%-15s%-15s%-20s\n", "말머리", "번호", "작성일", "작성자",
												"제목");
										System.out.println(
												"----------------------------------------------------------------");

										for (Writing w : userList) {
											w.writingList();
										}
										
										selectBoard(userList);
										break;

									}
								} else if (inputAnswer == 3) { // 내 댓글

									List<Comment> getCommentList = bs.selectMyComment(loginUser);

									System.out.println(
											"\n----------------------------------------------------------------");
									System.out.println(" 글 번호\t댓글 번호\t작성일\t\t댓글");
									System.out.println(
											"----------------------------------------------------------------");

									for (Comment c : getCommentList) {
										System.out.println(c.printMyComment());
									}

									while (true) {

										inputAnswer = 0;

										while (true) {
											try {
												System.out.print("\n9 뒤로가기 > ");
												inputAnswer = scan.nextInt();
												break;
											} catch (InputMismatchException e) {
												System.out.println("\n\t- 숫자를 입력하세요. -");
												scan.next();
												continue;
											}
										}

										if (inputAnswer == 9) {
											break;
										} else {
											System.out.println("\n\t- 잘못 입력하셨습니다. -");
										}
									}

								} else if (inputAnswer == 9) {
									break;
								} else {
									System.out.println("\n\t- 잘못 입력하셨습니다. -\n");
								}
							}

						} else if (inputMenu == 9) { // 로그아웃
							cnt = 1;
							break;
						} else {
							System.out.println("\n\t- 잘못 입력하셨습니다. -");
						}

						if (cnt == 1) {
							break;
						}

					} // end of while

				} else {
					System.out.println("\n\t- 입력한 아이디, 비밀번호를 찾을 수 없습니다. -");
					continue;
				}
				
				if (cnt == 1) {
					break;
				}

			} else if (inputLogin == 2) { // 회원가입

				while (true) {
					System.out.println("\n[ 회원가입 ]");
					System.out.print("아이디 입력 > ");
					String inputId = scan.next();

					if (bs.checkUser(inputId) == true) {
						System.out.println("\n\t- 중복된 아이디가 있습니다. -\n");
					} else {

						System.out.print("비밀번호 입력 > ");
						String inputPw = scan.next();
						System.out.print("이름 입력 > ");
						String inputName = scan.next();
						System.out.print("닉네임 입력 > ");
						String inputNickname = scan.nextLine();
						inputNickname = scan.nextLine();
						System.out.print("생일 입력 ex.00-00-00 > ");
						String inputBirth = scan.next();

						System.out.print("휴대폰 번호 입력 ex.000-0000-0000 > ");
						String inputPhone = scan.next();
						String[] phoneAry = inputPhone.split("-");
						inputPhone = "";
						for (int i = 0; i < phoneAry.length; i++) {
							inputPhone += phoneAry[i];
						}

						User newUser = new User(inputId, inputPw, inputName, inputBirth, inputPhone, inputNickname);
						if (bs.insertUser(newUser) == true) {

							System.out.println("\n\t- 회원가입 완료! -");

						} else {

							System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");

						}
						break;
					}

				}

			} else if (inputLogin == 3) { // 비밀번호 찾기

				System.out.println("\n[ 비밀번호 찾기 ]");
				System.out.print("비밀번호를 찾고자하는 아이디 입력 > ");
				String inputUserId = scan.next();

				User user = bs.selectMyInfo(inputUserId);

				if (user == null) {
					System.out.println("\n\t- 해당하는 아이디가 없습니다. -");
				} else {

					System.out.print("이름 입력 > ");
					String inputName = scan.next();
					System.out.print("생년월일 입력 ex.00-00-00 > ");
					String inputBirth = scan.next();

					System.out.print("휴대폰 번호 입력 ex.000-0000-0000 > ");
					String inputToPhone = scan.next();

					String[] phoneAry = inputToPhone.split("-");
					inputToPhone = "";
					for (int i = 0; i < phoneAry.length; i++) {
						inputToPhone += phoneAry[i];
					}

					if (user.getUserPhone().equals(inputToPhone) && user.getUserName().equals(inputName)
							&& user.getUserBirth().subSequence(2, 10).equals(inputBirth)) {

						SendExample.sendPwSms(inputToPhone, inputUserId);

					} else {
						System.out.println("\n\t- 정보가 일치하지 않습니다. -");
					}

				}

			} else if (inputLogin == 9) { // 프로그램 종료
				break;

			} else {
				System.out.println("\n\t- 잘못 입력하셨습니다. -");
				continue;
			}
			
			

		}

		System.out.println("End of Program");

	} // end of main()

	public void printLogin() {
		String str = "\n-------------\n" //
				+ " 1 로그인\n" //
				+ " 2 회원가입\n" //
				+ " 3 비밀번호 찾기\n" //
				+ " 9 종료\n" //
				+ "-------------\n" //
				+ "선택 > ";
		System.out.print(str);
	}

	public void printMyPage() {
		String str = "\n-------------\n" //
				+ " 마이페이지\n" //
				+ "-------------\n" //
				+ " 1 내 정보\n" //
				+ " 2 내 게시글\n" //
				+ " 3 내 댓글\n" //
				+ " 9 돌아가기\n" //
				+ "-------------\n" //
				+ "선택 > ";
		System.out.print(str);
	}
	
	
	public void selectBoard(List<Writing> getList) {
		int inputAnswer = 0;
		while (true) {
			try {
				System.out.print("\n1 게시글 상세보기  9 뒤로가기    선택 > ");
				inputAnswer = scan.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("\n\t- 숫자를 입력하세요. -");
				scan.next();
				continue;
			}
		}

		if (inputAnswer == 1) {

			int inputWritingNo = 0;
			while (true) {

				while (true) {
					try {
						System.out.print("글 번호 입력 > ");
						inputWritingNo = scan.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("\n\t- 숫자를 입력하세요. -\n");
						scan.next();
						continue;
					}
				}

				if (bs.getWriting(inputWritingNo) == null) {

					System.out.println("\n\t- 입력한 번호의 글을 찾을 수 없습니다. -\n");
					continue;

				} else if (bs.getWriting(inputWritingNo) != null) {

					int writingNo = 0;
					for (Writing w : getList) {
						if (w.getWritingNo() == inputWritingNo) {
							writingNo = w.getWritingNo();
							break;
						}
					}

					if (writingNo == 0) {
						System.out.println("\n\t- 입력한 번호의 글을 찾을 수 없습니다. -\n");
						continue;
					} 

				}
				

				System.out.println(bs.getWriting(inputWritingNo).toString());
				List<Comment> comments = bs.getComment(inputWritingNo);
				System.out.println("");
				for (Comment c : comments) {
					System.out.println(c);
					List<ReComment> recomments = bs.getReComment(c.getCommentNo());
					if (recomments == null) {
						continue;
					}
					for (ReComment rc : recomments) {
						System.out.println(rc);
					}
				}

				while (true) {
					int inputMenu = 0;
					while (true) {
						try {
							System.out.print("\n1 수정  2 삭제  9 뒤로가기    선택 > ");
							inputMenu = scan.nextInt();
							break;
						} catch (InputMismatchException e) {
							System.out.println("\n\t- 숫자를 입력하세요. -");
							scan.next();
							continue;
						}
					}
					
					if (inputMenu == 1) { // 게시글 상세보기 > 수정
						
						if (bs.checkUser(loginUser, inputWritingNo) == true) {
							
							System.out.print("게시글 제목 수정 > ");
							String inputWritingSub = scan.nextLine();
							inputWritingSub = scan.nextLine();
							
							System.out.println("게시글 수정 (마지막 줄에 -를 입력하여 저장) > ");
							String inputWritingAll = "";
							String inputWriting = "";
							
							while (scan.hasNext()) {
								
								if ((inputWriting = scan.nextLine()).equals("-")) {
									break;
								}
								inputWritingAll += (" " + inputWriting + "\r\n");
								
							}
							
							Writing writing = new Writing(null, inputWritingNo, inputWritingSub,
									loginUser.getUserId(), inputWritingAll,
									loginUser.getUserNickname());
							
							if (bs.updatePost(writing) == true) {
								System.out.println("\n\t- 수정 완료! -");
								break;
							} else {
								System.out.println("\n\t- 정상적으로 처리되지 않았습니다. -");
								break;
							}
						} else {
							System.out.println("\n\t- 본인이 작성한 글만 수정할 수 있습니다. -");
							break;
						}
						
					} else if (inputMenu == 2) { // 게시글 상세보기 > 삭제
						
						if (bs.checkUser(loginUser, inputWritingNo) == true) {
							
							while (true) {
								
								System.out.print("\n\t 정말로 게시글을 삭제하시겠습니까? (Y/N)  > ");
								String inputYesNo = scan.next();
								
								if (inputYesNo.equals("Y") || inputYesNo.equals("y")) {
									
									if (bs.deletePost(inputWritingNo) == true) {
										
										System.out.println("\t- 삭제 완료! -");
										break;
										
									} else {
										System.out.println("\t- 정상적으로 처리되지 않았습니다. -");
										break;
									}
									
								} else if (inputYesNo.equals("N") || inputYesNo.equals("n")) {
									break;
								} else {
									System.out.println("\t- 잘못 입력하셨습니다. -");
								}
								
							}
							break;
							
						} else {
							System.out.println("\n\t- 본인이 작성한 글만 삭제할 수 있습니다. -");
							continue;
						}
					}  else if (inputMenu == 9) { // 게시글 상세보기 > 뒤로가기
						break;
					} else {
						System.out.println("\n\t- 잘못 입력하셨습니다. -");
					}
				}
				break;
			} 

		} else if (inputAnswer == 9) { // 말머리 조회 > 뒤로가기
			return;
		} else {
			System.out.println("\n\t- 잘못 입력하셨습니다. -");
		}
	}

}
