package model.dao.mysql;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;

/**
 * Created by User on 07.03.2019.
 */


public class MySQLConnectionPoolHolder {
    private static final Logger log = Logger.getLogger(MySQLConnectionPoolHolder.class);
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if(dataSource==null){
            synchronized (MySQLConnectionPoolHolder.class){
                if(dataSource == null){
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl("jdbc:mysql://localhost:3306/exhibitions");
                    ds.setUsername("root");
                    ds.setPassword("18480322");
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    ds.setDriverClassName("com.mysql.jdbc.Driver");
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

}
