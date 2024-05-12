package oop_project;

public class Main {

	// 메뉴 추가하는 함수
	public static Menu[] AddMenu(String name, Menu[] menuList) {
		Menu[] newMenuList = new Menu[menuList.length + 1]; // 기존보다 크기가 1큰 리스트
		int i;
		for (i = 0; i < menuList.length; i++) { // 기존 메뉴 추가
			newMenuList[i] = menuList[i];
		}
		newMenuList[i] = new Menu(name); // 신규 메뉴 추가
		menuList = newMenuList; // 메뉴리스트 갱신

		return menuList;
	}

	// 셰프를 이름을 입력받고 추가하는 함수 오버로딩
	public static Chef[] AddChef(String name, Chef[] chefList, int menuLen) {
		Chef[] newchefList = new Chef[chefList.length + 1]; // 기존보다 크기가 1큰 리스트
		int i;
		for (i = 0; i < chefList.length; i++) { // 기존 셰프 추가
			newchefList[i] = chefList[i];
		}
		newchefList[i] = new Chef(name, menuLen); // 신규 셰프 추가
		chefList = newchefList; // 셰프리스트 갱신

		return chefList;
	}

	// 셰프를 이름과 등급을 입력받고 추가하는 함수 오버로딩
	public static Chef[] AddChef(String name, int rank, Chef[] chefList, int menuLen) {
		Chef[] newChefList = new Chef[chefList.length + 1]; // 기존보다 크기가 1큰 리스트
		int i;
		for (i = 0; i < chefList.length; i++) { // 기존 셰프 추가
			newChefList[i] = chefList[i];
		}
		newChefList[i] = new Chef(name, menuLen, rank); // 신규 셰프 추가
		chefList = newChefList; // 셰프리스트 갱신

		return chefList;
	}

	// 손님의 이름을 입력받고 추가하는 함수 오버로딩
	public static Guest[] AddGuest(String name, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + 1]; // 기존보다 크기가 1큰 리스트
		int i;
		for (i = 0; i < guestList.length; i++) { // 기존 손님 추가
			newGuestList[i] = guestList[i];
		}
		newGuestList[i] = new Guest(name, menuLen); // 신규 손님 추가
		guestList = newGuestList; // 손님 리스트 갱신

