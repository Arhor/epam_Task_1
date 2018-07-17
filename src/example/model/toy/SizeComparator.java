package example.model.toy;

import java.util.Comparator;

public class SizeComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy one, Toy two) {
        return one.getSize().compareTo(two.getSize());
    }
}
