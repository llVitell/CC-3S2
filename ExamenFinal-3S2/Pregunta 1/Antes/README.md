# Antes
En la revisión de código se observa que en las lineas 4 y 5 de la clase ```Airport``` se definen dos tipos de vuelo "Economico" y "Negocios"
```Java
Flight economyFlight = new Flight("1", "Economico"); 
Flight businessFlight = new Flight("2", "Negocios");
```
Sin embargo en los métodos ```addPassenger``` y ```removePassenger``` de la clase ```Flight``` se definen solo dos tipos de vuelos posibles: "Economica" y "Negocios"
```Java
switch (flightType) { 
            case "Economica": 
                if (!passenger.isVip()) { 
                    return passengers.remove(passenger); 
                } 
                return false; 
            case "Negocios": 
                return false; 

            default: 

                throw new RuntimeException("Tipo desconocido: " + flightType); 
        } 
```
Lo cual resulta en un error al momento de ejecutar la clase Airport ya que el tipo de vuelvo "Economico" no existe.
Una solución óptima para este error sería definir los tipos de vuelo en una clase ENUM sin embargo, por el momento la solución rápida sería:
```Java
Flight economyFlight = new Flight("1", "Economica"); // antes: Flight economyFlight = new Flight("1","Economico")
Flight businessFlight = new Flight("2", "Negocios");
```


