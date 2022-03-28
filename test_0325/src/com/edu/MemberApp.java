package com.edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MemberApp {

	static Scanner scan = new Scanner(System.in);
	static List<Member> members = new ArrayList<Member>();

	class MemberServiceImpl implements MemberService {

		MemberServiceImpl() {
			try {
				FileReader fr = new FileReader("member_list.data");
				BufferedReader br = new BufferedReader(fr);
				
				String readMem = null;
				while ((readMem = br.readLine()) != null) {
					String[] contents = readMem.split(","); // , 단위로 분리
					if (contents[0].equals("도서반")) {
						members.add( //
								new BookMember(Integer.parseInt(contents[1]), //
											contents[2], //
											contents[3], //
											contents[4], //
											contents[5] //
											));
					} else if (contents[0].equals("축구반")) {
						members.add( //
								new SoccerMember(Integer.parseInt(contents[1]), //
											contents[2], //
											contents[3], //
											contents[4], //
											contents[5] //
											));
					} else if (contents[0].equals("수영반")) {
						members.add( //
								new SwimMember(Integer.parseInt(contents[1]), //
											contents[2], //
											contents[3], //
											contents[4], //
											contents[5] //
											));
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public Member getMember(int memberId) {
			for (int i = 0; i < members.size(); i++) {
				if (memberId == members.get(i).getMemberId()) {
					return members.get(i);
				}
			}
			return null;
		}

		@Override
		public void addMember(Member member) {
			members.add(member);
			System.out.println("\n[ 등록 완료 ]\n");
		}

		@Override
		public void modifyMember(Member member) {
			for (int i = 0; i < members.size(); i++) {
				if (members.get(i).getMemberId() == member.getMemberId()) {
					Member changeMem = members.get(i);
					changeMem.setPhone(member.getPhone());
					System.out.println("\n[ 수정 완료 ]\n");
					return;
				}
			}
			System.out.println("\n조회되는 학생 번호가 없습니다.\n");
		}

		@Override
		public List<Member> memberList() {

			return members;
		}

		public void saveToFile() {

			List<Member> searchList = memberList();

			try {
				FileWriter fw = new FileWriter("member_list.data");
				BufferedWriter bw = new BufferedWriter(fw);

				for (Member m : searchList) {
					
					if (m instanceof BookMember) {
						BookMember bookMem = (BookMember) m;
						bw.write(bookMem.getTeam() + "," //
								+ bookMem.getMemberId() + "," //
								+ bookMem.getMemberName() + "," //
								+ bookMem.getPhone() + "," //
								+ bookMem.getLeaderName() + "," //
								+ bookMem.getClassName() + "\n");
					} else if (m instanceof SoccerMember) {
						SoccerMember soccerMem = (SoccerMember) m;
						bw.write(soccerMem.getTeam() + "," //
								+ soccerMem.getMemberId() + "," //
								+ soccerMem.getMemberName() + "," //
								+ soccerMem.getPhone() + "," //
								+ soccerMem.getTeacherName() + "," //
								+ soccerMem.getLocker() + "\n");
					} else if (m instanceof SwimMember) {
						SwimMember swimMem = (SwimMember) m;
						bw.write(swimMem.getTeam() + "," //
								+ swimMem.getMemberId() + "," //
								+ swimMem.getMemberName() + "," //
								+ swimMem.getPhone() + "," //
								+ swimMem.getTeacherName() + "," //
								+ swimMem.getGrade() + "\n");
					}
				}
			
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void execute() {
		// 메뉴: 1.등록 2.수정 3.전체리스트 9.종료

		MemberServiceImpl service = new MemberServiceImpl();

//		Member member1 = new BookMember(101, "지수빈", "010-1234-1234", "서강준", "예담실");
//		Member member2 = new SwimMember(102, "지수빈", "010-1234-1234", "서강준", "예담실");
//		Member member3 = new SoccerMember(103, "지수빈", "010-1234-1234", "서강준", "예담실");
//		Member member4 = new SwimMember(104, "지수빈", "010-1234-1234", "서강준", "예담실");
//		Member member5 = new SoccerMember(105, "지수빈", "010-1234-1234", "서강준", "예담실");
//		
//		members.add(member1);
//		members.add(member2);
//		members.add(member3);
//		members.add(member4);
//		members.add(member5);
	
		while (true) {
			printMenu();
			int inputMenu = scan.nextInt();

			if (inputMenu == 1) {
				// 1. 학생 등록
				// 학생 번호, 이름, 휴대폰 번호, 부서 입력
				// 도서반(반장, 강의실), 축구반(코치, 락커룸), 수영반(코치, 수영등급) 각 정보 입력

				int memberId = 0;
				while (true) {
					try {
						System.out.print("학생 번호 입력 > ");
						memberId = scan.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("\n유효하지 않은 값입니다.\n");
						scan.next();
						continue;
					}
				}

				System.out.print("이름 입력 > ");
				String memberName = scan.next();
				System.out.print("휴대폰 번호 입력 > ");
				String phone = scan.next();

				System.out.print("부서 선택 > 1:도서반 2:축구반 3:수영반 > ");
				int inputClass = scan.nextInt();

				// 1.1. 도서반에 학생 등록
				if (inputClass == 1) {

					System.out.print("반장 이름 입력 > ");
					String leaderName = scan.next();
					System.out.print("강의실 이름 입력 > ");
					String className = scan.next();

					Member member = new BookMember(memberId, memberName, phone, leaderName, className);
					service.addMember(member);

					// 1.2. 축구반에 학생 등록
				} else if (inputClass == 2) {

					System.out.print("코치 이름 입력 > ");
					String teacherName = scan.next();
					System.out.print("락커룸 이름 입력 > ");
					String locker = scan.next();

					Member member = new SoccerMember(memberId, memberName, phone, teacherName, locker);
					service.addMember(member);

					// 1.3. 수영반에 학생 등록
				} else if (inputClass == 3) {

					System.out.print("코치 이름 입력 > ");
					String teacherName = scan.next();
					System.out.print("수영등급 입력 > ");
					String grade = scan.next();

					Member member = new SwimMember(memberId, memberName, phone, teacherName, grade);
					service.addMember(member);
				}

			} else if (inputMenu == 2) {
				// 2. 수정 (휴대폰 번호)

				System.out.print("수정할 학생 번호 입력 > ");
				int inputId = scan.nextInt();
				System.out.print("휴대폰 번호 수정 > ");
				String phone = scan.next();

				Member newMem = new Member(inputId, null, phone);

				service.modifyMember(newMem);

			} else if (inputMenu == 3) {
				// 3. 리스트 출력

				System.out.print("조회할 부서 선택 > 1:도서반 2:축구반 3:수영반 > ");
				int inputClass = scan.nextInt();

				List<Member> searchList = service.memberList();

				// 3.1. 도서반 리스트 출력
				if (inputClass == 1) {

					for (int i = 0; i < searchList.size(); i++) {
						if (searchList.get(i) instanceof BookMember) {
							System.out.println(searchList.get(i).toString());
						}
					}

					// 3.2. 축구반 리스트 출력
				} else if (inputClass == 2) {

					for (int i = 0; i < searchList.size(); i++) {
						if (searchList.get(i) instanceof SoccerMember) {
							System.out.println(searchList.get(i).toString());
						}
					}

					// 3.3. 수영반 리스트 출력
				} else if (inputClass == 3) {

					for (int i = 0; i < searchList.size(); i++) {
						if (searchList.get(i) instanceof SwimMember) {
							System.out.println(searchList.get(i).toString());
						}
					}
				}

			} else if (inputMenu == 4) {
				service.saveToFile();
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

		}

		System.out.println("end of program");
	}

	public void printMenu() {
		String str = "--------------------------------\r\n" //
				+ " 1. 등록  2. 수정  3. 리스트  4. 종료\r\n" //
				+ "--------------------------------\r\n" + "선택 > ";
		System.out.print(str);
	}
}
