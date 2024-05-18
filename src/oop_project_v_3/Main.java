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

	// 메뉴 추가
	public static void addMenu(Restaurant restaurant) {
		Scanner scan = new Scanner(System.in);

		System.out.println("메뉴 이름을 입력하십시오.");
		String menuName = scan.nextLine();

		System.out.println("메인 재료를 선택하시겠습니까? (0 : 네, 1 : 아니오)");
		String selectOption = "0";

		boolean isOk = false;
		while (!isOk) {
			selectOption = scan.next();
			if (selectOption.equals("0") || selectOption.equals("1")) {
				isOk = true;
			} else {
				System.out.println("다시 입력해 주십시오.");
			}
		}

		System.out.println("어떤 메인 재료를 선택하시겠습니까?");
		System.out.println("브리또, 보울, 크리스피콘, 또띠아");

		String selectItem = "";
		isOk = false;
		while (!isOk) {
			selectItem = scan.next();
			if (selectItem.equals("브리또") || selectItem.equals("보울") || selectItem.equals("크리스피콘")
					|| selectItem.equals("또띠아")) {
				isOk = true;
			} else {
				System.out.println("다시 입력해 주십시오.");
			}
		}

		Menu newMenu = new Menu("", restaurant);
		if (selectOption.equals("1")) {
			newMenu = new Menu(menuName, restaurant);
		} else if (selectOption.equals("0")) {
			newMenu = new Menu(menuName, selectItem, restaurant);
		}
		restaurant.addMenu(newMenu);
		System.out.println(menuName + "메뉴가 추가되었습니다.");

		return;
	}

	// 메뉴 삭제
	public static void deleteMenu(Restaurant restaurant) {
		Scanner scan = new Scanner(System.in);

		System.out.println("삭제할 메뉴 이름을 입력하십시오.");
		String menuName = scan.nextLine();

		for (int i = 0; i < restaurant.getMenuLen(); i++) {
			if (restaurant.getMenuList().get(i).name.equals(menuName)) {
				System.out.println(restaurant.getMenuList().get(i).name + " 메뉴를 삭제합니다.");
				restaurant.deleteMenu(i);
			}
		}
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
		// 요리가 됐는지 확인하는 flag
		boolean isCooked = false;

		// 아직 처리하지 못한 주문의 길이만큼 반복
		for (int i = 0; i < restaurant.getOrderLen(); i++) {
			isCooked = false;

			// 손님이 선택한 메뉴의 인덱스
			int selectMenuIndex = restaurant.getOrderList().get(i).selectMenuIndex;

			// 셰프의 수 만큼 반복
			for (int j = 0; j < restaurant.getChefLen(); j++) {
				// !(주문이 이미 요리 시작했는지) && 일할 수 있는 셰프가 있는지
				// true면 요리 시작
				if (!restaurant.getOrderList().get(i).isCooked && restaurant.assignChef(j, selectMenuIndex, i)) {
					restaurant.reduceItem(selectMenuIndex);
					restaurant.addItem();

					restaurant.getOrderList().get(i).setEndTurn(turn + 1);
					restaurant.getOrderList().get(i).isCooked = true;
					isCooked = true;
					break;
				}
			}

			// 요리가 시작되지 않고, 요리 상태가 요리 중이지도 않으면
			if (!isCooked && !restaurant.getOrderList().get(i).isCooked) {
				System.out.println("요리할 수 있는 사람이 없습니다.");
			}
		}

		return;
	}

	// 주문 중 완료된 것이 있는지 확인
	public static void checkOrder(int turn, Restaurant restaurant) {
		for (int i = 0; i < restaurant.getOrderLen(); i++) {
			// 만약 주문이 완성되는 턴이 지금 턴과 같다면
			if (restaurant.getOrderList().get(i).endTurn == turn) {

				// 가격 계산
				int pay = restaurant.getOrderList().get(i).count;
				pay *= restaurant.getMenuList().get(restaurant.getOrderList().get(i).selectMenuIndex).price;
				restaurant.adjustIncome(pay);

				// 셰프의 상태 변경
				restaurant.getChefList().get(restaurant.getOrderList().get(i).chefIndex).isCooking = false;
				System.out.print(
						"[" + restaurant.getChefList().get(restaurant.getOrderList().get(i).chefIndex).name + "] : ");
				System.out.println(
						"주문하신 [" + restaurant.getMenuList().get(restaurant.getOrderList().get(i).selectMenuIndex).name
								+ "] 나왔습니다.");

				// 주문 완료 시 리스트에서 제외
				restaurant.leaveOrder(i);
				// 손님이 떠나는 턴
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
		System.out.println("7. 자세한 메뉴 확인");
		System.out.println("8. 자세한 셰프 확인");
		System.out.println("9. 메뉴 추가");
		System.out.println("10. 메뉴 삭제");
	}

	public static void printWokingOption() {
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
				System.out.println("프로그램을 종료합니다.\n");
				sleep(1);
				System.out.println("■■■■■■■■■■■■■■■■■■");
				System.out.println("■ You Loved Taco ■");
				System.out.println("■■■■■■■■■■■■■■■■■■\n");
				sleep(3);
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

		System.out.println("■■■■■■■■■■■■■■■");
		System.out.println("■ I Love Taco ■");
		System.out.println("■■■■■■■■■■■■■■■\n");

		while (day != 30) {
			System.out.println("하루를 시작합니다.");
			printStartDayInputList();

			int input = scan.nextInt();
			if (input == 0) {
				System.out.println("프로그램을 종료합니다.\n");
				sleep(1);
				System.out.println("■■■■■■■■■■■■■■■■■■");
				System.out.println("■ You Loved Taco ■");
				System.out.println("■■■■■■■■■■■■■■■■■■\n");
				sleep(3);
				scan.close();
				return;
			} else if (input == 1) {
				while (turn != 13) {
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

					System.out.println("※일시정지하고 싶다면 0을 입력하십시오※");
					String inputTemp = scan.next();
					if (inputTemp.equals("0")) {
						printWokingOption();
						selectWorkingOption(scan, restaurant);
					}

				}

				restaurant.initChef();
				restaurant.initGuest();
				restaurant.initOrder();
				System.out.println("\n하루를 종료합니다.");
				restaurant.printIncome();
				System.out.println();

				day++;
				turn = 0;

			} else if (input == 2) {
				restaurant.printItem();
			} else if (input == 3) {
				restaurant.printMenu();
			} else if (input == 4) {
				restaurant.printChef();
			} else if (input == 5) {
				restaurant.printIncome();
			} else if (input == 6) {
				restaurant.printItemDetail();
			} else if (input == 7) {
				restaurant.printMenuDetail();
			} else if (input == 8) {
				restaurant.printChefDetail();
			} else if (input == 9) {
				addMenu(restaurant);
			} else if (input == 10) {
				deleteMenu(restaurant);
			} else {
				System.out.println("다시 입력해주십시오.");
			}
		}

		System.out.println("■■■■■■■■■■■■■■■■■■");
		System.out.println("■ You Loved Taco ■");
		System.out.println("■■■■■■■■■■■■■■■■■■\n");

		scan.close();
		return;
	}

}
