package management.library.services;

import management.library.data.model.Librarian;
import management.library.data.repository.LibrarianRepository;
import management.library.dtos.request.BookRequest;
import management.library.dtos.request.LoginRequest;
import management.library.dtos.request.RegisterRequest;
import management.library.exceptions.InvalidDetailsException;
import management.library.exceptions.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static management.library.utils.Mapper.map;

@Service
public class LibrarianServiceImpl  implements  LibrarianService{

    @Autowired
    public LibrarianRepository librarianRepository;
    @Override
    public void register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUsername())) throw new UserExistException(registerRequest.getUsername()
                +" User Already Exist");
        Librarian librarian = map(registerRequest);
        librarianRepository.save(librarian);
    }
    private boolean userExist(String userName) {
        Librarian foundUser =  librarianRepository.findByName(userName);
        return foundUser != null;
    }
    @Override
    public void login(LoginRequest loginRequest) {
        Librarian librarian = librarianRepository.findByName(loginRequest.getUsername());
        if (!userExist(loginRequest.getUsername())) throw new InvalidDetailsException();
        if (!librarian.getPassword().equals(loginRequest.getPassword())) throw new InvalidDetailsException();
        librarian.setLocked(false);
        librarianRepository.save(librarian);
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
