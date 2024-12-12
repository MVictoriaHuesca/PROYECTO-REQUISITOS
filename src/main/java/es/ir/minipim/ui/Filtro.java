package es.ir.minipim.ui;

import es.ir.minipim.entity.Category;

public class Filtro {

    protected Integer category;
    protected Integer price;

    public Filtro() {
        this.category = -1;
        this.price = -1;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean estaVacio() {
        return this.category == null || this.category<=0;

    }
}
