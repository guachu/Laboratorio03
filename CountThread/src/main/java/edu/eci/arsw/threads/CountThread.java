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
public class CountThread implements Runnable{

    private String nombre;
    private int min,max;
    private Thread thread;
    
    public CountThread(String nombreN, int minN, int maxN){
        nombre = nombreN;
        min = minN;
        max = maxN;
        thread = new Thread(this, nombre);
        Start();
    }


    @Override
    public void run() {
        for (int i = min; i <= max; i++){
            System.out.println("El conteo de este thread es "+ i); 
        }   
    }
    
    
    public void Start(){
        thread.start();
    }
     
    
    
}
