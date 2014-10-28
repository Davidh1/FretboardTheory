package src.main.guitar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Fretboard {
	private List<GuitarString> guitarStrings;
	private final int STRING_COUNT = 6;
	private final int FRET_COUNT = 24;
	private Map<Integer, String> stringRootNotes;

	public Fretboard() {
		guitarStrings = new ArrayList<GuitarString>();
		initializeMaps();
		initializeFretboard();
	}

	private void initializeFretboard() {		
		for (int i = 1; i <= STRING_COUNT; i++) {//loop through each of the guitar strings
			GuitarString guitarString = new GuitarString(i, stringRootNotes.get(i));			
			int rootNote = Note.noteNumbers.get(guitarString.getStringRoot());	
			for (int j = 0; j < FRET_COUNT + 1; j++) {//loop through each fret	
				int noteNumber = 0;
				//this is to reset the note to 1 after it hits 12.
				if(rootNote + j < 13){
					noteNumber = rootNote + j;
				} else if (rootNote + j - 12 < 13){
					noteNumber = rootNote + j - 12;
				} else {
					noteNumber = rootNote + j - 24;
				}
				Note note = new Note(noteNumber , Note.noteLetters.get(noteNumber), j);
				guitarString.getNotes().put(j, note);
			}
			guitarStrings.add(guitarString);
		}
		for (GuitarString guitarString : guitarStrings) {
			for(Entry<Integer, Note> note : guitarString.getNotes().entrySet()){
				System.out.println("String number = " + guitarString.getStringNumber() + " String Root = " + guitarString.getStringRoot() + " Note = " + note);
			}
		}
	}

	private void initializeMaps() {
		//TODO:  Move this
		stringRootNotes = new HashMap<Integer, String>();

		stringRootNotes.put(1, "E");
		stringRootNotes.put(2, "B");
		stringRootNotes.put(3, "G");
		stringRootNotes.put(4, "D");
		stringRootNotes.put(5, "A");
		stringRootNotes.put(6, "E");
	}

	public List<GuitarString> getGuitarStrings() {
		return guitarStrings;
	}

	public void setGuitarStrings(List<GuitarString> guitarStrings) {
		this.guitarStrings = guitarStrings;
	}
	
	
}
