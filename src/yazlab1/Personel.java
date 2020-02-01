/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ABRA
 */
public class Personel {
    
    public static List list = new ArrayList();
    String Number;
    int UserID, BookRating, ID;
    double benzerlikoran;

   public Personel(){
       benzerlikoran=0;
   }
    
    public Personel(int UserID2, String Number2, int BookRating2) {
        UserID = UserID2;
        Number = Number2;
        BookRating = BookRating2;
    }

    public Personel(double benzerlik,int ID2) {
       this.ID = ID2;
       this.benzerlikoran=benzerlik;
    }
    
    public double getBenzerlik(){
        return this.benzerlikoran;
    }

    public int getUserID() {
        return UserID;
    }

    public String getNumber() {
        return Number;
    }

    public int getBookRating() {
        return BookRating;
    }

    public int getID() {
        return ID;
    }
    
    public void setID(int x){
        this.ID=x;
    }
    public void setBenzerlik(double x){
        this.benzerlikoran=x;
        
    }

}
