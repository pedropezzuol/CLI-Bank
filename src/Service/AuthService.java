package Service;

import CLI.UserAccountDTO;
import Model.UserAccount;
import Repository.AuthRepository;
import Repository.Impl.AuthRepositoryImpl;

public class AuthService {
    private AuthRepository authRepository = new AuthRepositoryImpl();

    public AuthService(){}

    private static UserAccount setUser(UserAccountDTO userAccountDTO){
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(userAccountDTO.getEmail());
        userAccount.setPassword(userAccountDTO.getPassword());

        return userAccount;
    }

    public void createAccount(UserAccountDTO userAccountDTO){
        UserAccount userAccount = AuthService.setUser(userAccountDTO);
        authRepository.save(userAccount);
    }

    public UserAccount login(UserAccountDTO userAccountDTO){
        UserAccount userAccount = AuthService.setUser(userAccountDTO);
        UserAccount user = authRepository.findByEmailAndPassword(userAccount);
        if(user == null){
            System.out.println("Invalid email or password");
            return null;
        }
        return user;
    }
}
