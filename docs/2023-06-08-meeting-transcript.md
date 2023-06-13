# Transcript of 2023-06-08 meeting

## Opening 

[Start at 00:00:00]

Emi: Hello everyone, I'm Emi, and I'm going to be leading this meeting, representing the Fractureiser Mitigation Team. 

This is gonna be a discussion with community memebers of note about the mitigation for potential future malware incidents.

As a summary, Fractureiser is a 4-Stage, self-updating, self-replicating piece of malware that boardly targets Java programs with the focus on Minecraft and modded communities. 

Stage3 is capable of stealing all browser information, including passwords, payment info, and cookies. It's also capable of stealing Microsoft, Minecraft and Discord credentials along with cryptocurrency. 

Contained is also various botnet utilities for DDoS-ing, the ability to run arbitrary system commands, and all stuff like that. It's a comprehensive pwn on the entire system.

Stage3 is notably capable of spearding Stage 0 to every jar file on the system, to perpetuate itself with special logic to additionaly target Minecraft mods and plugins. 

Uh, the ability to capture browser passwords with further use to increase Fractureiser's virality. 

On June 7th, at about 00:20 UTC, the Luna Pixel modding team announced it detected unauthorized uploads to several of its projects. 

One or more of their team memebers must've been compromised and the attacker has used the login information to upload further instances of the virus. 

Because of the quick response, the team was able to get the malicious server nullrouted, and also prompted attacker to temporarily disable the Stage 2 and its attempt to thwart analysis. 

In the investigation, it was revealed that Fracturiser was presented on mods uploaded as early as April 18th of this year. 

Accroding to CurseForge, 6000 unique users downloaded copies of the virus. 

Because of the popularity of the Lunar Pixel projects, if it was not caught as quickly as was on the 7th, 24 hours could have translated to millions of infected users. 

The purpose of today's meeting is to discuss what to do next. The Fractureiser Mitigation Team has successfully prevented further spread of the virus, and has worked on further detection, mitigation efforts with the community.

And the most dangerous period of it has now passed. But it's necessary to reflect on how easy it was for mailicious actor to pull off attack of scale, and how close they got to significant numbers. 

Today's topic: how do we stop another Fractureiser before it's written?

We have an agenda of five (5) topics today, and I'm gonna hand it off to willie to introduce the first topic. 

## Topic 1: Opaque Review Processes/Security by Obscurity

[Start at 00:02:24]

Williewillus: Alright. Hey everyone, I'm willie, and I've kind of been serving as the secretary of this whole thing.

I kinda wrote up this agenda, that you, uh that is linked in the GitHub, and I guess, I've ordered these topics, 
there's about 4 or 5 of them, from the most realistic or actionable to the most kinda like, "pie in the sky". 

So if we run out of time, we'll probably cut some of the later ones. 

The first one I'd like to start with, I guess, just from the perspective of the community or the incident response, was the questions like what actually happens when a mod repository "reviews" the mod that is submitted. Are there new mod or an update? And what sort of checks are being run, what should be put in place, and those are sort of the question that I'd like to discuss in the first point. 

Back to you, Emi or Jasmine.

Emi: sure, it looks like Fury has requested to speak, so we'll give them the floor. 

Fury: Hi everybody. My name is Fury, and, CEO of Overwolf. Emi, before I touch on this uh first topic, um sorry willie. 

I just want to say, we're... I'm very grateful, we're all very grateful in Overwolf and CurseForge, for all the help we received from a lot of the folks here, 

Super ??? in my opinion, that there is such involvement, dedication and commitment on behalf of the community. The way the things happened, I agree that if this is not caught on time, the impact could've been much more severe.  

The reason I'm here, and not like our engineering team, is that they're working on some mitigations and some sort of actions that we' re actively doing right now, to, based on our understanding, further prevent this thing from happening in the future. 

So that's the first reason. Secondly, I think it's just really, really important both for me and for the rest of the company to show how safety is important for us. 

And I think, particulary in UGC communities, user-generated content, mods, safety is critical, and without safety there is really nothing out there, and everyone would lose trust. Not only the players, not only the creaters, also beginning developers.

And this could turn into a bad reality for everybody, and you know, it's very much against the furture we believe in, so this is why we think safety is critical. And we're gonna do, and we are doing everything we can to improve and to correct and to focus on providing a great, safe to players experiences and consumers.  

Um, so the first question was really which tests are now happening. I want to talk about this from a faily high-level perspective, and the reason why I don't be extremely detailed is we don't want to be in a place, where, everything is out there and open, and people understand exactly which test are performed, and how and maybe we see the code, that is running those tests, so they can find ways to bypass that, so. 

I understand that ambiguity is, um, a concern, especially, and this is why I wanna try sharing as much as I can, from the perspective how we work, but at the same time, hopefully some reviewers can understand that, exposing everything that eventually would lead to vulnerabilities. 

So, for every modded submission, for every submission of the mods, we run automatic checks and then we run, for some mods, manual checks. Manual checks are not being triggered for every single mod update. For some, we're just happy with the automation checks we have.   

Technically, we start by running antivirus scans and malware scans, and uh we use couple of services, um, to do that. 

We check for file tags and inspecting file structures, um, I saw the comment in the kinda of the background of this call on um, signing, antiviruses and SHA-1, just emphasises that our API actually supports um SHA-1, so theroretically we could've used it. There is, um, ability to do that. So we're taking this into account; we are making more clients improvements to make sure this is enforced in a good way.  

Um, in terms of the manual checks, whenever something is triggered, um from these automation checks, then a human would then review the mod. By the way, if someone changes the texts and images, we also require manual review, to avoid profanity and that content, all of these things, um.  

But if those automated checks have trigged some sort of the issue, or there is suspicous, it would be an manual check. 

Also I wanna emphasis that this is continuously evolving process for us, uh so just for example following this incident, we already updated our automatic checks, to um test for this particular vulnerabiliy, and should we identified this particular vulnerability again, it would trigger a manual review, um because we want to double check to make sure that, um, the mod are not compromised.    

I also saw the idea of um [Fury disconnected]

Emi: ah, looks like they've muted. We also have the Geometrically from Modrinth who's here to speak, so uh, if you have any finishing words, go ahead. We want other voices. 

Fury: sorry, uh I got disconnected I think. Can you guys hear now?
 
Emi: yes.

Fury: OK. Can you repeat? I did not listen; I am not here for the first thing what's that?

Emi: Since you muted, and because we want to get as many voices in here as possible, we're going to [be] moving on to Modrinth's perspective, if you have any quick final words, feel free.

Fury: On this topic of which tests were running or in general?

Emi: Yes.

Fury: Um, let me see... Yeah I mean, there are couple more things here but you don't have to have me have microphones. That was too long, so no worries.

Emi: sounds good.

Geo: hey all, can you hear me?

Emi: Yes.

Geo: Hey, I'm Jay, I'm the founder of Modrinth, and yeah, it's great to be here, it's really cool to kinda of see all sides of the community really come together. 

It's crazy that there is 300 people here. But yeah, besides the point, about how we do moderations. 
So, um, our moderation process is, let's say it's pretty robust. 

