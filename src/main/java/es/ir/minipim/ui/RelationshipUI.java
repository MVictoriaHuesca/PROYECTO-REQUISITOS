package es.ir.minipim.ui;

import es.ir.minipim.entity.Account;
import es.ir.minipim.entity.AttributeType;
import es.ir.minipim.entity.Product;

import java.time.Instant;


public class RelationshipUI {
    private String name;
    private Product product_1;
    private Product product_2;
    private Account account;
    private Integer idRelationship;

    public RelationshipUI() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct_1() {return product_1;}
    public void setProduct_1(Product product_1) {this.product_1 = product_1;}

    public Product getProduct_2() {return product_2;}
    public void setProduct_2(Product product_2) {this.product_2 = product_2;}

    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getIdRelationship(){ return idRelationship;}
    public void setIdRelationship(Integer idRelationship) {this.idRelationship = idRelationship;}
}
