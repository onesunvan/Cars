package com.tess.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
    @NamedQuery(name = "Car.findAll", query = "SELECT u FROM Car u")
})
public class Car implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    
    private String brand;

    private String model;
    
    private Integer price;
    
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private byte[] image;   

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
    
}
