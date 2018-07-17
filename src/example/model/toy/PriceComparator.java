package example.model.toy;

import java.util.Comparator;

public class PriceComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy one, Toy two) {
        return (int)(one.getPrice() - two.getPrice());
    }
}
