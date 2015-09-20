import http.RequestManager

def rm = new RequestManager('http://sf.blockshopper.com')

def links = rm.getMenu('subnav curvedbottom bshadow')
println links + ' from test script'
rm.processListLinks(links)
List linkss =  rm.generateListOfLinksFromPage(links)

for(l in linkss){
    println l
}

/*
List linkss =  rm.generateListOfLinksFromPage(rm.getLinksHomePage())

for(l in linkss){
    println 'from for loop'
    println l
}
*/