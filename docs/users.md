# Modded Players Guide

If you're a Modded Minecraft player, you need to verify if you have been infected by the fractureiser malware to ensure your machine and personal data are not at risk. You can do so with the instructions below.

Additional info on what to do if you are or are not infected will also be provided after the diagnostic steps.

## Am I Infected?

As of current knowledge, fractureiser specifically targets Linux and Windows installations. If you are on any other Operating System, you are not infected. The way to verify if you are infected is by looking for specific files in your system, as such:

### Windows Instructions

* Open your Start menu with the Windows Key, and type `%localappdata%` - it should appear as such:
![Search results for the above query](media/localappdata.png)

* Inside the Local appdata folder, you must ensure that your Explorer is set to view both `Hidden Items`, and `Protected Operating System Files`. 
  * This can be done from View > Options
  * If you are unsure how to do this, a video explanation [can be found here](https://youtu.be/KLTlTlnXeKs).


* Locate a folder named `Microsoft Edge`. The SPACE between "Microsoft" and "Edge" is important - as `MicrosoftEdge` is a legitimate folder that is used by Edge. The virus simply named it like that to disguise itself.
* If `Microsoft Edge` is present, you were infected. If this is the case, permanently delete the folder and everything inside it.
  * If the folder can not be deleted, you must stop any Java programs currently running via your Task Manager.

Afterwards, follow onto the next section of this page that is relevant to you.

### Linux Instructions

Firstly, ensure whichever method you are using to list files has the ability to view hidden files. If doing this on a terminal, use `ls -a` in the respective directories.

If any of the following files exist, you were infected. If this is the case, delete all of them:
* `~/.config/systemd/user/systemd-utility.service`
* `/etc/systemd/system/systemd-utility.service`
* `~/.config/.data/lib.jar`

Upon doing so, if applicable, check your `systemctl` for any changes you may not recognize. Afterwards, follow onto the next section of this page that is relevant to you.

## MacOS Information

The malware does not seem to affect MacOS, so you should be fine. *Recheck this doc in the future if this changes*

### Scripts

*If you don't know how to run a PowerShell or Bash script, these are not for you.*  
Automated PowerShell or Bash scripts are also available [on the PrismLauncher website](https://prismlauncher.org/news/cf-compromised-alert/#automated-script) to do this for you, if you have the technical knowhow to run them. Overwolf (Curseforge's parent company) has also released a C# detection tool: https://github.com/overwolf/detection-tool

## I'm Infected, Now What?

**IMPORTANT**: We do not currently know the full extent of everything this can do, nor what its intent is, so extreme caution should be exercised until a complete way to remove any symptoms is found. Everything stated here is only *what we know* - please keep an eye on communication from the team on updates if anything critical is found.

If you have been infected by fractureiser, your best option now is to assume everything on the computer that was infected is *entirely compromised*. Any file, account, password you may have it in it, as well as access to the computer itself is at the hands of the virus's authors. You should:
* Back up anything you do not want to lose on an a flash drive or external disk (you should be doing this regularly anyway!)
* Using a separate device, change ALL of your passwords (preferably using a password manager like [BitWarden](https://bitwarden.com))
* If you were not yet using Two-Factor Authentication for every service that supports it (such as an Authenticator App (best) or SMS (not great but better than nothing)), please start doing so immediately
* If you are able to, contact a professional service in your area to run a proper diagnostic on your machine for anything suspicious, or simply wipe and reinstall the system.
* Read the below section on what to do if you're not infected, as the steps there apply to you too.

## I'm Not Infected, Now What?

The absolute safest thing you can do at the moment is to **not launch Minecraft at all**. Yes, even Vanilla.  
We do not know 100% everything that's compromised, and there's no way to guaranteed any one given installation has not been corrupted by a step of the code we have not found yet.

With that said - if nothing was found in the first place, chances are there's nothing going on.
If you still want to play the game:
* With the current knowledge we have, this is not risky, but we do not guarantee this is accurate - you are *willingly putting yourself at risk*.
* After each session, check for the infection files in the previous step to ensure nothing has happened since
* Do not, under **any circumstances**, download or update any mods, modpacks, or plugins you may use, or even run any you downloaded and never ran before - stick to instances you have already used, and those **only**

### What Actually Happened?

A number of Curseforge and dev.bukkit.org (not the Bukkit software itself) accounts were compromised, and malicious software was injected into copies of many popular plugins and mods. Some of these malicious copies have been injected into popular modpacks including Better Minecraft. *There are reports of malicious plugin/mod JARs as early as mid-April.*

This malware is composed of multiple "stages", each Stage is responsible for downloading and running the next one. In total, there are three known Stages (Stages 1, 2, and 3), with infected mod files serving as a "Stage 0" to kick the whole process off.

Stage 3 is the "mastermind" of the malware, and we have evidence that it attempts to do all of the following:
* Propagate itself to *all* `jar` files on the filesystem, possibly infecting mods that
  were not downloaded from CurseForge or BukkitDev or other Java programs
* Steal cookies and login information for many web browsers
* Replace cryptocurrency addresses in the clipboard with alternates that are presumably owned by the attacker
* Steal Discord credentials
* Steal Microsoft and Minecraft credentials

(See [technical details](tech.md) for more info)

Because of its behavior, we are **very confident** this is a **targeted attack against the modded Minecraft ecosystem**. It's quite bad.

**Until further notice, exercise extreme caution with Minecraft mod downloads, regardless of origin.** While the control server for this malware is currently offline, **any download from Curseforge or the Bukkit plugin repository in the last 2-3 weeks should be treated as potentially malicious**. This malware is unlikely to be detected by Windows Defender or similar antimalware products.

The affected accounts had two-factor authentication enabled. This is not a simple password compromise situation. Multiple accounts are affected.

*At this point we cannot be confident claiming any hosting service is unaffected*. Please exercise caution regardless of what site you use. Even Maven repositories may be infected, and this malware goes back months.

Right now, the malware is dormant due to the loss of its C&C (Command and Control) server and the Stage 0 (what was distributed via mods and modpacks) not having a way to get a new server. If you were infected with Stage 2 (the file described below, dropped by Stage 1 when C&C was up), then **the malware is still active.**

### Given a jar file, how do I know if it's safe?

There are various heuristics you can use to determine whether a jar is infected with Stage 0.

Emi's shell script [here](https://gist.github.com/emilyploszaj/a9693c4f3de5ec9fbc255c51ff3ca47e) simply checks for all usages of `ClassLoader`, which is uncommon in mod code. This can lead to false positives and negatives. For example, it falsely flags the latest Quark 1.19 file as infected when it is not.

Sylv's shell script [here](https://pastebin.com/T6aQ7C2E) does a bit more fingerprint matching for the malware, and should be more precise.

As a non-technical user, your best course of action is to check if your system was affected using the above steps, remediating if necessary, and refraining from downloading anything from CurseForge or dev.bukkit.org until further notice.

### What the f*** is a Stage?

![](media/stages.png)
