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

###siirraUuteenPaikkaan()
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

###piirraPalat()
T‰m‰n testaaminen on j‰tetty v‰liin, koska Graphics-olioiden testaaminen
on suhteellisen hankalaa. Kuitenkin, metodi piirt‰‰ linnun kuvan, jos linnun
kuva on ladattuna, muutoin piirret‰‰n linnun palat, jotka n‰ytt‰v‰t osuma-alueen.

##Pala
###piirra()
T‰m‰n testaaminen on j‰tetty v‰liin, koska Graphics-olioiden testaaminen
on suhteellisen hankalaa. Metodin idea on kuitenkin piirt‰‰ palan parametrien
nelikulmio.

##Pelaaaja
###kuolee()
Metodin p‰‰asiallinen toiminta on testattu, mutta testit eiv‰t kata ajan
mittaamista. Ajan testaaminen on hankalaa, koska testien aikana on hankala tiet‰‰,
mit‰ asioita k‰sitell‰‰n mill‰kin hetkell‰ ja tulokset voivat vaihdella suurestikin.
Ideana on kuitenkin, ett‰ otetaan systeemin aika millisekunteinta muuttujaan loppu ja
temp = loppu - alku, jolloin saadaan millisekunteina aika, joka on kulunut pelin alusta.
Msec-muuttuja ottaa aika-muuttujan jakoj‰‰nnˆksen tuhannesta, jolloin sekunnin
murto-osat saadaan laskettua ja sec-muuttuja ottaa aika-muuttujalta msec-muuttujan
avulla kokonaiset sekunnit.

###piirraPalat()
T‰m‰n testaaminen on j‰tetty v‰liin, koska Graphics-olioiden testaaminen
on suhteellisen hankalaa. Idea on kuitenkin sama, kuin linnulla.
Metodissa on pieni ero siin‰, ett‰ alussa tarkistetaan, onko hahmo viel‰
elossa ja p‰ivitet‰‰n loppu-muuttujan arvo, jotta aika saadaan p‰ivitetty‰
pelaajan tietoon alanurkkaan (aikaa k‰sittelev‰t muuttujat toimivat samalla
tapaa, kuin kuolee()-metodissa). Jos hahmo ei ole elossa, loppu-muuttujan arvo
ei p‰‰se muuttumaan, jolloin pelaaja ei voi huijata saaneensa parempaa aikaa.
Testaaminen totetutettu kokeilemalla painaa eri nappeja kuoleman j‰lkeen.

##Pilvi
###siirraUuteenPaikkaan()
Testauksessa ei ole onnistuttu huomioimaan satunnaisia kohtia metodissa.
yy-muuttujasta otetaan vastaluku kertomalla (-1):ll‰, jos y >= 100, jolloin
pilvi ei p‰‰se laskeutumaan liian alas pelialuetta.  Jos y < 0, yy-muuttuja
asetetaan v‰lille [10,24], jolloin se ei p‰‰se nousemaan pelialueesta liian
korkeallekaan. Lopuksi pilven y-koordinaattin lis‰t‰‰n muuttujan yy arvo ja 
tempX asetetaan v‰lille [900, 1299], mik‰ on pituus jonka pilvi siirtyy
x-suunnassa pelialueen oikealle.

##Puu