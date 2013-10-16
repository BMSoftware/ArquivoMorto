package Dao;

import Util.HibernateUtil;

/**
 *
 * @author Bruno
 */
public class DAOFactory {
    
    public static UsuarioDAO criarUsuarioDAO(){
        UsuarioDAO usuarioDAO = new UsuarioDAOImp();
        usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
}
