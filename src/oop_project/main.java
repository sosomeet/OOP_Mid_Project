package oop_project;

public class Main {

	public static Menu[] AddMenu(String name, Menu[] menuList) {
		Menu[] newMenuList = new Menu[menuList.length + 1];
		int i;
		for (i = 0; i < menuList.length; i++) {
			newMenuList[i] = menuList[i];
		}
		newMenuList[i] = new Menu(name);
		menuList = newMenuList;	
		return menuList;
	}

	public static Chef[] AddChef(String name, Chef[] chefList, int menuLen) {
		Chef[] newchefList = new Chef[chefList.length + 1];
		int i;
		for (i = 0; i < chefList.length; i++) {
			newchefList[i] = chefList[i];
		}
		newchefList[i] = new Chef(name, menuLen);
		chefList = newchefList;
		return chefList;
	}

	public static Chef[] AddChef(String name, int rank, Chef[] chefList, int menuLen) {
		Chef[] newChefList = new Chef[chefList.length + 1];
		int i;
		for (i = 0; i < chefList.length; i++) {
			newChefList[i] = chefList[i];
		}
		newChefList[i] = new Chef(name, menuLen, rank);
		chefList = newChefList;
		return chefList;
	}

	public static Guest[] AddGuest(String name, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + 1];
		int i;
		for (i = 0; i < guestList.length; i++) {
			newGuestList[i] = guestList[i];
		}
		newGuestList[i] = new Guest(name, menuLen);
		guestList = newGuestList;
		return guestList;
	}

	public static Guest[] AddGuest(String name, int category, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + 1];
		int i;
		for (i = 0; i < guestList.length; i++) {
			newGuestList[i] = guestList[i];
		}
		newGuestList[i] = new Guest(name, menuLen, category);
		guestList = newGuestList;
		return guestList;
	}

	public static Guest[] AddGuest(int count, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + count];
		int i;
		for (i = 0; i < guestList.length; i++) {
			newGuestList[i] = guestList[i];
		}

		i = guestList.length;
		for (; i < guestList.length + count; i++) {
			newGuestList[i] = new Guest(menuLen, i);
		}

		guestList = newGuestList;
		return guestList;
	}

	public static Guest[] LeaveGuest(int count, Restaurant restaurant, Guest[] guestList, Menu[] menuList) {
		Guest[] newGuestList = new Guest[guestList.length - count];
		int i;

		for (i = 0; i < count; i++) {
			restaurant.AdjustIncome(menuList[guestList[i].GetSelectMenuIndex()].GetPrice() * guestList[i].GetSelectCount());
		}
		
		for (i = 0; i < (guestList.length - count); i++) {
			newGuestList[i] = guestList[i + count];
		}
		guestList = newGuestList;
		return guestList;
	}
	
	public static void PrintMenuList(Menu[] menuList, Restaurant restaurant) {
		System.out.println("메뉴 " + menuList.length + "개");
		for(int i = 0 ; i< menuList.length; i++) {
			menuList[i].PrintMenuList(menuList[i], restaurant.GetItemNameList());
		}
		System.out.println();
		return;
	}
	
	public static void PrintMenuListDetail(Menu[] menuList, Restaurant restaurant) {
		System.out.println("메뉴 " + menuList.length + "개");
		for(int i = 0 ; i< menuList.length; i++) {
			menuList[i].PrintMenuListDetail(menuList[i], restaurant.GetItemNameList());
		}
		System.out.println();
		return;
	}
	
	public static void PrintChefList(Chef[] chefList) {
		System.out.println("직원 " + chefList.length + "명");
		for(int i = 0; i < chefList.length; i++) {
			chefList[i].PrintChefList(chefList[i], chefList.length);
		}
		System.out.println();
		return;
	}
	
	public static void PrintChefListDetail(Chef[] chefList, Menu[] menuList) {
		System.out.println("직원 " + chefList.length + "명");
		for(int i = 0; i < chefList.length; i++) {
			chefList[i].PrintChefListDetail(chefList[i], menuList);
		}
		System.out.println();
		return;
	}
	
	public static void PrintGuestListSimple(Guest[] guestList, Menu[] menuList) {
		System.out.println("손님 " + guestList.length + "명");
		for (int i = 0; i < guestList.length; i++) {
			System.out.println(guestList[i].GetSelectMenuName(menuList) + " " + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		return;
	}

	public static void PrintGuestList(Guest[] guestList, Menu[] menuList) {
		System.out.println("손님 " + guestList.length + "명");
		for (int i = 0; i < guestList.length; i++) {
			System.out.println(guestList[i].GetName() + " : " + guestList[i].GetSelectMenuName(menuList) + " "
					+ guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		return;
	}

	public static void PrintGuestListDetail(Guest[] guestList, Menu[] menuList) {
		System.out.println("손님 " + guestList.length + "명");
		for (int i = 0; i < guestList.length; i++) {
			System.out.print(guestList[i].GetName() + " 유형 : " + guestList[i].GetCategory() + " \t");
			System.out.println(guestList[i].GetSelectMenuName(menuList) + guestList[i].GetSelectCount() + "개");
		}
		System.out.println();
		return;
	}

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();

		restaurant.PrintRestaurant();

		System.out.println("--------------------------");
		
		Menu[] menuList = new Menu[0];

		Chef[] chefList = new Chef[0];

		Guest[] guestList = new Guest[0];

		menuList = AddMenu("타코", menuList);
		menuList = AddMenu("브리또", menuList);
		menuList = AddMenu("보울타코", menuList);
		menuList = AddMenu("크리스피타코", menuList);
		menuList = AddMenu("또띠아", menuList);
		PrintMenuList(menuList, restaurant);
		// PrintMenuListDetail(menuList, restaurant);
		
		System.out.println("--------------------------");

		chefList = AddChef("요리사1", 0, chefList, menuList.length);
		chefList = AddChef("요리사2", 1, chefList, menuList.length);
		chefList = AddChef("요리사3", 2, chefList, menuList.length);
		chefList = AddChef("요리사4", 3, chefList, menuList.length);
		chefList = AddChef("요리사5", chefList, menuList.length);
		PrintChefList(chefList);
		// PrintChefListDetail(chefList, menuList);

		System.out.println("--------------------------");
		
		guestList = AddGuest(10, guestList, menuList.length);
		guestList = AddGuest("착한놈", guestList, menuList.length);
		guestList = AddGuest("나쁜놈", 1, guestList, menuList.length);
		PrintGuestListSimple(guestList, menuList);
		// PrintGuestList(guestList, menuList);
		// PrintGuestListDetail(guestList, menuList);
		
		restaurant.PrintIncome();
		
		System.out.println("--------------------------");
		
		guestList = LeaveGuest(12, restaurant, guestList, menuList);
		PrintGuestListSimple(guestList, menuList);
		restaurant.PrintIncome();

	}

}
