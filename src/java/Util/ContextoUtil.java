package Util;

import Beans.ContextoBean;
import javax.el.ELResolver;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
public abstract class ContextoUtil {
    public static ContextoBean getContextoBean(){
        FacesContext context = FacesContext.getCurrentInstance();
        ELResolver resolver = context.getApplication().getELResolver();
        return (ContextoBean) resolver.getValue(context.getELContext(), null, "contextoBean");
    } 
}
