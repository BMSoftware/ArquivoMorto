package Beans;

import Entidade.Sala;
import RegraDeNegocio.SalaRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "salaConverter")
@FacesConverter(value = "salaConverter")
public class SalaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new SalaRN().getSala(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Sala)o).getIdSala().toString();
    }
    
}
