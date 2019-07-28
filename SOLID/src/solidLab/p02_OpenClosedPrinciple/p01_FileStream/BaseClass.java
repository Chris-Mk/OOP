package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public abstract class BaseClass {
    private int length;
    private int sent;

    protected BaseClass(int length, int sent) {
        this.length = length;
        this.sent = sent;
    }

    public final int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public final int getSent() {
        return this.sent;
    }

    public void setSent(int sent) {
        this.sent = sent;
    }
}
