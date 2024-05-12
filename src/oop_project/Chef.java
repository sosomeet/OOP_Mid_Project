package oop_project;

public class Chef extends Restaurant {

	private String name; // 셰프 이름
	private String rank; // 셰프 등급
	private boolean[] cookableMenu; // 요리 가능한 메뉴 리스트

	// 기본 생성자
	Chef() {
		InitChef("0", 0, 0);
	}

	// 이름이 설정된 생성자 오버로딩
	Chef(String name, int menuLen) {
		int rank = (int) (Math.random() * 4);
		InitChef(name, rank, menuLen);
	}

	// 이름과 등급이 설정된 생성자 오버로딩
	Chef(String name, int menuLen, int rank) {
		InitChef(name, rank, menuLen);
	}

	// 셰프 초기화 함수
	public void InitChef(String name, int rank, int menuLen) {
		// 등급에 따른 셰프 유형 초기화

		// 오너셰프 : 모든 요리 가능
		if (rank == 0) {
			this.name = name;
			this.rank = "오너셰프";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}
		}

		// 매니저 : 1개 빼고 가능
		else if (rank == 1) {
			this.name = name;
			this.rank = "매니저";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableMenu[temp] = false;
		}

		// 견습생 : 메뉴 절반 가능
		else if (rank == 2) {
			this.name = name;
			this.rank = "견습생";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}

			// 메뉴 절반만 가능하게 만드는 코드
			boolean[] randCookableList = new boolean[this.cookableMenu.length];
			int randCount = 0;
			
			while (true) {
				for (int i = 0; i < this.cookableMenu.length; i++) {
					if ((int) (Math.random() * menuLen) == 0) {
						randCookableList[i] = false;
					} else {
						randCookableList[i] = true;
						randCount++;
					}
				}
				
				// 메뉴 절반만 가능하다면
				if(randCount != (int) (this.cookableMenu.length / 2)) {
					break;
				}
				else {
					randCount = 0;
				}
			}
			
			this.cookableMenu = randCookableList;
		}

		// 아르바이트 : 메뉴 1개 가능
		else if (rank == 3) {
			this.name = name;
			this.rank = "아르바이트";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = false;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableMenu[temp] = true;
		}

		return;
	}

	// 요리 가능한 메뉴 출력
	public void PrintCookableMenu(Menu[] menuList, int menuLen) {
		System.out.print(this.name + "가 요리 가능한 메뉴 : ");
		for (int i = 0; i < menuLen; i++) {
			if (this.cookableMenu[i]) {
				System.out.print(menuList[i].GetName() + " ");
			}
		}
		System.out.println();
		return;
	}

	
	// 셰프의 이름 반환
	public String GetName() {
		return this.name;
	}
	
	// 셰프의 등급 반환
	public String GetRank() {
		return this.rank;
	}

	// 셰프가 가능한 요리인지 확인
	public boolean IsCookable(int guestSelectMenuIndex) {
		boolean isCookable = false;

		if (this.cookableMenu[guestSelectMenuIndex]) {
			isCookable = true;
		}

		return isCookable;
	}

	// 기본 셰프 출력
	// 이름 : 등급
	public void PrintChef(Chef chef, int chefLen) {
		System.out.println(chef.GetName() + " " + chef.GetRank());
		return;
	}

	// 자세한 셰프 출력
	// 이름 : 등급, 요리 가능한 메뉴
	public void PrintChefDetail(Chef chef, Menu[] menuList) {
		System.out.println(chef.GetName() + " " + chef.GetRank() + ",");
		chef.PrintCookableMenu(menuList, menuList.length);
		return;
	}

	// 0번 손님이 주문한 메뉴를 직원이 요리
	public boolean Cook(Restaurant restaurant, Menu[] menuList, Guest[] guestList) {
		if (this.IsCookable(guestList[0].GetSelectMenuIndex())) {
			restaurant.AdjustItemStock(menuList[guestList[0].GetSelectMenuIndex()].GetUseItemList());
			restaurant.SetItemStock();
			System.out.println(guestList[0].GetSelectMenuName(menuList) + "는 " + this.name + "이 요리합니다.");
			return true;
		}

		return false;
	}

}
