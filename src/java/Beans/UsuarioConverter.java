package Beans;

import Entidade.Usuario;
import RegraDeNegocio.UsuarioRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "usuarioConverter")
@FacesConverter(value = "usuarioConverter")
public class UsuarioConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new UsuarioRN().getUsuario(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Usuario)o).getIdUsuario().toString();
    }
}
