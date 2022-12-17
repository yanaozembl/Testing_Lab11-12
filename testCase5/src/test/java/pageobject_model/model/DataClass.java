package pageobject_model.model;

public class DataClass {
    private String nameOfProduct;
    private String nameOfPage;

    public DataClass(){}

    public DataClass(String nameOfProduct, String nameOfPage) {
        this.nameOfProduct = nameOfProduct;
        this.nameOfPage = nameOfPage;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getNameOfPage() {
        return nameOfPage;
    }

    public void setNameOfPage(String nameOfPage) {
        this.nameOfPage = nameOfPage;
    }
}
