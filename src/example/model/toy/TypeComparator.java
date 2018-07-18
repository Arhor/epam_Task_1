/*
 * class: TypeComparator
 *
 * version: 1.0 18 Jul 2018
 *
 * author: Maxim Burishinets
 */

package example.model.toy;

import java.util.Comparator;

public class TypeComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy one, Toy two) {
        return one.getType().compareTo(two.getType());
    }
}
