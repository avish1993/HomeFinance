package exceptions;

import javax.swing.JOptionPane;

public class NotSelectedException extends Exception {
	@Override
	public String toString() {

		JOptionPane.showMessageDialog(null,
				"Please select an option to continue !");
		return null;
	}
}
