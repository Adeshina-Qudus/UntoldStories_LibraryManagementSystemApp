package management.library.data.repository;

import management.library.data.model.Librarian;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibrarianRepository extends MongoRepository<Librarian, String> {

}
