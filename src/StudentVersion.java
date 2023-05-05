import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class StudentVersion {
    public static void main(String[] args) {
        boolean run = true;
        String choice;

        do {
            choice = displayMenu();
            if (choice.equals("x")){
                run = false;
            }
            else if (choice.equals("1")){
                double x = getNumber(1);
                double y = getNumber(2);
                double total = sumMethod(x,y);  // changed to double
                display(total);  // changed to "total"
                run = checkFinish();
            }
            else if (choice.equals("2")){
                double x = getNumber(1);
                double y = getNumber(2);
                double total = subtractMethod(x,y);
                display(total);
                run = checkFinish();
            }
            else if (choice.equals("3")){
                double x = getNumber(1);
                double y = getNumber(2);
                double total = multiplyMethod(x,y);  // changed to multiplyMethod
                display(total);
                run = checkFinish();
            }
            else if (choice.equals("4")){  // added if
                double x = getNumber(1);
                double y = getNumber(2);
                double total = divideMethod(x,y);
                display(total);
                run = checkFinish();
            }
            else {
                System.out.println("Entry not recognised, please try again...");
            }

        } while (run);
    }

    public static double getNumber(int count){
        while (true) {  // removed redundant boolean variable numberWrong
            if (count == 1) {
                System.out.print("Enter 1st number: ");
            } else {
                System.out.print("Enter 2nd number: ");  // changed to "print" instead of "println"
            }
            Scanner reader = new Scanner(System.in);
            try {
                return Double.parseDouble(reader.next());  // removed redundant usage of "x" and changed to Double.parseDouble(reader.next())
            } catch (Exception e){
                System.out.println("Number not recognised, please try again.");
            }
        }
        // removed unreachable statement:  return 0;
    }

    public static String displayMenu(){
        System.out.println(" Calculator Menu");
        System.out.println("1. Add numbers");
        System.out.println("2. Subtract numbers");
        System.out.println("3. Multiply numbers");
        System.out.println("4. Divide numbers");
        System.out.println("x. Exit program");
        System.out.println();
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter option (1,2,3,4,x): ");
        return reader.nextLine();
    }

    public static boolean checkFinish(){
        Scanner reader = new Scanner(System.in);
        // removed redundant variable "check": boolean check = true;
        System.out.print("Have you finished (y/n): ");
        String ans = reader.nextLine().trim().toLowerCase();
        return !ans.equals("y");  // simplified "if else" statement
    }

    public static double sumMethod(double n, double m){
        System.out.println("When adding the numbers");
        return (n + m);  // corrected from "*" to "+"
    }

    public static double subtractMethod(double n, double m){
        System.out.println("When subtracting the numbers");
        return (n - m);
    }

    public static double multiplyMethod(double n, double m){
        System.out.println("When multiplying the numbers");
        return (n * m);
    }

    public static double divideMethod(double n, double m){
        System.out.println("When dividing the numbers");
        return (n / m);  // removed redundant "double" casting
    }

    public static void display(double sum){
        System.out.println("The answer is: " + sum);  // added ;
    }

    @Test  // Make test method visible to JUnit and executable on demand
    public void testSumMethod() {
        // Test for two positive numbers
        assertEquals(15, sumMethod(8, 7), 0.001);
        // Test for two negative numbers
        assertEquals(-8, sumMethod(-5, -3), 0.001);
        // Test for a positive and a negative number
        assertEquals(-13, sumMethod(5, -18), 0.001);
        // Test for zero
        assertEquals(0, sumMethod(0, 0), 0.001);
    }
}
