package homework.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayModelTest {

    private final MyArrayModel<Orange> orangeList = new MyArrayModel<>();

    /**
     * Testing to get array size
     */
    @Test
    void testGetSizeWithAddedElement() {
        Orange firstOrange = new Orange(1, "russian", 70);

        orangeList.add(firstOrange);


        assertEquals(1, orangeList.size());
        assertEquals(firstOrange, orangeList.get(0));
    }


    /**
     * Testing adding an element to an array
     */
    @Test
    void testAddElementInArray() {
        Orange firstOrange = new Orange(1, "russian", 70);
        Orange secondOrange = new Orange(2, "marocco", 100);
        Orange thirdOrange = new Orange(3, "african", 80);

        orangeList.add(firstOrange);
        orangeList.add(secondOrange);
        orangeList.add(thirdOrange);

        assertEquals(3, orangeList.size());
        assertTrue(thirdOrange.equals(orangeList.get(2)));
    }

    /**
     * Testing to remove an element from an array by index
     */
    @Test
    void testRemoveElementFromArrayByIndex() {
        Orange firstOrange = new Orange(1, "russian", 70);
        Orange secondOrange = new Orange(2, "marocco", 100);
        Orange thirdOrange = new Orange(3, "african", 80);

        orangeList.add(firstOrange);
        orangeList.add(secondOrange);
        orangeList.add(thirdOrange);

        orangeList.remove(2);

        assertTrue(secondOrange.equals(orangeList.get(1)));
        assertTrue(firstOrange.equals(orangeList.get(0)));
    }


    /**
     * Testing to get an element from an array by index
     */
    @Test
    void testGetElementFromArrayByIndex() {
        Orange firstOrange = new Orange(1, "russian", 70);
        Orange secondOrange = new Orange(2, "marocco", 100);

        orangeList.add(firstOrange);
        orangeList.add(secondOrange);

        assertEquals(0, orangeList.get(0).compareTo(firstOrange));
    }

    /**
     * Testing for changing an element from an array by index
     */
    @Test
    void testSetArrayElementByIndex() {

        Orange firstOrange = new Orange(1, "russian", 70);
        Orange secondOrange = new Orange(2, "marocco", 100);

        orangeList.add(firstOrange);
        orangeList.add(secondOrange);

        Orange thirdOrange = new Orange(5, "serbian", 134);
        orangeList.set(1, thirdOrange);

        assertEquals(0, orangeList.get(1).compareTo(thirdOrange));
    }
}