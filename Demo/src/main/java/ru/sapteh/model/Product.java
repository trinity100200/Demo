package ru.sapteh.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Cost")
    private String cost;
    @Column(name = "Description")
    private String description;
    @Column(name = "MainImagePath")
    private String mainImagePath;
    @Column(name = "IsActive")
    private String isActive;
    @Column(name = "ManufacturerID")
    private int manufacturerId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ManufacturerID")
    private Manufacturer manufacturer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ProductID")
    private ProductSale productSale;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost='" + cost + '\'' +
                ", description='" + description + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                ", isActive='" + isActive + '\'' +
                ", manufacturerId=" + manufacturerId +
                '}';
    }
}
