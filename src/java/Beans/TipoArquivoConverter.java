package Beans;

import Entidade.TipoArquivo;
import RegraDeNegocio.TipoArquivoRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "tipoArquivoConverter")
@FacesConverter(value = "tipoArquivoConverter")
public class TipoArquivoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        return new TipoArquivoRN().getTipoArquivo(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        return ((TipoArquivo)o).getIdTipoArquivo().toString();
    }
    
    
}
