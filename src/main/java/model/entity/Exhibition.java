package model.entity;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by User on 05.03.2019.
 */


public class Exhibition {
    private long idExpo;
    private long idCategory;
    private long idHall;
    private String name;
    private Date date;
    private long price;

    private String hallName;
    private String catName;

    private Exhibition(Builder builder) {
        this.idExpo = builder.idExpo;
        this.idCategory = builder.idCategory;
        this.idHall = builder.idHall;
        this.name = builder.name;
        this.date = builder.date;
        this.price = builder.price;
        this.catName = builder.catName;
        this.hallName = builder.hallName;
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

    public long getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public String getHallName() {
        return hallName;
    }

    public String getCatName() {
        return catName;
    }

    public static class Builder {
        private long idExpo = 0;
        private long idCategory = 0;
        private long idHall = 0;
        private String name = "";
        private Date date = Date.valueOf(LocalDate.now());
        private long price = 0;

        private String hallName = "";
        private String catName = "";

        public Builder setHallName(String hallName) {
            this.hallName = hallName;
            return this;
        }

        public Builder setCatName(String catName) {
            this.catName = catName;
            return this;
        }

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

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setPrice(long price) {
            this.price = price;
            return this;
        }

        public Exhibition build() {
            return new Exhibition(this);
        }
    }
}
