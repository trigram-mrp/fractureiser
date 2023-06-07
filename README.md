# Modded Minecraft Malware "fractureiser"

## What?
`fractureiser` is a [Worm](https://en.wikipedia.org/wiki/Computer_worm) Virus found in several Minecraft projects uploaded to CurseForge and CraftBukkit's dev website. The malware is embedded in multiple mods, some of which were added to highly popular modpacks.

If left unchecked, fractureiser can be **INCREDIBLY DANGEROUS** to your machine. Please read through this document for the info you need to keep yourself safe.

We've dubbed this malware `fractureiser` because that's the name of the CurseForge account that uploaded the most notable malicious files.  
*Pardon our dust*, this is a living document being edited by multiple people about a developing situation. Some sections may be messy.

---

## Current Investigation status
We have a good idea how fractureiser works, from stages 0 to 3. There are certain unknowns, but stage 0 bootstrapping was quickly nipped and tomorrow we'll be moving our focus to mitigation. As a plan, we've contacted Mojang and will likely be working with teams to get detection software distributed and integrated into CurseForge and Modrinth, as well as considering integration in launchers like Prism, and mod loaders like Fabric and Forge. It is also worthwhile to run this detection software on mod distribution mavens, as it's possible some have become infected.

Most of the current team responsible for updating this doc is tired and going to bed (as of 02:46a Pacific time). Others are continuing to reverse engineer stage 3.

Work has begun on a detector for infected stage0 mods: https://github.com/MCRcortex/nekodetector

## What YOU need to know

TODO

## Additional Info

If you have files relevant to this malware, please upload them to https://wormhole.app and email the URL to fractureiser.investigation@opayq.com — this inbox is controlled by xylemlandmark, and anything sent to it will be shared with the rest of the team. **Please also let us know if you have the ability to download files from VirusTotal**, as that would let us get ahold of many of the files we're missing. We are looking especially for one `lib.dll`.

If you need to get in touch more generally, please send mail to jaskarth4@gmail.com.

If you copy portions of this document elsewhere, *please* put a prominent link back to this [GitHub Repository](https://github.com/fractureiser-investigation/fractureiser) somewhere near the top so that people can read the latest updates and get in contact.


The **only** official public channel you may join without being personally invited that's *run by the same team that wrote this writeup* is [#cfmalware on EsperNet IRC](https://webchat.esper.net/?channels=cfmalware). 
You may join the channel if you wish, but due to an influx of new users we've set the channel +m, you will need permission to speak. **Joining an IRC channel will expose your IP address.**

IRC logs: TODO


## Credits
Nonextensive! Thank you to all that pitched in. We'll flesh this out after this all blows over.

**D3SL**: Extensive reverse engineering, early discovery learned of later  
**Nia**: Extensive stage 3 reverse engineering  
**Jasmine**: Coordination, writing the decompiler we've been using (Quiltflower)  
**Emi**: Coordination, initial discovery (for this team), and early research  
**williewillus**: Coordination, journalist  
**quat**: Documentation, initial infected sample research  
**xylemlandmark**: Coordination of documentation, crowd control, responsible for using Snopyta at first and the disaster that caused
