package by.teachmeskills.lesson30.dto;

import java.math.BigDecimal;

public class Product {

    private final Integer id;
    private final String name;
    private CategoryEnum category;
    private BigDecimal price;
    private String shop;
    private double weight;
    private double size;

    Product(Integer id, String name, CategoryEnum category, BigDecimal price, String shop, double weight, double size) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.shop = shop;
        this.weight = weight;
        this.size = size;
    }

    public static ProductBuilder builder(Integer id, String name) {
        return new ProductBuilder().id(id).name(name);
    }

    public static class ProductBuilder {
        private Integer id;
        private String name;
        private CategoryEnum category;
        private BigDecimal price;
        private String shop;
        private double weight;
        private double size;

        ProductBuilder() {
        }

        private ProductBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        private ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder category(CategoryEnum category) {
            this.category = category;
            return this;
        }

        public ProductBuilder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder shop(String shop) {
            this.shop = shop;
            return this;
        }

        public ProductBuilder weight(double weight) {
            this.weight = weight;
            return this;
        }

        public ProductBuilder size(double size) {
            this.size = size;
            return this;
        }

        public Product build() {
            return new Product(id, name, category, price, shop, weight, size);
        }

        public String toString() {
            return "Product.ProductBuilder(id=" + this.id + ", name=" + this.name + ", category=" + this.category + ", price=" + this.price + ", shop=" + this.shop + ", weight=" + this.weight + ", size=" + this.size + ")";
        }
    }


//    public Product(Integer id, String name, CategoryEnum category, BigDecimal price, String shop, double weight, double size) {
//        this.id = id;
//        this.name = name;
//        this.category = category;
//        this.price = price;
//        this.shop = shop;
//        this.weight = weight;
//        this.size = size;
//    }
//
//    public Product(Integer id, String name, CategoryEnum category, BigDecimal price, String shop, double weight) {
//        this.id = id;
//        this.name = name;
//        this.category = category;
//        this.price = price;
//        this.shop = shop;
//        this.weight = weight;
//    }
//
//    public Product(Integer id, String name, CategoryEnum category) {
//        this.id = id;
//        this.name = name;
//        this.category = category;
//    }
//
//    public Product(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
