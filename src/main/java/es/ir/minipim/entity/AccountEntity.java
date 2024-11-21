package es.ir.minipim.entity;

import es.ir.minipim.dto.AccountDto;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account", schema = "grupo05DB", catalog = "")
public class AccountEntity {
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
    @Column(name = "account_profile_picture", nullable = true, length = 64)
    private String accountProfilePicture;
    @Basic
    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
    @OneToMany(mappedBy = "accountByAccountIdFk")
    private List<AccountAttributeEntity> accountAttributesByAccountId;
    @OneToMany(mappedBy = "accountByAccountIdFk")
    private List<AccountCategoryEntity> accountCategoriesByAccountId;
    @OneToMany(mappedBy = "accountByAccountIdFk")
    private List<AccountProductEntity> accountProductsByAccountId;
    @OneToMany(mappedBy = "accountByAccountIdFk")
    private List<AttributeEntity> attributesByAccountId;
    @OneToMany(mappedBy = "accountByAccountIdFk")
    private List<CategoryEntity> categoriesByAccountId;
    @OneToMany(mappedBy = "accountByAccountIdFk")
    private List<ProductAttributeEntity> productAttributesByAccountId;
    @OneToMany(mappedBy = "accountByAccountIdFk")
    private List<ProductCategoryEntity> productCategoriesByAccountId;

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

    public String getAccountProfilePicture() {
        return accountProfilePicture;
    }

    public void setAccountProfilePicture(String accountProfilePicture) {
        this.accountProfilePicture = accountProfilePicture;
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
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(accountName, that.accountName) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(accountProfilePicture, that.accountProfilePicture) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountName, emailAddress, accountProfilePicture, createdAt);
    }

    public List<AccountAttributeEntity> getAccountAttributesByAccountId() {
        return accountAttributesByAccountId;
    }

    public void setAccountAttributesByAccountId(List<AccountAttributeEntity> accountAttributesByAccountId) {
        this.accountAttributesByAccountId = accountAttributesByAccountId;
    }

    public List<AccountCategoryEntity> getAccountCategoriesByAccountId() {
        return accountCategoriesByAccountId;
    }

    public void setAccountCategoriesByAccountId(List<AccountCategoryEntity> accountCategoriesByAccountId) {
        this.accountCategoriesByAccountId = accountCategoriesByAccountId;
    }

    public List<AccountProductEntity> getAccountProductsByAccountId() {
        return accountProductsByAccountId;
    }

    public void setAccountProductsByAccountId(List<AccountProductEntity> accountProductsByAccountId) {
        this.accountProductsByAccountId = accountProductsByAccountId;
    }

    public List<AttributeEntity> getAttributesByAccountId() {
        return attributesByAccountId;
    }

    public void setAttributesByAccountId(List<AttributeEntity> attributesByAccountId) {
        this.attributesByAccountId = attributesByAccountId;
    }

    public List<CategoryEntity> getCategoriesByAccountId() {
        return categoriesByAccountId;
    }

    public void setCategoriesByAccountId(List<CategoryEntity> categoriesByAccountId) {
        this.categoriesByAccountId = categoriesByAccountId;
    }

    public List<ProductAttributeEntity> getProductAttributesByAccountId() {
        return productAttributesByAccountId;
    }

    public void setProductAttributesByAccountId(List<ProductAttributeEntity> productAttributesByAccountId) {
        this.productAttributesByAccountId = productAttributesByAccountId;
    }

    public List<ProductCategoryEntity> getProductCategoriesByAccountId() {
        return productCategoriesByAccountId;
    }


    public void setProductCategoriesByAccountId(List<ProductCategoryEntity> productCategoriesByAccountId) {
        this.productCategoriesByAccountId = productCategoriesByAccountId;
    }

    public AccountDto toDto() {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(this.accountId);
        accountDto.setAccountName(this.accountName);
        accountDto.setEmailAddress(this.emailAddress);
        accountDto.setAccountProfilePicture(this.accountProfilePicture);
        accountDto.setCreatedAt(this.createdAt.toString());
        List<AccountAttributeEntity> accountAttributesByAccountId = new ArrayList<>();
        if (this.accountAttributesByAccountId != null) {
            accountAttributesByAccountId.addAll(this.accountAttributesByAccountId);
        }
        accountDto.setAccountAttributesByAccountId(accountAttributesByAccountId);
        List<AccountCategoryEntity> accountCategoriesByAccountId = new ArrayList<>();
        if (this.accountCategoriesByAccountId != null) {
            accountCategoriesByAccountId.addAll(this.accountCategoriesByAccountId);
        }
        accountDto.setAccountCategoriesByAccountId(accountCategoriesByAccountId);
        List<AccountProductEntity> accountProductsByAccountId = new ArrayList<>();
        if (this.accountProductsByAccountId != null) {
            accountProductsByAccountId.addAll(this.accountProductsByAccountId);
        }
        accountDto.setAccountProductsByAccountId(accountProductsByAccountId);
        List<AttributeEntity> attributesByAccountId = new ArrayList<>();
        if (this.attributesByAccountId != null) {
            attributesByAccountId.addAll(this.attributesByAccountId);
        }
        accountDto.setAttributesByAccountId(attributesByAccountId);
        List<CategoryEntity> categoriesByAccountId = new ArrayList<>();
        if (this.categoriesByAccountId != null) {
            categoriesByAccountId.addAll(this.categoriesByAccountId);
        }
        accountDto.setCategoriesByAccountId(categoriesByAccountId);
        List<ProductAttributeEntity> productAttributesByAccountId = new ArrayList<>();
        if (this.productAttributesByAccountId != null) {
            productAttributesByAccountId.addAll(this.productAttributesByAccountId);
        }
        accountDto.setProductAttributesByAccountId(productAttributesByAccountId);
        List<ProductCategoryEntity> productCategoriesByAccountId = new ArrayList<>();
        if (this.productCategoriesByAccountId != null) {
            productCategoriesByAccountId.addAll(this.productCategoriesByAccountId);
        }
        accountDto.setProductCategoriesByAccountId(productCategoriesByAccountId);
        return accountDto;
    }
}

