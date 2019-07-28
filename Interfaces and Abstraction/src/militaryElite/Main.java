package militaryElite;

import militaryElite.classes.*;
import militaryElite.enumerators.Corps;
import militaryElite.enumerators.State;
import militaryElite.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Private> privates = new ArrayList<>();
        String input;

        while (!"End".equals(input = scan.nextLine())) {
            String[] data = input.split("\\s+");

            switch (data[0]) {
                case "Private":
                    Private privateImp = new PrivateImpl(Integer.parseInt(data[1]), data[2], data[3], Double.parseDouble(data[4]));
                    privates.add(privateImp);
                    System.out.println(privateImp.toString());
                    break;
                case "LeutenantGeneral":
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(Integer.parseInt(data[1]),
                            data[2],
                            data[3],
                            Double.parseDouble(data[4]));

                    for (int i = 5; i < data.length; i++) {
                        for (Private priv : privates) {
                            if (priv.getId() == Integer.parseInt(data[i])) {
                                lieutenantGeneral.addPrivate(priv);
                                break;
                            }
                        }
                    }
                    System.out.println(lieutenantGeneral.toString());
                    break;
                case "Engineer":
                    if (validateCorp(data[5])) {
                        if (data[5].equals("Airforces")) {
                            data[5] = "Air_forces";
                        }

                        Engineer engineer = new EngineerImpl(Integer.parseInt(data[1]),
                                data[2],
                                data[3],
                                Double.parseDouble(data[4]),
                                Corps.valueOf(data[5].toUpperCase()));

                        for (int i = 6; i < data.length - 1; i += 2) {
                            Repair repair = new Repair(data[i], Integer.parseInt(data[i + 1]));
                            engineer.addRepair(repair);
                        }
                        System.out.println(engineer.toString());
                    }
                    break;
                case "Commando":
                    if (validateCorp(data[5])) {
                        if (data[5].equals("Airforces")) {
                            data[5] = "Air_forces";
                        }

                        Commando commando = new CommandoImpl(Integer.parseInt(data[1]),
                                data[2],
                                data[3],
                                Double.parseDouble(data[4]),
                                Corps.valueOf(data[5].toUpperCase()));

                        for (int i = 6; i < data.length - 1; i += 2) {
                            if (validateMission(data[i + 1])) {
                                if (data[i + 1].equals("inProgress")) {
                                    data[i + 1] = "in_progress";
                                }

                                Mission mission = new Mission(data[i], State.valueOf(data[i + 1].toUpperCase()));
                                commando.addMission(mission);
                            }
                        }
                        System.out.println(commando.toString());
                    }
                    break;
                case "Spy":
                    Spy spy = new SpyImp(Integer.parseInt(data[1]), data[2], data[3], data[4]);
                    System.out.println(spy.toString());
                    break;
            }
        }
    }

    private static boolean validateMission(String mission) {
        boolean isValid = false;
        for (State value : State.values()) {
            if (value.name().replaceAll("_", "").equalsIgnoreCase(mission)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private static boolean validateCorp(String corp) {
        boolean isValid = false;
        for (Corps value : Corps.values()) {
            if (value.name().replaceAll("_", "").equalsIgnoreCase(corp)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}
