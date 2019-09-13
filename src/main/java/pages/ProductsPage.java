package pages;

import helper.FilterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    private static final String SPECIFIC_PRODUCTS_URL = "https://www.falabella.com.co/falabella-co/category/cat910963/Celulares-y-Telefonos?isPLP=1";

    @FindBy(className = "pod-item")
    private WebElement product;

    @FindBy(className = "fb-filter-bar")
    private WebElement containerFilters;

    @FindBy(xpath = "//*[@class='fb-price-list']//p[contains(text(),'(Internet)')]")
    private List<WebElement> productsPrice;

    @FindBy(xpath = "//*[@class='fb-cpy-bold-small fb-selectedfilters__title']")
    private WebElement selectsFilters;

    private final By titleOfFilters = By.xpath("//*[@class='fb-filter_container']");
    private final By filterOptions = By.xpath("//*[@class='content-text-verticalFilter']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openProduct() {
        drivenFacade.openPage(SPECIFIC_PRODUCTS_URL);
        product.click();
    }

    public void applyPriceFilter(String filterName, String start, String end) {
        FilterHelper filterHelper = new FilterHelper();
        applyFilter(filterName, titleOfFilters);
        applyFilter(filterHelper.rangeName(start, end), filterOptions);
    }

    /**
     * verify that the products price are between to values
     * @param startPrice min price
     * @param endPrice max price
     * @return true if all elements are inside the range
     */
    public boolean verifyPriceFilter(int startPrice, int endPrice) {
        drivenFacade.waitVisible(selectsFilters);
        boolean response = true;
        for (WebElement productPrice : productsPrice) {
            String[] priceName = productPrice.getText().split(" ");
            String stringPrice = priceName[1].replace(".", "");
            int price = Integer.parseInt(stringPrice);
            if (price < startPrice && price > endPrice) {

                response = false;
            }

        }
        return response;
    }


    private void applyFilter(String filterName, By path) {
        FilterHelper filterHelper = new FilterHelper();
        List<WebElement> filters = containerFilters.findElements(path);
        WebElement filter = filterHelper.findFilter(filters, filterName);
        if (filter != null) {
            filter.click();
        }

    }

}
