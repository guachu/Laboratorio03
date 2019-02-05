/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.edu.eci.arsw.blacklistvalidator;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import main.java.edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class HostBlackListsValidator {

    private static final int BLACK_LIST_ALARM_COUNT=5;
    private List<ThreadC> listaThreads = new ArrayList<ThreadC>();
    private int minimo = 0;
    private int maximo;
    private int maximoEstandar;
    private int conteoResidual = 0;
    LinkedList<Integer> blackListOcurrences=new LinkedList<>();
    /**
     * Check the given host's IP address in all the available black lists,
     * and report it as NOT Trustworthy when such IP was reported in at least
     * BLACK_LIST_ALARM_COUNT lists, or as Trustworthy in any other case.
     * The search is not exhaustive: When the number of occurrences is equal to
     * BLACK_LIST_ALARM_COUNT, the search is finished, the host reported as
     * NOT Trustworthy, and the list of the five blacklists returned.
     * @param ipaddress suspicious host's IP address.
     * @return  Blacklists numbers where the given host's IP address was found.
     */
    public List<Integer> checkHost(String ipaddress, int N){
        
        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        int tamanioServer = skds.getRegisteredServersCount();
        if (N > tamanioServer){
            N = tamanioServer;
        }
        if(tamanioServer%N != 0){
            maximoEstandar = tamanioServer/N;
            conteoResidual = tamanioServer%N;
            maximo = maximoEstandar +1;
        }
        else{
            maximoEstandar = tamanioServer/N;
        }
        System.out.println(maximoEstandar);
        System.out.println(conteoResidual);
        for(int i = 1; i <= conteoResidual; i++){
            String nombre = "thread#" + i;
            ThreadC nodo = new ThreadC(nombre, minimo, maximo,ipaddress, blackListOcurrences);
            minimo = maximo;
            maximo+= maximoEstandar +1;
            listaThreads.add(nodo);
        }
        maximo-=1;
        for(int i = 1; i <= (N-conteoResidual); i++){
            String nombre = "thread#" + (i+conteoResidual);
            ThreadC nodo = new ThreadC(nombre, minimo, maximo,ipaddress, blackListOcurrences);
            minimo = maximo;
            maximo += maximoEstandar;
            listaThreads.add(nodo);
        }
        
        
        for(ThreadC i : listaThreads) {
            try{
                i.join(); 
            }catch(InterruptedException e){
                System.out.println(e);
            }
        };
        
        
        
        int ocurrencesCount=  ThreadC.Ask();

        int checkedListsCount= ThreadC.AskLists();
        
//        for (int i=0;i<skds.getRegisteredServersCount() && ocurrencesCount<BLACK_LIST_ALARM_COUNT;i++){
//            checkedListsCount++;
//            
//            if (skds.isInBlackListServer(i, ipaddress)){
//                
//                blackListOcurrences.add(i);
//                
//                ocurrencesCount++;
//            }
//        }
        
        if (ocurrencesCount>=BLACK_LIST_ALARM_COUNT){
            skds.reportAsNotTrustworthy(ipaddress);
        }
        else{
            skds.reportAsTrustworthy(ipaddress);
        }                
        
        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", new Object[]{checkedListsCount, skds.getRegisteredServersCount()});
        
        return blackListOcurrences;
    }
    
    
    private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
    
    
    
}
