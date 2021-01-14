package monApp;

import entities.Address;
import entities.Customer;
import entities.Invoice;
import entities.Product;
import model.CustomerDAO;
import model.ProductDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO=new ProductDAO();


        Address address = new Address();
        address.setStreet("middle street");
        address.setHouseNumber("2A");
        address.setZipCode(11111);
        address.setCity("world");

        Customer daniel = new Customer();
        daniel.setId(1L);
        daniel.setName("daniel");
        daniel.setAddress(address);

        Product pomme= new Product();
        pomme.setName("pomme");
        pomme.setUnitPrice(1.15F);
        productDAO.saveProduct(pomme);

        Product poire= new Product();
        poire.setName("poire");
        poire.setUnitPrice(1.15F);
        productDAO.saveProduct(poire);

        Map<Product,Integer> productList1 =new HashMap<>();
        productList1.put(pomme,5);
        productList1.put(poire,2);

        Map<Product,Integer> productList2 =new HashMap<>();
        productList2.put(pomme,15);
        productList2.put(poire,20);

        Map<Product,Integer> productList3 =new HashMap<>();
        productList3.put(pomme,1);
        productList3.put(poire,2);


        Invoice invoice1=new Invoice();
        Invoice invoice2=new Invoice();
        Invoice invoice3=new Invoice();

        invoice1.setProductQuantity(productList1);
        invoice2.setProductQuantity(productList2);
        invoice3.setProductQuantity(productList3);

        List<Invoice> invoiceList=new ArrayList<>();
        invoiceList.add(invoice1);
        invoiceList.add(invoice2);
        invoiceList.add(invoice3);

        daniel.setInvoices(invoiceList);


        customerDAO.saveCustomer(daniel);
        System.out.println(customerDAO.showCustomer(1L));



    }
}
