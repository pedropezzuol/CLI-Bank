package Repository;

import Model.UserAccount;
import CLI.UserAccountDTO;

public interface AuthRepository {
    void createAccount(UserAccount user);
    void login();
}
