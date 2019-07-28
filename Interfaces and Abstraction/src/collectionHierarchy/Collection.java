package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private static final int MAX_SIZE = 100;
    private List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(MAX_SIZE);
    }

    protected List<String> getItems() {
        return this.items;
    }
}
