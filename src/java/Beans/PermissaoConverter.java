package Beans;

import Entidade.Permissao;
import RegraDeNegocio.PermissaoRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "permissaoConverter")
@FacesConverter(value = "permissaoConverter")
public class PermissaoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new PermissaoRN().getPermissao(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Permissao)o).getNomePermissao();
    }
    
}
