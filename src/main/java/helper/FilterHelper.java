package helper;

import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterHelper {

    /**
     * Search a specific filter in a list
     * @param filters List of all the filters
     * @param filterName String with the tag of the filter
     * @return WebElement of the searched filter
     */
    public WebElement findFilter(List<WebElement> filters, String filterName) {
        WebElement filter = null;
        boolean fine = false;
        int i = 0;
        while (!fine && i < filters.size()) {
            if (filters.get(i).getText().contains(filterName)) {
                fine = true;
                filter = filters.get(i);
            } else {
                i++;
            }
        }
        return filter;
    }

    /**
     * Create the name of a specific range price filter
     * @param start minim value in the range
     * @param end maxim value in tha range
     * @return The name of the range filter
     */
    public String rangeName(String start, String end) {
        return "$" + start + " - " + "$" + end;

    }
}
