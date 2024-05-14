package oop_project_v_3;

import java.util.ArrayList;

public class Restaurant {
	private int income;
	private int maxStock;

	String[][] itemNameArray;
	private int[][] itemStockArray;
	private int[][] itemPriceArray;

	private ArrayList<Menu> menuList;
	private ArrayList<Chef> chefList;
	private ArrayList<Guest> guestList;
	private ArrayList<Order> orderList;

	Restaurant() {
		income = 0;
		maxStock = 10;

		itemNameArray = new String[5][];
		itemStockArray = new int[5][];
		itemPriceArray = new int[5][];

		String[] mainItemList = { "브리또", "보울", "크리스피콘", "또띠아" };
		String[] mainToppingList = { "소고기", "돼지고기", "닭고기", "바베큐" };
		String[] subToppingList = { "콩", "백미", "황미", "양상추", "양배추" };
		String[] sauceList = { "토마토살사", "칠리살사", "사워크림", "과카몰리", "케찹" };
		String[] sideList = { "감자튀김", "어니언링", "나쵸", "콜라", "사이다", "맥주" };

		itemNameArray[0] = new String[mainItemList.length];
		itemNameArray[1] = new String[mainToppingList.length];
		itemNameArray[2] = new String[subToppingList.length];
		itemNameArray[3] = new String[sauceList.length];
		itemNameArray[4] = new String[sideList.length];

		for (int i = 0; i < itemNameArray[0].length; i++) {
			itemNameArray[0][i] = mainItemList[i];
		}
		for (int i = 0; i < itemNameArray[1].length; i++) {
			itemNameArray[1][i] = mainToppingList[i];
		}
		for (int i = 0; i < itemNameArray[2].length; i++) {
			itemNameArray[2][i] = subToppingList[i];
		}
		for (int i = 0; i < itemNameArray[3].length; i++) {
			itemNameArray[3][i] = sauceList[i];
		}
		for (int i = 0; i < itemNameArray[4].length; i++) {
			itemNameArray[4][i] = sideList[i];
		}

		for (int i = 0; i < itemNameArray.length; i++) {
			itemStockArray[i] = new int[itemNameArray[i].length];
			itemPriceArray[i] = new int[itemNameArray[i].length];
			for (int j = 0; j < itemNameArray[i].length; j++) {
				itemStockArray[i][j] = maxStock;
				itemPriceArray[i][j] = (int) (Math.random() * 300) + 100;
			}
		}

		menuList = new ArrayList<Menu>();
		chefList = new ArrayList<Chef>();
		guestList = new ArrayList<Guest>();
		orderList = new ArrayList<Order>();

	}

	public ArrayList<Chef> getChefList() {
		return this.chefList;
	}

	public ArrayList<Menu> getMenuList() {
		return menuList;
	}

