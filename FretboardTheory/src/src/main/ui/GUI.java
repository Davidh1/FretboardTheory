package src.main.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import src.main.guitar.Fretboard;
import src.main.guitar.GuitarString;
import src.main.guitar.Note;

public class GUI {

	private Dimension buttonDimension = new Dimension(75, 25);
	private Dimension frameSize = new Dimension(1850, 1000);

	public static final Map<Integer, Color> buttonColors = new HashMap<Integer, Color>();
	static {
		buttonColors.put(1, Color.RED);
		buttonColors.put(2, Color.BLUE);
		buttonColors.put(3, Color.GREEN);
		buttonColors.put(4, Color.ORANGE);
		buttonColors.put(5, Color.YELLOW);
		buttonColors.put(6, Color.MAGENTA);
		buttonColors.put(7, Color.PINK);
		buttonColors.put(8, Color.WHITE);
		buttonColors.put(9, Color.CYAN);
		buttonColors.put(10, Color.DARK_GRAY);
		buttonColors.put(11, Color.BLACK);
		buttonColors.put(12, Color.GRAY);
	}

	public GUI() {
		final Fretboard fretboard = new Fretboard();
		JFrame frame = new JFrame("FRETBOARD THEORY!");
		Container contentPane = frame.getContentPane();
		SpringLayout layout = new SpringLayout();

		JButton button;
		Dimension buttonPadding;
		int xPadding = 0;
		int yPadding = 0;

		for (int i = 0; i < fretboard.getGuitarStrings().size(); i++) {
			button = fretboard.getGuitarStrings().get(i).getNotes().get(0);//get the first note for each string
			buttonPadding = buttonDimension;//reset the padding to be the size of the first fret
			xPadding = (int) buttonPadding.getHeight() * i;		
			yPadding = (int) buttonPadding.getWidth();
			for (int j = 0; j < fretboard.getGuitarStrings().get(i).getNotes().size(); j++) {				
				button = fretboard.getGuitarStrings().get(i).getNotes().get(j);//get the guitar string at 'i' and the fret at 'j'				
				button.setPreferredSize(buttonPadding);
				yPadding = (int) buttonDimension.getWidth() * j;
				layout.putConstraint(SpringLayout.WEST, button, yPadding, SpringLayout.WEST, contentPane);
				layout.putConstraint(SpringLayout.NORTH, button, xPadding, SpringLayout.NORTH, contentPane);
				
				button.addActionListener(new ActionListener() {//add action listener to each button
					
					//how's this for readable?					
					@Override
					public void actionPerformed(ActionEvent e) {						
						JButton buttonClicked = (JButton) e.getSource();
						System.out.println("button clicked = " + buttonClicked.getText());
						//loop through each button to color the appropriate notes						
						for (GuitarString guitarString : fretboard.getGuitarStrings()){
							for (Entry<Integer, Note> note : guitarString.getNotes().entrySet()) {	
								if (note.getValue().getText().equalsIgnoreCase(buttonClicked.getText())){
									if (note.getValue().isClicked()){
										note.getValue().setBackground(null);
										note.getValue().setClicked(false);
									} else {
										int colorInt = Note.noteNumbers.get(buttonClicked.getText());							
										note.getValue().setBackground(buttonColors.get(colorInt));
										note.getValue().setClicked(true);
									}
								}
							}
						}
					}
				});
				contentPane.add(button);
				//Set the button up for the next iteration


			}
		}
		contentPane.setLayout(layout);
		frame.setSize(frameSize);
//		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	//TODO
	private void calculateButtonPadding() {

	}
}
