package Beans;

import Entidade.Setor;
import RegraDeNegocio.SetorRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "setorConverter")
@FacesConverter(value = "setorConverter")
public class SetorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        SetorRN setorRN = new SetorRN();
        return setorRN.getSetor(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Setor)o).getIdSetor().toString();
    }
    
}
