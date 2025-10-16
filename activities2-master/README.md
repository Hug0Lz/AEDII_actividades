# Actividades de AED2
## Índice

* [1. Introducción](#1-introducción)
* [2. Instalación de Apache NetBeans 22](#2-instalación-de-apache-netbeans-22)
  * [2.1. Introducción](#21-introducción)
  * [2.2. Requisitos Previos](#22-requisitos-previos)
  * [2.3. Descarga de Apache NetBeans 22](#23-descarga-de-apache-netbeans-22)
  * [2.4. Instalación en Linux](#24-instalación-en-linux)
    * [2.4.1. Verificar la instalación de Java 21](#241-verificar-la-instalación-de-java-21)
    * [2.4.2. Instalación en distribuciones basadas en Debian/Ubuntu](#242-instalación-en-distribuciones-basadas-en-debianubuntu)
    * [2.4.3. Instalación en distribuciones basadas en RHEL/Fedora](#243-instalación-en-distribuciones-basadas-en-rhelfedora)
    * [2.4.4. Ejecutar NetBeans en Linux](#244-ejecutar-netbeans-en-linux)
   * [2.5. Instalación en Windows](#25-instalación-en-windows)
     * [2.5.1. Verificar la instalación de Java 21](#251-verificar-la-instalación-de-java-21)
     * [2.5.2. Ejecutar el instalador de NetBeans](#252-ejecutar-el-instalador-de-netbeans)
   * [2.6. Verificación Final](#26-verificación-final)
* [3. Descarga del proyecto](#3-descarga-del-proyecto)
  * [3.1. Requisitos Previos]((#31-requisitos-previos))
  * [3.2. Pasos para clonar el proyecto](#32-pasos-para-clonar-el-proyecto)
    * [3.2.1. Desde NetBeans](#321-desde-netbeans)
    * [3.2.2. Desde línea de comandos](#322-desde-linea-de-comandos)
* [4. Exportar e importar el proyecto](#4-exportar-e-importar-el-proyecto)
* [5. Trabajar con el proyecto](#5-trabajar-con-el-proyecto)
  * [5.1. Estructura de paquetes del proyecto](#51-estructura-de-paquetes-del-proyecto)
  * [5.2. Estructura de clases de un paquete](#52-estructura-de-clases-de-un-paquete)
  * [5.3. Codificación](#53-codificacion)
  * [5.4. Prueba](#54-prueba)

------

## 1. Introducción

Este proyecto contiene las plantillas para la resolución de todos los boletines de ejercicios que se van a trabajar a lo largo del curso en la asignatura AEDII.

El documento que se muestra a continuación proporciona una guía completa para la instalación y uso de Apache NetBeans 22, un entorno de desarrollo integrado (IDE) de código abierto para sistemas operativos Linux y Windows, donde se utiliza Java 21 como entorno de ejecución.

En el apartado de instalación se indican los pasos a seguir para verificar la correcta instalación de Java, así como la descarga de NetBeans y su instalación tanto en Linux (distribuciones Debian/Ubuntu y RHEL/Fedora) como en Windows. También se incluye un proceso de verificación final para asegurar que NetBeans y Java estén correctamente configurados.

A continuación, se explican los pasos para clonar un proyecto directamente desde NetBeans o mediante la línea de comandos, así como los pasos para importar/exportar el proyecto entre diferentes entornos. 

Por último, se detalla la estructura de paquetes y clases del proyecto AEDII-Activities, y se describen las diferentes formas de codificación y prueba de los ejercicios, incluyendo tanto la ejecución de clases de prueba como métodos específicos.

------

## 2. Instalación de Apache NetBeans 22

Apache NetBeans es un entorno de desarrollo integrado (IDE) de código abierto que permite desarrollar aplicaciones en múltiples lenguajes como Java, PHP y HTML5, entre otros. A continuación, se detallan los pasos necesarios para instalar NetBeans 22 en Linux y Windows.

### 2.1. Introducción

Este tutorial explica cómo instalar **Apache NetBeans 22** en **Linux** y **Windows**, usando **Java 21** como entorno de ejecución.  

### 2.2. Requisitos Previos

1. **Java Development Kit (JDK)** versión 21 instalado.  
2. Conexión a Internet para descargar los archivos de instalación.

### 2.3. Descarga de Apache NetBeans 22

1. Visita el sitio oficial de Apache NetBeans:  
   [https://netbeans.apache.org/front/main/download/nb22/](https://netbeans.apache.org/front/main/download/nb22/).

2. Descarga el archivo adecuado para tu sistema:  
   - **Linux (Debian/Ubuntu):** Paquete `.deb`.  
   - **Linux (RHEL/Fedora):** Paquete `.rpm`.  
   - **Windows:** Instalador `.exe`.

### 2.4. Instalación en Linux

#### 2.4.1. Verificar la instalación de Java 21

Abre un terminal y ejecuta:

```bash
java -version
```

Si no está instalado, agrega **OpenJDK 21**. Por ejemplo, en Ubuntu/Debian deberías hacer lo siguiente:

```bash
sudo apt update
sudo apt install openjdk-21-jdk -y
```

En Fedora/RHEL usa:

```bash
sudo dnf install java-21-openjdk -y
```

Verifica nuevamente la correcta instalación de Java 21:

```bash
java -version
```

#### 2.4.2. Instalación en distribuciones basadas en Debian/Ubuntu

1. Navega a la carpeta donde descargaste el archivo `.deb` (ejemplo: `~/Descargas`):

```bash
cd ~/Descargas
```

2. Instala el paquete con **dpkg**:

```bash
sudo dpkg -i apache-netbeans_22-1_all.deb
```

3. Si hay dependencias faltantes, corrígelas ejecutando:

```bash
sudo apt install -f
```

---

#### 2.4.3. Instalación en distribuciones basadas en RHEL/Fedora

1. Navega a la carpeta donde descargaste el archivo `.rpm`:

```bash
cd ~/Descargas
```

2. Instala el paquete con **dnf**:

```bash
sudo dnf install apache-netbeans-22-0.noarch.rpm
```

#### 2.4.4. Ejecutar NetBeans en Linux

Una vez instalado, inicia NetBeans mediante el siguiente comando:

```bash
netbeans
```

Si no funciona, verifica que la ruta del ejecutable se haya añadido correctamente al PATH. Si sigue sin funcionar realiza los ajustes necesarios (revisar permisos, verificar que tienes Java instalado, revisar errores de ejecución).

### 2.5. Instalación en Windows

#### 2.5.1. Verificar la instalación de Java 21

1. Abre el **Símbolo del sistema** (cmd) y verifica la versión de Java:

```bash
java -version
```

2. Si no tienes Java, descarga el instalador de **JDK 21** desde: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/).
3. Asegúrate de [agregar Java a la variable de entorno **PATH**](https://www.java.com/es/download/help/path_es.html).

#### 2.5.2. Ejecutar el instalador de NetBeans

1. Localiza el archivo `.exe` descargado y ejecútalo.  
2. Sigue los pasos del asistente de instalación:  
   - Selecciona la carpeta de instalación (ejemplo: `C:\Program Files\NetBeans-22`).  
   - Verifica que detecte **Java 21** correctamente.

3. Finaliza la instalación.

### 2.6. Verificación Final

1. Abre **NetBeans** desde el menú de inicio (Windows) o un terminal (Linux).  
2. Ve a **Tools > Options** y verifica que la ruta del JDK sea la correcta (debe apuntar a Java 21).  
3. Crea un nuevo proyecto (por ejemplo, uno de Java) y compílalo para asegurarte de que todo funciona correctamente.

------

## 3. Descarga del proyecto

A continuación, se indican los pasos a seguir para clonar un proyecto desde NetBeans.

### 3.1 Requisitos Previos

- Asegúrate de tener correctamente instalado y configurado NetBeans.

### 3.2 Pasos para clonar el Proyecto

#### 3.2.1 Desde NetBeans

1. Abre **NetBeans** en tu ordenador.

2. Ve a **Team > Git > Clone...**

3. Introduce la URL https://github.com/esei-aed/activities1 en el campo **Repository URL**. [TODO]

4. Selecciona la carpeta de tu ordenador en donde vas a clonar el proyecto, haciendo clic en **Browse...**

5. Para finalizar el clonado del proyecto:

   - Haz clic en **Next** y revisa la información del repositorio.

   - Luego, haz clic en **Finish**.

#### 3.2.2. Desde línea de comandos

Para poder clonar el proyecto desde línea de comandos sigue los pasos que se indican:

1. Abre un terminal

2. Asegúrate de tener instalado Git. 

   ```bash
   git --version
   ```

   Si no lo tienes, descárgalo desde https://git-scm.com/

3. Accede a la carpeta en donde vas a clonar el proyecto (ejemplo: `~/Documentos`/AEDII/):

   ```bash
   cd ~/Documentos/AEDII/
   ```

4. Ejecuta el siguiente comando para clonar el proyecto:

   ```bash
   git clone https://dev.sing-group.org/gitlab/aed/activities2 
   ```

 Una vez clonado, puedes abrir el proyecto en **NetBeans **y comenzar a trabajar.

------

## 4. Exportar e importar el proyecto

Para mover el proyecto de un ordenador a otro, se puede *exportar*/importar. Los pasos a seguir se describen a continuación:

### 4.1 Exportar

1. Desde  **NetBeans**.

2. Ve a **File > Export Project > To ZIP...**

3. Selecciona en **Root Project** el proyecto a exportar.

4. Indica la carpeta donde se va a guardar el fichero comprimido, haciendo clic en **Browse...** (asegúrate que indicas la extensión .zip en el nombre del fichero).

5. Para finalizar, haz clic en **Export**.

Una vez exportado, puedes copiar el fichero comprimido (.zip) en tu dispositivo de almacenamiento o en la nube.

### 4.2 Importar

1. Desde  **NetBeans**.
2. Ve a **File > Import Project > From ZIP...**
3. Selecciona el fichero zip a importar, haciendo clic en **Browse...** de la opción **ZIP File**. 
4. Indica la carpeta donde se va a guardar el proyecto, haciendo clic en **Browse...** de la opción **Folder**.
5. Para finalizar, haz clic en **Import**.

 Una vez importado, puedes abrir el proyecto en **NetBeans **y comenzar a trabajar.

------

## 5. Trabajar con el proyecto

### 5.1. Estructura de paquetes del proyecto

El proyecto AEDII-Activities, en la carpeta *Source Packages*, contiene varios paquetes nombrados como `es.uvigo.esei.aed2.activityX`, donde `X` se sustituye por un número que identifica a cada uno de los boletines concretos de ejercicios de la asignatura, cuyo enunciado está disponible en Moovi.

Cada boletín contiene varios ejercicios para resolver:

- En algunos casos, todos los ejercicios del boletín se resolverán en **una única clase java**, como es el caso del boletín 2, que se implementará íntegramente en la clase Activity2 del paquete `es.uvigo.esei.aed2.activity2`. 
- En otros casos, el boletín se revolverá en **varias clases**, como es el caso del boletín 3, donde los ejercicios se encuentran en paquetes distintos (`es.uvigo.esei.aed2.activity3.implementation`, `es.uvigo.esei.aed2.activity3.use`...) . En ese caso se nombran como `es.uvigo.esei.aed2.activityX.nameClass`, donde `nameClass` es un nombre representativo del ejercicio. 

### 5.2. Estructura de clases de un paquete

El proyecto AEDII-Activities, en la carpeta *Source Packages*, contiene tres tipos de paquetes:

- **Paquetes con una sola clase**, como el paquete `es.uvigo.esei.aed2.activity2`, que contiene la clase Activity2.java, donde están los encabezados de los métodos a codificar para resolver todos los ejercicios del boletín 2. 
- **Paquetes con más de una clase**, como el paquete `es.uvigo.esei.aed2.activity4`, que contiene todas las clases necesarias para resolver un ejercicio del boletín 4, estando algunas de ellas ya codificadas para agilizar y facilitar la resolución del ejercicio.  

### 5.3. Codificación 

Para resolver los ejercicios de un boletín concreto:

1. Selecciona el paquete que se corresponde con el número de boletín a resolver (ejemplo, `es.uvigo.esei.aed2.activity2` para trabajar con el boletín 2).
2. Abre la clase donde vas a codificar los ejercicios ( ejemplo, `Activity2`).
3. Lee el enunciado del boletín y resuelve cada ejercicio planteado codificando el método correspondiente en la clase adecuada (ejemplo, método `isComplete`). Cada una de las clases ya incorpora la cabecera del método a codificar.

### 5.4. Prueba

Para probar la correcta ejecución de los métodos se hará uso de las clases de prueba situadas en la carpeta *Test Packages* del proyecto AEDII-Activities. Esta carpeta también se encuentra organizada en paquetes que se corresponden con los boletines. En cada paquete hay, por lo menos, una clase de prueba que se identifica porque su nombre termina con el sufijo *TestCase* (ejemplo, `Activity2TestCase` o `LinkedBinaryTreeTestCase`). 

Para **ejecutar una clase de prueba**:

1. Haz clic derecho en dicha clase (ejemplo `Activity2TestCase` ).
2. Selecciona **Test File**.

Es posible **ejecutar un método específico de una clase de prueba** mediante el siguiente procedimiento:

1. Abre la clase de prueba (ejemplo, `Activity2TestCase`).
2. Localiza el método de prueba específico a ejecutar. El método debe estar anotado con `@Test` (ejemplo, `testCompleteEmptyTree`).
3. Haz clic derecho en el nombre del método.
4. En el menú contextual que aparece, selecciona **Run Focused Test Method**.







