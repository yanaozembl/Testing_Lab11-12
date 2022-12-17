package pageobject_model.model;

public class DataClass {
    private String selectedProductFavouritesPage;

    public DataClass() {
    }

    public DataClass(String selectedProductFavouritesPage) {
        this.selectedProductFavouritesPage = selectedProductFavouritesPage;
    }

    public String getSelectedProductFavouritesPage() {
        return selectedProductFavouritesPage;
    }

    public void setSelectedProductFavouritesPage(String selectedProductFavouritesPage) {
        this.selectedProductFavouritesPage = selectedProductFavouritesPage;
    }
}
