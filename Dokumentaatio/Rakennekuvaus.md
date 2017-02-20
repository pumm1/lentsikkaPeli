#Rakennekuvaus

##Hahmot
Kaikkien hahmojen ns. 'hitboxit', eli osuma-alueet, koostuvat laatikoista,
joilla on x- ja y-koordinaatit, sekä leveys ja korkeus. Tämä toteutetaan 
luokalla Pala. Jokainen pala pystyy myös tarkistamaan muiden palojen osalta sen,
ovatko palat sisäkkäin, eli osuvatko ne toisiinsa. Hahmo-luokka siis yhdistää
useamman Pala-luokan olion itseensä, jolloin jokainen hahmo voi tarkistaa jokaiselle
palalleen osumansa toisen hahmon paloihin.

Lopulta itse peli käyttää luokkia Pelaaja, Puu ja Lintu, jotka perivät Hahmo-luokan
ominaisuudet, mutta muuttavat jokainen osaltaan hiukan pieniä yksityiskohtia
toiminnallisuudeltaan. Puu- ja Lintu-oliot muuttavat sijaintinsa pelialueen
ulkopuolelle jouduttuaan siten, että puut ovat alempana ja linnut ylempänä ja linnut
myös lentävät erikoisemmalla tavalla.

##Peli
Kaikki hahmot lopulta alustetaan Peli-luokassa, jossa pelaajan hahmo alustetaan
tietylle paikalle, kun muut hahmot arvotaan siten, että ovat jossain sopivalla
paikalla pelialueen oikealla puolella, josta ne sitten lähtevät tulemaan pelaajan
hahmoa kohti.

Peli-luokka myös alustaa käyttöliittymän, jonka toteutus Kayttoliittyma-luokassa,
joka alustaa piirtoalustan, joka piirtää kaikki hahmot ruudulle. Piirtoalusta
toteutetaan saman nimisellä luokalla ja käyttöliittymän kanssa se hyödyntää
Kuuntelija-luokkaa, joka ottaa vastaan pelaajan inputin ja mahdollistaa pelaajan 
tekemät väistöliikkeet pelissä. Piirtoalusta-luokka toteuttaa myös pelin sisäisen
ajan Timer-oliolla, joka mahdollistaa pelin etenemisen ja uuden kuvan päivittymisen
ruudulle.
