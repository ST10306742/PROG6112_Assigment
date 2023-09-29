/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog_questionone;

import java.util.Scanner;

/**
 *
 * @author shail
 */
public class PROG_QuestionOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      // Question 1 PROG6112 Assignment
        int ArrayIndex=0;//current student amount
        Scanner kb = new Scanner(System.in);
        Student st = new Student();
        //1.1
        System.out.println("STUDENT MANAGEMENT APPLICATION"+
                        "\n***************************************");
        boolean exitMenu=false;
        //Arrays
        String[]names=new String[ArrayIndex];
        int[]ID=new int[ArrayIndex];
        int[]age=new int[ArrayIndex];
        String[]email=new String[ArrayIndex];
        String[]course=new String[ArrayIndex];
        while(exitMenu==false){
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String menuLauncher=kb.next();
            if (menuLauncher.equals("1")) {
                launchMenu();
                int menuOption=kb.nextInt();
                
                switch(menuOption){
                    case 1:
                        //TempArrays to store current values before resizing main array
                         String[]tempNames=new String[ArrayIndex];
                        int[]tempID=new int[ArrayIndex];
                        int[]tempAge=new int[ArrayIndex];
                        String[]tempEmail=new String[ArrayIndex];
                        String[]tempCourse=new String[ArrayIndex];
                        for (int i = 0; i < ArrayIndex; i++) {  //loop for resizing array to add more students
                          tempNames[i]=names[i];
                          tempID[i]=ID[i];
                          tempAge[i]=age[i];
                          tempEmail[i]=email[i];
                          tempCourse[i]=course[i];  
                        }
                          ArrayIndex++;
                          names=new String[ArrayIndex];
                          ID=new int[ArrayIndex];
                          age=new int[ArrayIndex];      //initialising array to new size
                          email=new String[ArrayIndex];
                          course=new String[ArrayIndex];
                          for (int i = 0; i < tempNames.length; i++) {
                          names[i]=tempNames[i];
                          ID[i]=tempID[i];
                          age[i]=tempAge[i];        //storing new array with new size so no data is lost
                          email[i]=tempEmail[i];
                          course[i]=tempCourse[i];
                          }
                        
                        //add new students:
                        Student.SaveStudent(ID, names, age, email, course, ArrayIndex);
                       
                    break;
                    case 2:System.out.println("Enter the student id to search: ");//requests for student id to search
                        int searchInput=kb.nextInt();
                        Student.SearchStudent(ID, names, age, email, course, ArrayIndex,searchInput);
                    break;
                    case 3:
                        System.out.println("Enter the student id to Delete: ");//requests for student id to search
                        int deleteInput=kb.nextInt();
                        Student.SearchStudent(ID, names, age, email, course, ArrayIndex,deleteInput);
                        String vert=Student.deleteVertification(deleteInput);
                        Student.DeleteStudent(ID, names, age, email, course, ArrayIndex,deleteInput,vert);
                        ArrayIndex--;//decrements studAmt after deletion
                    break;
                    case 4:
                        Student.StudentReport(ID, names, age, email, course, ArrayIndex);
                    break;
                    case 5:
                        Student.ExitStudentApplication();
                    break;
                    default:
                        System.out.println("Invalid input,make sure to select one of the options given.");
                    break;
                 }
                
            } else {
                Student.ExitStudentApplication();
            }
        }
    }
    public static void launchMenu(){
    System.out.println("Please Select one of the following items:"+
                                   "\n(1)Capture a new student.\n(2)Search for a student."+
                                   "\n(3)Delete a student.\n(4)Print student report."+
                                   "\n(5)Exit Application.");
}
    
}
