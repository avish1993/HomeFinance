package gui_classes;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class LafSelector {

	private JDialog frame;
	private boolean startNext;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JDialog();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Thomas Home Finance");
		frame.setResizable(false);
		JLabel lblNewLabel = new JLabel("Select Desired Interface");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ariel Black", Font.BOLD, 14));
		lblNewLabel.setBounds(122, 26, 191, 44);
		frame.getContentPane().add(lblNewLabel);

		final JRadioButton radioNimbus = new JRadioButton("Nimbus");
		radioNimbus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLaf(radioNimbus.getText().toLowerCase(), frame);

			}
		});
		radioNimbus.setBounds(61, 92, 149, 23);
		frame.getContentPane().add(radioNimbus);

		final JRadioButton radioWIndows = new JRadioButton("Windows");
		radioWIndows.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLaf(radioWIndows.getText().toLowerCase(), frame);
			}
		});
		radioWIndows.setBounds(61, 137, 149, 23);
		frame.getContentPane().add(radioWIndows);

		final JRadioButton radioLinux = new JRadioButton("Linux");
		radioLinux.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setLaf(radioLinux.getText().toLowerCase(), frame);
			}
		});
		radioLinux.setBounds(61, 187, 149, 23);
		frame.getContentPane().add(radioLinux);

		ButtonGroup bg = new ButtonGroup();
		bg.add(radioNimbus);
		bg.add(radioWIndows);
		bg.add(radioLinux);
		JButton btnStart = new JButton("Start Application");
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startNext = true;
				frame.dispose();
			}
		});

		btnStart.setBounds(218, 92, 169, 44);
		frame.getContentPane().add(btnStart);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(218, 166, 169, 44);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				startNext = false;
				frame.dispose();
			}
		});
		frame.setModal(true);
		frame.setVisible(true);
	}

	public boolean isStartNext() {
		return startNext;
	}

	private void setLaf(String laf, JDialog frame) {
		try {
			switch (laf) {
			case "nimbus":
				UIManager
						.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;
			case "windows":
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				break;
			case "linux":
				UIManager
						.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
				break;
			default:
				UIManager
						.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Look and feel not found in system!");
		}
		SwingUtilities.updateComponentTreeUI(frame);

	}
}
