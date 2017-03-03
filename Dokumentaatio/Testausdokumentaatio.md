#Testausdokumentaatio

Jotain asioita projektissani on hankalaa testata automaattisesti, joten
testasin joidenkin asioiden toiminnan puhtaasti kokeilemalla itse ja 
laskemalla itse mahdollisia muutoksia erilaisilla muuttujilla. Käyn 
seuraavaksi läpi eri luokkien kohtia, joiden toteutuksen testasin itse.

##Lintu
###konstruktori
Konstruktorissa luotava muuttuja i määrää linnun alkuasetelman suunnan
(ylös/alas), joka arvotaan kokonaislukujen 0 ja 1 väliltä. Kun i=0, 
muuttuja suunta saa arvon true ja muuttuja dy, joka määrää linnun 
liikkumisen y-suunnassa, saa jonkin satunnaisen kokonaislukuarvon väliltä
[0,3], kun taas jos i=1, suunta saa arvon false ja dy saa satunnaisen 
kokonaislukuarvon väliltä [-3,0]. Dy:n arvolla ei ole suurta merkitystäkään
alussa, koska dy:n arvo vaihtelee välillä [-5,5] ja muuttuu sitä mukaa, kun 
lintu liikkuu.

###liiku()
Liikkumista on myös hankala testata, koska linnun alkuarvo dy:lle vaihtelee
välillä [-3,3]. Mutta jokaisella kerralla kun lintu liikkuu, se liikkuu
x-suunnassa dx:n verran ja y-suunnassa dy:n verran. Kun dy = 5 (tai -5) 
metodin suorituksen alussa, suunta vaihdetaan päinvastaiseksi, kuin mitä se
aiemmin oli. Muutoin dy kasvaa tai vähenee yhdellä, riippuen suunnasta. Näin
linnun lentorata saadaan aaltomaiseksi.
Toteutus toimii, koska jokaiselle suunnalle on selvä raja, jonka dy voi
saavuttaa ja muutoin dy vain muuttaa arvoaan yhdellä suuntaan tai toiseen,
riippuen mikä suunta sillä hetkellä on.

###siirraUuteenPaikkaan()
Linnun siirrossa muuttuja dx s aa uuden arvon välillä [-15,-6], joka määrää
linnun nopeuden x-suunnassa (dx siis kerrotaan luvulla (-1), jotta suunta 
olisi myös vasemmalle, kohti pelaajaa). Tämän jälkeen muuttuja tempY saa
arvon väliltä [80, 119] ja tällä määrätään se, paljonlo lintu vaihtaa 
paikkaansa y-suunnassa. Jos linnun y-koordinaatti on suurempi kuin 100,
kerrotaan tempY luvulla (-1), jolloin linnun paikka ei pääse liian alas.
Jos linnun y-koordinaatti on nolla tai pienempi, tempY asetetaan välille
[10, 24], jolloin lintu pysyy varmasti pelialueen sisällä.
Muuttuja tempX arvotaan välille[1200, 2497], mikä on määrä jonka lintu
siirtyy x-akselilla uuteen paikkaan oikealle.

###piirraPalat()
Tämän testaaminen on jätetty väliin, koska Graphics-olioiden testaaminen
on suhteellisen hankalaa. Kuitenkin, metodi piirtää linnun kuvan, jos linnun
kuva on ladattuna, muutoin piirretään linnun palat, jotka näyttävät osuma-alueen.

##Pala
###piirra()
Tämän testaaminen on jätetty väliin, koska Graphics-olioiden testaaminen
on suhteellisen hankalaa. Metodin idea on kuitenkin piirtää palan parametrien
nelikulmio.

##Pelaaaja
###kuolee()
Metodin pääasiallinen toiminta on testattu, mutta testit eivät kata ajan
mittaamista. Ajan testaaminen on hankalaa, koska testien aikana on hankala tietää,
mitä asioita käsitellään milläkin hetkellä ja tulokset voivat vaihdella suurestikin.
Ideana on kuitenkin, että otetaan systeemin aika millisekunteinta muuttujaan loppu ja
temp = loppu - alku, jolloin saadaan millisekunteina aika, joka on kulunut pelin alusta.
Msec-muuttuja ottaa aika-muuttujan jakojäännöksen tuhannesta, jolloin sekunnin
murto-osat saadaan laskettua ja sec-muuttuja ottaa aika-muuttujalta msec-muuttujan
avulla kokonaiset sekunnit.

###piirraPalat()
Tämän testaaminen on jätetty väliin, koska Graphics-olioiden testaaminen
on suhteellisen hankalaa. Idea on kuitenkin sama, kuin linnulla.
Metodissa on pieni ero siinä, että alussa tarkistetaan, onko hahmo vielä
elossa ja päivitetään loppu-muuttujan arvo, jotta aika saadaan päivitettyä
pelaajan tietoon alanurkkaan (aikaa käsittelevät muuttujat toimivat samalla
tapaa, kuin kuolee()-metodissa). Jos hahmo ei ole elossa, loppu-muuttujan arvo
ei pääse muuttumaan, jolloin pelaaja ei voi huijata saaneensa parempaa aikaa.
Testaaminen totetutettu kokeilemalla painaa eri nappeja kuoleman jälkeen.

##Pilvi
###siirraUuteenPaikkaan()
Testauksessa ei ole onnistuttu huomioimaan satunnaisia kohtia metodissa.
yy-muuttujasta otetaan vastaluku kertomalla (-1):llä, jos y >= 100, jolloin
pilvi ei pääse laskeutumaan liian alas pelialuetta.  Jos y < 0, yy-muuttuja
asetetaan välille [10,24], jolloin se ei pääse nousemaan pelialueesta liian
korkeallekaan. Lopuksi pilven y-koordinaattin lisätään muuttujan yy arvo ja 
tempX asetetaan välille [900, 1299], mikä on pituus jonka pilvi siirtyy
x-suunnassa pelialueen oikealle.

##Puu
###konstruktori
Dx-muuttujalle arvotaan uusi arvo väliltä [-7,-3], jolloin puu liikkuu aina
x-suunnassa oikealta vasemmalle. (Alkuun vähän hitaampi ja helpompi väistää)

###siirraUuteenPaikkaan()
Dx-muuttujalle arvotaan taas uusi arvo väliltä [-12, -5]. Y-muuttuja arvotaan
välille [30, 79] ja jos puun ensimmäisen palan y-koordinaatti on >=280, y-muuttujan 
arvo kerrotan (-1):llä, jotta y-suunnassa liikkuminen ei tapahdu aina samaan suuntaan.
Muuttuja tempX määrää taas puun siirron x-suunnassa oikealle, kuten esim. Pilvellä.
Muuttujan arvo on vain hiukan eri.