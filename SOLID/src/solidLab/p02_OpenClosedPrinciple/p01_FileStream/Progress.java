package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Progress {

    public static int getCurrentPercent(BaseClass baseClass) {
        return baseClass.getSent() * 100 / baseClass.getLength();
    }
}
