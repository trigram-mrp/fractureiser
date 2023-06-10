<p align="center">
    <img src="docs/media/logo.svg" alt="Logo">
</p>

*お騒がせして申し訳ないですが、このドキュメントは作業中です*

## これは何?
`fractureiser`は、[CurseForge](https://www.curseforge.com/minecraft)と[CraftBukkitのプラグイン配布サイト](https://dev.bukkit.org/)にアップロードされた、いくつかのMinecraft関係のプロジェクトにて発見された[コンピュータウイルス](https://ja.wikipedia.org/wiki/%E3%82%B3%E3%83%B3%E3%83%94%E3%83%A5%E3%83%BC%E3%82%BF%E3%82%A6%E3%82%A4%E3%83%AB%E3%82%B9)です。このマルウェアは複数のModに組み込まれており、そのうちのいくつかは非常に有名なmodpackに追加されていました。このマルウェアは、Windows及びLinuxのみを対象としている事が知られています。

確認せずに放置した場合、fractureiserはあなたのパソコンにおいて**非常に危険**になり得ます。この文書を読み、自身の安全を守るために必要な情報を確認してください。

私達は、このマルウェアに対して`fractureiser`という名前を付けました。これは、最も注意すべき悪質なファイルをアップロードした、CurseForgeのアカウント名に由来します。

## あなたが知るべき事

### [Modを利用していた人はここを見てください](docs/users.md)

あなたがただModで遊んでいただけで、開発者でないのなら。上記のリンクがあなたに必要な情報の全てです。そこには、このマルウェアの能力の表面的な情報・感染しているかどうかを確認する方法・除去する方法・FAQが書かれています。

より詳細な情報を知りたい人は、以下の記事も見ると良いでしょう。
* [事件の時系列](docs/timeline.md)
* [技術的詳細](docs/tech.md)

### 私はMinecraftのModを利用したことがありません

あなたは影響を受けません。

## 現在の調査状況
fractureiserがどの様に動作するかは、Stage 0から3まで概ね判明しています。いくつかの不明点はありますが、攻撃サーバーはオフラインであり、私達の知る限り、*新しい*感染はあり得ません。古い感染はまだ有効な可能性があります。

私達は今、ユーザー向けのドキュメントの改良に取り組んでいるため、そちらをご覧ください。

## フォローアップ・ミーティング
2023/06/08(アメリカ時間, 日本標準時で2023/06/09 午前01:00~)にfractureiser緩和チームはコミュニティの注目すべきメンバーと共に会議を行いました。この会議では、fractureiserを阻止する方法と、将来に類似した問題を起こさないための解決策を話し合いました。
議題と議事録については、[このページ](docs/2023-06-08-meeting.md)を見てください。

## 追加情報

このマルウェアに関するファイルを持っている場合、 https://wormhole.app にファイルをアップロードし、そのURLを fractureiser.investigation@opayq.com にメールしてください。このメールはunascribedにより管理され、送られた物は全てチームの全員に共有されます。より一般的に連絡を取る必要がある場合、jaskarth4@gmail.comにメールしてください。
**訳注**: この翻訳版についてはこれらのメールアドレスを含む、調査チームに対して連絡しないでください。この翻訳はCC-BY-SA-4.0 ライセンスに基づいた非公式な翻訳版です。この翻訳に関する連絡はこのリポジトリのIssueまたは[Twitterの@toliner_](twitter.com/toliner_)に対して行ってください。

このドキュメントの一部をどこかに引用する場合、*必ず*冒頭周辺の目立った場所にオリジナルの [GitHub Repository](https://github.com/fractureiser-investigation/fractureiser)へのリンクを貼ってください。読者が最新の情報を得たり連絡を取るのに必要です。
**訳注**: この翻訳版を引用する場合、可能であればオリジナルのリポジトリとこのリポジトリの両方のリンクを貼ってください。字数等の制約により難しい場合はオリジナル版のみでかまいません。

個人的に招待される物を除いた、能動的に参加可能な*オリジナルの記事を書いているのと同じ団体が運営している***唯一の**公式の公開チャンネルは、[EsperNet IRCにおける #cfmalwareチャンネル](https://webchat.esper.net/?channels=cfmalware)です。
**IRCチャンネルに参加すると、IPアドレスが公開されます。**

---

\- the [fractureiser Mitigation Team](docs/credits.md)

翻訳された日/Translated At: 2023/06/10 12:00 JST
対象のコミット/Target Commit:[c15def8](https://github.com/fractureiser-investigation/fractureiser/commit/c15def8bf03315cefe24faa564754c6fa8648975)