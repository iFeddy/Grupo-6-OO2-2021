# Trabajo Práctico Cuatrimestral OO2

## Instalación

```
git clone https://github.com/iFeddy/Grupo-6-OO2-2021.git
```

## Helpers

### ConfigHelper
Configuraciones Globales como el nombre de la app, permisos, db, etc

### RouteHelper
Para no tener que andar cambiando las rutas desde los metodos, las propiedades tienen que ser static String, despues en los metodos de los controladores lo llamamos asi:

```
ModelAndView view = new ModelAndView(RouteHelper.INDEX);
```

## Actualizar Dependencias Front-end
No creo que sea necesario usar esto pero si hay que actualizar jQuery/Bootstrap etc... hay que usar npm y copiar el dist dentro de static (esta mal pero funciona)

```
npm update
```