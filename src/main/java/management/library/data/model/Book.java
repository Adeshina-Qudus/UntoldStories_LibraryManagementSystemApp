package management.library.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Book {
    @Id
    private String bookId;
    private String bookTitle;
    private String bookAurthor;
    private String yearOfPublication;

}
