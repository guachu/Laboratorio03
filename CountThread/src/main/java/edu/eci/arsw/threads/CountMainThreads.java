/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.edu.eci.arsw.threads;
/**
 *
 * @author 2124203
 */
public class CountMainThreads {
    
    
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         CountThread nodo1 = new CountThread("nodo1", 0, 99);
         CountThread nodo2 = new CountThread("nodo2", 100, 199);
         CountThread nodo3 = new CountThread("nodo3", 200, 299); 
    }
    
    
    
    
}
