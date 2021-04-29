# Trabajo Práctico Cuatrimestral OO2

## Instalación

```
git clone https://github.com/iFeddy/Grupo-6-OO2-2021.git
```

### Instalar la base de datos

Crear una base de datos que se llame:
```
oo2tpc
```
Crear un usuario de MySQL con privilegios globales con los siguientes datos:

```
Usuario: oo2tpc
Contraseña: oo2tpc
```

## Helpers

### ConfigHelper
Configuraciones Globales como el nombre de la app, permisos, db, etc

### RouteHelper
Para no tener que andar cambiando las rutas desde los metodos, las propiedades tienen que ser static String, despues en los metodos de los controladores lo llamamos asi:

```
ModelAndView view = new ModelAndView(RouteHelper.INDEX);
```

### AdminSideBarHelper
Para agregar los links del menu lateral en Admin, hay que instanciar un nuevo AdminSideBar con el ID que le corresponda

```
AdminSideBar[] links = {
            ....
            new AdminSideBar(int, "url", "class icon de fontawesome", "texto del link"),
        };      
```

## Actualizar Dependencias Front-end
No creo que sea necesario usar esto pero si hay que actualizar jQuery/Bootstrap etc... hay que usar npm y copiar el dist dentro de static (esta mal pero funciona)

```
npm update
```

## Panel de Administración

No creo que tengamos la necesidad de usar charts pero igual dejo el link del template por si necesitamos agregar algo de ahi:

Template: https://wrappixel.com/demos/admin-templates/ampleadmin/ample-admin-lite/dashboard.html

Si llegamos a necesitar Tablas podemos usar DataTables.js que funciona con jQuery