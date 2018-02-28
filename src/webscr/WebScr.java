/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscr;

import com.jaunt.*;
import com.jaunt.component.*;
import java.io.*;

public class WebScr
{
  public static void main(String[] args)throws IOException
  {
   // try
    
        PrintWriter out = new PrintWriter(new File("/home/nandan/bnmitsem4.csv"));
       out.write("\n\n\n");
        for(int i = 1 ; i<=200; i++)
        {
            try
            {
                
         UserAgent user = new UserAgent();
            String usn = new String("1BG15CS") ;
            usn += String.format("%03d", i);
      user.visit("http://results.vtu.ac.in/cbcs_17/result_page.php?usn="+usn);           
             Table t = user.doc.getTable("<table style=\"margin-left:10px;margin-top:10px\"");
     Element e = t.getCell(1,0);
     System.out.print(e.getText()+" ");
     out.write(e.getText());
     e = t.getCell(1,1);
     System.out.print(e.getText()+"");
            out.write(","+e.getText());
        
  
     
       t = user.doc.getTable("<table class=\"table table-bordered\"");
         //System.out.print(usn+"  ");
      //visit a url 
      double cgpa = 0.0f ;
      //Enmeration e = 
     for(int row = 1 ; row <= 8 ; row++)
     {
         for(int col = 2 ; col <= 5 ; col++)
         {
             if(col==5 )
             {
                  e = t.getCell(col-1,row);
                         int total = Integer.parseInt(e.getText());
                         if(total >= 90 )
                         {
                             System.out.print("S+ ");
                             out.write(","+"S+");
                             cgpa += (row==7||row==8)? 20 : 40 ;
                         }
                             else if(total >= 80)
                             {
                               cgpa += (row==7||row==8)? 18 : 36 ;
                             System.out.print(" S ");
                             out.write(","+"S");
                             }
                             else if(total >= 70)
                             {
                                cgpa += (row==7||row==8)? 16 : 32 ;
                                 System.out.print("A");
                                 out.write(","+"A");
                             }
                                 else if(total >= 60)
                                 {
                                     cgpa += (row==7||row==8)? 14 : 28 ;
                                     System.out.print(" B ");
                                     out.write(","+"B");
                                 }
                         else if(total >= 50)
                         {
                            // cgpa += 6;
                             cgpa += (row==7||row==8)? 12 : 24 ;
                             System.out.print(" C ");
                             out.write(","+"C");
                         }
                         else if( total >= 45)
                         {
                            /// cgpa += 5;
                             cgpa += (row==7||row==8)? 10 : 20 ;
                             System.out.print(" D ");
                             out.write(","+"D");
                         }
                         else if(total >= 40 )
                         {
                            // cgpa += 4;
                             cgpa += (row==7||row==8)? 8 : 16 ;
                             System.out.print(" E ");
                             out.write(","+"E");
                         }
                         else 
                         {
                             cgpa+= 0 ;
                             System.out.print(" F ");
                             out.write(","+"F");
                         }
                            
                        
             }
             else
             {
                
            
              e = t.getCell(col,row);
                     System.out.print(e.getText()+" ");
                     out.write(","+e.getText());
             }
         }
     }
     //System.out.println();
     cgpa = cgpa / 28.0 ;
     System.out.println(" "+String.format("%.2f",cgpa));
     out.write(","+String.format("%.2f",cgpa)+"\n");
    
     
        }catch(Exception e) {System.out.println();out.write("\n");continue ;}
        } 
    out.close();
    //catch(JauntException e)
    {         //if an HTTP/connection error occurs, handle JauntException.
      //System.err.println(e);
       // System.out.println("server took too long to respond");
    }
  }
}

