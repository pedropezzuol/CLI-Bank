package Repository;

import Model.UserAccount;

import java.util.Optional;

public interface UserRepo {
    void save(UserAccount user);
    int createIBAN();
    Optional<UserAccount> findByEmailAndPassword(UserAccount user);
    Optional<UserAccount> findByEmail(UserAccount user);
    Optional<UserAccount> findByIban(int iban);
    void deleteAccount();
}
