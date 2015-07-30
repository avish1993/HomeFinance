package gui_classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import business_logic.Loan;
import dao.BranchManagerDAO;
import dao.BranchManagerDAOImpl;

public class BranchManagerLoanViewPane extends JPanel {
	private JTextField txtShowFamIn;
	private JTextField txtShowTimePrd;
	private JTextField txtShowLoanAmt;
	private JTextField txtShowDwnPmnt;
	private JLabel lblRefNo;
	private JLabel lblLoanCode;
	private JLabel lblShowLoanType;
	private JLabel lblDate;
	private JLabel lblMonth;
	private JLabel lblYear;
	private JTextArea txtShowPropAddr;
	private JLabel lblShowWorkLoad;
	private JComboBox<String> comboBox;
	private Loan private_loan;

	public BranchManagerLoanViewPane(final Loan loan) {
		setLayout(null);
		final BranchManagerDAO bmanDB_handle = new BranchManagerDAOImpl();
		JLabel lblApplRef = new JLabel("Application Ref. No.:");
		lblApplRef.setHorizontalAlignment(SwingConstants.LEFT);
		lblApplRef.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblApplRef.setBounds(417, 38, 150, 16);
		add(lblApplRef);

		lblRefNo = new JLabel("<ref no>");
		lblRefNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRefNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblRefNo.setBounds(567, 38, 63, 16);
		add(lblRefNo);

		JLabel lblLoanProg = new JLabel("Loan Program .:");
		lblLoanProg.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanProg.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLoanProg.setBounds(417, 66, 150, 16);
		add(lblLoanProg);

		lblLoanCode = new JLabel("<lp##>");
		lblLoanCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoanCode.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLoanCode.setBounds(567, 66, 63, 16);
		add(lblLoanCode);

		JLabel lblHeading = new JLabel("Loan Application Form :");
		lblHeading.setHorizontalAlignment(SwingConstants.LEFT);
		lblHeading.setFont(new Font("Cambria", Font.BOLD, 19));
		lblHeading.setBounds(46, 38, 282, 24);
		add(lblHeading);

		JLabel lblLoanType = new JLabel("Loan Type");
		lblLoanType.setToolTipText("");
		lblLoanType.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanType.setBounds(46, 113, 142, 20);
		add(lblLoanType);

		JLabel lblPropAddr = new JLabel("Address of Property");
		lblPropAddr.setToolTipText("");
		lblPropAddr.setHorizontalAlignment(SwingConstants.LEFT);
		lblPropAddr.setBounds(46, 211, 153, 20);
		add(lblPropAddr);

		txtShowPropAddr = new JTextArea();
		txtShowPropAddr.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtShowPropAddr.setEnabled(false);
		txtShowPropAddr.setEditable(false);
		txtShowPropAddr.setBounds(228, 213, 218, 75);
		add(txtShowPropAddr);

		JLabel lblAnnFamIncome = new JLabel("Annual Family Income");
		lblAnnFamIncome.setToolTipText("");
		lblAnnFamIncome.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnnFamIncome.setBounds(46, 308, 169, 24);
		add(lblAnnFamIncome);

		txtShowFamIn = new JTextField();
		txtShowFamIn.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtShowFamIn.setEnabled(false);
		txtShowFamIn.setEditable(false);
		txtShowFamIn.setColumns(10);
		txtShowFamIn.setBounds(228, 304, 141, 28);
		add(txtShowFamIn);

		JLabel lblApplDate = new JLabel("Date of Application");
		lblApplDate.setToolTipText("");
		lblApplDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblApplDate.setBounds(46, 168, 153, 20);
		add(lblApplDate);

		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> model = (DefaultListModel<String>) (BranchManagerUIDesign.list
						.getModel());
				int selectedIndex = BranchManagerUIDesign.list
						.getSelectedIndex();
				try {
					String srpId = String.valueOf(comboBox.getSelectedItem());
					bmanDB_handle.assignLoan(srpId, private_loan.getRefNumber());
					model.remove(selectedIndex);
					lblShowWorkLoad.setText(String.valueOf(bmanDB_handle
							.getWorkLoad(srpId)));
					BranchManagerUIDesign.loanList.remove(selectedIndex);
					if (selectedIndex >= 0
							&& BranchManagerUIDesign.loanList.size() > 0) {
						BranchManagerUIDesign.list.setSelectedIndex(0);
						setVals(BranchManagerUIDesign.loanList.get(0));
						BranchManagerUIDesign.listScrollPane.validate();
						BranchManagerUIDesign.listScrollPane.repaint();
					} else {
						setNull();
					}
					validate();
					repaint();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error Occurred!");

				}
			}

		});
		btnAssign.setBounds(540, 408, 117, 28);
		add(btnAssign);

		txtShowTimePrd = new JTextField();
		txtShowTimePrd.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtShowTimePrd.setEnabled(false);
		txtShowTimePrd.setEditable(false);
		txtShowTimePrd.setToolTipText("Enter time period in years");
		txtShowTimePrd.setColumns(10);
		txtShowTimePrd.setBounds(531, 346, 141, 28);
		add(txtShowTimePrd);

		txtShowLoanAmt = new JTextField();
		txtShowLoanAmt.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtShowLoanAmt.setEnabled(false);
		txtShowLoanAmt.setEditable(false);
		txtShowLoanAmt.setToolTipText("Enter time period in years");
		txtShowLoanAmt.setColumns(10);
		txtShowLoanAmt.setBounds(228, 346, 141, 28);
		add(txtShowLoanAmt);

		txtShowDwnPmnt = new JTextField();
		txtShowDwnPmnt.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtShowDwnPmnt.setEnabled(false);
		txtShowDwnPmnt.setEditable(false);
		txtShowDwnPmnt.setToolTipText("Enter loan amount");
		txtShowDwnPmnt.setColumns(10);
		txtShowDwnPmnt.setBounds(531, 304, 141, 28);
		add(txtShowDwnPmnt);

		JLabel lblLoanAmt = new JLabel("Loan Amount");
		lblLoanAmt.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanAmt.setBounds(46, 344, 142, 22);
		add(lblLoanAmt);

		JLabel lblDwnPmnt = new JLabel("Down Payment");
		lblDwnPmnt.setHorizontalAlignment(SwingConstants.LEFT);
		lblDwnPmnt.setBounds(398, 310, 125, 21);
		add(lblDwnPmnt);

		JLabel lblTimePrd = new JLabel("Time Period");
		lblTimePrd.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimePrd.setBounds(396, 348, 117, 23);
		add(lblTimePrd);

		lblShowLoanType = new JLabel("<<Show loan type>>");
		lblShowLoanType.setHorizontalAlignment(SwingConstants.LEFT);
		lblShowLoanType.setBounds(228, 114, 265, 28);
		add(lblShowLoanType);

		lblDate = new JLabel("<Date>");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(228, 168, 55, 20);
		add(lblDate);

		lblMonth = new JLabel("<Month>");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBounds(308, 170, 71, 16);
		add(lblMonth);

		lblYear = new JLabel("<Year>");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(391, 170, 55, 16);
		add(lblYear);

		JLabel lblAssignTo = new JLabel("Assign To :");
		lblAssignTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssignTo.setBounds(62, 411, 91, 22);
		add(lblAssignTo);

		JLabel lblWorkload = new JLabel("Workload :");
		lblWorkload.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkload.setBounds(259, 411, 91, 22);
		add(lblWorkload);

		comboBox = new JComboBox<String>();
		final DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>();
		comboBox.setModel(comboModel);
		try {
			ArrayList<String> srpIdList = bmanDB_handle.getAllSrpId();
			for (String Id : srpIdList) {
				comboModel.addElement(Id);
			}
		} catch (SQLException e1) {

		}
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String srpId = String.valueOf(comboBox.getSelectedItem());
				try {
					int workLoad = bmanDB_handle.getWorkLoad(srpId);
					lblShowWorkLoad.setText(String.valueOf(workLoad));
				} catch (SQLException e1) {

				}
			}
		});
		comboBox.setBounds(165, 409, 63, 26);
		add(comboBox);

		lblShowWorkLoad = new JLabel();
		lblShowWorkLoad.setHorizontalAlignment(SwingConstants.LEFT);
		lblShowWorkLoad.setBounds(380, 411, 63, 22);
		add(lblShowWorkLoad);
		String srpId = String.valueOf(comboBox.getSelectedItem());
		try {
			int workLoad = bmanDB_handle.getWorkLoad(srpId);
			lblShowWorkLoad.setText(String.valueOf(workLoad));
		} catch (SQLException e1) {

		}
		setVals(loan);

	}

	protected void setNull() {
		lblRefNo.setText("");
		lblLoanCode.setText("");
		txtShowPropAddr.setText("");
		txtShowFamIn.setText("");
		txtShowTimePrd.setText("");
		txtShowLoanAmt.setText("");
		txtShowDwnPmnt.setText("");
		lblShowLoanType.setText("");
		lblDate.setText("");
		lblMonth.setText("");
		lblYear.setText("");
	}

	protected void setVals(Loan loan) {
		this.private_loan = loan;
		lblRefNo.setText(loan.getRefNumber());
		lblLoanCode.setText(loan.getLoanProgramCode());
		txtShowPropAddr.setText(loan.getAddressOfProperty());
		txtShowFamIn.setText(String.valueOf(loan.getAnnualIncome()));
		txtShowTimePrd.setText(String.valueOf(loan.getLoanPeriod()));
		txtShowLoanAmt.setText(String.valueOf(loan.getApprovedAmount()));
		txtShowDwnPmnt.setText(String.valueOf(loan.getDownPayment()));
		lblShowLoanType.setText(loan.getAppliedFor());
		java.sql.Date date = loan.getDateOfApplication();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String simple_date = df.format(date);
		lblDate.setText(simple_date.substring(3, 5));
		lblMonth.setText(simple_date.substring(0, 2));
		lblYear.setText(simple_date.substring(6, 10));
	}
}
