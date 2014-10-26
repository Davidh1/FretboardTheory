package src.main.ui;

import javax.swing.JButton;
import javax.swing.JFrame;

import src.main.guitar.Fretboard;
import src.main.guitar.GuitarString;
import src.main.guitar.Note;

public class GUI {

	public GUI(){
		Fretboard fretboard = new Fretboard();		
		JFrame frame = new JFrame("FRETBOARD THEORY!");
				
		frame.setSize(1000, 1000);//TODO: Make into ratio of the screen instead of hardcoding
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(GuitarString guitarString : fretboard.getGuitarStrings()){
			for(Note note : guitarString.getNotes()){
				JButton button = new JButton("Test");
				button.setSize(10, 10);
				frame.add(button);
			}
		}
		
		frame.setVisible(true);
	}

}
