package militaryElite.classes;

import militaryElite.interfaces.LieutenantGeneral;
import militaryElite.interfaces.Private;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(Integer id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

//    @Override
//    public List<Private> getPrivates() {
//        return this.privates;
//    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());
        this.privates.stream()
                .sorted((e1, e2) -> Integer.compare(e2.getId(), e1.getId()))
                .forEach(e -> builder.append("  ").append(e.toString()).append(System.lineSeparator()));
        return builder.toString().trim();
    }
}
