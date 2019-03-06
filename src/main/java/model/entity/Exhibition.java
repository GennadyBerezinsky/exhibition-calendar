package model.entity;

import java.time.LocalDate;

/**
 * Created by User on 05.03.2019.
 */


public class Exhibition {
    private long idExpo;
    private long idCategory;
    private long idHall;
    private String name;
    private LocalDate date;

    private Exhibition(Builder builder) {
        this.idExpo = builder.idExpo;
        this.idCategory = builder.idCategory;
        this.idHall = builder.idHall;
        this.name = builder.name;
        this.date = builder.date;
    }

    public long getIdExpo() {
        return idExpo;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public long getIdHall() {
        return idHall;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public static class Builder {
        private long idExpo = 0;
        private long idCategory = 0;
        private long idHall = 0;
        private String name = "";
        private LocalDate date = LocalDate.now();

        public Builder setIdExpo(long idExpo) {
            this.idExpo = idExpo;
            return this;
        }

        public Builder setIdCategory(long idCategory) {
            this.idCategory = idCategory;
            return this;
        }

        public Builder setIdExhibitionHall(long idHall) {
            this.idHall = idHall;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Exhibition build() {
            return new Exhibition(this);
        }
    }
}
