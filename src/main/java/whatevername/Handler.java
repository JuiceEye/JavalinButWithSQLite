package whatevername;

import java.sql.SQLException;
import java.util.List;

public interface Handler {
    Handler create(Object object) throws SQLException;
    Object read(int id) throws SQLException;
    Handler update(Object object) throws SQLException;
    Handler delete(int id) throws SQLException;
    List<Student> getAll() throws SQLException;
}

