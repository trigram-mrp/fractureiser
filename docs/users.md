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