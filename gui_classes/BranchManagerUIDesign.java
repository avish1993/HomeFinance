package gui_classes;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business_logic.BranchManager;
import business_logic.Loan;

public class BranchManagerUIDesign extends JPanel {

	private BranchManagerLoanViewPane custData;
	static JList<String> list;
	static JSplitPane splitPane;
	static DefaultListModel<String> unassignedList = new DefaultListModel<String>();
	static JScrollPane listScrollPane, applScrollPane;
	static ArrayList<Loan> loanList = null;

	// static JFrame frame;

	public BranchManagerUIDesign(BranchManager bMan) {

		loanList = bMan.getUnassignedLoanList();
		if (loanList.size() > 0) {
			for (Loan loan : loanList) {
				unassignedList.addElement(loan.getRefNumber());
			}
			list = new JList<String>(unassignedList);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setSelectedIndex(0);

			listScrollPane = new JScrollPane(list);
			custData = new BranchManagerLoanViewPane(loanList.get(0));
			applScrollPane = new JScrollPane(custData);

			// Create a split pane with the two scroll panes in it.
			splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
					listScrollPane, applScrollPane);
			splitPane.setOneTouchExpandable(true);
			splitPane.setDividerLocation(250);

			// Provide minimum sizes for the two components in the split pane.
			Dimension minimumSize = new Dimension(500, 600);
			listScrollPane.setMinimumSize(minimumSize);
			applScrollPane.setMinimumSize(minimumSize);
			// add(splitPane);
			JTabbedPane tabbedPane = new JTabbedPane();
			tabbedPane.addTab("Loan Assignment", null, splitPane,
					"Assign Loans to Sales Representatives");
			tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
			BranchDetailsViewPanel branchDetails = new BranchDetailsViewPanel(
					bMan);
			tabbedPane.addTab("Branch Manager Details", null, branchDetails,
					"Show Branch Manager details");
			tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
			add(tabbedPane);
			// Provide a preferred size for the split pane.
			splitPane.setPreferredSize(new Dimension(1000, 600));

			list.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						JList<String> theList = (JList<String>) e.getSource();
						if (theList.getSelectedIndex() == -1
								&& loanList.size() > 0) {
							theList.setSelectedIndex(0);
						}
						if (loanList.size() > 0
								&& theList.getSelectedIndex() >= 0) {
							final ArrayList<Loan> newloanList = loanList;
							custData.setVals(newloanList.get(theList
									.getSelectedIndex()));
						}
					}
				}
			});
		} else {
			JOptionPane.showMessageDialog(null, "No work to do!");
		}
	}

}