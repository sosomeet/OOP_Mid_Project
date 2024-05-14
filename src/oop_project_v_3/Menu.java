package oop_project_v_3;

public class Menu {
	String name;
	int price;
	int[][] useItems;

	Menu(String name, Restaurant restaurant) {
		constructorMenu(name, "", restaurant);
	}
	
	Menu(String name, String requireItem, Restaurant restaurant) {
		constructorMenu(name, requireItem, restaurant);
	}

	private void constructorMenu(String name, String requireItem, Restaurant restaurant) {
		this.name = name;
		price = 0;
		useItems = new int[restaurant.getItem().length][];

		for (int i = 0; i < useItems.length; i++) {
			// Restaurant 클래스의 GetItemLen()로 사용하려는 재료 개수의 리스트를 받아와서 초기화함
			useItems[i] = new int[restaurant.getItem()[i].length];
		}

		// 각 항목에 대한 가격 계산
		for (int i = 0; i < useItems.length; i++) {
			if (i == 0) {
				if (requireItem.equals("")) {
					useItems[i][(int) (Math.random() * 4)] = 1;
				} else if (requireItem.equals("브리또")) {
					useItems[i][0] = 1;
				} else if (requireItem.equals("보울")) {
					useItems[i][1] = 1;
				} else if (requireItem.equals("크리스피콘")) {
					useItems[i][2] = 1;
				} else if (requireItem.equals("또띠아")) {
					useItems[i][3] = 1;
				}
				for (int j = 0; j < useItems[i].length; j++) {
					price += useItems[i][j] * restaurant.getItemPrice()[i][j];
				}

				continue;
			}
			for (int j = 0; j < useItems[i].length; j++) {
				useItems[i][j] = (int) (Math.random() * 3);

				// 모든 재료와 가격을 곱하여 전체 가격 구하기
				price += useItems[i][j] * restaurant.getItemPrice()[i][j];
			}
		}

		// 소숫점 둘째 자리에서 반올림
		// 원가의 3.5배 되는 가격을 받아 마진 확보
		price = (int) (price * 3.5f / 100) * 100;
	}
}
