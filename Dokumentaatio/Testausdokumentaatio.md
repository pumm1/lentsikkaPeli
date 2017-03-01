#Testausdokumentaatio

Jotain asioita projektissani on hankalaa testata automaattisesti, joten
testasin joidenkin asioiden toiminnan puhtaasti kokeilemalla itse ja 
laskemalla itse mahdollisia muutoksia erilaisilla muuttujilla. K‰yn 
seuraavaksi l‰pi eri luokkien kohtia, joiden toteutuksen testasin itse.

##Lintu
###konstruktori
Konstruktorissa luotava muuttuja i m‰‰r‰‰ linnun alkuasetelman suunnan
(ylˆs/alas), joka arvotaan kokonaislukujen 0 ja 1 v‰lilt‰. Kun i=0, 
muuttuja suunta saa arvon true ja muuttuja dy, joka m‰‰r‰‰ linnun 
liikkumisen y-suunnassa, saa jonkin satunnaisen kokonaislukuarvon v‰lilt‰
[0,3], kun taas jos i=1, suunta saa arvon false ja dy saa satunnaisen 
kokonaislukuarvon v‰lilt‰ [-3,0]. Dy:n arvolla ei ole suurta merkityst‰k‰‰n
alussa, koska dy:n arvo vaihtelee v‰lill‰ [-5,5] ja muuttuu sit‰ mukaa, kun 
lintu liikkuu.

###liiku()
Liikkumista on myˆs hankala testata, koska linnun alkuarvo dy:lle vaihtelee
v‰lill‰ [-3,3]. Mutta jokaisella kerralla kun lintu liikkuu, se liikkuu
x-suunnassa dx:n verran ja y-suunnassa dy:n verran. Kun dy = 5 (tai -5) 
metodin suorituksen alussa, suunta vaihdetaan p‰invastaiseksi, kuin mit‰ se
aiemmin oli. Muutoin dy kasvaa tai v‰henee yhdell‰, riippuen suunnasta. N‰in
linnun lentorata saadaan aaltomaiseksi.
Toteutus toimii, koska jokaiselle suunnalle on selv‰ raja, jonka dy voi
saavuttaa ja muutoin dy vain muuttaa arvoaan yhdell‰ suuntaan tai toiseen,
riippuen mik‰ suunta sill‰ hetkell‰ on.

##siirraUuteenPaikkaan()
Linnun siirrossa muuttuja dx s aa uuden arvon v‰lill‰ [-15,-6], joka m‰‰r‰‰
linnun nopeuden x-suunnassa (dx siis kerrotaan luvulla (-1), jotta suunta 
olisi myˆs vasemmalle, kohti pelaajaa). T‰m‰n j‰lkeen muuttuja tempY saa
arvon v‰lilt‰ [80, 119] ja t‰ll‰ m‰‰r‰t‰‰n se, paljonlo lintu vaihtaa 
paikkaansa y-suunnassa. Jos linnun y-koordinaatti on suurempi kuin 100,
kerrotaan tempY luvulla (-1), jolloin linnun paikka ei p‰‰se liian alas.
Jos linnun y-koordinaatti on nolla tai pienempi, tempY asetetaan v‰lille
[10, 24], jolloin lintu pysyy varmasti pelialueen sis‰ll‰.
Muuttuja tempX arvotaan v‰lille[1200, 2497], mik‰ on m‰‰r‰ jonka lintu
siirtyy x-akselilla uuteen paikkaan oikealle.

##Pala

##Pelaaaja

##Pilvi

##Puu