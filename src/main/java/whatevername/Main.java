package whatevername;

import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        app.get("/students", context -> {
            context.result(new StudentHandler().getAll().toString());
        });
        app.get("/student/:id", context -> {
            context.result(new StudentHandler().read(Integer.parseInt(context.pathParam("id"))).toString());
        });
        app.post("/student/:id/:firstName/:lastName", context -> {
            context.result(new StudentHandler().create(new Student(Integer.parseInt(context.pathParam("id")), context.pathParam("firstName"), context.pathParam("lastName"))).toString());
        });
        app.patch("/student/:id/:firstName/:lastName", context -> {
            context.result(new StudentHandler().update(new Student(Integer.parseInt(context.pathParam("id")), context.pathParam("firstName"), context.pathParam("lastName"))).toString());
        });
        app.delete("/student/:id", context -> {
            context.result(new StudentHandler().delete(Integer.parseInt(context.pathParam("id"))).toString());
        });
        app.start(8080);
    }

    private static Handler parseLine(String line) throws SQLException {
        //create student 1 John Doe

        //update student 1 Jane Doe

        //delete student 1

        //read student 1
        Scanner scanner = new Scanner(line);
        String first = scanner.next();
        switch (first) {
            case CREATE:
                return createCommand(scanner);
            case READ:
                return readCommand(scanner);
            case UPDATE:
                return updateCommand(scanner);
            case DELETE:
                return deleteCommand(scanner);
            default:
                throw new RuntimeException("Not supported yet.");
        }
    }

    private static Handler createCommand(Scanner scanner) throws SQLException {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            String firstName = scanner.next();
            String lastName = scanner.next();
            return new StudentHandler().create(new Student(id, firstName, lastName));
        } else throw new RuntimeException("Not supported yet.");
    }

    private static Handler readCommand(Scanner scanner) throws SQLException {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            return (Handler) new StudentHandler().read(id);
        } else throw new RuntimeException("Not supported yet.");
    }

    private static Handler updateCommand(Scanner scanner) throws SQLException {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            String firstName = scanner.next();
            String lastName = scanner.next();
            return new StudentHandler().update(new Student(id, firstName, lastName));
        } else throw new RuntimeException("Not supported yet.");
    }

    private static Handler deleteCommand(Scanner scanner) throws SQLException {
        String className = scanner.next();
        if (className.equals(CLASS_STUDENT)) {
            int id = scanner.nextInt();
            return new StudentHandler().delete(id);
        } else throw new RuntimeException("Not supported yet.");
    }

    private static final String CREATE = "create";
    private static final String READ = "read";
    private static final String UPDATE = "update";
    private static final String DELETE = "delete";
    private static final String CLASS_STUDENT = "student";
}
