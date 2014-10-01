package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Plano;
import model.TipoInclusao;
import component.PlanoComponent;

@ManagedBean
@ViewScoped
public class ConsultaPlanoAdmMB extends AbstractConsultaMB<Plano> {
	private List<Plano> filteredList = new ArrayList<>();

	
	public ConsultaPlanoAdmMB() throws InstantiationException,
			IllegalAccessException {
		super(Plano.class);
		System.out.println("Instanciou o ConsultaPlanoAdmMB!!");
	}

	@PostConstruct
	public void init() {
		listTable = planoComponent.getPlanos();
		filteredList = planoComponent.getPlanos();
	}

	@Inject
	private PlanoComponent planoComponent;

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}

	@Override
	public String getPdfReportName() {
		return "planos";
	}
	
	public void carregarPopUpAlterar(){
		if((selectedList != null) && (!selectedList.isEmpty())){
			selected = selectedList.get(0);	
		}
	}
	
	public void carregarPopUpIncluir(){
		selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
	}
	
	@Override
	public void setSelected(Plano selected) {
		if(selected!=null)
			this.selected = selected;		
		else if(selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);		
	}

	public List<Plano> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Plano> filteredList) {
		this.filteredList = filteredList;
	}

	@Override
	public void incluir() {
		System.out.println("Incluiu Planos");	
	}

	@Override
	public void alterar() {
		System.out.println("Alterou Planos");
	}

	@Override
	public String getPdfTemplateName() {		
		return "template_portrait";
	}
}
