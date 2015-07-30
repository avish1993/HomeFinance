package gui_classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import business_logic.Loan;
import dao.SalesRepresentativeDAO;
import dao.SalesRepresentativeDAOImpl;

public class SalesRepLoanSplitPane extends JPanel {

	private JTextField txtAnnFamInc;
	private JTextField txtTimePeriod;
	private JTextField txtShowLoanAmt;
	private JTextField txtDwnPmnt;
	private JLabel lblRefNo;
	private JLabel lblLoanCode;
	private JTextArea txtArShowPropAddrss;
	private JButton btnGrant;
	private JLabel lblDate;
	private JLabel lblYear;
	private JLabel lblMonth;
	private JButton btnEdit;
	private JLabel lblShowLoanType;
	private Loan private_loan;

	public SalesRepLoanSplitPane(final Loan loan) {

		setLayout(null);
		JLabel lblApplRef = new JLabel("Application Ref. No.:");
		lblApplRef.setHorizontalAlignment(SwingConstants.LEFT);
		lblApplRef.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblApplRef.setBounds(526, 121, 141, 16);
		add(lblApplRef);

		lblRefNo = new JLabel("");
		lblRefNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblRefNo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblRefNo.setBounds(676, 121, 78, 16);
		add(lblRefNo);

		JLabel lblLoanProg = new JLabel("Loan Program.:");
		lblLoanProg.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanProg.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLoanProg.setBounds(526, 149, 141, 16);
		add(lblLoanProg);

		lblLoanCode = new JLabel("");
		lblLoanCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanCode.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblLoanCode.setBounds(676, 149, 78, 16);
		add(lblLoanCode);

		JLabel lblHeading = new JLabel("Loan Application Form :");
		lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeading.setFont(new Font("Cambria", Font.BOLD, 19));
		lblHeading.setBounds(73, 47, 290, 24);
		add(lblHeading);

		JLabel lblLoanType = new JLabel("Type of Loan");
		lblLoanType.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanType.setBounds(73, 120, 154, 20);
		add(lblLoanType);

		JLabel lblAddressProp = new JLabel("Address of Property");
		lblAddressProp.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddressProp.setBounds(73, 218, 154, 20);
		add(lblAddressProp);

		txtArShowPropAddrss = new JTextArea("");
		txtArShowPropAddrss.setEnabled(false);
		txtArShowPropAddrss.setEditable(false);
		txtArShowPropAddrss.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtArShowPropAddrss.setBounds(272, 220, 228, 75);
		add(txtArShowPropAddrss);

		JLabel lblAnnFamInc = new JLabel("Annual Family Income");
		lblAnnFamInc.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnnFamInc.setBounds(73, 312, 154, 24);
		add(lblAnnFamInc);

		txtAnnFamInc = new JTextField("");
		txtAnnFamInc.setEnabled(false);
		txtAnnFamInc.setEditable(false);
		txtAnnFamInc.setColumns(10);
		txtAnnFamInc.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAnnFamInc.setBounds(272, 311, 141, 28);
		add(txtAnnFamInc);

		JLabel lblApplDate = new JLabel("Date of Application");
		lblApplDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblApplDate.setBounds(73, 175, 154, 20);
		add(lblApplDate);

		btnGrant = new JButton("Grant");
		btnGrant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (SalesRepUIDesign.loanList.size() > 0) {
						private_loan.setAddressOfProperty(txtArShowPropAddrss
								.getText());
						private_loan.setAnnualIncome(Double
								.parseDouble(txtAnnFamInc.getText()));
						private_loan.setDownPayment(Double
								.parseDouble(txtDwnPmnt.getText()));
						private_loan.setApprovedAmount(Double
								.parseDouble(txtShowLoanAmt.getText()));
						private_loan.setLoanPeriod(Integer
								.parseInt(txtTimePeriod.getText()));
						private_loan.setLoan_status(true);
						SalesRepresentativeDAO loanDB_handle = new SalesRepresentativeDAOImpl();
						loanDB_handle.loanApprove(private_loan);
						final int selectedIndex = SalesRepUIDesign.list
								.getSelectedIndex();
						SalesRepUIDesign.loanList.remove(private_loan);
						if (selectedIndex >= 0
								&& SalesRepUIDesign.loanList.size() > 0) {
							((DefaultListModel<String>) (SalesRepUIDesign.list
									.getModel()))
									.removeElementAt(selectedIndex);
							SalesRepUIDesign.list.setSelectedIndex(0);
							setVals(SalesRepUIDesign.loanList.get(0));
							SalesRepUIDesign.listScrollPane.validate();
							SalesRepUIDesign.listScrollPane.repaint();
							validate();
							repaint();
						} else {
							((DefaultListModel<String>) (SalesRepUIDesign.list
									.getModel()))
									.removeElementAt(selectedIndex);
							SalesRepUIDesign.listScrollPane.validate();
							SalesRepUIDesign.listScrollPane.repaint();
							setNull();
						}
					}

				} catch (SQLException e) {

					JOptionPane.showMessageDialog(null, "Error Occurred!");
					e.printStackTrace();
				}

			}
		});
		btnGrant.setBounds(573, 415, 110, 28);
		add(btnGrant);

		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				DefaultListModel<String> model = (DefaultListModel<String>) (SalesRepUIDesign.list
						.getModel());
				int selectedIndex = SalesRepUIDesign.list.getSelectedIndex();
				if (selectedIndex != -1) {
					SalesRepresentativeDAO loanDB_handle = new SalesRepresentativeDAOImpl();
					try {
						loanDB_handle.loanReject(private_loan.getRefNumber());
						model.removeElementAt(selectedIndex);
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Error occurred!");

					}
				}
				SalesRepUIDesign.listScrollPane.validate();
				SalesRepUIDesign.listScrollPane.repaint();
				validate();
				repaint();
			}

		});
		btnReject.setBounds(418, 415, 113, 28);
		add(btnReject);

		txtTimePeriod = new JTextField("");
		txtTimePeriod.setEnabled(false);
		txtTimePeriod.setEditable(false);
		txtTimePeriod.setColumns(10);
		txtTimePeriod.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtTimePeriod.setBounds(563, 353, 141, 28);
		add(txtTimePeriod);

		txtShowLoanAmt = new JTextField("");
		txtShowLoanAmt.setEnabled(false);
		txtShowLoanAmt.setEditable(false);
		txtShowLoanAmt.setColumns(10);
		txtShowLoanAmt.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtShowLoanAmt.setBounds(272, 353, 141, 28);
		add(txtShowLoanAmt);

		txtDwnPmnt = new JTextField("");
		txtDwnPmnt.setEnabled(false);
		txtDwnPmnt.setEditable(false);
		txtDwnPmnt.setColumns(10);
		txtDwnPmnt.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDwnPmnt.setBounds(563, 311, 141, 28);
		add(txtDwnPmnt);

		JLabel lblLoanAmt = new JLabel("Loan Amount");
		lblLoanAmt.setHorizontalAlignment(SwingConstants.LEFT);
		lblLoanAmt.setBounds(73, 348, 154, 22);
		add(lblLoanAmt);

		JLabel lblDwnPmnt = new JLabel("Down Payment");
		lblDwnPmnt.setHorizontalAlignment(SwingConstants.LEFT);
		lblDwnPmnt.setBounds(431, 310, 114, 28);
		add(lblDwnPmnt);

		JLabel lblTimePeriod = new JLabel("Time Period");
		lblTimePeriod.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimePeriod.setBounds(435, 354, 110, 25);
		add(lblTimePeriod);

		lblShowLoanType = new JLabel("");
		lblShowLoanType.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowLoanType.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblShowLoanType.setBounds(272, 121, 228, 18);
		add(lblShowLoanType);

		lblDate = new JLabel("");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblDate.setBounds(272, 175, 66, 20);
		add(lblDate);

		lblMonth = new JLabel("");
		lblMonth.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonth.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMonth.setBounds(350, 175, 73, 20);
		add(lblMonth);

		lblYear = new JLabel("");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblYear.setBounds(435, 175, 55, 20);
		add(lblYear);

		btnEdit = new JButton("Edit");
		btnEdit.setBounds(270, 415, 117, 28);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnEdit.getText().equals("Edit")) {
					btnEdit.setText("Done");
					setComponentsEditable(true);
				} else {
					btnEdit.setText("Edit");
					setComponentsEditable(false);
				}
			}
		});
		add(btnEdit);
		setVals(loan);
	}

	private void setComponentsEditable(Boolean val) {
		txtArShowPropAddrss.setEditable(val);
		txtAnnFamInc.setEditable(val);
		txtDwnPmnt.setEditable(val);
		txtShowLoanAmt.setEditable(val);
		txtTimePeriod.setEditable(val);
		txtArShowPropAddrss.setEnabled(val);
		txtAnnFamInc.setEnabled(val);
		txtDwnPmnt.setEnabled(val);
		txtShowLoanAmt.setEnabled(val);
		txtTimePeriod.setEnabled(val);
	}

	protected void setNull() {
		lblRefNo.setText("");
		lblLoanCode.setText("");
		txtArShowPropAddrss.setText("");
		txtAnnFamInc.setText("");
		txtTimePeriod.setText("");
		txtShowLoanAmt.setText("");
		txtDwnPmnt.setText("");
		lblShowLoanType.setText("");
		lblDate.setText("");
		lblMonth.setText("");
		lblYear.setText("");
	}

	protected void setVals(Loan loan) {
		this.private_loan = loan;
		lblRefNo.setText(loan.getRefNumber());
		lblLoanCode.setText(loan.getLoanProgramCode());
		txtArShowPropAddrss.setText(loan.getAddressOfProperty());
		txtAnnFamInc.setText(String.valueOf(loan.getAnnualIncome()));
		txtTimePeriod.setText(String.valueOf(loan.getLoanPeriod()));
		txtShowLoanAmt.setText(String.valueOf(loan.getApprovedAmount()));
		txtDwnPmnt.setText(String.valueOf(loan.getDownPayment()));
		lblShowLoanType.setText(loan.getAppliedFor());
		java.sql.Date date = loan.getDateOfApplication();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String simple_date = df.format(date);
		lblDate.setText(simple_date.substring(3, 5));
		lblMonth.setText(simple_date.substring(0, 2));
		lblYear.setText(simple_date.substring(6, 10));
	}
}
