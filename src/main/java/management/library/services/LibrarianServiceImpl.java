package management.library.services;

import management.library.dtos.request.BookRequest;
import management.library.dtos.request.LoginRequest;
import management.library.dtos.request.RegisterRequest;

public class LibrarianServiceImpl  implements  LibrarianService{
    @Override
    public void register(RegisterRequest registerRequest) {

    }

    @Override
    public void login(LoginRequest loginRequest) {

    }

    @Override
    public boolean lendBooks(BookRequest bookRequest) {
        return false;
    }

    @Override
    public void addBooks(BookRequest bookRequest) {

    }

    @Override
    public void checkBooks(BookRequest bookRequest) {

    }

    @Override
    public void returnBook(BookRequest bookRequest) {

    }
}
