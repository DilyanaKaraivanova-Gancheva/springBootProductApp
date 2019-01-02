package guru.springframework.domain;

import javax.persistence.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Base64;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String productId;
    private String description;
    private byte[] imageUrl;
    private BigDecimal price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Lob
    public byte[] getImageUrl() {
        return imageUrl;
    }

    public Product setImageUrl(byte[] imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getImageEncoded() throws UnsupportedEncodingException {
        byte[] encode = Base64.getEncoder().encode(this.getImageUrl());
        this.setImageUrl(encode);
        return new String(this.getImageUrl(), "UTF-8");
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
