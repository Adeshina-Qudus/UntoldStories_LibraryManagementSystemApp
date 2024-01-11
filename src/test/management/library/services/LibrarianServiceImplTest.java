package management.library.services;

import management.library.data.repository.LibrarianRepository;
import management.library.dtos.request.LoginRequest;
import management.library.dtos.request.RegisterRequest;
import management.library.exceptions.InvalidDetailsException;
import management.library.exceptions.UserExistException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class LibrarianServiceImplTest {

    @Autowired
    private LibrarianService librarianService;
    @Autowired
    private LibrarianRepository librarianRepository;

    @AfterEach
    public void doThisAfterEachTest(){
        librarianRepository.deleteAll();
    }
    @Test
    public void registerUserAndNumberOfUsersIsOneTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("holyChild");
        registerRequest.setPassword("1234");
        librarianService.register(registerRequest);
        assertEquals(1,librarianRepository.count());
    }
    @Test
    public void registerUserAndPasswordMustNotGoBeyond4Test(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("holy");
        registerRequest.setPassword("1223442");
        assertThrows(InvalidDetailsException.class, ()->librarianService.register(registerRequest));
    }
    @Test
    public void registerAccountWithAnExistingUserName(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("jamming");
        registerRequest.setPassword("1234");
        librarianService.register(registerRequest);
        registerRequest.setUsername("jamming");
        registerRequest.setPassword("1232");
        assertThrows(UserExistException.class, ()-> librarianService.register(registerRequest));
    }
    @Test
    public void registerAccountLoginWithCorrectDetails(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("jamming");
        registerRequest.setPassword("1234");
        librarianService.register(registerRequest);
        loginRequest.setUsername("jamming");
        loginRequest.setPassword("1234");
        librarianService.login(loginRequest);
    }
    @Test
    public void registerAccountLoginWithWrongUserNameDetails(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("jamming");
        registerRequest.setPassword("1234");
        librarianService.register(registerRequest);
        loginRequest.setUsername("jamin");
        loginRequest.setPassword("1234");
        assertThrows(InvalidDetailsException.class , () ->librarianService.login(loginRequest));
    }
    @Test
    public void registerAccountLoginWithWrongPasswordDetails(){
        RegisterRequest registerRequest = new RegisterRequest();
        LoginRequest loginRequest = new LoginRequest();
        registerRequest.setUsername("jamming");
        registerRequest.setPassword("1234");
        librarianService.register(registerRequest);
        loginRequest.setUsername("jamming");
        loginRequest.setPassword("1233");
        assertThrows(InvalidDetailsException.class, () ->librarianService.login(loginRequest));
    }

}
