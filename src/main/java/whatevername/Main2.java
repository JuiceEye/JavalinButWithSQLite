//Данные в таблицу записываются через body

package whatevername;

import io.javalin.Javalin;

import java.sql.SQLException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        app.get("/students", context -> {
            context.result(new StudentHandler().getAll().toString());
        });
        app.get("/student/:id", context -> {
            context.result(new StudentHandler().read(Integer.parseInt(context.pathParam("id"))).toString());
        });
        app.post("/student", context -> {
            Scanner request = new Scanner(context.body());
            int id = Integer.parseInt(request.next());
            String firstName = request.next();
            String lastName = request.next();
            new StudentHandler().create(new Student(id, firstName, lastName));
        });
        app.patch("/student", context -> {
            Scanner request = new Scanner(context.body());
            int id = Integer.parseInt(request.next());
            String firstName = request.next();
            String lastName = request.next();
            new StudentHandler().update(new Student(id, firstName, lastName));
        });
        app.delete("/student/:id", context -> {
            new StudentHandler().delete(Integer.parseInt(context.pathParam("id")));
        });
        app.start(8080);
    }
}
