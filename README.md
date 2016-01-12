# springBatch
Proyecto maven de ejemplo que muestra como usar springBatch

+ Concepto de job

+ Concepto de step
Flujo de steps condicionales
Steps que se repiten ante un error (Decisor)

+ Concepto de chunk (reader - processor - writer)
 Ejemplo manual 
 Ejemplo lectura de ficheros usando FlatFileItemReader

+ Gestion de transacciones
PROPAGATION_REQUIRED: soporte a la transaccion actual. Crea una nueva si no existe.
PROPAGATION_REQUIRES_NEW: crea una nueva transaccion suspendiendo la anterior en caso de existir.
PROPAGATION_SUPPORTS: soporte a la transaccion actual. Si no existe transaccion, no existe una nueva
ISOLATION_DEFAULT: Utiliza la configuracion por defecto del datastore

+ Gestion de hilos
Configurable usando el paquete  org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor