package oop_project_v_3;

public class Guest {
	String name;
	int category;
	int leaveTurn;

	Guest() {
		constructorGuest("", this.category = (int) (Math.random() * 3));
	}

	Guest(String name) {
		constructorGuest(name, this.category = (int) (Math.random() * 3));
	}

	Guest(String name, int category) {
		constructorGuest(name, category);
	}

	private void constructorGuest(String name, int category) {
		if (name.equals("")) { // 이름이 설정되지 않았을 경우
			if (category == 0) { // 평범한 손님, 1~2개 주문
				this.name = "평범한 손님";
			}

			else if (category == 1) { // 대식가 손님, 2~5개 주문
				this.name = "소식가 손님";
			}

			else if (category == 2) { // 신메뉴 요구 손님, 새로운 메뉴 제작
				this.name = "대식가 손님";
			}
		} else { // 이름이 설정됐을 경우
			this.name = name;
			this.category = category;
		}
		leaveTurn = 100;
		return;
	}
}