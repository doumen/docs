package managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.TipoInclusao;

import org.primefaces.context.RequestContext;

import component.PlanoComponent;

import entity.Plano;

@ManagedBean
@ViewScoped
public class ConsultaPlanoAdmMB extends AbstractConsultaMB<Plano> {
	private List<Plano> filteredList;

	public ConsultaPlanoAdmMB() throws InstantiationException,
			IllegalAccessException {
		super(Plano.class);
		setEnctype("application/x-www-form-urlencoded");
		System.out.println("Instanciou o public ConsultaPlanoAdmMB() throws InstantiationException, IllegalAccessException");
	}

	public void init() {
		System.out.println("Instanciou o public void init()");
		listTable = planoComponent.getPlanos();
	}

	@Inject
	private PlanoComponent planoComponent;

	@Override
	public String getAvisoExcluir() {
		System.out.println("Chamou o public String getAvisoExcluir()");
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		System.out.println("Chamou o public String getAvisoPreExcluir()");
		return "Os itens serão excluídos";
	}

	@Override
	public String getPdfReportName() {
		System.out.println("Chamou o public String getPdfReportName()");
		return "planos";
	}

	public void carregarPopUpAlterar() {
		System.out.println("Chamou o public void carregarPopUpAlterar()");
		if ((selectedList != null) && (!selectedList.isEmpty())) {
			selected = selectedList.get(0);
		}
	}

	public void carregarPopUpIncluir() {
		System.out.println("Chamou o public void carregarPopUpIncluir()");
		selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
		selected.setDataInclusao(new Date());
	}

	@Override
	public void setSelected(Plano selected) {
		System.out.println("Chamou o public void setSelected(Plano selected)");
		if (selected != null)
			this.selected = selected;
		else if (selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);
	}

	public List<Plano> getFilteredList() {
		System.out.println("Chamou o public List<Plano> getFilteredList()");
		return filteredList;
	}

	public void setFilteredList(List<Plano> filteredList) {
		System.out.println("Chamou o public void setFilteredList(List<Plano> filteredList)");
		this.filteredList = filteredList;
	}

	@Override
	public void incluir() {
		System.out.println("Chamou o incluir do ConsultaPlanoAdmMB");
		FacesMessage message;		
		try {
			planoComponent.inserirPlano(selected);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Plano inserido com sucesso.");
			listTable.add(selected);
		} catch (Exception e) {
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Não Foi possível inserir o plano");
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	@Override
	public void alterar() {
		System.out.println("Chamou o public void alterar()");
		FacesMessage message;
		try {
			planoComponent.alterar(selected);;
			 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Contabilidade alterada com sucesso.");
		} catch (Exception e) {
			 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Não foi possível alterar o Plano");			
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		RequestContext.getCurrentInstance().update("formPainel:dataTable");
	}

	@Override
	public String getPdfTemplateName() {
		System.out.println("Chamou o public String getPdfTemplateName()");
		return "template_portrait";
	}

	@Override
	public void removeSelectedList() {
		System.out.println("Chamou o public void removeSelectedList()");
		FacesMessage message;
		ArrayList<Plano> r = new ArrayList<>();
		for(Plano p : selectedList){
			try {
				p.setAtivo(false);
				planoComponent.alterar(p);
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Plano " + p.getDescricao() + " excluído com sucesso.");
				r.add(p);
			} catch (Exception e) {
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Não foi possível excluir o plano " + p.getDescricao());
				e.printStackTrace();
			}			
			RequestContext.getCurrentInstance().showMessageInDialog(message);			
		}
		selectedList.removeAll(r);
		RequestContext.getCurrentInstance().update("formPainel:dataTable");

	}
}
