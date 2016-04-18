/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartEjb;

import entity.Product;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vilma
 */

@Stateless
public class ShoppingCart implements ShoppingCartLocal {

    private List<Product>cardProducts = new ArrayList();
    
    @PersistenceContext(unitName = "13029096-ejbPU")
    private EntityManager em;

    @Override
    public List<Product> getProducts() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return cardProducts;
    }

    @Override
    public void addProduct(Product product) {
      cardProducts.add(product);
      System.out.println(product.getDescription());
    }
    @Override
    public void removeProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
