package ShoppingMall.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDTO {

    private String name;
    private int deposit;
    private int withdraw;
    private String bankingAt;

    @Override
    public String toString() {
        return "AccountDTO{" +
                ", name='" + name + '\'' +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }

    public AccountDTO(String name, int deposit, int withdraw) {
        this.name = name;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankingAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy.MM.dd.HH:mm"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(int withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }
}
