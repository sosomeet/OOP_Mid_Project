package oop_project;

public class main {

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant();

		restaurant.PrintRestaurant();
		
		restaurant.AddMenu("타코");
		restaurant.AddMenu("브리또");
		restaurant.AddMenu("보울 타코");
		restaurant.AddMenu("크리스피 타코");
		restaurant.AddMenu("또띠아");
		restaurant.PrintMenuList();
		// restaurant.PrintMenuListDetail();
		
		restaurant.AddChef("요리사1", 0);
		restaurant.AddChef("요리사2", 1);
		restaurant.AddChef("요리사3", 2);
		restaurant.AddChef("요리사4", 3);
		restaurant.AddChef("요리사5");
		restaurant.PrintChefList();
		// restaurant.PrintChefListDetail();
		
		restaurant.AddGuest(10);
		restaurant.AddGuest("착한놈");
		restaurant.AddGuest("나쁜놈", 1);
		restaurant.PrintGuestList();
		// restaurant.PrintGuestListDetail();
		
		restaurant.LeaveGuest(4);
		restaurant.PrintGuestList();
		restaurant.PrintIncome();
		
		restaurant.LeaveGuest(4);
		restaurant.PrintGuestList();
		restaurant.PrintIncome();
		
		restaurant.LeaveGuest(4);
		restaurant.PrintGuestList();
		restaurant.PrintIncome();
	}

}
