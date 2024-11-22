package es.ir.minipim.dto;
import es.ir.minipim.entity2.*;
import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    private Integer accountId;
    private String accountName;
    private String emailAddress;
    private String accountProfilePicture;
    private String createdAt;
    private List<AccountAttributeEntity> accountAttributesByAccountId;
    private List<AccountCategoryEntity> accountCategoriesByAccountId;
    private List<AccountProductEntity> accountProductsByAccountId;
    private List<AttributeEntity> attributesByAccountId;
    private List<CategoryEntity> categoriesByAccountId;
    private List<ProductAttributeEntity> productAttributesByAccountId;
    private List<ProductCategoryEntity> productCategoriesByAccountId;
}