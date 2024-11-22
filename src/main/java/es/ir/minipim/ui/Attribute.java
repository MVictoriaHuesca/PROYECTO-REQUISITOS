package es.ir.minipim.ui;

import es.ir.minipim.entity2.AccountEntity;
import es.ir.minipim.entity2.AttributeType;

import java.sql.Timestamp;

public class Attribute {
    private String name;
    private AttributeType type;
    private Timestamp date;
    private AccountEntity account;
    private Integer idAttribute;

    public Attribute() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public AttributeType getType() {
        return type;
    }
    public void setType(AttributeType type) {
        this.type = type;
    }

    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    public AccountEntity getAccount() {
        return account;
    }
    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public Integer getIdAttribute(){ return  idAttribute;}
    public void setIdAttribute(Integer idAttribute) {this.idAttribute = idAttribute;}
}
