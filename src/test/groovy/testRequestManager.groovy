import http.RequestManager

def rm = new RequestManager('http://jsoup.org')

def links = rm.getMenu()
println links + ' from test script'
rm.processListLinks(links)
List linkss =  rm.generateListOfLinksFromPage(links)

for(l in linkss){
    println l
}