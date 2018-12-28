import java.util.*;
import java.io.IOException;
import java.io.FileWriter;

public class Task2 {

    public static void main2() throws IOException {

        ArrayList<Integer> Alpha = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i=0; i<150; i++) Alpha.add( rand.nextInt(200) + 1);

        System.out.println("Alpha:");
        System.out.println(Alpha);

        ArrayList<Integer> Beta = new ArrayList<Integer>();
        Beta = FillBeta(Alpha);

        System.out.println("Beta:");
        System.out.println(Beta);
        FileWriter f = new FileWriter("Beta.txt");
        for (Integer el : Beta) f.write(Integer.toString(el) + "\t");
        f.close();
        System.out.println("Alpha:");
        System.out.println(Alpha);

    }

    public static ArrayList<Integer> FillBeta(ArrayList<Integer> list){
        ArrayList temp = (ArrayList) list.clone();
        Collections.sort(temp, Collections.reverseOrder());
        temp.subList(15, list.size()).clear();
        return  temp;
    }

}