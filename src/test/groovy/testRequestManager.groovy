import http.RequestManager

def rm = new RequestManager('http://jsoup.org')

def links = rm.getMenu()
rm.processListLinks(links)