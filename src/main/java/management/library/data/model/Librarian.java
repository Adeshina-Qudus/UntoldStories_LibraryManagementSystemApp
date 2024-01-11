package management.library.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Librarian {

    @Id
    private String userId;
    private String name;
    private String password;
    private boolean isLocked = true;
}
