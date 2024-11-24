package es.ir.minipim.ui;

import es.ir.minipim.entity.Account;
import es.ir.minipim.entity.AttributeType;

import java.time.Instant;


public class CategoryUI {
    private String name;
    private Instant date;
    private Account account;
    private Integer idCategory;

    public CategoryUI() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Instant getDate() {
        return date;
    }
    public void setDate(Instant date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getIdCategory(){ return idCategory;}
    public void setIdCategory(Integer idCategory) {this.idCategory = idCategory;}
}
