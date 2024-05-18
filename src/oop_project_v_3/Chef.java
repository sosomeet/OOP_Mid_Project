package oop_project_v_3;

public class Chef {
	String name;
	int rank;
	boolean[] cookableArray;

	int cookOrderIndex;
	boolean isCooking;

	Chef(String name, int menuLen) {
		constructorChef(name, (int) (Math.random() * 4), menuLen);
	}

	Chef(String name, int rank, int menuLen) {
		constructorChef(name, rank, menuLen);
	}

	private void constructorChef(String name, int rank, int menuLen) {
		this.name = name;
		this.rank = rank;
		this.cookableArray = new boolean[menuLen];
		this.isCooking = false;
		this.cookOrderIndex = -1;

		if (name.equals("")) {
			switch (rank) {
			case 0:
				this.name = "���ʼ���";
				break;
			case 1:
				this.name = "�Ŵ���";
				break;
			case 2:
				this.name = "�߽���";
				break;
			case 3:
				this.name = "�Ƹ�����Ʈ";
				break;
			}
		}
		
		initCookableArray(menuLen);

	}

	public void initCookableArray(int menuLen) {
		this.cookableArray = new boolean[menuLen];
		
		// ���ʼ��� : ��� �丮 ����
		if (rank == 0) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = true;
			}
		}

		// �Ŵ��� : 1�� ���� ����
		else if (rank == 1) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = true;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableArray[temp] = false;
		}

		// �߽��� : �޴� ���� ����
		else if (rank == 2) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = true;
			}

			// �޴� ���ݸ� �����ϰ� ����� �ڵ�
			boolean[] randCookableList = new boolean[this.cookableArray.length];
			int randCount = 0;

			while (true) {
				for (int i = 0; i < this.cookableArray.length; i++) {
					if ((int) (Math.random() * menuLen) == 0) {
						randCookableList[i] = false;
					} else {
						randCookableList[i] = true;
						randCount++;
					}
				}

				// �޴� ���ݸ� �����ϴٸ�
				if (randCount == (int) (this.cookableArray.length / 2)) {
					break;
				} else {
					randCount = 0;
				}
			}

			this.cookableArray = randCookableList;
		}

		// �Ƹ�����Ʈ : �޴� 1�� ����
		else if (rank == 3) {
			for (int i = 0; i < menuLen; i++) {
				this.cookableArray[i] = false;
			}
			int temp = (int) (Math.random() * menuLen);
			this.cookableArray[temp] = true;
		}
	}
}
