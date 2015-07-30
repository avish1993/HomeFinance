package gui_classes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CustomerLoanStatus extends JPanel {

	/**
	 * Create the panel.
	 */
	public CustomerLoanStatus() {
		setLayout(null);

		JLabel lblApplicationRefNo = new JLabel("Application Ref. No.:");
		lblApplicationRefNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblApplicationRefNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplicationRefNo.setBounds(10, 21, 150, 21);
		add(lblApplicationRefNo);

		JLabel label = new JLabel("<ref no>");
		label.setFont(new Font("SansSerif", Font.PLAIN, 12));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(187, 24, 66, 14);
		add(label);

		JLabel lblLoanProgram = new JLabel("Loan Program :");
		lblLoanProgram.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLoanProgram.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoanProgram.setBounds(304, 24, 106, 14);
		add(lblLoanProgram);

		JLabel loan_code = new JLabel("<lp##>");
		loan_code.setFont(new Font("SansSerif", Font.PLAIN, 12));
		loan_code.setHorizontalAlignment(SwingConstants.CENTER);
		loan_code.setBounds(422, 24, 79, 14);
		add(loan_code);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(70, 131, 162, 14);
		add(lblName);

		JLabel lblLoanType = new JLabel("Loan Type");
		lblLoanType.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLoanType.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanType.setBounds(70, 185, 162, 14);
		add(lblLoanType);

		JLabel lblLoanAmount = new JLabel("Amount applied for");
		lblLoanAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanAmount.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblLoanAmount.setBounds(70, 237, 162, 14);
		add(lblLoanAmount);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblStatus.setBounds(70, 292, 162, 14);
		add(lblStatus);

		JLabel lblshowName = new JLabel("<show name>");
		lblshowName.setHorizontalAlignment(SwingConstants.CENTER);
		lblshowName.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblshowName.setBounds(244, 128, 231, 21);
		add(lblshowName);

		JLabel lblShowLoan = new JLabel("<show loan type>");
		lblShowLoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowLoan.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblShowLoan.setBounds(244, 182, 231, 21);
		add(lblShowLoan);

		JLabel lblShowAmount = new JLabel("<show loan amount>");
		lblShowAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowAmount.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		lblShowAmount.setBounds(244, 234, 231, 21);
		add(lblShowAmount);

		JLabel label_1 = new JLabel("<show Status>");
		label_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(244, 289, 231, 21);
		add(label_1);

	}
}
