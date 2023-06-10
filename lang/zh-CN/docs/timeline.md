### 时间线

时间线顺序是从下往上，最上方的事件为最新消息。

---

*2023-06-09 07:48 UTC*

目测阶段 3b（Skyrage）的作者失去了 `skyrage.de` 域名的控制权（解析服务器及 Registrar 信息变更，DNS 解析记录消失）。

---
*2023-06-08 10:50 UTC*

阶段 3b 的指挥控制（Command & Control，下简称 C&C）服务器（Skyrage 相关）`95[.].214.27.172` 和 `171[.]22.30.117` 已无法访问。将持续保持对潜在 DNS 解析记录变化的观测。

该时间为服务器被发现无法访问的时间，并非事件发生时间。

---
*2023-06-08 05:11 UTC*

Prospector 发布公告称：

> An update from Modrinth, all files uploaded in the last 10 months
> (about half of our files) have been scanned and not one infected
> file has been found.
>
> 「Modrinth 最新动态：最近 10 个月内上传的文件（占全部 Modrinth 上托管文件的一半）
>  已经过扫描，未发现感染。」

---
*2023-06-08 01:12 UTC*

事态再次逐渐平息，杀毒软件逐步开始可以检测并查杀阶段 1 及以上的 jar 文件。
计划于美国（译注：太平洋日光节约时间，PDT）次日早上召开会议，讨论下一步行动。

会议将以半闭门方式召开，但会议纪要及录音将会在会议后发布。

CurseForge 仍在扫描其平台上的全部模组。

---
*2023-06-07 18:51 UTC*

第二个 C&C 服务器 `107[.]189.3.101` 的托管方停止其服务。

---
*2023-06-07 16:00 UTC*

因 HackMD 访问时产生的巨大延迟，本文档转移至 GitHub 仓库托管：
https://github.com/fractureiser-investigation/fractureiser

---
*2023-06-07 14:40 UTC*

未混淆的阶段 3 文件现已替换为混淆后的版本，后续则换成了另一个文件。

这次出现的文件是 Skyrage 更新器。Skyrage 是款已知会针对使用 Spigot 的 Minecraft 服务器的恶意软件。

在一段时间后，Skyrage 又被换成了 Meteor 端。

（TODO 此处时间线并不准确）

---
*2023-06-07 14:20 UTC*

对新 IP 的分析引出了一份完全无混淆的阶段 3 文件，疑似为意外上传。
该版本已在此仓库归档：https://github.com/clrxbl/NekoClient

---
*2023-06-07 14:19 UTC*

CloudFlare Pages 域名已下架。

---
*2023-06-07 14:05 UTC*

CloudFlare Pages 域名现在指向一个新地址：107.189.3.101。

---


*2023-06-07 08:52 UTC*

事态逐渐平息。我们现在对该恶意软件的早期阶段（译注：阶段 0、1、2）有了充分了解，同时我们在进行阶段 3 的逆向工程。
阶段 1 目前处于休眠状态。

我们将在美国时间的次日上午某一时刻恢复动态更新。（译注：未指明具体时区）

----
*2023-06-07 08:09 UTC*

我们仍在逆向阶段 3，参考下文章节了解技术信息。（译注：在迁移到 GitHub 前，「技术分析」一小节位于原文档的「时间线」一小节下方。）

----
*2023-06-07 07:37 UTC*

CurseForge 在其 Discord 服务器 #news 频道发布下列声明：

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

Darkhax 联系了 CurseForge 代表，确认了受感染文件是通过网页界面上传，而非透过 API 上传。

CurseForge 已暂停全部新模组的审批工作，并等待事态明朗，所有受感染文件全部清除。

CurseForge 同时已对上传者 IP 展开调查，以确认这些 IP 是否与对应账号的真正持有者相匹配。

----
*2023-06-07 7:03 UTC*

我们相信我们发现了阶段 3（`client.jar`）的真正功能，并试图在本文档中记录下来。所有人注意，这是个坏消息。

