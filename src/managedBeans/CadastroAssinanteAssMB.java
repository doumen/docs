package managedBeans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroAssinanteAssMB extends ConsultaAssinantesAdmMB{
	
	
	@Override
	public void init(){
		selected = assinanteComponent.getAssinanteComUsuariosCertificado(getLoginBean().getAssinante());
		setCertificadoA1(selected.getCertificadoA1());
		selectedList.add(selected);		
		setHeaderInclude("Alterar");
		setBotaoIncluir(false);
		setBotaoAlterar(true);
		setShowUpload(false);
		setShowUploadNome(true);
		carregarPopUpAlterar();
	}

}
