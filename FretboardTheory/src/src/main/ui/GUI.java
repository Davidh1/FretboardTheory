package src.main.ui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import src.main.guitar.Fretboard;
import src.main.guitar.Note;

public class GUI {

	private Dimension buttonDimension = new Dimension(100, 25);
	private Dimension frameSize = new Dimension(1000, 750);

	public GUI() {
		Fretboard fretboard = new Fretboard();
		JFrame frame = new JFrame("FRETBOARD THEORY!");
		Container contentPane = frame.getContentPane();
		SpringLayout layout = new SpringLayout();	
		
		Fret button = new Fret(fretboard.getGuitarStrings().get(0).getNotes().get(0));//get the first note of the first string
//		contentPane.add(button);
		layout.putConstraint(SpringLayout.WEST, button, 100, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, button, 100, SpringLayout.NORTH, contentPane);
		contentPane.add(button);
		
		
		for (int i = 1; i < fretboard.getGuitarStrings().size(); i++) {
			for (Note note : fretboard.getGuitarStrings().get(i).getNotes()) {
//				contentPane.add(button);
//				button = new Fret(note); 
//				button.setPreferredSize(buttonDimension);
//				layout.putConstraint(SpringLayout.WEST, button, 100, SpringLayout.WEST, contentPane);
//				layout.putConstraint(SpringLayout.NORTH, button, 100, SpringLayout.NORTH, contentPane);
//				
			}
		}
		contentPane.setLayout(layout);
		frame.setSize(frameSize);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
