package solidLab.p05_DependencyInversion.p01_HelloWord;

import solidLab.p05_DependencyInversion.p02_Worker.Manager;
import solidLab.p05_DependencyInversion.p02_Worker.Worker;

public class Main {
    public static void main(String[] args) {
        new Manager(new Worker());
    }
}