		return guestList;
	}

	// 손님의 이름과 유형을 입력받고 추가하는 함수 오버로딩
	public static Guest[] AddGuest(String name, int category, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + 1]; // 기존보다 크기가 1큰 리스트
		int i;
		for (i = 0; i < guestList.length; i++) { // 기존 손님 추가
			newGuestList[i] = guestList[i];
		}
		newGuestList[i] = new Guest(name, menuLen, category); // 신규 손님 추가
		guestList = newGuestList; // 손님 리스트 갱신

		return guestList;
	}

	// 손님을 n명 추가하는 함수 오버로딩
	public static Guest[] AddGuest(int count, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + count]; // 기존보다 크기가 count만큼 큰 리스트
		for (int i = 0; i < guestList.length; i++) { // 기존 손님 추가
			newGuestList[i] = guestList[i];
		}

		for (int i = guestList.length; i < guestList.length + count; i++) { // 신규 손님 n명 추가
			newGuestList[i] = new Guest(menuLen);
		}
		guestList = newGuestList; // 손님 리스트 갱신

		return guestList;
	}

	// 손님을 n명 감소하는 함수 오버로딩
	public static Guest[] LeaveGuest(int count, Restaurant restaurant, Guest[] guestList, Menu[] menuList) {
		Guest[] newGuestList = new Guest[guestList.length - count]; // 기존보다 크기가 count만큼 작은 리스트
		for (int i = 0; i < count; i++) { // 메뉴 가격 * 메뉴 개수 만큼의 수익 추가
			restaurant.AdjustIncome(
					menuList[guestList[i].GetSelectMenuIndex()].GetPrice() * guestList[i].GetSelectCount());
		}

		for (int i = count; i < guestList.length; i++) { // count부터 기존 손님 추가
			newGuestList[i] = guestList[i];
		}
		guestList = newGuestList; // 손님 리스트 갱신

		return guestList;
	}

	// 기본 메뉴 출력
	public static void PrintMenuList(Menu[] menuList, Restaurant restaurant) {
		System.out.println("메뉴 " + menuList.length + "개");
		for (int i = 0; i < menuList.length; i++) { // 메뉴 이름 출력
			menuList[i].PrintMenu(restaurant.GetItemNameList());
		}
		System.out.println();
		
		return;
	}

	// 자세한 메뉴 출력
	public static void PrintMenuListDetail(Menu[] menuList, Restaurant restaurant) {
		System.out.println("메뉴 " + menuList.length + "개");
		for (int i = 0; i < menuList.length; i++) { // 메뉴 이름과 들어가는 재료 개수 출력
			menuList[i].PrintMenuDetail(restaurant.GetItemNameList());
		}
		System.out.println();
		
		return;
	}

	// 기본 셰프 출력
	public static void PrintChefList(Chef[] chefList) {
		System.out.println("직원 " + chefList.length + "명");
		for (int i = 0; i < chefList.length; i++) { // 셰프 이름과 유형 출력
			chefList[i].PrintChef(chefList[i], chefList.length);
		}
		System.out.println();
		
		return;
	}

	// 자세한 셰프 출력
	public static void PrintChefListDetail(Chef[] chefList, Menu[] menuList) {
		System.out.println("직원 " + chefList.length + "명");
		for (int i = 0; i < chefList.length; i++) { // 셰프 이름과 유형, 요리 가능한 메뉴 출력
			chefList[i].PrintChefDetail(chefList[i], menuList);
		}
		System.out.println();
		
		return;
	}

	// 간단한 손님 출력
	public static void PrintGuestListSimple(Guest[] guestList, Menu[] menuList) {
		System.out.println("손님 " + guestList.length + "명");
		for (int i = 0; i < guestList.length; i++) {
			// 손님이 고른 음식과 개수 출력
			System.out.println(guestList[i].GetSelectMenuName(menuList) + " " + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		return;
	}

	// 기본 손님 출력
	public static void PrintGuestList(Guest[] guestList, Menu[] menuList) {
		System.out.println("손님 " + guestList.length + "명");
		for (int i = 0; i < guestList.length; i++) {
			// 손님의 이름 : 고른 음식과 개수 출력
			System.out.println(guestList[i].GetName() + " : " + guestList[i].GetSelectMenuName(menuList) + " "
					+ guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		
		return;
	}
	
	// 자세한 손님 출력
	public static void PrintGuestListDetail(Guest[] guestList, Menu[] menuList) {
		System.out.println("손님 " + guestList.length + "명");
		for (int i = 0; i < guestList.length; i++) {
			// 손님의 이름 유형 : n	고른 음식과 개수 출력
			System.out.print(guestList[i].GetName() + " 유형 : " + guestList[i].GetCategory() + " \t");
			System.out.println(guestList[i].GetSelectMenuName(menuList) + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		
		return;
	}

	//손님이 주문한 요리 제작
	public static Guest[] Cook(int cooked, Restaurant restaurant, Menu[] menuList, Chef[] chefList, Guest[] guestList) {
		for (int k = 0; k <= cooked; k++) { // n명 요리 제작
			for (int i = 0; i < chefList.length; i++) { // 요리 가능한 셰프
				// 요리 가능한 셰프 확인
				if (chefList[i].Cook(restaurant, menuList, guestList)) {
					// 요리 가능하다면 손님이 떠남
					guestList = LeaveGuest(1, restaurant, guestList, menuList);
					break;
				}
			}
		}

		return guestList; // 손님 리스트 반환
	}

	public static void main(String[] args) {
		// 시간
		int turn = 0;

		// 레스토랑
		Restaurant restaurant = new Restaurant();

		// 메뉴 리스트
		Menu[] menuList = new Menu[0];

		// 셰프 리스트
		Chef[] chefList = new Chef[0];

		// 손님 리스트
		Guest[] guestList = new Guest[0];

	}

}
