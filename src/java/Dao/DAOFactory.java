package Dao;

import Util.HibernateUtil;

/**
 *
 * @author Bruno
 */
public class DAOFactory {

    public static ArquivoDAO criarArquivoDAO() {
        ArquivoDAO arquivoDAO = new ArquivoDAOHib();
        arquivoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return arquivoDAO;
    }

    public static CaixaDAO criarCaixaDAO() {
        CaixaDAO caixaDAO = new CaixaDAOHib();
        caixaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return caixaDAO;
    }

    public static EstanteDAO criarEstanteDAO() {
        EstanteDAO estanteDAO = new EstanteDAOHib();
        estanteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return estanteDAO;
    }

    public static PermissaoDAO criarPermissaoDAO() {
        PermissaoDAO permissaoDAO = new PermissaoDAOHib();
        permissaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return permissaoDAO;
    }

    public static PrateleiraDAO criarPrateleiraDAO() {
        PrateleiraDAO prateleiraDAO = new PrateleiraDAOHib();
        prateleiraDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return prateleiraDAO;
    }

    public static PredioDAO criarPredioDAO() {
        PredioDAO predioDAO = new PredioDAOHib();
        predioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return predioDAO;
    }

    public static SalaDAO criarSalaDAO() {
        SalaDAO salaDAO = new SalaDAOHib();
        salaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return salaDAO;
    }

    public static SetorDAO criarSetorDAO() {
        SetorDAO setorDAO = new SetorDAOHib();
        setorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return setorDAO;
    }

    public static UsuarioDAO criarUsuarioDAO() {
        UsuarioDAO usuarioDAO = new UsuarioDAOHib();
        usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
}
