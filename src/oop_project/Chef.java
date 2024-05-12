package oop_project;

public class Chef extends Restaurant {

	private String name; // ���� �̸�
	private String rank; // ���� ���
	private boolean[] cookableMenu; // �丮 ������ �޴� ����Ʈ

	// �⺻ ������
	Chef() {
		InitChef("0", 0, 0);
	}

	// �̸��� ������ ������ �����ε�
	Chef(String name, int menuLen) {
		int rank = (int) (Math.random() * 4);
		InitChef(name, rank, menuLen);
	}

	// �̸��� ����� ������ ������ �����ε�
	Chef(String name, int menuLen, int rank) {
		InitChef(name, rank, menuLen);
	}

	// ���� �ʱ�ȭ �Լ�
	public void InitChef(String name, int rank, int menuLen) {
		// ��޿� ���� ���� ���� �ʱ�ȭ

		// ���ʼ��� : ��� �丮 ����
		if (rank == 0) {
			this.name = name;
			this.rank = "���ʼ���";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}
		}

		// �Ŵ��� : 1�� ���� ����
		else if (rank == 1) {
			this.name = name;
			this.rank = "�Ŵ���";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableMenu[temp] = false;
		}

		// �߽��� : �޴� ���� ����
		else if (rank == 2) {
			this.name = name;
			this.rank = "�߽���";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = true;
			}

			// �޴� ���ݸ� �����ϰ� ����� �ڵ�
			boolean[] randCookableList = new boolean[this.cookableMenu.length];
			int randCount = 0;
			
			while (true) {
				for (int i = 0; i < this.cookableMenu.length; i++) {
					if ((int) (Math.random() * menuLen) == 0) {
						randCookableList[i] = false;
					} else {
						randCookableList[i] = true;
						randCount++;
					}
				}
				
				// �޴� ���ݸ� �����ϴٸ�
				if(randCount != (int) (this.cookableMenu.length / 2)) {
					break;
				}
				else {
					randCount = 0;
				}
			}
			
			this.cookableMenu = randCookableList;
		}

		// �Ƹ�����Ʈ : �޴� 1�� ����
		else if (rank == 3) {
			this.name = name;
			this.rank = "�Ƹ�����Ʈ";
			this.cookableMenu = new boolean[menuLen];
			for (int i = 0; i < menuLen; i++) {
				this.cookableMenu[i] = false;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableMenu[temp] = true;
		}

		return;
	}

	// �丮 ������ �޴� ���
	public void PrintCookableMenu(Menu[] menuList, int menuLen) {
		System.out.print(this.name + "�� �丮 ������ �޴� : ");
		for (int i = 0; i < menuLen; i++) {
			if (this.cookableMenu[i]) {
				System.out.print(menuList[i].GetName() + " ");
			}
		}
		System.out.println();
		return;
	}

	
	// ������ �̸� ��ȯ
	public String GetName() {
		return this.name;
	}
	
	// ������ ��� ��ȯ
	public String GetRank() {
		return this.rank;
	}

	// ������ ������ �丮���� Ȯ��
	public boolean IsCookable(int guestSelectMenuIndex) {
		boolean isCookable = false;

		if (this.cookableMenu[guestSelectMenuIndex]) {
			isCookable = true;
		}

		return isCookable;
	}

	// �⺻ ���� ���
	// �̸� : ���
	public void PrintChef(Chef chef, int chefLen) {
		System.out.println(chef.GetName() + " " + chef.GetRank());
		return;
	}

	// �ڼ��� ���� ���
	// �̸� : ���, �丮 ������ �޴�
	public void PrintChefDetail(Chef chef, Menu[] menuList) {
		System.out.println(chef.GetName() + " " + chef.GetRank() + ",");
		chef.PrintCookableMenu(menuList, menuList.length);
		return;
	}

	// 0�� �մ��� �ֹ��� �޴��� ������ �丮
	public boolean Cook(Restaurant restaurant, Menu[] menuList, Guest[] guestList) {
		if (this.IsCookable(guestList[0].GetSelectMenuIndex())) {
			restaurant.AdjustItemStock(menuList[guestList[0].GetSelectMenuIndex()].GetUseItemList());
			restaurant.SetItemStock();
			System.out.println(guestList[0].GetSelectMenuName(menuList) + "�� " + this.name + "�� �丮�մϴ�.");
			return true;
		}

		return false;
	}

}