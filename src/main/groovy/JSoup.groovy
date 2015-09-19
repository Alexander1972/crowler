import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

println "WebScraping with Groovy \n"
def url = "http://monitise.com";
def url2 = "http://scores.sify.com/index.shtml"
def document = Jsoup.connect(url).get();
println document
def cricDocument = Jsoup.connect(url2).get()
def goldDetails = document.select(".yellowTxt")
def caratDetails= goldDetails.first().text()
def goldRate = goldDetails.get(1).text()
def liveScore = cricDocument.select(".arial12black-b");
def matchDetails = cricDocument.select(".arial12blue-b");
def matchResults = cricDocument.select(".arial12black-n");
def liveScoreBound = liveScore.size()
def outerBound = matchDetails.size()
def j = 0
//-3 beacuse interested only in recent matches :)
(liveScoreBound-3).times {
    if((it%2 == 0))
    {
        print "(${j})*"
        j++;
    }
    println liveScore.get(it).text() + "\n"
}
println "\nAdditional Details\n"
j =0 ;
//here nos like 1,4,7 has match details so the loop is like this
for(i=0;i<outerBound-3;i=i+3)
{
    println "${j++}: " + matchDetails.get(i).text()
}
println "\nToday's Gold Rate (in Chennai/India)"
println """
|------------------|--------------|
| Name | Rate |
| | |
| ${caratDetails} ${goldRate} |
|------------------|--------------|
"""
println "Thanks to Groovy and Jsoup"
//println matchResults.text()