When we, uh when files are initially uploaded, for new projects we do manual reviews, and during that manual reviews, we check all kinds of things, right? Like the usual description and images, gallary images, all the kind of like the stuff to check for inapproporaite stuff. 

But we also check the source code occasionally, not every single time. If the mod is suspicious or if it's a new author or not really known in the community. 

And if that's the case, right, we will go look at the source code of the mod if it's open source, right, to see like if there's anything suspicious. But if it's closed source, we will occasionally decompile mods, but this isn't happen every time. 

After initial upload, we also run some checks in the backend, mainly for the file structure. 

What we did notice is, like, over the years we've kinda run the site, is that when malware has happened in the Minecraft community, it is bascially never been detected by antiviruses, and antiviruses really is just to have proved to be false positives for everything, as any, like, uh specialized malware for Minecraft mods, would never be detected, as indicated by this incident.

So what we do do is, if it is closed source, and it's a little suspicous, we will decompile it, and we have rejected mods in the past which have had some suspicious code. 

And I do understand this process is inherently flawed. After kind of the initial review, and someone's project passes that, we don't check, um we don't do manual checks for files after that; we basically rely on reports. 

So if someone, let's say, uploads a project and it's like, "hey, I'm gonna be an innocent project at first, and once it's get approved, I am going to upload malware to it." Currently, we would rely on reports to fix that, but ideally we wouldn't have to do that.  

So yeah, I guess like part of the reaason we are here, is to kinda of imporve the moderation process. But as kinda of our principle, all of our code is open-source; we really wanna have like a transparent tool that anybody in the community can use for finding or detecting malware and making mod more safe for all. 

I would say, our modertion process, we generally rely on a lot of community trust, so like if an auther is well known, we generally will kinda be less robust their projects, which might also be flawed. 

But, if authors is like completely new, we'll generally have a lot more scrutiny towards what they upload, and we defnintely have caught some in the past with that.

Emi: sure, thank you. I do have a question. Um, when you say that you check open-source mods, do you do any verification that the source representing the mod is equivalent to the jar that has been uploaded by the user? 

