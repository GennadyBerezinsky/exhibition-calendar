package model.entity;

/**
 * Created by User on 06.03.2019.
 */


public class Payment {
    private long idPayment;
    private long idTicket;
    private long idUser;

    private Payment(Builder builder) {
        this.idPayment = builder.idPayment;
        this.idTicket = builder.idTicket;
        this.idUser = builder.idUser;
    }

    public static class Builder {
        private long idPayment = 0;
        private long idTicket = 0;
        private long idUser = 0;

        public Builder setIdPayment(long idPayment) {
            this.idPayment = idPayment;
            return this;
        }

        public Builder setIdTicket(long idTicket) {
            this.idTicket = idTicket;
            return this;
        }

        public Builder setIdUser(long idUser) {
            this.idUser = idUser;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }

}
