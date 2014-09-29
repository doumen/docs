package managedBeans.components;

import javax.annotation.PostConstruct;

public abstract class PaginatorMB {

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
			
	@PostConstruct
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

