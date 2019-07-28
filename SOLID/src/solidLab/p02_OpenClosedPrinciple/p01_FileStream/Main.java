package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Main {
    public static void main(String[] args) {

        BaseClass file = new File(1, 5, "file");
        BaseClass music = new Music(21, 10, "mj", "wak");

        System.out.println(Progress.getCurrentPercent(file));
        System.out.println(Progress.getCurrentPercent(music));
    }
}

