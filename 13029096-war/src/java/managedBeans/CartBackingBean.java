/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.inject.Named;

import session.ProductFacade;
import ShoppingCartEjb.ShoppingCartLocal;
import entity.Product;
import java.util.List;
import javax.enterprise.context.Dependent;


/**
 *
 * @author Vilma
 */
@ManagedBean
@Dependent
@Named(value = "cardBackingBean")
public class CartBackingBean {

    @EJB
    private ProductFacade pf;
    
    @EJB
    private ShoppingCartLocal shoppingCart;
    
    private String client_message;
    /**
     * Creates a new instance of CardBackingBean
     */
    
    public CartBackingBean() {
        
    }

    public String getClient_message() {
        return client_message;
    }
    public List<Product>returnProducts(){
     return this.shoppingCart.getProducts();
    }
    public void setClient_message(String client_message) {
        this.client_message = client_message;
    }
    public void add(int productID){
        System.out.println("Test id"+ productID);
        Product p =(Product)pf.find(productID);
     //   System.out.println("Test: {"+p.getAvailable()+"}");
        
        if(p.getAvailable().equals("TRUE")){
           shoppingCart.addProduct((Product)pf.find(productID));
           client_message="Product was succesfully added";
           System.out.println("Help adding here");
        }
        else{
           this.client_message="Product is not available";
           System.out.println("Added nothging because is empty");
        }
    }
}
