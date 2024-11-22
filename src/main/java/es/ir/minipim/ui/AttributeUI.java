package es.ir.minipim.ui;

import es.ir.minipim.entity.Account;
import es.ir.minipim.entity.Attribute;
import es.ir.minipim.entity.AttributeType;

import java.sql.Timestamp;
import java.time.Instant;

public class AttributeUI {
    private String name;
    private AttributeType type;
    private Instant date;
    private Account account;
    private Integer idAttribute;

    public AttributeUI() {
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

    public Integer getIdAttribute(){ return  idAttribute;}
    public void setIdAttribute(Integer idAttribute) {this.idAttribute = idAttribute;}
}