	public ArrayList<Guest> getGuestList() {
		return guestList;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public boolean assignChef(int chefIndex, int menuIndex, int orderIndex) {
		if (!chefList.get(chefIndex).isCooking && chefList.get(chefIndex).cookableArray[menuIndex]) {
			this.chefList.get(chefIndex).cookOrderIndex = orderIndex;
			System.out.print("[" + chefList.get(chefIndex).name + "] 요리사가 ");
			System.out.println("[" + menuList.get(menuIndex).name + "] 요리를 시작 합니다.");
			chefList.get(chefIndex).isCooking = true;
			orderList.get(orderIndex).chefIndex = chefIndex;
			return true;
		}
		return false;
	}

	public String[][] getItem() {
		return this.itemNameArray;
	}

	public int[][] getItemStock() {
		return this.itemStockArray;
	}

	public int[][] getItemPrice() {
		return this.itemPriceArray;
	}

	public int getMenuLen() {
		return menuList.size();
	}

	public int getChefLen() {
		return chefList.size();
	}

	public int getGuestLen() {
		return guestList.size();
	}

	public int getOrderLen() {
		return orderList.size();
	}

	public void adjustIncome(int income) {
		this.income += income;
		return;
	}

	public void addMenu(Menu menu) {
		menuList.add(menu);
		return;
	}

	public void addChef(Chef chef) {
		chefList.add(chef);
		return;
	}

	public void addGuest(Guest guest) {
		guestList.add(guest);
		return;
	}

	public void addOrder(Order order) {
		orderList.add(order);
		return;
	}

	public void leaveGuest(int index) {
		guestList.remove(index);
		return;
	}

	public void leaveOrder(int index) {
		orderList.remove(index);
		return;
	}

	public void reduceItem(int menuIndex) {
		for (int i = 0; i < itemNameArray.length; i++) {
			for (int j = 0; j < itemNameArray[i].length; j++) {
				itemStockArray[i][j] -= menuList.get(menuIndex).useItems[i][j];
			}
		}
		return;
	}

	public void addItem() {
		int decreaseIncome = 0;
		for (int i = 0; i < itemNameArray.length; i++) {
			for (int j = 0; j < itemNameArray[i].length; j++) {
				if (itemStockArray[i][j] <= 0) {
					System.out.println(itemNameArray[i][j] + " 재발주했습니다.");
					// 수익 감소량은 해당 재료의 가격과 재고량의 차이
					decreaseIncome += itemPriceArray[i][j] * (this.maxStock - itemStockArray[i][j]);
					// 각 재료의 재고량 재설정
					itemStockArray[i][j] = this.maxStock;
				}
			}
		}
		income -= decreaseIncome;
		if (decreaseIncome != 0) {
			printIncome();
		}
		return;
	}

	public void initItem() {
		int decreaseIncome = 0;
		System.out.println("모든 재료를 재발주했습니다.");
		for (int i = 0; i < itemNameArray.length; i++) {
			for (int j = 0; j < itemNameArray[i].length; j++) {
				// 수익 감소량은 해당 재료의 가격과 재고량의 차이
				decreaseIncome += itemPriceArray[i][j] * (this.maxStock - itemStockArray[i][j]);
				// 각 재료의 재고량 재설정
				itemStockArray[i][j] = this.maxStock;
			}
		}
		income -= decreaseIncome;
		return;
	}

	public void initChef() {
		for (int i = 0; i < chefList.size(); i++) {
			chefList.get(i).cookOrderIndex = -1;
			chefList.get(i).isCooking = false;
		}
		return;
	}

	public void initGuest() {
		this.guestList = new ArrayList<Guest>();
		return;
	}

	public void initOrder() {
		this.orderList = new ArrayList<Order>();
		return;
	}

	public void printIncome() {
		System.out.println("[수입] : " + this.income + "원");
		return;
	}

	public void printItem() {
		for (int i = 0; i < this.itemNameArray.length; i++) {
			if (i == 0) {
				System.out.println("[메인 재료]");
			} else if (i == 1) {
				System.out.println("[메인 토핑]");
			} else if (i == 2) {
				System.out.println("[서브 토핑]");
			} else if (i == 3) {
				System.out.println("[소스]");
			} else if (i == 4) {
				System.out.println("[사이드]");
			}
			for (int j = 0; j < this.itemNameArray[i].length; j++) {
				System.out.print(this.itemNameArray[i][j] + " ");
			}
			System.out.println();
		}
		return;
	}
	
	public void printItemDetail() {
		for (int i = 0; i < this.itemNameArray.length; i++) {
			if (i == 0) {
				System.out.println("[메인 재료]");
			} else if (i == 1) {
				System.out.println("[메인 토핑]");
			} else if (i == 2) {
				System.out.println("[서브 토핑]");
			} else if (i == 3) {
				System.out.println("[소스]");
			} else if (i == 4) {
				System.out.println("[사이드]");
			}
			for (int j = 0; j < this.itemNameArray[i].length; j++) {
				System.out.print(this.itemNameArray[i][j] + " ");
				System.out.print(this.itemPriceArray[i][j] + "원 ");
				System.out.print(this.itemStockArray[i][j] + "개 ");
			}
			System.out.println();
		}
		return;
	}

	public void printMenu() {
		System.out.println("메뉴판");
		for (int i = 0; i < menuList.size(); i++) {
			System.out.println("[" + menuList.get(i).name + "] : " + menuList.get(i).price + "원");
		}
		return;
	}

	public void printChef() {
		System.out.println("직원 목록");
		for (int i = 0; i < chefList.size(); i++) {
			System.out.println("[" + chefList.get(i).name + "] : " + (chefList.get(i).rank + 1) + "등급 요리사");
		}
		return;
	}

	public void printChefDetail() {
		System.out.println("직원 목록");
		for (int i = 0; i < chefList.size(); i++) {
			System.out.println("[" + chefList.get(i).name + "] : " + (chefList.get(i).rank + 1) + "등급 요리사");
			System.out.println("요리 가능한 목록");
			for (int j = 0; j < this.menuList.size(); j++) {
				if (chefList.get(i).cookableArray[j]) {
					System.out.print(menuList.get(j).name + " ");
				}
			}
			System.out.println();
		}
		return;
	}

	public void printGuest() {
		System.out.println("손님 목록판");
		for (int i = 0; i < guestList.size(); i++) {
			System.out.println("[" + guestList.get(i).name + "] 유형 : " + guestList.get(i).category);
		}
		return;
	}

	public void printOrder() {
		System.out.println("주문 목록");
		for (int i = 0; i < orderList.size(); i++) {
			System.out.print("[" + menuList.get(orderList.get(i).selectMenuIndex).name + "] ");
			System.out.println(orderList.get(i).count + "개가" + orderList.get(i).endTurn + "에 완료");
		}
		return;
	}

}
