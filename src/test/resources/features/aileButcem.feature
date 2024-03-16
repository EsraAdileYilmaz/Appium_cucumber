


  Feature:Kullanici aile butcem gorevlerini gerceklestirir

  Background:Kullanicilar siteye giris yapmak icin bu adimlari kullanir
    * ilk ekran ayarlarini yapin 0 6 946 1005 500 150 1005 500 ve ardindan login "Giriş Yap" sayfasina ulasin
    * "email" ve "password" bilgilerini girerek kullanici bilgileriyle "Giriş Yap" giris yapin
    * uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin


  Scenario Outline:Kullanici verilen gorevler uzerinden test gorevlerini yerine getirir
    * sol kisimdaki menuden "Hesabım" bolumune gidin
    * hesabim sayfasindaki bilgileri degistirerek "<isim>" "<soyisim>" "<sehir>" "<yas>" "<meslek>" degisikleri kaydedin ve dogrulayin
    * kullanici uygulamayi kapatir

    Examples:
      | isim  | soyisim  | sehir  | yas  | meslek  |
      | isim1 | soyisim1 | sehir1 | yas1 | meslek1 |
      | isim2 | soyisim2 | sehir2 | yas2 | meslek2 |
      | isim3 | soyisim3 | sehir3 | yas3 | meslek3 |


    Scenario:Gelir ekle sayfasina girilir ve gerekli secimler yapilir

      * anasayfadaki arti 541 1676 0 butonuna tiklayin
      * "Gelir Ekle" butonuna text uzerinden tiklanir
      * Gelir Ekle sayfasinda aciklama kismina "Ilk gelir degeri " deger girilir
      * Gelir Ekle sayfasinda "Gelir Tipi" gelir tipi "Düzensiz" secilir
      * Gelir Ekle sayfasinda "Kategori" kategori "Serbest Gelir" secilir
      * Gelir Ekle sayfasinda tarih belirlemesi 0 1 771 1056 500 270 1056 1000 ve gun secimi "17" 975 1245 1000 yapilir
      * Gelir Ekle sayfasinda tutar "10000" bilgisi girilir
      * "Kaydet" butonuna text uzerinden tiklanir
      * basariyla eklendigini dogrulayin
      * kullanici uygulamayi kapatir

    @ab
    Scenario:Gelir ekle sayfasina girilir ve gerekli secimler yapilir
      * anasayfadaki arti 541 1676 0 butonuna tiklayin
      * "Gelir Ekle" butonuna text uzerinden tiklanir
      * Gelir Ekle sayfasinda aciklama kismina "Ikinci gelir degeri " deger girilir
      * Gelir Ekle sayfasinda "Gelir Tipi" gelir tipi "Düzenli" secilir
      * Gelir Ekle sayfasinda "Gelir Periyodu" gelir tipi "Aylık" secilir
      * Gelir Ekle sayfasinda "Kategori" kategori "Maaş Geliri" secilir
      * Gelir Ekle sayfasinda tarih belirlemesi 0 1 771 1056 500 270 1056 1000 ve gun secimi "17" 980 1382 1000 yapilir
      * Gelir Ekle sayfasinda tutar "5000" bilgisi girilir
      * "Kaydet" butonuna text uzerinden tiklanir
      * basariyla eklendigini dogrulayin
      * kullanici uygulamayi kapatir