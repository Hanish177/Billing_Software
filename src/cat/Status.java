/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat;

/**
 *
 * @author Akschaya balaji
 */
public class Status{
        private  String Title;
        private String Author;
        private int ISBN;
        private int Quantity;
        private int Price;
        
        
        public Status(String Title,String Author,int ISBN,int Quantity,int Price){
            this.Title = Title;
            this.Author = Author;
            this.ISBN = ISBN;
            this.Quantity = Quantity;
            this.Price = Price;
            
        }
        public String getTitle(){
            return Title;
        }
        public String getAuthor(){
            return Author;
        }
        public int getISBN(){
            return ISBN;
        }
        public int getQuantity(){
            return Quantity;
        }
        public int getPrice(){
            return Price;
        }
        
        
        
    }