package util;

import java.util.Scanner;

public class InputUtil {
    public static String inputRequiredString(String title){
        Scanner input=new Scanner(System.in);
        System.out.print(title);
        return input.nextLine();
    }
    public static Integer inputRequiredInteger(String title){
        Scanner input=new Scanner(System.in);
        System.out.print(title);
        return input.nextInt();

    }
    public static Double inputRequiredDouble(String title){
        Scanner input=new Scanner(System.in);
        System.out.print(title);
        return input.nextDouble();}
}
