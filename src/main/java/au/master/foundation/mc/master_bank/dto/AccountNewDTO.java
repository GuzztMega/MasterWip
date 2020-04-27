package au.master.foundation.mc.master_bank.dto;

import java.util.Random;

public class AccountNewDTO {

    private Random rand = new Random();

    private Integer type;
    private Double balance;

    AccountNewDTO(){}

    public String newAgency() {
        char[] vet = new char[4];

        for (int i=0; i<4; i++){
            vet[i] = (char) (rand.nextInt(10) + 48);
        }
        return new String(vet).concat("-"
                +((char) (rand.nextInt(10) + 48)));
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
