package model.exception;

/**
 * Created by User on 10.04.2019.
 */


public class PaymentTransactionException extends Exception {
    String mes;

    public PaymentTransactionException(String mes) {
        super(mes);
        this.mes = mes;
    }

}
