package oop_project;

public class main {

	public static void main(String[] args) {
		Kitchen kitchen = new Kitchen();

		kitchen.PrintKitchen();
		
		kitchen.AddMenu("타코");
		kitchen.AddMenu("볼타코");
		kitchen.AddMenu("샐러드타코");
		
		kitchen.PrintMenuList();
		kitchen.PrintMenuListDetail();
		
		kitchen.AddChef("이치우1", 0);
		kitchen.AddChef("이치우2", 1);
		kitchen.AddChef("이치우3", 2);
		kitchen.AddChef("이치우4", 3);
		kitchen.AddChef("이치우5");
		kitchen.AddChef("이치우6");
		kitchen.PrintChefList();
		
	}

}
