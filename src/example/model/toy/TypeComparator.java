package example.model.toy;

import java.util.Comparator;

public class TypeComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy one, Toy two) {
        return one.getType().compareTo(two.getType());
    }
}
