package Model;

public class UserAccount {
    private String email;
    private String password;
    private String iban;
    private Double balance;

    public UserAccount() {}

    public UserAccount(String email, String iban, String password, Double balance){
        this.email = email;
        this.iban = iban;
        this.password = password;
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getIban() {
        return iban;
    }

    public Double getBalance() {
        return balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}