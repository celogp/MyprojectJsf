package utilitarios;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final String PERSISTENCE_UNIT_NAME = "MyprojectJsf";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
    
    public static Object getPrimaryKey(Object entidade) {
    	return factory.getPersistenceUnitUtil().getIdentifier(entidade);
    }
	
    public static String getEntityName(Object entidade) {
    	return entidade.getClass().getSimpleName();
    }
	
}
