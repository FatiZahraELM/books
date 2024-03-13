package fr.norsys.gestionlivresapi.DTO;

import jakarta.persistence.*;
import lombok.Data;
@Data

public class BookDto {


        private int id;

        private String title;

        private int price;


        private int author_id;

        public BookDto(int id,String title, int price, int author_id) {
            this.id=id;
            this.title = title;
            this.price = price;
            this.author_id = author_id;
        }

        public BookDto(){

        }

        public int getId() {
            return id;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }



}
