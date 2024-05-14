package oop_project_v_3;

import java.util.Scanner;

public class Main {

	public static void sleep(int time) {
		try {
			Thread.sleep(time * 1000); // time * 1�� ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// ���� �ʱ�ȭ
	public static void initRestaurant(Restaurant restaurant) {
		Menu taco = new Menu("Ÿ��", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("�긮��Ÿ��", "�긮��", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("����Ÿ��", "����", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("ũ������Ÿ��", "ũ��������", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("�Ƕ��", "�Ƕ��", restaurant);
		restaurant.addMenu(taco);

		Chef chef = new Chef("��ġ��", 3, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("����ȣ", 2, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("����", 1, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("�ڹ��", 0, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("���ؼ�", restaurant.getMenuLen());
		restaurant.addChef(chef);
	}

	// �մ� �߰�
	public static void addGuest(Restaurant restaurant) {
		Guest guest;
		Order order;
		int rand = (int) (Math.random() * 10);

		if (rand == 0) {
			rand = (int) (Math.random() * 4) + 1;
			for (int i = 0; i < rand; i++) {
				guest = new Guest();
				restaurant.addGuest(guest);

				System.out.print(guest.name + " : ");
				order = new Order(guest.category, restaurant.getMenuList());
				restaurant.addOrder(order);
			}

			return;
		}

		else if (rand == 1) {
			Scanner scan = new Scanner(System.in);
			System.out.println("�մ� �̸��� �Է��Ͻʽÿ�.");
			String name = scan.nextLine();

			guest = new Guest(name);
			restaurant.addGuest(guest);

			System.out.print(guest.name + " : ");
			order = new Order(guest.category, restaurant.getMenuList());
			restaurant.addOrder(order);

			return;
		}

		else if (rand == 2) {
			Scanner scan = new Scanner(System.in);

			System.out.println("�մ� �̸��� �Է��Ͻʽÿ�.");
			String name = scan.nextLine();
			System.out.println("�մ� ������ �Է��Ͻʽÿ�.");
			int input = scan.nextInt();
			while (!(input <= 2 && input >= 0)) {
				System.out.println("�ٽ� �Է��Ͻʽÿ�.");
				input = scan.nextInt();
			}

			guest = new Guest(name, input);
			restaurant.addGuest(guest);

			System.out.print(guest.name + " : ");
			order = new Order(guest.category, restaurant.getMenuList());
			restaurant.addOrder(order);

			return;
		}

		else if (rand == 3) {
			for (int i = 0; i < 2; i++) {
				guest = new Guest();
				restaurant.addGuest(guest);

				System.out.print(guest.name + " : ");
				order = new Order(guest.category, restaurant.getMenuList());
				restaurant.addOrder(order);
			}

			return;
		}

		else {
			guest = new Guest();
			restaurant.addGuest(guest);

			System.out.print(guest.name + " : ");
			order = new Order(guest.category, restaurant.getMenuList());
			restaurant.addOrder(order);

			return;
		}
	}

	// �ֹ��� �丮�翡�� ����
	public static void assignOrder(int turn, Restaurant restaurant) {
		boolean isCooked = false;

		for (int i = 0; i < restaurant.getOrderLen(); i++) {
			isCooked = false;
			int selectMenuIndex = restaurant.getOrderList().get(i).selectMenuIndex;
			for (int j = 0; j < restaurant.getChefLen(); j++) {
				if (!restaurant.getOrderList().get(i).isCooked && restaurant.assignChef(j, selectMenuIndex, i)) {
					restaurant.reduceItem(selectMenuIndex);
					restaurant.addItem();

					restaurant.getOrderList().get(i).setEndTurn(turn + 1);
					restaurant.getOrderList().get(i).isCooked = true;
					isCooked = true;
					break;
				}
			}
			if (!isCooked && !restaurant.getOrderList().get(i).isCooked) {
				System.out.println("�丮�� �� �ִ� ����� �����ϴ�.");
			}
		}

		return;
	}

	// �ֹ� �� �Ϸ�� ���� �ִ��� Ȯ��
	public static void checkOrder(int turn, Restaurant restaurant) {
		int pay = 0;

		for (int i = 0; i < restaurant.getOrderLen(); i++) {
			if (restaurant.getOrderList().get(i).endTurn == turn) {
				// ���� ���
				pay = restaurant.getOrderList().get(i).count;
				pay *= restaurant.getMenuList().get(restaurant.getOrderList().get(i).selectMenuIndex).price;
				restaurant.adjustIncome(pay);

				restaurant.getChefList().get(restaurant.getOrderList().get(i).chefIndex).isCooking = false;
				System.out.print(
						"[" + restaurant.getChefList().get(restaurant.getOrderList().get(i).chefIndex).name + "] : ");
				System.out.println(
						"�ֹ��Ͻ� [" + restaurant.getMenuList().get(restaurant.getOrderList().get(i).selectMenuIndex).name
								+ "] ���Խ��ϴ�.");
				restaurant.leaveOrder(i);
				restaurant.getGuestList().get(i).leaveTurn = turn + 1;
			}
		}

		return;
	}

	// �մ� �� �Ļ縦 �� �� ����� �ִ��� Ȯ��
	public static void checkGuest(int turn, Restaurant restaurant) {
		for (int i = 0; i < restaurant.getGuestLen(); i++) {
			if (restaurant.getGuestList().get(i).leaveTurn == turn) {
				restaurant.leaveGuest(i);
			}
		}

		return;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int day = 0;
		int turn = 0;

		Restaurant restaurant = new Restaurant();
		initRestaurant(restaurant);

		while (day != 30) {
			System.out.println("�Ϸ縦 �����մϴ�.\n");
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.println("1. ���� ����");
			System.out.println("2. ��� Ȯ��");
			System.out.println("3. �޴� Ȯ��");
			System.out.println("4. ���� Ȯ��");
			System.out.println("5. �մ� Ȯ��");
			System.out.println("6. �ֹ� Ȯ��");
			System.out.println("7. ���� Ȯ��");
			System.out.println("8. �ڼ��� ��� Ȯ��");
			System.out.println("9. �ڼ��� ���� Ȯ��");

			int input = scan.nextInt();

			if (input == 1) {
				while (turn != 13) {
					int rand = (int) (Math.random() * 2);
					System.out.println("\n" + (day + 1) + "�� " + (turn + 8) + "��");
					if ((int) (Math.random() * 2) == 1) {
						addGuest(restaurant);
					} else {
						System.out.println("�մ��� ���� �ʾҽ��ϴ�.");
					}
					assignOrder(turn, restaurant);
					checkOrder(turn, restaurant);
					checkGuest(turn, restaurant);

					sleep(1);
					turn++;
				}

				restaurant.initChef();
				restaurant.initGuest();
				restaurant.initOrder();
				System.out.println("�Ϸ縦 �����մϴ�.");
				restaurant.printIncome();
				System.out.println();

			} else if (input == 2) {
				restaurant.printItem();
				day--;
			} else if (input == 3) {
				restaurant.printMenu();
				day--;
			} else if (input == 4) {
				restaurant.printChef();
				day--;
			} else if (input == 5) {
				restaurant.printGuest();
				day--;
			} else if (input == 6) {
				restaurant.printOrder();
				day--;
			} else if (input == 7) {
				restaurant.printIncome();
				day--;
			} else if (input == 8) {
				restaurant.printItemDetail();
				day--;
			} else if (input == 8) {
				restaurant.printChefDetail();
				day--;
			} else {
				System.out.println("�ٽ� �Է����ֽʽÿ�.");
				day--;
			}

			day++;
			turn = 0;
		}

		return;
	}

}