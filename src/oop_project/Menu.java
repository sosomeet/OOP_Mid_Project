package oop_project;

//Menu 클래스 선언 Restaurant클래스 상속
public class Menu extends Restaurant { 
    // 필드 초기화
	// private으로 필드를 선언하여 외부로부터 해당 필드로의 접근을 제한함(캡술화 지원)
	// 안정성을 높이고 유지 및 보수를 용이하게 함
	private String name;        // 메뉴 이름
	private int price;          // 메뉴 가격
	private int[] useItemList;  // 사용하려고 하는 재료 개수의 리스트
    
	// 기본 생성자
	Menu() {   
	}
	
    // 메뉴의 이름을 파라미터로 받는 생성자
	Menu(String name) { // 가격과 사용된 항목의 리스트를 초기화
		this.name = name;
		this.price = 0;
		this.useItemList = new int[super.GetItemLen()]; // Restaurant 클래스의 GetItemLen()로 사용하려는 재료 개수의 리스트를 받아와서 초기화함
		
		// 각 항목에 대한 가격 계산
		for (int i = 0; i < super.GetItemLen(); i++) {  
			// super.GetItemLen()를 호출하여 Restaurant클래스에서 상속받은 함수 사용하여 항목 길이 가져옴
			useItemList[i] = (int) (Math.random() * 3);
			this.price += useItemList[i] * super.GetItemPrice()[i];  // 모든 재료와 가격을 곱하여 전체 가격 구하기
		}
		// 소숫점 둘째 자리에서 반올림
		// 원가의 3.5배 되는 가격을 받아 마진 확보
		this.price = (int)(this.price * 3.5f / 100)*100;  
	}
    // 메뉴의 정보를 보여주는 함수
	public void PrintMenu(String[] itemNameList) {
		System.out.println("[" + this.name + "] " + this.price + "��");  // 메뉴의 이름과 가격을 출력
		return;  
	}
	
	// 메뉴의 상세정보를 나타내는 함수
    // 메뉴의 이름과 가격, 사용된 각 재료의 이름과 개수 출력함
	public void PrintMenuDetail(String[] itemNameList) {
		System.out.println("[" + this.name + "] " + this.price + "��");  // 메뉴의 이름과 가격 출력
		
		// for 문을 통해 메뉴에 쓰인 각 재료명과 개수를 출력
		for (int i = 0; i < useItemList.length; i++) {
			System.out.print(itemNameList[i] + this.useItemList[i] + "�� "); 
			// itemNameList에서 해당 인덱스의 항목을 가져와 그 이름, 그 항목이 메뉴에서 사용된 개수 출력
		}
		System.out.println();
		return;
	}
    // 메뉴의 이름을 반환하는 함수
	public String GetName() {
		return this.name;
	}
    // 메뉴의 가격을 반환하는 함수
	public int GetPrice() {
		return this.price;
	}
    // 사용된 항목의 리스트를 반환하는 함수
	public int[] GetUseItemList() {
		return this.useItemList; // useItemList 필드 가리킴
	}
}
