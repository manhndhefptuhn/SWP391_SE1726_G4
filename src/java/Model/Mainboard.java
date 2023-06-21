/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Zarius
 */
public class Mainboard {
    private int mainboardID;
    private String mainboardName;
    private int price;
    private String description;
    private String image;
    private boolean status;

    public Mainboard() {
    }

    public Mainboard(int mainboardID, String mainboardName, int price, String description, String image, boolean status) {
        this.mainboardID = mainboardID;
        this.mainboardName = mainboardName;
        this.price = price;
        this.description = description;
        this.image = image;
        this.status = status;
    }


    public int getMainboardID() {
        return mainboardID;
    }

    public void setMainboardID(int mainboardID) {
        this.mainboardID = mainboardID;
    }

    public String getMainboardName() {
        return mainboardName;
    }

    public void setMainboardName(String mainboardName) {
        this.mainboardName = mainboardName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
}
