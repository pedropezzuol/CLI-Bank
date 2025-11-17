package Repository.Impl;

import Model.UserAccount;
import Repository.UserRepo;

import java.util.ArrayList;
import java.util.Optional;

public class UserRepoImpl implements UserRepo {

    private static ArrayList<UserAccount> db = new ArrayList<>();

    private static int iban;

    public UserRepoImpl() {}

    public int createIBAN(){
        return iban++;
    }

    public void save(UserAccount user){
        db.add(user);
    }

    public Optional<UserAccount> findByEmail(UserAccount user){
        System.out.println("cu");
        for (UserAccount u : db){
            if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public Optional<UserAccount> findByEmailAndPassword(UserAccount user){
        for (UserAccount u : db){
            if (u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public Optional<UserAccount> findByIban(int iban) {
        for(UserAccount u : db){
            if(u.getIban() == iban){
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public void deleteAccount(){

    }
}
