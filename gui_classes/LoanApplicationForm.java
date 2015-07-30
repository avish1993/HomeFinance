package gui_classes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import business_logic.Customer;
import business_logic.Loan;
import dao.LoanDao;
import dao.LoanDaoImpl;

public class LoanApplicationForm extends JPanel {

	private JTextField txtAnnualIncome;
	private JTextField txtOtherIncome;
	private JTextField txtAmount;
	private JTextField txtDwnPayment;
	private JTextField txtPeriod;

	public LoanApplicationForm(final Customer cust) {
		setLayout(null);
		JLabel lblAppliRN = new JLabel("Application Ref. No.:");
		lblAppliRN.setHorizontalAlignment(SwingConstants.LEFT);
		lblAppliRN.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblAppliRN.setBounds(383, 43, 132, 16);
		add(lblAppliRN);

		final JLabel lblRefNo = new JLabel("");
		lblRefNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRefNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblRefNo.setBounds(536, 43, 66, 16);
		add(lblRefNo);

		JLabel lblLoanProg = new JLabel("Loan Program .:");
		lblLoanProg.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanProg.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLoanProg.setBounds(383, 71, 100, 16);
		add(lblLoanProg);

		final JLabel lblLoanCode = new JLabel("");
		lblLoanCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanCode.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLoanCode.setBounds(536, 71, 66, 16);
		add(lblLoanCode);
		JLabel lblLoanApplicationForm = new JLabel("Loan Application Form :");
		lblLoanApplicationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoanApplicationForm.setFont(new Font("Cambria", Font.BOLD, 19));
		lblLoanApplicationForm.setBounds(55, 32, 284, 24);
		add(lblLoanApplicationForm);

		final JComboBox comboPuchaseProp = new JComboBox();
		comboPuchaseProp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (String.valueOf(comboPuchaseProp.getSelectedItem())) {
				case "Purchase Property":
					lblRefNo.setText(cust.getId().substring(0, 3) + "Lp01"
							+ String.valueOf(cust.getLoanList().size() + 1));
					lblLoanCode.setText("Lp01");
					break;
				case "Renovation of Property":
					lblRefNo.setText(cust.getId().substring(0, 3) + "Lp02"
							+ String.valueOf(cust.getLoanList().size() + 1));
					lblLoanCode.setText("Lp02");
					break;
				case "Extension of Present Property":
					lblRefNo.setText(cust.getId().substring(0, 3) + "Lp03"
							+ String.valueOf(cust.getLoanList().size() + 1));
					lblLoanCode.setText("Lp03");
					break;
				case "Construction of Property":
					lblRefNo.setText(cust.getId().substring(0, 3) + "Lp04"
							+ String.valueOf(cust.getLoanList().size() + 1));
					lblLoanCode.setText("Lp04");
					break;
				}
			}
		});
		comboPuchaseProp.setModel(new DefaultComboBoxModel(new String[] {
				"Purchase Property", "Renovation of Property",
				"Extension of Present Property", "Construction of Property" }));
		comboPuchaseProp.setToolTipText("Click to view Various Loan Types");
		comboPuchaseProp.setBounds(248, 121, 228, 26);
		add(comboPuchaseProp);

		JLabel lblLoanType = new JLabel("Type of Loan");
		lblLoanType.setToolTipText("");
		lblLoanType.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanType.setBounds(81, 124, 117, 20);
		add(lblLoanType);

		JLabel lblNameOfApplicant = new JLabel("Address of Property");
		lblNameOfApplicant.setToolTipText("");
		lblNameOfApplicant.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameOfApplicant.setBounds(81, 229, 149, 20);
		add(lblNameOfApplicant);

		final JTextArea txtAddress = new JTextArea();
		txtAddress
				.setToolTipText("Enter your home address, street name, city and state");
		txtAddress.setEditable(true);
		txtAddress.setBounds(248, 226, 218, 75);
		add(txtAddress);

		JLabel lblAnnualFamilyIncome = new JLabel("Annual Family Income");
		lblAnnualFamilyIncome.setToolTipText("");
		lblAnnualFamilyIncome.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnnualFamilyIncome.setBounds(81, 338, 165, 20);
		add(lblAnnualFamilyIncome);

		txtAnnualIncome = new JTextField();
		txtAnnualIncome.setBounds(248, 335, 122, 28);
		add(txtAnnualIncome);
		txtAnnualIncome.setColumns(10);

		JLabel lblDate = new JLabel("Date of Application");
		lblDate.setToolTipText("");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setBounds(81, 178, 149, 20);
		add(lblDate);

		final JComboBox comboDay = new JComboBox();
		comboDay.setModel(new DefaultComboBoxModel(new String[] { "Day", "01",
				"02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
				"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboDay.setBounds(248, 175, 69, 26);
		add(comboDay);

		final JComboBox comboMonth = new JComboBox();
		comboMonth.setModel(new DefaultComboBoxModel(new String[] { "Month",
				"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12" }));
		comboMonth.setBounds(329, 175, 74, 26);
		add(comboMonth);

		final JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] { "Year",
				"2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
		comboYear.setBounds(415, 175, 61, 26);
		add(comboYear);

		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Loan loan = null;
				switch (String.valueOf(comboPuchaseProp.getSelectedItem())) {
				case "Purchase Property":
					loan = new Loan("Lp01");
					break;
				case "Renovation of Property":
					loan = new Loan("Lp02");
					break;
				case "Extension of Present Property":
					loan = new Loan("Lp03");
					break;
				case "Construction of Property":
					loan = new Loan("Lp04");
					break;
				}
				try {
					lblRefNo.setText(cust.getId().substring(0, 3)
							+ loan.getLoanProgramCode()
							+ String.valueOf(cust.getLoanList().size() + 1));
					loan.setAddressOfProperty(txtAddress.getText());
					loan.setApprovedAmount(Double.parseDouble(txtAmount
							.getText()));
					loan.setDownPayment(Double.parseDouble(txtDwnPayment
							.getText()));
					String date = String.valueOf((comboYear.getSelectedItem()))
							+ String.valueOf((comboMonth.getSelectedItem()))
							+ String.valueOf((comboDay.getSelectedItem()));
					loan.setDateOfApplication(date);
					loan.setOtherIncome(Double.parseDouble(txtOtherIncome
							.getText()));
					loan.setLoanPeriod(Integer.parseInt(txtPeriod.getText()));
					loan.setAnnualIncome(Double.parseDouble(txtAnnualIncome
							.getText()));
					loan.setRefNumber(cust.getId().substring(0, 3)
							+ loan.getLoanProgramCode()
							+ String.valueOf(cust.getLoanList().size() + 1));
					LoanDao loanDB_handle = new LoanDaoImpl();
					loanDB_handle.addCustomerLoanApplication(cust, loan);
				} catch (SQLException | NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error Occurred!");
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,
						"Thank you for applying for the loan.");
				cust.addLoan(loan);
				CustomerUIDesign.tabbedPane.remove(2);
				CustomerUIDesign.tabbedPane.setSelectedIndex(1);

			}
		});
		btnApply.setBounds(388, 466, 80, 28);
		add(btnApply);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerUIDesign.tabbedPane.remove(2);
				CustomerUIDesign.tabbedPane.setSelectedIndex(0);
			}
		});
		btnBack.setBounds(250, 466, 77, 28);
		add(btnBack);

		JLabel lblOtherIncome = new JLabel("Other Income");
		lblOtherIncome.setBounds(81, 410, 117, 15);
		add(lblOtherIncome);

		txtOtherIncome = new JTextField();
		txtOtherIncome.setColumns(10);
		txtOtherIncome.setBounds(248, 404, 122, 28);
		add(txtOtherIncome);

		txtAmount = new JTextField();
		txtAmount.setBounds(536, 335, 122, 27);
		add(txtAmount);
		txtAmount.setColumns(10);

		txtDwnPayment = new JTextField();
		txtDwnPayment.setBounds(536, 404, 122, 27);
		add(txtDwnPayment);
		txtDwnPayment.setColumns(10);

		JLabel lblAmount = new JLabel("Total Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setBounds(395, 338, 105, 20);
		add(lblAmount);

		JLabel lblDwnpayment = new JLabel("Down Payment");
		lblDwnpayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblDwnpayment.setBounds(395, 410, 120, 22);
		add(lblDwnpayment);

		JLabel lblPeriod = new JLabel("Period :");
		lblPeriod.setBounds(510, 247, 60, 15);
		add(lblPeriod);

		txtPeriod = new JTextField();
		txtPeriod.setBounds(510, 273, 60, 28);
		add(txtPeriod);
		txtPeriod.setColumns(10);

	}
}
