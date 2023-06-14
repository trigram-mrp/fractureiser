# Anleitung für Spieler mit Mods

Falls Sie **nur** Vanilla mit einem vertrauenswürdigen Launcher, wie dem offiziellen Launcher oder dem Prism-Launcher gespielt hat und niemals Mods verwendet haben: Sie sind zu 100% sicher. Halten Sie sich vorerst von Mods fern.

Falls Sie ein Modded Minecraft-Spieler sind müssen Sie prüfen, ob Sie von der fractureiser-Malware infiziert worden sind, um sicherzustellen, dass ihr Computer und ihre persöhnlichen Daten nicht gefährdet sind. Dies können Sie mit den Anweisungen unten.

### Läuft der Angriff noch?
**Nein. Nun, ein bisschen.**  
Nach dem aktuellen Wissenstand wurde das `fractureiser`-Virus vollständig von öffentlichen mod(pack)s entfernt.

Aktuell glauben wir, dass Nutzer, die mit dem Stage2-Checker auf dieser Seite gescannt haben, sicher weiterspielen können. Allerdings gibt es nun die Möglichkeit für Trittbrettfahrer, neue Viren zu schreiben, da die Uploads auf Curseforge und Modrinth wieder aktiviert wurden.

Wir stehen mit allen Beteiligten in Kontakt, um Vorgänge und Protokolle zu etablieren, die dies in der Zukunft verhindern sollen.

Bitte gehen Sie sowohl die Schritte auf dieser Seite, als auch die Folgeabschnitte, falls Sie infiziert oder nicht infiziert sind, durch, wenn Sie spielen wollen.

