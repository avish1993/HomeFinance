package gui_classes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import business_logic.BranchManager;
import business_logic.Customer;
import business_logic.SalesRepresentative;
import dao.BranchManagerDAO;
import dao.BranchManagerDAOImpl;
import dao.CustomerDao;
import dao.CustomerDaoImpl;
import dao.SalesRepresentativeDAO;
import dao.SalesRepresentativeDAOImpl;

public class LoginPage extends JFrame {

	private final JPanel loginPane;
	private final JTextField txtUserName;
	private final JPasswordField txtPassword;

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setTitle("Thomas Home Finance Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 633, 387);
		loginPane = new JPanel();
		loginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPane);
		loginPane.setLayout(null);

		final JComboBox<String> ddAccountTypes = new JComboBox<String>();
		ddAccountTypes.setToolTipText("Select account type");
		ddAccountTypes.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Select", "Branch Manager", "Customer",
						"Sales Representative" }));
		ddAccountTypes.setBounds(16, 111, 155, 27);
		loginPane.add(ddAccountTypes);

		final JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Courier 10 Pitch", Font.BOLD, 22));
		lblSignIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignIn.setBounds(224, 34, 137, 30);
		loginPane.add(lblSignIn);

		txtUserName = new JTextField();
		txtUserName.setToolTipText("Enter your first name");
		txtUserName.setBounds(198, 111, 122, 27);
		loginPane.add(txtUserName);
		txtUserName.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("Enter password");
		txtPassword.setBounds(335, 111, 122, 27);
		loginPane.add(txtPassword);

		final JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				switch (String.valueOf(ddAccountTypes.getSelectedItem())) {
				case "Select":
					JOptionPane.showMessageDialog(null,
							"Please select an account type!");
					break;
				case "Sales Representative":
					SalesRepresentative salesRep = new SalesRepresentative();
					salesRep.setName(txtUserName.getText());
					salesRep.setPassword(new String(txtPassword.getPassword()));
					SalesRepresentativeDAO srpDB_handle = new SalesRepresentativeDAOImpl();
					try {
						if (srpDB_handle.isExists(salesRep)) {
							JOptionPane.showMessageDialog(null,
									"Login Successful!");
							remove(loginPane);
							validate();
							repaint();
							setBounds(getLocationOnScreen().x,
									getLocationOnScreen().y, 1020, 540);
							SalesRepUIDesign salesUI = new SalesRepUIDesign(
									salesRep);
							salesUI.setOpaque(true);
							setContentPane(salesUI);
							setTitle("Thomas Home Finance Application Managements");
						} else {
							JOptionPane.showMessageDialog(null,
									"Invalid Credentials");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Error Occurred!");
						e1.printStackTrace();
					}

					break;
				case "Customer":
					CustomerDao custDB_handle = new CustomerDaoImpl();
					String name = txtUserName.getText();
					String pass = new String(txtPassword.getPassword());
					try {
						if (custDB_handle.isExists(name, pass)) {
							Customer cust = custDB_handle.getCustomer(name,
									pass);
							remove(loginPane);
							validate();
							repaint();
							setBounds(getLocationOnScreen().x,
									getLocationOnScreen().y, 720, 560);
							setTitle("Manage your account");
							CustomerUIDesign custUI = new CustomerUIDesign(cust);
							setContentPane(custUI);
						} else {
							JOptionPane.showMessageDialog(null,
									"Invalid Credentials!");
						}
					} catch (SQLException e) {

					}

					break;
				case "Branch Manager":
					name = txtUserName.getText();
					pass = new String(txtPassword.getPassword());
					BranchManagerDAO bmanDB_handle = new BranchManagerDAOImpl();
					try {
						if (bmanDB_handle.isExists(name, pass)) {
							remove(loginPane);
							validate();
							repaint();
							setBounds(getLocationOnScreen().x,
									getLocationOnScreen().y, 1020, 540);
							setTitle("Thomas Home Finance: Administration");
							BranchManager bMan = bmanDB_handle.getBManager(
									name, pass);
							BranchManagerUIDesign bManUI = new BranchManagerUIDesign(
									bMan);
							setContentPane(bManUI);
						} else {
							JOptionPane.showMessageDialog(null,
									"Invalid credentials!");
						}

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,
								"An error Occurred!");

						e.printStackTrace();
					}

					break;
				}

			}

		});
		btnLogin.setToolTipText("Sign In");
		btnLogin.setBounds(473, 111, 100, 27);
		loginPane.add(btnLogin);

		final JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Courier 10 Pitch", Font.BOLD, 22));
		lblSignUp.setBounds(228, 176, 128, 44);
		loginPane.add(lblSignUp);

		final JLabel lblNewUser = new JLabel("New User? ");
		lblNewUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewUser.setFont(new Font("Courier 10 Pitch", Font.PLAIN, 18));
		lblNewUser.setBounds(163, 242, 111, 63);
		loginPane.add(lblNewUser);

		final JButton btnRegister = new JButton("Register Here");
		btnRegister
				.setToolTipText("Click here to create an account at Thomas Home Finanace");
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				remove(loginPane);
				validate();
				repaint();
				setBounds(getLocationOnScreen().x, getLocationOnScreen().y,
						720, 520);
				setTitle("Thomas Home Finance Customer Registration");
				Register registerPane = new Register();
				registerPane.setOpaque(true);
				setContentPane(registerPane);

			}
		});
		btnRegister.setBounds(284, 258, 147, 27);
		loginPane.add(btnRegister);

	}
}
