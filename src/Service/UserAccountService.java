package Service;

import Model.UserAccount;
import Repository.Impl.UserRepoImpl;
import Repository.UserRepo;

import java.util.ArrayList;
import java.util.Optional;

public class UserAccountService {
    private final UserRepo  userRepoImpl = new UserRepoImpl();

    public UserAccountService(){}

    public boolean transfer(UserAccount user, int iban, double amount){
        if(user.getBalance() < amount){
            return false;
        }

        Optional<UserAccount> optionalReceiver = userRepoImpl.findByIban(iban);
        if(optionalReceiver.isEmpty()){
            System.out.println("User not found");
            return false;
        }
        UserAccount receiver = optionalReceiver.get();

        user.setBalance(user.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        return true;

    }

    public boolean deleteAccount(int iban){
        return userRepoImpl.deleteAccount(iban);
    }

    public ArrayList<UserAccount> getAllUsers(){
        return userRepoImpl.getAllUsers();
    }
}
