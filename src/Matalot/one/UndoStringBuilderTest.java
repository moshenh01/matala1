package Matalot.one;



import Matalot.one.UndoableStringBuilder;

import static org.junit.jupiter.api.Assertions.*;

class UndoStringBuilderTest {

    @org.junit.jupiter.api.Test
    void testAppend() {
        //1
        UndoableStringBuilder sbE1 = new UndoableStringBuilder();
        sbE1.append("100 present");
        assertEquals("100 present",sbE1.toString());
        //2
        UndoableStringBuilder sbE2 = new UndoableStringBuilder("going to the gym");
        sbE2.append(" to space");
        assertEquals("going to the gym to space",sbE2.toString());
        /**
         * we know StringBuilder is already checked all of this method,
         * so we will check only the one's that matter, Undo().
         */

    }

    /**
     * other test on the same agenda.
     */
    @org.junit.jupiter.api.Test
    void delete() {
        UndoableStringBuilder sbDelet = new UndoableStringBuilder("moty");
       sbDelet.delete(2,1);
        assertEquals("moty",sbDelet.toString());
        sbDelet.delete(-1,10);
        assertEquals("moty",sbDelet.toString());
    }

    @org.junit.jupiter.api.Test
    void insert() {
        UndoableStringBuilder sbE1 = new UndoableStringBuilder();
        sbE1.append("going to to space");
        sbE1.insert(9,"the gym ");
        assertEquals("going to the gym to space",sbE1.toString());
        UndoableStringBuilder sbE2 = new UndoableStringBuilder();
        sbE2.append("to be");
        sbE2.insert(3,"be or not to ");
        assertEquals("to be or not to be",sbE2.toString());
        UndoableStringBuilder sbE3 = new UndoableStringBuilder("to be");
        sbE3.insert(3,null);
        assertEquals("to nullbe",sbE3.toString());

    }

    @org.junit.jupiter.api.Test
    void replace() {
        UndoableStringBuilder sbE1 = new UndoableStringBuilder();
        sbE1.append("to be or not to be");
        sbE1.replace(0,6,"");
        String str = sbE1.replace(0,6,"").toString();
        sbE1.undo();
        sbE1.delete(0,6);
        assertEquals(str,sbE1.toString());
        UndoableStringBuilder sbE2 = new UndoableStringBuilder("going or not to gym to space");
        sbE2.replace(6,16,"to the ");
        assertEquals("going to the gym to space",sbE2.toString());
        UndoableStringBuilder sbE3 = new UndoableStringBuilder("going or not to gym to space");
        sbE3.replace(5,10,null);
        assertEquals("going or not to gym to space",sbE3.toString());
    }

    @org.junit.jupiter.api.Test
    void reverse() {
        UndoableStringBuilder sbE1 = new UndoableStringBuilder();
        sbE1.append("eb ot ton ro eb ot");
        sbE1.reverse();
        assertEquals("to be or not to be",sbE1.toString());
        UndoableStringBuilder sbE2 = new UndoableStringBuilder("going to the gym");
        sbE2.append(" to space");
        UndoableStringBuilder sbE3 = new UndoableStringBuilder("going to the gym");
        sbE3.append(" to space");
        sbE3.reverse();
        sbE3.reverse();
        assertEquals(sbE3.toString(),sbE2.toString());
    }

    @org.junit.jupiter.api.Test
    void undo() {
        //1. basic undo.
        UndoableStringBuilder usb = new UndoableStringBuilder();
        usb.append("khol");usb.append(" aholam");usb.append(" koolo");usb.append(" gesher");
        usb.append(" tzsaar");usb.append(" moed");
        usb.undo();
        assertEquals("khol aholam koolo gesher tzsaar",usb.toString());
        //2. out of bounds time's undo.
        for(int i = 0;i <10;i++)
            usb.undo();
        assertEquals(usb.toString(),"");
        //3.checking index status
        usb.append("banana");
        assertEquals("banana",usb.toString());
        //
    }
}