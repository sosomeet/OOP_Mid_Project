package oop_project;

class Restaurant {
	private String[] itemNameList = { "타코", "소스", "고기", "치즈", "채소", "보울", "브리또" };

	private int itemLen;
	private int[] itemPriceList;
	private int[] itemStockList;

	private int income;

	Restaurant() {
		itemLen = itemNameList.length;
		this.itemPriceList = new int[itemLen];
		this.itemStockList = new int[itemLen];

		for (int i = 0; i < itemLen; i++) {
			this.itemPriceList[i] = (int)(Math.random() * 300) + 100;
			this.itemStockList[i] = 50;
		}

		income = 0;
	}

	public void PrintRestaurant() {
		for (int i = 0; i < itemLen; i++) {
			System.out
					.println("[" + itemNameList[i] + "] " + this.itemPriceList[i] + "원, 재고 : " + this.itemStockList[i]);
		}
		System.out.println();
		return;
	}


	public void PrintIncome() {
		System.out.println("수익 : " + income + "원\n");
		return;
	}

	public int GetitemLen() {
		return this.itemLen;
	}

	public String[] GetItemNameList() {
		return this.itemNameList;
	}

	
	public int[] GetItemStock() {
		return this.itemStockList;
	}

	public int[] GetItemPrice() {
		return this.itemPriceList;
	}

	public void AdjustIncome(int adjustIncome) {
		this.income += adjustIncome;
		return;
	}

	public int GetIncome() {
		return this.income;
	}


}
