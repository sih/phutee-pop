package net.phutee.data.api;

import java.util.*;

public interface PopulatorAPI {

    /**
     * @param source The source of this data (e.g. file path, URI)
     * @param menu A list of attributes and with corresponding values of the way
     *        to obtain that attribtue (e.g. the XPath to the attribute in the
     *        document)
     * @return A CSV string representing the attributes specified in the menu.
     *         This should include a header row as the first element in order to
     *         define the schema
     */
    public List<String> getTeams(String source, Map<String, String> menu);

}
