package es.ir.minipim.ui;

import es.ir.minipim.entity.Account;
import es.ir.minipim.entity.AttributeType;
import es.ir.minipim.entity.Product;

import java.time.Instant;


public class RelationshipUI {
    private String name;
    private Integer product_1;
    private Integer product_2;
    private Account account;
    private Integer idRelationship;

    public RelationshipUI() {
        this.name = "";
        this.product_1 = -1;
        this.product_2 = -1;
        this.account = new Account();
        this.idRelationship = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getProduct_1() {return product_1;}
    public void setProduct_1(Integer product_1) {this.product_1 = product_1;}

    public Integer getProduct_2() {return product_2;}
    public void setProduct_2(Integer product_2) {this.product_2 = product_2;}

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getIdRelationship(){ return idRelationship;}
    public void setIdRelationship(Integer idRelationship) {this.idRelationship = idRelationship;}
}
