package oop_project;

class Kitchen {
	private static String[] itemNameList = { "타코", "소스", "고기", "치즈", "채소", "보울", "브리또" };

	private static int itemLen;
	private int[] itemPriceList;
	private int[] itemStockList;

	private static int income;

	private Menu[] menuList;
	protected int menuLen;

	private Chef[] chefList;
	protected int chefLen;

	Kitchen() {
		itemLen = itemNameList.length;
		this.itemPriceList = new int[itemLen];
		this.itemStockList = new int[itemLen];

		for (int i = 0; i < itemLen; i++) {
			this.itemPriceList[i] = 100;
			this.itemStockList[i] = 10;
		}

		income = 0;

		this.menuLen = 0;
		this.menuList = new Menu[this.menuLen];

		this.chefLen = 0;
		this.chefList = new Chef[this.chefLen];
	}

	public void PrintKitchen() {
		for (int i = 0; i < itemLen; i++) {
			System.out.println("[" + itemNameList[i] + "] " + this.itemPriceList[i] + "원, 재고 : " + this.itemStockList[i]);
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
			this.chefList[i].PrintCookableMenu(this.menuLen, this.menuList);
		}
		System.out.println();
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

}
