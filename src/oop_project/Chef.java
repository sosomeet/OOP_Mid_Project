package oop_project;

public class Chef extends Restaurant {

	private String name;
	private String rank;
	private boolean[] cookableMenu;

	Chef() {
		AddChef("0", 0, 0);
	}

	Chef(String name, int menuLen) {
		int rank = (int) (Math.random() * 4);
		AddChef(name, rank, menuLen);
	}

	Chef(String name, int menuLen, int rank) {
		AddChef(name, rank, menuLen);
	}

	public void AddChef(String name, int rank, int menuLen) {
		if (rank == 0) {
			this.name = name;
			this.rank = "오너셰프";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}
		}

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

		else if (rank == 2) {
			this.name = name;
			this.rank = "견습생";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableMenu[temp] = false;
			int temp2 = (int) (Math.random() * menuLen);
			while (temp2 == temp) {
				temp2 = (int) (Math.random() * menuLen);
			}
			this.cookableMenu[temp2] = false;
		}

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

	public String GetRank() {
		return this.rank;
	}

	public String GetName() {
		return this.name;
	}

	public boolean IsCookable(int guestSelectMenuIndex) {
		boolean isCookable = false;

		if (this.cookableMenu[guestSelectMenuIndex]) {
			isCookable = true;
		}

		return isCookable;
	}

	public void PrintChefList(Chef chef, int chefLen) {
		System.out.println(chef.GetName() + " " + chef.GetRank());
		return;
	}

	public void PrintChefListDetail(Chef chef, Menu[] menuList) {
		System.out.println(chef.GetName() + " " + chef.GetRank());
		chef.PrintCookableMenu(menuList, menuList.length);
		return;
	}

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