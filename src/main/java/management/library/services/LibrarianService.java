package management.library.services;

import management.library.dtos.request.BookRequest;
import management.library.dtos.request.LoginRequest;
import management.library.dtos.request.RegisterRequest;

public interface LibrarianService {

    void register(RegisterRequest registerRequest);
    void login(LoginRequest loginRequest);
    boolean lendBooks(BookRequest bookRequest);
    void addBooks(BookRequest bookRequest);
    void checkBooks(BookRequest bookRequest);
    void returnBook(BookRequest bookRequest);

}
