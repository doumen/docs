package managedBeans.components;

import managedBeans.AbstractExporterMB;
import model.GraficoDoctosAssinante;

public abstract class PaginatorMB extends AbstractExporterMB<GraficoDoctosAssinante>{

	private int pgAtual;
	private int totalPg;
	
	public void irParaUltimaPagina(){
		pgAtual = totalPg;
		carregaPagina();
	}
	
	public void irParaProximaPagina(){
		if(pgAtual<totalPg){
			pgAtual++;
			carregaPagina();
		}
	}
	
	public void irParaPrimeiraPagina(){
		pgAtual = 1;
		carregaPagina();
	}
	
	public void irParaPaginaAnterior(){
		if(pgAtual>1){
			pgAtual --;
			carregaPagina();
		}
	}
		
	public abstract void carregaPagina();
	
	public abstract void postConstructAndLoadTotPag();
			
	public void init(){
		postConstructAndLoadTotPag();
		pgAtual = 1;
		carregaPagina();
	}
					
	public int getPaginaAtual(){
		return pgAtual;
	}
	
	public int getTotPag(){
		return totalPg;
	}

	public void setTotPag(int totalPg){
		this.totalPg = totalPg;
	}
}

