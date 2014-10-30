package model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entity.Assinante;
import entity.Plano;

public class GraficosPainel {
	private Map<Integer,BigDecimal> faturamentos;
	private Map<Integer,Integer> assinaturas;
	private Map<Integer,Integer> cancelamentos;
	private Map<Plano,Integer> totalPorPlano;
	private Map<Integer,Integer> ultimosTotaisArmazenados;
	private int totalContratacaoContabilidade;
	private int totalContratacaoDireta;
	private int totalAssinantes;
	private int totalCte;
	private int totalNfe;
	private int totalSpedFiscal;
	private int totalSpedSocial;
	private int totalSpedCont;
	
	public GraficosPainel(List<Assinante> assinantes){
		Calendar c = Calendar.getInstance();
		setFaturamentos(new HashMap<Integer, BigDecimal>());
		setAssinaturas(new HashMap<Integer,Integer>());
		setCancelamentos(new HashMap<Integer,Integer>());
		ultimosTotaisArmazenados = new HashMap<>();
		totalPorPlano = new HashMap<>();
		totalAssinantes = 0;
		for(int i=0;i<30;i++){
			
			for(Assinante a:assinantes){
				
				if(i==0 && a.isAtivo()){
					totalPorPlano.put(a.getPlano(),Integer.valueOf((totalPorPlano.get(a.getPlano())==null)?1:totalPorPlano.get(a.getPlano())+1));
					totalAssinantes++;
					totalCte+=a.getTotalCte();
					totalNfe+=a.getTotalNfe();
					totalSpedCont +=a.getTotalSpedContribuicoes();
					totalSpedFiscal +=a.getTotalSpedFiscal();
					totalSpedSocial +=a.getTotalSpedSocial();
					if(TipoInclusao.MODULO_ADMINISTRATIVO.equals(a.getTipoInclusao()))
						setTotalContratacaoDireta(getTotalContratacaoDireta() + 1);
					else if(TipoInclusao.MODULO_CONTABILIDADE.equals(a.getTipoInclusao()))
						setTotalContratacaoContabilidade(getTotalContratacaoContabilidade() + 1);
				}
				
				if(Util.comparaDiaMesAno(a.getDataInclusaoCalendar(), c)>=0){
					if(a.isAtivo()){
						getFaturamentos().put(i,getFaturamentos().get(i)==null?BigDecimal.ZERO:getFaturamentos().get(i).add(a.getFaturamento()));
						getAssinaturas().put(i, getAssinaturas().get(i)==null?1:getAssinaturas().get(i)+1);
						ultimosTotaisArmazenados.put(i,ultimosTotaisArmazenados.get(i)==null?a.getTotalDoctosAte(i):ultimosTotaisArmazenados.get(i)+1);						
					}
					if(a.getDataExclusao()!=null && Util.comparaDiaMesAno(a.getDataExclusaoCalendar(), c)==0)
						getCancelamentos().put(i, getCancelamentos().get(i)==null?1:getCancelamentos().get(i)+1);
				}
			}
			c.add(Calendar.DATE, -1);
		}
	}

	public Map<Integer,BigDecimal> getFaturamentos() {
		return faturamentos;
	}

	public void setFaturamentos(Map<Integer,BigDecimal> faturamentos) {
		this.faturamentos = faturamentos;
	}

	public Map<Integer,Integer> getAssinaturas() {
		return assinaturas;
	}

	public void setAssinaturas(Map<Integer,Integer> assinaturas) {
		this.assinaturas = assinaturas;
	}

	public Map<Integer,Integer> getCancelamentos() {
		return cancelamentos;
	}

	public void setCancelamentos(Map<Integer,Integer> cancelamentos) {
		this.cancelamentos = cancelamentos;
	}

	public int getTotalContratacaoContabilidade() {
		return totalContratacaoContabilidade;
	}

	public void setTotalContratacaoContabilidade(
			int totalContratacaoContabilidade) {
		this.totalContratacaoContabilidade = totalContratacaoContabilidade;
	}

	public int getTotalContratacaoDireta() {
		return totalContratacaoDireta;
	}

	public void setTotalContratacaoDireta(int totalContratacaoDireta) {
		this.totalContratacaoDireta = totalContratacaoDireta;
	}
	
	public String getAnalise() {
		StringBuilder analise = new StringBuilder("Análise de Evolução das Vendas \n\n");
		
		BigDecimal total = BigDecimal.ZERO;
		
		Map<Plano, Integer> treeMap = new TreeMap<Plano, Integer>(
				new Comparator<Plano>() {
	 
				@Override
				public int compare(Plano o1, Plano o2) {
					return o2.getFaixaInicial().compareTo(o1.getFaixaInicial());
				}
	 
			});
			treeMap.putAll(totalPorPlano);
		
		analise.append(totalAssinantes);
		analise.append(" Clientes\n\n");
		for (Map.Entry<Plano, Integer> entry : treeMap.entrySet()) {
			Plano plano =  entry.getKey();
			Integer assPlano = entry.getValue();
			analise.append(assPlano + " Assinantes Plano " +plano.getFaixaInicial() + " - " + plano.getFaixaFinal() + "\n");
			total = total.add(plano.getValorMensal().multiply(new BigDecimal(assPlano)));
		}
		analise.append("\n\n");
		
		analise.append(totalAssinantes);
		analise.append(" Clientes = R$ " + total);
		return analise.toString();
	}

	public Map<Plano, Integer> getTotalPorPlano() {
		return totalPorPlano;
	}

	public void setTotalPorPlano(Map<Plano, Integer> totalPorPlano) {
		this.totalPorPlano = totalPorPlano;
	}

	public int getTotalAssinantes() {
		return totalAssinantes;
	}

	public void setTotalAssinantes(int totalAssinantes) {
		this.totalAssinantes = totalAssinantes;
	}

	public int getTotalCte() {
		return totalCte;
	}

	public void setTotalCte(int totalCte) {
		this.totalCte = totalCte;
	}

	public int getTotalNfe() {
		return totalNfe;
	}

	public void setTotalNfe(int totalNfe) {
		this.totalNfe = totalNfe;
	}

	public int getTotalSpedFiscal() {
		return totalSpedFiscal;
	}

	public void setTotalSpedFiscal(int totalSpedFiscal) {
		this.totalSpedFiscal = totalSpedFiscal;
	}

	public int getTotalSpedSocial() {
		return totalSpedSocial;
	}

	public void setTotalSpedSocial(int totalSpedSocial) {
		this.totalSpedSocial = totalSpedSocial;
	}

	public int getTotalSpedCont() {
		return totalSpedCont;
	}

	public void setTotalSpedCont(int totalSpedCont) {
		this.totalSpedCont = totalSpedCont;
	}

	public Map<Integer,Integer> getUltimosTotaisArmazenados() {
		return ultimosTotaisArmazenados;
	}

	public void setUltimosTotaisArmazenados(Map<Integer,Integer> ultimosTotaisArmazenados) {
		this.ultimosTotaisArmazenados = ultimosTotaisArmazenados;
	}
	
}
