### Timeline

Questa timeline è dal basso verso l'alto. Gli eventi più recenti sono quelli più in alto.

---
*2023-06-09 07:48 UTC*

I creatori di stage3b (skyrage) hanno perso il loro dominio skyrage.de (le entrate nameserver e registrar sono state cambiate, le entrate dns sono scomparse)

---
*2023-06-08 10:50 UTC*

I correnti Server di Comando & Controllo di stage3b (skyrage) `95[.].214.27.172` e `171[.]22.30.117` non sono più raggiungibili. Stanno controllando per potenziali cambi di DNS.

Questo è quando è stato notato, non quando è accaduto.

---
*2023-06-08 05:11 UTC*

Prospector annuncia il seguente:

> Un aggiornamento da Modrinth, tutti i file caricati negli ultimi 10 mesi
> (quasi la metà dei nostri file) sono stati tutti scansionati e nessun file infetto
> è stato trovato.

---
*2023-06-08 01:12 UTC*

Le cose si sono calmate per la maggior parte, gli scanner del virus hanno iniziato
a rilevare i jar nella fase 1+ come maliziosi, un meeting per i prossimi passi è pianificato
per il mattino successivo negli US.

Il meeting sarà semi-privato, ma le registrazioni / minutaggi saranno condivisi successivamente.

CurseForge sta scansionando tutte le mods, ma il processo è ancora in corso.

---
*2023-06-07 18:51 UTC*

Il secondo server di Comando & Controllo 107[.]189.3.101 è stato sospeso dal suo fornitore di hosting

---
*2023-06-07 16:00 UTC*

A causa dei problemi nell'HackMD, questo documento è stato trasferito alla repository di GitHub
https://github.com/fractureiser-investigation/fractureiser

---
*2023-06-07 14:40 UTC*

La fase 3 non offuscato è stato rimpiazzato da uno offuscato, poi dopo da un altro payload.

Quel payload è lo skyrage updater, che è un malware di Minecraft conosciuto che bersaglia i server spigot.

Dopo aver servito skyrage per un po', è passato di nuovo al servizio del client hackerato Meteor

(TODO questo timeframe non è completamente accurato)

---
*2023-06-07 14:20 UTC*

L'analisi del nuovo indirizzo IP produce una fase 3 completamente deoffuscata, apparentemente caricata per sbaglio.
E' stata archiviata qui: https://github.com/clrxbl/NekoClient

---
*2023-06-07 14:19 UTC*

Il dominio delle pagine di Cloudflare è stato rimosso.

---
*2023-06-07 14:05 UTC*

Il dominio delle pagine di CloudFlare è passato a puntare un nuovo indirizzo IP, 107.189.3.101.

---
*2023-06-07 08:52 UTC*

Il polverone si è per lo più depositato per ora. Abbiamo una buona idea degli stadi inizali del malware, nel mentre stanno risalendo al codice sorgente della fase 3. La prima fase è temporaneamente dormiente.

Continueremo gli aggiornamenti la prossima mattinata orario US (circa).

----
*2023-06-07 08:09 UTC*

Stiamo ancora lavorando a risalire al codice sorgente della fase 3, guardate la sezione qui sotto per i dettagli tecnici.

----
*2023-06-07 07:37 UTC*

CurseForge ha pubblicato la seguente dichiarazione nel loro canale #news nel loro discord:

> Ciao a tutti,
>
> Vorremmo affrontare la situazione attuale che è in corso ed evidenziare alcuni punti importanti:
>
> * Un utente malintenzionato ha creato diversi account e caricato progetti contenenti malware sulla piattaforma
> * Separatamente, un utente appartenente a Luna Pixel Studios (LPS) è stato violato ed è stato utilizzato per caricare malware simili
> * Abbiamo bannato tutti gli account rilevanti e disabilitato anche quello LPS. Siamo in contatto diretto con il team LPS per aiutarli a ripristinare l'accesso
> * Stiamo esaminando TUTTI i nuovi progetti e file per garantire la vostra sicurezza. Ovviamente <u> stiamo trattenendo il processo di approvazione di tutti i nuovi file fino a quando il problema non sarà risolto</u>
> * L'eliminazione del client di CurseForge non è una soluzione consigliata in quanto non risolverà il problema e ci impedirà di implementare una correzione. Stiamo lavorando a uno strumento per aiutarvi ad assicurarvi di non essere esposti a nulla di tutto ciò. Nel frattempo fate riferimento alle informazioni pubblicate su #current-issues.
> * Questo è rilevante SOLO per gli utenti di Minecraft
> * Per essere chiari **CurseForge non è stato compromesso! Nessun admin account è stato hackerato.**
>
> Stiamo lavorando per assicurarci che la piattaforma rimanga un luogo sicuro per scaricare e condividere mod. Grazie a tutti gli autori e utenti che ci aiutano con l'evidenziazione, apprezziamo la vostra collaborazione e pazienza ❤️
>
> Resta sintonizzato per ulteriori aggiornamenti e risolveremo questo problema.

----
*2023-06-07 07:24 UTC*

Darkhax ha contattato i rappresentanti di CurseForge i quali hanno confermato che i file infetti erano stati caricato tramite la UI, non l'API.

