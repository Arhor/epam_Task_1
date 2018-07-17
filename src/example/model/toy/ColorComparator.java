package example.model.toy;

import java.util.Comparator;

public class ColorComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy one, Toy two) {
        return one.getColor().compareTo(two.getColor());
    }
}
