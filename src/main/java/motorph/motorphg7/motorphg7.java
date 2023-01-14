/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package motorph.motorphg7;

import java.io.BufferedReader;
import java .io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class motorphg7 {
   
    public static void authentication (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] UserCredentials = {{"2000", "L1z3tt3SAKALAM"}, {"3000", "M@rv1nSAKALAM"}, {"4000", "J3zr31SAKALAM"}};
        System.out.println("Enter Employee ID:");
        String user_id = sc.nextLine();
        System.out.println("Enter Passphrase:");
        String passphrase = sc.nextLine();
    
        boolean authenticated = false;
        for (String[] pair : UserCredentials) {
            if (user_id.equals(pair[0]) && passphrase.equals(pair[1])) {
            authenticated = true;
            break;
            }
        }
        if (authenticated) {
            System.out.println("Authentication successful!");
            switch (user_id) {
                case "2000" -> hr_portal();
                case "3000" -> admin_portal();
                case "4000" -> employee_portal();
                    default -> {
                    }
            }
        } 
        else {
      System.out.println("Authentication failed.");
        }
    }
 
    public static void hr_portal() {
        System.out.println("Welcome Lizette to Human Resource Portal!");
        System.out.println("Select HR function you wanted proceed");
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] Employee Search");
        System.out.println("[2] Work Hours Calculator");
        String hr_function = sc.nextLine();
        switch (hr_function) {
            case "1" -> employee_search();
            case "2" -> workhours_calculator();
            default -> {
                System.out.println("Please select a correct HR function.");
                hr_portal();
            }
        }
    }

    public static void admin_portal() {
        System.out.println("Welcome Marvin to Administration Portal!");
    }
  
    public static void employee_portal() {
        System.out.println("Welcome Jezrei to Employee Portal");
    }

    public static void employee_search() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader("employeedetails.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] einfo = line.split(",");
                if (einfo[0].equals(id)) {
                    System.out.println("EID: " + id);
                    System.out.println("Complete Name: " + einfo[1] + " " + einfo[2]);
                    System.out.println("Birthdate: " + einfo[3]);
                    System.out.println("Address: " + einfo[4]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            }
   }
   
    /* Please insert workhours calculation code here. */
    
    public static void workhours_calculator() {
        
        System.out.println("Please enter the work hours per day.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Sunday:");
        int sun = sc.nextInt();
        System.out.println("Monday:");
        int mon = sc.nextInt();
        System.out.println("Tuesday:");
        int tue = sc.nextInt();
        System.out.println("Wednesday:");
        int wed = sc.nextInt();
        System.out.println("Thursday:");
        int thu = sc.nextInt();
        System.out.println("Friday:");
        int fri = sc.nextInt();
        System.out.println("Saturday:");
        int sat = sc.nextInt();
        int work_hours = sun + mon + tue + wed + thu + fri + sat;
        System.out.println("The total working hours this week is:" +work_hours);
    
    }
  
    public static void exit() {
        System.out.println("Thank your for using MotorPH HRIS!");
    }
 
}
