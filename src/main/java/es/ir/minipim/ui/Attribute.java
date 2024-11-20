package es.ir.minipim.ui;

import java.util.Date;

public class Attribute {
    private String name;
    private String type;
    private Date date;

    public Attribute() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
