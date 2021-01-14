package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client")
public class Customer {

    @Id
    @Column(name = "Nr_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nom_Client")
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Client_Facture")
    private List<Invoice> invoices;

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Customer() {
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{id=%d, name='%s', address=%s, invoices=%s}".formatted(id, name, address, invoices);
    }
}
