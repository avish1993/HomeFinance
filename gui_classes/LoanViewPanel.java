package gui_classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import business_logic.Loan;

public class LoanViewPanel extends JPanel {
	private JTextField txtLoanAmount;
	private JTextField txtTimePeriod;
	private JTextField txtRate;
	private JTextField txtCalulatedEmi;
	private JTextField txtDownPayment;

	/**
	 * Create the panel.
	 */
	public LoanViewPanel() {
		setLayout(null);

		final JComboBox comboLoanTypes = new JComboBox();
		comboLoanTypes.setToolTipText("Click to view Various Loan Types");
		comboLoanTypes.setModel(new DefaultComboBoxModel(new String[] {
				"Purchase", "Renovation", "Construction", "Extension" }));
		comboLoanTypes.setBounds(269, 126, 258, 28);
		add(comboLoanTypes);

		JLabel lblTypeOfLoan = new JLabel("Loan Type");
		lblTypeOfLoan.setToolTipText("");
		lblTypeOfLoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeOfLoan.setBounds(100, 128, 112, 24);
		add(lblTypeOfLoan);

		JLabel lblNewLabel = new JLabel("Loan Amount");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(100, 179, 112, 22);
		add(lblNewLabel);

		txtLoanAmount = new JTextField();
		txtLoanAmount.setToolTipText("Enter loan amount");
		txtLoanAmount.setBounds(273, 177, 141, 28);
		add(txtLoanAmount);
		txtLoanAmount.setColumns(10);

		JLabel lblTimePeriod = new JLabel("Time Period");
		lblTimePeriod.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimePeriod.setBounds(100, 267, 112, 23);
		add(lblTimePeriod);

		JLabel lblProvideTheDetails = new JLabel(
				"Provide the details to get EMI amount");
		lblProvideTheDetails.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblProvideTheDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblProvideTheDetails.setBounds(100, 62, 321, 28);
		add(lblProvideTheDetails);

		txtTimePeriod = new JTextField();
		txtTimePeriod.setToolTipText("Enter time period in years");
		txtTimePeriod.setBounds(275, 265, 141, 28);
		add(txtTimePeriod);
		txtTimePeriod.setColumns(10);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblRate.setBounds(100, 320, 112, 22);
		add(lblRate);

		JButton btnCalculateEmi = new JButton("Calculate EMI");
		btnCalculateEmi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double amt = Double.parseDouble(txtLoanAmount.getText());
				double dwnpay = Double.parseDouble(txtDownPayment.getText());
				int time = Integer.parseInt(txtTimePeriod.getText());
				Loan loan = new Loan("Lp01");
				switch (String.valueOf(comboLoanTypes.getSelectedItem())) {
				case "Purchase":
					loan = new Loan("Lp01");
					break;
				case "Renovation":
					loan = new Loan("Lp02");
					break;
				case "Construction":
					loan = new Loan("Lp03");
					break;
				case "Extension":
					loan = new Loan("Lp04");
					break;
				}
				loan.setApprovedAmount(amt);
				loan.setDownPayment(dwnpay);
				loan.setLoanPeriod(time);
				txtRate.setText(String.valueOf(loan.getRateOfInterest()));
				txtCalulatedEmi.setText(String.valueOf(loan.getEmiAmount()));
			}

		});
		btnCalculateEmi.setBounds(100, 371, 128, 28);
		add(btnCalculateEmi);

		txtRate = new JTextField();
		txtRate.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		txtRate.setToolTipText("The Rate for this Loan type");
		txtRate.setEnabled(false);
		txtRate.setEditable(false);
		txtRate.setBounds(273, 320, 141, 24);
		add(txtRate);
		txtRate.setColumns(10);

		txtCalulatedEmi = new JTextField();
		txtCalulatedEmi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtCalulatedEmi.setToolTipText("The EMI amount");
		txtCalulatedEmi.setEnabled(false);
		txtCalulatedEmi.setEditable(false);
		txtCalulatedEmi.setColumns(10);
		txtCalulatedEmi.setBounds(273, 372, 183, 28);
		add(txtCalulatedEmi);

		JLabel lblDownPayment = new JLabel("Down Payment");
		lblDownPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblDownPayment.setBounds(100, 225, 112, 21);
		add(lblDownPayment);

		txtDownPayment = new JTextField();
		txtDownPayment.setToolTipText("Enter time period in years");
		txtDownPayment.setColumns(10);
		txtDownPayment.setBounds(274, 222, 141, 28);
		add(txtDownPayment);

	}
}
