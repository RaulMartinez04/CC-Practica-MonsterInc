# Simulación de Monster Inc
##  Descripción

Este proyecto simula actividades en la empresa Monster Inc, donde varios monstruos participan en diferentes tareas, desde trabajar en la cafetería hasta gestionar el tanque. La simulación implementa y usa conceptos de programación concurrente.

## Instrucciones de Compilación

- Para compilar y empaquetar el proyecto, sigue estos pasos:
	- Abre una terminal y navega hasta: monster-inc-simulation/monster-inc-simulation
	- Ejecuta los siguientes comandos de Maven desde: CC-Practica-MonsterInc/monster-inc-simulation/monster-inc-simulation$
```
mvn clean install package
```
Este comando limpiará el proyecto, compilará el código fuente, ejecutará las pruebas y empaquetará la aplicación en un archivo JAR.

## Instrucciones de Ejecución

Una vez que el proyecto se haya compilado correctamente, puedes ejecutar la simulación utilizando el siguiente comando:

```
java -cp target/monster-inc-simulation-1.0-SNAPSHOT.jar com.monstersinc.MonsterInc
```

Este comando inicia la simulación de Monster Inc utilizando el archivo JAR compilado. Asegúrate de tener Java instalado en tu sistema.
