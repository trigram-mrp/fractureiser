### Harmonogram

Harmonogram jest od dołu do góry. Najnowsze wydarzenia znajdują się na górze.

---
*2023-06-09 07:48 UTC*

Twórcy Stage3b (skyrage) apparently stracili swoją domenę skyrage.de (zmienione zostały wpisy serwera nazw i rejestratora, wpisy DNS zniknęły).

---
*2023-06-08 10:50 UTC*

Obecne serwery C&C Stage3b (skyrage) `95[.].214.27.172` i `171[.]22.30.117` nie są już osiągalne. Obserwujemy możliwe zmiany DNS.

Czas to moment zauważenia, nie czas, kiedy to się stało.

---
*2023-06-08 05:11 UTC*

Prospector ogłasza następujące:

> Aktualizacja od Modrinth, wszystkie pliki przesłane w ciągu ostatnich 10 miesięcy
> (około połowa naszych plików) zostały zeskanowane i nie znaleziono żadnych zainfekowanych
> plików.

---
*2023-06-08 01:12 UTC*

Sprawy większościowo się uspokoiły, skanery wirusów zaczęły wykrywać pliki jar stage 1+
jako złośliwe, a spotkanie w sprawie kolejnych kroków zaplanowano na następny poranek w USA.

Spotkanie będzie miało charakter półprywatny, ale nagrania/protokoły zostaną udostępnione później.

CurseForge skanuje wszystkie mody, ale ten proces wciąż trwa.

---
*2023-06-07 18:51 UTC*

Drugi serwer C&C 107[.]189.3.101 został zawieszony przez dostawcę usług hostingowych.

---
*2023-06-07 16:00 UTC*

Ze względu na opóźnienia w HackMD, ten dokument został przeniesiony do repozytorium GitHub
https://github.com/fractureiser-investigation/fractureiser

---
*2023-06-07 14:40 UTC*

Niezaobfuskowany stage 3 został zastąpiony przez zafuskowany, a następnie kolejnym
ładunkiem.

Ten ładunek to aktualizator skyrage, który jest znanym złośliwym oprogramowaniem dla Minecrafta, atakującym serwery spigot.
Po pewnym czasie obsługi skyrage, zmienił się na obsługę klienta Meteor.

(TODO ten harmonogram czasowy nie jest całkowicie dokładny)

---
*2023-06-07 14:20 UTC*

Analiza nowego adresu IP ujawnia w pełni zdeobfuskowany etap 3, który wydaje się został przypadkowo przesłany.
Został zarchiwizowany tutaj: https://github.com/clrxbl/NekoClient

---
*2023-06-07 14:19 UTC*

Domena Cloudflare pages została wyłączona.

---
*2023-06-07 14:05 UTC*

Domena Cloudflare pages została przekierowana na nowy adres IP: 107.189.3.101.

---

*2023-06-07 08:52 UTC*

Pierwszy etap większościowo się uspokoił na razie. Mamy dobry obraz początkowych etapów złośliwego oprogramowania, a etap 3 jest poddawany procesowi reverse engineeringu. Pierwszy etap jest tymczasowo uśpiony.

Wznowimy aktualizacje następnego ranka, czasu amerykańskiego (lub około tego czasu).

---
*2023-06-07 08:09 UTC*

Nadal pracujemy nad odwracaniem etapu 3, szczegóły techniczne można znaleźć w sekcji poniżej.

---
*2023-06-07 07:37 UTC*

CurseForge opublikował następujące oświadczenie na kanale #news w ich dyskordzie:

> Cześć wszystkim,
> 
> Chcielibyśmy odnieść się do obecnej sytuacji, która trwa i podkreślić kilka ważnych punktów:
> 
> * Złośliwy użytkownik utworzył kilka kont i przesłał projekty zawierające złośliwe oprogramowanie na platformę
> * Oddzielnie użytkownik należący do Luna Pixel Studios (LPS) został zhakowany i użyty do przesłania podobnego złośliwego oprogramowania
> * Zbanowaliśmy wszystkie konta związane z tymi wydarzeniami i również wyłączyliśmy konto LPS. Jesteśmy w bezpośrednim kontakcie z zespołem LPS, aby pomóc im odzyskać dostęp
> * Przebiegamy TERAZ przez WSZYSTKIE nowe projekty i pliki, aby zagwarantować Wasze bezpieczeństwo. Oczywiście <u>zawieszamy proces zatwierdzania wszystkich nowych plików, dopóki to nie zostanie rozwiązane</u>
> * Usunięcie klienta CF nie jest zalecanym rozwiązaniem, ponieważ nie rozwiąże to problemu i uniemożliwi nam wdrożenie poprawki. Pracujemy nad narzędziem, które pomoże sprawdzić, czy nie byliście narażeni na te zagrożenia. W międzyczasie odwołujcie się do informacji opublikowanych w #current-issues.
> * Dotyczy to TYLKO użytkowników Minecrafta
> * Aby być jasnym **CurseForge nie jest zagrożony! Żadne konto administratora nie zostało zhakowane.**
>
> Pracujemy nad tym, aby platforma nadal była bezpiecznym miejscem do pobierania i udostępniania modyfikacji. Dziękujemy wszystkim autorom i użytkownikom, którzy pomagają nam w tej sprawie, doceniamy Waszą współpracę i cierpliwość ❤️
>
> Bądźcie na bieżąco w oczekiwaniu na kolejne aktualizacje, rozwiązanie tego problemu jest bliskie.


----
*2023-06-07 07:24 UTC*

