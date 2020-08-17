package whatevername;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;

public interface StudentCommand extends Handler {
    default Dao<Student, Integer> dao() throws SQLException {
        return DaoManager.createDao(DatabaseUtils.CONNECTION_SOURCE, Student.class);
    }
}