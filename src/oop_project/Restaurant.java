package oop_project;

class Restaurant {
	private static String[] itemNameList = { "타코", "소스", "고기", "치즈", "채소", "보울", "브리또" };

	private static int itemLen;
	private int[] itemPriceList;
	private int[] itemStockList;

	private static int income;

	private Menu[] menuList;
	private int menuLen;

	private Chef[] chefList;
	private int chefLen;

	private Guest[] guestList;
	private int guestLen;

	Restaurant() {
		itemLen = itemNameList.length;
		this.itemPriceList = new int[itemLen];
		this.itemStockList = new int[itemLen];

		for (int i = 0; i < itemLen; i++) {
			this.itemPriceList[i] = 100;
			this.itemStockList[i] = 50;
		}

		income = 0;

		this.menuLen = 0;
		this.menuList = new Menu[this.menuLen];

		this.chefLen = 0;
		this.chefList = new Chef[this.chefLen];

		this.guestLen = 0;
		this.guestList = new Guest[this.guestLen];
	}

	public void PrintRestaurant() {
		for (int i = 0; i < itemLen; i++) {
			System.out
					.println("[" + itemNameList[i] + "] " + this.itemPriceList[i] + "원, 재고 : " + this.itemStockList[i]);
		}
		System.out.println("수익 : " + income);
		System.out.println();
		return;
	}

	public void PrintMenuList() {
		System.out.println("메뉴 " + this.menuLen + "개");
		for (int i = 0; i < this.menuLen; i++) {
			this.menuList[i].PrintItem(itemNameList);
		}
		System.out.println();
		return;
	}

	public void PrintMenuListDetail() {
		System.out.println("메뉴 " + this.menuLen + "개");
		for (int i = 0; i < this.menuLen; i++) {
			this.menuList[i].PrintItemDetail(itemNameList);
		}
		System.out.println();
		return;
	}

	public void PrintChefList() {
		System.out.println("직원 " + this.chefLen + "명");
		for (int i = 0; i < this.chefLen; i++) {
			System.out.println(chefList[i].GetName() + " " + chefList[i].GetRank());
		}
		System.out.println();
		return;
	}

	public void PrintChefListDetail() {
		System.out.println("직원 " + this.chefLen + "명");
		for (int i = 0; i < this.chefLen; i++) {
			System.out.println(chefList[i].GetName() + " " + chefList[i].GetRank());
			this.chefList[i].PrintCookableMenu(this.menuLen, this.menuList);
		}
		System.out.println();
		return;
	}

	public void PrintGuestListSimple() {
		System.out.println("손님 " + this.guestLen + "명");
		for (int i = 0; i < this.guestLen; i++) {
			System.out
					.println(guestList[i].GetSelectMenuName(this.menuList) + " " + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		return;
	}

	public void PrintGuestList() {
		System.out.println("손님 " + this.guestLen + "명");
		for (int i = 0; i < this.guestLen; i++) {
			System.out.println(guestList[i].GetName() + " : " + guestList[i].GetSelectMenuName(this.menuList) + " "
					+ guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		return;
	}

	public void PrintGuestListDetail() {
		System.out.println("손님 " + this.guestLen + "명");
		for (int i = 0; i < this.guestLen; i++) {
			System.out.println(guestList[i].GetName() + " 유형 : " + guestList[i].GetCategory() + " \t"
					+ guestList[i].GetSelectMenuName(this.menuList) + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		return;
	}

	public void PrintIncome() {
		System.out.println("수익 : " + income + "원\n");
		return;
	}

	public int GetitemLen() {
		return itemLen;
	}

	public int[] GetItemStock() {
		return this.itemStockList;
	}

	public int[] GetItemPrice() {
		return this.itemPriceList;
	}

	public void AdjustIncome(int adjustIncome) {
		income += adjustIncome;
		return;
	}

	public int GetIncome() {
		return income;
	}

	public Menu[] GetmenuList() {
		return this.menuList;
	}

	public int GetMenuLen() {
		return this.menuLen;
	}

	public void AddMenu(String name) {
		Menu[] newmenuList = new Menu[this.menuLen + 1];
		int i;
		for (i = 0; i < this.menuLen; i++) {
			newmenuList[i] = this.menuList[i];
		}
		newmenuList[i] = new Menu(name);
		this.menuLen += 1;
		this.menuList = newmenuList;
	}

	public void AddChef(String name) {
		Chef[] newchefList = new Chef[this.chefLen + 1];
		int i;
		for (i = 0; i < this.chefLen; i++) {
			newchefList[i] = this.chefList[i];
		}
		newchefList[i] = new Chef(name, this.menuLen);
		this.chefLen += 1;
		this.chefList = newchefList;
	}

	public void AddChef(String name, int rank) {
		Chef[] newchefList = new Chef[this.chefLen + 1];
		int i;
		for (i = 0; i < this.chefLen; i++) {
			newchefList[i] = this.chefList[i];
		}
		newchefList[i] = new Chef(name, this.menuLen, rank);
		this.chefLen += 1;
		this.chefList = newchefList;
	}

	public void AddGuest(String name) {
		Guest[] newGuestList = new Guest[this.guestLen + 1];
		int i;
		for (i = 0; i < this.guestLen; i++) {
			newGuestList[i] = this.guestList[i];
		}
		newGuestList[i] = new Guest(name, this.menuLen);
		this.guestLen += 1;
		this.guestList = newGuestList;
	}

	public void AddGuest(String name, int category) {
		Guest[] newGuestList = new Guest[this.guestLen + 1];
		int i;
		for (i = 0; i < this.guestLen; i++) {
			newGuestList[i] = this.guestList[i];
		}
		newGuestList[i] = new Guest(name, this.menuLen, category);
		this.guestLen += 1;
		this.guestList = newGuestList;
	}

	public void AddGuest(int count) {
		Guest[] newGuestList = new Guest[this.guestLen + count];
		int i;
		for (i = 0; i < this.guestLen; i++) {
			newGuestList[i] = this.guestList[i];
		}

		i = this.guestLen;
		this.guestLen += count;
		for (; i < this.guestLen; i++) {
			newGuestList[i] = new Guest(this.menuLen, i);
		}

		this.guestList = newGuestList;
	}

	public void LeaveGuest(int count) {
		Guest[] newGuestList = new Guest[this.guestLen - count];
		int i;

		for (i = 0; i < count; i++) {
			this.income += this.menuList[this.guestList[i].GetSelectMenuIndex()].GetPrice()
					* this.guestList[i].GetSelectCount();
		}

		this.guestLen -= count;
		for (i = 0; i < this.guestLen; i++) {
			newGuestList[i] = this.guestList[i + count];
		}
		this.guestList = newGuestList;

	}

}
