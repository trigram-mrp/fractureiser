### Timeline

The timeline is from bottom-to-top. Topmost events are the most recent.

---
*2023-06-08 05:11 UTC*

Prospector announces the following:

> An update from Modrinth, all files uploaded in the last 10 months
> (about half of our files) have been scanned and not one infected
> file has been found.

---
*2023-06-08 01:12 UTC*

Things have mostly settled down again, virus scanners have begun detecting the stage 1+
jars as malicious, and a meeting for next steps is planned for the next morning in the US.

The meeting will be semi-private, but recordings/minutes will be shared afterwards.

CurseForge is scanning all mods, but that process is still ongoing.

---
*2023-06-07 18:51 UTC*

The second C&C server 107[.]189.3.101 has been suspended by its hosting provider

---
*2023-06-07 16:00 UTC*

Due to lag in the HackMD, this document was transferred to the GitHub repository
https://github.com/fractureiser-investigation/fractureiser

---
*2023-06-07 14:40 UTC*

The unobfuscated stage 3 was replaced by an obfuscated one, then further by another
payload.

That payload is the skyrage updater, which is a known Minecraft malware targeting spigot
servers.

After serving skyrage for a while, it switched again to serving the Meteor hacked client.

(TODO this timeframe is not completely accurate)

---
*2023-06-07 14:20 UTC*

Analysis of the new IP address yields a fully deobfuscated stage 3, seemingly uploaded by accident.
It has been archived here: https://github.com/clrxbl/NekoClient

---
*2023-06-07 14:19 UTC*

The Cloudflare pages domain has been taken down.

---
*2023-06-07 14:05 UTC*

The Cloudflare pages domain has switched to pointing to a new IP address, 107.189.3.101.

---


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

Investigation has slowed down and most of the team is going to bed. unascribed has opened an email inbox for people to submit samples or other useful information. williewillus is currently working to clean up and get the information presented by D3SL into this doc. 

----

*2023-06-07 6:20 UTC*

D3SL informs the unofficial Discord that they have a copy of the full (untruncated) Stage 3 `client.jar`, as well as an in-depth analysis of what the malware is doing. They first noticed this weeks ago and undertook in-depth analysis, and as a result was able to obtain full copies of all the payloads.

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

*2023-06-01 to 2023-06-04*

D3SL becomes suspicious of the malicious files' consumption of CPU and RAM and begins
investigating. Order of operations:

1. Suspicion about the Java executable's firewall request leads to it being blocked.
2. Inability to reach self-hosted services leads to event viewer showing all tcpip ports
   blocked
3. Netstat shows massive port consumption via the hostile jar file's PID
4. Identifying the malicious javaw.exe running libwebgl64.jar confirmed malware

From here Tzalumen was instrumental in assisting with the initial reverse engineering of
the byte[] obfuscated code and manually capturing a complete set of files from the remote
destinations.

Full copies of all original files (incl. deobfuscations) except lib.dll, translations of
all remote destinations contacted, and a writeup of the infection process and several
hostile capabilities were provided through channels to Windows Defender and
Malwarebytes. Curseforge was notified as well. Knowledge of the malware wasn't shared
publicly at this time in order to avoid tipping off the attackers

----
