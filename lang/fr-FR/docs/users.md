# Guide pour les joueurs modés

Si vous jouez **uniquement** en vanilla via un launcher de confiance comme le launcher officiel ou 
Prism, et n'avez jamais touché à des mods : vous êtes en sécurité à 100%. Restez éloignés des mods 
pour le moment.

Si vous êtes un joueur de Minecraft moddé, vous allez avoir besoin de vérifier si vous avez été infecté par le
malware fractureiser pour être sûr que votre ordinateur et vos données personneles ne courent aucun risque. Vous pouvez faire
cela en suivant les instructions ci-dessous.

(*translation note :* Des informations additionnelles sur quoi faire si vous êtes ou non infecté seront données après les étapes permettant un diagnostic.)

### Est-ce toujours en cours ??
**Non. Enfin, en quelque sorte.**
Pour le moment avec nos connaissances, nous pensons que le virus `fractureiser` a été complètement supprimé de tous les mod(pack)s publics.

Notre recommendation actuel est : si vous avez exécuté le scanner pour l'Étape 2 de cette page, vous êtes en sécurité pour jouer tranquillement, cependant, depuis que la publication de mods est de retour sur CurseForge et Modrinth, il est possible que des créateurs de virus, voulant copier fractureiser, créent de nouveaux virus.

Nous sommes en contact avec toutes les parties pour établir des protocoles pour que ceci n'arrive plus dans le futur.

Si vous voulez jouer, suivez les étapes de diagnostic sur cette page ainsi que les sections sur quoi faire si vous êtes infectés ou non.

