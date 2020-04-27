package au.master.foundation.mc.master_bank.services.exceptions;

public class SameAccountsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public SameAccountsException(String msg){ super(msg); }

    public SameAccountsException(String msg, Throwable cause){
        super(msg,cause);
    }
}
