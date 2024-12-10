package es.ir.minipim.ui;

import es.ir.minipim.entity.Category;

public class Filtro {

    protected Category category;

    public Filtro() {
        this.category = null;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
