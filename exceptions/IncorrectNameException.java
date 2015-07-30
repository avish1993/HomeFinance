package exceptions;

import javax.swing.JOptionPane;

public class IncorrectNameException extends Exception {
	@Override
	public String toString() {

		JOptionPane.showMessageDialog(null, "The name entered is incorrect!");
		return null;
	}

}