### Seitenaufbau
* [Was ist eigentlich passiert?](#was-ist-eigentlich-passiert)
* [Bin ich infiziert?](#bin-ich-infiziert)
* [Ich bin infiziert, was jetzt?](#ich-bin-infiziert-was-jetzt)
* [Ich bin nicht infiziert, was jetzt?](#ich-bin-nicht-infiziert-was-jetzt)
* [Häufig gestellte Fragen](#häufig-gestellte-fragen)
* [Technisches FAQ](#technisches-faq)

Lesen Sie diese Seite vollständig, inklusive dem FAQ am Ende, falls Sie Fragen zu fractureiser haben, da die meisten Fragen, die wir erhielten hier beantwortet werden.

## Was ist eigentlich passiert?

Mehrere unauffällige böswillige Mods und Plugins wurden ursprünglich vom Ersteller der Malware auf die Mod-Hosting-Website CurseForge und die Plugin-Seite dev.craftbukkit.org (nicht die Bukkit-Software selbst). Ein wichtiger Mod-Pack-Developer lud sich einer dieser Mods herunter, um sie auszuprobieren. Dabei wurden unbemerkt Dateien auf seinem/ihrem Computer infiziert, darunter die Kopie eines Projektes, die dann als unaufällige Datei auf CurseForge hochgeladen werden würde.

Dieser Prozess wiederholte sich einige Male bei anderen Nutzern von CurseForge und dev.craftbukkit.org, wobei Kopien von mehreren beliebten Plugins und Mods infiziert wurden. *Es gibt Meldungen von infizierten Plugin und Mod Jar-Dateien, die bis Mitte April zurückreichen.*

Gleichzeitig versuchte der Autor der Malware mithilfe einer Brute-Force-Attacke Zugriff zu Accounts beliebter Ersteller auf CurseForge zu erhalten. Es ist derzeit unbekannt, ob Attacken erfolgreich waren oder ob die Besitzer der Accounts mit der Malware infiziert wurden.

Die Malware besteht aus mehreren Stufen ("stages"). Jede Stufe ist für das herunterladen und ausführen der Nächsten verantwortlich. Insgesamt gibt es drei bekannte Stufen (Stage 1, 2, 3) und infizierte Mod-Dateien als "Stage0", die den Prozess starten.

Stage3 ist das "mastermind" der Malware und sie wurde beim folgenden beobachtet:

* Verbreitung zu *allen* `jar`-Dateien auf dem Dateisystem, auch Mods, die nicht von CurseForge oder BukkitDev heruntergeladen wurden oder anderen Java-Programmen
* Stehlen von Cookies und Login-Informationen von vielen WebBrowsern
* Ersetzen von kopierten Cryptowährungs-Addressen in der Zwischenablage mit anderen, vermutlich dem Angreifer gehörenden
* Stehlen von Discord-Logindaten
* Stehlen von Microsoft- und Mojang-Logindaten

(Siehe [technische Details](tech.md) für mehr Informationen)

Aufgrund seines Verhalten sind wird uns **sehr sicher**, dass es sich um eine **gezielte Attacke gegen das Minecraft-Modding-Ökosystem** handelt.

**Bis auf weiteres ist mit heruntergeladenen Minecraft-Mods höchste Vorsicht geboten, egal, woher sie kommen.** Der Kontroll-Server der Malware ist zwar derzeit offline, aber **jeder Donwload von CurseForge oder dev.craftbukkit.org in den letzten 2-3 Wochen sollte als potentiell bösartig angesehen werden**. Einige Malware-Scanner haben begonnen, Signaturen der Malware in ihre Datenbanken hinzuzufügen, aber seien Sie, bis alle Scanner diese Signaturen erhalten haben, vorsichtig.

*Derzeit können wir für keinen Hosting-Service garantieren, dass er nicht betroffen ist*. Bitte lassen Sie Vorsicht walten, egal, welche Seiten Sie verwenden. Sogar Maven Repositories können betroffen sein und diese Malware ist Monate alt.

Aktuell sind keine neuen Infektionen möglich, da der Server des Angreifers ausgeschaltet ist, bestehende Infektionen sind eventuell immer noch aktiv.

<!--### Get to the point, how do I fix this?

![Flowchart](media/flowchart.png)-->

### Was zur Hölle ist eine Stufe/stage?

![Stage Diagram](media/stages.png) <!-- TODO: Translate image into German-->

## Bin ich infiziert?

Die Malware hat mehrere Stufen, also ist die Frage, ob Sie infiziert sind, eigentlich zwei Fragen

### Besitze ich mit Stage0 infizierte Mods?
Es gibt viele Scanner, die eine Mod-Datei auf eine Infektion mit Stage0 überprüfen können.

* Der [Scanner]((https://github.com/overwolf/jar-infection-scanner/releases)) von Overwolf
  * Dies ist empfohlen, wenn Sie ihr gesamtes Spiel prüfen wollen - Stellen Sie einfach nur den CurseForge-Ordner oder den Ordner, in dem sich Ihre Instanzen befinden, ein
  * Dieses Programm funktioniert auch ohne die Overwolf-App
* Der [web-basierte Onlinescanner](https://douira.github.io/fractureiser-web-detector/) von douira
* [nekodetector](https://github.com/MCRcortex/nekodetector/releases) von cortex
  * Klicke auf "Assets", um die ausführbare Datei anzuzeigen - Java wird benötigt

Alleine ist eine Infektion mit Stage0 harmlos, wenn die Dateien gelöscht werden und niemals ausgeführt wurden.

### Sind Stage2-Dateien auf meinem System?

Wenn Stage2-Dateien auf Ihrem System sind, bedeutet das, dass Stage0 und Stage1 erfolgreich ausgeführt wurden.
Falls Sie präsent sind, ist ihr Computer vermutlich *vollständig infiziert* und Sie sollten die Anweisungen in diesem Dokument weiter lesen.

Viele Virenscanner beginnen, Stage2-Dateien zu erkennen. Falls Sie eine Warnung, dass solche Dateien erkannt und entfernt wurden, sollten Sie den "Ich bin infiziert, was jetzt?"-Abschnitt lesen.

Ansonsten können Sie selbst wie folgt eine Überprüfung durchführen:

#### Auf Windows

* Öffnen Sie ihr Startmenu mit der Windows-Taste und geben Sie `%localappdata%` ein - es sollte so aussehen:
![Suchergebnisse für die Anfrage oben](media/localappdata.png)

* Stellen Sie dann sicher, dass ihr Explorer sowohl
`Versteckte Dateien`, als auch `Geschützte Systemdateien` anzeigt.
  * Dies können Sie in Ansicht > Optionen machen
  * Falls Sie nicht wissen, wie [finden Sie ein Videotutorial hier](https://youtu.be/KLTlTlnXeKs).
  * Auf Windows 11 sind die gleichen Optionen beim dem Ansicht-Button und beim "..."-Button rechts daneben.

* Suchen Sie nach einem Ordner names `Microsoft Edge`. Die LEERTASTE zwishcen "Microsoft" und "Edge" ist wichtig - `MicrosoftEdge` ist der legitime Ordner, der von Edge verwendet wird.
Der Virus benannte ihn nur so, um sich zu verstecken.
  * Der legitime Ordner kann auch `Microsoft\Edge` heißen (ein `Edge` Ordner in einem
`Microsoft` Ordner).
  * Der legitime Ordner *muss* nicht existieren - wenn es keine Edge-Ordner gibt, sind Sie sicher.
  * Es können auch beide legitime Ordner gleichzeitig existieren.
* Wenn `Microsoft Edge` existiert, sind Sie infiert. Löschen Sie in diesem Fall den Ordner und seinen Inhalt dauerhaft.
  * Wenn der Ordner nicht gelöscht werden kann, stoppen Sie alle Java-Programme mit dem Task Manger.

#### Auf MacOS

Die Malware scheint MacOS nicht anzugreifen, also besteht keine Gefahr.
*Schauen Sie immer mal wieder hier vorbei, falls sich dies ändert.*

#### Auf Linux

Stellen Sie zuerst sicher, dass die Methode, mit der Sie Dateien auflisten versteckte Dateien anzeigen kann.
Bei den meisten GUI-Dateimanagern können Sie mit der Tastenkombination Strg+H die versteckten Dateien anzeigen.
Falls Sie ein Terminal verwenden, führen Sie `ls -A` (oder `ls -lha` für mehr Details) in den entsprechenden Ordnern aus.

Falls eine der folgenden Dateien existiert, sind Sie infiziert. Löschen Sie in diesem Fall jede dieser Dateien:
* `~/.config/systemd/user/systemd-utility.service`
* `/etc/systemd/system/systemd-utility.service`
* `~/.config/.data/lib.jar`

Nachdem Sie dies getan haben, überprüfen Sie `journalctl` nach Änderungen, die Sie nicht erkennen.
Dies können Sie mit dem Befehl `journalctl -exb` (für System-Logs) und `journalctl -exb --user` 
(für Nutzer-Logs).
Führen Sie die folgenden Befehle aus, um ihre Systemd-Dienste neu zu laden:
```sh
sudo systemctl daemon-reload # Geben Sie Nutzer-Passwort ein.
systemctl --user daemon-reload 
```

#### Skripte

*Nutzen Sie diese nur, wenn Sie wissen, wie man ein PowerShell- oder Bash-Skript ausführt.*  
Automatische PowerShell- und Bash-Skripte zur Überprüfung auf Stage2 sind auch [auf der PrismLauncher
website](https://prismlauncher.org/news/cf-compromised-alert/#automated-script) erhältlich, falls Sie das technische Wissen haben, um die Skripte auszuführen. Overwolf (Muttergesellschaft von CurseForge) hat auch ein in C# geschriebenes Erkennungswerkzeug für Stage2 veröffentlicht:
https://github.com/overwolf/detection-tool

## Ich bin infiziert, was jetzt?

**IMPORTANT**: We do not currently know the full extent of everything this can do, nor what its
intent is, so extreme caution should be exercised until a complete way to remove any symptoms is
found. Everything stated here is only *what we know* - please keep an eye on communication from the
team on updates if anything critical is found.

If you find stage 2 files from fractureiser on your system, it's very likely that the stage 3 code
has ran and infected your machine.  
Your best option now is to assume everything on that system is *entirely compromised*. You should:

* Back up anything you do not want to lose on an a flash drive or external disk (you should be
doing this regularly anyway!)
* Using a separate device, change the passwords to all services you were logged into on
  the old machine (Discord, email, etc.). Preferably using a password manager like
  [BitWarden](https://bitwarden.com).
* If you were not yet using Two-Factor Authentication (Authenticator app or SMS) for every service
that supports it, please start doing so immediately
* If you are able to, contact a professional service in your area to run a proper
  diagnostic on your machine for anything suspicious, or as a safe default simply wipe and
  reinstall the system.
* Read the below section on what to do if you're not infected, as the steps there apply to you too.

## Ich bin nicht infiziert, was jetzt?

If nothing was found by the stage 2 detector, chances are there's nothing going on and you're good
to play.

While `fractureiser` has been cleaned out, new viruses may appear in the near future until we 
establish new protocols. If you want to play the game, we recommend:

* Play exclusively mods and modpacks that you have already downloaded and verified safe.
* Avoid downloading anything uploaded after the 8th of June from new or unknown authors, for the
same reason as the previous point.
* Avoid updating your mod(pack)s.
* Keep an eye on communication from the team on developments regarding new methods to detect
issues like this in the future.

## Häufig gestellte Fragen

### Is CurseForge hacked?
CurseForge itself is not compromised, only individual users. This is not a CurseForge problem, they
just happened to the be place this happened in. CurseForge have also [posted an article](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) describing the situation from their end and
are working on deploying countermeasures.

### Is Modrinth okay?
Modrinth has ran a full scan of the last 10 months of uploads and no infected projects were found. 
We still recommend exercising extreme caution when downloading anything mod related at the moment. 
The fact no mods were infected there was entirely luck.

### Is Modrinth safer?
This isn't a website-level issue, Modrinth is just as safe as CurseForge is.

### How did CurseForge let this slip through?
The code the stage 0 infection ran wasn't necessarily suspicious to an automated system, and could
very well have been something another mod would've used. In fact, early heuristics for determining
stage 0 infection had significant amounts of false flags on popular mods such as Quark.

Realistically, this type of prevention on a platform scale is non-feasible due to the infinite
different ways you can lay out code to hide your intent.

### Which Antiviruses catch this?
New ones are being added as we speak, it's best to do the manual verification above instead of
relying on AV for now.

### Is Multiplayer safe?
Yes, you can not be infected via a multiplayer server if you don't download mods for it elsewhere.

### Is Bedrock safe?
Yes, this affects only Java.

### Are alternative game clients such as Lunar or Badlion safe?
See the below point.

### Is Optifine safe? / Is Sodium safe? / Is Iris safe? / Is Create safe? / Is Essential safe? / Is (insert mod) safe?

**We can not currently fully confirm the safety of any given mod.**

One of the functions of stage3 of the virus is infecting as many .jars as it can find on your 
computer. It can infect **all `.jar`s**, including Minecraft itself (vanilla/modded), Minecraft 
mods, Spigot plugins, and unrelated Java applications. So if your computer has the stage3 portion 
of the virus, it doesn't matter whether a mod you download is "safe" - it will *become* infected. 
Detect and remove the later stages of fractureiser *first*.

At the moment, all *known* infected mods have been removed from CurseForge. CurseForge [posted a 
list of known infected mods](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) (bottom
of the page) and has removed them from the website. Modrinth has scanned back 10 months and has not found any infected mods. 

This does *not guarantee no sneaky ones slipped through*. To check whether a given jar contains 
stage0 of fractureiser, check the [Am I Infected?](#am-i-infected) section and overall exercise
extreme caution downloading anything mod related for now.

### How widespread was the infection?

CurseForge is reporting infected files were downloaded roughly 6,000 times for the entire 
infection period. Quote from CF's Discord announcement: 
> Just to give perspective, this accounts to about 0.015% of CurseForge’s daily downloads 
> for Minecraft.

### Did someone want to spoil the 1.20 release event?

It appears to be a coincidence - this malware campaign was active for quite a while before being 
widely uncovered the morning-of the 1.20 release.

## Technisches FAQ

### Can fractureiser escape VMs (Virtual Machines)?

**No.**

stage3 *does* contain code for *attempting* a *manual* escape from the 
["Windows Sandbox"](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview).
It does not happen automatically. If the virus is ran from the Windows Sandbox, it will try to
mess with the clipboard to trick you into pasting a shortcut to the malware.

Note that this sort of "clipboard escape" is nothing new and it is very easy to defeat by simply
not sharing the clipboard between the host and guest OS. Use a more heavyweight virtual-machine
than the "Windows Sandbox", and disable features like VirtualBox's "Guest Addons" or Hyper-V's
"integration services".

(*Real* virtual-machine escape exploits are worth millions of dollars and would not be burned on
some Minecraft kids, and we have reason to believe the author of this malware is not a very good
programmer in the first place.)

### Does this spread over the network?

As far as we know, fractureiser does not contain network spread functionality, but it is not fully
out of the question.  
A security researcher we are working with got an alert, but it ended up being about completely 
unrelated malware that happened to use a similar filename. This was just a false alarm.

### What are CurseForge and Modrinth doing about it?

CurseForge has developed an open-source [stage2/3 detection tool](https://github.com/overwolf/detection-tool) 
and [stage0 detection tool](https://github.com/overwolf/jar-infection-scanner), have scanned *all* 
uploaded mods/plugins for stage0 infections, and have deleted all *known* infection cases.

Modrinth has also scanned uploaded mods/plugins for stage0 infections going back 10 months and did 
not find any.

Both platforms are considering introducing some sort of automated "virus scan" process to the mod 
submission pipeline. It's hard, since Java malware like this is typically bespoke.

### What IP addresses and URLs should I block in my firewall/routing table?

fractureiser-related code has been observed to connect to these URLs and addresses over a wide 
variety of port numbers.

* The hardcoded address in stage0-infected mods, and the first observed command&control 
server: `85.217.144.130`
* The second observed command&control server: `107.189.3.101`
* The fallback URL that stage1 tries to use, and the stage2 command&control hostname: 
`files-8ie.pages.dev`

There's also evidence of it trying to connect to the hostname `v2202209151437200088` 
over port 25575 - unknown reasons; probably from an older version of the malware.

Here are some additional addresses to firewall related to skyrage stuff (again, *very* unlikely 
skyrage was downloaded to anyone's PC through this vector, but nothing good comes from these 
addresses anyway):

* `95.214.27.172`
* `connect.skyrage.de`
* `t23e7v6uz8idz87ehugwq.skyrage.de`
* `qw3e1ee12e9hzheu9h1912hew1sh12uw9.skyrage.de`
* *Probably just block all of `skyrage.de` honestly*

Should go without saying that you should not visit these.

### Can we make it against CurseForge/Modrinth rules for your mod to download other files?

It's already against CurseForge rules to upload malware. There are also many legitimate use cases 
for a mod to download files that this would also stifle.

### Would it be possible to include some sort of "antivirus" or "sandbox" in the modloader itself?

"Antivirus": Probably not, for the same reasons that regular antiviruses didn't detect it. 
Antiviruses can only detect known malware, not unknown malware.

Sandboxing: Including some sort of "does this class contain 'safe' code?" check before loading a 
class is a great way to spur on a cat-and-mouse game between malware developers and modloader 
developers.

It's really hard to ban Java code from using a specific class (say, `URLClassLoader`) because you 
can also refer to it with `Class.forName` (which has a ton of legitimate use-cases), and if you 
ban or deny-list classes from *that*, you can typically find something *else* on the classpath 
willing to call `Class.forName` for you, and trying to get rid of these gadgets is an endless 
game of whack-a-mole.

Sandboxing Java is pretty much impossible - see articles like 
["Twenty Years of Escaping the Java Sandbox"](https://www.exploit-db.com/papers/45517).

Java mods are simply bundles of arbitrary code: treat them like an `.exe`, they can do anything. 

### Why aren't mods cryptographically signed to prevent malware from tampering with them?

Part of the problem is that signatures alone do not prevent malware - a cryptographically-signed 
virus is still a virus - and if self-signing was permitted, it doesn't prevent tampering either - 
it's possible for a virus to simply strip digital signatures off a jar ("delete META-INF") and 
re-sign it with its own key. (This isn't a hypothetical, either: fractureiser does contain code to 
remove digital signatures from the jars it infects.)

Signed mods with online signature verification *does* seem like a somewhat promising way forward, 
though it's not without tradeoffs. There will be [a meeting](2023-06-08-meeting.md) with
many different reps from the modding ecosystem to discuss how to move forward.

### Would it be possible to forbid mods from downloading executable code?

It's not possible. You can't know whether a file contains executable code before you download it, 
and after a file is downloaded, you can't control what is done with it.

* What if my mod downloads a single Java class file?
* What about a Java class file but spelled backwards, so it doesn't look like a class file at first?
* What about a Java class file but encrypted?
* What about Java *source* code that is compiled on your computer?
* What about a Python script?
* What about a file containing English prose where it just so *happens* that sentences with an 
even number of words correspond to a 0, and sentences with an odd number of words correspond to 
a 1? - even though it's a prose document I can technically reassemble it into 
an `.exe`, if I so choose.

### Is this related to that Spigot plugin malware going around?

Possibly! There's some ties to the existing malware `skyrage` - the malware author uploaded a 
skyrage-relevant `.jar` to their backup command&control server, in a fruitless attempt to 
extend the attack, shortly before CloudFlare took it down anyway.

**We have not received any reports of anyone becoming infected by Skyrage through this vector.** 
The author updated their CloudFlare URL to point to Skyrage a significant length of time *after* 
the hardcoded IP address in stage0-infected mods was already taken down. It's mostly a funny 
curiosity that the attacker tried to serve this jar at all.

skyrage is an existing, well-studied piece of malware and you can find some more info about 
it [here](https://ljskatt.no/analysis/updater_class/).