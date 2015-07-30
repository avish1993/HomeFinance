package exceptions;

import javax.swing.JOptionPane;

public class EmptyFieldException extends Exception {
	private String field;

	public EmptyFieldException(String field) {
		this.field = field;
	}

	@Override
	public String toString() {

		JOptionPane
				.showMessageDialog(null, "The " + field + " field is empty!");
		return null;
	}
}
