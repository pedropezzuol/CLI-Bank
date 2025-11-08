package Model;

public class UserAccount {
    private String email;
    private String password;
    private int iban;
    private Double balance;

    public UserAccount() {}

    public UserAccount(String email, int iban, String password, Double balance){
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

    public int getIban() {
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

    public void setIban(int iban) {
        this.iban = iban;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}