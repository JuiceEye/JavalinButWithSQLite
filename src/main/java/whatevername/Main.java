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
            new StudentHandler().create(new Student(Integer.parseInt(context.pathParam("id")), context.pathParam("firstName"), context.pathParam("lastName")));
        });
        app.patch("/student/:id/:firstName/:lastName", context -> {
            new StudentHandler().update(new Student(Integer.parseInt(context.pathParam("id")), context.pathParam("firstName"), context.pathParam("lastName")));
        });
        app.delete("/student/:id", context -> {
            new StudentHandler().delete(Integer.parseInt(context.pathParam("id")));
        });
        app.start(8080);
    }
}
