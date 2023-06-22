# Modlu Oyuncular Kılavuzu

Eğer vanilyayı **sadece** resmi başlatıcı gibi güvenilir bir başlatıcı üzerinden oynuyorsanız veya
Prism ve modlara hiç dokunmadıysanız: %100 güvendesiniz. Şu an için modlardan uzak durun
şu anda.

Modlu bir Minecraft oyuncusuysanız, virüsün size bulaşıp bulaşmadığını doğrulamanız gerekir.
Makinenizin ve kişisel verilerinizin risk altında olmadığından emin olmak için kötü amaçlı yazılımları kırın. Yapabilirsin
yani aşağıdaki talimatlarla.

### Hala devam ediyor mu?
Evet. Daha sonra tekrar kontrol edin.

### Sayfa Yapısı
* [Aslında Ne Oldu?](#gerçekte-ne-oldu)
* [Enfekte miyim?](#virüs-bulaştı-mı)
* [Enfekte Oldum, Şimdi Ne Olacak?](#enfekteyim-ne-olacak)
* [Enfekte Değilim, Şimdi Ne Olacak?](#enfekte-değilim-şimdi-ne-olacak)
* [Sıkça Sorulan Sorular](#sıkça-sorulan-sorular)
* [Teknik SSS](#teknik-sss)

Fractureiser hakkında herhangi bir sorunuz varsa, lütfen bu sayfanın tamamını ve SSS bölümünü okuyun
Sonunda, aldığımız soruların çoğu burada yanıtlanıyor.

## Gerçekte Ne Oldu?

Başlangıçta kötü amaçlı yazılımın yaratıcısı tarafından birkaç masum görünümlü kötü amaçlı mod ve eklenti yüklendi 
mod barındırma web sitesi CurseForge ve eklenti merkezi dev.craftbukkit.org (Bukkit değil 
yazılımın kendisi). Yüksek profilli bir mod paketi geliştiricisi denemek için bu modlardan birini indirdi
bilgisayarlarındaki dosyalara bilgileri olmadan virüs bulaştırdı - buna bir kopyası da dahildi 
Daha sonra CurseForge'a görünüşte yalın bir dosya olarak yüklenecek olan çalışma projesi 
virüs dahil. 

Bu süreç daha sonra CurseForge'daki kullanıcılardan gelen diğer birkaç vaka için kendini tekrarladı ve 
dev.craftbukkit.org, birçok popüler eklenti ve modun kopyalarına bulaşıyor. *Şu raporlar var 
kötü amaçlı eklenti ve mod kavanozları erken
Nisan ortası gibi.*

Bunun yanı sıra, CurseForge'daki yüksek trafikli içerik oluşturucu hesaplarına yönelik kaba kuvvet erişim girişimleri
kötü amaçlı yazılım yazarı tarafından denenmiştir. Şu anda ihlalin aşağıdaki nedenlerden kaynaklanıp kaynaklanmadığından emin değiliz
kaba kuvvet girişimi veya hesap sahiplerine trojan bulaşması nedeniyle.

Bu kötü amaçlı yazılım birden fazla "aşamadan" oluşur, her Aşama indirme ve yükleme işlemlerinden sorumludur.
bir sonrakini çalıştırıyor. Toplamda bilinen üç Aşama (Aşama 1, 2 ve 3) vardır ve enfekte olmuş
mod dosyaları tüm süreci başlatmak için bir "Aşama 0" görevi görür.

Aşama 3, kötü amaçlı yazılımın "beyni" ve elimizde tüm bunları yapmaya çalıştığına dair kanıtlar var
aşağıdakileri yapabilir:

* Kendini dosya sistemindeki *tüm* `jar` dosyalarına yayar, muhtemelen şu modlara bulaştırır
  CurseForge veya BukkitDev'den veya diğer Java programlarından indirilmemiştir
* Birçok web tarayıcısı için çerezleri ve giriş bilgilerini çalmak
* Panodaki kripto para adreslerini, muhtemelen sahip oldukları alternatif adreslerle değiştirin
saldırgan
* Discord kimlik bilgilerini çalın
* Microsoft ve Minecraft kimlik bilgilerini çalın

(Daha fazla bilgi için [teknik ayrıntılar](tech.md) bölümüne bakın)

Davranışı nedeniyle, bunun modifiye edilmiş cihazlara yönelik bir **hedefli saldırı** olduğundan **çok eminiz 
Minecraft ekosistemi**. Oldukça kötü.

**Bir sonraki duyuruya kadar, Minecraft mod indirmeleri konusunda son derece dikkatli olun.
Bu kötü amaçlı yazılımın kontrol sunucusu şu anda çevrimdışı olsa da, **herhangi bir
Curseforge'dan veya Bukkit eklenti deposundan son 2-3 hafta içinde indirilen
potansiyel olarak kötü niyetli olarak değerlendirilir**. Bazı kötü amaçlı yazılım tarayıcıları imza eklemeye başladı
ancak bu durum tüm veritabanlarına yayılıncaya kadar lütfen dikkatli olun.

*Bu noktada herhangi bir barındırma hizmetinin etkilenmediğini iddia edemeyiz*. Lütfen
Hangi siteyi kullandığınızdan bağımsız olarak dikkatli olun. Maven depolarına bile virüs bulaşmış olabilir,
ve bu kötü amaçlı yazılım aylar öncesine dayanıyor.

Saldırganın sunucusu kapatıldığı için şu anda yeni virüs bulaşması mümkün değil,
mevcut enfeksiyonlar hala aktif olabilir.

<!--### Sadede gel, bunu nasıl düzeltebilirim?

![Akış Şeması](media/flowchart.png)-->

### Bekle, s******* "sahne"si de ne?

![Sahne Diyagramı](media/stages.png)

## Virüs Bulaştı mı?

Kötü amaçlı yazılımın birden fazla aşaması vardır, bu nedenle size bulaşıp bulaşmadığını sormak aslında iki sorudan oluşur

### Mod dosyalarımdan herhangi birinde Aşama 0 var mı?
Bir mod dosyasını alan ve 0. Aşama tarafından enfekte edilip edilmediğini tespit eden çeşitli tarayıcılar mevcuttur.
kötü amaçlı yazılım.

* Overwolf'un [tarayıcısı](https://github.com/overwolf/jar-infection-scanner/releases)
  * Bu, tüm oyununuzu kontrol etmek için önerilen seçenektir - sadece CurseForge'a doğrultun 
kurulum klasörü veya örneklerinizi kaydettiğiniz başka bir yer
  * Bu bağımsız bir programdır ve Overwolf uygulamasının yüklü olmasını gerektirmez
* douira'nın [web sitesi tabanlı çevrimiçi tarayıcısı](https://douira.github.io/fractureiser-web-detector/)
* korteks'in [nekodetektörü](https://github.com/MCRcortex/nekodetector/releases) 
  * Çalıştırılabilir dosyayı göstermek için "Varlıklar" üzerine tıklayın - Java'nın yüklü olmasını gerektirir

Tek başına, dosyalar silinir ve hiç çalıştırılmazsa 0. aşama enfeksiyon tehlikeli değildir.

### Aşama 2 dosyaları sistemimde mevcut mu?

2. Aşama dosyalarının sisteminizde bulunması, kötü amaçlı yazılımın 0. ve 1. aşamalarının başarıyla çalıştığı anlamına gelir.
Eğer bu dosyalar mevcutsa, muhtemelen *tamamen enfekte* olmuşsunuzdur ve
belgedeki talimatlar.

Birçok virüs tarayıcısı 2. aşama dosyaları tespit etmeye başlamıştır. Eğer böyle bir uyarı alırsanız
dosyaları bulundu ve kaldırıldı, "Enfekte Oldum, Şimdi Ne Olacak?" bölümüne geçin.

Aksi takdirde, platformunuza bağlı olarak aşağıdakileri yaparak manuel olarak kontrol edebilirsiniz:

#### Windows Talimatları

* Başlat menünüzü Windows Tuşu ile açın ve `%localappdata%` yazın - bu şekilde görünmelidir:
![Yukarıdaki sorgu için arama sonuçları](media/localappdata.png)

* Yerel appdata klasörünün içinde, Explorer'ınızın her ikisini de görüntüleyecek şekilde ayarlandığından emin olmalısınız 
`Gizli Öğeler` ve `Korumalı İşletim Sistemi Dosyaları`.
  * Bu işlem Görünüm > Seçenekler'den yapılabilir
  * Bunu nasıl yapacağınızdan emin değilseniz, bir video açıklaması 
[burada bulunabilir](https://youtu.be/KLTlTlnXeKs).
  * Windows 11 kullanıcıları aynı seçenekleri üst şeritteki "Görünüm" düğmesinin altında bulabilirler. 
  en sağındaki "..." düğmesinin yanı sıra

* Microsoft Edge` adlı bir klasör bulun. "Microsoft" ve "Edge" arasındaki boşluk
  önemli - çünkü `MicrosoftEdge` Edge tarafından kullanılan meşru bir klasördür.  Virüs
  kendini gizlemek için basitçe bu şekilde adlandırmıştır.  
  * Meşru klasörün adı `Microsoft\Edge` de olabilir (bir `Edge` klasörünün içinde 
Microsoft' klasörü).
  * Edge ile ilgili herhangi bir klasörünüz yoksa, meşru klasörün var olması *gerekmez*,
  güvendesiniz.
  * Her iki yasal klasör de aynı anda mevcut olabilir, bu da sorun değil.
* Eğer `Microsoft Edge` mevcutsa, size virüs bulaşmış demektir. Bu durumda, `Microsoft Edge` klasörünü kalıcı olarak silin. 
klasörünü ve içindeki her şeyi silebilirsiniz.
  * Klasör silinemiyorsa, o anda çalışmakta olan tüm Java programlarını 
Görev Yöneticisi.

#### MacOS Bilgileri

Kötü amaçlı yazılım MacOS'u etkilemiyor gibi görünüyor, bu yüzden iyi olmalısınız.  
*Her ihtimale karşı ara sıra burayı tekrar kontrol edin.

#### Linux Talimatları

Öncelikle, dosyaları listelemek için kullandığınız yöntemin gizli dosyaları görüntüleme özelliğine sahip olduğundan emin olun.
Çoğu GUI dosya yöneticisi, gizli dosyaları değiştirmek için Ctrl+H kısayoluna sahiptir. Eğer bunu bir terminal üzerinde yapıyorsanız, 
ilgili dizinlerde `ls -A` veya daha ayrıntılı bir liste için `ls -lha` kullanın.

Aşağıdaki dosyalardan herhangi biri mevcutsa, virüs bulaşmış demektir. Eğer durum buysa, hepsini silin:
* `~/.config/systemd/user/systemd-utility.service`
* `/etc/systemd/system/systemd-utility.service`
* `~/.config/.data/lib.jar`

Bunu yaptıktan sonra, eğer varsa, `journalctl' dosyanızda fark edemediğiniz değişiklikler olup olmadığını kontrol edin. Sen
bunu `journalctl -exb` (sistem günlükleri için) ve `journalctl -exb --user` komutları ile yapabilirsiniz. 
(kullanıcı günlükleri için). Systemd servislerinizi yenilemek için aşağıdaki komutları çalıştırın:
```sh
sudo systemctl daemon-reload # Kullanıcı parolanızı girin
systemctl --user daemon-reload 
```

#### Komut Dosyaları

*Bir PowerShell veya Bash betiğini nasıl çalıştıracağınızı bilmiyorsanız, bunlar sizin için değildir.  
Otomatik PowerShell veya Bash betikleri de mevcuttur [PrismLauncher'da
web sitesi](https://prismlauncher.org/news/cf-compromised-alert/#automated-script) kontrol etmek için
Eğer bunları çalıştıracak teknik bilgiye sahipseniz, 2. Aşama için size yardımcı olabiliriz. Overwolf (Curseforge'un
ana şirket) bir C# Stage 2 tespit aracı da yayınladı:
https://github.com/overwolf/detection-tool

## Enfekte Oldum, Şimdi Ne Olacak?

**ÖNEMLİ**: Şu anda bunun yapabileceği her şeyin tam kapsamını veya ne olduğunu bilmiyoruz.
Bu nedenle, semptomları ortadan kaldırmanın tam bir yolu bulunana kadar son derece dikkatli olunmalıdır.
bulundu. Burada belirtilen her şey sadece *bildiklerimizdir* - lütfen kurumun iletişimini takip edin
kritik bir şey bulunursa güncellemelerle ilgili ekip.

Sisteminizde fractureiser'ın 2. aşama dosyalarını bulursanız, büyük olasılıkla 3. aşama kodu
koştu ve makinenize bulaştı.  
Şu anda en iyi seçeneğiniz bu sistemdeki her şeyin *tamamen tehlikede* olduğunu varsaymaktır. Yapmanız gerekenler:

* Kaybetmek istemediğiniz her şeyi bir flash sürücüye ya da harici diske yedekleyin.
bunu zaten düzenli olarak yapıyorsunuz!)
* Ayrı bir cihaz kullanarak, oturum açtığınız tüm hizmetlerin parolalarını değiştirin
  eski makine (Discord, e-posta vb.). Tercihen aşağıdaki gibi bir şifre yöneticisi kullanarak
  [BitWarden](https://bitwarden.com).
* Henüz her hizmet için İki Faktörlü Kimlik Doğrulama (Authenticator uygulaması veya SMS) kullanmıyorsanız
destekliyorsa, lütfen bunu hemen yapmaya başlayın
* Mümkünse, bölgenizdeki profesyonel bir servisle iletişime geçerek uygun bir
  makinenizde şüpheli herhangi bir şey için tanılama veya güvenli bir varsayılan olarak sadece silme ve
  sistemi yeniden yükleyin.
* Virüs bulaşmadıysa ne yapmanız gerektiğine ilişkin aşağıdaki bölümü okuyun, çünkü buradaki adımlar sizin için de geçerlidir.

## Enfekte Değilim, Şimdi Ne Olacak?

Son birkaç ay içinde mod oynadıysanız, şu anda yapabileceğiniz en güvenli şey 
Minecraft'ı hiç başlatmamaktır**. Evet, Vanilla'yı bile.  

Bununla birlikte - ilk etapta hiçbir şey bulunmadıysa, büyük olasılıkla hiçbir şey olmuyor.
Eğer hala oyunu oynamak istiyorsanız:
* Elimizdeki mevcut bilgilerle bu riskli değildir, ancak bunun böyle olduğunu garanti etmiyoruz
doğru - *kendinizi isteyerek riske atıyorsunuz*.
* Her oturumdan sonra, hiçbir şey olmadığından emin olmak için önceki adımdaki 2. aşama enfeksiyon dosyalarını kontrol edin
o zamandan beri
* **Hiçbir koşul altında**, herhangi bir mod, mod paketi veya eklentiyi indirmeyin veya güncellemeyin.
kullanabilir, hatta indirdiğiniz ve daha önce hiç çalıştırmadığınız herhangi birini çalıştırabilir - sahip olduğunuz örneklere bağlı kalın
zaten kullanılmış ve **SADECE** olanlar.

## Sıkça Sorulan Sorular

### CurseForge saldırıya uğradı mı?
CurseForge'un kendisi tehlikeye atılmadı, sadece bireysel kullanıcılar. Bu bir CurseForge sorunu değil, onlar
sadece bu olayın yaşandığı yer oldu. CurseForge ayrıca [bir makale yayınladı] (https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) durumu kendi açılarından açıklıyor ve
karşı önlemler üzerinde çalışıyorlar.

### Modrinth iyi mi?
Modrinth son 10 aylık yüklemelerde tam bir tarama yaptı ve virüslü hiçbir projeye rastlanmadı. 
Şu anda modla ilgili herhangi bir şey indirirken son derece dikkatli olmanızı tavsiye ediyoruz. 
Orada hiçbir modun enfekte olmaması tamamen şanstı.

### Modrinth daha mı güvenli?
Bu web sitesi düzeyinde bir sorun değil, Modrinth de CurseForge kadar güvenli.

### CurseForge bunun geçmesine nasıl izin verdi?
Aşama 0 enfeksiyonunun çalıştırdığı kod, otomatik bir sistem için mutlaka şüpheli değildi ve
başka bir modun kullanabileceği bir şey olabilirdi. Aslında, ilk sezgisel yöntemler
0. aşama enfeksiyonunda Quark gibi popüler modlarda önemli miktarda yanlış bayrak vardı.

Gerçekçi olmak gerekirse, platform ölçeğinde bu tür bir önleme, sonsuz sayıda virüs olması nedeniyle mümkün değildir.
Niyetinizi gizlemek için kodu düzenleyebileceğiniz farklı yollar.

### Hangi Antivirüsler bunu yakalar?
Konuştuğumuz gibi yenileri ekleniyor, bunun yerine yukarıdaki manuel doğrulamayı yapmak en iyisidir
Şimdilik AV'ye güveniyorum.

### Multiplayer güvenli mi?
Evet, eğer başka bir yerden mod indirmezseniz çok oyunculu bir sunucu üzerinden virüs bulaşmaz.

### Bedrock güvenli mi?
Evet, bu sadece Java'yı etkiler.

### Lunar veya Badlion gibi alternatif oyun istemcileri güvenli mi?
Aşağıdaki noktaya bakın.

### Optifine güvenli mi? / Sodium güvenli mi? / Iris güvenli mi? / Create güvenli mi? / Essential güvenli mi? / (mod ekleyin) güvenli mi?

**Şu anda herhangi bir modun güvenliğini tam olarak teyit edemiyoruz.**

Virüsün 3. aşamasının işlevlerinden biri, bilgisayarınızda bulabildiği kadar çok .jars'a bulaşmaktır. 
bilgisayar. Minecraft'ın kendisi (vanilya/modifiye), Minecraft ve Minecraft'ın diğer versiyonları da dahil olmak üzere **tüm `.jar`lara** bulaşabilir. 
modları, Spigot eklentileri ve ilgisiz Java uygulamaları. Yani bilgisayarınızda stage3 bölümü varsa 
Virüsün bir parçası olarak, indirdiğiniz bir modun "güvenli" olup olmadığı önemli değildir - virüs *bulaşacaktır*. 
İlk olarak *kırılmanın* sonraki aşamalarını tespit edin ve kaldırın.

Şu anda, *bilinen* tüm virüslü modlar CurseForge'dan kaldırılmıştır. CurseForge [bir 
bilinen virüslü modların listesi](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) (alt
sayfanın) ve bunları web sitesinden kaldırdı. Modrinth 10 ay öncesini taradı ve herhangi bir virüslü mod bulamadı. 

Bu *sinsi olanların sızmadığını garanti etmez*. Belirli bir kavanozun şunları içerip içermediğini kontrol etmek için 
fractureiser'ın 0. aşaması, [Am I Infected?] (#am-i-infected) bölümünü ve genel egzersizi kontrol edin
Şimdilik modla ilgili herhangi bir şey indirirken çok dikkatli olun.

### Enfeksiyon ne kadar yaygındı?

CurseForge, virüslü dosyaların tüm yıl boyunca yaklaşık 6.000 kez indirildiğini bildiriyor 
enfeksiyon dönemi. CF'nin Discord duyurusundan alıntı: 
> Perspektif vermek gerekirse, bu CurseForge'un günlük indirmelerinin yaklaşık %0.015'ine denk geliyor 
> Minecraft için.

### Birisi 1.20 sürüm etkinliğini mahvetmek mi istedi?

Tesadüf gibi görünüyor - bu kötü amaçlı yazılım kampanyası yayınlanmadan önce uzunca bir süre aktifti 
1.20 sürümünün sabahında yaygın olarak ortaya çıkarıldı.

## Teknik SSS

### Fractureiser VM'lerden (Sanal Makineler) kaçabilir mi?

**Hayır.**

stage3 *does* contains code for *attempting* a *manual* escape from the 
["Windows Sandbox"](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview).
Bu otomatik olarak gerçekleşmez. Virüs Windows Sandbox'tan çalıştırılırsa, aşağıdakileri yapmaya çalışacaktır
sizi kandırarak zararlı yazılıma bir kısayol yapıştırmanızı sağlamak için pano ile oynar.

Bu tür bir "pano kaçışının" yeni bir şey olmadığını ve basitçe aşağıdaki yöntemlerle alt edilmesinin çok kolay olduğunu unutmayın
panoyu ana bilgisayar ve konuk işletim sistemi arasında paylaşmamak. Daha ağır bir sanal makine kullanın
"Windows Sandbox" yerine, VirtualBox'ın "Konuk Eklentileri" veya Hyper-V'nin
"entegrasyon hizmetleri".

(*Gerçek* sanal makine kaçış açıkları milyonlarca dolar değerindedir ve
Bazı Minecraft çocukları ve bu kötü amaçlı yazılımın yazarının çok iyi olmadığına inanmak için nedenlerimiz var.
ilk etapta programcı).

### Bu ağ üzerinden yayılıyor mu?

Bildiğimiz kadarıyla, fractureiser ağa yayılma işlevi içermiyor, ancak tam olarak
söz konusu değil.  
Birlikte çalıştığımız bir güvenlik araştırmacısı bir uyarı aldı, ancak bu uyarı tamamen 
Benzer bir dosya adı kullanan alakasız bir kötü amaçlı yazılım. Bu sadece yanlış bir alarmdı.

### CurseForge ve Modrinth bu konuda ne yapıyor?

CurseForge açık kaynaklı bir [stage2/3 tespit aracı] geliştirdi (https://github.com/overwolf/detection-tool) 
ve [stage0 tespit aracı] (https://github.com/overwolf/jar-infection-scanner), *tüm* 
yüklenen modları/eklentileri 0. aşama enfeksiyonlar için taradı ve *bilinen* tüm enfeksiyon vakalarını sildi.

Modrinth ayrıca 10 ay öncesine kadar yüklenen modları/eklentileri 0. aşama enfeksiyonlar için taradı ve şunları yaptı 
bulamadılar.

Her iki platform da mod'a bir tür otomatik "virüs tarama" süreci eklemeyi düşünüyor 
gönderme hattı. Bunun gibi Java kötü amaçlı yazılımları genellikle ısmarlama olduğu için bu zordur.

### Güvenlik duvarımda/yönlendirme tablomda hangi IP adreslerini ve URL'leri engellemeliyim?

kırılmayla ilgili kodun bu URL'lere ve adreslere geniş bir yelpazede bağlandığı gözlemlenmiştir 
çeşitli port numaraları.

* Stage0 virüslü modlarda kodlanmış adres ve ilk gözlemlenen komut&kontrol 
sunucu: `85.217.144.130`
* Gözlemlenen ikinci komuta ve kontrol sunucusu: `107.189.3.101`
* stage1'in kullanmaya çalıştığı geri dönüş URL'si ve stage2 komut&kontrol ana bilgisayar adı: 
`files-8ie.pages.dev`

Ayrıca `v2202209151437200088` ana bilgisayar adına bağlanmaya çalıştığına dair kanıtlar da var 
25575 numaralı bağlantı noktası üzerinden - bilinmeyen nedenler; muhtemelen kötü amaçlı yazılımın eski bir sürümünden.

İşte skyrage ile ilgili güvenlik duvarına bazı ek adresler (yine, *çok* olası değil 
skyrage bu vektör aracılığıyla herkesin bilgisayarına indirildi, ancak bunlardan iyi bir şey çıkmaz 
adresleri zaten):

* `95.214.27.172`
* `connect.skyrage.de`
* `t23e7v6uz8idz87ehugwq.skyrage.de`
* `qw3e1ee12e9hzheu9h1912hew1sh12uw9.skyrage.de`
* *Muhtemelen sadece `skyrage.de`nin tamamını engelleyin*

Bunları ziyaret etmemeniz gerektiğini söylemeye gerek yok.

### Modunuzun diğer dosyaları indirmesini CurseForge/Modrinth kurallarına aykırı hale getirebilir miyiz?

Kötü amaçlı yazılım yüklemek zaten CurseForge kurallarına aykırı. Ayrıca birçok meşru kullanım durumu vardır 
bir modun dosya indirmesini de engelleyecektir.

### Modloader'ın kendisine bir çeşit "antivirüs" veya "sandbox" eklemek mümkün olabilir mi?

"Antivirüs": Muhtemelen hayır, normal antivirüslerin tespit edemediği aynı nedenlerden dolayı. 
Antivirüsler yalnızca bilinen kötü amaçlı yazılımları tespit edebilir, bilinmeyen kötü amaçlı yazılımları değil.

Sandboxing: Yüklemeden önce bir çeşit "bu sınıf 'güvenli' kod içeriyor mu?" kontrolünün dahil edilmesi 
sınıfı, kötü amaçlı yazılım geliştiricileri ve modloader arasında bir kedi-fare oyununu teşvik etmek için harika bir yoldur 
geliştiriciler.

Java kodunun belirli bir sınıfı (örneğin `URLClassLoader`) kullanmasını yasaklamak gerçekten zordur çünkü 
ayrıca `Class.forName` (bir ton meşru kullanım durumu vardır) ile de başvurabilir ve eğer 
'dan sınıfları yasaklar veya listeden çıkarırsanız, genellikle sınıf yolunda *başka* bir şey bulabilirsiniz 
sizin için `Class.forName` dosyasını çağırmaya isteklidir ve bu araçlardan kurtulmaya çalışmak sonu gelmeyen bir 
köstebek oyunu.

Java'yı sandbox'lamak neredeyse imkansızdır - aşağıdaki gibi makalelere bakın 
["Twenty Years of Escaping the Java Sandbox"](https://www.exploit-db.com/papers/45517).

Java modları basitçe keyfi kod demetleridir: onlara bir `.exe' gibi davranın, her şeyi yapabilirler. 

### Kötü amaçlı yazılımların bunları kurcalamasını önlemek için modlar neden kriptografik olarak imzalanmıyor?

Sorunun bir kısmı imzaların tek başına kötü amaçlı yazılımları engellememesidir - kriptografik olarak imzalanmış bir 
virüs hala virüstür - ve kendi kendini imzalamaya izin verildiyse, bu da kurcalamayı engellemez - 
Bir virüsün bir kavanozdan dijital imzaları silmesi ("delete META-INF") ve 
kendi anahtarıyla yeniden imzalayabilir. (Bu da varsayımsal bir durum değildir: fractureiser şu kodları içerir 
bulaştığı kavanozlardan dijital imzaları kaldırır).

Çevrimiçi imza doğrulamalı imzalı modlar *gerçekten de* ileriye dönük umut verici bir yol gibi görünüyor, 
Yine de ödünler olmadan olmaz. 2023-06-08-meeting.md) ile [bir toplantı] yapılacaktır.
modlama ekosisteminden birçok farklı temsilci nasıl ilerleyeceğimizi tartışmak için.

### Modların çalıştırılabilir kod indirmesini yasaklamak mümkün mü?

Bu mümkün değil. Bir dosyayı indirmeden önce çalıştırılabilir kod içerip içermediğini bilemezsiniz, 
ve bir dosya indirildikten sonra, onunla ne yapılacağını kontrol edemezsiniz.

* Modum tek bir Java sınıf dosyası indirirse ne olur?
* Peki ya bir Java sınıf dosyası ama tersten yazılmış, bu yüzden ilk başta bir sınıf dosyası gibi görünmüyorsa?
* Peki ya şifrelenmiş bir Java sınıf dosyası?
* Bilgisayarınızda derlenen Java *kaynak* koduna ne dersiniz?
* Peki ya bir Python betiği?
* İngilizce düzyazı içeren bir dosyaya ne dersiniz? 
çift sayıda kelime 0'a karşılık gelir ve tek sayıda kelime içeren cümleler 
1 mi? - düzyazı bir belge olmasına rağmen teknik olarak onu 
eğer istersem bir `.exe'.

### Bu, ortalıkta dolaşan Spigot eklentisi kötü amaçlı yazılımıyla mı ilgili?

Muhtemelen! Mevcut kötü amaçlı yazılım `skyrage` ile bazı bağlar var - kötü amaçlı yazılım yazarı bir 
skyrage ile ilgili `.jar` dosyasını yedek komuta ve kontrol sunucusuna aktarmak için sonuçsuz bir girişim 
CloudFlare yine de saldırıyı kaldırmadan kısa bir süre önce saldırıyı genişletti.

**Bu vektör aracılığıyla Skyrage tarafından enfekte edilen herhangi bir rapor almadık.** 
Yazar, CloudFlare URL'sini Skyrage'i işaret edecek şekilde *sonrasında* önemli bir süre boyunca güncellemiştir. 
stage0 virüslü modlardaki sabit kodlu IP adresi zaten kaldırılmıştı. Bu çoğunlukla komik bir 
Saldırganın bu kavanozu sunmaya çalışması merak uyandırıcı.

skyrage mevcut, iyi çalışılmış bir kötü amaçlı yazılım parçasıdır ve hakkında daha fazla bilgi bulabilirsiniz 
burada] (https://ljskatt.no/analysis/updater_class/).
