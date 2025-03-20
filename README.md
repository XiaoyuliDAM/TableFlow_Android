#  LLegeix-me de l’App TableFlow

**Table Flow** és una aplicació per a la gestió de restaurants que permet als usuaris realitzar comandes i gestionar l'ocupació de les taules de manera eficient.

##  Característiques
-  Inici de sessió amb validació d'usuari i contrasenya.
-  Navegació amb **DrawerLayout** i menú lateral amb informació de l'usuari.
-  Gestor de **rols** (exemple: **encarregat/da, cambrer/a, cuiner/a**).
-  Botó de **tancament de sessió** per tornar a la pantalla de login.

##  Tecnologies Utilitzades
- **Android Studio (Java)**
- **ConstraintLayout** i **DrawerLayout**
- **NavigationView** amb un headerLayout
- **Gestió de SharedPreferences** per a la sessió

##  Instal·lació
1. Clona aquest repositori:
   ```sh
   git clone https://github.com/XiaoyuliDAM/TableFlow_Android.git
   ```
2. Obre el projecte a **Android Studio**.
3. Assegura't de tenir configurat un **emulador** o **dispositiu físic**.
4. Executa l'aplicació.

##  Ús de l'Aplicació
###  Iniciar sessió amb:
```plaintext
Usuari: Francisco
Contrasenya: rosa1234
```
Si les dades són incorrectes:
- Es mostrarà un missatge d'error indicant **"Usuari incorrecte"** o **"Contrasenya incorrecta"**.

###  Pantalla Dashboard:
- Es mostrarà el **menú lateral** amb la informació de l'usuari.
- Un **botó de Tancar Sessió** permet tornar al **login**.

###  Pantalla de Registre:
- Disponible des de la pantalla d'**inici de sessió**.

##  Estructura del Projecte
```plaintext
TableFlow/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/li/ioc/tableflow/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── DashboardActivity.java
│   │   │   │   ├── RegisterActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_dashboard.xml
│   │   │   │   │   ├── activity_register.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── themes.xml
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── ic_user.xml
│   │   │   │   │   ├── ic_password.xml
│   │   │   │   │   ├── ic_logout.xml
```

##  Futures Millores
- 🔹 **Integració amb una base de dades real.**
- 🔹 **Implementació d'autenticació amb JWT.**
- 🔹 **Personalització del menú segons el rol de l'usuari.**
- 🔹 **Millora de la UI/UX amb Material Design.**

##  Contacte
Si tens **preguntes o suggeriments**, pots contactar-me.

 **Repositori:** [GitHub - TableFlow](https://github.com/XiaoyuliDAM/TableFlow_Android)

