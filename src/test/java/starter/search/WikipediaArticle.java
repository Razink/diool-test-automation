package starter.search;

import net.serenitybdd.screenplay.targets.Target;

public class WikipediaArticle {
    public static final Target HEADING =  Target.the("article heading").locatedBy("#firstHeading");
    public static final Target test =  Target.the("fee value").locatedBy("//span[contains(text(),'Fees') or contains(text(),'Frais')]/../span[2]");

}