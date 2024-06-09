### Linea del tiempo

La linea del tiempo es de abajo hacia arriba. Los eventos de arriba son los más recientes.

---
*2023-06-09 07:48 UTC*

Los creadores de la etapa 3b (skyrage) aparentemente han perdido su dominio skyrage.de (nombre de servidor y entradas de registro cambiadas, las entradas de DNS desparecieron)

---
*2023-06-08 10:50 UTC*

Los servidores actuales de la etapa 3b (skyrage) `95[.].214.27.172` y `171[.]22.30.117` ya no son alcanzables. Esperando por cambios de DNS potenciales.

El tiempo es cuando se notó, no cuando ocurrió.

---
*2023-06-08 05:11 UTC*

Prospector anunció lo siguiente:

> Una actualización de Modrinth, todos los archivos subidos en los últimos 10 meses
> (acerca de la mitad de nuestros archivos) han sido escaneados y ninguno archivo
> infectado ha sido encontrado

---
*2023-06-08 01:12 UTC*

Las cosas se han calmado de nuevo, los escáneres de virus han empezado a detectar los archivos jar de las etapas +1 como maliciosas, y una reunión para los siguientes pasos es planeada para la siguiente mañana en los E.U.

La reunión va a ser semi-privada, pero las grabaciones/minutos van a ser compartidos después.

CurseForge está escaneando todos los mods, pero ese proceso aún sigue en curso.

---
*2023-06-07 18:51 UTC*

El servidor de C&C `107[.]189.3.101` ha sido suspendido por su proveedor de alojamiento.

---
*2023-06-07 16:00 UTC*

Debido a lag en HackMD, este documento ha sido transferido al repositorio de GitHub
https://github.com/fractureiser-investigation/fractureiser

---
*2023-06-07 14:40 UTC*

La etapa 3 sin encriptar ha sido remplazada por una encriptada, entonces por otra carga util maliciosa.

Esa carga util es el actualizador de skyrage, que es un conocido virus de Minecraft para servidores de Spigot.

Después de servir skyrage por un tiempo, ha cambiado de nuevo para servidor el cliente hackeado Meteor.

(PARA HACER: este marco de tiempo no es completamente preciso)

---
*2023-06-07 14:20 UTC*

El análisis de la nueva dirección IP lleva a la etapa 3 completamente sin encriptar, aparentemente subido por accidente.

Ha sido archivado aquí: https://github.com/clrxbl/NekoClient

---
*2023-06-07 14:19 UTC*

El dominio de páginas de Cloudflare ha sido derribado.

---
*2023-06-07 14:05 UTC*

El dominio de páginas de Cloudflare ha cambiado para apuntar a una nueva dirección de IP, 107.189.3.101.

---


*2023-06-07 08:52 UTC*

El polvo ha comenzado a asentarse por ahora. Tenemos una buena idea de las primeras etapas del virus, y la etapa 3 está siendo sometida a ingeniería inversa. La primera etapa está temporalmente inactiva.

Resumiremos las actualizaciones la siguiente mañana tiempo de E.U. (o alrededor).

----
*2023-06-07 08:09 UTC*

Seguimos trabajando en la ingeniería inversa de la etapa 3, ve la sección de abajo para detalles técnicos.

----
*2023-06-07 07:37 UTC*

CurseForge publicó lo siguiente en su canal #news de discord:

>Hola a todos,
>
>Nos gustaría atender la situación actual que está en curso y remarcar algunos puntos importantes:
>
>* Un usuario malicioso ha creado varias cuentas y ha subido proyectos conteniendo software malicioso a la plataforma
>* Separadamente, un usuario perteneciente a Luna Pixel Studios (LPS) fue hackeado y ha subido software malicioso similar
>* Hemos bloqueado todas las cuentas relevantes a esto y también hemos deshabilitado la cuenta de LPS. Estamos en contacto directo con el equipo de LPS para ayudarlos a restaurar su acceso.
>* Estamos en el proceso de revisar TODOS los nuevos proyectos y archivos para garantizar tu seguridad. Tenemos, por supuesto, <u>en espera el proceso de aprobación de nuevos archivos hasta que esto es resuelto</u>
>* Eliminar tu cliente de CF no es una solución recomendada pues no va a resolver el problema y va a prevenir que despleguemos una solución. Estamos trabajando en una herramienta para ayudar a estar seguros que no fuiste expuesto a nada de esto. Mientras tanto, refiéranse a la información publicada en #current-issues.
>* Esto es relevante SOLO para usuarios de Minecraft.
>* Para ser claros, **CurseForge no está comprometido! Ninguna cuenta de administrador fue infectada.**
>
>Estamos trabajando en esto para estar seguros que la plataforma sigue siendo un >lugar seguro para descargar y compartir mods. Gracias a todos los autores y >usuarios que nos ayudan a remarcar, apreciamos su cooperación y paciencia.
>
>Manténgase al tanto para mas actualizaciones y solucionaremos este problema.

