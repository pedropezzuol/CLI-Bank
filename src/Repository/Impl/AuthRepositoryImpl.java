package Repository.Impl;

import Model.UserAccount;
import Repository.AuthRepository;

import java.util.ArrayList;

public class AuthRepositoryImpl implements AuthRepository {

    private ArrayList<UserAccount> db = new ArrayList<>();

    public void createAccount(UserAccount user){
        db.add(user);
    }

    public void login(){

    }
}
