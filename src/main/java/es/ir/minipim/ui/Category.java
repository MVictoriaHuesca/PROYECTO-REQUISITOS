package es.ir.minipim.ui;

import java.util.Date;

public class Category {
    private String name;
    private Date date;
    private Integer idUser;
    private Integer idCategory;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdUser(){ return  idUser;}
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdCategory(){ return  idCategory;}
    public void setIdCategory(Integer idCategory) {this.idCategory = idCategory;}
}
