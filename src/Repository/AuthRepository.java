package Repository;

import Model.UserAccount;

public interface AuthRepository {
    void save(UserAccount user);
    UserAccount findByEmailAndPassword(UserAccount user);
}
