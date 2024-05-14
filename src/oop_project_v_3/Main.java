package oop_project_v_3;

import java.util.Scanner;

public class Main {

	public static void sleep(int time) {
		try {
			Thread.sleep(time * 1000); // time * 1초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 게임 초기화
	public static void initRestaurant(Restaurant restaurant) {
		Menu taco = new Menu("타코", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("브리또타코", "브리또", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("보울타코", "보울", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("크리스피타코", "크리스피콘", restaurant);
		restaurant.addMenu(taco);
		taco = new Menu("또띠아", "또띠아", restaurant);
		restaurant.addMenu(taco);

		Chef chef = new Chef("이치우", 3, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("김준호", 2, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("윤희성", 1, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("박배균", 0, restaurant.getMenuLen());
		restaurant.addChef(chef);
		chef = new Chef("김준석", restaurant.getMenuLen());
		restaurant.addChef(chef);
	}

	// 손님 추가
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
			System.out.println("손님 이름을 입력하십시오.");
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

			System.out.println("손님 이름을 입력하십시오.");
			String name = scan.nextLine();
			System.out.println("손님 유형을 입력하십시오. (0:평범, 1:소식가 2:대식가)");
			String input = scan.next();
			while (!(input.equals("0") || input.equals("1") || input.equals("2"))) {
				System.out.println("다시 입력하십시오.");
				input = scan.next();
			}

			int category = Integer.parseInt(input);
			guest = new Guest(name, category);
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

	// 주문을 요리사에게 배정
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
				System.out.println("요리할 수 있는 사람이 없습니다.");
			}
		}

		return;
	}

	// 주문 중 완료된 것이 있는지 확인
	public static void checkOrder(int turn, Restaurant restaurant) {
		int pay = 0;

		for (int i = 0; i < restaurant.getOrderLen(); i++) {
			if (restaurant.getOrderList().get(i).endTurn == turn) {
				// 가격 계산
				pay = restaurant.getOrderList().get(i).count;
				pay *= restaurant.getMenuList().get(restaurant.getOrderList().get(i).selectMenuIndex).price;
				restaurant.adjustIncome(pay);

				restaurant.getChefList().get(restaurant.getOrderList().get(i).chefIndex).isCooking = false;
				System.out.print(
						"[" + restaurant.getChefList().get(restaurant.getOrderList().get(i).chefIndex).name + "] : ");
				System.out.println(
						"주문하신 [" + restaurant.getMenuList().get(restaurant.getOrderList().get(i).selectMenuIndex).name
								+ "] 나왔습니다.");
				restaurant.leaveOrder(i);
				restaurant.getGuestList().get(i).leaveTurn = turn + 1;
			}
		}

		return;
	}

	// 손님 중 식사를 다 한 사람이 있는지 확인
	public static void checkGuest(int turn, Restaurant restaurant) {
		for (int i = 0; i < restaurant.getGuestLen(); i++) {
			if (restaurant.getGuestList().get(i).leaveTurn == turn) {
				restaurant.leaveGuest(i);
			}
		}

		return;
	}

	public static void printStartDayInputList() {
		System.out.println("\n무엇을 하시겠습니까?");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 영업 시작");
		System.out.println("2. 재고 확인");
		System.out.println("3. 메뉴 확인");
		System.out.println("4. 셰프 확인");
		System.out.println("5. 수입 확인");
		System.out.println("6. 자세한 재고 확인");
		System.out.println("7. 자세한 셰프 확인");
	}

	public static void printWokingInputList() {
		System.out.println("\n무엇을 하시겠습니까?");
		System.out.println("0. 프로그램 종료");
		System.out.println("1. 영업 진행");
		System.out.println("2. 재고 확인");
		System.out.println("3. 메뉴 확인");
		System.out.println("4. 셰프 확인");
		System.out.println("5. 손님 확인");
		System.out.println("6. 주문 확인");
		System.out.println("7. 수입 확인");
		System.out.println("8. 자세한 재고 확인");
		System.out.println("9. 자세한 셰프 확인");
	}

	public static void selectWorkingOption(Scanner scan, Restaurant restaurant) {
		while (true) {
			int input = scan.nextInt();
			if (input == 0) {
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0);
				return;
			} else if (input == 1) {
				return;
			} else if (input == 2) {
				restaurant.printItem();
			} else if (input == 3) {
				restaurant.printMenu();
			} else if (input == 4) {
				restaurant.printChef();
			} else if (input == 5) {
				restaurant.printGuest();
			} else if (input == 6) {
				restaurant.printOrder();
			} else if (input == 7) {
				restaurant.printIncome();
			} else if (input == 8) {
				restaurant.printItemDetail();
			} else if (input == 9) {
				restaurant.printChefDetail();
			} else {
				System.out.println("다시 입력해주십시오.");
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int day = 0;
		int turn = 0;

		Restaurant restaurant = new Restaurant();
		initRestaurant(restaurant);

		while (day != 30) {
			System.out.println("하루를 시작합니다.");
			printStartDayInputList();

			int input = scan.nextInt();
			if (input == 0) {
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				return;
			} else if (input == 1) {
				while (turn != 13) {
					int rand = (int) (Math.random() * 2);
					System.out.println("\n" + (day + 1) + "일 " + (turn + 8) + "시");
					if ((int) (Math.random() * 2) == 1) {
						addGuest(restaurant);
					} else {
						System.out.println("손님이 오지 않았습니다.");
					}
					assignOrder(turn, restaurant);
					checkOrder(turn, restaurant);
					checkGuest(turn, restaurant);

					turn++;
					sleep(1);

					System.out.println("@일시정지하고 싶다면 0을 입력하십시오.@");
					String inputTemp = scan.next();
					if (inputTemp.equals("0")) {
						printWokingInputList();
						selectWorkingOption(scan, restaurant);
					}
				}

				restaurant.initChef();
				restaurant.initGuest();
				restaurant.initOrder();
				System.out.println("하루를 종료합니다.");
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
				restaurant.printIncome();
				day--;
			} else if (input == 6) {
				restaurant.printItemDetail();
				day--;
			} else if (input == 7) {
				restaurant.printChefDetail();
				day--;
			} else {
				System.out.println("다시 입력해주십시오.");
				day--;
			}

			day++;
			turn = 0;
		}

		scan.close();
		return;
	}

}
