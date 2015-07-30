package gui_classes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business_logic.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;

@SuppressWarnings("serial")
public class CustomerAccountMod extends JPanel {
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtPhone;
	private JTextField txtIncome;

	/**
	 * Create the panel.
	 * 
	 * @param cust
	 */
	public CustomerAccountMod(final Customer cust) {
		setLayout(null);

		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblName.setBounds(127, 116, 91, 27);
		add(lblName);

		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setToolTipText("Your full name");
		txtName.setColumns(10);
		txtName.setBounds(306, 117, 267, 27);
		txtName.setText(cust.getName());
		add(txtName);

		JLabel lblPromt = new JLabel("Account Details :");
		lblPromt.setFont(new Font("Century Schoolbook L", Font.BOLD, 18));
		lblPromt.setBounds(127, 29, 199, 47);
		add(lblPromt);

		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblAge.setBounds(127, 170, 91, 27);
		add(lblAge);

		txtAge = new JTextField();
		txtAge.setEnabled(false);
		txtAge.setToolTipText("Your current age");
		txtAge.setColumns(3);
		txtAge.setBounds(306, 171, 60, 27);
		txtAge.setText(String.valueOf(cust.getAge()));
		add(txtAge);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblAddress.setBounds(127, 221, 91, 27);
		add(lblAddress);

		final JTextArea txtAreaAddr = new JTextArea();
		txtAreaAddr.setEnabled(false);
		txtAreaAddr
				.setToolTipText("Enter your home address, street name, city and state");
		txtAreaAddr.setBounds(306, 228, 267, 71);
		txtAreaAddr.setText(cust.getAddress());
		add(txtAreaAddr);

		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblPhone.setBounds(127, 323, 150, 27);
		add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setEnabled(false);
		txtPhone.setToolTipText("Enter your personal phone number");
		txtPhone.setColumns(10);
		txtPhone.setBounds(301, 324, 150, 27);
		txtPhone.setText(cust.getPhoneNumber());
		add(txtPhone);

		JLabel lblIncome = new JLabel("Annual Income:");
		lblIncome.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblIncome.setBounds(127, 371, 150, 27);
		add(lblIncome);

		txtIncome = new JTextField();
		txtIncome.setEnabled(false);
		txtIncome.setToolTipText("Your annual income");
		txtIncome.setColumns(10);
		txtIncome.setBounds(301, 371, 150, 27);
		txtIncome.setText(String.valueOf(cust.getAnnualIncome()));
		add(txtIncome);

		final JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnEdit.getText().equals("Edit")) {
					btnEdit.setText("Done");
					txtAreaAddr.setEnabled(true);
					txtAge.setEnabled(true);
					txtIncome.setEnabled(true);
					txtName.setEnabled(true);
					txtPhone.setEnabled(true);
				} else if (btnEdit.getText().equals("Done")) {
					btnEdit.setText("Edit");
					txtAreaAddr.setEnabled(false);
					txtAge.setEnabled(false);
					txtIncome.setEnabled(false);
					txtName.setEnabled(false);
					txtPhone.setEnabled(false);
				}
			}
		});
		btnEdit.setToolTipText("Click here to edit account");
		btnEdit.setFont(new Font("Century Schoolbook L", Font.BOLD, 14));
		btnEdit.setBounds(260, 422, 104, 47);
		add(btnEdit);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CustomerDao custDB_handle = new CustomerDaoImpl();
				try {
					cust.setAge(Integer.parseInt(txtAge.getText()));
					cust.setAnnualIncome(Double.parseDouble(txtIncome.getText()));
					cust.setName(txtName.getText());
					cust.setAddress(txtAreaAddr.getText());
					cust.setPhoneNumber(txtPhone.getText());
					custDB_handle.updateAccount(cust);
					JOptionPane.showMessageDialog(null,
							"The data has been updated!");
					txtAreaAddr.setEnabled(false);
					txtAge.setEnabled(false);
					txtIncome.setEnabled(false);
					txtName.setEnabled(false);
					txtPhone.setEnabled(false);
				} catch (SQLException | NumberFormatException
						| NullPointerException e) {
					JOptionPane
							.showMessageDialog(null,
									"Error Occurred!\nPlease check if all fields are valid!");
					e.printStackTrace();
				}

				// show the updated values in the text box using some getter
				// method
			}
		});
		btnSubmit.setToolTipText("Click here to finalize account");
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSubmit.setBounds(417, 422, 104, 47);
		add(btnSubmit);
	}

}
