#Rakennekuvaus

##Hahmot
Kaikkien hahmojen ns. 'hitboxit', eli osuma-alueet, koostuvat laatikoista,
joilla on x- ja y-koordinaatit, sek� leveys ja korkeus. T�m� toteutetaan 
luokalla Pala. Jokainen pala pystyy my�s tarkistamaan muiden palojen osalta sen,
ovatko palat sis�kk�in, eli osuvatko ne toisiinsa. Hahmo-luokka siis yhdist��
useamman Pala-luokan olion itseens�, jolloin jokainen hahmo voi tarkistaa jokaiselle
palalleen osumansa toisen hahmon paloihin.

Lopulta itse peli k�ytt�� luokkia Pelaaja, Puu ja Lintu, jotka periv�t Hahmo-luokan
ominaisuudet, mutta muuttavat jokainen osaltaan hiukan pieni� yksityiskohtia
toiminnallisuudeltaan. Puu- ja Lintu-oliot muuttavat sijaintinsa pelialueen
ulkopuolelle jouduttuaan siten, ett� puut ovat alempana ja linnut ylemp�n� ja linnut
my�s lent�v�t erikoisemmalla tavalla.

##Peli
Kaikki hahmot lopulta alustetaan Peli-luokassa, jossa pelaajan hahmo alustetaan
tietylle paikalle, kun muut hahmot arvotaan siten, ett� ovat jossain sopivalla
paikalla pelialueen oikealla puolella, josta ne sitten l�htev�t tulemaan pelaajan
hahmoa kohti.

Peli-luokka my�s alustaa k�ytt�liittym�n, jonka toteutus Kayttoliittyma-luokassa,
joka alustaa piirtoalustan, joka piirt�� kaikki hahmot ruudulle. Piirtoalusta
toteutetaan saman nimisell� luokalla ja k�ytt�liittym�n kanssa se hy�dynt��
Kuuntelija-luokkaa, joka ottaa vastaan pelaajan inputin ja mahdollistaa pelaajan 
tekem�t v�ist�liikkeet peliss�. Piirtoalusta-luokka toteuttaa my�s pelin sis�isen
ajan Timer-oliolla, joka mahdollistaa pelin etenemisen ja uuden kuvan p�ivittymisen
ruudulle.
