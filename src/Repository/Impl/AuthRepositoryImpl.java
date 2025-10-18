package Repository.Impl;

import Model.UserAccount;
import Repository.AuthRepository;

import java.util.ArrayList;

public class AuthRepositoryImpl implements AuthRepository {

    private ArrayList<UserAccount> db = new ArrayList<>();

    public AuthRepositoryImpl() {}

    public void createAccount(UserAccount user){
        db.add(user);
        UserAccount one = db.getFirst();
        System.out.println(one.getEmail() + one.getPassword());
    }

    public void login(){

    }
}
