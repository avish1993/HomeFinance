package gui_classes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business_logic.Customer;
import dao.CustomerDao;
import dao.CustomerDaoImpl;
import driver_classes.Main;

public class Register extends JPanel {
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtPhone;
	private JTextField txtIncome;
	private JPasswordField txtPass;
	private Customer cust;
	private JTextArea txtAreaAddr;

	/**
	 * Create the panel.
	 */
	public Customer setVals() {
		Customer temp = new Customer();
		cust.setName(txtName.getText());
		cust.setAddress(txtAreaAddr.getText());
		cust.setAge(Integer.parseInt(txtAge.getText()));
		cust.setPassword(new String(txtPass.getPassword()));
		cust.setPhoneNumber(txtPhone.getText());
		cust.setAnnualIncome(Integer.parseInt(txtIncome.getText()));
		return temp;
	}

	public Register() {
		setLayout(null);
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblName.setBounds(99, 84, 91, 27);
		add(lblName);

		txtName = new JTextField();
		txtName.setToolTipText("Your full name");
		txtName.setColumns(10);
		txtName.setBounds(267, 86, 267, 27);
		add(txtName);

		JLabel lblPromt = new JLabel("Enter Your Details:");
		lblPromt.setFont(new Font("Century Schoolbook L", Font.BOLD, 18));
		lblPromt.setBounds(99, 12, 199, 47);
		add(lblPromt);

		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblAge.setBounds(99, 138, 91, 27);
		add(lblAge);

		txtAge = new JTextField();
		txtAge.setToolTipText("Your current age");
		txtAge.setColumns(3);
		txtAge.setBounds(267, 138, 60, 24);
		add(txtAge);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblAddress.setBounds(99, 236, 91, 27);
		add(lblAddress);

		txtAreaAddr = new JTextArea();
		txtAreaAddr
				.setToolTipText("Enter your home address, street name, city and state");
		txtAreaAddr.setBounds(267, 237, 267, 71);
		txtAreaAddr.setBorder(new JTextField().getBorder());
		add(txtAreaAddr);

		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblPhone.setBounds(99, 333, 150, 27);
		add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setToolTipText("Enter your personal phone number");
		txtPhone.setColumns(10);
		txtPhone.setBounds(308, 333, 109, 27);
		add(txtPhone);

		JLabel lblIncome = new JLabel("Annual Income:");
		lblIncome.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		lblIncome.setBounds(99, 380, 150, 27);
		add(lblIncome);

		txtIncome = new JTextField();
		txtIncome.setToolTipText("Your annual income");
		txtIncome.setColumns(10);
		txtIncome.setBounds(267, 380, 150, 27);
		add(txtIncome);

		txtPass = new JPasswordField();
		txtPass.setEchoChar('*');
		txtPass.setToolTipText("Enter your desired password (6 characters min)");
		txtPass.setColumns(10);
		txtPass.setBounds(267, 191, 267, 24);
		add(txtPass);

		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (txtPhone.getText().matches("[0-9]+")) {
					if (new String(txtPass.getPassword()).length() >= 6) {
						cust = setVals();
						CustomerDao custDB_handle = new CustomerDaoImpl();
						try {
							custDB_handle.addCustomer(cust);
							JOptionPane.showMessageDialog(null,
									"Registered Successfully!");
							CustomerUIDesign cuid = new CustomerUIDesign(cust);
							Main.loginPage.setContentPane(cuid);
							repaint();
							validate();
							repaint();
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null,
									"An error occurred!");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Password must be atleast 6 characters!");
						txtPass.setText("");
					}
					// make the frame static and the call
					// ClassName.frame.setContentPane(cuid);
				} else {
					JOptionPane.showMessageDialog(null,
							"Enter a valid phone number!");
					txtPhone.setText("");
				}

			}
		});
		button.setToolTipText("Click here to create acount");
		button.setFont(new Font("Century Schoolbook L", Font.BOLD, 14));
		button.setBounds(301, 434, 104, 47);
		add(button);

		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPass.setBounds(99, 191, 129, 27);
		add(lblPass);

		final JTextField txt91 = new JTextField("+91");
		txt91.setBounds(267, 333, 38, 27);
		txt91.setBorder(new JTextField().getBorder());
		txt91.setEditable(false);
		add(txt91);

	}
}
