/**
 * Created by jigme.dorji on 23/04/2020.
 */
package dhi.ca.ttpl.web.config;

import org.hibernate.dialect.MySQLDialect;


public class MySQLCustomDialect extends MySQLDialect {
    //region public method
    public MySQLCustomDialect() {
        super();
        registerHibernateType(-9, "string");
        registerHibernateType(0, "integer");
    }
    //endregion
}


