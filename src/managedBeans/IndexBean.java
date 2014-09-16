package managedBeans;

import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionListener;
import javax.inject.Named;
 
/**
 * Page backing bean for
 * <code>index.xhtml</code>.
 *
 * @author John Yeary
 * @version 1.0
 */
@Named
@RequestScoped
public class IndexBean {
 
    private String uuid;
 
    /**
     * {@link ActionListener} implementation that generates a random UUID and
     * sets the value in the bean. The returned value can be found by calling
     * {@link #getUuid()}.
     */
    public void generateUUID() {
        try {
            // Add this so that we have a delay for the AJAX spinner.
            Thread.sleep(2000);
            uuid = UUID.randomUUID().toString();
        } catch (InterruptedException ignore) {
        }
    }
 
    /**
     * Getter for UUID.
     *
     * @return return {@link UUID#toString()}.
     */
    public String getUuid() {
        return uuid;
    }
}