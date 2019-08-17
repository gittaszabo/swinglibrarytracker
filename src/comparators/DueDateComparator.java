/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import java.util.Comparator;

/**
 *
 * @author Gitta Szabo
 */
public class DueDateComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.isEmpty()) {
            o1 = "99-99-9999";
        }
        if (o2.isEmpty()) {
            o2 = "99-99-9999";
        }

        String o1Normalized = o1.substring(6) + o1.substring(3, 5) + o1.substring(0, 2);
        String o2Normalized = o2.substring(6) + o2.substring(3, 5) + o2.substring(0, 2);

        return o1Normalized.compareTo(o2Normalized);
    }
}
