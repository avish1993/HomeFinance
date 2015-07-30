package exceptions;

import javax.swing.JOptionPane;

public class NameWithSpecialCharacterException extends Exception {
	@Override
	public String toString() {

		JOptionPane.showMessageDialog(null,
				"The name cannot contain special characters!");
		return null;
	}

}
