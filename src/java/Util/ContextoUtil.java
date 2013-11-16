package Util;

import Beans.ContextoBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruno
 */
public class ContextoUtil {

    public static ContextoBean getContextoBean() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext external = context.getExternalContext();
        HttpSession session = (HttpSession) external.getSession(true);
        ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
        return contextoBean;
    }
}
