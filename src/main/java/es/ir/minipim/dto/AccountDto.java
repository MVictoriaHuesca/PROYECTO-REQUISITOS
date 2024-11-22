package es.ir.minipim.dto;
import es.ir.minipim.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    private Integer accountId;
    private String accountName;
    private String emailAddress;
    private String accountProfilePicture;
    private String createdAt;
    private List<AccountAttribute> accountAttributesByAccountId;
    private List<AccountCategory> accountCategoriesByAccountId;
    private List<AccountProduct> accountProductsByAccountId;
    private List<Attribute> attributesByAccountId;
    private List<Category> categoriesByAccountId;
    private List<ProductAttribute> productAttributesByAccountId;
    private List<ProductCategory> productCategoriesByAccountId;
}