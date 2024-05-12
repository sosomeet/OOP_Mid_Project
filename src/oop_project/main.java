package oop_project;

public class Main {

	// �޴� �߰��ϴ� �Լ�
	public static Menu[] AddMenu(String name, Menu[] menuList) {
		Menu[] newMenuList = new Menu[menuList.length + 1]; // �������� ũ�Ⱑ 1ū ����Ʈ
		int i;
		for (i = 0; i < menuList.length; i++) { // ���� �޴� �߰�
			newMenuList[i] = menuList[i];
		}
		newMenuList[i] = new Menu(name); // �ű� �޴� �߰�
		menuList = newMenuList; // �޴�����Ʈ ����

		return menuList;
	}

	// ������ �̸��� �Է¹ް� �߰��ϴ� �Լ� �����ε�
	public static Chef[] AddChef(String name, Chef[] chefList, int menuLen) {
		Chef[] newchefList = new Chef[chefList.length + 1]; // �������� ũ�Ⱑ 1ū ����Ʈ
		int i;
		for (i = 0; i < chefList.length; i++) { // ���� ���� �߰�
			newchefList[i] = chefList[i];
		}
		newchefList[i] = new Chef(name, menuLen); // �ű� ���� �߰�
		chefList = newchefList; // ��������Ʈ ����

		return chefList;
	}

	// ������ �̸��� ����� �Է¹ް� �߰��ϴ� �Լ� �����ε�
	public static Chef[] AddChef(String name, int rank, Chef[] chefList, int menuLen) {
		Chef[] newChefList = new Chef[chefList.length + 1]; // �������� ũ�Ⱑ 1ū ����Ʈ
		int i;
		for (i = 0; i < chefList.length; i++) { // ���� ���� �߰�
			newChefList[i] = chefList[i];
		}
		newChefList[i] = new Chef(name, menuLen, rank); // �ű� ���� �߰�
		chefList = newChefList; // ��������Ʈ ����

		return chefList;
	}

	// �մ��� �̸��� �Է¹ް� �߰��ϴ� �Լ� �����ε�
	public static Guest[] AddGuest(String name, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + 1]; // �������� ũ�Ⱑ 1ū ����Ʈ
		int i;
		for (i = 0; i < guestList.length; i++) { // ���� �մ� �߰�
			newGuestList[i] = guestList[i];
		}
		newGuestList[i] = new Guest(name, menuLen); // �ű� �մ� �߰�
		guestList = newGuestList; // �մ� ����Ʈ ����

