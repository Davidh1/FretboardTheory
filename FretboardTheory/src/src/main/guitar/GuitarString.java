package src.main.guitar;

import java.util.ArrayList;
import java.util.List;

public class GuitarString {

	//	private List<Integer> frets;
	private int stringNumber;
	private String stringRoot;
	private List<Note> notes = new ArrayList<Note>();;

	public GuitarString(int stringNumber, String stringRoot) {
		this.stringNumber = stringNumber;
		this.stringRoot = stringRoot;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public int getStringNumber() {
		return stringNumber;
	}

	public void setStringNumber(int stringNumber) {
		this.stringNumber = stringNumber;
	}

	public String getStringRoot() {
		return stringRoot;
	}

	public void setStringRoot(String stringRoot) {
		this.stringRoot = stringRoot;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		/* looping through a map...cool */
		//		for(Entry<Integer, String> note : notes.entrySet()){
		//			stringBuffer.append(" Fret = " + note.getKey() + " Note = " + note.getValue());
		//		}
		for (Note note : notes) {
			stringBuffer.append("String number = " + stringNumber + "String Root = " + stringRoot + " Fret = " + note.getFretNumber() + " Note Number = " + note.getNoteNumber() + " Note = " + note.getNoteLetter());
		}
		return stringBuffer.toString();
	}
}
