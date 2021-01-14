package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ElementCollection
    private Map<Product,Integer> productQuantity;
    private float total;


    public Invoice() {
        this.date=LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<Product, Integer> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Map<Product, Integer> productQuantity) {
        this.productQuantity = productQuantity;
        productQuantity.forEach(((product, integer) -> this.total+=product.getUnitPrice()*integer));
    }

    public float getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "\n\nInvoice{id=%d, date=%s, \nproductQuantity=%s, \ntotal=%s}".formatted(id, date, productQuantity, total);
    }

    public void setTotal(float total) {
        this.total = total;
    }
}