		return guestList;
	}

	// �մ��� �̸��� ������ �Է¹ް� �߰��ϴ� �Լ� �����ε�
	public static Guest[] AddGuest(String name, int category, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + 1]; // �������� ũ�Ⱑ 1ū ����Ʈ
		int i;
		for (i = 0; i < guestList.length; i++) { // ���� �մ� �߰�
			newGuestList[i] = guestList[i];
		}
		newGuestList[i] = new Guest(name, menuLen, category); // �ű� �մ� �߰�
		guestList = newGuestList; // �մ� ����Ʈ ����

		return guestList;
	}

	// �մ��� n�� �߰��ϴ� �Լ� �����ε�
	public static Guest[] AddGuest(int count, Guest[] guestList, int menuLen) {
		Guest[] newGuestList = new Guest[guestList.length + count]; // �������� ũ�Ⱑ count��ŭ ū ����Ʈ
		for (int i = 0; i < guestList.length; i++) { // ���� �մ� �߰�
			newGuestList[i] = guestList[i];
		}

		for (int i = guestList.length; i < guestList.length + count; i++) { // �ű� �մ� n�� �߰�
			newGuestList[i] = new Guest(menuLen);
		}
		guestList = newGuestList; // �մ� ����Ʈ ����

		return guestList;
	}

	// �մ��� n�� �����ϴ� �Լ� �����ε�
	public static Guest[] LeaveGuest(int count, Restaurant restaurant, Guest[] guestList, Menu[] menuList) {
		Guest[] newGuestList = new Guest[guestList.length - count]; // �������� ũ�Ⱑ count��ŭ ���� ����Ʈ
		for (int i = 0; i < count; i++) { // �޴� ���� * �޴� ���� ��ŭ�� ���� �߰�
			restaurant.AdjustIncome(
					menuList[guestList[i].GetSelectMenuIndex()].GetPrice() * guestList[i].GetSelectCount());
		}

		for (int i = count; i < guestList.length; i++) { // count���� ���� �մ� �߰�
			newGuestList[i] = guestList[i];
		}
		guestList = newGuestList; // �մ� ����Ʈ ����

		return guestList;
	}

	// �⺻ �޴� ���
	public static void PrintMenuList(Menu[] menuList, Restaurant restaurant) {
		System.out.println("�޴� " + menuList.length + "��");
		for (int i = 0; i < menuList.length; i++) { // �޴� �̸� ���
			menuList[i].PrintMenu(restaurant.GetItemNameList());
		}
		System.out.println();
		
		return;
	}

	// �ڼ��� �޴� ���
	public static void PrintMenuListDetail(Menu[] menuList, Restaurant restaurant) {
		System.out.println("�޴� " + menuList.length + "��");
		for (int i = 0; i < menuList.length; i++) { // �޴� �̸��� ���� ��� ���� ���
			menuList[i].PrintMenuDetail(restaurant.GetItemNameList());
		}
		System.out.println();
		
		return;
	}

	// �⺻ ���� ���
	public static void PrintChefList(Chef[] chefList) {
		System.out.println("���� " + chefList.length + "��");
		for (int i = 0; i < chefList.length; i++) { // ���� �̸��� ���� ���
			chefList[i].PrintChef(chefList[i], chefList.length);
		}
		System.out.println();
		
		return;
	}

	// �ڼ��� ���� ���
	public static void PrintChefListDetail(Chef[] chefList, Menu[] menuList) {
		System.out.println("���� " + chefList.length + "��");
		for (int i = 0; i < chefList.length; i++) { // ���� �̸��� ����, �丮 ������ �޴� ���
			chefList[i].PrintChefDetail(chefList[i], menuList);
		}
		System.out.println();
		
		return;
	}

	// ������ �մ� ���
	public static void PrintGuestListSimple(Guest[] guestList, Menu[] menuList) {
		System.out.println("�մ� " + guestList.length + "��");
		for (int i = 0; i < guestList.length; i++) {
			// �մ��� �� ���İ� ���� ���
			System.out.println(guestList[i].GetSelectMenuName(menuList) + " " + guestList[i].GetSelectCount() + "��");
		}
		System.out.println();
		return;
	}

	// �⺻ �մ� ���
	public static void PrintGuestList(Guest[] guestList, Menu[] menuList) {
		System.out.println("�մ� " + guestList.length + "��");
		for (int i = 0; i < guestList.length; i++) {
			// �մ��� �̸� : �� ���İ� ���� ���
			System.out.println(guestList[i].GetName() + " : " + guestList[i].GetSelectMenuName(menuList) + " "
					+ guestList[i].GetSelectCount() + "��");
		}
		System.out.println();
		
		return;
	}
	
	// �ڼ��� �մ� ���
	public static void PrintGuestListDetail(Guest[] guestList, Menu[] menuList) {
		System.out.println("�մ� " + guestList.length + "��");
		for (int i = 0; i < guestList.length; i++) {
			// �մ��� �̸� ���� : n	�� ���İ� ���� ���
			System.out.print(guestList[i].GetName() + " ���� : " + guestList[i].GetCategory() + " \t");
			System.out.println(guestList[i].GetSelectMenuName(menuList) + guestList[i].GetSelectCount() + "��");
		}
		System.out.println();
		
		return;
	}

	//�մ��� �ֹ��� �丮 ����
	public static Guest[] Cook(int cooked, Restaurant restaurant, Menu[] menuList, Chef[] chefList, Guest[] guestList) {
		for (int k = 0; k <= cooked; k++) { // n�� �丮 ����
			for (int i = 0; i < chefList.length; i++) { // �丮 ������ ����
				// �丮 ������ ���� Ȯ��
				if (chefList[i].Cook(restaurant, menuList, guestList)) {
					// �丮 �����ϴٸ� �մ��� ����
					guestList = LeaveGuest(1, restaurant, guestList, menuList);
					break;
				}
			}
		}

		return guestList; // �մ� ����Ʈ ��ȯ
	}

	public static void main(String[] args) {
		// �ð�
		int turn = 0;

		// �������
		Restaurant restaurant = new Restaurant();

		// �޴� ����Ʈ
		Menu[] menuList = new Menu[0];

		// ���� ����Ʈ
		Chef[] chefList = new Chef[0];

		// �մ� ����Ʈ
		Guest[] guestList = new Guest[0];

	}

}
