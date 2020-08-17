package whatevername;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DatabaseUtils {
    public static String JDBC_CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Администратор\\Desktop\\database\\base.sqlite";

    public static ConnectionSource CONNECTION_SOURCE;

    static {
        try {
            CONNECTION_SOURCE = new JdbcConnectionSource(JDBC_CONNECTION_STRING);
            TableUtils.createTableIfNotExists(CONNECTION_SOURCE, Student.class);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
