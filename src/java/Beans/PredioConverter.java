package Beans;

import Entidade.Predio;
import RegraDeNegocio.PredioRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "predioConverter")
@FacesConverter(value = "predioConverter")
public class PredioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new PredioRN().getPredio(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Predio)o).getIdPredio().toString();
    }
    
}
