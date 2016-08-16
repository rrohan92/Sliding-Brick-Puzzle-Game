/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg1;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

/**
 *
 * @author Rohan
 */
public class Functions {
    
     Scanner sc;
     int row,col;
     int state[][];
     List<String> list = new ArrayList<String>();
        
//input
     
    public void input(String s) throws FileNotFoundException{
      File input =new File(s);
         sc=new Scanner(input);
       row=0; 
       col=0;  
          String q=sc.nextLine();
          String z[]=q.split(",");
          row=Integer.parseInt(z[1]);
          col=Integer.parseInt(z[0]);
          state=new int[row][col];
          int i=0;
           while(sc.hasNextLine()) {
               
                String line = sc.nextLine();
                       String array[]=line.split(",");   
                       for(int j=0; j<array.length; j++){
                           state[i][j]=Integer.parseInt(array[j]);
            }
                       i++;           
           }
            sc.close();
  
    }
    
     //display  
      public void display(){  
     System.out.println(col +","+ row+",");
     for(int b=0; b<row; b++){
         for (int c=0; c<col; c++){
             System.out.print(state[b][c]+ ",");
         } 
         System.out.println();
     }  
      }
     //clone
      public int[][] cloning(){
     int clone[][]=new int[row][col];
     for (int e=0; e<row; e++){
         for(int f=0; f<col; f++){
             clone[e][f]=state[e][f];
              
         }
        
     }
     return clone;
      }
     //2B
      public boolean check(){
     int count=0;
     for (int y=0; y<row; y++){
         for(int l=0; l<col; l++){
             if (state[y][l]==-1){
                 count++;
                 }    
         }
     }
     if(count>0){
         return false;
     }
     else{
        return true;
     }
     
     
     }
      public void Move(int p){
          int piece=p;
         int up=-1;
         int down=-2;      //Directions
         int left=-3;
         int right=-4;
         
            for(int a=0; a<row; a++){
                for(int b=0; b<col; b++){
                    if(state[a][b]==piece){
                        if(state[a][b-1]==0){
                            System.out.println("("+piece + "," + left+ ")");
                        }
                         if(state[a][b+1]==0){
                            System.out.println("("+piece + "," + right +")");
                        }
                          if(state[a-1][b]==0){
                            System.out.println("("+piece + "," + up +")");
                        }
                           if(state[a+1][b]==0){
                            System.out.println("("+piece + "," + down +")");
                        }
                    }
                }
            }
      }
      public List  AllMoves(){
         // System.out.println("List of all moves");
           int up=-1;
         int down=-2;      //Directions
         int left=-3;;
         int right=-4;
         
        int i=0;
          for(int a=0; a<row; a++){
                for(int b=0; b<col; b++){
                    if(state[a][b]>1){
                        if(state[a][b-1]==0){
                            //System.out.println(state[a][b] + "," + left);
                            list.add(state[a][b] + "," + left);
                        }
                         if(state[a][b+1]==0){
                           // System.out.println(state[a][b] + "," + right);
                            list.add(state[a][b] + "," + right);
                        }
                          if(state[a-1][b]==0){
                           // System.out.println(state[a][b] + "," + up);
                           list.add(state[a][b] + "," + up);
                        }
                           if(state[a+1][b]==0){
                           // System.out.println(state[a][b] + "," + down);
                            list.add(state[a][b] + "," + down);
                        }
                    }
                }
            }
          return list;
      }
      public void applyMove(String s){
        int piece1;
          int d;
         String ret=s;
         String piece[]=ret.split(",");
         piece1=Integer.parseInt(piece[0]);
         d=Integer.parseInt(piece[1]);
            for(int a=0; a<row; a++){
                for(int b=0; b<col; b++){
                    if(state[a][b]==piece1){
                        if(state[a][b-1]==0 && d==-3){
                            state[a][b-1]=state[a][b];
                            state[a][b]=0;
                        } else {
                        }
                         if(state[a][b+1]==0 && d==-4){
                             state[a][b+1]=state[a][b];
                            state[a][b]=0;
                        }
                          if(state[a-1][b]==0 && d==-1){
                              state[a-1][b]=state[a][b];
                            state[a][b]=0;
                        }
                           if(state[a+1][b]==0 && d==-2){
                               state[a+1][b]=state[a][b];
                            state[a][b]=0;
                        }
                    }
                }
            }
      }
      public int[][] applyMoveCloning(int p){
          int clone[][]=new int[row][col];
     for (int e=0; e<row; e++){
         for(int f=0; f<col; f++){
             clone[e][f]=state[e][f];         
         }        
     }
     int piece1=p;
      for(int a=0; a<row; a++){
                for(int b=0; b<col; b++){
                    if(state[a][b]==piece1){
                        if(state[a][b-1]==0){
                            
                            state[a][b-1]=state[a][b];
                            state[a][b]=0;
                        }
                         if(state[a][b+1]==0){
                             state[a][b+1]=state[a][b];
                            state[a][b]=0;
                        }
                          if(state[a-1][b]==0){
                              state[a-1][b]=state[a][b];
                            state[a][b]=0;
                        }
                           if(state[a+1][b]==0){
                               state[a+1][b]=state[a][b];
                            state[a][b]=0;
                        }
                    }
                }
            }
      return state;
          
      }
      public boolean Comparison(String s1, String s2) throws FileNotFoundException{
             File input1 =new File(s1);
             Boolean b;
             File input2=new File(s2);
             int state1[][];
             int state2[][];
         sc=new Scanner(input1);
      int row1=0; 
      int col1=0;  
          String q=sc.nextLine();
          String z[]=q.split(",");
          row1=Integer.parseInt(z[1]);
          
          col1=Integer.parseInt(z[0]);
          state1=new int[row1][col1];
          int i=0;
           while(sc.hasNextLine()) {
               
                String line = sc.nextLine();
                       String array[]=line.split(",");   
                       for(int j=0; j<array.length; j++){
                           state1[i][j]=Integer.parseInt(array[j]);
            }
                       i++;           
           }
            sc.close();
       
             sc=new Scanner(input2);
      int row2=0; 
      int col2=0;  
          String q1=sc.nextLine();
          String z1[]=q.split(",");
          row2=Integer.parseInt(z1[1]);
          
          col2=Integer.parseInt(z1[0]);
          state2=new int[row2][col2];
          int k=0;
           while(sc.hasNextLine()) {
               
                String line = sc.nextLine();
                       String array[]=line.split(",");   
                       for(int j=0; j<array.length; j++){
                           state2[k][j]=Integer.parseInt(array[j]);
            }
                       k++;           
           }
            sc.close();
            if(row1!=row2 || col1!=col2)
                b=false;
            else{
              b=Arrays.deepEquals(state1,state2);
 
            }
            return b;
            }
      public void swapidx(int indx1, int indx2){
           for(int a=0; a<row; a++){
                      for(int b=0; b<col; b++){
                          if(state[a][b]==indx1){
                              state[a][b]=indx2;
                      }
                          else if(state[a][b]==indx2){
                            state[a][b]=indx1;  
           }
           }
      }
      }
            public void Normalization()
            {
                   int nextidx=3;

                  for(int a=0; a<row; a++){
                      for(int b=0; b<col; b++){
                              if(state[a][b]==nextidx){
                                  nextidx++;
                              }
                                  else if(state[a][b]>nextidx)
                                          {
                                          swapidx(nextidx,state[a][b]);
                                         
                                          nextidx++;
                                          
                                          }
                              }
                          
                      }
                  
                  }
            }