在文档成型之前——简单来说，`client.jar` 会对**整个文件系统**进行扫描（译注：即「全盘扫描」），找出所有疑似模组 jar 的文件，并感染所有疑似模组文件使其进入阶段 0。这包括**整个 Gradle 和 Maven 缓存**，以及一大堆模组开发者根本不会怀疑的死角。由此，是次事件的影响范围已从「几个怪模组」扩展到了**可能无穷大**。

我们认为这可以解释感染的起源，并且 CurseForge 并非最初的传播媒介。

----

*2023-06-07 6:27 UTC*

调查随着大部分团队成员需要睡觉而放缓。unascribed 设立了专门的电子邮箱，用于收集样本及其他有用信息。williewillus 目前在整理文档，并将 D3SL 提供的信息整理入文档。

----

*2023-06-07 6:20 UTC*

D3SL 通知了（我们的）非官方 Discord，称其获得了未截断的完整版阶段 3 `client.jar`，以及一份对其行为的深入分析报告。其还表示该样本是在数周前发现的，研究工作也随之展开。由此，我们已获得该恶意软件会下载的全部文件的样本。
----

*2023-06-07 5:27 UTC*

我们发现了有可能是阶段 3 本体的文件，但文件本身遭截断。该文件经过深度混淆，包含有一 DLL 文件，用于试图从 Windows 操作系统的凭证储藏室中窃取身份凭证信息。

----

*2023-06-07 4:57 UTC*

我们发现了上传时间标记为四月的文件。对此，有两种解释：要么这个日期是窜改后的，要么这意味着该恶意软件的传播时间远超预期。很多涉及此事的账号的最后活跃时间是 1999 年，大概率为 CurseForge 旧账号迁移的历史遗留，但仍然值得注意。

Modrinth 工作人员正在调查是否有上传到 Modrinth 上的文件被感染。针对最近一段时间的快速检查显示并无文件感染。

----
    
*2023-06-07 4:40 UTC*

攻击规模似乎比预期要大：含恶意软件的文件的上传时间可追溯到数周前，最早的可追溯回 5 月 20 日。我们之所以今天得以发现是因为攻击方入侵了一款知名整合包。

---

*2023-06-07 3:38 UTC*

服务器提供商下架了 C&C 服务器。若 CloudFlare Page 链接仍然存活，我们预计会有新 C&C 服务器上线。我们在时刻对此保持监视。

----

*2023-06-07 3:26 UTC*

匿名用户向我们提供了可能的阶段 2 jar 文件。该用户其声称为一服务器托管商工作。

----

*2023-06-07 2:26 UTC*

我们在 EsperNet 上创建了 #cfmalware 频道，以协调散落在数个 Discord 服务器及 Matrix 聊天室中的讨论。

----

*2023-06-07 0:40 UTC*

本文档的维护团队了解到，有人在未经授权的情况下发布了 Better Minecraft 整合包更新，其中包含有恶意软件。

----

*2023-06-01 to 2023-06-04*

D3SL 在发现恶意文件的 CPU 及内存消耗不正常后产生怀疑，并展开调查。以下为具体行动顺序：

1. 对 Java 可执行文件发出的防火墙放行请求产生怀疑，并选择阻断请求。
2. 无法访问自行托管的服务，随后查阅事件记录，发现全部 TCP/IP 端口被封锁
3. 执行 `netstat`，发现存在一运行中的 jar 文件对应的 PID，对应的进程占用了海量端口资源
4. 识别出存在恶意行为的 `javaw.exe`，其所运行的 `libwebgl64.jar` 随后被识别为恶意软件。

从这里开始，Tzalumen 协助逆向了最初的 `byte[]` 混淆代码，并从远端服务器上手动捕获了完整的全部文件。

D3SL 通过特殊渠道向 Windows Defender 和 Malwarebytes 提供了除 `lib.dll` 外的全部原始文件的样本（包含反混淆后的版本）、
解码后的服务器地址、以及一份感染流程及恶意行为的分析报告。CurseForge 也获得了有关通知。关于此恶意软件的信息此时仍不对外公开，
以防止攻击者获得有关消息。

----
