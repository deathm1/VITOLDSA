import java.util.Arrays;
import java.util.Scanner;

//Digital Assignment DSA VITOL
//Author : Harsh Handoo
//RegNo  : 17BEC0217
//GitHub : death_m1
//Write a program to implement a 3-stacks of size ‘m’ in an array
//of size ‘n’ with all the basic operations such as IsEmpty(i),
//Push(i), Pop(i), IsFull(i) where ‘i’ denotes the stack number
//(1,2,3), m n/3. Stacks are not overlapping each other. Leftmost
//stack facing the left direction and other two stacks are facing in
//the right direction.
//https://github.com/deathm1/VITOLDSA/blob/master/threeStacksInOneStack.java

public class tstos {

    int[] parentStack;
    int tempVar1=0;
    int tempVar2=0;
    int tempVar3=0;
    int tempVar1p=0;
    int tempVar2p=0;
    int tempVar3p=0;


    public void incrementParentStack(int i){
        Scanner sc = new Scanner(System.in);
        int sizeOfChildren = i/3;
        int starIndex=0;
        parentStack = new int[i];
        System.out.println("Enter Values in Stack 1");
        for(int x=starIndex; x<sizeOfChildren; x++){
            parentStack[starIndex] = sc.nextInt();
            starIndex++;
        }
        int newEnd1 = sizeOfChildren+starIndex;
        System.out.println("Enter Values in Stack 2");
        for(int x=starIndex; x<newEnd1; x++){
            parentStack[starIndex] = sc.nextInt();
            starIndex++;
        }
        int newEnd2 = sizeOfChildren+starIndex;
        System.out.println("Enter Values in Stack 3");
        for(int x=starIndex; x<newEnd2; x++){
            parentStack[starIndex] = sc.nextInt();
            starIndex++;
        }
        System.out.println("This is parent Stack");
        System.out.println(Arrays.toString(parentStack));
    }
    public void popOperation(int i){
        System.out.println("Initial Parent");
        parentUpdate();
        int sizeOfChildren = parentStack.length/3;
        int endIndex = sizeOfChildren-1;
        if(i!=1){
            endIndex = sizeOfChildren*i-1;
        }
        if(i==1){
            int popIndex = endIndex - tempVar1;
            if (popIndex==-1){
                System.out.println("Stack 1 is Empty");
            }
            else {
                parentStack[popIndex] = 0;
                tempVar1 = tempVar1 +1;
            }
        }

        else if(i==2){
            int popIndex = endIndex - tempVar2;
            if (popIndex<sizeOfChildren*i-sizeOfChildren){
                System.out.println("Stack 2 is Empty");
            }
            else {
                parentStack[popIndex] = 0;
                tempVar2 = tempVar2 +1;
            }
        }
        else if(i==3){
            int popIndex = endIndex - tempVar3;
            if (popIndex<sizeOfChildren*i-sizeOfChildren){
                System.out.println("Stack 3 is Empty");
            }
            else {
                parentStack[popIndex] = 0;
                tempVar3 = tempVar3 +1;
            }
        }

        System.out.println("Final Parent");
        parentUpdate();
    }
    public void pushOperation(int i){
        System.out.println("Initial Parent");
        parentUpdate();
        int sizeOfChildren = parentStack.length/3;
        int startIndex = 0;
        if(i!=1){
            startIndex = sizeOfChildren*i-sizeOfChildren;
        }
        Scanner sc = new Scanner(System.in);

        if(i==1){
            startIndex = startIndex + tempVar1p;
            if(startIndex>sizeOfChildren-1){
                System.out.println("No Space in current Stack");
            }
            else{
                System.out.println("Enter new Element (Stack 1): ");
                parentStack[startIndex] = sc.nextInt();
                tempVar1p = tempVar1p +1;
            }
        }
        else if(i==2){
            startIndex = startIndex + tempVar2p;
            if(startIndex>sizeOfChildren*i-1){
                System.out.println("No Space in current Stack");
            }
            else{
                System.out.println("Enter new Element (Stack 2): ");
                parentStack[startIndex] = sc.nextInt();
                tempVar2p = tempVar2p +1;
            }
        }
        else if(i==3){
            startIndex = startIndex + tempVar3p;
            if(startIndex>sizeOfChildren*i-1){
                System.out.println("No Space in current Stack");
            }
            else{
                System.out.println("Enter new Element (Stack 3): ");
                parentStack[startIndex] = sc.nextInt();
                tempVar3p = tempVar3p +1;
            }
        }


        System.out.println("Final Parent");
        parentUpdate();

    }
    public void isEmpty(int i){
        int sizeOfChildren = parentStack.length/3;
        int startIndex = 0;
        if(i!=1){
            startIndex = sizeOfChildren*i-sizeOfChildren;
        }
        int counter = 0;
        for(int x = startIndex; x<sizeOfChildren*i; x++){
            if(parentStack[x]==0){
                counter = counter + 1;
            }
        }

        if(counter==sizeOfChildren){
            System.out.println("Stack is Empty");
        }
        else if(counter==0){
            System.out.println("Stack is full.");
        }
        else {
            System.out.println("Stack may have elements");
        }




    }
    public void isFull(int i){
        int sizeOfChildren = parentStack.length/3;
        int startIndex = 0;
        if(i!=1){
            startIndex = sizeOfChildren*i-sizeOfChildren;
        }
        int counter = 0;
        for(int x = startIndex; x<sizeOfChildren*i; x++){
            if(parentStack[x]==0){
                counter = counter + 1;
            }
        }
        if(counter==sizeOfChildren){
            System.out.println("Stack is Empty");
        }
        else if(counter==0){
            System.out.println("Stack is full.");
        }
        else {
            System.out.println("Stack may have elements");
        }
    }


    public void parentUpdate(){
        System.out.println(Arrays.toString(parentStack));
    }

    public void operationCaller(){
        while (true){
            System.out.print("Enter '1' for PUSH;           pushOperation(i)                             i=1,2,3: \n");
            System.out.print("Enter '2' for POP;            popOperation(i)                              i=1,2,3: \n");
            System.out.print("Enter '3' is full?            isFull(i)                                    i=1,2,3: \n");
            System.out.print("Enter '4' is empty ?          isEmpty(i)                                   i=1,2,3: \n");
            System.out.print("Enter '5' Parent Stack ?      incrementParentStack(i)                      i%3==i:  \n");
            Scanner sc = new Scanner(System.in);

            int i = sc.nextInt();
            if(i==1){
                System.out.println("Enter stack number : ");
                int userInput = sc.nextInt();
                if(userInput>3){
                    System.out.println("This program accepts only 3 stacks in parent");
                }
                else{
                    pushOperation(userInput);
                }

            }
            else if(i==2){
                System.out.println("Enter stack number to be popped : ");
                int stackName = sc.nextInt();
                popOperation(stackName);
            }
            else if(i==3){
                System.out.println("Enter stack number : ");
                int userI = sc.nextInt();
                isFull(userI);
            }
            else if(i==4){
                System.out.println("Enter stack number : ");
                int userI = sc.nextInt();
                isEmpty(userI);
            }
            else if(i==5){
                System.out.println("Enter Size of parent stack");
                int parentSize = sc.nextInt();
                if(parentSize%3==0){
                    incrementParentStack(parentSize);
                }
                else {
                    System.out.println("Error : Please enter a number divisible by 3.");
                }
            }

        }
    }


    public static void main(String args[]){
        tstos main = new tstos();

        main.operationCaller();
    }
}
