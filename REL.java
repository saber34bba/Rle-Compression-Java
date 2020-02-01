/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp01rle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sofiane
 */

public class REL {

    public static void main(String[] args) throws IOException {
       REL rle=new REL();
       rle.readfile();
       rle.count();
       
       rle.showcomp();
       
    }

    
    
    static class Node {

        Node left;
        Node right;
        char value;
        

        public Node(char value) {
            this.value = value;
        }
    }
 Node nd;
    public void readfile() throws IOException {
     
         
         
          File file = new File("C:\\test.txt"); 

        BufferedReader br = new BufferedReader(new FileReader(file)); 
        
  String st; 
 
           nd = new Node('5');

  while ((st = br.readLine()) != null)
  { 
  
      for(int i=0;i<st.length();i++)
         {
                addtotree(nd,st.charAt(i));
                //text=st.charAt(i)+""+text;
             //System.out.println(st.charAt(i)); 
         }
     
  }
    }
    
//int k=1;
    public void addtotree(Node node, char value) {
     
        
        if(value != node.value)
        {// k=1;
            if(node.right!=null){
                //k++;
                addtotree(node.right, value);
            }
            else
            {            //    System.out.println("  Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
            }
        }
        
        if(value ==node.value && node.right==null)
        {
          if(node.left!=null)
          {// k++;
              addtotree(node.left, value);
          }
          else{
                         //  System.out.println("  Inserted " + value + " to left of Node " + node.value/*+""+k*/);
              node.left=new Node(value);
          }
        }
        if(value==node.value && node.right!=null)
        {
            addtotree(node.right, value);
        }
    }
    
     void count(){ 
       countrec(nd.right); 
       rr=nd.right;
    } 
  int t=0;
  Node rr;
  String s="";
  String kk="";
  char caracter;
  
  
  
    void countrec(Node nd) {
        if (nd != null) { 
        t++;
        rr=nd;
       
          //  System.out.println(nd.value); 
            caracter=nd.value;
            countrec(nd.left); 
            countrec(nd.right); 
            
        }
        else{
            if(t>3)
            {
                 
                s=s+"$"+t+""+caracter;
            }
            else{
                //if(rr.value)
                       //if(caracter!=s.charAt(s.length()))
                if(rr.right!=null )
                          //System.out.println(""+rr.right.value);
                           s=s+""+caracter;
                  
            }
          
                        t=0;
        }
       
    } 
    
    public void showcomp()
    {
         System.out.print(s);
    }
  
}


