package Service;

import Repository.AuthRepository;
import Repository.Impl.AuthRepositoryImpl;

public class AuthService {
    private AuthRepository authRepository;

    public AuthService(AuthRepository authRepository){
        this.authRepository = new AuthRepositoryImpl();
    }

    public void createAccount(){

    }
}
