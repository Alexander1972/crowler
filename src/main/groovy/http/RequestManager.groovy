package http


import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import groovy.util.logging.Log

@Log

/**
 * Created by alexander on 9/19/15.
 */
class RequestManager {

    String baseUrl
    Document homeDoc

    def RequestManager(String baseUrl) {

        this.baseUrl = baseUrl
        homeDoc = Jsoup.connect(this.baseUrl).get()

    }

    def getAllLinksFromDocument(document) {
        List links = []
        Elements data = document.select("a[href]")

        print("\nLinks: (%d)", links.size());
        for (Element link : data) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }

    }

    def getAllLinksFromHomePage() {
        List links = []
        Elements data = homeDoc.select("a[href]")

        for (Element link : data) {
            println(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }

    }

    def Elements getMenu() {
        try {
            // load input from url
            Document doc = Jsoup.connect(baseUrl).get();
            // navigate to <div class="nav-sections"> the parent of all menu items
            Elements navDivTag = doc.getElementsByClass("nav-sections");
            // get the first element since there is only one, and return a list of all sub <a> tag of menu items
            return navDivTag.get(0).getElementsByTag("a");

        } catch (Exception ex) {
            log.info( "getMenus", ex.getMessage());
            return null;
        }


    }

    def processListLinks(List list){
        if(list != null && list.size() > 0) {
            // get each <a> tag
            for(Element menu: list) {
                // output the menu content
                System.out.print(String.format("[%s]", menu.html()));
            }
            System.out.println("\nMenu and its relative path:");
            // query and parse each <a> tags' href attribute values
            for(Element menu: list) {
                // output the attribute values
                System.out.println(String.format("[%s] href = %s", menu.html(), menu.attr("href")));
            }
        }
    }
}