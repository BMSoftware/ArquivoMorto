package Dao;

import Entidade.Arquivo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public interface ArquivoDAO {

    public void setSession(Session session);

    public void salvar(Arquivo arquivo);

    public void atualizar(Arquivo arquivo);

    public void excluir(Arquivo arquivo);

    public Arquivo getArquivo(Integer idArquivo);

    public List<Arquivo> list();
    
    public List<Arquivo> listTipoArquivo(String descricao);
    
    public List<Arquivo> listUsuario(String nomeUsuario);
    
    public List<Arquivo> listCaixa (String nomeCaixa);
}
