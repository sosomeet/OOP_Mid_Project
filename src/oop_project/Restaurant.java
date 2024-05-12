package oop_project;

class Restaurant {
	private String[] itemNameList = { "타코", "소스", "고기", "치즈", "채소", "보울", "브리또" };

	private int itemLen;
	private int[] itemPriceList;
	private int[] itemStockList;

	private int income;
	private int maxStock;
	

	Restaurant() {
		this.itemLen = this.itemNameList.length;
		this.itemPriceList = new int[this.itemLen];
		this.itemStockList = new int[this.itemLen];

		for (int i = 0; i < itemLen; i++) {
			this.itemPriceList[i] = (int)(Math.random() * 300) + 100;
			this.itemStockList[i] = 10;
		}

		this.income = 0;
		this.maxStock = 10;
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
		System.out.println("수익 : " + this.income + "원\n");
		return;
	}

	public int GetItemLen() {
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
	
	public void AdjustItemStock(int[] adjustItemStock) {
		for(int i = 0 ; i<this.itemStockList.length; i++) {
			this.itemStockList[i] -= adjustItemStock[i];
		}
		return;
	}

	public int GetIncome() {
		return this.income;
	}
	
	public void SetItemStock() {
		for(int i = 0 ; i< this.itemStockList.length; i++) {
			if(this.itemStockList[i] <= 0) {
				System.out.println("\n" + this.itemNameList[i] + "을 재발주했습니다.");
				System.out.println(("수익 " + this.itemPriceList[i] * (10 - this.itemStockList[i])) + "원 차감");
				this.income -= this.itemPriceList[i] * (10 - this.itemStockList[i]);
				this.itemStockList[i] = 10;
			}
		}
		return;
	}
	
	public void InitItemStock() {
		int decreaseIncome = 0;
		for(int i = 0 ; i< this.itemStockList.length; i++) {
			System.out.println(this.itemNameList[i] + "을 재발주했습니다.");
			this.income -= this.itemPriceList[i] * (10 - this.itemStockList[i]);
			decreaseIncome += this.itemPriceList[i] * (10 - this.itemStockList[i]);
			this.itemStockList[i] = 10;
		}
		System.out.println("수익 " + decreaseIncome + "원 차감");
		return;
	}

}
