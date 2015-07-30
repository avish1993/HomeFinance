package exceptions;

import javax.swing.JOptionPane;

public class PasswordLengthException extends Exception {
	@Override
	public String toString() {

		JOptionPane.showMessageDialog(null,
				"The password must be atleast of 6 characters!");
		return null;
	}

}
