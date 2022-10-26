package GUI_JediDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import app.ConnectionFactory;
import app.Operation;
import appTools.ALClass;


@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	public enum PanelCheckEnum {
		START_PANEL, CUSTOM_SEARCH, JMA_MENU, JMA_JEDI_ADD, JMA_JEDI_EDIT, JMA_JEDI_REMOVE
	}


	private static PanelCheckEnum panelCheck = PanelCheckEnum.START_PANEL;;

	//Images
	static File generalBG = new File("images/Jedi_Archives.jpg");
	static File jediBG = new File("images/hyperspacejump.jpg");
	static File sithBG = new File("images/Korriban.jpg");
	static File bountyHuntersBG = new File("images/BountyHunters.jpg");
	static File smugglersBG = new File("images/milleniumFalcon.jpg");
	static File battlesBG = new File("images/sabersCrossed.jpg");
	public static ImageIcon orderIcon = new ImageIcon("images/orderIconLarge.png");
	public static Image bgImage;

	//Data table structure
	private JPanel inputTablePanel;
	public JScrollPane scrollPane = new JScrollPane();
	private JPanel tablePanel = new JPanel(new GridLayout());
	public JTable inputTable;
	public JTable editTable;
	private String[][] inputs;
	public JTable viewTable;
	public String[][] savedOriginalArray;
	private JPanel counterPanel;
	private DefaultTableCellRenderer idColumnRenderer = new DefaultTableCellRenderer();;
	
	public static JLabel textTitle = new JLabel("", SwingConstants.CENTER);
	public JLabel confirmationLabel = new JLabel("", SwingConstants.CENTER);
	public JPanel confirmationButtonsPanel = new JPanel(new GridLayout(1, 2, 10, 0));

	private final String[] rankJediOptions = { "", "Padawan", "Knight", "Master", "Grand Master" };
	private final String[] specJediOptions = { "", "Guardian", "Consular", "Sentinel" };

	private final MyComboBoxRenderer rankJediOptionsJCBox = new MyComboBoxRenderer(rankJediOptions); //The actual JComboBox
	private final MyComboBoxRenderer specJediOptionsJCBox = new MyComboBoxRenderer(specJediOptions); //The actual JComboBox

	//SW font
	Font swFont;

	ALClass alClass = new ALClass();
	//Main buttons
	public static JButton beingsButton = new JButton("Root");
	public static JButton jediButton = new JButton("Jedi");
	public static JButton sithButton = new JButton("Sith");
	public static JButton bhButton = new JButton("Bounty Hunters");
	public static JButton smugglersButton = new JButton("Smugglers");
	public static JButton battlesButton = new JButton("Battles");
	public static JButton planetsButton = new JButton("Planets");
	public static JButton modifiedSearchButton = new JButton("Modified search");
	public static JButton manipulateButton = new JButton("Jedi Master Access");
	public static JButton goBackButtonToMain = new JButton("Back <<<");
	public static JButton goBackButtonToUpdateCategory = new JButton("Back <<<");

	//Buttons labels and panels
	public static JLabel buttonsLabel = new JLabel();
	public static JLabel advancedButtons = new JLabel();
	public static JLabel editTypeButtonsLabel = new JLabel();

	//Update buttons
	//Jedi
	public static JButton updateJediButton = new JButton("Jedi");
	public static JButton confirmJediUpdateButton = new JButton("Confirm >>>");

	//Sith
	public static JButton updateSithButton = new JButton("Sith");
	public static JButton confirmSithUpdateButton = new JButton("Confirm >>>");

	//Bounty Hunters
	public static JButton updateBountyHuntersButton = new JButton("Bounty Hunters");
	public static JButton confirmBountyHuntersUpdateButton = new JButton("Confirm >>>");

	//Smugglers
	public static JButton updateSmugglersButton = new JButton("Smugglers");
	public static JButton confirmSmugglersUpdateButton = new JButton("Confirm >>>");

	//Battles
	public static JButton updateBattlesButton = new JButton("Battles");
	public static JButton confirmBattlesUpdateButton = new JButton("Confirm >>>");

	//Planets
	public static JButton updatePlanetsButton = new JButton("Planets");
	public static JButton confirmPlanetsUpdateButton = new JButton("Confirm >>>");

	//General buttons
	public static JButton cancelChangesButton = new JButton("Cancel changes X");
	public static JButton emptyFieldsButton = new JButton("Empty all fields []");
	public static JButton unselectAllFieldsButton = new JButton("Unselect all fields []");
	public static JButton toAddDataButton = new JButton("add");
	public static JButton toEditDataButton = new JButton("edit");
	public static JButton toRemoveDataButton = new JButton("remove");


	public MainPanel () throws Exception {

		//Registering the SW font
		try {
			swFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/starjedi/Starjedi.ttf")));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		//MainPanel attributes
		this.setPreferredSize(new Dimension(Frame.FRAME_WIDTH, Frame.FRAME_HEIGHT));
		this.setLayout(null);

		//Reused Back Buttons
		goBackButtonToMain.setSize(100, 25);
		goBackButtonToMain.setLocation(15, 15);
		goBackButtonToUpdateCategory.setSize(100, 25);
		goBackButtonToUpdateCategory.setLocation(15, 15);

		//Reused edit type buttons
		editTypeButtonsLabel.setLayout(new GridLayout(1, 3, 5, 0));
		editTypeButtonsLabel.setSize(250, 25);
		editTypeButtonsLabel.setLocation(Frame.FRAME_WIDTH - editTypeButtonsLabel.getWidth() - 30, 15);
		editTypeButtonsLabel.add(MainPanel.toAddDataButton);
		editTypeButtonsLabel.add(MainPanel.toEditDataButton);
		editTypeButtonsLabel.add(MainPanel.toRemoveDataButton);
		
		idColumnRenderer.setHorizontalAlignment(JLabel.CENTER);
		idColumnRenderer.setBackground(Color.decode("#eeeeee"));
		
		addAllButtonListeners();
		setPanelToStart();

	}


	public void addAllButtonListeners () {

		beingsButton.addActionListener(alClass.showAllBeingsListener);
		jediButton.addActionListener(alClass.showAllJediListener);
		sithButton.addActionListener(alClass.showAllSithListener);
		bhButton.addActionListener(alClass.showAllBHListener);
		smugglersButton.addActionListener(alClass.showAllSmugglersListener);
		battlesButton.addActionListener(alClass.showAllBattlesListener);
		modifiedSearchButton.addActionListener(alClass.toModifiedSearchListener);
		manipulateButton.addActionListener(alClass.toJMAccessListener);
		goBackButtonToMain.addActionListener(alClass.toBackStartPanelListener);
		goBackButtonToUpdateCategory.addActionListener(alClass.toJMAccessListener);
		toAddDataButton.addActionListener(alClass.toAddJediListener);
		toEditDataButton.addActionListener(alClass.toEditDataListener);
		toRemoveDataButton.addActionListener(alClass.toRemoveDataListener);
		updateJediButton.addActionListener(alClass.toAddJediListener);
		confirmJediUpdateButton.addActionListener(alClass.confirmJediButtonListener);
		emptyFieldsButton.addActionListener(alClass.cancelOrEmptyListener);		
		cancelChangesButton.addActionListener(alClass.cancelOrEmptyListener);
		unselectAllFieldsButton.addActionListener(alClass.unselectAllFieldsListener);		
	}


	public void setScrollPane (String data, Connection connection) throws Exception {
		Connection con = connection;
		switch (data) {
			case "beings":
				viewTable = Operation.readQuery(Operation.OperationType.SELECT_ALL_BEINGS, con);
				scrollPane.getViewport().add(viewTable);
				break;
			case "jedi":
				viewTable = Operation.readQuery(Operation.OperationType.SELECT_ALL_JEDI, con);
				scrollPane.getViewport().add(viewTable);
				break;
			case "jediEditOrRemove":
				viewTable = Operation.readQuery(Operation.OperationType.SELECT_ALL_JEDI_FOR_EDIT, con);
				scrollPane.getViewport().add(viewTable);
				break;
			case "sith":
				viewTable = Operation.readQuery(Operation.OperationType.SELECT_ALL_SITH, con);
				scrollPane.getViewport().add(viewTable);
				break;
			case "bountyHunters":
				viewTable = Operation.readQuery(Operation.OperationType.SELECT_ALL_BOUNTYHUNTERS, con);
				scrollPane.getViewport().add(viewTable);
				break;
			case "smugglers":
				viewTable = Operation.readQuery(Operation.OperationType.SELECT_ALL_SMUGGLERS, con);
				scrollPane.getViewport().add(viewTable);
				break;
			case "battles":
				viewTable = Operation.readQuery(Operation.OperationType.SELECT_ALL_BATTLES, con);
				scrollPane.getViewport().add(viewTable);
		}
	}


	public void setPanelToStart () throws IOException {

		setPanelCheck(PanelCheckEnum.START_PANEL);

		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		removeAll();
		revalidate();

		this.tablePanel.setSize(new Dimension(600, 350));
		this.tablePanel.setLocation(Frame.FRAME_WIDTH / 3, Frame.FRAME_HEIGHT / 2 - tablePanel.getHeight() / 2 - 50);
		this.tablePanel.setLayout(new BorderLayout());
		this.tablePanel.add(scrollPane, BorderLayout.CENTER);
		this.add(tablePanel);

		textTitle.setText("Luminous Beings");
		textTitle.setSize(600, 40);
		textTitle.setLocation(tablePanel.getX(), tablePanel.getY() - 60);
		textTitle.setFont(swFont);
		textTitle.setForeground(Color.yellow);
		this.add(textTitle);

		advancedButtons.setBackground(Color.green);
		advancedButtons.setBounds(tablePanel.getX() / 2 - 254 / 2, tablePanel.getY() + tablePanel.getHeight() / 2 - 100, 254, 200);
		advancedButtons.setLayout(new GridLayout(3, 0, 5, 20));
		advancedButtons.add(beingsButton);
		advancedButtons.add(modifiedSearchButton);
		advancedButtons.add(manipulateButton);
		this.add(advancedButtons);

		buttonsLabel.setBounds(tablePanel.getX(), tablePanel.getY() + tablePanel.getHeight() + 20, 600, 75);
		buttonsLabel.setLayout(new GridLayout(0, 2, 5, 5));
		buttonsLabel.add(jediButton);
		buttonsLabel.add(sithButton);
		buttonsLabel.add(bhButton);
		buttonsLabel.add(smugglersButton);
		buttonsLabel.add(battlesButton);
		buttonsLabel.add(planetsButton);
		this.add(buttonsLabel);

		this.setBackgroundTo("start");

		try {
			this.setScrollPane("beings", connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		repaint();
	}


	public void setPanelToCustomSearch () {

		setPanelCheck(PanelCheckEnum.CUSTOM_SEARCH);

		removeAll();
		revalidate();
		goBackButtonToMain.setSize(100, 25);
		goBackButtonToMain.setLocation(15, 15);
		this.add(goBackButtonToMain);

		repaint();
	}


	public void setPanelToJMAccess () throws IOException {

		setPanelCheck(PanelCheckEnum.JMA_MENU);

		this.setBackgroundTo("root");

		JPanel buttons = new JPanel();

		removeAll();
		revalidate();

		this.add(goBackButtonToMain);

		buttons.setSize(600, 200);
		buttons.setLocation(this.getWidth() / 2 - buttons.getWidth() / 2, this.getHeight() / 2 - buttons.getHeight() / 2);

		textTitle.setText("update category:");
		textTitle.setLocation(this.getWidth() / 2 - textTitle.getWidth() / 2, buttons.getY() - 95);
		this.add(textTitle);

		buttons.setOpaque(false);
		buttons.setLayout(new GridLayout(3, 2, 15, 15));

		buttons.add(updateJediButton);
		buttons.add(updateSithButton);
		buttons.add(updateBountyHuntersButton);
		buttons.add(updateSmugglersButton);
		buttons.add(updateBattlesButton);
		buttons.add(updatePlanetsButton);
		this.add(buttons);

		repaint();
	}


	public void setPanelToJMAdd (String category) {

		removeAll();
		revalidate();
		

		final int numberOfInputRows = 7;
		String[] columnNames;
		
		inputTablePanel = new JPanel(new GridLayout());
		inputTablePanel.setSize(900, 200);
		inputTablePanel.setLocation(this.getWidth() / 2 - inputTablePanel.getWidth() / 2 + 10, this.getHeight() / 2 - inputTablePanel.getHeight() / 2);
		
		//Counter on the left side
		counterPanel = new JPanel(new GridLayout(numberOfInputRows, 1));
		for (int i = 1; i <= numberOfInputRows; i++) {
			counterPanel.add(new JLabel(String.valueOf(i), SwingConstants.CENTER));
		}
		counterPanel.setSize(25, inputTablePanel.getHeight() - 20);
		counterPanel.setLocation(inputTablePanel.getX() - counterPanel.getWidth(), inputTablePanel.getY() + 20);
		counterPanel.setOpaque(true);
		this.add(counterPanel);

		confirmationButtonsPanel.setBounds(inputTablePanel.getX(), inputTablePanel.getY() + inputTablePanel.getHeight() + 10, inputTablePanel.getWidth(), 40);
		confirmationButtonsPanel.setOpaque(false);
		confirmationButtonsPanel.remove(cancelChangesButton);
		confirmationButtonsPanel.remove(unselectAllFieldsButton);
		confirmationButtonsPanel.add(confirmJediUpdateButton);
		confirmationButtonsPanel.add(emptyFieldsButton);
		this.add(confirmationButtonsPanel);

		confirmationLabel.setSize(confirmationButtonsPanel.getWidth() / 2, 40);
		confirmationLabel.setLocation(Frame.FRAME_WIDTH / 2 - confirmationLabel.getWidth() / 2, confirmationButtonsPanel.getY() + confirmationButtonsPanel.getHeight() + 25);
		confirmationLabel.setFont(swFont);
		confirmationLabel.setOpaque(false);
		this.add(confirmationLabel);
		
		this.confirmationLabel.setText("");
		this.add(goBackButtonToUpdateCategory);
		this.add(textTitle);
		this.add(editTypeButtonsLabel);


		//Data
		switch (category) {
			case "jedi":

				setPanelCheck(PanelCheckEnum.JMA_JEDI_ADD);

				textTitle.setText("Jedi to add (1 - 7):");

				//Table's attributes for the specific class' input				
				columnNames = new String[11];
				columnNames[0] = "Last name";
				columnNames[1] = "First name";
				columnNames[2] = "Species";
				columnNames[3] = "Birthdate";
				columnNames[4] = "Birthplace";
				columnNames[5] = "Death date";
				columnNames[6] = "Deathplace";
				columnNames[7] = "Rank";
				columnNames[8] = "Specialization";
				columnNames[9] = "Saber type";
				columnNames[10] = "Saber color";

				inputs = new String[numberOfInputRows][columnNames.length];
				for (int i = 0; i < numberOfInputRows; i++) {
					for (int j = 0; j < columnNames.length; j++) {
						if (j != 7 && j != 8) { //not sure if needed - ComboBoxes have to be added for these cells
							inputs[i][j] = "";
						}
					}
				}

				

				inputTable = new JTable(inputs, columnNames);
				inputTable.setRowHeight(25);
				inputTable.getColumnModel().getColumn(1).setPreferredWidth(65);
				inputTable.getColumnModel().getColumn(4).setPreferredWidth(65);
				inputTable.getColumnModel().getColumn(6).setPreferredWidth(65);

				//Combo boxes for insert
				rankJediOptionsJCBox.setSelectedIndex(0);
				inputTable.getColumnModel().getColumn(7).setCellEditor(new MyComboBoxEditor(rankJediOptions));
				inputTable.getColumnModel().getColumn(7).setCellRenderer(rankJediOptionsJCBox);

				specJediOptionsJCBox.setSelectedIndex(0);
				inputTable.getColumnModel().getColumn(8).setCellEditor(new MyComboBoxEditor(specJediOptions));
				inputTable.getColumnModel().getColumn(8).setCellRenderer(specJediOptionsJCBox);

				inputTablePanel.add(new JScrollPane(inputTable));

				this.add(inputTablePanel);

				repaint();
				break;
		}

	}


	public void setPanelToJMEdit (String category) throws Exception {

		removeAll();
		revalidate();

		this.confirmationLabel.setText("");
		this.add(goBackButtonToUpdateCategory);
		this.add(textTitle);
		this.add(editTypeButtonsLabel);
		this.add(confirmationLabel);

		confirmationButtonsPanel.setOpaque(false);
		confirmationButtonsPanel.remove(emptyFieldsButton);
		confirmationButtonsPanel.remove(unselectAllFieldsButton);
		confirmationButtonsPanel.add(cancelChangesButton);
		this.add(confirmationButtonsPanel);
		
		
		tablePanel.setSize(900 + this.counterPanel.getWidth(), 200);
		tablePanel.setLocation(this.counterPanel.getX(), this.getHeight() / 2 - inputTablePanel.getHeight() / 2);
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		
		//Data
		switch (category) {
			case "jediEdit":

				setPanelCheck(PanelCheckEnum.JMA_JEDI_EDIT);
				textTitle.setText("Edit Jedi:");
			

				this.setScrollPane("jediEditOrRemove", ConnectionFactory.getConnection());
				this.add(tablePanel);

				//JComboBoxes for editing
				viewTable.getColumnModel().getColumn(8).setCellEditor(new MyComboBoxEditor(rankJediOptions));
				viewTable.getColumnModel().getColumn(8).setCellRenderer(rankJediOptionsJCBox);

				viewTable.getColumnModel().getColumn(9).setCellEditor(new MyComboBoxEditor(specJediOptions));
				viewTable.getColumnModel().getColumn(9).setCellRenderer(specJediOptionsJCBox);

				viewTable.setRowHeight(25);
				viewTable.getColumnModel().getColumn(0).setCellRenderer(idColumnRenderer);
				viewTable.getColumnModel().getColumn(0).setPreferredWidth(20);
				viewTable.getColumnModel().getColumn(1).setPreferredWidth(this.inputTable.getColumnModel().getColumn(1).getWidth());
				viewTable.getColumnModel().getColumn(2).setPreferredWidth(this.inputTable.getColumnModel().getColumn(1).getWidth());
				viewTable.getColumnModel().getColumn(4).setPreferredWidth(this.inputTable.getColumnModel().getColumn(4).getWidth());
				viewTable.getColumnModel().getColumn(6).setPreferredWidth(this.inputTable.getColumnModel().getColumn(6).getWidth());

				repaint();
				break;

		}

		//Saving the originally displayed table for further use
		savedOriginalArray = Operation.saveOriginalTable();
	}


	public void setPanelToJMRemove (String category) throws Exception {
		
		removeAll();
		revalidate();

		this.confirmationLabel.setText("");
		this.add(goBackButtonToUpdateCategory);
		this.add(textTitle);
		this.add(editTypeButtonsLabel);
		this.add(confirmationLabel);
		
		
		confirmationButtonsPanel.setOpaque(false);
		confirmationButtonsPanel.remove(emptyFieldsButton);
		confirmationButtonsPanel.remove(cancelChangesButton);
		confirmationButtonsPanel.add(unselectAllFieldsButton);
		this.add(confirmationButtonsPanel);
		
		
		tablePanel.setSize(900 + this.counterPanel.getWidth(), 200);
		tablePanel.setLocation(this.counterPanel.getX(), this.getHeight() / 2 - inputTablePanel.getHeight() / 2);
		tablePanel.add(scrollPane, BorderLayout.CENTER);
	
		
		switch(category) {
			case "jediRemove":
					
				setPanelCheck(PanelCheckEnum.JMA_JEDI_REMOVE);
				textTitle.setText(("Remove Jedi: "));
				
				
				this.setScrollPane("jediEditOrRemove", ConnectionFactory.getConnection());
				this.add(tablePanel);
							
				viewTable.setRowHeight(25);
				viewTable.getColumnModel().getColumn(0).setCellRenderer(idColumnRenderer);
				viewTable.getColumnModel().getColumn(0).setPreferredWidth(20);
				viewTable.getColumnModel().getColumn(1).setPreferredWidth(this.inputTable.getColumnModel().getColumn(1).getWidth());
				viewTable.getColumnModel().getColumn(2).setPreferredWidth(this.inputTable.getColumnModel().getColumn(1).getWidth());
				viewTable.getColumnModel().getColumn(4).setPreferredWidth(this.inputTable.getColumnModel().getColumn(4).getWidth());
				viewTable.getColumnModel().getColumn(6).setPreferredWidth(this.inputTable.getColumnModel().getColumn(6).getWidth());		
		
				repaint();					
				break;
		}
		
	}


	public void clearInputTable () throws Exception {

		if (MainPanel.getPanelCheck() == PanelCheckEnum.JMA_JEDI_ADD) {
			for (int i = 0; i < inputTable.getRowCount(); i++) {
				for (int j = 0; j < inputTable.getColumnCount(); j++) {
					if (inputTable.getModel().getValueAt(i, j) != "") {
						inputTable.getModel().setValueAt("", i, j);
					}
				}
			}

			repaint();

		}

	}


	public void removeChanges () {
		try {
			setPanelToJMEdit("jediEdit");
			this.confirmationLabel.setForeground(Color.yellow);
			this.confirmationLabel.setText("Changes cancelled");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void setBackgroundTo (String panel) throws IOException {
		switch (panel) {
			case "start":
				bgImage = ImageIO.read(generalBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
				repaint();
				break;
			case "jedi":
				bgImage = ImageIO.read(jediBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
				repaint();
				break;
			case "sith":
				bgImage = ImageIO.read(sithBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
				repaint();
				break;
			case "bountyHunters":
				bgImage = ImageIO.read(bountyHuntersBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
				repaint();
				break;
			case "smugglers":
				bgImage = ImageIO.read(smugglersBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
				repaint();
				break;
			case "battles":
				bgImage = ImageIO.read(battlesBG).getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
				repaint();
				break;
		}
	}


	public void setNoDataErrorLabel () {
		Frame.gui.confirmationLabel.setForeground(Color.red);
		Frame.gui.confirmationLabel.setText("No data input");
		System.out.println("No data input");
	}


	class MyComboBoxRenderer extends JComboBox<Object> implements TableCellRenderer {
		public MyComboBoxRenderer (String[] items) {
			super(items);
		}


		public Component getTableCellRendererComponent (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if (isSelected) {
				setForeground(table.getSelectionForeground());
				super.setBackground(table.getSelectionBackground());
			} else {
				setForeground(table.getForeground());
				setBackground(table.getBackground());
			}
			setSelectedItem(value);
			return this;
		}
	}



	class MyComboBoxEditor extends DefaultCellEditor {
		public MyComboBoxEditor (String[] items) {
			super(new JComboBox<Object>(items));
		}
	}


	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);
	}


	public static PanelCheckEnum getPanelCheck () {
		return panelCheck;
	}
	
	
	public static void configureViewTable() {
		
	}

	
	public static void setPanelCheck (PanelCheckEnum panelCheck) {
		MainPanel.panelCheck = panelCheck;
	}
}
