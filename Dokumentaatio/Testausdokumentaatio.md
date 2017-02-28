###Testausdokumentaatio

Jotain asioita projektissani on hankalaa testata automaattisesti, joten
testasin joidenkin asioiden toiminnan puhtaasti kokeilemalla itse ja 
laskemalla itse mahdollisia muutoksia erilaisilla muuttujilla. Käyn 
seuraavaksi läpi eri luokkien kohtia, joiden toteutuksen testasin itse.

##Lintu
#konstruktori
Konstruktorissa luotava muuttuja i määrää linnun alkuasetelman suunnan
(ylös/alas), joka arvotaan kokonaislukujen 0 ja 1 väliltä. Kun i=0, 
muuttuja suunta saa arvon true ja muuttuja dy, joka määrää linnun 
liikkumisen y-suunnassa, saa jonkin satunnaisen kokonaislukuarvon väliltä
[0,3], kun taas jos i=1, suunta saa arvon false ja dy saa satunnaisen 
kokonaislukuarvon väliltä [-3,0]. Dy:n arvolla ei ole suurta merkitystäkään
alussa, koska dy:n arvo vaihtelee välillä [-5,5] ja muuttuu sitä mukaa, kun 
lintu liikkuu.

#liiku()
Liikkumista on myös hankala testata, koska linnun alkuarvo dy:lle vaihtelee
välillä [-3,3]. Mutta jokaisella kerralla kun lintu liikkuu, se liikkuu
x-suunnassa dx:n verran ja y-suunnassa dy:n verran. Kun dy == 5 (tai -5) 
metodin suorituksen alussa, suunta vaihdetaan päinvastaiseksi, kuin mitä se
aiemmin oli. Muutoin dy kasvaa tai vähenee yhdellä, riippuen suunnasta. Näin
linnun lentorata saadaan aaltomaiseksi.
Toteutus toimii, koska jokaiselle suunnalle on selvä raja, jonka dy voi
saavuttaa ja muutoin dy vain muuttaa arvoaan yhdellä suuntaan tai toiseen,
riippuen mikä suunta sillä hetkellä on.

##Pala

##Pelaaaj

#Pilvi

#Puu