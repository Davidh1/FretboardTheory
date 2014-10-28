package src.main.guitar;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GuitarString {

	private int stringNumber;
	private String stringRoot;
	private Map<Integer, Note> notes = new HashMap<Integer, Note>();

	public GuitarString(int stringNumber, String stringRoot) {
		this.stringNumber = stringNumber;
		this.stringRoot = stringRoot;
	}

	public HashMap<Integer, Note> getNotes() {
		return (HashMap<Integer, Note>) notes;
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

		for (Entry<Integer, Note> note : notes.entrySet()) {
			stringBuffer.append(" Fret = " + note.getKey() + " Note = " + note.getValue());
		}
		return stringBuffer.toString();
	}
}
