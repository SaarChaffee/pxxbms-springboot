package com.chaffee.entity.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName bill_good
 */
@TableName(value ="bill_good")
@Data
public class BillGood implements Serializable {
    /**
     * 订单id
     */
    @TableField(value = "billCode")
    private Long billCode;

    /**
     * 商品id
     */
    @TableField(value = "goodCode")
    private Long goodCode;

    /**
     * 数量
     */
    @TableField(value = "quantity")
    private Long quantity;

    /**
     * 单价
     */
    @TableField(value = "price")
    private Double price;

    /**
     * 
     */
    @TableField(value = "createdBy")
    private Long createdBy;

    /**
     * 
     */
    @TableField(value = "creationDate", fill = FieldFill.INSERT)
    private LocalDateTime creationDate;

    /**
     * 
     */
    @TableField(value = "modifyBy")
    private Long modifyBy;

    /**
     * 
     */
    @TableField(value = "modifyDate", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

    /**
     * 
     */
    @Version
    @TableField(value = "version")
    private Long version;

    /**
     * 
     */
    @TableLogic
    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BillGood other = (BillGood) that;
        return (this.getBillCode() == null ? other.getBillCode() == null : this.getBillCode().equals(other.getBillCode()))
            && (this.getGoodCode() == null ? other.getGoodCode() == null : this.getGoodCode().equals(other.getGoodCode()))
            && (this.getQuantity() == null ? other.getQuantity() == null : this.getQuantity().equals(other.getQuantity()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCreatedBy() == null ? other.getCreatedBy() == null : this.getCreatedBy().equals(other.getCreatedBy()))
            && (this.getCreationDate() == null ? other.getCreationDate() == null : this.getCreationDate().equals(other.getCreationDate()))
            && (this.getModifyBy() == null ? other.getModifyBy() == null : this.getModifyBy().equals(other.getModifyBy()))
            && (this.getModifyDate() == null ? other.getModifyDate() == null : this.getModifyDate().equals(other.getModifyDate()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBillCode() == null) ? 0 : getBillCode().hashCode());
        result = prime * result + ((getGoodCode() == null) ? 0 : getGoodCode().hashCode());
        result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCreatedBy() == null) ? 0 : getCreatedBy().hashCode());
        result = prime * result + ((getCreationDate() == null) ? 0 : getCreationDate().hashCode());
        result = prime * result + ((getModifyBy() == null) ? 0 : getModifyBy().hashCode());
        result = prime * result + ((getModifyDate() == null) ? 0 : getModifyDate().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", billCode=").append(billCode);
        sb.append(", goodCode=").append(goodCode);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", modifyBy=").append(modifyBy);
        sb.append(", modifyDate=").append(modifyDate);
        sb.append(", version=").append(version);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
