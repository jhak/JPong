**Testausdokumentaatio**<br>
K�sin testattuna ( pelaamalla peli� ) kaikki toimii, suurempia bugeja ei peruspelauksessa ole havaittavissa, kuitenkin tiedossa olevia bugeja on mm.
* Pallo l�p�isee mailan kimpoamatta mailan ��rireunoista joissain jyrkiss� kulmissa todella pienelt� alueelta
* Huono framerate heikommilla kokoonpanoilla (?)

Automaattisesti ei testata:
* AI, johtuen sis��nrakennetusta satunnaisesta "virheratkaisun" mahdollisudesta en katsonut mielekk��ksi l�hte� testaamaan liikuttako AI mailaa, t�m�n voi kuitenkin havaita toimivaksi
lyhyell� pelaamisella/k�sin testaamalla.
* PaddleListener luokkaa ei my�sk��n sen kummemmin automaattisesti testata, kun luokan k�yt�ss� oleva toiminnallisuus rajautuu ihmispelaajan sy�tteeseen reagointiin jonka my�s voi havaita toimivaksi pelaamalla.
* K�ytt�liittym�n/pelikent�n tai GameObjectejen skaalautuvuuden testaamiseen ei my�sk��n ole kiinnitetty sen enemp�� huomiota koska kyseinen lis�toiminnallisuus j�i keskener�iseksi eik� pelikent�n kokoa ole tarkoituskaan t�ss� vaiheessa kehityst� pysty� muuttamaan.



