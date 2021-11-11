/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chocolatebardivision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class ChocolateBarDivision {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan=new Scanner(System.in);
        int n,d,m,number;
        List<Integer> s= new ArrayList<>();
        
        do{
            System.out.println("Enter the number of squares in the chocolate bar between 1 and 100: ");
            n=scan.nextInt();
        }while(n<1 || n>100);
        
        System.out.println("Enter the integers found on the squares of the bar: ");
        do{
            number=scan.nextInt();
            if(number>0 && number<=5){
                s.add(number);
            }
        }while(s.size()<n);
        
        do{
            System.out.println("Enter Ron's birth day(between 1 and 31) and birth month(between 1 and 12): ");
            d=scan.nextInt();
            m=scan.nextInt();
        }while(d<1 || d>31 || m<1 || m>12);             //if the user's input is out the condition's range, the system will ask him to enter the info again
        
        System.out.println(birthday(s,d,m));           //call the birthday method and print out the result
    }
    
    public static int birthday(List<Integer> s, int d, int m){
        int count = 0, add;                           //the count variable is for the number of ways the bar can be divided
        int n=s.size();

        for (int i=0;i<n-1;i++){                      //iterate over all the elements inside the list except for the last one
            add= sum(s,m);                            //call the sum method to find the addition result and store it inside the add variable
            if(add==d)
                count+=1;                             //increment the number of ways by 1 when the condition is applied
            s.remove(0);                              //remove the element at index 0 to add the next numbers
        }
        if (m==1 && s.size()==1 && s.get(0)==d)       //this condition is applied when the list is with a single element
            count+=1;
        
        return count;
    }
    
    public static int sum(List<Integer>s, int m){         //finding the sum of the number of elements according to the m variable
        if (m==0)
            return 0;
        return s.get(m-1)+sum(s,m-1);
    }
  
}
