/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.AssinanteComponent;
import model.Assinante;

/**
 *
 * @author Marcel
 */
@ManagedBean
@ViewScoped
public class BarMB {
    private List<Assinante> assinantes;
    
    @Inject
    private AssinanteComponent assinanteComponent;
    
   @PostConstruct
   public void init(){
       setAssinantes(assinanteComponent.getAssinantes());
//       totAss = assinantes.size();
       totPag = getTotalPaginas();
   }
   
   private final int nMaxAssPp = 10;
   
   private int pgAtual = 1;
   
   private int totAss;
   
   private int totPag;
   
   public void irParaProximaPagina(){
       if(pgAtual<totPag){
           pgAtual ++;
       }
   }
   
   public void irParaPaginaAnterior(){
       
   }
      
   public int getTotalPaginas(){
       if(totAss>nMaxAssPp){
           return (totAss - totAss%nMaxAssPp)/nMaxAssPp + 1;
       }
       return 1;
   }
   
   public int getAssinantesPorPagina(){
       if(pgAtual<totPag){
           if(totAss>nMaxAssPp)
               return nMaxAssPp;
           else{
               return totAss;
           }
       }else{
           return totAss%nMaxAssPp;
       }
   }
   
   
public List<Assinante> getAssinantes() {
	return assinantes;
}

public void setAssinantes(List<Assinante> assinantes) {
	this.assinantes = assinantes;
}

   
}