### Structure de la page
* [Qu'est-ce qu'il s'est passé ?](#quest-ce-quil-sest-passé-)
* [Suis-je infecté·e ?](#suis-je-infectée)
* [Je suis infecté·e, que faire ?](#je-suis-infectée-que-faire)
* [Je ne suis pas infecté·e, que faire ?](#je-ne-suis-pas-infectée-que-faire)
* [Foire aux Questions](#foire-aux-questions)
* [FAQ technique](#faq-technique)

Si vous avez des questions sur fractureiser, lisez cette page en entier, y compris la FAQ à la fin, car la plupart des questions ont leur réponse la bas.

## Qu'est-ce qu'il s'est passé ?

Plusieurs mods et plugins malicieux ont été publié par le créateur du malware
sur le site d’hébergement de mods CurseForge et sur le hub de plugins dev.craftbukkit.org (à ne pas confondre avec le logiciel Bukkit lui-même). Une développeuse connue a téléchargé l'un de ces mods pour l'essayer, ce qui a infecté les fichiers de son ordinateur sans sa connaissance - incluant une copie d'un projet qui aurait pu être publié sur CurseForge comme un fichier légitime, avec le virus inclus.

Cette suite d’événements s'est répétée plusieurs fois sur d'autres utilisateurs de CurseForge et dev.craftbukkit.org, infectant des copies de plusieurs plugins et mods populaires. *Il y a des traces de ces fichiers malicieux remontant jusqu'a mi-avril.*

Pendant ce temps, le créateur du malware a essayé de "brute force" les comptes de créateurs ayant des mods populaires sur CurseForge. Pour le moment, nous ne sommes pas sûr de s'il s'agit d'une brèche causée par le "brute force" ou par l'infection des comptes des créateurs.

Ce logiciel se décompose en plusieurs étapes, chaque Étape est responsable du téléchargement
et l'exécution de celle d'après. Au total, il y a trois étapes connues (Les Étapes 1, 2, et 3),
avec les fichiers infectés servant d'"Étape 0" pour démarrer tout le processus.
L'Étape 3 est le cerveau du malware, et nous avons des preuves qu'elle essaye d'effectuer ce qui suit :

* S'autopropager à *tous* les fichiers `jar` sur votre machine, affectant probablement les mods
  n'ayant pas été téléchargé via CurseForge ou BukkitDev, et les autres programmes Java
* Voler les "cookies" et informations de connection de nombreux navigateurs web
* Remplacer les adresses de cryptomonnaies contenues dans le presse-papier par des versions alternatives qui semblent appartenir à l'attaquant[^1]
* Voler des identifiants Discord (tokens)
* Voler des identifiants Microsoft et Minecraft

(Voir les [détails techniques](/docs/tech.md) pour plus d'informations)

À cause de ce comportement, nous sommes **très confiant** sur le fait que cela soit **une attaque visant l'écosystème de mods de Minecraft**. C'est assez grave.

**Jusqu'à nouvel ordre, ayez une précaution extrême sur l'installation de mods Minecraft, sans tenir compte
de la source.** Bien que le serveur de contrôle du logiciel soit maintenant hors ligne, **tous les téléchargements provenant de CurseForge ou de Bukkit dans les 2-3 dernières semaines doivent être traité comme potentiellement dangereux**. Certains anti virus ont commencé à ajouter la signature du malware dans leurs bases de données, mais tant que tous n'auront pas été mis à jour, restez précautionneux.

*Pour l'instant, nous ne pouvons pas affirmer qu'aucun service d'hébergement de mods est intact*. Agissez avec précaution sans tenir compte de quel site vous utilisez. Il est même possible que les répertoires Maven soient infecté, et ce malware remonte à plusieurs mois.

Pour le moment, de nouvelles infections sont impossibles car le serveur de l'attaquant a été fermé, des infections existantes peuvent cependant encore être actives.

### Qu'est-ce qu'une Étape ? (What the f*** is a Stage?)

![Stage Diagram](/docs/media/stages.png)

*Note de traduction : je me concentre pour le moment sur la traduction textuelle, la traduction des images arrivera au plus vite*

## Suis-je infecté·e ?

Le malware a plusieurs étapes, donc demandez si vous êtes infecté revient à poser deux questions

### Est-ce que certains de mes mods ont l'Étape 0 ?
Plusieurs scanners existent qui prennent un fichier de mod et détectent s'il contient l'Étape 0 du logiciel malveillant.

* Le [scanner](https://github.com/overwolf/jar-infection-scanner/releases) d'Overwolf
  * Il s'agit de l'option recommandé pour tester votre jeu entier - juste donner le dossier où se trouvent vos instances
  * Il s'agit d'un programme autonome qui ne requiert pas l'application Overwolf sur votre ordinateur
* Le [scanner](https://douira.github.io/fractureiser-web-detector/) en ligne par douira
* [nekodetector](https://github.com/MCRcortex/nekodetector/releases) par cortex (Cliquez sur "Assets" pour avoir accès au fichier exécutable)

Isolée, l'infection de l'Étape 0 est inoffensive tant que le fichier est supprimé et jamais executé.

### Est-ce que les fichiers de l'Étape 2 sont présents sur mon ordinateur ?

Si les fichiers de l'Étape 2 se trouvent sur votre ordinateur, cela signifie que les étapes 0 et 1 ont fonctionné avec succès.
S'ils sont présents, vous êtes possiblement *complètement infecté* et devriez continuer à lire les instructions de ce document.

Beaucoup d'anti virus ont commencé à détecter les fichiers de l'étape 2. Si vous recevez un avertissement a propos de fichiers trouvés et supprimés, passez à la section "Je suis infecté·e, que faire ?"

Dans le cas contraire, vous pouvez vérifier manuellement en faisant ce qui suit, selon votre système d'exploitation :

#### Instructions pour Windows

* Ouvrez le menu Démarrer avec la touche Windows, et taper `%localappdata%` - il devrait apparaître comme suit :
![Résultats de la recherche ci dessus](/docs/media/localappdata.png)

* Dans le dossier Local appdata, vous devez vous assurer que votre explorateur de fichier est configuré pour permettre de voir les `Fichiers cachés` et les `Fichiers protégés du Système d'Exploitation`. 
  * Cela peut être fait via Affichage > Options
  * Si vous n'êtes pas sûr de la procédure, une vidéo explicative (en anglais) [se trouve ici](https://youtu.be/KLTlTlnXeKs).
  * Les utilisateurs de Windows 11 users peuvent trouver des options similaires sous le bouton "Affichage" en haut de la fenêtre, ainsi que le bouton "..." à droite de celui-ci


* Trouvez le dossier nommé `Microsoft Edge`. L'ESPACE entre "Microsoft" et "Edge" est
  important - comme `MicrosoftEdge` est un dossier légitime qui est utilisé par Edge. Le virus
  le nomme juste ainsi pour se cacher. Le vrai dossier peut aussi s'appeler `Microsoft\Edge` (un dossier `Edge` dans le dossier `Microsoft`).
  * Le vrai dossier *peut ne pas exister* - si vous n'avez rien lié à Edge, vous êtes en sécurités
  * Les deux dossiers légitimes peuvent coexister en même temps, c'est normal.
* Si le dossier `Microsoft Edge` existe, vous êtes infecté. Si c'est le cas, supprimez définitivement ce dossier et son contenu.
  * Si le dossier ne peut pas être supprimé, couper tous les programmes Java via le Gestionaire de Tâches.


#### Informations pour les utilisateurs de MacOS

Ce malware ne semble pas affecter MacOS, donc vous devriez être tranquille.
*Revenez ici de temps en temps, juste au cas où.*

#### Instructions pour les systèmes Linux

Premièrement, assurez-vous que la méthode que vous utilisez pour voir les fichiers est capable de voir les fichiers cachés. La plupart des explorateurs de fichiers graphiques ont le raccourci Ctrl+H pour afficher/cacher les fichiers cachés. Si vous faites, ceci via un invite de commandes, utilisez `ls -A` dans les dossiers correspondants, ou `ls -lha` pour plus d'informations.

Si un seul des fichiers suivant existe, vous êtes infecté. Dans ce cas, supprimez les tous :
* `~/.config/systemd/user/systemd-utility.service`
* `/etc/systemd/system/systemd-utility.service`
* `~/.config/.data/lib.jar`

Ce faisant, si possible, vérifiez votre `journalctl` pour tous les changements que vous pouvez reconnaître. Vous pouvez faire cela via la commande `journalctl -exb` (pour les journaux systèmes) et `journalctl -exb --user` (pour les journaux utilisateurs). Exécutez les commandes suivantes pour rafraîchir vos services systemd :
```sh
sudo systemctl daemon-reload # Entrez votre mot de passe utilisateur
systemctl --user daemon-reload 
```

#### Scripts

*Si vous ne savez pas utiliser des scripts PowerShell ou Bash, ceci n'est pas pour vous*  
Des scripts PowerShell et Bash automatiques sont disponibles [sur le site de PrismLauncher](https://prismlauncher.org/news/cf-compromised-alert/#automated-script) (article en anglais) pour vérifier la présence des fichiers de l'Étape 2, si vous avez les connaissances techniques pour les lancer. Overworlf (la compagnie parente de CurseForge) a aussi publié un outil de détection de l'Étape 2 en C# :
https://github.com/overwolf/detection-tool

## Je suis infecté·e, que faire ?

**IMPORTANT** : Nous ne connaissons pas encore l’entièreté de ce que peut réaliser le malware, ni ses intentions, donc une précaution extrême doit être appliqué jusqu'à ce qu'une façon de supprimer tous les symptômes soit trouvée. Tout ce qui est noté ici est seulement *ce que nous savons* - gardez un œil sur les communications de l'équipe pour de possible mise à jour si quoi que ce soit de critique est trouvé.

(*note de traduction : Référez vous aux communications de l'equipe anglaise en premier lieu, la traduction en français prend du temps*) 

Si vous avez trouvé des fichiers de l'Étape 2 de fractureiser sur votre ordinateur, il est fortement probable que l'Étape 3 ait été exécuté et ait infecté votre appareil. Votre meilleure option est de considérer que tout ce qui se trouve sur votre ordinateur est *entièrement compromis*. Vous devrez :

* Faire une Back Up de tout ce que vous ne voulez pas perdre sur une clé USB ou une mémoire externe (vous devriez faire ceci souvent dans tous les cas !)
* Utiliser un ordinateur différent, changer vos mots de passes pour tous les services auxquel vous étiez connectés sur votre ancien ordinateur (Discord, boite mails, etc...). Si possible utilisez une gestionnaire de mots de passe comme [BitWarden](https://bitwarden.com).
* Si vous n'utilisez pas encore d’Authentification à Double Facteur (l'application Authentificar ou SMS) pour tous les services le proposant, commencez à le faire immédiatement
* Si vous le pouvez, contactez un service professionnel pour effectuer un diagnostic plus détaillé sur votre appareil pour quoi que ce soit de suspicieux, ou pour vous aider à tout effacer et réinstaller le système d'exploitation.
* Lisez les sections suivantes sur quoi faire si vous n'êtes pas infecté, car les étapes s'appliquent à vous aussi.

## Je ne suis pas infecté·e, que faire ?

Si rien n'a été trouvé par le scanner pour l'Étape 2, il est probable que rien ne se passe et que vous soyez capable de jouer tranquillement.

Bien que `fractureiser` ai été supprimé, de nouveaux virus peuvent apparaître dans un futur proche tant que nous n'aurons pas établi de nouveaux protocoles. Si vous voulez jouer, nous vous recommandons de :

* Jouer exclusivement avec les mods et modpacks que vous avez deja installer et vérifier pour leur sécurité
* Éviter d'installer quoi que ce soit publié le 8 juin venant de nouveaux auteurs ou d'auteurs inconnus, pour la même raison que le point d'avant.
* Éviter de mettre à jour vos modpacks.
* Garder un œil sur les communications des équipes de développement pour être au courant des nouvelles méthodes pour détecter des problèmes similaires dans le futur.

## Foire aux Questions

### Est-ce que CurseForge a été compromis ?
CurseForge en lui-même n'est pas compromis, seulement certains comptes. Ce n'est pas un problème de CurseForge, il se trouve juste qu'il s'agit de l’endroit où tout s'est produit. CurseForge ont aussi [publié un article](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) (en anglais) décrivant la situation de leur point de vue et travaillent activement pour déployer des mesures de sécurité supplémentaires.

### Et Modrinth ?
Modrinth ont réalisé un scan entier des mods publiés ces 10 derniers mois et aucun projet infecté n'a été trouvé. Cependant, nous recommandons toujours de rester vigilant en téléchargeant quoi que ce soit lié aux mods Minecraft durant cette période.
Le fait qu'aucun mod n'ait été infecté est un coup de chance.

### Modrinth est-il plus sûre ?
Le problème ne vient pas du site, la sécurité de Modrinth équivaut à celle de CurseForge.

### Comment CurseForge n'ont pas pu détecter cela ?
Le code de l'Étape 0 exécute n'est pas nécessairement suspicieux pour un système de vérification automatisé, et pourrait très bien être quelque chose qu'un autre mod utilise (une dépendance). En faite, les premiers outils pour détecter l'Étape 0 renvoyaient un nombre signifiant de faux positifs sur des mods populaires tel que Quark.

Soyons réaliste : ce type de prévention à la taille d'une platform est infaisable à cause de l'infinité de possibilités de cacher les intentions de son code.

### Quels Antivirus sont capables d'identifier le malware ?
De nouveaux sont en train d'être ajoutés au moment où nous parlons, il est mieux de rester à la vérification manuelle ci-dessus plutôt que de compter sur les AV pour le moment.

### Est-ce que je peux aller en multijoueur ?
Oui, vous ne pouvez pas être infecté via un serveur multijoueur si vous ne téléchargez pas de mods pour lui.

### Bedrock est-il touché ?
Non, cela n'affecte que la version Java de Minecraft.

### Est-ce que des clients alternatifs tels que Lunar ou Badlion sont sûrs ?
Voir ci-dessous.

### Est-ce qu'Optifine est sûr ? / Est-ce que Sodium est sûr ? / Est-ce qu'Iris est sûr ? / Est-ce que Create est sûr ? / Est-ce que Essential est sûr ? / Est-ce que (inserer un nom de mod) est sûr ?

**Nous ne pouvons pas entièrement confirmer la sécurité d'aucun mod.**

L'une des fonctions de l'Étape 3 du virus est d'infecter le plus de `.jar`s qu'il peut trouver sur votre ordinateur. Il peut infecter **tous les .`jar`s**, y compris Minecraft (vanilla/moddé), des mods, des plugins, et des applications Java sans rapport. Donc si votre ordinateur à l'Étape 3 du virus, savoir si le mod que vous venez de télécharger est sûr n'est plus utile - il va *devenir* infecté.
Détectez et supprimez les Étapes 1 et 2 de fractureiser **en premier**.

Pour le moment, tous les mods infectés **connus** ont été supprimé de CurseForge. CurseForge [a posté une liste des mods infectés connus](https://support.curseforge.com/en/support/solutions/articles/9000228509-june-2023-infected-mods-detection-tool/) (en anglais, en fin de page) et les ont supprimés du site. Modrinth a scanné 10 mois de mods publiés et n'ont trouvé aucune infection.

Cela *ne garantit pas que des mods infectés aient passé les vérifications*. Pour vérifier si un `jar` donné contient l'Étape 0 de fractureiser, regardez la section [Suis-je infecter ?](#suis-je-infectée) et surtout ayez une précaution extrême en téléchargeant quoi que ce soit lié aux mods pour le moment.

### À quel point l'infection est elle répandue ?

CurseForge a indiqué que les fichiers infectés ont été téléchargé près de 6 000 fois pour leur entière période d'infection. Citation de l'annonce de CurseForge sur Discord (en anglais) :
> Just to give perspective, this accounts to about 0.015% of CurseForge’s daily downloads 
> for Minecraft.

> "Pour vous donner un ordre d'idée, cela représente a peut près 0.015% des téléchargements journaliers de mods minecraft sur curseforge"

### Est-ce que quelqu'un a voulu gâcher la sortie de la 1.20 ?

Il s'agit d'une coincidence - ce virus était actif depuis plusieurs mois avant d'être mis à la lumière du jours le matin même de la sortie de la 1.20.

## FAQ technique

### Est-ce que fractureiser peut s'échapper des VMs (Machines Virtuelles)?

**Non.**

L'Étape 3 *contient* du code pour *essayer* de s'échapper *manuellement* du ["Bac à sable Windows"](https://learn.microsoft.com/fr-fr/windows/security/application-security/application-isolation/windows-sandbox/windows-sandbox-overview).
Cela n'arrive pas automatiquement. Si le virus est lancé depuis le Bac à sable, il va essayer de modifier votre presse-papier pour vous faire coller un raccourci vers le logiciel malveillant.

Notez que cette sorte d'"évasion presse-papier" n'est rien de nouveau et elle est très facile à faire échouer en ne partageant pas son presse-papier entre les systèmes hébergeur et hébergé. Utilisez une machine virtuelle plus lourde que le Bac à sable, et désactivez les fonctionnalités partageant le presse-papier ("Guest Addons" pour VirtualBox ou l'intégration des services pour Hyper-V).

(De *vraies* techniques d'évasion de machines virtuelles valent des millions de dollars et ne seraient pas utilisées pour des enfants jouant à Minecraft, et nous avons des raisons de croire que l'auteur de ce malware n'est pas un très bon programmeur en premier lieu.)

### Est-ce que le virus peut se propager dans les réseaux ?

De ce que nous savons, fractureiser ne contient pas de fonctionnalités pour se propager sur des réseaux, mais ce n'est pas à exclure.
Un chercheur en sécurité avec qui nous travaillons a reçu une alerte, mais il s'est avéré que ça n'avait aucun lien avec fractureiser, seulement un autre fichier ayant le même nom. Juste une fausse alerte.

### Que font CurseForge et Modrinth face à la situation ?

CurseForge ont développé un [détecteur pour les étapes 2 et 3](https://github.com/overwolf/detection-tool) ainsi qu'un [détecteur d'étape 0](https://github.com/overwolf/jar-infection-scanner), ils ont aussi scanné **tous** les mods et plugins publiés à la recherche d'infection d'Étape 1, et ont supprimé tous les cas d'infection **connus**.

Modrinth ont aussi scanné les mods et plugins publiés ces 10 derniers mois et n'ont trouvé aucune infection.

Les deux platforms considèrent l'introduire d'un processus de scan automatique pour les mods soumis. C'est difficile, puisque les malwares Java comme celui-ci sont typiquement uniques.

### Quelles adresses puis-je bloquer dans mon firewall/ma table de routage ?

Le code lié à fractureiser a pu être observé se connecter aux URL et adresses suivantes sur un grand nombre de ports :

* L'adresse mise en brute dans les mods infecté par l'Étape 0, ainsi que le premier serveur "command&control" observé (le serveur gérant tout pour faire simple) : `85.217.144.130`
* Le deuxième serveur "command&control" observé : `107.189.3.101`
* L'URL de rechange que l'Étape 1 essaye d'utiliser, et le nom de domaine du serveur "command&control" de l'Étape 2 : 
`files-8ie.pages.dev`

Il y a aussi des preuves de tentatives de connection à l'adresse `v2202209151437200088` 
sur le port 25575 - la raison est toujours inconnue ; probablement une ancienne version du virus.

Voici quelques adresses additionnelles à bloquer lié à "skyrage" (un ancien virus visant les serveurs Spigot/Paper, il est *très* improbable que skyrage eu été téléchargé sur l'ordinateur de qui que ce soit via ce moyen, mais rien de bon ne vient de ces adresses dans tous les cas) :

* `95.214.27.172`
* `connect.skyrage.de`
* `t23e7v6uz8idz87ehugwq.skyrage.de`
* `qw3e1ee12e9hzheu9h1912hew1sh12uw9.skyrage.de`
* *Honnêtement, bloquez tout `skyrage.de`*

Cela va sans dire que vous ne devriez en aucun cas visiter ces sites.

### Peut-on ajouter aux règles de CurseForge/Modrinth l'interdiction pour vos mods de télécharger d'autres fichiers ?

Il est déjà contre les règles de CurseForge de publier des malwares. Il y a aussi certains mods qui ont un besoin légitime à télécharger des fichiers pour lesquels cela poseraient problème.

### Serait-il possible d'inclure une sorte d'"antivirus" ou un "bac à sable" dans les outils tel que Forge ou Fabric eux-mêmes ?

"Antivirus" : Probablement non, pour la même raison que les antivirus classiques n'ont pas détecté fractureiser 
Les antivirus ne peuvent détecter que les menaces connues, et non les nouveaux malwares.

Utiliser un "bac à sable " : Inclure une sorte de vérification "est-ce que ce que contient cette classe est du code 'sûre' ?" avant de charger la classe est un très bon moyen de lancer un jeu de chat contre souris entre les développeurs mal intentionnés et les développeurs des plateformes de mods.

Il est très difficile de bannir du code Java d'utiliser une certaine classe (disons, `URLClassLoader`) car vous pouvez y référer en tant que `Class.forName` (qui a énormément d'utilisations légitimes), et si vous bannissez ou mettez sur liste noire des classes de ce moyen, vous pouvez basiquement trouver d'*autres* moyens d'utiliser `Class.forName`, et essayer de se débarrasser de ces utilitaires dans une partie sans fin de Tape Taupe.

Utiliser un "bac à sable" en Java est quasiment impossible - voir des articles comme ["Twenty Years of Escaping the Java Sandbox"](https://www.exploit-db.com/papers/45517) (en anglais).

Les mods pour Minecraft Java sont basiquement un sac de code arbitraire : traitez les comme des `.exe`, ils peuvent tout faire.

### Pourquoi les mods n'ont pas de signature cryptographique pour éviter des malwares de se glisser en leur sein ?

Le problème est qu'une signature seule ne previent en aucun cas un malware - un virus possédant une signature reste un virus - et si s'autoattribuer une signature est autorisé, cela ne change rien, le virus peut simplement supprimer la signature du jar ("supprimer le dossier META-INF") et recréer une signature avec sa propre clé. (Ce n'est pas une hypothèse, en effet : fractureiser contient une partie permettant d'enlever la signature des jars qu'il infecte.)

Une signature en ligne pour les mods *semble* être un pas en avant prometteur, mais il y aura des compromis à faire. Il y a eu [une réunion](/docs/2023-06-08-meeting.md) avec différents responsables de l'écosystème Minecraft moddé pour discuter de comment continuer sur cette voie.

### Serait-il possible d'interdire la possibilité de télécharger du code exécutable aux mods ?

Ce n'est pas possible. Vous ne pouvez pas savoir si un fichier contient du code executable avant son téléchargement, et après celui-ci, vous ne pouvez pas controller ce qui en est fait.

* Et si mon mod téléchargeait une simple classe Java ?
* Qu'en est-il d'une classe Java mais écrit à l'envers, est-ce qu'on dirait une classe dans un premier temps ?
* Qu'en est-il d'une classe Java encryptée ?
* Qu'en est-il de code *source* Java qui se compile sur votre ordinateur ?
* Qu'en est-il d'un script Python ?
* Qu'en est-il d'un fichier contenant un paragraphe en anglais où il *apparaît* que les phrases avec un nombre pair de mots correspondent à un 0, et celle avec un nombre impair à un 1 ? - même s'il s'agit uniquement d'un paragraphe, je peux techniquement l'assembler en un fichier exécutable, si j'en ai envie.

### Est-ce que cela a un lien avec le plugin malveillant Spigot qui circule ?

Possiblement ! Il existe des liens vers ce malware existant `skyrage` - l'auteur de fractureiser a publié des fichiers jars reliés à skyrage sur son serveur "command&control" de secours, dans une tentative sans succès d'étendre son attaque, juste avant que CloudFare coupe le serveur.

**Nous n'avons reçu aucune preuve que qui que ce soit ait été infecté par Skyrage via ce moyen.**
L'auteur a mis à jour l'URL CloudFare pour rediriger vers Skyrage après une longue période de temps *après* que l'adresse écrite en brute dans les mods infecté par l'Étape 0 a été retiré. Il s'agit plus d'une curiosité amusante que l'attaquant ait essayé de partager ce fichier dans tous les cas.

Skyrage est un malware existant bien étudié et vous pouvez trouver des informations sur celui-ci, [ici](https://ljskatt.no/analysis/updater_class/).