And if [Geo: No it's not] not, should have been there anything put in place to achieve that?

Geo: Yeah this is kinda part of the problem. And basically, ideally, what we could have is a system of reproducible builds, kinda similar to what NPM has done, I think last year, where if a project is uploaded, like GitHub Actions, it'll have, like, a verified symbol that's built from the source.

But now we don't have a way to verify that. And ideally maybe we can have it, so everybody has to upload the source of their mods. They don't have to make a public source, maybe just like, um, to us to build.

That way, like, users can be sure that whatever they put on our site, doens't have malicious code. That's only one way of doing it, and I think, and it might be the most ideal way because authors might now want to share their source code with us, which is totally understandable. 

But yeah, it is definitely a flawed system, and I'm not sure how we should fix it.

Emi: Thank you. And there is an action item here that I would like to ask, what method does Modrinth do 
for verifying integrity of a file that has been uploaded? CurseForge, as it stands, uses MD5 hashes.

Geo: Yeah, so we use, uh, we use a combination of hashes through our API, so, you can use SHA-1, SHA-512. For the launcher we're building, we validate every hash for every file that has downloaded. We kinda leave that more as an implementation deatil for whoever is kinda implementing our API. 

It's like recommended in our documentation, everybody does it, will provide it. SHA-1 is more over-deprecated, because there is vulnerabilities in SHA-1 integrity. 

There is, um, it still requires a lot of compute right now, but it will only be more of a problme as years come. So we rehashed all of our files to SHA-512 about a year and a half ago. So that's the main check of the integrity right now. 

Emi: alright, thank you very much for speaking on this topic. 

## Topic 2: Reproducible Builds

[Starting at around 00:14:28]

Emi: uh, willie, would like to continue on your agenda?

Willie: Yeah. Uh, I think one thing, I just want to, like, plug in (laugh), in this section before I get into next one. Uh I am not, uh this isn't really looking for response, but just one idea that I thought of while listening, is that: we probably want... if it isn't already done - 

similarity checks to like popular mods, 'cause we saw impersonation attempts for few projects during this incident. Another thing is like you might want to flip this around and say that, every upload by a popular modder, or to a popular pack, should be reviewed, if it's an update not an initial project, 

'cause [data lose] a few months might be compromised, or [voice unclear] targets were compromised. But that's just an idea. So, let's go on to the next point, which is reproducible builds. We're kinda on this topic already, but bascially one thing that would've helped the response a lot, is knowing... knowing whether a mod is tampered with Stage 0 infection.

We could've simply just rebuid a mod from the source, hashed it, and compare that hash to every candidate, right? That will cause, "hey, was this mod modified from the version that supposed to be", maybe something is up there. 

Uh, the reason I bring this up is, as the second point, is that it is kinda actionable I think; the problems right now are that Fabric example mod, also Forge's MDK example

Um, uses like `-SNAPSHOT` versions basically, or like, ForgeGradle is like, `5.1.+` or whatever, in the gradle plugins of the default build for ExampleMods. And that's just like one example; there is a lot of, like, irreproducibility in the modding ecosystem; that's kinda like been there since for years, basically. And I think like, we should probably start moving towards like, "hey let's specify the exact versions of for these things," 

and maybe even start using Gradle's checks verification where dumps hashs of all of your dependencies, and you checked in like npm or cargo rust lockfiles. 

Um there is like systems for that, but of course it's Gradle's, so of course it's a mess. 

And another thing is, uh, the modding toolchains, we do a lot of hackery on top of gradle, and there is also, so... to my knowledge, there are some stages where, for example, we remap the jar, or something, we write all the entries in parallel, which can lead to unstable ordering even when the gradle flags that's like "hey please try to be reproducible," cause I have tried doing this for Botania for couple year, like a year ago or so? Just setting the gradle like "hey make it reproducible" flag, and it didn't really work. 

So I am assuming some part of the modding toolchain has non-determinism that we can ruled out, and I think it is pretty actionable. Just examinating every part of the toolchain, making sure we don't violate those assumptions. 

And the crazy idea on the agenda, Geo kinda covered it already, that F-droid-style: we submit the source and it's get built by the mod repo. 

But, as we kinda covered this, this is kinda unrealistic, so I am not gonna spend too much time talking about that. 

So I mainly look for discussion about the stuff I mentioned before, which is making our default templates and the toolchain more, uh, easy to verify and reproduce. 

Emi: sounds great, we have a representative from the Quilt project here that would like to speak on this topic. And I will give them the floor. 

Starchild: Hello, so very quickly, I am the admin and infrastructure lead for Quilt, also I am DevOp experts in my day jobs. 

Um okay, so one issue we have here is that, like later in the discussion, if anyone want to talk about, is signing build. 

Problem is that we are forced to throw away from any form of reproducible build because you can't reproduce a signatures, that's the entire point. 

Considering how particular each project has built, upon here according to the chat we have, Forge will include some timestamp in the build, stuff like that. 

I think it is much more relevant to build specialized tooling to compare different mods together. 

And um maybe even, building an hashing system that actually gonna look at the relevant part, and like not care about timestamp, signature and like that. 

Even if we can have Modrinth and CurseForge implements that, directly show hash directly on the website, we'll have a good way to comparing differnt files together ignoring all the irrevelant part. 

Willie: Sorry I do have a question about signature in like, the reproducibility. So when you say… I am assuming this is for Quilt, but like are the signatures embedded in the jar? Or they are like in the `.asc` files let's say, like separately? Cause like, usually it's like, it's the jar like the only reproducible thing, and you distribute the signature separetly from that, right?

Starchild: As far as I know, I don't think Quilt has any built-in system for signature, and Forge is the only one that has something that uh, I didn't really get adopted; [Willie: ah ok, I see, understand] it makes sense to have it inside the files; it would be a mess to download files, copy to and compare them together, I think.

Willie: um-hum.

Emi: Alright, uh. We have another guest to speak on this topic. From Modrinth again. 

Geo: Yeah I think, uh, this one isn't really Modrinth related, but I think it is important to know the compromise we have to make as a community, which is that: you can never be like 100% secure. 

I guess right now it's like, we can spend a lot of time reviewing each mod, reviewing each new file, uh but that would take a lot of our resources, which is limited, right? And every modder would have to wait, like even if in a week to look through each of the file. 

I think like, one thing is to just keep in mind that accessibility, right? Like a lot of authors, the majority probably don't even really understand how gradle works, right? And a lot of people might not even know how to setup reproducible builds. 

So like, let's say you only have for like a fraction of authors on the site, should you have the rest of mods just not be trusted by the community? And I think that's kind like, one concern I had, right? Would it just basically make it so like smaller mod devs, the barrier to entry for Minecraft modder would be a lot more higher?

I think it's like template mods exist to you right? But like, code-sigining, stuff like that, it's still something when you try to up to the AppStore, or the Android, right? Something like developers struggle with? I think we should still do it, but it should be done in a way that everybody can do.

And enforce reproducible builds are definitely hard, some mods might have some stuff that is a barrier to that, and I think a better solution in general would be just code-signing, where developer sign thair artifacts; that wouldn't fix the problem of people just could swap the source between the builds that ??? actually believes that, right? But you still need to keep in mind that nobody is gonna be checking the source code. 

And I think it's pretty hard for moderator on either Overwolf or us to constantly review for... at every update; we get hundreds of if not thousands of file submissions a day, so it would be really difficult; I think ideally it could something that is automated, but if not, it should be something that is like very easy to do by human moderator, especially because code analysis and the decompiling are both like pretty hard and time-consuming skill to learn.

Emi: Alright, uh we also have another guest to speak from the CurseForge team on this topic, so I am gonna give him to speak now.

Fury: Yeah, just wait a ...

DoctorOyster: Can you hear me?

Fury: Oh sorry. Uh...

DoctorOyster: No no, go ahead.

Fury: Oh thanks. Um, so I think, uh, another, so, you know, I agree that we need to think about accessiblity and code-signing, is maybe more scaleable to do this, uh and for some authors, it's quite complicated than some of the other strategies.
One of the other things we do wanna suggest is that, that could be done on Modrinth as well, is for authors that do choose to go through more extensive security measures, they can have like a tag on their mod, for gamers to see. Or for example, on CurseForge app, we can have like, uh potentially a section. If I am a user and I only wanna download mods with the safest possible, kinda mechanisms, then I'd be able to do that, like a tag associated with mod will not be mandatory for every single mod author.  

Emi: Thank you. Um, I believe that would be a... pretty reaasonable middle-ground solution to do both encourage usage of the software and not harm users that unfamiliar with how to achieve that. 

Uh, do we have anyone else that would like to speak on this topic? Otherwise we can move forward on the agenda. 

### Topic 3: Mods Downloading External Files

[Start at 00:24:57]

Emi: Alright, willie. Can you take forward?

Willie: Yep. 
Um, next topic is a bit a smaller one, and submitted by solo, um, involves like the policies on mods that kinda of like, download extra code at runtime. 

So I think one of the most notorious examples is Essential, which kinda like downloads something that downloads something else that updates the mod, which kinda likes leaves a big hole open to kinda of, getting around everything we are kinda discussing right now. 

Or is like, owolib, gadgets, which kinda of also have its own self updaters, yeah. 

The main question here was like, should we just ban these outright? Just don't allow mods that download other stuff in executed. Um, yeah. 

Fury: So, our thinking was that, uh... each of these mods, that has going donwload addtional files, will be manually reviewed. So, it'll trigger a flag in the automation test, or if we know that this mod has this thing, then it would need to be reviewed manually. 

That's our current thinking, particularly based the recent incident.

Willie: Hmm, I guess the problem is that, like, you can... if I were malicious, I could have something that was safe when you are review it, right? And then after four weeks, I pushed an automatic update that bypasses CurseForge or Modrinth, directly to the users.

Fury: Yeah. I agree, I think the where we think about this, is the, um, when you do a manual review, you don't just look at the code, you also look at the who the author is, how many downloads this mod has, how popular it is, I mean. And then you use your judgement. 

For example, you know, if, if it's a mod that has couple of players using it, and then it's by an author that has been in the system safe for three years, and you know the person, we can trust them, and also we see that the mod doesn't have scale, then we probably be comfortable, you know; at the same time, if it's a new author, for a mod that has a lot of the scale, you know this is a red flag. Or, obviously there is a case in which very popular mod, the PC of the mod author could have been compromised, even with 2FA. 

Um, so there is that risk, but you know, at that point we can kinda, uh, if we have suspicious, or suspicion regard with the mod, we can reach out to the author and say, "hey, is this legit? Like, here's like the diff between the updates, did you do that?" 

For some folks with which we worked for, uh, or probably over the decade now, we think we can trust them, particularly if we're speaking to them on Discord, then you know, um, we can trust them, you know, in parallel with our own test. 

So I think uh, what I am trying to say is that, when we're doing manual things, not just manually looking the code, it's looking absolutely every kind of attribute of the safety we can think of regards to "should we release it or not?" 

And you know, it's human, there could be errors, but it increases safety levels, in our opinion. 

Emi: Thanks, uh...

Fury: versus banning them altogether, like if you... uh, yeah I agree that there's an option to just not allow that altogether, um, ... we felt like that would be, in this case, too drastic, you know, but I'd love to hear what community has to say on it, and if you guys think differently, We'd love to consider. 

Emi: Thank you for speaking on this. There was a concern from the audience that I would like to address, and it is something that personally experienced, is that older mods will contact a domain names, and over time, those domain names will expire, once the mod grows out of favor, and the author no longer maintain the work, and anyone, especially the malicious actor, can pick up those domains, and become an attack vector, through the old, existing, forgotten-about mods. So I believe that that is something very important to consider. 

Uh we have request to speak from the Quilt project on this topic, so I am gonna invite them in now.

[Silence]

Emi: Uh, if you are speaking, we are unable to hear you. Uh... Starchild?

Starchild: Uh okay. Um... I think, so like, CurseForge said it wouldn't be really down to ban everything that is downloading from the Internet. 

I can also personally see some legitimate use case to that. 

I think something that would be quite important is to mark the mod directly on the platform, as something he's downloading from external sources, and adding the attack vector to your ... to your install. I don't think Modrinth and CurseForge could implement something like that. 

I would also say, that it is something that best solved through policies, like um, if you wanna download from external sources, you need to do that over HTTPS, and um, having proper list of different downloaded artifacts, check that [voice unclear], a set of policies like that could be drafted with community on what is acceptable as an external download to strike a middle ground between having absolutely no policy and banning everything. 

Willie: Uh, I want to plug in very quickly. Just clarify, that my idea was to ban downloading of code, not necessarily just update checking or like, the Botania head flower list or whatever. I think... I don't know if there is misunderstanding, but my idea is partly get to that code, mainly, for banning, but yeah.

Emi: Alright, um, do we have anyone that would like to speak? Or actually, if your microphone was working now, I would invite you in to see if that... 

[Short silence]

Emi: All work?

[Silence]

Emi: Alright, okay, that seems like, that's not gonna be functioning. Does anyone else want to speak on the topic of mods downloading external files?

[Silence]

Emi: Alright. Uh...

Lambda: Oh oh, it's working. Yes, I want to say something, but my microphone broke. So, uh I have missed a little bit because I have to restart the computer.  

But what I wanted to say is... I heards stuff about trust, and I don't really totally agree with it, because um, there is a lot of cases, with um, like, popular NPM package manager for JavaScript modules that, often had issues with like trusted projects that got compromised due to ... um, due to some reasons. That makes the trust argument a bit hard to accept. 

And the other thing is... I have no idea if Starchild have talked about ... about Quilt's ... about one of the Quilt's plan that was to do dependency downloading. 

Cause that was on the table at one point, but it's currently not. And for example, the plan about that is ... wasn't final and won't be for a good while, but the last thing... the few things will like, kinda of decided is that, for example, the downloading wouldn't like an updater, it won't download stuff it didn't know about it. It only download stuff that had specific hash. 

That could ensure that target file that was never modified, even if the domain expired, something like that. 

So, my opinion on this is, um, ... downloading stuff is... needs to be really secure, and auto-updaters are kinda not secure because of the files that, you cannot predict the hash of something in the future or something, so. It's definitely a big question that needs a lot of thinking, but so far, I... even if I want to trust the mod that's doing the downloading, I will still stay suspicous with it, because I cannot trust that it will always stay trustworthy at all time.

Emi: Thank you for your prespective on this, uh, issue. Um, if anyone has anything else want to say, they can raise their hand now. Otherwise, we are be moving on to next conversation topic. 

### Topic 4: Code Signing

[Start at 00:35:10]

Emi: Alright, willie?

Willie: OK. Uh next topic is kinda, (laugh), the big one. Which everyone's kinda skipped to already, which is code-signing. 

So the idea is that, requiring binary artifact uploaded to mod repos to be signed by their author. It had ... I guess like, there's lots of questions here about it, but my main concern, which was brought up by the Modrinth folks said I think, was like the ease of use: if it is not easy to use, especially for modders who are like in high school and don't know what a signature is, no one is gonna use it. 

And I think that's actually one of the hardest parts, along with signature verification, which is like the hardest part. 

So um, this is why it is like fourth on the list, cause I actually don't think, (laugh) several don't think the community will really like agree on anything here, but it's useful exercise to kinda like just talk about it, even if nothing really happens, just to like, uh, have to talk about it (laugh) I guess. 

So like, the first question is, how do you do signature verification, and where your trust route is. Basically, like how do you, given a public key, how do you know it's that author, like the human, that author. In like, you can store it in user account, you can have some separate like, uh, authority like, is responsible for verifying this, so that's lots of questions there. 

Second is, to use the built-in Java jar signer stuff, on which I think it was Forge or some other stuff used to use, or you use like the wider industry standard, which like PGP, which is what Maven Central uses actually. So Maven Central actually uses jar signing. And for PGP the signature is seaprate from the jar, so you can have a reproducible build jar and signature besides it, instead of having the signature embedded in the artifact which kinda interferes with the reproducible builds. So that's number two. 

Number 3, prior art. So I mentioend Forge has had some kind of signature-ish stuff for years, like, uh, literally, probably a decade, and no one uses it, and what can we learn from that? 

And then, lastly, what sort of UI on the platforms or launchers can we use, if we hypothetically had a perfect like, if we had a signing system that everyone agreed on how would it work. Yeah. 

Emi: And uh, before we invite speakers to speak on this, I do want to talk about something that CurseForge did say, which was the fact that it doesn't necessitate being a required process. There is value in having a trusted badge where this mod is signed, but still being able to download unsigned mods, just having this displayed to users in the way that makes sense and doesn't inspire unnecessary worry of the issue. 

We do have someone who would like to speak on the topics, I am going to invite them now.  

Starchild: Yeah, so I think one of the problems right now is we haven't exactly... decide what we want to prevent: do we want to like, use that as an additional way to authenticate when publishing mods, in which it's really quite simple, Modrinth and CurseForge can just associate specific key with user, and use that when checking new upload, that's quite simple. 

Or do we also want to have some checks inside the loader, like for example, um, I am thinking for example, for large modpacks, they could have list of people that are allowed to sign mods that are used in the modpacks. So like if you download a mod for... or like, a malware rather than a mod, to your mod install, it would get immediately flaged.

I think that's only two things that are really relevant, maybe someone else has other ideas, but I don't really see how we can work on something else that is actually productive and actually to do something.

Emi: thank you for your thoughts on that. Uh, we have a member of the Fractureiser team that would like to say something on code signing. 

Jasmine: Yeah. Hello, I'm Jasmine. 

So uh, my thought on code signing, is the one from where I recently uploaded something to the Maven Central repository, which enforces code signing. 

And that process was mostly able to be done through, like the build script itself; the most painful part of the process was getting the documentation on how to do it.  

So I feel like if we're able to get something done, where it's part of the Gradle system itself, then it might reduce the ... yeah, like sort of the friction between like, um, enable to do the code signing, and uh, like, uploading onto mod distribution sites. 

But that's something we are gonna have to work together with various of the modding projects to get it done for example mods and such. 

Emi: I'd like to bring up some of these things that have been messaged in the meeting's channel, because there are people talking in text chant not speaking on voice, so that's not being recorded, and I'd like to relay it. 

Um, there are questions of what the purpose of signing is. If, you know, like, if someone has the key, can they just sign the malware? 

And the main reason for having signing is for identifying actors; if you signed a mod that are identified as the person who has perpetuated it, which is a big barrier for malicious actors, because that is undesirable.  

Um we have someone who'd like to speak on this topic. I am gonna hand the stage down now.

cpw: Unmute - alright, I think I was invited here mostly because I am the person who, uh, wrote the code signing stuff for Forge, ummm, and yeah, it has been in Forge for about ten (10) years. 

Um, it might have detected Stage0 injections, um, if the mod was signed and the signature wasn't stripped. 

Umm, it would definitely detect Stage3 injections, um, if the signature isn't stripped. 

But, um, it's a tricky thing, because we'd wanting people to sign the jars; it gives a lot of useful data about the integrity about the jar file. 

So I know most people in the Forge ecosystem use it these days; if you have a open-source mod, that means anyone can come along and compile it, and they could put whatever they want in it. 

And they could just theoretically go randomly distributed, you can't quite control that. 

But, you can control your identity key that identifies you as the person who compiles this module, or your CI system, or whatever it is. 

And that fingerpint would both show up in things like debug log, log files and stuff like that. 

So if your fingerpint shows up against your mod, then you know they got your jar; they don't have someone else's.  

So, um, that's primary purpose we have right now; it really needs to be pushed a layer up. 

In my opinion, at this time there is no mechanism to distribute trust, because, uh, it's great, you know, the modder signs the jar, and they can tell their jar is good, but they can't, you know, as a user, I can download your mod, but I have no idea whether or not is signature is valid and is owned by you. 

That requires a trust authority. And we don't have any inside of the For[ge]... oh the Minecraft ecosystem. 

There is no trust authority. Setting one up is a pretty complex endeavour; the only viable actors within the space would be CurseForge and Modrinth, potentially, um, because they already tracked the stuff you need track to be able to become an authority for trust. 

What CurseForge guy said earlier on about displaying a flag if you signed your mod - yeah that's a good idea; what would be better, is if it is signed by a code-signing key that was um, parented from a certificate authority, distributed by CurseForge. 

That would actually give a very good reassurance, "hey this person is who we think it is, and we have verified that this jar is signed and intact." 

That verification is actually very simple and completely automatable, and that would give a first-stage validation to the thing. 

But I think it has to start there. Um, being able to do it, um, the client side would far too late down the chain the chain to be able to make any sensible decisions at the present time; if we got the entire ecosystem to start signing the jars that only has the certifcate authorities from the people at Modrinth and CurseForge, um, it may change this picture a little bit, but right now, I think we need to start at the front door, which is the distribution [of trust], which is CurseForge and Modrinth. 

Emi: Thank you for speaking on that. 

And I have a question for, uh uh I guess, both you and the CurseForge and Modrinth, and that is the question of: is it possible for collaboration to occur to have a third party, uh, control the certificate authority for both of the platforms? Because as it stands, I know a lot of modders that upload to both platforms have to deal with the individual systems, and adding a layer of requring two separate code signatures [cpw: Sorry. You can sign multiply] in their automated system...

cpw: You can sign multiply. You don't need to have one certifiacte authority. You can have multiple, and you can sign using both. 

Emi: Alright, thank you for... 

cpw: And that's a doable thing. 

Emi: Sure, that sounds great. Um, Fury has requested to speak on this, so I will give them the stage.

Fury: Sorry, need to unmute. 

Uh, appreciate the feedback, this is the bascially our intention, as you were explaining this. 

I was chatting with the Tom online, and that is the idea that, that likes our intention, so we would function as the certificate authority, and for that, provide the extra safety. 

Um it looks like the question do we need, like a third party sort of the mechanism.

Sounds to me that the answer is it might not be needed because we can kinda of, sign it twice, one or to the other, um but, uh, it's definitely something we can look into potentially. 

cpw: There are mechanisms. Uh, we are.. probably needed to publish guidelines on how you could do this stuff in parallel. But it would need commitment from... obviously, if you're committing to that, that's awesome, CurseForge is a very big distribution platform. I hope we can get similar commitment from Modrinth guys. Um, yeah.  

Emi: Alright, I'm definitely invite Modrinth to speak; they have thoughts on this topic.

Geo: Yeah. Yeah, I think like, personally, this is not related to Modrinth at all, I think it would be best for like a trusted third party to do it, mainly just because like the platform as a whole, we both have, theirs like, moderations rights. 

Let's say we banned a user because like, let's say they violated our content policy or uploading copyrighted content or something like that, right? 

We wouldn't want them to lose their ability to code-sign from a certificate authority. 

I don't know like how we could do that. I guess the fact that someone uploading to a user account, we have to associatie that. 

But I would agree definitely that we'd love to work on code-sigining, and kinda of becoming a certificate authority. 

Um, I just think we just have to do it in a really secure way, to make sure that there is no vulnerabilities; we are not going to have a, like, flawed system and all of that. 

So, ot's gonna take a little bit of the time, but I do think that is something needed. 

Emi: Yeah, and there's a quick question directly for you, um, would you be willing to work with CurseForge to, into, uh, to have a third party system, controlled by the joint of the two of you?

Geo: Yeah, yeah, I think, like, the overall security that the modding ecosystem uses in general is something like everyone should put their differences aside, like, even though we were unaffected by this, we still are, but people still see Minecraft mods as unsafe, even though the malware has been mostly taken care of it, and really I think we should just do everything we can to have a secure ecosystem for players to feel safe when they download mods. 

Emi: Uh, thank you for all the thoughts on this. Cpw, do you have any closing thoughts?

cpw: Uh no not really, I hope we can proceed on this one. It would be nice to see some movements after ten years. (Laugh)

Emi: Alright. Thanks everyone for speaking on this. I will give the floor to willie; I believe we have one more action item on our agenda. 

## Topic 5: Sandboxing

[Start at 00:50:48]

Willie: Ah yeah. So last item, um, it's last for a reason, because, yeah. (Laugh) 

It's sandboxing, which is another different strategy that would have limited the blast radius of the attacks in this specific scenario. 

Um, in general to our heart problem, the thing we actually want are kinda simple. I think... 

Minecraft needs, like, the Internet to login into, to play on servers, and another thing we knida need is filesystem access to the instance folder, the `.minecraft` and its recursive descedents. It bascially doesn't need any other thing, right? After that. 

The problem here, or the interesting theory here to lock down filesystem access, but the problem is that, we breifly kinda looked into this, and it's basically - the state of things is that, Windows has like, no facility for this, basically, at all, and Windows is where like, 95% of the users are. 

The agenda has some light discussion for macOS and Linux, and people are kinda building prototypes on that, which is cool, we can do that where it's possible, but I'd urge people have to focus on Winodws cause that's where all the players are.  

Just the state of things there, doesn't look that great. 

So, I don't know if there is actually that much to discuss, but since it was brought up multiple times during the whole incident, I thought to bring it up here again. 

One of the other thing, that I'm just gonna mention out of the gate, is that JVM-level sandboxing is just, not gonna work. Besides the fact that it is getting deprecated and removed in a few years, it's just broken, so don't suggest that. 

Alright, so open the floor for discussion. 

Emi: Yeah, we have a couple of people from the Prism Launcher team that would like to speak on this topic, so I am gonna invite them in to have their perspective on this issue. 

ZekeZ: Good. Hi. How's everyone going today?

timoreo: Hello hello.

ZekeZ: Alright, um. Do you want to start this timoreo? You're the main, one of the main developers behind the actual launcher. 

timoreo: Yeah. So I'll to start. So, sandboxing, first off, the first point: executing untruest will never be safe, no matter how much sandboxing you put, that's just a fact. [ZekeZ: um-hum.] You can never fully protect. 

This is kind of, sandboxing is the last resort, just to limit the impact. 

In fact, we can do a bits of sandboxing because we have a distribution of Flatpak, which is sandboxed. 

It may seem a bit like a niche part, except that what's important is that Steam Deck users, which has actually a huge majority of their users, is forced to use Flatpak.

What Flatpak does is essentially restrict a lot of access, mainly file systems.  

So in this case, for this specific malware Fractureizer, it wouldn't have been able to steal information from the browser and all of that, or set up starting some malicious code that booted all of that.

ZekeZ: And yeah, in this case, we found it was ineffective, the malware, I believe, against the Flatpak. Is that correct?

timoreo: Yes. I mean, generally, the malware wasn't that well coded for Linux.

ZekeZ: This specific one, at least.

timoreo: This specific one was entirely broken on Linux. 

But the problem is kind of, you can restrict more with Flatpaks, but... 

For example, you could restrict microphone access because you can think, "oh, Minecraft doesn't need microphone," but some mods may add some voice chat or something like that, which would need microphone and would restrict users; or even Discord RPC, you know, the little thing displaying Minecraft or whatever.

This needs also special permissions and all of that, even with some older systems like X11 that requests some special permissions.

It's kind of, it needs to be restricted, but not too much to still allow some freedom from the modders, because that's what modding is mostly about.

As for the technical side, well, obviously, Linux, I mostly develop on Linux, so I'm... I know about that. It has a lot of stuff about that. 

It can restrict pretty much everything.

ZekeZ: Yeah.

timoreo: Exactly. 

ZekeZ: We've already got the things such as Flatpak for the Linux package, and I believe that Scrumplex was looking at things like Bubblewrap. 

The main issue for us to tackle is going to be sandboxing on the Windows and macOS platform, which we're not all as familiar with, as well as especially on the Windows platform having a lot more limitation and nothing... really there.

timoreo: Yeah, there isn't any really pre-existing stuff on Windows, but if some people were looking into that, but we'd have to go in and spend a lot of development time on protecting this. 

Thinking one more thing...

Emi: All right. Thank you for speaking on this issue, especially for illuminating the situation with the flatpak. 

ZekeZ: Did you just say you had one more thing, timoreo? I didn't...

timoreo: uh... uh... I'm not too far down to...

ZekeZ: That's all good.

timoreo: Nah, it's okay. 

Emi: All right. I did want to bring up a concern for several mods that I've interacted with or developed myself.

Locking down file system access is probably adequate for a majority of mods, but there are well-known mods like...

ZekeZ: There's definitely exceptions.

Emi: ... and mods that I've written like EMI that have, in a broad case. want global configs. I believe even JEI back in the day had a system like this. 

ZekeZ: I'd be curious what those directly are, because I know with the Flatpak, like I use EMI for some of my modpacks and stuff and I haven't had too many issues with them. 

Would they be something that would be user facing, or more of a development sort of constraint issue?

Emi: There is a user facing option, which is not enabled by default, [ZekeZ: Oh OK.] to use a global config file stored in your root `.minecraft` rather than the one in your local install.

timoreo: Yeah.

ZekeZ: Right. 

Emi: And Psi has similar systems. Once you've learned how to do the mod, you don't need to go through the tutorial again.

ZekeZ: Yeah. 

Emi: It persists in your global `.minecraft`.

timoreo: Yeah. So one of the things with Flatpak is that, for example, the user can case-by-case allow access to files, and if you, for example, use the standard stuff for popping up a file selector, it will use that system to allow access at a specific file. 

But I remembered what I wanted to say. Some people were talking about restricting network access. Because the malware would communicate with something to do most of its activities like logging. 

So I've heard some people throwing that about restricting what it connects to. That could be an interesting thought, except you can kind of connect to any server you want from multiplayer. 

So you would have to put some component inside of Minecraft, and as we already said, putting anything security inside of Minecraft is going to be pretty much... pretty much impossible. 

Yes, that's just one type of malware. It could still damage files, but with the files system restrictions, it could... block. But yeah.

Emi: All right. Thanks a lot for the team on these thoughts.

This is going to be a last call on thoughts on this topic. 

Once we hit the hour mark for our meeting, we're going to open the floor to all attendees and all agenda items to revisit any topics or talk about any aggregate items. 

ZekeZ: Thank you for having us on.

Emi: It's great to have you.

timoreo: Yeah, thank you.

### Overall recap

[Start at 00:59:29]

Emi: So if no one would like to speak on this, then yeah, we can move forward.  

We have a request from PaperMC, and I will given them floor.

kennytv: Hello, kinda of our perspective from Paper. 

Since, uh, we have some overlap with modding communities, just not too much; also we own our own plugin repository, which is still kinda on the side. 

We would like also, for one, be interested in, uh like, one work-together, maintainable scanner that being able to identify the malicious jars from the current malware, that would be nice to see. 

Right now, we have a bunch of them in the list, that all working slight differently [from each other], some from  browser, some locally; having one that is unified and definitely known to work on all the variations of the different Stages would be nice.  

And, back on signing. Sponge also had that for a while on Ore, which is kinda of interesting. 

They did give up on it; it's basically just... because people did not know how to use it. 

As people already said before, it is kinda of difficult for an average 14-year-old developer who has never heard of anything of signing or cryptography, to actually start signing jars. 

And sure, with kinda of Maven Central getting these automatic scripts is possible, but unless you completely handle someone all the way there, even including maven and say, built... gradle build scripts, they are not really gonna get there. 

We need some kind of, yeah, completely copy-paste example for different build systems, maybe even beyond these build systems, some kind of tooling, websites to allow... yeah, people to be able to actually sign their jars and code; otherwise, it is gonna be hard to get people, especially novice people, on jar signing. 

On general, but it's definitely something; I also agree that signing is one good way to build these mostly... mitigating the issue of going towards malware, yeah. 

Emi: Alright, thank you for your thoughts on, uh, on this topic.  

We have another request to speak, so. I will give them the floor. Thank you again for speaking.   

LambdAurora: And it's me again. 

Um, so, I was thinking, in this attack, that was, like a project got attacked by having a new file uploaded to the project; my thoughts, like manually, probably through tokens stealing or something. 

I was thinking, and it's something that I kinda like to see from mod hosting websites to add, is more Two-Factor Authentication (2FA). 

Like, I have an option to have two-factor authentication for file uploads, or even just disable the entirety of file uploads through the interface, to only allow closed pipelines like GitHub Actions to upload to the project. 

It can be a bit annoying, if... um, if there is issue in one of the pipeline or something fails to upload, but it could still be... um, an additional security to avoid that kind of token stealing, resulting in bad uploads from actors having stolen things.  

Um, because currently, I don't know if Modrinth has any Two-Factor Authentication for any of their parts, maybe for modders payout, but I'm not even sure because I haven't used it yet. 

And CurseForge has Two-Factor Authentication, but that's also only for modders' payouts. 

I think I'd like to see that system be a bit more expanded for all the other actions on the accounts, to secure the more. 

Emi: Sure; we have Modrinth willing to speak on this topic. I am gonna given them the floor. 

Geo: Yeah, thanks for bring that up. 

I think that's really important, and we are actually like - even before this happen - we were working on it. 

We are basically using Ory Kratos, which is really wildly used authentication system, but what it will have is, it will have basically expand Modrinth authentication path, right now is just "sign in with GitHub", but we are also implementing 2FA and scoped tokens, so not only you would be able to set 2FA for certain actions like withdrawing payouts or uploading files, it will also be able to accept a scoped token for your, like, GitHub Actions. 

So like, someone could have upload a file, but you could like, maybe set it to only upload it if it is not code-signed, right? And on the other hand, signed internally would be uploaded by another token, for example, right? So, we were working on that.  

I think one thing to know is that, 2FA, like, has its inherent flaw with session tokens, where no matter how much 2FA you do, you are always gonna have to issue a session token, unless you require the code for every single action. 

And if your device is compromised, your session token, like, gets leaked, your account would likely be compromised, too. 

This happened to a lot of people, like LinusTechTips, his YouTube account got compromised by this, so. 

You can only go so far with it, but I definitely think it is really worth doing, and we are planning on launching this new authentication system in a couple of weeks, so. Um, yeah. 

Emi: As a technical perspective from the Fractureiser Mitigation Team, it is our understanding that the Luna Pixel projects, the author that were compromised, did have Two-Factor Authentication enabled, and the reason this was able to be circumvented was session tokens, stored in the browser's history, which was sent to the malicious actor.  

But also yes, thank you for discussion on that, and I hope we see some form of 2FA on Modrinth in the future. 

Willie: yeah, I'm just gonna, again, kinda revisited some of the points that we kinda touched on here, one that I didn't really mention in the code-signing section, was that we should kinda be encouraging people to build, um, build and upload from CI. 

This was mentioned just now, but I didn't really get to that before. I think like that kinda mitigates the whole steal stuff from author's, from modder's local machine, because the signing token is not there, or the upload tokens or the signing keys aren't on the machine.  

And for GitHub Actions, they have this credential vault, where they also hide the private tokens to your GitHub Actions job, only for the trusted actions, and not PR that kind of stuff. 

It's like very, it's pretty robust; people on the industry use it kinda of a bit.  

Yeah, I think pushing people towards that is, uh would be better. 

The problem then comes back to, like, how do you get beginners to understand this, how this works, right? Cause then, we can add upload workflow and signing workflow to our templates, `build.gradle`s, right? 

But you still have to handle people like, "hey, generate a key, go to GitHub, go to this box, paste in the box," and... yeah. 

I think the open question is that how to educate the people properly. But it would be really nice to kinda see this default pushed towards building in CI. 

And... this is kinda lit a fire for me, 'cause like for Violet Moon, or Botania and Patchouli, are currently are built manually by me, most of the time, or on Jared's maven, so we are definitely setup automated building, sigining and publishing, soon. 

Geo: Yeah I think, like, just my two-cents there, I think one thing all platform can do, and we had a lot of success with this, is just having a checklist, or something to give people general information when they are first uploading a project. 

So, when you upload a project to Modrinth, there is a checklist guiding you through everything, and before, what would happen is when things is being approved, people would have a really short descriptions. It still happens, but there're short descriptions, no icons, no images. 

But we added these to checklist, and all of the sudden, these start happening a lot less. 

So what we are thinking of doing, is similarily, basically recommending, by having a recommended items in the checklist, basically like "hey, you can code-sign your mods here, here's how you can do it; here you can do the reproducible builds," that kind of stuff when we kinda get, uh, get to implementing those. 

Emi: Yeah, that sounds like a great way to introduce new modders. 

As a perspective from a person who recently implemented a CI publisher, the situation is very much: you go to a random mod that has CI publishing, and you copy the gradle or GitHub [Action] workflow file, and try to understand what they are doing, and that sort of situation is not maintenable, even though it is a lot of modding works: you reference open-source mods.  

We definitely need existing templates and proper documentation and education for how to do all of these things, especially as we implement more and more work onto modders. There needs to be really big ease of access high access to templating.   

Um, if anyone would like to speak on this or another issue, the floor is open right now. 

LambdAurora: I'd like to just add a word on that.  

I feel like it's a kind of thing that, like CI, is not the thing that first time modder will do, um, because generally it's... generally it's... there is a learning curve to modding.

So, first you experiment, you try stuff, and maybe you start getting into publishing stuff, and then when stuff gets very popular, you often try to do stuff better, and fix some of the issues with your code and your pipeline. I feel like CI might be a bit daunting for beginner; definitely right now... definitely very daunting because lack of the documentation.

Emi: Thanks for your perspective on this. 

Um, would anyone else like to speak on this topic? Or... [Lambda: (tried to say something, got disconneted)] yes? ... Or another?

[Short silence]

Emi: Uh, alright. Willie, do you have any thoughts on any of the topics that we had gone over? 

Willie: Is there another request to speak, I think? Maybe? Or you are seeing something [Emi: Yes] still? [Emi: I have a ...] Oh OK.

Emi: I have a request from Jared from the BlameJared Maven. I just need to get him into the meeting. A little. Give me one second.  

So yeah, if someone else want to speak, you can always let them step up. 

Willie: Uh... OK.

LambdAurora: Hi I am back. My connection cut outside. I wasn't fully finished what I was saying.  

Umm, so I have no idea about what you missed, umm...

Willie: The last thing I heard was "daunting for a lack of documentation for beginners." 

LambdAurora: It's daunting, but it's not there like there is a lack of documentation because there's a lot documentation about GitHub Actions, but it's more there is lack of documentation to what's modding specific CI workflows. 

Because, if you look at the mod loader wikis, or... the example mods, there isn't really CI stuff, aside from basic "builds for every commit," no publishing to CurseForge or Modrinth.  

For example mods, it might not be approporiate, or like, umm, actually it might be because tokens won't be there by default, so it could work, maybe. 

But having documentation for a modding... modded specific setting would be really welcomed to help those people to start getting into CI publishing because as Emi mentioned, currently the way to do it, is kinda of looking at all the people's mods, and how they do CI publishing. And I am also guilty on that.

Emi: Alright, thank for your thoughts. 

I have, um, Jared ready to speak. I would consider him as an expert on this subject, so I hope he has some thoughts. 

I will give him the floor.   

Jared: Test, 'ello, can you hear me?

Emi: Yep!

Jared: So if you don't know me, I'm Jared, I host the BlameJared Maven, there are hundred of projects on there, from dozens of mod authors.  

In general, I've helped every single one of them. Setup CI, get the stuff moving to Jenkins, even as much as helping them setup a webhook on GitHub. 

There is just... isn't any documentation of these stuff from mod loaders. Not the Forge MDK `build.gradle`, they just do `artifact jar`, but I don't think their default publication, has javadocs or source jars, so. Like that. 

I think it's something, if there's actual documentation, examples maybe, even like, "follow this guide to setup your CI/CD framework, or framework system that takes you through setting up Jenkins in a Docker, publishing a repository to GitHub, the webhooks", all of that. 

I feel... just stuff like that, get modders, teach modders about the build system more. 

That said, really badly, but I think that [Willie: Do you think...] could help.

Willie: Yeah do you think for beginners, it would probably be easy here to recommend GitHub actions right? 

Cause for Jenkins you need to setup the webhook like, have a separate system, have to talk to you, or someone in that hosts the Jenkins server. 

Um I think for beginners it's like, GitHub Actions is the easiest, safe by default grant. Once we get everything added to template, for stuff. 

Jared: For CI, yes. For the CD part, the Maven part, I am not too up-to-date on the GitHub whole thing, but I think for GitHub Packages you need to include your ... some credentials to be able just pull from it. 

So for the Jenkins part, yes. 

For everything, for the maven hosting part, not too sure on [it]. 

I know for me, I don't have a system set up in place to accept file uploads. 

All the binary on my maven have been built on the same machine, and I don't have a system to not do that, which is something I'm gonna look into after this whole system. Yes, good.

Emi: Sure, I can definitely speak on that because I'm a author that uses GitHub Actions, and I use a thrid-party maven. 

Typically, the situation from the GitHub CI perspective, is there is small amount of code built into build script, and the secret are passed from GitHub Actions, do you know, the username and password, as well as the maven URL, passed from GitHub Actions, and Gradle can just handle uploading files. 

I think in terms of accessibility, GitHub Actions publishing to maven is probably the most viable, and it's also worth considering that, for a lot of mods, maven is not strictly necessary. 

Um, there's just solutions like CurseMaven and Modrinth has a maven for all uploaded mods, which is useful for mods that aren't exposing themselves as APIs, and you know, for just like, casual add-on developers. 

And... I think the space for API developers kinda of set off a higher standard for understanding the ecosystem, settup up Maven, and the communication there. 

Maybe a much less significant concern. 

Willie: Yeah I guess I would second the whole, the maven thing is kinda a second-order issue because most modders are just content, leaf content mods, right? 

They just need to care about publishing... to mod repos, not necessarily a maven that serve by someone else. Just want to second that point. 

Emi: Alright Jared, if you have any thoughts?

Jared: My only thought would be, say, yes maven aren't generally required, but I don't think CurseMaven is a solution. 

That's also what other are saying, there isn't documentation on anything. 

I mean I don't think people has even noticed it yet, but CurseGradle, the tool, or the Gradle plugin that most people use to upload to CurseForge, is off GitHub. 

The source is gone. So... I don't know how long it has been gone, but I haven't seen any real community announcement about it. So yeah. 

Emi: Alright, well, thank you for speaking of your expertises on this topic.  

Um, since we are definitely getting quite a bit over time, um I think I will let this to one or two more talking point. 

So if anyone has anything to say [Willie: um,] on...

Willie: I think it's probably good to kind of call here. 

Wait, I think one thing that I just want to, is just kinda go briefly kinda like over major points we get, and state what the action items are, so we don't have a big meeting and the like, just don't do anything after it, right?  

Um, so first thing for review process is, I feel like we like the Modrinth people to kind of, well, both platforms, to describe how their review process goes, and also to consider changes in light on this, like requiring 2FA, or requiring more in-depth review for large or high-profile accounts or projects. 

I think that's to the most actionable things that came out of there.  

Um, for reproducible builds, kinda code-signing as well, I think that the action item here is pretty clear, that is we need to improve the default templates for Fabric and Quilt and Forge, to include the CI templates that are going to be just literally just filling your keys here, and it works. Filling your key and your project ID. Yeah I think like, that's pretty actionable. 

There is a result artifact that will come out of it, like "do we do this or not?" So that's the second thing that I see that we can do immediately.  

With signing, I don't see any immediate thing that's like very like, "hey we can say we got this done," very quickly. 

I think it's gonna be a longer term thing, and I don't know if the Fractureiser Mitigation Team is really in a positon to faciliate that at the top level. 

This is kinda, have to come from the loaders, the mod loaders and the distribution platforms, the five of them, to come together and further, yeah. 

And then sandboxing is just, yeah, (laugh) I don't think there is anything that's come out of that. 

Emi: I think it is useful to look into Windows at least on the PrismLauncher team, because they definitely have seen some successful in Flatpak, especially since they guard against Stage0 Fractureiser. 

Um, so, it might be actionable. For further promoting Flatpak use for Linux developers and modders, you know. Um, yeah. 

Willie: OK, so, um, I think that brings an end to this. 

I took notes throughout this meeting and I will push them immediately after, and like there is also gonna be recording, which... I don't know how that's gonna work. 

But I am sure that will be announced sometime. 

Emi: Um, yeah we do have one final request to speak from Fury, and I think I will grant them the floor one last time.

Fury: Yep, um. So, since we are wrapping up, um, once again, thank everyone for involved and for the time up to speak, um, everybody here. That's one. 

Willie, thank you for capture these action items, we have also done this internally, and we'll start executing on those, communicating our next steps in public channels.  

There is one other request that I would like to bring to this forum. Um, we are all talking about these technical thing on what we can do, and this is great. 

Overwolf as a company, you know, we've sorta grown up in the years, over 160 people now, and we were fortunate in a place where we could also, um, you know, deal with the, or handle this specific individuals or bad actors. 

I want to say thank you. I don't know if you are here in the call of this, but some folks has reached out to us and provided some very valueable information, that allows us to use our... resources to, or also takes steps that are not so technical, to prevent this thing from happening in future, particularly with this bad actor that apparently has done things, not just this time, but in more occasions in Minecraft community.  

My request again, is that if you have any specific information, examples, all of that, you have DoctorOyster here from Overwolf, a community manager that's here with us, that's on the CurseForge Discord server. 

Any information that can be provided will help us, you know, not look the other way. And if bad actors doing bad things, you know, make sure we do what we can. 

It's not easy, but at the same time we don't we can look the other way.  

So thanks again everybody. I'm appreciated the opportunity. 

Emi: Thank you for speaking as well.   

So yeah, to close off this meeting, I think it's important to say we should form working groups for at least 3 specific focuses on this meeting: 

one is we need some people to get together to work on code-signing, communiating with Overwolf and Modrinth, and trying to get the ball rolling there, because that is a prerequisite to a lot of things that we were talking about with signing today; we need a centralized authority to be ready for that. 

We are also going to need to have a working team to have a centralized malware detector. It was mentioned earlier on the team, or in the meeting, that there are a lot of duplication. And some of them catch certain Stages, and it's unclear what people should be using or they should be using them all. So um. I say that's the final actionable item we need to collect working groups for that.  

Uh, does anyone has any closing thoughts on the Fractureiser [Mitigation] Team? 

[Silence]

Emi: Alright, then I believe we can call this meeting a close. 

Thank you for everyone who came, and thank you for everyone who spoke on this topic, especically those who has expertise. 

I believe this was very productive, and I hope to see some results on this in the future. 

Thank you for everyone from the Fractureiser [Mitigation] Team, that we could make a productive step forward after this incident. 

And I hope the future looks bright from here.
 