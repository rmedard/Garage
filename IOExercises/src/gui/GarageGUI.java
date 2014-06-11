package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class GarageGUI {

	private JFrame frame;
	private JTextField txtCarType;
	private JTextField textCarModel;
	private JTextField textYOF;
	private JTextField textKm;
	private JTextField textCost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GarageGUI window = new GarageGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GarageGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 679, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnLanguage = new JMenu("Language");
		menuBar.add(mnLanguage);
		
		JMenuItem mntmFrench = new JMenuItem("French");
		mnLanguage.add(mntmFrench);
		
		JMenuItem mntmEnglish = new JMenuItem("English");
		mnLanguage.add(mntmEnglish);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 22, 584, 306);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAddCar = new JButton("Add Car");
		btnAddCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddCar.setBounds(10, 16, 138, 23);
		panel.add(btnAddCar);
		
		JList list = new JList();
		list.setBounds(158, 18, 174, 277);
		panel.add(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnRemoveCar = new JButton("Remove Car");
		btnRemoveCar.setBounds(10, 63, 138, 23);
		panel.add(btnRemoveCar);
		
		JButton btnSaveCar = new JButton("Save Car");
		btnSaveCar.setBounds(440, 192, 130, 23);
		panel.add(btnSaveCar);
		
		txtCarType = new JTextField();
		txtCarType.setBounds(440, 37, 130, 20);
		panel.add(txtCarType);
		txtCarType.setColumns(10);
		
		textCarModel = new JTextField();
		textCarModel.setColumns(10);
		textCarModel.setBounds(440, 68, 130, 20);
		panel.add(textCarModel);
		
		textYOF = new JTextField();
		textYOF.setColumns(10);
		textYOF.setBounds(440, 99, 130, 20);
		panel.add(textYOF);
		
		textKm = new JTextField();
		textKm.setColumns(10);
		textKm.setBounds(440, 130, 130, 20);
		panel.add(textKm);
		
		textCost = new JTextField();
		textCost.setColumns(10);
		textCost.setBounds(440, 161, 130, 20);
		panel.add(textCost);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(368, 41, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblModel = new JLabel("Model");
		lblModel.setBounds(368, 72, 46, 14);
		panel.add(lblModel);
		
		JLabel lblYearOfFab = new JLabel("Year Of Fab.");
		lblYearOfFab.setBounds(368, 102, 62, 14);
		panel.add(lblYearOfFab);
		
		JLabel lblKilometer = new JLabel("Kilometer");
		lblKilometer.setBounds(368, 133, 46, 14);
		panel.add(lblKilometer);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(368, 164, 46, 14);
		panel.add(lblCost);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.BLACK);
		separator.setBounds(342, 11, 2, 284);
		panel.add(separator);
		
	}
}
