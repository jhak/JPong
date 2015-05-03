**Testausdokumentaatio**<br>
Käsin testattuna ( pelaamalla peliä ) kaikki toimii, suurempia bugeja ei peruspelauksessa ole havaittavissa, kuitenkin tiedossa olevia bugeja on mm.
* Pallo läpäisee mailan kimpoamatta mailan äärireunoista joissain jyrkissä kulmissa todella pieneltä alueelta
* Huono framerate heikommilla kokoonpanoilla (?)

Automaattisesti ei testata:
* AI, johtuen sisäänrakennetusta satunnaisesta "virheratkaisun" mahdollisudesta en katsonut mielekkääksi lähteä testaamaan liikuttako AI mailaa, tämän voi kuitenkin havaita toimivaksi
lyhyellä pelaamisella/käsin testaamalla.
* PaddleListener luokkaa ei myöskään sen kummemmin automaattisesti testata, kun luokan käytössä oleva toiminnallisuus rajautuu ihmispelaajan syötteeseen reagointiin jonka myös voi havaita toimivaksi pelaamalla.
* Käyttöliittymän/pelikentän tai GameObjectejen skaalautuvuuden testaamiseen ei myöskään ole kiinnitetty sen enempää huomiota koska kyseinen lisätoiminnallisuus jäi keskeneräiseksi eikä pelikentän kokoa ole tarkoituskaan tässä vaiheessa kehitystä pystyä muuttamaan.



