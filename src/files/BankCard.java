package files;

import java.util.List;

public class BankCard {

    private String name, fio;
    private int number, validity, code, sum;

    BankCard() {
        this.name = "name";
        this.number = 0;
        this.validity = 0;
        this.fio = "fio";
        this.code = 0;
        this.sum = 0;
    }
    BankCard(String name, int number, int validity, String fio, int code, int sum) {
        this.name = name;
        this.number = number;
        this.validity = validity;
        this.fio = fio;
        this.code = code;
        this.sum = sum;
    }

    public int getNumber() {
        return number;
    }
    public String getParams() {
        return name + "/" + number + "/" + validity + "/" + fio + "/" + code + "/" + sum + "\n";
    }
    public int codeToValidity (int code, List<BankCard> cards) {
        for (BankCard bankCard : cards) {
            if (bankCard.code == code) {
                return bankCard.validity;
            }
        }
        return -1;
    }
    public boolean sameNames (BankCard b1, BankCard b2) {
        if (b1.name == b2.name) {
            return true;
        }
        return false;
    }
}
