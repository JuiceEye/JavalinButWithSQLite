package whatevername;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class StudentGroup {
    @DatabaseField(id = true)
    private long id;
    @DatabaseField()
    private String name;
}
