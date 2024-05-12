package oop_project;

public class Guest extends Restaurant {
	private String name; // �մ��� �̸�
	private int category; // �մ��� ���� 0 = ���, 1 = ��İ�, 2 = �Ÿ޴�
	private int selectMenuIndex; // �մ��� ������ �޴��� index
	private int selectMenuCount; // �մ��� ������ �޴��� ����

	// �⺻ ������
	Guest() {
		this.name = "";
		this.category = 0;
		this.selectMenuCount = 0;
		this.selectMenuCount = 0;
	}

	// n�� �����Ǵ� �մ� ������ �����ε�
	Guest(int menuLen) {
		this.category = (int) (Math.random() * 3); // ������ ���� ����
		AddGuest("", menuLen, this.category);

	}

	// �̸��� ������ ������ �����ε�
	Guest(String name, int menuLen) {
		AddGuest(name, menuLen, this.category);

	}

	// �̸��� �մ� ������ ������ ������ �����ε�
	Guest(String name, int menuLen, int category) {
		AddGuest(name, menuLen, category);
	}

	// �մ� �߰� �Լ�
	public void AddGuest(String name, int menuLen, int category) {
		boolean isCreated = false; // �մ��� �߰��Ǿ����� Ȯ��

		while (!isCreated) { // �մ��� �߰��� �� ���� �ݺ�

			if (name.equals("")) { // �̸��� �������� �ʾ��� ���
				if (category == 0) { // ����� �մ�, 1~2�� �ֹ�
					this.name = "����� �մ�";
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 2) + 1;
					isCreated = true;
				}

				else if (category == 1) { // ��İ� �մ�, 2~5�� �ֹ�
					this.name = "��İ� �մ�";
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 4) + 2;
					isCreated = true;
				}

				else if (category == 2) { // �Ÿ޴� �䱸 �մ�, ���ο� �޴� ����
					this.category = (int) (Math.random() * 3); // �Ÿ޴� �䱸 �մ��� Ȯ�� ���� �ڵ� 1/3 * 1/3 = 1/9 Ȯ���� ����
					if (category == 2) {
						this.name = "�Ÿ޴� �մ�";
						this.selectMenuIndex = (int) (Math.random() * menuLen);
						this.selectMenuCount = 1;
						isCreated = true;
					} else {
						isCreated = false;
					}
				}
			} else { // �̸��� �������� ���
				if (category == 0) {
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 2) + 1;
					isCreated = true;
				}

				else if (category == 1) {
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = (int) (Math.random() * 4) + 2;
					isCreated = true;
				}

				else if (category == 2) {
					this.category = (int) (Math.random() * 3);
					this.name = name;
					this.selectMenuIndex = (int) (Math.random() * menuLen);
					this.selectMenuCount = 1;
					isCreated = true;
				}
			}
		}

		return;
	}

	// �մ� �̸� ��ȯ
	public String GetName() {
		return this.name;
	}

	// �մ� ���� ��ȯ
	public int GetCategory() {
		return this.category;
	}

	// �մ��� ������ �޴��� �ε��� ��ȯ
	public int GetSelectMenuIndex() {
		return this.selectMenuIndex;
	}

	// �մ��� ������ �޴��� �̸� ��ȯ
	public String GetSelectMenuName(Menu[] menuList) {
		return menuList[this.selectMenuIndex].GetName();
	}

	// �մ��� ������ �޴��� ���� ��ȯ
	public int GetSelectCount() {
		return this.selectMenuCount;
	}

	// ������ �մ� ����Ʈ ���
	// �մ� n��
	// �޴��� n��
	public void PrintGuestListSimple(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("�մ� " + guestLen + "��");
		for (int i = 0; i < guestLen; i++) {
			System.out.println(guestList[i].GetSelectMenuName(menuList) + " " + guestList[i].GetSelectCount() + "��");
		}
		System.out.println();
		
		return;
	}

	// �⺻ �մ� ����Ʈ ���
	// �մ� n��
	// �մ� �̸� : �޴��� n��
	public void PrintGuestList(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("�մ� " + guestLen + "��");
		for (int i = 0; i < guestLen; i++) {
			System.out.println(guestList[i].GetName() + " : " + guestList[i].GetSelectMenuName(menuList) + " "
					+ guestList[i].GetSelectCount() + "��");
		}
		System.out.println();
		
		return;
	}

	// �ڼ��� �մ� ����Ʈ ���
	// �մ� n��
	// �մ� �̸� ���� : n	�޴��� n��
	public void PrintGuestListDetail(Guest[] guestList, int guestLen, Menu[] menuList) {
		System.out.println("�մ� " + guestLen + "��");
		for (int i = 0; i < guestLen; i++) {
			System.out.print(guestList[i].GetName() + " ���� : " + guestList[i].GetCategory() + " \t");
			System.out.println(guestList[i].GetSelectMenuName(menuList) + guestList[i].GetSelectCount() + "��");
		}
		System.out.println();
		
		return;
	}

}
