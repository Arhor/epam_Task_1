/*
 * class: PriceComparator
 *
 * version: 1.0 18 Jul 2018
 *
 * author: Maxim Burishinets
 */

package by.epam.training.model.toy.comparsion;

import by.epam.training.model.toy.Toy;

import java.util.Comparator;

public class PriceComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy one, Toy two) {
        return Double.compare(one.getPrice(), two.getPrice());
    }
}
