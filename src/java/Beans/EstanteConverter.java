package Beans;

import Entidade.Estante;
import RegraDeNegocio.EstanteRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "estanteConverter")
@FacesConverter(value = "estanteConverter")
public class EstanteConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new EstanteRN().getEstante(new Integer(string));
        }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Estante)o).getIdEstante().toString();
    }
    
}
