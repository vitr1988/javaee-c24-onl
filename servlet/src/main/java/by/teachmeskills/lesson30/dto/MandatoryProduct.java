package by.teachmeskills.lesson30.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class MandatoryProduct {

    private final Integer id;
    private final String name;
    private CategoryEnum category;
    private BigDecimal price;
    private String shop;
    private double weight;
    private double size;

    MandatoryProduct(Integer id, String name, CategoryEnum category, BigDecimal price, String shop, double weight, double size) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.category = category;
        this.price = price;
        this.shop = shop;
        this.weight = weight;
        this.size = size;
    }

    public static MandatoryProductBuilder builder() {
        return new MandatoryProductBuilder();
    }


    public static class MandatoryProductBuilder {
        private Integer id;
        private String name;
        private CategoryEnum category;
        private BigDecimal price;
        private String shop;
        private double weight;
        private double size;

        MandatoryProductBuilder() {
        }

        public MandatoryProductBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public MandatoryProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public MandatoryProductBuilder category(CategoryEnum category) {
            this.category = category;
            return this;
        }

        public MandatoryProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public MandatoryProductBuilder shop(String shop) {
            this.shop = shop;
            return this;
        }

        public MandatoryProductBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public MandatoryProductBuilder size(double size) {
            this.size = size;
            return this;
        }

        public MandatoryProduct build() {
            return new MandatoryProduct(id, name, category, price, shop, weight, size);
        }

        public String toString() {
            return "MandatoryProduct.MandatoryProductBuilder(id=" + this.id + ", name=" + this.name + ", category=" + this.category + ", price=" + this.price + ", shop=" + this.shop + ", weight=" + this.weight + ", size=" + this.size + ")";
        }
    }
}
