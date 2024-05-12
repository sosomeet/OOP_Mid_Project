package oop_project;

//Restaurant 클래스 정의
class Restaurant {
	
	private String[] itemNameList = { "타코", "소스", "고기", "치즈", "채소", "보울", "브리또" };
	// 메뉴 이름의 배열
	private int itemLen;         // 메뉴 항목의 개수   
	private int[] itemPriceList; // 각 메뉴 항목의 가격을 저장하는 배열
	private int[] itemStockList; // 재료의 재고를 저장하는 배열

	private int income;     // 총 수익    
	private int maxStock;   // 최대 재고량
	
    // 기본 생성자
	Restaurant() {
		this.itemLen = this.itemNameList.length;     // 메뉴의 항목 개수 설정
		this.itemPriceList = new int[this.itemLen];  // 메뉴의 가격의 배열을 초기화
		this.itemStockList = new int[this.itemLen];  // 재료의 재고에 대한 배열을 초기화
		
		// 각 메뉴에 대한 가격을 랜덤으로 설정하고, 초기 재고를 10개로 설정
		for (int i = 0; i < itemLen; i++) {
			this.itemPriceList[i] = (int)(Math.random() * 300) + 100;
			this.itemStockList[i] = 10;
		}
        // 총 수익과 최대 재고량을 각각 0원, 10개로 초기화 
		this.income = 0;
		this.maxStock = 10;
	}
	
	// 메뉴의 항목, 가격, 재료의 재고를 출력하는 함수
	public void PrintRestaurant() {
		for (int i = 0; i < itemLen; i++) {
			System.out.println("[" + itemNameList[i] + "] " + this.itemPriceList[i] + "원, 재고 : " + this.itemStockList[i]);
		}   // 현재 메뉴에 대한 이름과 가격, 재고를 출력함
		System.out.println();
		return;
	}

	// 총 수익을 출력하는 함수
	public void PrintIncome() {
		System.out.println("수익 : " + this.income + "원\n");
		return;
	}
    // 메뉴 항목의 개수를 반환하는 함수
	public int GetItemLen() {
		return this.itemLen;
	}
	// 메뉴 항목의 이름의 배열을 반환하는 함수
	public String[] GetItemNameList() {
		return this.itemNameList;
	}

	// 재료의 재고 배열을 반환하는 함수
	public int[] GetItemStock() {
		return this.itemStockList;
	}
    // 메뉴의 가격을 반환하는 함수
	public int[] GetItemPrice() {
		return this.itemPriceList;
	}
	// 수익을 조정하는 함수
	public void AdjustIncome(int adjustIncome) {
		this.income += adjustIncome;  // 현재 수익에 함수가 호출될 때 파라미터로 받은 adjustIncome 값을 더하여 총 수익을 조정함
		return;
	}
	// 재료의 재고 상태를 조정하는 함수
	public void AdjustItemStock(int[] adjustItemStock) {
		for(int i = 0 ; i<this.itemStockList.length; i++) {
			this.itemStockList[i] -= adjustItemStock[i];  // 각 메뉴의 항목별로 조정해야 하는 재고량을 가짐
		}
		return;
	}
	// 총 수익을 반환하는 함수
	public int GetIncome() {
		return this.income;
	}
	
	// 재고가 0인 재료 항목을 재발주 하고
	// 그에 해당하는 만큼의 수익을 차감하는 함수
	public void SetItemStock() {
		for(int i = 0 ; i< this.itemStockList.length; i++) {
			if(this.itemStockList[i] <= 0) {  // 해당 항목의 재고가 0인지 확인함
				System.out.println("\n" + this.itemNameList[i] + "을 재발주했습니다.");
				System.out.println(("수익 " + this.itemPriceList[i] * (10 - this.itemStockList[i])) + "원 차감"); // 재발주 과정에서 차감되는 수익을 계산하여 출력
				this.income -= this.itemPriceList[i] * (10 - this.itemStockList[i]); // 총 수익에서 차감된 수익만큼 빼주고 총 수익에 저장
				this.itemStockList[i] = 10;  // 해당 항목의 재고값을 MaxCount로 다시 초기화
			}
		}
		return;
	}
	
	// 음식의 재고량을 다시 최대로 채워주는 함수
	public void InitItemStock() {
		int decreaseIncome = 0;     // 재고를 채워주는 과정에서 생기는 수익 감소량을 저장하는 변수
		for(int i = 0 ; i< this.itemStockList.length; i++) {
			System.out.println(this.itemNameList[i] + "을 재발주했습니다.");
			this.income -= this.itemPriceList[i] * (10 - this.itemStockList[i]); // 수익감소량은 해당 메뉴의 가격과 재고량의 차이
			decreaseIncome += this.itemPriceList[i] * (10 - this.itemStockList[i]); // 계산된 수익 감소량을 decreaseIncome 변수에 저장
			this.itemStockList[i] = 10;   // 각 메뉴의 재고량 재설정
		}
		System.out.println("수익 " + decreaseIncome + "원 차감");  // 수익 감소량 출력
		return;
	}

}