Darkhax skontaktował się z przedstawicielami Curseforge, którzy potwierdzili, że dotknięte pliki zostały przesłane za pomocą interfejsu użytkownika, a nie interfejsu API.

Curseforge wstrzymał zatwierdzanie przesyłek podczas rozwoju tej sytuacji i usunął wiele zainfekowanych plików.

Badają również adresy IP przesyłających złośliwe pliki, aby sprawdzić, czy pasują do wcześniejszych żądań prawowitych właścicieli kont.

----
*2023-06-07 7:03 UTC*

Uważamy, że odkryliśmy prawdziwą funkcję Stage3 (`client.jar`) i próbujemy ją tutaj udokumentować. To nie wygląda dobrze, ludzie.

Krótka wersja, dopóki przygotowujemy ten dokument: client.jar przeszukuje *cały system plików* w poszukiwaniu plików wyglądających jak mod jars i infekuje je Stage0. Dotyczy to *całych cache'ów Gradle i Maven*, oraz wielu rzeczy, o których deweloperzy modów prawdopodobnie nigdy by nie pomyśleli sprawdzić. Skala i zakres tej infekcji wzrosły z "kilku dziwnych modów" do *potencjalnie nieskończoności*.

Uważamy, że to jest sposób, w jaki infekcja pierwotnie się rozprzestrzeniła, i Curseforge może nie być początkowym wektorem ataku.

----

*2023-06-07 6:27 UTC*

Śledztwo zwolniło tempo, a większość zespołu idzie spać. unascribed otworzył skrzynkę pocztową, do której ludzie mogą przesyłać próbki lub inne przydatne informacje. williewillus obecnie pracuje nad uporządkowaniem i przedstawieniem informacji dostarczonych przez D3SL w tym dokumencie.

----

*2023-06-07 6:20 UTC*

D3SL informuje nieoficjalne Discord, że mają kopię pełnej (nieobciętej) wersji Stage 3 `client.jar`, oraz dogłębną analizę tego, co robi złośliwe oprogramowanie. Zauważyli to już kilka tygodni temu i przeprowadzili dogłębną analizę, co pozwoliło im uzyskać pełne kopie wszystkich payloadów.

----

*2023-06-07 5:27 UTC*

Odkryliśmy potencjalny (obcięty) plik Stage 3; jest on silnie zaciemniony i zawiera dynamiczną bibliotekę ładującą (DLL), która próbuje kraść dane uwierzytelniające z magazynu uwierzytelniania systemu Windows.

----

*2023-06-07 4:57 UTC*

Odkryto przesłane pliki w kwietniu; albo daty są podrobione, albo to działo się jeszcze wcześniej. Wiele kont ma datę ostatniej aktywności w 1999 roku - prawdopodobnie wynika to z cechy starych kont CurseForge, ale jest to warte uwagi.

Personel Modrinth sprawdza, czy tamtejsze przesyłki nie są zagrożone. Szybkie przejście przez ostatnio zaktualizowane projekty wyglądało dobrze.

----
    
*2023-06-07 4:40 UTC*

Zakres tego naruszenia wydaje się większy, niż początkowo sądziliśmy. Złośliwe pliki sięgają kilka tygodni wstecz, aż od 20 maja. Zauważyliśmy to dopiero dzisiaj, ponieważ zainfekowano popularny modpack.

---

*2023-06-07 3:38 UTC*

Serwer C&C został wyłączony przez dostawcę serwera. Jeśli strona Cloudflare pozostanie aktywna, prawdopodobnie pojawi się nowy serwer C&C. Obserwujemy to.

----

*2023-06-07 3:26 UTC*

Otrzymaliśmy możliwy plik Stage 2 jar od anonimowego użytkownika twierdzącego, że pracuje u dostawcy serwerów.

----

*2023-06-07 2:26 UTC*

Utworzono kanał #cfmalware na EsperNet, aby skoordynować dyskusję, która toczyła się na wielu serwerach Discord i w przestrzeniach Matrix.

----

*2023-06-07 0:40 UTC*

Zespół odpowiedzialny za ten dokument dowiaduje się o złośliwych plikach zawartych w nieautoryzowanej aktualizacji Better Minecraft.

----

*2023-06-01 do 2023-06-04*

D3SL zaczyna podejrzewać zużycie procesora i pamięci RAM przez złośliwe pliki i rozpoczyna dochodzenie. Kolejność działań:

1. Podejrzenie dotyczące żądania zapory ogniowej wykonywalnego pliku Java prowadzi do jego zablokowania.
2. Niezdolność do dotarcia do usług hostowanych przez siebie prowadzi do wyświetlenia w dzienniku zdarzeń blokowania wszystkich portów tcpip.
3. Netstat pokazuje ogromne wykorzystanie portów przez PID złośliwego pliku jar.
4. Identyfikacja działającego złośliwego javaw.exe uruchamiającego libwebgl64.jar potwierdza, że jest to złośliwe oprogramowanie.

Od tego momentu Tzalumen odegrał kluczową rolę w pomocy przy początkowym reverse engineeringu kodu obfuskowanego byte[], ręcznym zebraniu pełnego zestawu plików z lokalizacji zdalnych.

Przez kanały dostarczono pełne kopie wszystkich oryginalnych plików (wraz z deobfuskacjami) oprócz lib.dll, tłumaczenia wszystkich skontaktowanych lokalizacji zdalnych oraz opracowanie procesu infekcji i kilku zdolności złośliwego oprogramowania firmie Windows Defender i Malwarebytes. Poinformowano również Curseforge. Informacje o złośliwym oprogramowaniu nie zostały podzielone publicznie w tym czasie, aby nie ostrzec atakujących.

----