----
*2023-06-07 07:24 UTC*

Darkhax ha contactado los representativos de CurseForge que han confirmado que los archivos afectados fueron subidos via la interfaz, no la API.

CurseForge ha detenido las aprobaciones de subidas mientras esta situación se desarrolla y ha también eliminado varios archivos infectados.

Están también investigando las IPs de los autores de los archivos maliciosos, para ver si concuerdan con solicitudes previas por los poseedores legítimos de las cuentas.

----
*2023-06-07 7:03 UTC*

Pensamos que hemos descubierto la verdadera función de la etapa 3 (`client.jar`) y estamos intentando documentarlo aquí. No es bueno, amigos.

La version rápida, mientras obtenemos este documento en forma: client.jar busca *el sistema de archivos entero* por archivos que parecen como mods, y los infecta con la etapa 0. Esto incluye *las cachés de Gradle y Maven enteras*, así como muchas otras cosas que desarrolladores de mods nunca pensarían en revisar. La escala y alcance potencial de esta infección va desde "algunos mods extraños" a *potencialmente infinita*.

Creemos que esto es como la infección inicialmente se propago, y como CurseForge pudo no haber visto el vector de ataque inicial.

----

*2023-06-07 6:27 UTC*

La investigación se ha ralentizado y la mayor parte del equipo está llendo a dormir. unascribed ha abierto un correo electrónico para que las personas envíen muestras u otra información util. williewillus está actualmente trabajando para limpiar y obtener la información presentada por D3SL en este documento.

----

*2023-06-07 6:20 UTC*

D3SL informa al Discord que tienen una copia completa (sin truncar) de la etapa 3 `client.jar`, así como análisis a fondo de que es lo que está haciendo. Se dieron cuenta de esto algunas semanas atrás y tomaron análisis profundos, y como resultado fue posible de obtener copias de todas las cargas útiles.

----

*2023-06-07 5:27 UTC*

Hemos descubierto un archivo Etapa 3 (truncado); está bastante encriptado y contiene una carga util nativa en DLL que intenta robar credenciales de Windows Credential Store.

----

*2023-06-07 4:57 UTC*

Archivos subidos en Abril han sido descubiertos; puede que las fechas han sido suplantadas o esto ha estado en progreso desde mas tiempo. Muchas de las cuentas tienen fechas de ultima vez conectado en 1999 — probablemente una característica en cuentas de CurseForge viejas.

El personal de Modrinth están investigando si alguna subida fue comprometida. En una verificación rápida que hicieron en proyectos recientes todo pareció estar bien.

----

*2023-06-07 4:40 UTC*

El alcance de este compromiso parece mas largo que inicialmente. Los archivos maliciosos van atrás por multiples semanas, hasta el 20 de mayo. Solo nos dimos cuenta hoy porque comprometieron un modpack popular.

---

*2023-06-07 3:38 UTC*

El servidor de C&C ha sido derribado por su proveedor. Uno nuevo probablemente vendrá si la pagina de Cloudflare se mantiene arriba, estamos monitoreandolo.

----

*2023-06-07 3:26 UTC*

Se nos envió un posiblemente una archivo jar de etapa 2 por un usuario anónimo que dice trabajar en un proveedor de alojamiento.

----

*2023-06-07 2:26 UTC*

El canal #cfmalware de EsperNet ha sido creado para coordinar la discusión que ha estado pasando en multiples servidores de Discord y espacios de Matrix.

----

*2023-06-07 0:40 UTC*

El equipo detrás de este documento aprende de los archivos maliciosos incluidos en una actualización no autorizada a Better Minecraft.

----

*2023-06-01 to 2023-06-04*

D3SL está sospechando del uso de CPU y RAM de los archivos maliciosos y empieza a investigar. Orden de operaciones:

1. Sospecha acerca de la solicitud del ejecutable de Java que lleva a ser bloqueada.
2. Inhabilidad de alcanzar servicios autoalojados lleva al visor de eventos a mostrar todos los puertos tcpip bloqueados.
3. Netstat muestra un consumo masivo de puertos via el PID del archivo jar hostil
4. Identificando el malicioso javaw.exe ejecutar libwebgl64.jar confirmado malicioso.

Desde aquí, Tzalumen fue esencial en asistir con la ingeniería inversa inicial de el código byte[] encriptado y manualmente capturar un conjunto de archivos completo de las ubicaciones remotas.

Copias completas de todos los archivos originales (incluyendo desencriptaciones) excepto lib.dll, traducciones de todas los destinos remotos conectados y un informe del proceso de infección y capacidades hostiles fueron proveídas mediante canales a Windows Defender y Malwarebytes. CurseForge también fue notificado. El conocimiento del malware no fue publicado hasta este tiempo para evitar alertar a los atacantes.

----