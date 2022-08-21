<h1 align="center"> Beyzanur Özer - Enuygun MockAPI Projesi </h1>

> >##  ``` Grocery için bir mock servis oluşturuldu ve testler yazıldı.  ```

## MockAPIRestAssured
<br>https://app.mocklab.io/<br> sitesi kullanılarak bir mock servis oluşturuldu.

# Oluşturulan baseURI="https://lgoqg.mocklab.io/"

# Yazılan testlerin endpointleri aşağıdaki gibidir.
* GET /allGrocery (Tüm stok bilgisini getirir)
* GET /allGrocery/{name} (İsme göre uygun veriyi getirir)
* POST /add (Yeni bir veri ekler.)

## Ek bilgiler

> # Not1:
Raporlama için allure report kullanılmıştır. Test çalıştıktan sonra otomatik olarak "Seleniumproject" altında <b>Allure-results</b> dosyası oluşacaktır. Terminalden projesenin bulunduğu dizinde <b>Allure serve allure-results</b> yazarak test raporlarına ulaşılabilir.

