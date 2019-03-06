package model.entity;

/**
 * Created by User on 26.02.2019.
 */
public class User {

    public enum ROLE{
        UNKNOWN,
        USER,
        ADMIN
    }

    private long idUser;
    private String name;
    private String login;
    private ROLE role;

    private User(Builder builder) {
        this.idUser = builder.idUser;
        this.name = builder.name;
        this.login = builder.login;
        this.role = builder.role;
    }

    public long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role.toString();
    }

    static class Builder {
        private long idUser;
        private String name;
        private String login;
        private ROLE role;

        public Builder setIdUser(long id) {
            this.idUser = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setRole(String stringRole) {
            this.role = ROLE.valueOf(stringRole.toUpperCase());
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
