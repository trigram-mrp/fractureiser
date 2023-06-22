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
* [Aslında Ne Oldu?](#what-actually-happened)
* [Enfekte miyim?](#am-i-infected)
* [Enfekte Oldum, Şimdi Ne Olacak?](#im-infected-now-what)
* [Enfekte Değilim, Şimdi Ne Olacak?](#im-not-infected-now-what)
* [Sıkça Sorulan Sorular](#frequently-asked-questions)
* [Teknik SSS](#technical-faq)

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

### Is Multiplayer safe?
Yes, you can not be infected via a multiplayer server if you don't download mods for it elsewhere.

### Is Bedrock safe?
Yes, this affects only Java.

### Are alternative game clients such as Lunar or Badlion safe?
See the below point.

### Is Optifine safe? / Is Sodium safe? / Is Iris safe? / Is Create safe? / Is Essential safe? / Is (insert mod) safe?

**We can not currently fully confirm the safety of any given mod.**

One of the functions of stage3 of the virus is infecting as many .jars as it can find on your 
computer. It can infect **all `.jar`s**, including Minecraft itself (vanilla/modded), Minecraft 
mods, Spigot plugins, and unrelated Java applications. So if your computer has the stage3 portion 
of the virus, it doesn't matter whether a mod you download is "safe" - it will *become* infected. 
Detect and remove the later stages of fractureiser *first*.

At the moment, all *known* infected mods have been removed from CurseForge. CurseForge [posted a 
list of known infected mods](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) (bottom
of the page) and has removed them from the website. Modrinth has scanned back 10 months and has not found any infected mods. 

This does *not guarantee no sneaky ones slipped through*. To check whether a given jar contains 
stage0 of fractureiser, check the [Am I Infected?](#am-i-infected) section and overall exercise
extreme caution downloading anything mod related for now.

### How widespread was the infection?

CurseForge is reporting infected files were downloaded roughly 6,000 times for the entire 
infection period. Quote from CF's Discord announcement: 
> Just to give perspective, this accounts to about 0.015% of CurseForge’s daily downloads 
> for Minecraft.

### Did someone want to spoil the 1.20 release event?

It appears to be a coincidence - this malware campaign was active for quite a while before being 
widely uncovered the morning-of the 1.20 release.

## Technical FAQ

### Can fractureiser escape VMs (Virtual Machines)?

**No.**

stage3 *does* contain code for *attempting* a *manual* escape from the 
["Windows Sandbox"](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview).
It does not happen automatically. If the virus is ran from the Windows Sandbox, it will try to
mess with the clipboard to trick you into pasting a shortcut to the malware.

Note that this sort of "clipboard escape" is nothing new and it is very easy to defeat by simply
not sharing the clipboard between the host and guest OS. Use a more heavyweight virtual-machine
than the "Windows Sandbox", and disable features like VirtualBox's "Guest Addons" or Hyper-V's
"integration services".

(*Real* virtual-machine escape exploits are worth millions of dollars and would not be burned on
some Minecraft kids, and we have reason to believe the author of this malware is not a very good
programmer in the first place.)

### Does this spread over the network?

As far as we know, fractureiser does not contain network spread functionality, but it is not fully
out of the question.  
A security researcher we are working with got an alert, but it ended up being about completely 
unrelated malware that happened to use a similar filename. This was just a false alarm.

### What are CurseForge and Modrinth doing about it?

CurseForge has developed an open-source [stage2/3 detection tool](https://github.com/overwolf/detection-tool) 
and [stage0 detection tool](https://github.com/overwolf/jar-infection-scanner), have scanned *all* 
uploaded mods/plugins for stage0 infections, and have deleted all *known* infection cases.

Modrinth has also scanned uploaded mods/plugins for stage0 infections going back 10 months and did 
not find any.

Both platforms are considering introducing some sort of automated "virus scan" process to the mod 
submission pipeline. It's hard, since Java malware like this is typically bespoke.

### What IP addresses and URLs should I block in my firewall/routing table?

fractureiser-related code has been observed to connect to these URLs and addresses over a wide 
variety of port numbers.

* The hardcoded address in stage0-infected mods, and the first observed command&control 
server: `85.217.144.130`
* The second observed command&control server: `107.189.3.101`
* The fallback URL that stage1 tries to use, and the stage2 command&control hostname: 
`files-8ie.pages.dev`

There's also evidence of it trying to connect to the hostname `v2202209151437200088` 
over port 25575 - unknown reasons; probably from an older version of the malware.

Here are some additional addresses to firewall related to skyrage stuff (again, *very* unlikely 
skyrage was downloaded to anyone's PC through this vector, but nothing good comes from these 
addresses anyway):

* `95.214.27.172`
* `connect.skyrage.de`
* `t23e7v6uz8idz87ehugwq.skyrage.de`
* `qw3e1ee12e9hzheu9h1912hew1sh12uw9.skyrage.de`
* *Probably just block all of `skyrage.de` honestly*

Should go without saying that you should not visit these.

### Can we make it against CurseForge/Modrinth rules for your mod to download other files?

It's already against CurseForge rules to upload malware. There are also many legitimate use cases 
for a mod to download files that this would also stifle.

### Would it be possible to include some sort of "antivirus" or "sandbox" in the modloader itself?

"Antivirus": Probably not, for the same reasons that regular antiviruses didn't detect it. 
Antiviruses can only detect known malware, not unknown malware.

Sandboxing: Including some sort of "does this class contain 'safe' code?" check before loading a 
class is a great way to spur on a cat-and-mouse game between malware developers and modloader 
developers.

It's really hard to ban Java code from using a specific class (say, `URLClassLoader`) because you 
can also refer to it with `Class.forName` (which has a ton of legitimate use-cases), and if you 
ban or deny-list classes from *that*, you can typically find something *else* on the classpath 
willing to call `Class.forName` for you, and trying to get rid of these gadgets is an endless 
game of whack-a-mole.

Sandboxing Java is pretty much impossible - see articles like 
["Twenty Years of Escaping the Java Sandbox"](https://www.exploit-db.com/papers/45517).

Java mods are simply bundles of arbitrary code: treat them like an `.exe`, they can do anything. 

### Why aren't mods cryptographically signed to prevent malware from tampering with them?

Part of the problem is that signatures alone do not prevent malware - a cryptographically-signed 
virus is still a virus - and if self-signing was permitted, it doesn't prevent tampering either - 
it's possible for a virus to simply strip digital signatures off a jar ("delete META-INF") and 
re-sign it with its own key. (This isn't a hypothetical, either: fractureiser does contain code to 
remove digital signatures from the jars it infects.)

Signed mods with online signature verification *does* seem like a somewhat promising way forward, 
though it's not without tradeoffs. There will be [a meeting](2023-06-08-meeting.md) with
many different reps from the modding ecosystem to discuss how to move forward.

### Would it be possible to forbid mods from downloading executable code?

It's not possible. You can't know whether a file contains executable code before you download it, 
and after a file is downloaded, you can't control what is done with it.

* What if my mod downloads a single Java class file?
* What about a Java class file but spelled backwards, so it doesn't look like a class file at first?
* What about a Java class file but encrypted?
* What about Java *source* code that is compiled on your computer?
* What about a Python script?
* What about a file containing English prose where it just so *happens* that sentences with an 
even number of words correspond to a 0, and sentences with an odd number of words correspond to 
a 1? - even though it's a prose document I can technically reassemble it into 
an `.exe`, if I so choose.

### Is this related to that Spigot plugin malware going around?

Possibly! There's some ties to the existing malware `skyrage` - the malware author uploaded a 
skyrage-relevant `.jar` to their backup command&control server, in a fruitless attempt to 
extend the attack, shortly before CloudFlare took it down anyway.

**We have not received any reports of anyone becoming infected by Skyrage through this vector.** 
The author updated their CloudFlare URL to point to Skyrage a significant length of time *after* 
the hardcoded IP address in stage0-infected mods was already taken down. It's mostly a funny 
curiosity that the attacker tried to serve this jar at all.

skyrage is an existing, well-studied piece of malware and you can find some more info about 
it [here](https://ljskatt.no/analysis/updater_class/).
