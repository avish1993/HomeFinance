package gui_classes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import business_logic.Customer;

public class CustomerUIDesign extends JPanel {
	static JTabbedPane tabbedPane;

	public CustomerUIDesign(final Customer cust) {
		super(new GridLayout(1, 1));
		tabbedPane = new JTabbedPane();

		JComponent panelLoanOffers = new LoanViewPanel();
		tabbedPane.addTab("View Loan Offers", null, panelLoanOffers,
				"Calculate Loan EMIs");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

		JButton button = new JButton("Apply for Loan");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JComponent loanAppl = new LoanApplicationForm(cust);
				tabbedPane.addTab("Submit Details", null, loanAppl,
						"Submit Loan Details");
				tabbedPane.setMnemonicAt(2, KeyEvent.VK_4);
				tabbedPane.setSelectedIndex(2);

				loanAppl.setVisible(true);

			}
		});
		button.setBounds(493, 371, 136, 28);
		panelLoanOffers.add(button);

		JComponent panelAccountManagement = new CustomerAccountMod(cust);
		tabbedPane.addTab("Manage Account", null, panelAccountManagement,
				"Change your account details");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_1);
		add(tabbedPane);

		// The following line enables to use scrolling tabs.
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

	}
}