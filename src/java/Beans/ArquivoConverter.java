package Beans;

import Entidade.Arquivo;
import RegraDeNegocio.ArquivoRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "arquivoConverter")
@FacesConverter(value = "arquivoConverter")
public class ArquivoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new ArquivoRN().getArquivo(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Arquivo)o).getIdArquivo().toString();
    }
    
}
