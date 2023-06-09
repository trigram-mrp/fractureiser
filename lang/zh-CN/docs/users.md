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
![上述关键词的搜索结果](../../../docs/media/localappdata.png)

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

**重要提示**：我们目前仍不清楚 Fractureiser 的全部能力以及其传播动机，所以在出现完全查杀指南之前，请保持最高程度的戒备。下文中列出的所有对策均针对**我们目前掌握的信息**，所以还请时刻关注我们的最新消息，我们会在发现关键信息时在第一时间披露。

若你的设备已感染 Fractureiser 阶段 2，你的设备有相当大可能性也已遭阶段 3 感染。此时，你的最佳选项是：假设你的系统已被**完全入侵**；此时你应该：

* 备份所有有价值数据到 U 盘或者其他硬盘上（平时你也应该有这样的习惯！）
* 在另一台设备上，修改被感染设备上登录的所有服务的账号密码（Discord、电邮、……）。考虑使用诸如 [BitWarden](https://bitwarden.com) 之类的密码管理器。
* 若你还没有使用 2FA（Two-Factor Authentication，双因子验证），不管是专用的 App 还是手机短信，但你使用的服务支持 2FA，请立即开始使用。
* 如果条件允许，请联系当地的专业维修人员对你的设备进行彻底检查，或者（作为更保险的备用方案）直接格盘重装操作系统。
* 阅读下文中「我没中招」一节。这其中内容也适用于已感染的情况。

## 我没中招，然后呢？

如果你过去数月中玩过模组，那么你现在能做的最安全的事情是：**不要启动 Minecraft，原版也不要碰。**

在此前提下——若你按上述流程排查未发现问题，那么你的设备有可能并未受影响。若你仍然想继续玩 Minecraft：

* 基于我们掌握的信息，我们认为继续玩 Minecraft 并不构成威胁，但我们不保证这一点准确无误——若你选择继续玩 Minecraft，那么**你同时也选择了承担所有风险**。
* 每次玩 Minecraft 结束后，使用上述流程检查你的设备是否存在阶段 2 感染文件，以确保你的设备安全。
* **在任何情况下都不要**下载、安装或更新任何你想用的模组、整合包和插件，尤其是此前从未使用过的——请暂时**只使用**你已经下载安装的模组、整合包、插件。

## 常见问题解答

### CurseForge 被入侵了吗？

CurseForge 本身没有被入侵，只有其个别用户账号被盗。这不是 CurseForge 平台的问题，CurseForge 只是意外成为了事件发生地。CurseForge 也已[就此事发文](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)，阐述了其目前的状况，以及正在部署的应对措施。

### Modrinth 有没有事？

Modrinth 已对其站内 10 个月内上传的所有文件进行了全盘检查，没有发现受感染文件。尽管如此，我们在此仍然建议，在下载任何模组文件时，保持最大程度的警惕。Modrinth 没有受影响纯粹是因为运气。

### Modrinth 更安全吗？

这不是网站的问题。Modrinth 目前的安全程度，可以说，和 CurseForge 在同一水平上。

### CurseForge 怎么让这玩意过审的？

阶段 0 感染中所执行的代码，并不一定能引起自动化审核系统的怀疑，且有一定概率确为作者需要使用的代码。事实上，此前一部分通过启发式检测来判定文件是否存在阶段 0 感染的方式产生了相当多的误报，有些甚至将包括 Quark（夸克）在内的知名模组也错标为「阶段 0」感染。

事实上，考虑到你有无数种方法隐藏你的代码的真正目的，此类全平台范围内的预防机制并不行得通。

### 哪个杀毒软件能查杀这个？

在我们编写本文档时，杀软也在更新其特征库，所以我们在此建议不要过度依赖杀软，先使用上文所述自查流程进行初步排查。

### 多人联机是否安全？

安全，在你没有下载联机所需模组的前提下，单纯通过多人游戏无法感染此病毒/恶意软件。

### 基岩版是否安全？

安全。该恶意软件只影响 Java 版。

### 第三方客户端（Lunar、Badlion 等）安全吗？

见下一条。

### OptiFine/Sodium/Iris/Create/Essential/[填入任意模组名] 安全吗？

**我们无法确认任何模组是否安全。**

处于阶段 3 的病毒的功能之一便是尽可能感染你的电脑上的所有 `.jar` 文件，注意是**所有 `.jar`**，包括 Minecraft 本体（原版和装了模组均受影响）、Minecraft 模组文件、Spigot 插件、甚至其他 Java 应用程序。所以，如果你的电脑已经存在阶段 3 感染，那么不论你从哪里下载模组，下载什么模组，最终都会感染，此时「安全」根本无从谈起。你**首先**应该做的是按前述流程进行查杀。

截至目前，所有 CurseForge 上已知的被感染模组均已被删除。CurseForge 还[公布了已知被感染模组清单](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/)，位于该页面最下方，清单中提及的模组均已被下架删除。Modrinth 目前已扫描 10 个月内在其上发布过的所有模组，未发现有感染。

然而，这**并不能保证有隐藏得足够深的漏网之鱼**。请根据[我有没有中招](%E6%88%91%E6%9C%89%E6%B2%A1%E6%9C%89%E4%B8%AD%E6%8B%9B)一节中所述内容检查某一个 jar 文件是否存在阶段 0 感染，并在此之后对所有新下载的模组文件保持最高程度的警戒。

### 感染的范围究竟有多大？

CurseForge 自称，受感染文件在最终下架删除前，下载量高达 6000 余次。引述 CurseForge 在其官方 Discord 中发布公告之原文：

> Just to give perspective, this accounts to about 0.015% of CurseForge’s daily downloads 
> for Minecraft.
>
> 「从另一个角度来看，这些下载量仅占[CurseForge 的] Minecraft 分区日下载量的 0.015%。」

### 是不是有人想毁掉 Minecraft 1.20 的发布活动？

目前的线索显示：这只是巧合。该恶意软件在 1.20 日发布日早上被大范围披露时，就已经悄无声息地传播了一段时间了。

## 技术问题解答

### Fractureiser 有没有虚拟机（Virtual Machine，VM）逃逸能力？

**没有。**

阶段 3 **确有**用于**试图**从所谓[「Windows Sandbox」](https://learn.microsoft.com/en-us/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview)中逃逸的代码。然而此过程并非自动完成：病毒会在检测到 Windows Sandbox 时，试图修改剪贴板中内容，以引诱你将指向恶意软件的快捷方式粘贴出来（译注：指粘贴到宿主机中，以此引诱用户双击，进而触发恶意行为）。

要注意的是，此类所谓「粘贴板逃逸（Clipboard escape）」技术并不新鲜，且防御方式也很简单：不要在宿主机（Host）和虚拟机（Guest）之间分享剪贴板内容就行了。如有需要，请使用比「Windows Sandbox」更重量级的虚拟机软件，并禁用诸如 VirtualBox 的「Guest Addons」、Hyper-V 的「integration services」之类的附加软件。

（**真正**的虚拟机逃逸漏洞实际上价值连城（译注：原文直译为「价值上百万美元」），单凭一个玩 Minecraft 的小孩并不一定搞得定。我们有理由相信，这个恶意软件的作者本身也并非训练有素的程序员。）

### Fractureiser 能通过网络传播吗？

根据我们掌握的信息，Fractureiser 并不包含通过网络传播的功能，但我们并不能排除这个可能性。
与我们合作的一位安全研究员收到了相关警报，但经调查发现是与此次事件无关的恶意程序，只是文件名碰巧相似，最终认定为假警报。

### CurseForge 和 Modrinth 对此有何反应？

CurseForge 开发了开源的[阶段 2/3 检测工具](https://github.com/overwolf/detection-tool)以及[阶段 0 检测工具](https://github.com/overwolf/jar-infection-scanner)，同时扫描了整个 CurseForge 上**所有的**模组及插件以确认阶段 0 感染情况，并下架删除了所有发现的受感染文件。

Modrinth 也已对 10 个月内上传的所有模组及插件完成了阶段 0 感染状况，结果显示并未发现感染。

两家平台均计划在其文件上传流程中引入某种形式的全自动「病毒检测」机制。然而，鉴于此类基于 Java 的恶意软件通常为定制，实现这一点并非易事。

### 我应该在我的防火墙/路由表里阻断哪些 IP 地址和 URL？

Fractureiser 相关代码会试图访问下列 URL 或 IP 的诸多端口：

* 在阶段 0 中发现的硬编码地址，同时亦是首个发现的「指挥控制」（Command & Control，下简称 C&C）服务器地址：`85.217.144.130`
* 第二个发现的 C&C 服务器地址：`107.189.3.101`
* 阶段 1 使用的备用 URL，同时也是阶段 2 的 C&C 服务器主机名：`files-8ie.pages.dev`

同时亦有证据显示 Fractureiser 还试图访问主机名为 `v2202209151437200088` 的服务器的 25575 端口，原因未知，推测为旧版恶意软件遗留。

此外，我们也建议将下列下列和 Skyrage 有关的地址填加入防火墙中（再次强调，尽管有人因此恶意软件而被 Skyrage 感染的可能性**很低**，但保守起见，一并加上去也无妨）：

* `95.214.27.172`
* `connect.skyrage.de`
* `t23e7v6uz8idz87ehugwq.skyrage.de`
* `qw3e1ee12e9hzheu9h1912hew1sh12uw9.skyrage.de`
* *也许应该直接屏蔽整个 `skyrage.de` 二级域下的所有域名*

请勿点击访问上述地址！这一点想必不言而喻。

### 我们能否要求 CurseForge/Modrinth 出台新规，禁止模组下载其他文件？

向 CurseForge 上传恶意软件已经是违反其使用规定的了。同时，这样的规定还会误杀其他有合理理由下载文件的模组。

### 模组加载器本身有没有可能内置「防病毒」或「沙箱」功能？ 

「防病毒」：大概不行，理由同常规杀软起初也无法探测。杀毒软件只能检测已知恶意软件，不能查出未知恶意软件。

「沙箱」：在类加载前就进行「这个类的代码是否『安全』？」的检查，无疑会将整个社群推向一场模组加载器开发者和恶意软件开发者之间的「猫捉老鼠」游戏中。

阻止 Java 代码引用某一特定类（比如 `URLClassLoader`）相当困难，因为你也可以在 `Class.forName` 中用到这个类，而这个用法有相当多的合理用途。如果你直接禁止引用，或者只限定某一列表内的类对其直接引用，你通常还能在你的 classpath 里找到**另一段代码**可以帮你调用 `Class.forName`，然后你会开始阻止更多的类，最终掉进无穷无尽的「打地鼠」循环中。

沙箱化 Java 基本上不可能，可参考[《Twenty Years of Escaping the Java Sandbox》](https://www.exploit-db.com/papers/45517)了解其中原因。

Java 编写的模组本质上就是任意代码的集合。你理应将其视作和 `.exe` 一样，有执行任意代码能力的程序。

### 为什么模组文件没有密码学签名，这样不就可以从源头阻止恶意软件窜改了吗？

这样做的问题之一在于，签名不能阻止恶意软件，带密码学签名的病毒仍然是病毒。如果我们允许自签名，甚至还不能防窜改：病毒只需删除原有签名（即「删除 `META-INF` 目录」）然后用自己的密钥重新签一份就是了。事实上，这个情况已经出现了：本次事件的主角 Fractureiser 就有删除其感染的 jar 内的数字签名的代码。

模组签名搭配在线验证**听起来很美好**，但也有代价。我们将就此事[召开会议](2023-06-08-meeting.md)，邀请社区中各个生态的代表人物，共同讨论应对方向及策略。

### 禁止模组下载可执行代码是否可行？

不可行。你在下载完成之前无法确认你下载文件里是否有可执行代码，下载完后也无法控制程序对这个文件的操作。

* 如果我的模组只下载一个 Java class 文件？
* 如果我的模组下载的 Java class 文件需要从尾往头读，所以不能一眼看出这是一个 Java class 文件？
* 如果我的模组下载了加密后的 Java class 文件？
* 如果我的模组下载了 Java 源代码，在本机编译成 class 文件后运行？
* 如果我的模组下载了 Python 脚本？
* 如果我的模组下载的文件内容是英语写的散文，不过这篇散文**恰巧**有如下特征：有偶数个词的一句话代表 0，有奇数个词的一句话代表 1？尽管这表面上就是个纯文本文件，内容是篇散文，我也可以选择根据上述规则，将其翻译为一串 0 和 1 组成的 `.exe` 可执行文件。

### 此次事件是否与当下流行的 Spigot 插件恶意软件有关？

有可能！有迹象显示此次恶意软件和已知恶意软件 `Skyrage` 之间有所关联——本次事件中的恶意软件作者曾试图在备份 C&C 服务器中上传和 Skyrage 相关的 `.jar`，但随后 CloudFlare 切断了服务器与公网的连接，是次扩大攻击范围的尝试也未能得手。

**我们还未收到任何藉由此感染 Skyrage 的报告。** 
作者将 CloudFalre URL 指向 Skyrage 时，其在阶段 0 感染的模组中硬编码的服务器地址**早已**下线多时了。可以说，攻击者选在这种时候试图传播这个 jar 的举动，少见且离谱。

Skyrage 是款已知，且已有深入研究的恶意软件，关于 Skyrage 的更多信息可在[这里](https://ljskatt.no/analysis/updater_class/)找到。