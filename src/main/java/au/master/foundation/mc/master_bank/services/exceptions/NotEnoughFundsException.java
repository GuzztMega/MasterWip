package au.master.foundation.mc.master_bank.services.exceptions;

public class NotEnoughFundsException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NotEnoughFundsException(String msg){ super(msg); }

    public NotEnoughFundsException(String msg, Throwable cause){
        super(msg,cause);
    }
}
