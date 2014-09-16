package teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@ManagedBean
public class FileDownloadView {
     
    private StreamedContent file;
     
    public FileDownloadView() throws FileNotFoundException {       
        //InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
        //file = new DefaultStreamedContent(stream, "image/jpg", "downloaded_optimus.jpg");
    	InputStream stream = new FileInputStream("/home/desenv/Downloads/teste.txt");    
        file = new DefaultStreamedContent(stream, "application/txt", "teste.txt"); 
    }
 
    public StreamedContent getFile() {
        return file;
    }
    
    public void setFile(StreamedContent file) {    
        this.file = file;    
    }  
}
