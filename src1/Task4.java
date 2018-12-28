import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static int n=0,l=0,r=100;

        public static void main4() {
            Random random=new Random();
            n = random.nextInt(r)+l;
            Scanner s =new Scanner(System.in);
            String guess;
            boolean t=true;
            while(t) {
                System.out.println("Try to guess the number in range:  [" + l + "," + r + "]");
                boolean check =true;
                while(check) {
                    try{
                        guess = s.nextLine();
                        if(Integer.parseInt(guess)<=r && Integer.parseInt(guess)>=l) {

                            if (Integer.parseInt(guess) == n) {
                                System.out.println("You won!");
                                t=false;
                                break;
                            }
                            if (Integer.parseInt(guess) < n) {
                                l = Integer.parseInt(guess);
                                System.out.println("Wrong! Try in range [" + l + "," + r + "]");
                            } else {
                                r = Integer.parseInt(guess);
                                System.out.println("Wrong! Try in range [" + l + "," + r + "]");
                            }
                            check = false;
                        }
                        else System.out.println("Your number is in range  [" + l + "," + r + "]");
                    }catch (NumberFormatException ex) {
                        System.out.println("Please input your guess as an integer");
                    }
                }
            }
        }
    }
