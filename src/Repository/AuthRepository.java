package Repository;

import Model.UserAccount;

public interface AuthRepository {
    void createAccount(UserAccount user);
    void login();
}
