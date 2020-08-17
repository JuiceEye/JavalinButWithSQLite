package whatevername;

import java.sql.SQLException;
import java.util.List;

public class StudentHandler implements StudentCommand {
    private Student student;

    public Student getStudent() {
        return student;
    }

    @Override
    public Handler create(Object student) throws SQLException {
        this.student = (Student) student;
        dao().create(this.student);
        System.out.println("Created student " + student);
        return null;
    }

    @Override
    public Object read(int id) throws SQLException {
        student = dao().queryForId(id);
        System.out.println(student);
        return student;
    }

    @Override
    public Handler update(Object student) throws SQLException {
        this.student = (Student) student;
        dao().update(this.student);
        System.out.println("Updated student " + student);
        return null;
    }

    @Override
    public Handler delete(int id) throws SQLException {
        student = dao().queryForId(id);
        System.out.println("Deleted" + student);
        dao().delete(student);
        return null;
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return dao().queryForAll();
    }
}
