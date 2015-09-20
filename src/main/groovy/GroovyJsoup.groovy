import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

Document doc = Jsoup.connect("http://sf.blockshopper.com").get()
//println doc
/*
try{
    List links = []
    Element link = doc.select("a")
    //String attrLink = link.attr('href')
   // println '>> ' link
    //println attrLink
}
catch (Exception ex) {
    println ex.getMessage()
}
*/




/*
links = doc.select('a')
links.each{println it}
println doc.baseUri()
*/


def findAllCities(baseUrl){
    Document doc = Jsoup.connect(baseUrl).get();
    List allLinks = []
    List formattedLinks = []
    allLinks = doc.select('a')
    println allLinks
    for(Element link in allLinks) {
        if(link.attr('href').size() > 1 && !link.attr('href').startsWith('http') && link.attr('href').startsWith('/cities/')){
            println link.attr('href')
            formattedLinks.add(link.attr('href'))
        }
    }
    println formattedLinks.size()
    return formattedLinks
}

def findAllStreetsInCity(String baseUrl, List cities){
    List allLinks = []
    List formattedLinks = []
    for(city in cities){
        println ">>> looking in city $city"
        sleep(1000)
        Document cityDoc = Jsoup.connect(baseUrl+city).get();
        allLinks = cityDoc.select('a')
        for(Element link in allLinks) {
            if(link.attr('href').size() > 1 && !link.attr('href').startsWith('http') && link.attr('href').contains('/streets/')  ){
                println link.attr('href')
                formattedLinks.add(link.attr('href'))
            }
        }
    }
    println formattedLinks.size()
    return formattedLinks
}

List cities = findAllCities("http://sf.blockshopper.com")
List allStreets = findAllStreetsInCity("http://sf.blockshopper.com", cities)
for(s in allStreets){
    println s
}
println allStreets.size()

