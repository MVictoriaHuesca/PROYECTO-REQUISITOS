package es.ir.minipim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Integer id;

    @Column(name = "account_name", nullable = false, length = 50)
    private String accountName;

    @Column(name = "email_address", nullable = false, length = 50)
    private String emailAddress;

    @Column(name = "account_profile_picture", length = 64)
    private String accountProfilePicture;

    @ColumnDefault("(now())")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToMany
    @JoinTable(name = "account_attribute",
            joinColumns = @JoinColumn(name = "account_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id_fk"))
    private List<Attribute> attributes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "account_category",
            joinColumns = @JoinColumn(name = "account_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "category_id_fk"))
    private List<es.ir.minipim.entity.Category> categories = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "account_product",
            joinColumns = @JoinColumn(name = "account_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "product_id_fk"))
    private List<es.ir.minipim.entity.Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "accountIdFk")
    private List<es.ir.minipim.entity.ProductAttribute> productAttributes = new ArrayList<>();

    @OneToMany(mappedBy = "accountIdFk")
    private List<es.ir.minipim.entity.ProductCategory> productCategories = new ArrayList<>();

}