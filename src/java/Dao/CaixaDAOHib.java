package Dao;

import Entidade.Caixa;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class CaixaDAOHib implements CaixaDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Caixa caixa) {
        this.session.save(caixa);
    }

    @Override
    public void atualizar(Caixa caixa) {
        this.session.update(caixa);
    }

    @Override
    public void excluir(Caixa caixa) {
        this.session.delete(caixa);
    }

    @Override
    public Caixa getCaixa(Integer idCaixa) {
        return (Caixa) this.session.get(Caixa.class, idCaixa);
    }

    @Override
    public List<Caixa> list() {
        Query query = this.session.createQuery("from Caixa c order by c.nomeCaixa asc");
        return query.list();
    }

    @Override
    public List<Caixa> listPredio(String nomePredio) {
        Query query = this.session.createQuery("from Caixa c WHERE "
                + "c.prateleira.estante.sala.predio.nomePredio LIKE :nomePredio "
                + "ORDER BY c.prateleira.estante.sala.predio.nomePredio asc, "
                + "c.nomeCaixa desc");
        query.setParameter("nomePredio", "%" + nomePredio + "%");
        return query.list();
    }

    @Override
    public List<Caixa> listSetor(String nomeSetor) {
        Query query = this.session.createQuery("from Caixa c where "
                + "c.setor.nomeSetor LIKE :nomeSetor ORDER BY c.setor.nomeSetor asc,"
                + "c.nomeCaixa desc");
        query.setParameter("nomeSetor", "%" + nomeSetor + "%");
        return query.list();
    }

    @Override
    public List<Caixa> listUsuario(String nomeUsuario) {
        Query query = this.session.createQuery("from Caixa c where "
                + "c.usuarioArquivou.nomeUsuario LIKE :nomeUsuario order by "
                + "c.usuarioArquivou.nomeUsuario asc, c.dataArquivamentoCaixa desc");
        query.setParameter("nomeUsuario", "%" + nomeUsuario + "%");
        return query.list();
    }
}
