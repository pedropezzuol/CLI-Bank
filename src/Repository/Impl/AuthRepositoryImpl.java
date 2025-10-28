package Repository.Impl;

import Model.UserAccount;
import Repository.AuthRepository;

import java.util.ArrayList;

public class AuthRepositoryImpl implements AuthRepository {

    private ArrayList<UserAccount> db = new ArrayList<>();

    public AuthRepositoryImpl() {}

    public void save(UserAccount user){
        db.add(user);
    }

    public UserAccount findByEmailAndPassword(UserAccount user){
        for (UserAccount u : db){
            if (u.getEmail().equalsIgnoreCase(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
