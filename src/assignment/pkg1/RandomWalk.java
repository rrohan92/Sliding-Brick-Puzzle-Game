/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

/**
 *
 * @author Rohan
 */
import java.io.*;
import java.util.List;
import java.util.Random;
public class RandomWalk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
         Functions f=new Functions();
        f.input("C:\\Users\\Rohan\\Desktop\\AI\\HW1\\SBP-level1.txt"); //Enter the location of file
        System.out.println("Initial State");
        f.display();
        System.out.println();
        
        int n=5;  //Number of moves
        for(int i=0; i<n-1; i++)
        {
            System.out.println();
             boolean b=f.check();
            if(b){
                System.out.println("Solved!");
                break;
            }
           List<String> list=f.AllMoves();
            Random r=new Random();                
            //Selects a random move                                                 
            int index = r.nextInt(list.size());
            System.out.print("Move:");
            System.out.println(list.get(index));
            f.applyMove(list.get(index));                  
            System.out.println();
            list.clear();
            f.display();
            f.Normalization();
             
           
            
          }
    
 }
} 


 
        
         
    



