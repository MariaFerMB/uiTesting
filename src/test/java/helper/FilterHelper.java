package helper;

import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterHelper {
    public WebElement findFilter(List<WebElement> filters,String filterName){
        WebElement filter =null;
        boolean fine =false;
        int i =0;
        while (!fine && i<filters.size()){
            if(filters.get(i).getText().contains(filterName)){
                fine = true;
                filter = filters.get(i);
            }
            else {
                i++;
            }
        }
        return filter;
    }

    public String rangeName(String start, String end){
        return "$"+start+" - "+"$"+end;

    }
}
