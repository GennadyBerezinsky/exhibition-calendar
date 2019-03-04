package model.entity;

/**
 * Created by User on 26.02.2019.
 */



public class User {

    public enum ROLE{
        USER,
        ADMIN
    }

    private String login;
    private ROLE role;

    private User(Builder builder) {
        this.login = builder.login;
        this.role = builder.role;
    }

    static class Builder {
        private String login;
        private ROLE role;

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setRole(ROLE role) {
            this.role = role;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
