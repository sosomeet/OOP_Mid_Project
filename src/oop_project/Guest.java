package oop_project;

public class Guest extends Restaurant {
	private String name; // 손님의 이름
	private int category; // 손님의 유형 0 = 평범, 1 = 대식가, 2 = 신메뉴
	private int selectMenuIndex; // 손님이 선택한 메뉴의 index
	private int selectMenuCount; // 손님이 선택한 메뉴의 개수

	// 기본 생성자
	Guest() {
		this.name = "";
		this.category = 0;
		this.selectMenuCount = 0;
		this.selectMenuCount = 0;
	}

	// n명 생성되는 손님 생성자 오버로딩
	Guest(int menuLen) {
		this.category = (int) (Math.random() * 3); // 무작위 유형 설정
		AddGuest("", menuLen, this.category);

	}

	// 이름이 설정된 생성자 오버로딩
	Guest(String name, int menuLen) {
		AddGuest(name, menuLen, this.category);

	}

	// 이름과 손님 유형이 설정된 생성자 오버로딩
	Guest(String name, int menuLen, int category) {
		AddGuest(name, menuLen, category);
	}

	// 손님 추가 함수
	public void AddGuest(String name, int menuLen, int category) {
		boolean isCreated = false; // 손님이 추가되었는지 확인

		while (!isCreated) { // 손님이 추가될 때 까지 반복

			if (name.equals("")) { // 이름이 설정되지 않았을 경우
				if (category == 0) { // 평범한 손님, 1~2개 주문
					this.name = "평범한 손님";
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 2) + 1;
					isCreated = true;
				}

				else if (category == 1) { // 대식가 손님, 2~5개 주문
					this.name = "대식가 손님";
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 4) + 2;
					isCreated = true;
				}

				else if (category == 2) { // 신메뉴 요구 손님, 새로운 메뉴 제작
					this.category = (int) (Math.random() * 3); // 신메뉴 요구 손님의 확률 조정 코드 1/3 * 1/3 = 1/9 확률로 등장
					if (category == 2) {
						this.name = "신메뉴 손님";
						this.selectMenuIndex = (int) (Math.random() * menuLen);
						this.selectMenuCount = 1;
						isCreated = true;
					} else {
						isCreated = false;
					}
				}
			} else { // 이름이 설정됐을 경우
				if (category == 0) {
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 2) + 1;
					isCreated = true;
				}

				else if (category == 1) {
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 4) + 2;
					isCreated = true;
				}

				else if (category == 2) {
					this.category = (int) (Math.random() * 3);
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = 1;
					isCreated = true;
				}
			}
		}

		return;
	}

	// 손님 이름 반환
	public String GetName() {
		return this.name;
	}

	// 손님 유형 반환
	public int GetCategory() {
		return this.category;
	}

	// 손님이 선택한 메뉴의 인덱스 반환
	public int GetSelectMenuIndex() {
		return this.selectMenuIndex;
	}

	// 손님이 선택한 메뉴의 이름 반환
	public String GetSelectMenuName(Menu[] menuList) {
		return menuList[this.selectMenuIndex].GetName();
	}

	// 손님이 선택한 메뉴의 개수 반환
	public int GetSelectCount() {
		return this.selectMenuCount;
	}

	// 간단한 손님 리스트 출력
	// 손님 n명
	// 메뉴명 n개
	public void PrintGuestListSimple(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("손님 " + guestLen + "명");
		for (int i = 0; i < guestLen; i++) {
			System.out.println(guestList[i].GetSelectMenuName(menuList) + " " + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		
		return;
	}

	// 기본 손님 리스트 출력
	// 손님 n명
	// 손님 이름 : 메뉴명 n개
	public void PrintGuestList(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("손님 " + guestLen + "명");
		for (int i = 0; i < guestLen; i++) {
			System.out.println(guestList[i].GetName() + " : " + guestList[i].GetSelectMenuName(menuList) + " "
					+ guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		
		return;
	}

	// 자세한 손님 리스트 출력
	// 손님 n명
	// 손님 이름 유형 : n	메뉴명 n개
	public void PrintGuestListDetail(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("손님 " + guestLen + "명");
		for (int i = 0; i < guestLen; i++) {
			System.out.print(guestList[i].GetName() + " 유형 : " + guestList[i].GetCategory() + " \t");
			System.out.println(guestList[i].GetSelectMenuName(menuList) + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		
		return;
	}

}
