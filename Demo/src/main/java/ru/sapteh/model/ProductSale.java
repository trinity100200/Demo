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
@Table(name = "productsale")
public class ProductSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "SaleDate")
    private String saleDate;
    @Column(name = "ProductID")
    private int productId;
    @Column(name = "Quantity")
    private int quantity;
    @Column(name = "ClientServiceID")
    private int clientServiceId;

    @OneToMany(mappedBy = "productSale", fetch = FetchType.LAZY)
    private Set<Product> products;

    @Override
    public String toString() {
        return "ProductSale{" +
                "id=" + id +
                ", saleDate='" + saleDate + '\'' +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", clientServiceId=" + clientServiceId +
                '}';
    }
}
