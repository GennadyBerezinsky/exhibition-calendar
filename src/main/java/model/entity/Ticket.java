package model.entity;

/**
 * Created by User on 06.03.2019.
 */


public class Ticket {
    private long idTicket;
    private long idExpo;
    private long idUser;

    public Ticket(Builder builder) {
        this.idTicket = builder.idTicket;
        this.idExpo = builder.idExpo;
        this.idUser = builder.idUser;
    }

    public long getIdTicket() {
        return idTicket;
    }

    public long getIdExpo() {
        return idExpo;
    }

    public long getIdUser() {
        return idUser;
    }

    public static class Builder {
        private long idTicket = 0;
        private long idExpo = 0;
        private long idUser = 0;

        public Builder setIdTicket(long idTicket) {
            this.idTicket = idTicket;
            return this;
        }

        public Builder setIdExpo(long idExpo) {
            this.idExpo = idExpo;
            return this;
        }

        public Builder setIdUser(long idUser) {
            this.idUser = idUser;
            return this;
        }

        public Ticket build(){
            return new Ticket(this);
        }
    }

}
