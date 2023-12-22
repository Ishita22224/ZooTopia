package org.example;

public class Deal {
    private String codeName;
    private String category;
    private Integer percentage;

//    constructor
    public Deal(String category, Integer percent) {
        this.codeName = category.toUpperCase() + percent.toString();
        this.category = category;
        this.percentage = percent;
    }

//    getters
    public String getCategory() {
        return this.category;
    }
    public int getPercentage() {
        return this.percentage;
    }
    public String getCodeName() {return this.codeName;}

//    setters
    public void setCodeName() {
        this.codeName = this.category.toUpperCase() + this.percentage.toString();
    }
    public void setCategory(String category) {
        this.category = category;
        this.setCodeName();
    }
    public void setPercentage(int percent) {
        this.percentage = percent;
        this.setCodeName();
    }

//    method
    public String getMsg() {
        return this.category + "( " + this.percentage + "% discount ) - " + this.codeName;
    }

}
