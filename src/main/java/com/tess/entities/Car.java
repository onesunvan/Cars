package com.tess.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "CAR")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT u FROM Car u"),
    @NamedQuery(name = "Car.findIfExists", query = "SELECT u FROM Car u WHERE u.ifExists=TRUE"),
    @NamedQuery(name = "Car.findLike", query = "SELECT u FROM Car u WHERE u.brand LIKE :filter OR u.model LIKE :filter"),
    @NamedQuery(name = "Car.findLikeIfExists", query = "SELECT u FROM Car u WHERE u.ifExists=TRUE AND "
            + "(u.brand LIKE :filter OR u.model LIKE :filter)")
})
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String brand;

    private String model;
    
    private Integer price;
    
//    @Lob
//    @Basic(fetch = FetchType.EAGER)
    private byte[] image;   

    @Column(name = "IF_EXISTS")
    private Boolean ifExists;
    
    public Car() {
    }

    public Car(String brand, String model, Integer price, byte[] image) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.image = image;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Boolean getIfExists() {
        return ifExists;
    }

    public void setIfExists(Boolean ifExists) {
        this.ifExists = ifExists;
    }
    
}
