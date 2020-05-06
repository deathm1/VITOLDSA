//Digital Assignment DSA VITOL
//Author : Harsh Handoo
//RegNo  : 17BEC0217
//GitHub : death_m1
//Students of a Programming class arrive to submit assignments.
// Their register numbers are stored in a LIFO list in the order
// in which the assignments are submitted. Write a program using
// array to display the register number of the ten students who
// submitted first. Register number of the ten students who submitted
// first will be at the bottom of the LIFO list. Hence pop out the
// required number of elements from the top so as to retrieve and
// display the first 10 students.


import java.util.Scanner;

public class regnos {
    String[] digitalAssignmentSubmissions;

    public void parentArray(int i){
        //This function is going to generate the array
        //of all the students who submitted the assignment.
        Scanner sc = new Scanner(System.in);
        if(i>10){
            digitalAssignmentSubmissions = new String[i];
            System.out.println("Enter alpha numeric registration number of "+ i + " students : ");
            for (int x=0; x<digitalAssignmentSubmissions.length; x++){
                digitalAssignmentSubmissions[x] = sc.nextLine();
            }
        }
        else{
            System.out.println("This input doesn't satisfy program requirements.");
        }

    }


    public void pop10Students(){
        //This function is going to pop out students in "last in first out" manner.
        for (int i=digitalAssignmentSubmissions.length-1; i!=-1; i--){
            System.out.println("Student Assignment Token (" + i +") :" + digitalAssignmentSubmissions[i]);
        }
    }


    public static void main (String[] args){
        regnos myClass = new regnos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter at least 11 students : ");
        myClass.parentArray(sc.nextInt());
        myClass.pop10Students();
    }
}
