package homework.sort;

import homework.model.MyArrayModel;
import homework.model.Orange;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    MyArrayModel<Orange> orangeList = new MyArrayModel<>(10);

    /**
     * Testing a sorted array with comparator
     */
    @Test
    void testSortingArrayWithComparator() {
        Orange firstOrange = new Orange(1, "russian", 100);
        Orange secondOrange = new Orange(5, "serbian", 130);
        Orange thirdOrange = new Orange(3, "african", 90);
        Orange fourthOrange = new Orange(2, "turkey", 160);

        orangeList.add(firstOrange);
        orangeList.add(secondOrange);
        orangeList.add(thirdOrange);
        orangeList.add(fourthOrange);

        QuickSort.sort(orangeList, Comparator.comparing(Orange::getWeight));
        assertEquals(thirdOrange, orangeList.get(0));


    }

    /**
     * Testing a sorted array with comparable
     */
    @Test
    void testSortingArrayWithComparable() {

        Orange firstOrange = new Orange(5, "russian", 100);
        Orange secondOrange = new Orange(5, "serbian", 130);
        Orange thirdOrange = new Orange(3, "african", 90);
        Orange fourthOrange = new Orange(1, "turkey", 160);

        orangeList.add(firstOrange);
        orangeList.add(secondOrange);
        orangeList.add(thirdOrange);
        orangeList.add(fourthOrange);

        QuickSort.sort(orangeList);

        assertEquals(orangeList.get(0),fourthOrange);
    }
}