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
public class Student {
     final static Scanner kb = new Scanner(System.in);
   public static int ageValid;  
   public static boolean StudentAge_StudentAgeInvalidCharacter(String temp){
       boolean flag=false;
            //checks to see if program will crash
        try{//will do actions if no crash in program occurs 
            ageValid=Integer.parseInt(temp);        
            return true;
        }catch(Exception E){//will do actions if a crash in program occurs 
            System.out.println("You have entered a incorrect age!!!"+    
                               "Please re-enter the student age >> ");
            return false;
        }
   }
     
    public static boolean StudentAge_StudentAgeValidation(){                                                              
             if (ageValid>=16) {   //appropriate age validation(16+)  
                 return true;
             }else{
               System.out.println("You have entered a incorrect age!!!"+    
                               "Please re-enter the student age >> ");
               return false; 
             }
   }
     public static int SaveStudent(int[] id,String[] name,int[] age,String[] email,String[] course,int studAmt){
         boolean saved = false;
        for (int i = 0; i < studAmt; i++) {
            if (id[i]==0) {  //checks if element is already stored
                                System.out.println("Enter the student id: ");
                                id[i]=kb.nextInt();
                                System.out.println("Enter the student name: ");          //input of arrays
                                name[i]=kb.next();
                                System.out.println("Enter student age");
                                
                                String numCheck;
                                boolean isNum=false;
                                boolean ageRange=false;
                                boolean ageFinal=false;
                                
                                numCheck = kb.next();
                                while(ageFinal==false){       
                                 isNum=Student.StudentAge_StudentAgeInvalidCharacter(numCheck);  
                                    if (isNum==false) {
                                        numCheck = kb.next();
                                    } else {
                                    if(StudentAge_StudentAgeValidation()==false){   //age validations
                                        isNum=false;
                                        numCheck = kb.next();
                                    }else{
                                    age[i]=Student.ageValid;
                                    ageFinal=true;
                                       }
                                    }
                                }
                                System.out.println("Enter the student email: ");
                                email[i]=kb.next();
                                System.out.println("Enter the student course: ");
                                course[i]=kb.next();
                                System.out.println("All student information has been saved successfully");
                                saved = true;
             }
        }
        return id[studAmt-1];
    }
    
    public static boolean SearchStudent(int[] id,String[] name,int[] age,String[] email,String[] course,int studAmt,int si){
       
        boolean flag=false;
        int index=0;
        System.out.println("-----------------------------------------");
       
        for (int i = 0; i < studAmt; i++) {
            if (si==id[i]) {//identifies student id
                index=i;
                flag=true;
            }
        }
            if (flag==true) {
               System.out.println("STUDENT ID: "+id[index]+
                                 "\nSTUDENT NAME: "+name[index]+
                                 "STUDENT AGE: "+age[index]+            //displays student id
                                 "\nSTUDENT EMAIL:"+email[index]+
                                 "\nSTUDENT COURSE: "+course[index]); 
            }else{
                System.out.println("Student with student id "+si+" was not found!");  //displays msg to notify user of unknown id
            }
        System.out.println("-----------------------------------------");
        return flag;
    }
    
    public static String deleteVertification(int di){   //gets vertification for deletion of student
      System.out.println("Are you sure you want to remove "+di+" from the system?Enter (y) to continue");  
      String vert=kb.next();
      return vert;
    }
    
    public static int DeleteStudent(int[] id,String[] name,int[] age,String[] email,String[] course,int studAmt,int di,String vert){
      
      boolean flag=false;
      int deleteIndex=0;
      int newStudAmt = 0;
      String vertification ="";
      //System.out.println("Enter the student id to delete: ");//requests for student id to search
      //di=kb.nextInt(); 
      
     for (int i = 0; i < studAmt; i++) {
            //get index of array element
            if (id[i]==di) {
                deleteIndex=i;
                flag=true;
            }
        }
        if (flag==false) {
            System.out.println("Student with student id "+id[deleteIndex]+" was not found!");
        } else {
            //vertify decision by user
            vertification=vert;
            if (vertification.equals("y")) {
            //loop from index to end of array
            for (int i = deleteIndex; i < studAmt-1; i++) {
                id[i]=id[i+1];
                name[i]=name[i+1];
                age[i]=age[i+1]-1;
                email[i]=email[i+1];
                course[i]=course[i+1];    //overwrites elements from the position of deleteIndex
            }
            id[studAmt-1]=0;
            name[studAmt-1]="";
            age[studAmt-1]=0;
            email[studAmt-1]="";
            course[studAmt-1]="";    //initalising last element of arrays
            //decrement array size
            studAmt--;
            System.out.println("Student "+di+" was deleted.");
           
        }else{
                System.out.println("Student "+di+" was not deleted.");
            }
      } 
        return studAmt;
    }
    
    public static void StudentReport(int[] id,String[] name,int[] age,String[] email,String[] course,int studAmt){
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < studAmt; i++) {
            int studIndex=i+1;
            System.out.println("STUDENT "+(studIndex) +"\n-----------------------------------------------------------------");
            System.out.println("STUDENT ID: "+id[i]+
                               "\nSTUDENT NAME: "+name[i]+
                               "\nSTUDENT AGE: "+age[i]+            //displays student id
                               "\nSTUDENT EMAIL:"+email[i]+
                               "\nSTUDENT COURSE: "+course[i]);
            System.out.println("-----------------------------------------------------------------");
        }
    }
    
    public static void ExitStudentApplication(){
        System.out.println("Exiting application...");
         System.exit(0);
    }
}
