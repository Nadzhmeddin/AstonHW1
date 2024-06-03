package homework.ModelComporator;


import homework.model.Orange;

import java.util.Comparator;

/**
 * A comparator that compares oranges based on sort
 */
public class OrangeSortComparator implements Comparator<Orange> {

    @Override
    public int compare(Orange o1, Orange o2) {
        return o1.getSort().compareTo(o2.getSort());
    }
}
