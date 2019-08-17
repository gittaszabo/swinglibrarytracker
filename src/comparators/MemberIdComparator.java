/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparators;

import java.util.Comparator;
import model.Member;

/**
 *
 * @author Gitta Szabo
 */
public class MemberIdComparator implements Comparator<Member> {

    @Override
    public int compare(Member o1, Member o2) {
        return o1.getId() - o2.getId();
    }

}
