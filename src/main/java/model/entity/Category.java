package model.entity;

/**
 * Created by User on 05.03.2019.
 */


public class Category {
    private long idCat;
    private String name;

    private Category(Builder builder) {
        this.idCat = builder.idCat;
        this.name = builder.name;
    }

    public long getIdCat() {
        return idCat;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private long idCat = 0;
        private String name = "";

        public Builder setIdCat(long idCat) {
            this.idCat = idCat;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
