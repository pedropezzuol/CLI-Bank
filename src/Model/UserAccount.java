package Model;

public class UserAccount {
    private String email;
    private String password;
    private String iban;
    private Double balance;

    public UserAccount(String email, String iban, String password, Double balance){
        this.email = email;
        this.iban = iban;
        this.password = password;
        this.balance = balance;
    }
}