package org.springlab.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand_name")
    private String brandName;

    // Constructors
    public Brand() {
    }

    public Brand(Integer id, String brandName) {
        this.id = id;
        this.brandName = brandName;
    }

    // Getter & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
