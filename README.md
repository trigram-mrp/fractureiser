# Modded Minecraft Malware "fractureiser"
*Pardon our dust, documentation not finalized*

This is a living document that is being edited by multiple people about a developing situation. 

We apologize for the inconvenience of any formatting issues, this means that some sections may be messy.

## What?
`fractureiser` is a [Virus](https://en.wikipedia.org/wiki/Computer_virus) found in several Minecraft projects uploaded to CurseForge and CraftBukkit's dev website. The malware is embedded in multiple mods, some of which were added to highly popular modpacks.

If left unchecked, fractureiser can be **INCREDIBLY DANGEROUS** to your machine. Please read through this document for the info you need to keep yourself safe.

We've dubbed this malware `fractureiser` because that's the name of the CurseForge account that uploaded the most notable malicious files.  

## What YOU need to know

### [Mod PLAYERS Click Here](docs/users.md)

If you're simply a mod player and not a developer, the above link is all you need. It contains surface level information of the malware's effects, steps to check if you have it and how to remove it, and a FAQ.

Anyone who wishes to dig deeper may also look at
* [Event Timeline](docs/timeline.md)
* [Technical Breakdown](docs/tech.md)

## Current Investigation Status
We have a good idea how fractureiser works, from Stages 0 to 3. There are certain
unknowns, but Stage 0 bootstrapping was quickly nipped and tomorrow we'll be moving our
focus to mitigation.

Work has begun on a detector for infected Stage 0 mods:
https://github.com/MCRcortex/nekodetector and arranging for this detector to be run on
Modrinth.

The threat actors attempted to bring up a new server IP. In the process, they accidentally
uploaded an unobfuscated version of Stage 3. This allowed us to further understand the
malware and what it does.

As of the time of writing this new control IP has been taken offline by its hosting provider.

## News

### Curseforge

Curseforge is fully aware of this ongoing problem and peforming their own investigation. 
You can see their latest updates in their [Discord](https://discord.com/invite/curseforge) server.

Their most recent announcement was at `1686153780` or Wednesday June 07 2023 16:03:00 GMT+0000, and is as follows follows:
> 📢 UPDATE: Repeated Questions
> 
> Hey all, as we are still seeing some misconceptions regarding the current situations, please note the following:
> 
> ONLY Minecraft is affected. This malware specifically targets Minecraft JAR files and nothing else. Any concerned players can rest assured their Addons, CC and non Minecraft mods are safe.
> We are currently in the process of scanning all Minecraft projects to detect any other affected projects and make sure you are safe to update and use your mods with Minecraft. Estimated time for this process is around 12 hours.
> 
> Once we have more information and can recommend more actions to you (beyond using the previously mentioned tool ⁠📢news⁠) we will post here.

## Additional Info

If you have files relevant to this malware, please upload them to https://wormhole.app and email the URL to fractureiser.investigation@opayq.com — this inbox is controlled by xylemlandmark, and anything sent to it will be shared with the rest of the team. If you need to get in touch more generally, please send mail to jaskarth4@gmail.com.

If you copy portions of this document elsewhere, *please* put a prominent link back to this [GitHub Repository](https://github.com/fractureiser-investigation/fractureiser) somewhere near the top so that people can read the latest updates and get in contact.

The **only** official public channel you may join without being personally invited that's *run by the same team that wrote this writeup* is [#cfmalware on EsperNet IRC](https://webchat.esper.net/?channels=cfmalware). 
You may join the channel if you wish, but due to an influx of new users we've set the channel +m, meaning you will need permission to speak. 
**Joining an IRC channel will expose your IP address.**

IRC logs: TODO

---

\- the [fractureiser Mitigation Team](docs/credits.md)
