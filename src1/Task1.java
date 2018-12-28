
import java.util.*;

public class Task1   {

    public static void main1() {

        int n;
        Scanner S=new Scanner(System.in);
        n=S.nextInt();

        System.out.println("Linked list:");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        getTime(n, linkedList);

        System.out.println("Array list:");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        getTime(n, arrayList);

        System.out.println("Tree set:");
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        getTime(n, treeSet);

        System.out.println("Hash set:");
        HashSet<Iterator> hashSet = new HashSet<Iterator>();
        getTime(n, hashSet);

    }

    public static <MyList extends AbstractCollection> void getTime(int Len, MyList List) {

        long begin = System.nanoTime();
        for (int i = 0; i < Len; i++) List.add(i);
        long end = System.nanoTime();
        System.out.println("Adding elements time is: " + ((end - begin)) + "ns");

        begin = System.nanoTime();
        Random rand = new Random();
        int n = rand.nextInt(Len);
        Iterator<Integer> iterator = List.iterator();
        while (iterator.hasNext()) {
            Integer node = iterator.next();
            if (node == n) break;
        }
        end = System.nanoTime();
        System.out.println("Finding element time is: " + ((end - begin)) + "ns");

        begin = System.nanoTime();
        List.remove(rand.nextInt(Len));
        end = System.nanoTime();
        System.out.println("Deleting element time is: " + ((end - begin)) + "ns");

    }
}
