General 
- **Do not use a VM it can escape**
- set 'neko.run' to an empty string
  * May change due to Stage 1 sourcing 
- protect your startup programs 
- Sandbox mincraft to only acess '.minecraft' and its recursive descendants and the internet 

Windows

- Delete the 'C:\Users\[User]\AppData\Local\Microsoft Edge' path, however this is a removal of the virus so password change is necssary 
- Password protect editing of registy 'HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run

Linux
- Premake ~\.config.\data dirrectroy, make it owned by root. Then set Immutable Flag 
 * prevents stage 2 saving
