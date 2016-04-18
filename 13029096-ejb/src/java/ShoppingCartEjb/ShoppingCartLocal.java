/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShoppingCartEjb;

import entity.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Vilma
 */
@Local
public interface ShoppingCartLocal {
    
    public List<Product>getProducts();
    public void addProduct(Product product);
    public void removeProduct();
}