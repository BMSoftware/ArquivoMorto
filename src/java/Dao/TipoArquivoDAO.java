package Dao;

import Entidade.TipoArquivo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface TipoArquivoDAO {
public void setSession(Session session);

    public void salvar(TipoArquivo tipoArquivo);

    public void atualizar(TipoArquivo tipoArquivo);

    public void excluir(TipoArquivo tipoArquivo);

    public TipoArquivo getTipoArquivo(Integer idTipoArquivo);

    public List<TipoArquivo> list();    
}
