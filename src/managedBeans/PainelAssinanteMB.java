package managedBeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import dao.AssinanteDao;
import entity.Assinante;

@ManagedBean
public class PainelAssinanteMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Assinante a;
	private Map<Object,Number> historico;	
	@Inject
	private AssinanteDao dao;
	
	@PostConstruct
	public void init(){
		try {
			a = dao.getAssinanteComTodosDoctos(getLoginBean().getAssinante());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH,0);
		setHistorico(a.getHistoricoConsumoTotalDoAssinante(Calendar.MONTH,12));
	}
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}
	
	public LoginBean getLoginBean(){
		return this.loginBean;
	}
	
	public PieChartModel getPieChartModel(){
		PieChartModel pieChartModel = new PieChartModel();
		pieChartModel = new PieChartModel();

		pieChartModel.set("NF-e", a.getTotalNfe());
		pieChartModel.set("CT-e", a.getTotalCte());
		pieChartModel.set("SPED Fiscal", a.getTotalSpedFiscal());
		pieChartModel.set("SPED Contribuições", a.getTotalSpedContribuicoes());
		pieChartModel.set("SPED Social", a.getTotalSpedSocial());

		pieChartModel.setTitle("Consumo de Recurso Contratado");
		pieChartModel.setLegendPosition("e");
		pieChartModel.setShowDataLabels(true);
		return pieChartModel;
	}
	
	public CartesianChartModel getLineChartModel() {
		CartesianChartModel model =new CartesianChartModel();
        ChartSeries cs = new ChartSeries();
        cs.setLabel("Consumo");
        
        for(Object o:getHistorico().keySet()){
        	cs.set(o,getHistorico().get(o));
        }
		model.addSeries(cs);
		return model;
	}

	public Map<Object,Number> getHistorico() {
		return historico;
	}

	public void setHistorico(Map<Object,Number> historico) {
		this.historico = historico;
	}
	
	public LineChartModel getHistoricoUtilizacao(){
		LineChartModel model =new LineChartModel();
		return model;
	}
}
