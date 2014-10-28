package src.main.guitar;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;

public class Note extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noteNumber;
	private int fretNumber;
	private String noteLetter;
	private boolean clicked = false;

	public static final Map<Integer, String> noteLetters = new HashMap<Integer, String>();
	static {
		noteLetters.put(1, "A");
		noteLetters.put(2, "A♯/B♭");
		noteLetters.put(3, "B");
		noteLetters.put(4, "C");
		noteLetters.put(5, "C♯/D♭");
		noteLetters.put(6, "D");
		noteLetters.put(7, "D♯/E♭");
		noteLetters.put(8, "E");
		noteLetters.put(9, "F");
		noteLetters.put(10, "F♯/G♭");
		noteLetters.put(11, "G");
		noteLetters.put(12, "G♯/A♭");
	}

	public static final Map<String, Integer> noteNumbers = new HashMap<String, Integer>();
	static {
		noteNumbers.put("A", 1);
		noteNumbers.put("A♯/B♭", 2);
		noteNumbers.put("B", 3);
		noteNumbers.put("C", 4);
		noteNumbers.put("C♯/D♭", 5);
		noteNumbers.put("D", 6);
		noteNumbers.put("D♯/E♭", 7);
		noteNumbers.put("E", 8);
		noteNumbers.put("F", 9);
		noteNumbers.put("F♯/G♭", 10);
		noteNumbers.put("G", 11);
		noteNumbers.put("G♯/A♭", 12);
	}

	public Note(int noteNumber, String noteLetter, int fretNumber) {
		this.noteNumber = noteNumber;
		this.noteLetter = noteLetter;
		this.fretNumber = fretNumber;
		setText(noteLetter);
	}
	
	public int getNoteNumber(){
		return noteNumber;
	}
	
	public void setNoteNumber(int noteNumber){
		this.noteNumber = noteNumber;
		setNoteLetter(Note.noteLetters.get(noteNumber));//update the note letter whenever the note number changes
	}	
	
	public String getNoteLetter(){
		return noteLetter;		
	}
	
	public void setNoteLetter(String noteLetter){
		this.noteLetter = noteLetter;
	}
	
	public int getFretNumber() {
		return fretNumber;
	}

	public void setFretNumber(int fretNumber) {
		this.fretNumber = fretNumber;
	}
	
	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	@Override
	public String toString(){
		return "Note Number = " + noteNumber + " Fret Number = " + fretNumber + " Note Letter = " + noteLetter;// + " String Letter = " //+ baseNoteLetter;
	}
}
