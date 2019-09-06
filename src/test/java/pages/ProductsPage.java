package pages;

import helper.FilterHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(className = "pod-item")
    private WebElement product;

    @FindBy(className = "fb-filter-bar")
    private WebElement containerFilters;

    @FindBy(xpath = "//*[@class='fb-price-list']//*[@class='fb-price']")
    private WebElement productPrice;

   public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void opendProduct(){
       product.click();
       //clickElement(product);
    }

    public void applyPriceFilter(String filterName,String start, String end){
        FilterHelper filterHelper =new FilterHelper();
       applyFilter("//*[@class='fb-filter_container']",filterName);
       applyFilter("//*[@class='content-text-verticalFilter']",filterHelper.rangeName(start,end));
    }

    public boolean verifyPriceFilter(int startPrice,int endPrice){
       boolean response =false;
       String[] priceName = productPrice.getText().split(" ");
       String stringPrice=priceName[1].replace(".","");
       int price = Integer.parseInt(stringPrice);
       System.out.println(price);
       if (price>=startPrice&&price<=endPrice){
           response=true;
       }
       return response;
    }


    private void applyFilter(String xpath,String filterName){
        FilterHelper filterHelper =new FilterHelper();
        List<WebElement> filters =  containerFilters.findElements(By.xpath(xpath));
        WebElement filter=filterHelper.findFilter(filters,filterName);
        if(filter!=null){
            filter.click();
          //  clickElement(filter);
        }

    }

}
