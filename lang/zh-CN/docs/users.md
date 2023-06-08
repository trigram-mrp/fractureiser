# 模组玩家自查指南

如果你**只**通过可信的启动器（例如官方启动器、Prism Launcher）玩原版游戏，且未接触过任何形式的模组：你百分之百安全了，同时近期不要接触任何形式的模组。

如果你是模组玩家，那么你需要检查你的设备是否有感染 Fractureiser，以确保你的设备及个人信息不暴露在危险中。你可以根据下文的教程来进行自我检查。

### 这个病毒还在传播吗？

对。请时刻保持关注。

### 目录

* [到底发生了什么？](#%E5%88%B0%E5%BA%95%E5%8F%91%E7%94%9F%E4%BA%86%E4%BB%80%E4%B9%88)
* [我有没有中招？](#%E6%88%91%E6%9C%89%E6%B2%A1%E6%9C%89%E4%B8%AD%E6%8B%9B)
* [我中招了，怎么办？](#%E6%88%91%E4%B8%AD%E6%8B%9B%E4%BA%86%EF%BC%8C%E6%80%8E%E4%B9%88%E5%8A%9E)
* [我没中招，然后呢？](#%E6%88%91%E6%B2%A1%E4%B8%AD%E6%8B%9B%EF%BC%8C%E7%84%B6%E5%90%8E%E5%91%A2)
* [常见问题解答](#%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98%E8%A7%A3%E7%AD%94)
* [技术问题解答](#%E6%8A%80%E6%9C%AF%E9%97%AE%E9%A2%98%E8%A7%A3%E7%AD%94)


若你对 Fractureiser 有任何问题，请务必先完整阅读本文档，尤其是结尾 FAQ 部分，基本上可以解答你想到的大部分问题。


## 到底发生了什么？

恶意软件的作者向模组托管网站 CurseForge 及 Bukkit 插件发布网站 dev.craftbukkit.org（注意不是 Bukkit 本身）上传了数个伪装成无害模组或插件的恶意软件。有一位社区知名的整合包开发团队的开发者在不知情的情况下，下载试用了其中一个模组，并直接导致其设备遭到感染。而被感染的文件中，就有即将要上传至 CurseForge 的项目文件。

同样的过程在数位 CurseForge 及 dev.craftbukkit.org 用户身上重演，进而感染了其他数个知名插件及模组。**有报告指最早的感染记录可追溯到（2023 年）四月中旬。**

与此同时，恶意软件作者开始尝试暴力破解 CurseForge 上大流量创作者的登录信息。我们目前仍不清楚登录信息泄漏是因为暴力破解还是因为账号持有者的设备遭木马入侵。


该恶意软件感染分数个「阶段」，每个阶段均负责下载并执行下一阶段的程序。我们目前已知其拥有三个阶段（阶段 1、2、3）；同时我们将受感染的模组文件称之为「阶段 0」，该阶段负责「启动」整个感染流程。

阶段 3 是整个恶意软件的「总指挥」。根据我们收集到的证据显示，此阶段的恶意软件会执行下列操作：

* 将自身传播到整个文件系统中的**全部** `jar` 格式文件中，可能包括不是从 CurseForge 或 BukkitDev 上下载的文件，甚至可能包括其他任意 Java 程序
* 通过网页浏览器窃取 Cookies 和登录信息
* 将剪贴板上的加密货币钱包地址替换为其他地址，据信替换后的地址由攻击者所有
* 窃取 Discord 登录信息
* 窃取 Microsoft 及 Minecraft 登录信息

（参阅[技术细节](tech.md)了解更多信息。)

考虑到其行为，我们有**十足把握**确定，这是一次**针对 Minecraft 模组生态的攻击**。形势不容乐观。

**我们在此强烈建议，不论你从哪里下载模组或插件，都应对下载到的文件保持最高程度的警惕，直至后续通知发布。**尽管该恶意软件的控制服务器目前已下线，**任何过去 2-3 周间从 CurseForge 及 Bukkit 插件仓库下载的文件都应视作可能存在恶意软件感染**。某些安全防护软件已将 Fractureiser 录入其特征库，但在全体杀软跟进之前，请务必小心行事。

**考虑到当前形势，我们无法保证任何托管服务的绝对安全**。无论你从哪里下载模组，请务必保持戒备。要知道，各种 Maven 仓库也可能会被感染，且此恶意软件的流行时间可能已达数月。

目前，攻击者的服务器已下线，因此**新感染**已不可能，但已感染的设备仍会受影响。

<!--### Get to the point, how do I fix this?

![Flowchart](media/flowchart.png)-->

### 等等，TMD 到底啥是「阶段」？

<!-- TODO 我们需要汉化这个图 -->

![阶段示意流程图](../../../docs/media/stages.png)

## 我有没有中招？

该恶意软件的感染分数个阶段，所以这个问题实际上是两个问题：

### 我的模组文件有没有感染「阶段 0」？

目前，已有相当多开发者编写了各式扫描软件，可用于判定是否你的模组文件是否已进入「阶段 0」感染期。

* Overwolf 自己的[扫描器](https://github.com/overwolf/jar-infection-scanner/releases)
  * 如果你要检查你的整个游戏，那我们推荐此选项。只需告诉扫描器你把 CurseForge App 或者其他整合包装哪里了就行。
  * 该扫描器是独立程序，不需要 Overwolf App 即可使用。
* douira 的 [网页版在线扫描器](https://douira.github.io/fractureiser-web-detector/)
* cortex 的 [nekodetector](https://github.com/MCRcortex/nekodetector/releases) 
  * 点「Assets」获取编译好的程序的下载链接。需要安装 Java 方可运行。

在完全隔离的环境，且文件被删除或从未运行的情况下，阶段 0 感染并不会构成威胁。

### 我的系统中是否存在「阶段 2」感染的文件？

阶段 2 感染相关文件的出现，代表着恶意软件已成功执行了阶段 0 和 1。
如果你找到了任何阶段 2 感染的文件，你的系统很可能已经**完全感染**，请务必往下读以了解应对措施。

很多防病毒软件已开始识别阶段 2 相关的文件。若你使用的杀毒软件已提示你相关文件已发现并被清除，请跳到「我中招了，怎么办」一节。

若你不确定，你可以根据下列流程手动检查，请按你的平台选择对应流程：

#### Windows 流程

* 打开开始菜单，输入 `%localappdata%`，如下图所示
![上述关键词的搜索结果](media/localappdata.png)

* 你需要确保资源浏览器已开启 `显示隐藏文件`，并取消 `保护操作系统文件` 的勾选：
  * 该选项在 View > Options 中
  * 如果你不知道如何操作，[这里有视频教程](https://youtu.be/KLTlTlnXeKs)。<!-- TODO 换个源？ -->
  * Windows 11 用户可以在顶部 Ribbon 导航条的 "View" 按钮中找到一样的选项，或者点最右侧「……」按钮亦可。

* 找到名为 `Microsoft Edge` 的文件夹。注意中间多了个空格！不带空格的 `MicrosoftEdge` 才是真正的 Edge 浏览器使用的文件夹名字。这个病毒只是通过这样命名来伪装自己。
  * 真正的 Edge 浏览器目录也可能是叫 `Microsoft\Edge`（即，在 `Microsoft` 文件夹里有个叫 `Edge` 的文件夹）。
  * 真正的 Edge 浏览器目录**不一定**存在。如果你没找到，那你也是安全的。
  * 你也可能同时找到 `MicrosoftEdge` 和 `Microsoft` 文件夹里的 `Edge`，这样也是安全的。
* 如果你找到了带空格的 `Microsoft Edge`，那么你已被感染了。请立即完整删除整个文件夹，以及里面的所有文件。
  * 如果系统提示你无法删除，请先通过任务管理器强制停止所有正在运行的 Java 程序。

#### MacOS 流程

该恶意软件似乎并不影响 MacOS，所以你应该没事。

**为以防万一，我们建议你仍务必时刻关注本文档更新。**

#### Linux 流程

Firstly, ensure whichever method you are using to list files has the ability to view hidden files.
Most GUI file managers have the shortcut Ctrl+H to toggle hidden files. If doing this on a terminal, 
use `ls -A` in the respective directories, or `ls -lha` for a more detailed listing.

首先，你需要确认你列出文件列表的程序可以显示隐藏文件。大部分带 GUI 的文件管理器支持 Ctrl+H 快捷键显示隐藏文件。在终端（命令行）界面中则可使用 `ls -A` 列出包括隐藏文件在内的所有文件，或使用 `ls -lha` 显示更多详细信息。

若你找到下列任何文件，那么你已被感染了，请立即完整删除这些文件：
* `~/.config/systemd/user/systemd-utility.service`
* `/etc/systemd/system/systemd-utility.service`
* `~/.config/.data/lib.jar`

在此之后，如果你符合下述情况：通过 `journalctl` 检查是否有你没有印象的变更。你可以通过 `journalctl -exb`（调阅 system log 系统日志）或 `journalctl -exb --user`（调阅 user log 用户日志）确认这一点，同时执行下列命令刷新你的 `systemd` 服务：

```sh
sudo systemctl daemon-reload # Enter your user password
systemctl --user daemon-reload 
```

#### 脚本

*如果你不知道如何运行 PowerShell 或者 Bash 脚本，那么这些脚本不是为你准备的。*  

[PrismLauncher 网站上提供了](https://prismlauncher.org/news/cf-compromised-alert/#automated-script)可自动检查感染情况的 PowerShell 及 Bash 脚本，如果你有一定技术水平的话，可使用这些脚本辅助查杀。Overwolf（CurseForge 母公司）已发布阶段 2 感染检查工具，使用 C# 编写：https://github.com/overwolf/detection-tool

## 我中招了，怎么办？

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

## 我没中招，然后呢？

如果你过去数月中玩过模组，那么你现在能做的最安全的事情是：**不要启动 Minecraft，原版也不要碰。**

With that said - if nothing was found in the first place, chances are there's nothing going on.
If you still want to play the game:
* With the current knowledge we have, this is not risky, but we do not guarantee this is
accurate - you are *willingly putting yourself at risk*.
* After each session, check for the stage 2 infection files in the previous step to ensure nothing
has happened since
* Do not, under **any circumstances**, download or update any mods, modpacks, or plugins you
may use, or even run any you downloaded and never ran before - stick to instances you have
already used, and those **ONLY**.

## 常见问题解答

### CurseForge 被入侵了吗？
CurseForge itself is not compromised, only individual users. This is not a CurseForge problem, they
just happened to the be place this happened in. CurseForge have also [posted an article](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) describing the situation from their end and
are working on deploying countermeasures.

### Modrinth 有没有事？
Modrinth has ran a full scan of the last 10 months of uploads and no infected projects were found. 
We still recommend exercising extreme caution when downloading anything mod related at the moment. 
The fact no mods were infected there was entirely luck.

### Modrinth 更安全吗？
This isn't a website-level issue, Modrinth is just as safe as CurseForge is.

### CurseForge 怎么让这玩意过审的？
The code the stage 0 infection ran wasn't necessarily suspicious to an automated system, and could
very well have been something another mod would've used. In fact, early heuristics for determining
stage 0 infection had significant amounts of false flags on popular mods such as Quark.

Realistically, this type of prevention on a platform scale is non-feasible due to the infinite
different ways you can lay out code to hide your intent.

### 哪个杀毒软件能查杀这个？
New ones are being added as we speak, it's best to do the manual verification above instead of
relying on AV for now.

### 多人联机是否安全？
Yes, you can not be infected via a multiplayer server if you don't download mods for it elsewhere.

### 基岩版是否安全？

安全。该恶意软件只影响 Java 版。

### 第三方客户端（Lunar、Badlion 等）安全吗？

见下一条。

### OptiFine/Sodium/Iris/Create/Essential/[填入任意模组名] 安全吗？

**我们无法确认任何模组是否安全。**

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

### 感染的范围究竟有多大？

CurseForge is reporting infected files were downloaded roughly 6,000 times for the entire 
infection period. Quote from CF's Discord announcement: 
> Just to give perspective, this accounts to about 0.015% of CurseForge’s daily downloads 
> for Minecraft.

### 是不是有人想毁掉 Minecraft 1.20 的发布活动？

It appears to be a coincidence - this malware campaign was active for quite a while before being 
widely uncovered the morning-of the 1.20 release.

目前的线索显示：这只是巧合。该恶意软件在 1.20 日发布日早上被大范围披露时，就已经悄无声息地传播了一段时间了。

## 技术问题解答

### Fractureiser 有没有虚拟机（Virtual Machine，VM）逃逸能力？

**没有。**

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

### Fractureiser 能通过网络传播吗？

As far as we know, fractureiser does not contain network spread functionality, but it is not fully
out of the question.  
A security researcher we are working with got an alert, but it ended up being about completely 
unrelated malware that happened to use a similar filename. This was just a false alarm.

### CurseForge 和 Modrinth 对此有何反应？

CurseForge has developed an open-source [stage2/3 detection tool](https://github.com/overwolf/detection-tool) 
and [stage0 detection tool](https://github.com/overwolf/jar-infection-scanner), have scanned *all* 
uploaded mods/plugins for stage0 infections, and have deleted all *known* infection cases.

Modrinth has also scanned uploaded mods/plugins for stage0 infections going back 10 months and did 
not find any.

Both platforms are considering introducing some sort of automated "virus scan" process to the mod 
submission pipeline. It's hard, since Java malware like this is typically bespoke.

### 我应该在我的防火墙/路由表里阻断哪些 IP 地址和 URL？

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

### 我们能否要求 CurseForge/Modrinth 出台新规，禁止模组下载其他文件？

It's already against CurseForge rules to upload malware. There are also many legitimate use cases 
for a mod to download files that this would also stifle.

向 CurseForge 上传恶意软件已经是违反其使用规定的了。同时，这样的规定还会误杀其他有合理理由下载文件的模组。

### 模组加载器本身有没有可能内置「防病毒」或「沙箱」功能？ 

「防病毒」：大概不行，理由同常规杀软起初也无法探测。杀毒软件只能检测已知恶意软件，不能查出未知恶意软件。

「沙箱」：Including some sort of "does this class contain 'safe' code?" check before loading a 
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

### 为什么模组文件没有密码学签名，这样不就可以从源头恶意软件窜改了吗？

Part of the problem is that signatures alone do not prevent malware - a cryptographically-signed 
virus is still a virus - and if self-signing was permitted, it doesn't prevent tampering either - 
it's possible for a virus to simply strip digital signatures off a jar ("delete META-INF") and 
re-sign it with its own key. (This isn't a hypothetical, either: fractureiser does contain code to 
remove digital signatures from the jars it infects.)

Signed mods with online signature verification *does* seem like a somewhat promising way forward, 
though it's not without tradeoffs. There will be [a meeting](2023-06-08-meeting.md) with
many different reps from the modding ecosystem to discuss how to move forward.

### 禁止模组下载可执行代码是否可行？

不可行。你在下载完成之前无法确认你下载文件里是否有可执行代码，下载完后也无法控制程序对这个文件的操作。

* What if my mod downloads a single Java class file?
* What about a Java class file but spelled backwards, so it doesn't look like a class file at first?
* What about a Java class file but encrypted?
* What about Java *source* code that is compiled on your computer?
* What about a Python script?
* What about a file containing English prose where it just so *happens* that sentences with an 
even number of words correspond to a 0, and sentences with an odd number of words correspond to 
a 1? - even though it's a prose document I can technically reassemble it into 
an `.exe`, if I so choose.

### 此次事件是否与当下流行的 Spigot 插件恶意软件有关？

Possibly! There's some ties to the existing malware `skyrage` - the malware author uploaded a 
skyrage-relevant `.jar` to their backup command&control server, in a fruitless attempt to 
extend the attack, shortly before CloudFlare took it down anyway.

**We have not received any reports of anyone becoming infected by Skyrage through this vector.** 
The author updated their CloudFlare URL to point to Skyrage a significant length of time *after* 
the hardcoded IP address in stage0-infected mods was already taken down. It's mostly a funny 
curiosity that the attacker tried to serve this jar at all.

skyrage is an existing, well-studied piece of malware and you can find some more info about 
it [here](https://ljskatt.no/analysis/updater_class/).