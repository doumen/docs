package managedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import model.AjaxStatus;
import model.ChaveDocto;
import model.Util;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import component.DoctoComponent;
import entity.Arquivo;
import entity.Docto;

public abstract class AbstractUploadMB<D,A> {
	
	public abstract DoctoComponent<D, A> getDoctoComponent();
	
	
	protected Docto docto;
	protected Arquivo arq;
	
	public AbstractUploadMB(Class<D> d,Class<A> a) throws InstantiationException, IllegalAccessException{
			docto = (Docto) d.newInstance();
			arq = (Arquivo) a.newInstance();
	}
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}
	
	public LoginBean getLoginBean(){
		return this.loginBean;
	}

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        UploadedFile file = event.getFile();
        byte[] bytes = IOUtils.toByteArray(file.getInputstream());
//        Map<byte[],String> arquivos = new HashMap<>();
        boolean salvou = saveFile(bytes);
        String m;
        if(salvou)
        	m = "Arquivo " + file.getFileName() + " inserido com sucesso ";
        else
        	m = "Não foi possível inserir o arquivo " + file.getFileName();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Atenção!", m));
    }
        		
	public boolean saveFile(byte[] file){
		arq.setArquivoXML(file);
		arq.setDataInclusao(Calendar.getInstance().getTime());
		Docto docto = getDoctoComponent().coletaDadosDoXml(arq);
			docto.setDataInclusao(arq.getDataInclusao());
			docto.setAssinante(getLoginBean().getAssinante());
			docto.setUsuario(getLoginBean().getUsuario());
		return getDoctoComponent().saveDocto(docto, arq);
	}
	
	private List<ChaveDocto> chavesDoctos = new ArrayList<>();
	private String chave = "";
	private ChaveDocto selectedChave;
	
	public void incluirChave(){
		if(chave!=null && !chave.equals("") && chave.length()==44){
			ChaveDocto chaveDocto = new ChaveDocto(chave);
			if(!chavesDoctos.contains(chaveDocto))
				chavesDoctos.add(chaveDocto);
			else{
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!", "Chave já registrada"));				
			}				
			chave = "";
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Atenção!", "Chave incorreta"));
		}
	}
	
	public void excluirChave(){
		chavesDoctos.remove(selectedChave);
	}
	
	public void processarNFe(){
		for(ChaveDocto chaveDocto:chavesDoctos){
			chaveDocto.setAjaxStatus(AjaxStatus.Recebido);
			chaveDocto.setProgresso(1);
			for(int i=0;i<10000;i++){
				Calendar c = Calendar.getInstance();
				c.add(Calendar.DATE, 3);
				Util.daysBetween(c, Calendar.getInstance());
			}
		}
	}

	public List<ChaveDocto> getChavesDoctos() {
		return chavesDoctos;
	}

	public void setChavesDoctos(List<ChaveDocto> chavesNFe) {
		this.chavesDoctos = chavesNFe;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public ChaveDocto getSelectedChave() {
		return selectedChave==null?new ChaveDocto(""):selectedChave;
	}

	public void setSelectedChave(ChaveDocto selectedChaves) {
		this.selectedChave = selectedChaves;
	}
}
