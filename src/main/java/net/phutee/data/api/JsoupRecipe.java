package net.phutee.data.api;

import java.util.List;

import org.jsoup.nodes.Document;

/**
 * This is a recipe that will provide the required output from a document parsed
 * by Jsoup.
 * @author sid
 *
 */
public interface JsoupRecipe {

    /**
     * @return A list of items for this object
     */
    public List<Object> cook(Document data);
    
    public String getName();
    
    
}
