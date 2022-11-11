package Matalot.one;

import java.util.ArrayList;

public class SaveUndo {
	/**
	 * Creating new array list to restore StringBuilder strings.
	 */
	ArrayList<String> arrs = new ArrayList<String> ();
	/**
	 * Index of the next free place in the array list
	 * that we can put in the next string.
	 */
	int indx = 0;
	/**
	 * Saves the string into the array list in indx place.
	 * @param str the string to save.
	 */
	public void save(String str) {
		arrs.add(str);
		indx++;
	}
	/**
	 * remove the last string from the array list 
	 * 
	 * @return if the array list is empty return "empty".
	 * 			if the array list is not empty return last element in the array.
	 */
	public String Undo() {
		indx--;
		if(indx >= 0) {
			arrs.remove(indx);
			if(indx == 0) {
				return "";
			}
			else if(indx > 0 ) {
				return arrs.get(indx-1);
			}
				
		}
		return "";
	}

}
