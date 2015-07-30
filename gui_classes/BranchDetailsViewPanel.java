package gui_classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import business_logic.BranchManager;
import dao.BranchManagerDAO;
import dao.BranchManagerDAOImpl;

public class BranchDetailsViewPanel extends JPanel {
	private JTextField txtBrName;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtConPer;
	private JTextField txtConPhNo;
	private JButton btnEdit;
	private JTextField txtZip;

	public BranchDetailsViewPanel(final BranchManager bMan) {
		setLayout(null);

		JLabel lblBranchName = new JLabel("Branch Name");
		lblBranchName.setHorizontalAlignment(SwingConstants.LEFT);
		lblBranchName.setBounds(74, 118, 171, 16);
		add(lblBranchName);

		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setBounds(74, 178, 90, 16);
		add(lblCity);

		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(SwingConstants.LEFT);
		lblState.setBounds(74, 267, 90, 16);
		add(lblState);

		JLabel lblContactPerson = new JLabel("Contact Person");
		lblContactPerson.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactPerson.setBounds(74, 315, 125, 16);
		add(lblContactPerson);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setBounds(75, 375, 125, 16);
		add(lblPhoneNumber);

		JLabel lblBranchDetails = new JLabel("Branch Details: ");
		lblBranchDetails.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblBranchDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblBranchDetails.setBounds(75, 31, 170, 31);
		add(lblBranchDetails);

		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnEdit.getText().equals("Edit")) {
					btnEdit.setText("Done");
					setEditable(true);
				} else {
					btnEdit.setText("Edit");
					setEditable(false);
				}
			}
		});
		btnEdit.setBounds(133, 438, 90, 28);
		add(btnEdit);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bMan.setBranchName(txtBrName.getText());
				bMan.setCity(txtCity.getText());
				bMan.setManagerName(txtConPer.getText());
				bMan.setPhone(txtConPhNo.getText());
				bMan.setZip(Long.parseLong(txtZip.getText()));
				BranchManagerDAO branchDB_handle = new BranchManagerDAOImpl();
				try {
					branchDB_handle.updateDetails(bMan);
					JOptionPane.showMessageDialog(null,
							"The Database has been Updated");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Error Occurred!");
					e1.printStackTrace();

				}

				setEditable(false);
			}
		});
		btnSubmit.setBounds(286, 438, 90, 28);
		add(btnSubmit);

		txtBrName = new JTextField(bMan.getBranchName());
		txtBrName.setEditable(false);
		txtBrName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtBrName.setBounds(261, 113, 162, 28);
		add(txtBrName);
		txtBrName.setColumns(10);

		txtCity = new JTextField(bMan.getCity());
		txtCity.setEditable(false);
		txtCity.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtCity.setBounds(261, 172, 162, 28);
		add(txtCity);
		txtCity.setColumns(10);

		txtState = new JTextField(bMan.getState());
		txtState.setEditable(false);
		txtState.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtState.setBounds(261, 262, 162, 28);
		add(txtState);
		txtState.setColumns(10);

		txtConPer = new JTextField(bMan.getManagerName());
		txtConPer.setEditable(false);
		txtConPer.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtConPer.setBounds(261, 310, 162, 28);
		add(txtConPer);
		txtConPer.setColumns(10);

		txtConPhNo = new JTextField(bMan.getPhone());
		txtConPhNo.setEditable(false);
		txtConPhNo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtConPhNo.setBounds(261, 370, 162, 28);
		add(txtConPhNo);
		txtConPhNo.setColumns(10);

		JLabel lblBranchCodePrompt = new JLabel("Branch Code:");
		lblBranchCodePrompt.setBounds(337, 32, 90, 31);
		add(lblBranchCodePrompt);

		JLabel lblBranchCode = new JLabel(bMan.getBranchCode());
		lblBranchCode.setBounds(439, 31, 60, 31);
		add(lblBranchCode);

		JLabel lblZip = new JLabel("Zip");
		lblZip.setBounds(75, 218, 41, 15);
		add(lblZip);

		txtZip = new JTextField(String.valueOf(bMan.getZip()));
		txtZip.setEditable(false);
		txtZip.setColumns(10);
		txtZip.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtZip.setBounds(261, 212, 162, 28);
		add(txtZip);

	}

	private void setEditable(boolean val) {

		txtBrName.setEditable(val);
		txtCity.setEditable(val);
		txtConPer.setEditable(val);
		txtConPhNo.setEditable(val);
		txtState.setEditable(val);
	}
}
