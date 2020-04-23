package au.master.foundation.mc.master_bank.domain.enums;

public enum AccountType {

    CURRENT(1, "Current Account"),
    SAVINGS(2, "Savings Account");

    private int cod;
    private String description;

    AccountType(int cod, String description){
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static AccountType toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(AccountType x : AccountType.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid ID: "+cod);
    }
}
