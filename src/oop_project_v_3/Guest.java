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
		if (name.equals("")) { // �̸��� �������� �ʾ��� ���
			if (category == 0) { // ����� �մ�, 1~2�� �ֹ�
				this.name = "����� �մ�";
			}

			else if (category == 1) { // ��İ� �մ�, 2~5�� �ֹ�
				this.name = "�ҽİ� �մ�";
			}

			else if (category == 2) { // �Ÿ޴� �䱸 �մ�, ���ο� �޴� ����
				this.name = "��İ� �մ�";
			}
		} else { // �̸��� �������� ���
			this.name = name;
			this.category = category;
		}
		leaveTurn = 100;
		return;
	}
}