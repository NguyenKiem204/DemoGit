
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NguyenGiap
 */
public class Main {

    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(System.in);
//        ManageStudent list = new ManageStudent();
        Student newStd = new Student() {
        };
        Student newStd1 = new Student() {
        };
        int input = 0;
        DBContext db = new DBContext();
        
        while(input !=6){

            System.out.println("-----------------------");
            System.out.println("---- Menu ----.");
            System.out.println("1.See detail of Student.");
            System.out.println("2.Add Student.");
            System.out.println("3.Fix information of Student.");
            System.out.println("4.Deleted Student.");
            System.out.println("5.Research information of Student.");
            System.out.println("6.Exit menu.");
            System.out.println("Choose your selection: ");
            System.out.println("-----------------------");
            input = sc.nextInt();
            
            if(input <=0 || input >=7){
                System.out.println("Wrong input! Try again");
            }else{
                switch(input)
                {
                    case 1: 
                       System.out.println("----------------------------");
                        System.out.println("Show information of Student:");
                        System.out.println("----------------------------");
                    {
                        try {
                            db.displayAllStudent();
                        } catch (FileNotFoundException | ClassNotFoundException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                        break;





                    case 2:
                        System.out.print("Enter the number of students want to add:");
                        int n = sc.nextInt();
                        for (int i = 0; i < n; i++) {
                        System.out.print("Student number " + (i + 1) + ": ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        newStd.setName(name);
                        System.out.print("Student ID " + newStd.getName()+ ": ");
                        String id = sc.next();
                        newStd.setId(id);
                        db.insert(newStd);
                        }            
                        System.out.println("Build success");
                        
                        ;break;
                    case 3: 
                        
                        System.out.print("Enter the number of students want to fix: ");
                        int n1 = sc.nextInt();
                        
                        for (int i = 0; i < n1; i++) {
                        System.out.print("Find ID of student you want to update: ");
                        String idToUpdate = sc.next();
                        db.deleteContent(idToUpdate);
                        System.out.print("Enter new name: ");
                        String newName = sc.next();
                        newStd1.setName(newName);
                        System.out.print("Enter new ID: ");
                        String newId = sc.next();
                        newStd1.setId(newId);
                        db.updateStudent(idToUpdate, newName, newId);
                        db.insert(newStd1);
                        
                        }            
                        System.out.println("Build success");
                        break;
                    case 4: 
                        
                         
                        System.out.print("Enter the number of students want to add:");
                        n = sc.nextInt();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Enter ID of student you want to delete: "); 
                            String keyId = sc.next();
                            db.deleteContent(keyId);
                            System.out.println("Dellet success!!!");
                        }
                        break;

                    case 5:
                        db.printStudentList();
                        break;
                    case 6: break;
                
                }
            } 
        }
        System.out.println("End of Menu! Thanks for use");
         
    }

    
}
