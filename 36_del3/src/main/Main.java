package main;

import controller.Controller;

public class Main {

	//Mainmetode med nyt ControllerObjekt c.
	//Så længe while(true) er opfyldt kører spillet.
	public static void main(String[] args) {
		Controller c = new Controller();
		while(true) {
			c.spilKontrol();
		}
	}

}
