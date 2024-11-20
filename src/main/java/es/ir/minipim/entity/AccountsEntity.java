package es.ir.minipim.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "accounts", schema = "grupo05DB", catalog = "")
public class AccountsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id", nullable = false)
    private Integer accountId;
    @Basic
    @Column(name = "account_name", nullable = false, length = 50)
    private String accountName;
    @Basic
    @Column(name = "email_address", nullable = false, length = 50)
    private String emailAddress;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @OneToMany(mappedBy = "accountsByAccountIdFk")
    private Collection<AccountAttributesEntity> accountAttributesByAccountId;
    @OneToMany(mappedBy = "accountsByAccountIdFk")
    private Collection<AccountCategoriesEntity> accountCategoriesByAccountId;
    @OneToMany(mappedBy = "accountsByAccountIdFk")
    private Collection<AccountProductsEntity> accountProductsByAccountId;
    @OneToMany(mappedBy = "accountsByAccountIdFk")
    private Collection<AttributesEntity> attributesByAccountId;
    @OneToMany(mappedBy = "accountsByAccountIdFk")
    private Collection<CategoriesEntity> categoriesByAccountId;
    @OneToMany(mappedBy = "accountsByAccountIdFk")
    private Collection<ProductAttributesEntity> productAttributesByAccountId;
    @OneToMany(mappedBy = "accountsByAccountIdFk")
    private Collection<ProductCategoriesEntity> productCategoriesByAccountId;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountsEntity that = (AccountsEntity) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(accountName, that.accountName) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountName, emailAddress, createdAt);
    }

    public Collection<AccountAttributesEntity> getAccountAttributesByAccountId() {
        return accountAttributesByAccountId;
    }

    public void setAccountAttributesByAccountId(Collection<AccountAttributesEntity> accountAttributesByAccountId) {
        this.accountAttributesByAccountId = accountAttributesByAccountId;
    }

    public Collection<AccountCategoriesEntity> getAccountCategoriesByAccountId() {
        return accountCategoriesByAccountId;
    }

    public void setAccountCategoriesByAccountId(Collection<AccountCategoriesEntity> accountCategoriesByAccountId) {
        this.accountCategoriesByAccountId = accountCategoriesByAccountId;
    }

    public Collection<AccountProductsEntity> getAccountProductsByAccountId() {
        return accountProductsByAccountId;
    }

    public void setAccountProductsByAccountId(Collection<AccountProductsEntity> accountProductsByAccountId) {
        this.accountProductsByAccountId = accountProductsByAccountId;
    }

    public Collection<AttributesEntity> getAttributesByAccountId() {
        return attributesByAccountId;
    }

    public void setAttributesByAccountId(Collection<AttributesEntity> attributesByAccountId) {
        this.attributesByAccountId = attributesByAccountId;
    }

    public Collection<CategoriesEntity> getCategoriesByAccountId() {
        return categoriesByAccountId;
    }

    public void setCategoriesByAccountId(Collection<CategoriesEntity> categoriesByAccountId) {
        this.categoriesByAccountId = categoriesByAccountId;
    }

    public Collection<ProductAttributesEntity> getProductAttributesByAccountId() {
        return productAttributesByAccountId;
    }

    public void setProductAttributesByAccountId(Collection<ProductAttributesEntity> productAttributesByAccountId) {
        this.productAttributesByAccountId = productAttributesByAccountId;
    }

    public Collection<ProductCategoriesEntity> getProductCategoriesByAccountId() {
        return productCategoriesByAccountId;
    }

    public void setProductCategoriesByAccountId(Collection<ProductCategoriesEntity> productCategoriesByAccountId) {
        this.productCategoriesByAccountId = productCategoriesByAccountId;
    }
}
