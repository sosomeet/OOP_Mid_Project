package oop_project;

public class Guest extends Restaurant {
	private String name;
	private int category;
	private int selectMenuIndex;
	private int selectMenuCount;

	Guest() {

	}

	Guest(int menuLen, int index) {
		boolean isCreated = false;
		
		while (!isCreated) {
			this.category = (int) (Math.random() * 3);
			if (category == 0) {
				this.name = "평범한 손님" + index;
				this.selectMenuIndex = (int) (Math.random() * menuLen);
				this.selectMenuCount = (int) (Math.random() * 2) + 1;
				isCreated = true;
			}

			else if (category == 1) {
				this.name = "대식가 손님" + index;
				this.selectMenuIndex = (int) (Math.random() * menuLen);
				this.selectMenuCount = (int) (Math.random() * 4) + 2;
				isCreated = true;
			}

			else if (category == 2) {
				this.category = (int) (Math.random() * 3);
				if (category == 2) {
					this.name = "신메뉴 손님" + index;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = 1;
					isCreated = true;
				} else {
					isCreated = false;
				}
			}
		}

	}

	Guest(String name, int menuLen) {
		int category = (int) (Math.random() * 3);

		if (category == 0) {
			this.name = "평범한 " + name;
			this.selectMenuIndex = (int) (Math.random() * menuLen);
			this.selectMenuCount = (int) (Math.random() * 2) + 1;
		}

		else if (category == 1) {
			this.name = "대식가 " + name;
			this.selectMenuIndex = (int) (Math.random() * menuLen);
			this.selectMenuCount = (int) (Math.random() * 4) + 2;
		}

		else if (category == 2) {
			this.name = "신메뉴 요구 " + name;
			this.selectMenuIndex = (int) (Math.random() * menuLen);
			this.selectMenuCount = 1;
		}

	}

	Guest(String name, int menuLen, int category) {
		this.name = name;

		if (category == 0) {
			this.name = "평범한 " + name;
			this.selectMenuIndex = (int) (Math.random() * menuLen);
			this.selectMenuCount = (int) (Math.random() * 2) + 1;
		}

		else if (category == 1) {
			this.name = "대식가 " + name;
			this.selectMenuIndex = (int) (Math.random() * menuLen);
			this.selectMenuCount = (int) (Math.random() * 4) + 2;
		}

		else if (category == 2) {
			this.name = "신메뉴 요구 " + name;
			this.selectMenuIndex = (int) (Math.random() * menuLen);
			this.selectMenuCount = 1;
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

}
