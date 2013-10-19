package Beans;

import Entidade.Prateleira;
import RegraDeNegocio.PrateleiraRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "prateleiraConverter")
@FacesConverter(value = "prateleiraConverter")
public class PrateleiraConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new PrateleiraRN().getPrateleira(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Prateleira)o).getIdPrateleira().toString();
    }
    
}
