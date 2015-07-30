package gui_classes;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business_logic.Loan;
import business_logic.SalesRepresentative;
import dao.SalesRepresentativeDAO;
import dao.SalesRepresentativeDAOImpl;

public class SalesRepUIDesign extends JPanel {
	private SalesRepLoanSplitPane loanData;
	static JList<String> list;
	private JSplitPane splitPane;
	private DefaultListModel<String> m = new DefaultListModel<String>();
	static JScrollPane listScrollPane;
	static JScrollPane applScrollPane;
	static ArrayList<Loan> loanList = null;

	public SalesRepUIDesign(SalesRepresentative salesRep) {

		SalesRepresentativeDAO srpDB_handle = new SalesRepresentativeDAOImpl();
		try {
			loanList = srpDB_handle.getLoanList(salesRep.getSalesRepID());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error Occurred!");

			e1.printStackTrace();
		}
		if (loanList.size() > 0) {
			for (Loan loan : loanList) {
				m.addElement(loan.getRefNumber());
			}

			list = new JList<String>(m);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setSelectedIndex(0);
			listScrollPane = new JScrollPane(list);
			loanData = new SalesRepLoanSplitPane(loanList.get(0));
			loanData.setVals(loanList.get(0));
			applScrollPane = new JScrollPane(loanData);
			// Create a split pane with the two scroll panes in it.
			splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
					listScrollPane, applScrollPane);
			splitPane.setOneTouchExpandable(true);
			splitPane.setDividerLocation(150);
			// Provide minimum sizes for the two components in the split pane.
			Dimension minimumSize = new Dimension(500, 600);
			listScrollPane.setMinimumSize(minimumSize);
			applScrollPane.setMinimumSize(minimumSize);
			add(splitPane);
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
						if (loanList.size() > 0) {
							final ArrayList<Loan> newloanList = loanList;
							loanData.setVals(newloanList.get(theList
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
