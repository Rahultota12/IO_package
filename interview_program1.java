import java.util.Scanner;
import java.io.*;

public class interview_program1 {

    public static void main(String[] args) {
        interview_program1 ip1 = new interview_program1();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER STRING ");
        String s = sc.nextLine();

        String a[] = s.split(" ");

        try {
            FileWriter file = new FileWriter("abc.txt");
            file.write(s);
            file.close();
        } catch (Exception e) {
             e.printStackTrace();
        }

        for (int i = 0; i < a.length; i++) {
            try {
                Integer.parseInt(a[i]); 
                System.out.println("Error: Please enter a string that does not contain integers");
                System.exit(0);
            } catch (NumberFormatException e) {
               
            }

            if (a[i].equalsIgnoreCase("RAHUL")) {
                try {
                    throw new Exception("  your name Rahul  exception  ");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            }
        }

        int temp = 1;
        for (int i = 0; i < a.length; i++) {
            temp = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].equals(a[j])) {
                    temp = temp + 1;

                    a[j] = "0";
                }
            }

            if (temp > 0 && a[i] != "0")
                System.out.println(a[i] + " => " + temp);
        }
    }

}
