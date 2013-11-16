package Beans;

import Entidade.Caixa;
import RegraDeNegocio.CaixaRN;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "caixaConverter")
@FacesConverter(value = "caixaConverter")
public class CaixaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return new CaixaRN().getCaixa(new Integer(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Caixa) o).getIdCaixa().toString();
    }
}
