package oop_project;

public class Guest extends Restaurant {
	private String name;
	private int category;
	private int selectMenuIndex;
	private int selectMenuCount;

	Guest() {
		this.name = "";
		this.category = 0;
		this.selectMenuCount = 0;
		this.selectMenuCount = 0;
	}

	Guest(int menuLen, int index) {
		this.category = (int) (Math.random() * 3);
		AddGuest("", menuLen, category);

	}

	Guest(String name, int menuLen) {
		AddGuest(name, menuLen, category);

	}

	Guest(String name, int menuLen, int category) {
		AddGuest(name, menuLen, category);
	}

	public void AddGuest(String name, int menuLen, int category) {
		boolean isCreated = false;

		while (!isCreated) {

			if (name.equals("")) {
				if (category == 0) {
					this.name = "Æò¹üÇÑ ¼Õ´Ô";
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 2) + 1;
					isCreated = true;
				}

				else if (category == 1) {
					this.name = "´ë½Ä°¡ ¼Õ´Ô";
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 4) + 2;
					isCreated = true;
				}

				else if (category == 2) {
					this.category = (int) (Math.random() * 3);
					if (category == 2) {
						this.name = "½Å¸Þ´º ¼Õ´Ô";
						this.selectMenuIndex = (int) (Math.random() * menuLen);
						this.selectMenuCount = 1;
						isCreated = true;
					} else {
						isCreated = false;
					}
				}
			} else {
				if (category == 0) {
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 2) + 1;
					isCreated = true;
				}

				else if (category == 1) {
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 4) + 2;
					isCreated = true;
				}

				else if (category == 2) {
					this.category = (int) (Math.random() * 3);
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = 1;
					isCreated = true;
				}
			}
		}

	}

	public String GetName() {
		return this.name;
	}

	public int GetCategory() {
		return this.category;
	}

	public int GetSelectMenuIndex() {
		return this.selectMenuIndex;
	}

	public String GetSelectMenuName(Menu[] menuList) {
		return menuList[this.selectMenuIndex].GetName();
	}

	public int GetSelectCount() {
		return this.selectMenuCount;
	}

	public void PrintGuestListSimple(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("¼Õ´Ô " + guestLen + "¸í");
		for (int i = 0; i < guestLen; i++) {
			System.out.println(guestList[i].GetSelectMenuName(menuList) + " " + guestList[i].GetSelectCount() + "°³");
		}
		System.out.println();
		return;
	}

	public void PrintGuestList(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("¼Õ´Ô " + guestLen + "¸í");
		for (int i = 0; i < guestLen; i++) {
			System.out.println(guestList[i].GetName() + " : " + guestList[i].GetSelectMenuName(menuList) + " "
					+ guestList[i].GetSelectCount() + "°³");
		}
		System.out.println();
		return;
	}

	public void PrintGuestListDetail(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("¼Õ´Ô " + guestLen + "¸í");
		for (int i = 0; i < guestLen; i++) {
			System.out.print(guestList[i].GetName() + " À¯Çü : " + guestList[i].GetCategory() + " \t");
			System.out.println(guestList[i].GetSelectMenuName(menuList) + guestList[i].GetSelectCount() + "°³");
		}
		System.out.println();
		return;
	}

}
