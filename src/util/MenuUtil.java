package util;

import static util.InputUtil.inputRequiredInteger;

public class MenuUtil {
    public static int entryApp() {
        System.out.println("\n----------| Gym Management System |----------");
        System.out.println("0. exit");
        System.out.println("1. Register gym member");
        System.out.println("2. Show all members");
        System.out.println("3. Enter the gym");
        System.out.println("4. Update departures");
        return inputRequiredInteger("Choose option: ");
    }
}
