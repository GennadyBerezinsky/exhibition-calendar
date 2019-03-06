package model.entity;

/**
 * Created by User on 05.03.2019.
 */


public class ExhibitionHall {
    private long id;
    private String nameHall;
    private String address;

    private ExhibitionHall(Builder builder) {
        this.id = builder.id;
        this.nameHall = builder.nameHall;
        this.address = builder.address;
    }

    public long getId() {
        return id;
    }

    public String getNameHall() {
        return nameHall;
    }

    public String getAddress() {
        return address;
    }

    static class Builder {
        private long id = 0;
        private String nameHall = "";
        private String address = "";



        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setNameHall(String nameHall) {
            this.nameHall = nameHall;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ExhibitionHall build() {
            return new ExhibitionHall(this);
        }
    }


}
