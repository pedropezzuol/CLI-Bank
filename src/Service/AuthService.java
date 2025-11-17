package Service;

import CLI.UserAccountDTO;
import Model.UserAccount;
import Repository.UserRepo;
import Repository.Impl.UserRepoImpl;

import java.util.Optional;

public class AuthService {
    private UserRepo userRepoImpl = new UserRepoImpl();

    public AuthService(){}

    private static UserAccount setUser(UserAccountDTO userAccountDTO){
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(userAccountDTO.getEmail());
        userAccount.setPassword(userAccountDTO.getPassword());

        return userAccount;
    }

    public void createAccount(UserAccountDTO userAccountDTO){
        UserAccount userAccount = setUser(userAccountDTO);
        Optional<UserAccount> userChecked = userRepoImpl.findByEmail(userAccount);
        if(userChecked.isPresent()){
            System.out.println("Email already exist");
            return;
        }
        userAccount.setIban(userRepoImpl.createIBAN());
        userRepoImpl.save(userAccount);
    }

    public Optional<UserAccount> login(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = setUser(userAccountDTO);
        return userRepoImpl.findByEmailAndPassword(userAccount);
    }
}
