package management.library.utils;

import management.library.data.model.Librarian;
import management.library.dtos.request.RegisterRequest;
import management.library.exceptions.*;

public class Mapper {
    public static Librarian map(RegisterRequest registerRequest) {
        Librarian librarian = new Librarian();
        librarian.setName(registerRequest.getUsername());
        librarian.setPassword(registerRequest.getPassword());
        if (registerRequest.getPassword().length() != 4) throw new InvalidDetailsException();
        return librarian;
    }
}
