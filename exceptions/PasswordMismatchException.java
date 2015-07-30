package exceptions;

import javax.swing.JOptionPane;

public class PasswordMismatchException extends Exception {
	@Override
	public String toString() {

		JOptionPane.showMessageDialog(null,
				"The password entered is incorrect!");
		return null;
	}
}
