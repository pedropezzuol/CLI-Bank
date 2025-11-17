package CLI;

public class TransferDTO {
    private int iban;
    private double amount;

    public TransferDTO(int iban, double amount) {
        this.iban = iban;
        this.amount = amount;
    }

    public int getIban() {
        return iban;
    }

    public double getAmount() {
        return amount;
    }

}
