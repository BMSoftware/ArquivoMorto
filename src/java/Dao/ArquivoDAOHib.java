package Dao;

import Entidade.Arquivo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class ArquivoDAOHib implements ArquivoDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Arquivo arquivo) {
        this.session.save(arquivo);
    }

    @Override
    public void atualizar(Arquivo arquivo) {
        this.session.update(arquivo);
    }

    @Override
    public void excluir(Arquivo arquivo) {
        this.session.delete(arquivo);
    }

    @Override
    public Arquivo getArquivo(Integer idArquivo) {
        return (Arquivo) this.session.get(Arquivo.class, idArquivo);
    }

    @Override
    public List<Arquivo> list() {
        Criteria criteria =  this.session.createCriteria(Arquivo.class);
        criteria.addOrder(Order.asc("conteudoArquivo"));
        return criteria.list();
    }

    @Override
    public List<Arquivo> listTipoArquivo(String descricao) {
        Criteria criteria = this.session.createCriteria(Arquivo.class);
        criteria.createAlias("tipoArquivo", "t");
        criteria.add(Restrictions.like("t.descricao", "%"+descricao+"%"));
        criteria.addOrder(Order.asc("t.descricao"));
        criteria.addOrder(Order.desc("conteudoArquivo"));
        return criteria.list();
    }

    @Override
    public List<Arquivo> listUsuario(String nomeUsuario) {
        Criteria criteria = this.session.createCriteria(Arquivo.class);
        criteria.createAlias("usuarioResponsavel", "u");
        criteria.add(Restrictions.like("u.nomeUsuario", "%"+nomeUsuario+"%"));
        criteria.addOrder(Order.asc("u.nomeUsuario"));
        criteria.addOrder(Order.desc("conteudoArquivo"));
        return criteria.list();
    }

    @Override
    public List<Arquivo> listCaixa(String nomeCaixa) {
        Criteria criteria = this.session.createCriteria(Arquivo.class);
        criteria.createAlias("caixa", "c");
        criteria.add(Restrictions.like("c.nomeCaixa", "%"+nomeCaixa+"%"));
        criteria.addOrder(Order.asc("c.nomeCaixa"));
        criteria.addOrder(Order.desc("conteudoArquivo"));
        return criteria.list();
    }
}
