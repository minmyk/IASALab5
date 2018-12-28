import java.util.Scanner;

public class Task6 {

    public static void main6(){
        String normal, reverse="";
        System.out.println("Input a string:");
        Scanner s = new Scanner(System.in);
        normal = s.nextLine();
        for (int i = normal.length()-1; i>=0; i--) reverse += normal.charAt(i);
        System.out.println("Reverse: \n" + reverse);
    }
}