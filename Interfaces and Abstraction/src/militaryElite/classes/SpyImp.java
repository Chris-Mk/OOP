package militaryElite.classes;

import militaryElite.interfaces.Spy;

public class SpyImp extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImp(Integer id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\r\nCode Number: " +  this.getCodeNumber();
    }
}
