Smart Cargo System

Bu proje, kargo gönderilerini dijital ortamda yönetmek ve takip etmek amacıyla geliştirilmiş Java tabanlı bir sistemdir. Nesne yönelimli programlama prensipleri kullanılarak hazırlanmıştır.

Proje Özellikleri
Yönetici ve Müşteri Panelleri: Sisteme yönetici şifresiyle girerek kargo oluşturulabilir veya müşteri paneli üzerinden takip numarasıyla sorgulama yapılabilir.

Veri Kaydı: Tüm kargo bilgileri cargos.txt dosyasında saklanır. Uygulama yeniden başlatıldığında eski veriler otomatik olarak yüklenir.

Otomatik Silme Mantığı: Durumu "DELIVERED" (Teslim Edildi) olarak güncellenen kargolar, hem sistemden hem de metin dosyasından otomatik olarak silinir.

Tahmini Teslimat: Çıkış ve varış şehirlerine göre temel bir teslimat süresi hesaplaması yapılır.

Teknik Yapı
Main.java: Menü yapılarını, kullanıcı girişlerini ve dosya okuma/yazma işlemlerini yöneten ana sınıftır.

Cargo.java: Kargo nesnesine ait özellikleri, durum geçmişini ve bilgi gösterme metodlarını içeren model sınıfıdır.

Status.java: Kargonun geçebileceği aşamaları (Hazırlanıyor, Yolda, Teslim Edildi vb.) tutan sabit değerler topluluğudur.
Veri Formatı
Uygulama, verileri cargos.txt dosyasında şu düzende tutar:
TakipNo | Gönderici | Alıcı | Çıkış Şehri | Varış Şehri | Güncel Durum

Bu çalışma, Java programlama dilinde dosya yönetimi ve nesne yapısı mantığını uygulamak için hazırlanmıştır.
