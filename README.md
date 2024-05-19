## Gestión Facultades (Angular y Spring)

### Descripción del proyecto:

Es una aplicación web que esta desarrollada por la herramienta Angular para la parte de cliente y de servidor utilizamos Spring. El proyecto se basa en la organización de aplicación web que nos permite agregar, modificar, eliminar y obtener una lista de facultades para la Universidad Tecnológica del Norte. 
Así mismo, en la parte de arriba podremos observar el logotipo de la facultad con su nombre y por debajo una barra de búsqueda con un botón de buscar el cual tiene como función tener una lista de facultades que contengan la misma ciudad que aparecerán debajo filtro de búsqueda. En las facultades tendremos su información detalla los cuales son: nombre de la facultad, ciudad, campus, una foto de la facultad, y el número de carreras.  
 
### Puntos de Rúbrica implementado: 

#### Angular: 
La aplicación con tiene tres paginas, en los cuales se encuentra la pagina de inicio donde se tiene todas las facultades, otra para añadir una nueva y finalmente una pagina para modificar una facultad existente.

- Contiene una barra de búsqueda la cual filtra las facultades por ciudad.
- Tiene una pantalla con un formulario el cual permite agregar una nueva facultad.
- Tiene una pantalla con un formulario en el cual se puede observar los datos que tiene la facultad y  actualizarlos.
- También contiene un botón de eliminar facultad en la que aparece en cada facultad de la pagina principal. 

#### Spring: 
Utilizamos esta herramienta para levantar el servidor de la aplicación, además de conectar la herramienta de angular con Spring, para que se puedan gestionar las facultades en java por medio  del controller. Así mismo, los datos de las facultades se pueden obtener del repositorio que esta conectando con la base de datos de MySQL.

- Se agrego el método GET para obtener la facultad o la lista de facultades que están almacenadas en la base de datos.
- Para la creación de una nueva facultad utilizamos POST.
- Usamos PUT para modificar la facultad.
- También utilizamos DELETE para eliminar la facultad.
- Se utilizo les test unitarios para comprobar el POST, PUT, DELETE, así como la serialización y deserialización de la facultad las cuales pudimos comprobar con éxito.

### Puntos de Rúbrica no implementados:

#### Angular:

- Implementación del Widget .
- La paginación para que aparezca una cantidad de facultades por pagina. 
- Uso de Test Unitarios. 
 
#### Spring:
- Implementación de la paginación.
- Añadir una tabla adicional.
- Consultas de búsquedas por filtrado.

### Enlace del video de Angular y Spring:
 https://eepmad-my.sharepoint.com/:v:/g/personal/kmateo-simbana1_eep-igroup_com/EWgnAOiNNJ1Pgfs7ippeZBkBgq-tjzyXhKn3IBXDyi2ohg?e=HFqBpT&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D