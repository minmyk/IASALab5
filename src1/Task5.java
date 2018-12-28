import java.io.*;
import java.util.*;

public class Task5{
    public static ArrayList<String> extract(String s) throws IOException
    {
        File f = new File(s);
        ArrayList<String> text = new ArrayList<>();
        FileReader fr = new FileReader(f);
        BufferedReader b = new BufferedReader(fr);
        String line = b.readLine();
        while ((line!=null)) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) text.add(words[i]);
            line = b.readLine();
        }
        return text;
    }
    public static void main5() {

        ArrayList<String> eng = new ArrayList<>();
        ArrayList<String> ukr = new ArrayList<>();
        ArrayList<String> rus = new ArrayList<>();
        try{
            ukr = extract("ukr.txt");
            eng = extract("eng.txt");
            rus = extract("rus.txt");
        } catch (IOException e){}

        Collections.sort(eng, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(rus, String.CASE_INSENSITIVE_ORDER);
        Collections.sort(ukr, String.CASE_INSENSITIVE_ORDER);
        int count=0;
        System.out.println("\n English:   ");
        for (String i : eng) {
            if(count%10==0) System.out.println(i + " ");
            else System.out.print(i + " ");
            count++;
        }
        count=0;
        System.out.println("\n Russian:    ");
        for (String i : rus) {
            if(count%10==0) System.out.println(i + " ");
            else System.out.print(i + " ");
            count++;
        }
        count=0;
        System.out.println("\n Ukrainian:  ");
        for (String i : ukr) {
            if(count%10==0) System.out.println(i + " ");
            else System.out.print(i + " ");
            count++;
        }
    }
}