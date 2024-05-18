package oop_project_v_3;

public class Chef {
	String name;
	int rank;
	boolean[] cookableArray;

	int cookOrderIndex;
	boolean isCooking;

	Chef(String name, int menuLen) {
		constructorChef(name, (int) (Math.random() * 4), menuLen);
	}

	Chef(String name, int rank, int menuLen) {
		constructorChef(name, rank, menuLen);
	}

	private void constructorChef(String name, int rank, int menuLen) {
		this.name = name;
		this.rank = rank;
		this.cookableArray = new boolean[menuLen];
		this.isCooking = false;
		this.cookOrderIndex = -1;

		if (name.equals("")) {
			switch (rank) {
			case 0:
				this.name = "오너셰프";
				break;
			case 1:
				this.name = "매니저";
				break;
			case 2:
				this.name = "견습생";
				break;
			case 3:
				this.name = "아르바이트";
				break;
			}
		}
		
		initCookableArray(menuLen);

	}

	public void initCookableArray(int menuLen) {
		this.cookableArray = new boolean[menuLen];
		
		// 오너셰프 : 모든 요리 가능
		if (rank == 0) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = true;
			}
		}

		// 매니저 : 1개 빼고 가능
		else if (rank == 1) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = true;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableArray[temp] = false;
		}

		// 견습생 : 메뉴 절반 가능
		else if (rank == 2) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = true;
			}

			// 메뉴 절반만 가능하게 만드는 코드
			boolean[] randCookableList = new boolean[this.cookableArray.length];
			int randCount = 0;

			while (true) {
				for (int i = 0; i < this.cookableArray.length; i++) {
					if ((int) (Math.random() * menuLen) == 0) {
						randCookableList[i] = false;
					} else {
						randCookableList[i] = true;
						randCount++;
					}
				}

				// 메뉴 절반만 가능하다면
				if (randCount == (int) (this.cookableArray.length / 2)) {
					break;
				} else {
					randCount = 0;
				}
			}

			this.cookableArray = randCookableList;
		}

		// 아르바이트 : 메뉴 1개 가능
		else if (rank == 3) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = false;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableArray[temp] = true;
		}
	}
}
