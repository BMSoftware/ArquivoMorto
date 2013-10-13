package Util;

import Entidade.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Bruno
 */
public class GeraTabelas {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            AnnotationConfiguration ac = new AnnotationConfiguration();
            ac.addAnnotatedClass(Arquivo.class);
            ac.addAnnotatedClass(Caixa.class);
            ac.addAnnotatedClass(Estante.class);
            ac.addAnnotatedClass(Permissao.class);
            ac.addAnnotatedClass(Prateleira.class);
            ac.addAnnotatedClass(Predio.class);
            ac.addAnnotatedClass(Sala.class);
            ac.addAnnotatedClass(Setor.class);
            ac.addAnnotatedClass(Usuario.class);
            sessionFactory = ac.configure().buildSessionFactory();
            SchemaExport se = new SchemaExport(ac);
            se.create(true, true);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
