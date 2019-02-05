/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.edu.eci.arsw.blacklistvalidator;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import main.java.edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

/**
 *
 * @author 2124203
 */
public class ThreadC implements Runnable{

    private String nombre;
    private int min;
    private int max;
    private final static AtomicInteger numeroFallos = new AtomicInteger(0);
    private final static AtomicInteger contLists = new AtomicInteger(0);
    private java.lang.Thread thread;
    private String Ip;
    private HostBlacklistsDataSourceFacade skds;
    LinkedList<Integer> blackListOcurrences;

    public ThreadC(String nombreN, int minN, int maxN, String IpN, LinkedList bl) {
        nombre = nombreN;
        min = minN+1;
        max = maxN;
        Ip = IpN;
        skds=HostBlacklistsDataSourceFacade.getInstance();
        blackListOcurrences = bl;
        thread = new java.lang.Thread(this, nombre);
        Start();
    
    }
    
    
    public static int Ask(){
        return numeroFallos.get();
    }
    
    public static int AskLists(){
        return contLists.get();
    }
    
    @Override
    public void run() {
        for (int i=min;i<=max;i++){       
            contLists.addAndGet(1);
            if (skds.isInBlackListServer(i, Ip)){
                blackListOcurrences.add(i);
                numeroFallos.addAndGet(1);
            }
        }
    }

    public final synchronized  void join() throws InterruptedException{
        thread.join();
    }

    private void Start() {
        thread.start();
    }
 
}
