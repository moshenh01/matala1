package Matalot.one;

import Matalot.one.SaveUndo;

public class UndoableStringBuilder extends SaveUndo {
	/**
	 * Use StringBuilder for class variable,so we
	 * can use all StringBuilder function.
	 */
	StringBuilder sb;
	
	/**
	 * Create a new UndoStringBuilder with default StringBuilder contractor.
	 */
	public UndoableStringBuilder() {
		this.sb = new StringBuilder();
	}

	/**
	 * Create a new <code>UndoStringBuilder</code> with the characters in the
	 * specified <code>String</code>. Create a new StringBuilder with  the
	 * characters in the specified String.
	 * @param str the <code>String</code> to convert.
	 */
	public UndoableStringBuilder(String str) {
		if(str == null) {
			this.sb = new StringBuilder("");
		}
		else
			this.sb = new StringBuilder(str);

	}

	/**
	 * Appends the specified string to this character sequence. Save the string of
	 * the new append StringBuilder to array list.
	 * 
	 * @param str the <code>String</code> to append.
	 * @return this <code>StringBuilder</code>.
	 */
	public StringBuilder append(String str) {
		this.sb.append(str);
		save(sb.toString());
		return sb;
	}

	/**
	 * Removes the characters in a substring of this sequence. The substring begins
	 * at the specified start and extends to the character at index end - 1 or to
	 * the end of the sequence if no such character exists. If start is equal to
	 * end, no changes are made. Save the string of the new StringBuilder to array
	 * list.
	 * 
	 * @param start the first character to delete.
	 * @param end   the index after the last character to delete.
	 * @return this <code>StringBuilder</code>.
	 */
	public StringBuilder delete(int start, int end) {
		try
		{
			this.sb.delete(start, end);
			save(sb.toString());
		}
		catch (StringIndexOutOfBoundsException e)
		{
			System.err.println("index is out of bounds");
		}

		return sb;
	}

	/**
	 * Inserts the string into this character sequence. Save the string of the new
	 * StringBuilder to array list.
	 * 
	 * @param offset the place to insert in this buffer.
	 * @param str    the <code>String</code> to insert.
	 * @return this <code>StringBuilder</code>.
	 */
	public StringBuilder insert(int offset, String str) {
		try {
			this.sb.insert(offset, str);
			save(sb.toString());
		}
		catch(StringIndexOutOfBoundsException e){
			System.err.println("index is out of bounds");
		}
		return sb;
	}

	/**
	 * Replaces the characters in a substring of this sequence with characters in
	 * the specified String. The substring begins at the specified start and extends
	 * to the character at index end - 1 or to the end of the sequence if no such
	 * character exists. First the characters in the substring are removed and then
	 * the specified String is inserted at start. Save the string of the new
	 * StringBuilder to array list.
	 * 
	 * @param start the beginning index of characters to delete.
	 * @param end   the ending index of characters to delete.
	 * @param str   the new <code>String</code> to insert.
	 * @return this <code>StringBuilder</code>.
	 */
	public StringBuilder replace(int start, int end, String str) {
		try {
			this.sb.replace(start, end, str);
			save(sb.toString());
		}
		catch(StringIndexOutOfBoundsException e){
			System.err.println("index is out of bounds");
		}
		catch(NullPointerException e){
			System.err.println("str is null");
		}

		return sb;
	}

	/**
	 * Causes this character sequence to be replaced by the reverse of the sequence.
	 * Save the string of the new StringBuilder to array list.
	 * 
	 * @return this <code>StringBuilder</code>
	 */

	public StringBuilder reverse() {
		this.sb.reverse();
		save(sb.toString());
		return sb;

	}

	/**
	 * Doing undo to StringBuilder function (explanation in the father class);
	 */
	public void undo() {
		this.sb = new StringBuilder(Undo());
	}

	public String toString() {
		return sb.toString();
	}
}