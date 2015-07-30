package driver_classes;

import gui_classes.LafSelector;
import gui_classes.LoginPage;

public class Main {
	public static void main(String[] args) {
		LafSelector lafOptionScreen = new LafSelector();
		lafOptionScreen.initialize();
		if (lafOptionScreen.isStartNext()) {
			// LoginPage loginPage = new LoginPage();
			loginPage = new LoginPage();
			loginPage.setVisible(true);
		}
	}

	public static LoginPage loginPage;
}
