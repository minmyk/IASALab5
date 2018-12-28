import java.util.*;
import java.lang.Comparable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static abstract class Worker implements Comparable<Worker> {
        private String Name;
        private long id;
        protected double AverageSalary;

        public Worker(String _Name,long _id)
        {
            Name=_Name;
            id=_id;
        }
        public Worker()
        {
            Name="";
            id=0;
        }

        public abstract double GetMonthSalary();

        @Override
        public int compareTo(Worker w) {
            if(GetMonthSalary()<w.GetMonthSalary())
                return 1;
            if(GetMonthSalary()>w.GetMonthSalary())
                return -1;
            else
            {
                return String.CASE_INSENSITIVE_ORDER.compare(Name,w.Name);
            }
        }
    }

    public static class HourSalaryWorker extends Worker {
        private double HourSalary;

        @Override
        public double GetMonthSalary() {
            AverageSalary = 20.8 * 8 * HourSalary;
            return 20.8 * 8 * HourSalary;
        }

        public HourSalaryWorker(String _Name, long _id, double _HourSalary)
        {
            super(_Name, _id);
            HourSalary = _HourSalary;
            GetMonthSalary();
        }

        @Override
        public String toString()
        {
            return "Name: "+super.Name+"\nWorker: Hour Salary Worker\nid: "
            +super.id+"\nAverage Salary: "+super.AverageSalary+"\n";
        }
    }
    public static class FixedSalaryWorker extends Worker {

        private double FixedSalary;

        @Override
        public double GetMonthSalary(){
            AverageSalary=FixedSalary;
            return AverageSalary;
        }

        public FixedSalaryWorker(String _Name, long _id, double _FixedSalary) {
            super(_Name, _id);
            FixedSalary=_FixedSalary;
            GetMonthSalary();
        }
        @Override
        public String toString()
        {
            return "Name: "+super.Name+"\nWorker: Fixed Salary Worker\nid :"
                    +super.id+"\nAverage Salary: "+super.AverageSalary+"\n";
        }
    }


    public static void toFile(ArrayList<Worker> workers, String s) throws IOException{
        FileWriter f = new FileWriter(s);
        for (Worker worker: workers) f.write(worker.toString()+"\n\n");
        f.close();
    }

    public static String extract(String categ, String separate, Scanner s)
    {
        String[] NextLine = s.nextLine().split(separate);
        if (!NextLine[0].replaceAll("\\s+","").equals(categ)) throw new IllegalArgumentException();
        return NextLine[1].replaceAll("\\s+","");
    }

    public static ArrayList<Worker> InitializeWorkersFromFile(String Filename) throws IOException
    {
        File f = new File(Filename);
        Scanner s = new Scanner(f);
        ArrayList<Worker> WorkersList = new ArrayList<>();
        while (s.hasNextLine()) {
            if (!s.nextLine().equals("Worker:")) throw new IllegalArgumentException();
            String name = extract("Name", ":", s);
            long id = Long.parseLong(extract("id", ":", s));
            String type = extract("Type", ":", s);

            if (type.equals("FixedSalary")) {
                double fixed = Double.parseDouble(extract("Salary", ":", s));
                FixedSalaryWorker worker = new FixedSalaryWorker(name, id, fixed);
                WorkersList.add(worker);
            } else if (type.equals("HourSalary")) {
                double hour = Double.parseDouble(extract("Salary", ":", s));
                Worker worker = new HourSalaryWorker(name, id, hour);
                WorkersList.add(worker);
            } else throw new IllegalArgumentException("Wrong file format");
        }
        return WorkersList;
    }

    public static void main(String[] args){
        ArrayList<Worker> Workers = new ArrayList<Worker>();
        try {
            Workers = InitializeWorkersFromFile("Workers.txt");
        } catch (IOException e) {}

        Collections.sort(Workers);

        System.out.println("Workers: \n");
        for (int i = 0; i < Workers.size(); i++) System.out.println(Workers.get(i).toString());

        try {
            toFile(Workers, "WorkersSorted.txt");
        } catch (IOException e) {}

        System.out.println("First 5 names of workers:");
        for (int i = 0; i < 5; i++) System.out.println(Workers.get(i).Name);

        System.out.println("\n" + "Last 3 ids of workers:");
        for (int i = Workers.size() - 3; i < Workers.size(); i++)
            System.out.println(Long.toString(Workers.get(i).id));
    }
}