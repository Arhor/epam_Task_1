/*
 * class: ColorComparator
 *
 * version: 1.0 18 Jul 2018
 *
 * author: Maxim Burishinets
 */

package by.epam.training.model.toy;

import java.util.Comparator;

public class ColorComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy one, Toy two) {
        return one.getColor().compareTo(two.getColor());
    }
}
