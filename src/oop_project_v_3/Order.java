package oop_project_v_3;

import java.util.ArrayList;

public class Order {
	int selectMenuIndex;
	int count;
	int endTurn;
	int chefIndex;
	boolean isCooked;
	
	Order(int category, ArrayList<Menu> menuList){
		selectMenuIndex = (int)(Math.random() * menuList.size());
		endTurn = 100;
		isCooked = false;
		chefIndex = -1;
		
		if(category == 0) {
			count = (int)(Math.random() * 1) + 1;
		}
		else if(category == 1) {
			count = 1;
		}
		else if(category == 2) {
			count = (int)(Math.random() * 4) + 2;
		}		

		System.out.println("여기 " + menuList.get(selectMenuIndex).name + " " + count + "개 주세요" );
	}
	
	public int getSelectMenuIndex() {
		return this.selectMenuIndex;
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void setEndTurn(int endTurn) {
		this.endTurn = endTurn;
		return;
	}
	
	public int getEndTurn() {
		return this.endTurn;
	}
	
	public int getChefIndex() {
		return chefIndex;
	}
	
	public void setChefIndex(int index) {
		this.chefIndex = index;
		return;
	}
	
}