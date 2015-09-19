import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

Document doc = Jsoup.connect("http://www.bing.com/search?q=web+scraping").get()
//println doc
List links = []
Element link = doc.select("a").first()
String attrLink = link.attr('href')
println attrLink
links = doc.select('a')
links.each{print it}
println doc.baseUri()