CurseForge ha fermato le approvazioni di altri caricamenti mentre questa situazione si sviluppa e hanno eliminato molti file infetti.

Stanno anche investigando gli IP delle persone che hanno caricato i file maliziosi, per vedere se corrispondono alle precedenti richieste dei legittimi titolari degli account.

----
*2023-06-07 7:03 UTC*

Crediamo di aver scoperto la vera funzione della fase 3 (`client.jar`) e stiamo cercando di documentarla qui. Non è bello, gente.

La versione veloce, mentre cerchiamo di dare una forma al documento: client.jar cerca *tutti i file di sistema* per file che assomigliano a jar di mod, e li infetta con la fase 0. Questo comprende *tutte le cache di Gradle e Maven*, così come un sacco di cose che gli sviluppatori di mod non controllerebbero mai. La portata e le possibilità di questa infezione sono passate da "un paio di modifiche strane" a *potenzialmente infinite*.

Crediamo che questo sia il come questa infezione si sia inizialmente diffuse, CurseForge potrebbe non essere stato il vettore di attacco iniziale.

----

*2023-06-07 6:27 UTC*

L'investigazione ha rallentato e molti del team stanno andando a letto. unascribed ha aperto una casella di posta elettronica così che le persone possano inviare campioni o altre informazioni utili. williewillus sta al momento lavorando nel pulire e inserire le informazioni presentate da D3SL in questo documento.

----

*2023-06-07 6:20 UTC*

D3SL informa il Discord non ufficiale che ha una copia della fase 3 completa (non troncata) del `client.jar`, così come un'analisi dettagliata di cosa fa il malware. Si sono accorti di ciò già settimane fa e intrapreso un'analisi dettagliata, e come risultato di essa siamo riusciti ad ottenere copie complete di tutti i payloads.

----

*2023-06-07 5:27 UTC*

Abbiamo scoperto un potenziale (troncato) file della fase 3; è fortemente offuscato e contiene una DLL di payload nativa che tenta di rubare le credenziali dall'archivio delle credenziali di Windows.

----

*2023-06-07 4:57 UTC*

I file caricati in Aprile sono stati scoperti; o le date sono state falsificate, o questo è andato avanti ancora più a lungo. Molti account sono stati attivi l'ultima volta nel 1999 - probabilmente una stranezza con i vecchi account CurseForge, ma comunque degna di nota.

Lo staff di Modrinth sta investigando se qualche caricamento sulla piattaforma è compromesso. Un passaggio veloce che hanno fatto recentemente su progetti aggiornati di recente sembrano OK.

----
    
*2023-06-07 4:40 UTC*

La portata di questo compromesso sembra più ampia di quanto inizialmente realizzato. I file maliziosi vanno indietro di molteplici settimane, già dal 20 Maggio. Ce ne siamo accorti solo oggi perché hanno compromesso un modpack popolare.

---

*2023-06-07 3:38 UTC*


Il server di Comando & Controllo è stato disattivato dal provider del server. Probabilmente ne uscirà uno nuovo se la pagina di Cloudflare rimane attiva, la stiamo monitorando.

----

*2023-06-07 3:26 UTC*

Ci è stato inviato un possibile jar della fase 2 da un utente anonimo che afferma di lavorare su un host del server.

----

*2023-06-07 2:26 UTC*

Il canale #cfmalware EsperNet è stato creato per coordinare le discussioni che si erano svolte in più gilde Discord e spazi Matrix.

----

*2023-06-07 0:40 UTC*

Il team dietro questo documento viene a conoscenza dei file maliziosi inclusi in un aggiornamento non autorizzato di Better Minecraft.

----

*2023-06-01 to 2023-06-04*

D3SL si insospettisce del consumo di CPU e RAM da parte dei file dannosi e inizia
indagare. Ordine delle operazioni:

1. Il sospetto sulla richiesta del firewall dell'eseguibile Java porta al suo blocco.
2. L'impossibilità di raggiungere i servizi self-hosted porta al visualizzatore eventi che mostra tutte le porte tcpip bloccate
3. Netstat mostra un massiccio consumo di porte tramite il PID del file jar ostile
4. L'identificazione del malware javaw.exe dannoso che esegue il malware confermato libwebgl64.jar

Da qui in avanti Tzalument è stato determinante nell'assistere con l'iniziale risorgimento al codice sorgente del codice byte[] offuscato e ha catturato manualmente un set completo di file dalle destinazioni remote.

Copie complete di tutti i file originali (incluse le deoffuscazioni) eccetto lib.dll, traduzoini di tutte le destinazioni remote contattate, e un resoconto del processo di infezione e delle diverse capacità ostili sono state fornite attraverso i canali a Windows Defender e Malwarebytes. Anche CurseForge è stato avvisato. 

Full copies of all original files (incl. deobfuscations) except lib.dll, translations of
all remote destinations contacted, and a writeup of the infection process and several
hostile capabilities were provided through channels to Windows Defender and
Malwarebytes. Curseforge was notified as well. La conoscenza del malware non è stata condivisa
pubblicamente in questo momento per evitare di avvertire gli aggressori

----
