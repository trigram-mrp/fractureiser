### Timeline

La timeline est de bas en haut. Les evenements le plus en haut sont les plus récents.

---
*2023-06-09 07:48 UTC*

les créateurs de Stage3b (skyrage) ont aparement perdu leur domaine skyrage.de (le nom les les registres d'entrées ont changés, les entrées DNS ont disparues)

---
*2023-06-08 10:50 UTC*

L'actuel C&C serveur de stage3b (skyrage) `95[.].214.27.172` et `171[.]22.30.117` ne sont dorénavent plus ateignables. A l'afut de potentiels changement de DNS.

Ceci est l'heure ou nous nous en sommes rendu compte, pas quand cela s'est produit.

---
*2023-06-08 05:11 UTC*

Prospector a annoncé:

> Une update de Modrinth, tout les fichiers uploadés ces 10 derniers mois
> (aproximativement la moitié de nos fichiers) ont été scannés et aucun fichier
> infecté n'a été trouvé.

---
*2023-06-08 01:12 UTC*

Les choses se sont de nouveau calmés, les antivirus ont commencé a déterminer les fichiers a l'étape 1+
comme malicieux, un meeting pour les prochaines étapes est prévus pour demain matin aux US.

Le meeting vas être semi-privé, mais ce qui s'y dit vas etre partagé après-coup.

Curseforge scan tout ses mods, Le processus est toujours en cours.

---
*2023-06-07 18:51 UTC*

Le deuxième serveur C&C 107[.]189.3.101 a été suspendu par son hébergeur.

---
*2023-06-07 16:00 UTC*

En raison d'un lag sur le HackMD, ce document a été transféré sur ce repo.
https://github.com/fractureiser-investigation/fractureiser

---
*2023-06-07 14:40 UTC*

Le fichier unobfusqué de l'etape3 a été remplacé par un fichier obfusqué, plus une charge utile.

Cette charge utile est l'updater skyrage, qui est un malware Minecraft connu pour target des serveurs spigots.

Après avoir redirigé vers skyrage pour un bout de temps, de retour vers le Meteor Hacked Client.

*note: le timestamp indiqué n'est pas accurate*
> "(TODO this timeframe is not completely accurate)"

---
*2023-06-07 14:20 UTC*

Après analyse de la nouvelle adresse IP, nous avons trouvé une version unobfusquée de l'étape 3, probablement uploadé par accident.
Le fichier est archivé ici: https://github.com/clrxbl/NekoClient

---
*2023-06-07 14:19 UTC*

Les pages du domaine Cloudflare ont été suprimées.

---
*2023-06-07 14:05 UTC*

Les pages du domaine Cloudflare redirigent vers une nouvelle adresse IP, 107.189.3.101.

---


*2023-06-07 08:52 UTC*

La poussière est maintenant retombée. Nous avons une idée générale des première étapes du virus, l'étape 3 est actuelement reverse-engineered. la première étape est temporairement dormante.

Nous recommenceront les updates demain matin, heure US (ou dans ces alentours la).

----
*2023-06-07 08:09 UTC*

Nous travaillons toujours a reverse-engineering l'étape 3, se référer a la section ci-dessous pour des détails techniques.

----
*2023-06-07 07:37 UTC*

CurseForge a publié l'annonce suivante dans leur salon discord #news:

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

*note: je traduirait ça plus tard si j'y pense, en attendant ça reste comme ça.*


----
*2023-06-07 07:24 UTC*

Darkhax a contacté les représentants de Curseforge, on a confirmation que les fichiers afectés ont été uploadé via l'UI, et non pas API.

Curseforge a stopé ses acceptations d'uploads en attendant que la situation se calme. Ils ont aussi suprimé beaucoup de fichiers infectés.

Curseforge instigue aussi les IPs des uploaders des fichiers malicieux, pour voir s'ils corespondent aux requètes précédentes.

----
*2023-06-07 7:03 UTC*

Nous pensons avoir découvert la véritable utilisation de l'Étape3 (`client.jar`) et nous essayons de le documenter. Ce n'est pas bon, pas bon dutout.

Pour faire court, pendant que nous documentont proprement: client.jar cherche *l'entièretée des fichiers systèmes* pour des fichiers ressemblant a des mods jar, et les infectes avec Étape0. Cela inclu l'*entièretée des caches Gradle et Maven*, mais aussi plein de trucs que les dévelopeurs de mods ne vérifieront jamais. La taille potentielle de cette infection est passé de  "quelques mods chelous" a *Potentiellement infinit*.

Nous pensons que c'est ainsi que l'infection s'est originellement propagée, Curseforge peut ne pas être le vecteur d'attaque initial.

----

*2023-06-07 6:27 UTC*

Les investigations ont ralenties et la team vas se coucher. unascribed a ouvert une boite mail pour permetre aux gens d'envoyer des échantillions ou autres informations utiles. williewillus travaille actuellement au clean up et a l'inclusion des informations présentées par D3SL dans ce doc. 

----

*2023-06-07 6:20 UTC*

D3SL a informé le discord non officiel qu'iel avait une copie unobfusquée de Étape3 `client.jar`, ainsi qu'une analyse en profondeur de ce que le malware fait. Iel s'en est rendu compte il y a une semaine et a fait une analyse en profondeur, en résultat, une copie complète des charges utiles.

----

*2023-06-07 5:27 UTC*

Nous avont découvert les fichiers potentiels de Étape3 (truncated); c'est très lourdement obfusqué et contian une charge utile native DLL qui essaye de voler des informations du windows store.

----

*2023-06-07 4:57 UTC*

Des fichiers uploadés en Avril ont été trouvés; soit les dates sont truqués, soit cela fait très longtemps que cela dure. La plupart des comptes ont une dernière activitée enregistrée en 1999 — probablement un bug avec d'anciens comptes CurseForge, cela reste notable.

Le staff de Modrinth vérifie qu'aucun fichiers ne soient compromis. une analyse récente indique que tout est OK.

----
    
*2023-06-07 4:40 UTC*

La taille de ce virus semble plus grand qu'anticipé. Les fichiers malicieux remontent a plusieures semaines, aussi tot que le 20 Mai. Nous nous en sommes rendu compte aujourd'hui seulement a cause de leur infection d'un gros modpack.

---

*2023-06-07 3:38 UTC*


Le serveur C&C a été suprimé par l'hébergeur. Un nouveau vas surement aparaitresi la page Cloudflare reste active, nous monitorons en cas d'activités.

----

*2023-06-07 3:26 UTC*

Nous avons reçu un fichier possiblement celui de l'Étape2 par un utilisateur anonyme prétendant travailler chez un hébergeur.

----

*2023-06-07 2:26 UTC*

Le salon #cfmalware EsperNet est crée pour coordiner les discutions se passant dans plusieurs serveurs discord et espaces Matrix.

----

*2023-06-07 0:40 UTC*

L'équipe derière ce document prend connaisance des fichiers malicieux inclus dans une update non autorisée de Better Minecraft.

----

*2023-06-01 to 2023-06-04*

D3SL devien suspicieux envers les fichiers malicieux' consomation de CPU et de RAM et commence a investiger. 
Ordre des opérations:

1. Suspicieux a propos des requetes du firewall de java.
2. Inabilitée a joindre des services self-hosted, menant a un event viewer montrant tout les ports tcpip bloqués
3. Netstat montre une consomation des ports exessive via le jar hostile.
4. Identification du fichier malicieux javaw.exe fesant tourner libwebgl64.jar, malware confirmé

A partir d'ici Tzalumen a assisté dans les reverse engineering initiaux du 'byte[] obfuscated' code et a manuellement capturé des fichier en provenance de destinations a distance.

Des copies entières des fichiers originaux (incl. deobfuscations) sauf lib.dll, traductions de toutes les destinations contactées, et une trace ecrite du processus d'infection ainsi que plusieurs capacitées hostiles ont été données a Windows defender et Malwarebytes. Curseforge a aussi été informé. La connaisance du malware n'a pas été rendue publique a ce moment la pour éviter de se faire démasquer par les attaquants.

----
