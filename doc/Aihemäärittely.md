**Aihe:** Klassinen pong-peli muutamilla lisäominaisuuksilla joiden on tarkoitus tuoda peliin hieman enemmän mielenkiintoa.


**Käyttäjät:**
Kuka tahansa kiinnostunut

**Kaikkien käyttäjien toiminnot:**

* Kykenee käynnistämään pelin
* Kykenee pelata peliä
* Kykenee muuttamaan sen asetuksia


**Vaatimukset pelille**

* Pelin tulee loppua tietyn pistemäärän jälkeen
* Pallon tulee liikkua oletettavasti
* Pelaajien palkkien tulee liikkua
* Pallon tulee reagoida pelaajien palkkeihin
* Pelin tulee päättyä kun toinen pelaajista on tehnyt 10 maalia.


**Luokkarakenne**
Pääluokka JPong käynnistää pelin luomalla Game-olion jonka luonnin yhteydessä luodaan myös samalla GameFrame-olio joka on graafisen käyttöliittymän pääluokka.
Game-luokka luokka sisältää pelin päälogikaan, peliloopin sekä luonnollisesti hallinnoi palloa sekä kutsuu AI-pelaajan mailaa liikuttavaa AI-oliota, GameFrame luokka puolestaan huolehtii GamePanel luokan kanssa pelin visuaalisesta puolesta sekä
Pelaajan näppäinsyötteiden vastaanotosta. Paddle ja Ball -luokat jotka GameObject-luokan alaluokkia puolestaan vastaavat mailojen ja pallon perustoiminnoista.