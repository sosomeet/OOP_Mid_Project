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
			// Restaurant Ŭ������ GetItemLen()�� ����Ϸ��� ��� ������ ����Ʈ�� �޾ƿͼ� �ʱ�ȭ��
			useItems[i] = new int[restaurant.getItem()[i].length];
		}

		// �� �׸� ���� ���� ���
		for (int i = 0; i < useItems.length; i++) {
			if (i == 0) {
				if (requireItem.equals("")) {
					useItems[i][(int) (Math.random() * 4)] = 1;
				} else if (requireItem.equals("�긮��")) {
					useItems[i][0] = 1;
				} else if (requireItem.equals("����")) {
					useItems[i][1] = 1;
				} else if (requireItem.equals("ũ��������")) {
					useItems[i][2] = 1;
				} else if (requireItem.equals("�Ƕ��")) {
					useItems[i][3] = 1;
				}
				for (int j = 0; j < useItems[i].length; j++) {
					price += useItems[i][j] * restaurant.getItemPrice()[i][j];
				}

				continue;
			}
			for (int j = 0; j < useItems[i].length; j++) {
				useItems[i][j] = (int) (Math.random() * 3);

				// ��� ���� ������ ���Ͽ� ��ü ���� ���ϱ�
				price += useItems[i][j] * restaurant.getItemPrice()[i][j];
			}
		}

		// �Ҽ��� ��° �ڸ����� �ݿø�
		// ������ 3.5�� �Ǵ� ������ �޾� ���� Ȯ��
		price = (int) (price * 3.5f / 100) * 100;
	}
}
