# Fase 1
Escribiendo la clase ```AirporTest.java``` se dividiría en dos casos, cuando hay un vuelo económico y cuando hay un vuelo de negocios
## ```EconomyFlightTest```
Este es el caso en el que se de un vuelo económico. Definimos nuestro entorno para poder realizar las pruebas
```Java
private Flight economyFlight;
private Passenger checha;
private Passenger lore;

@BeforeEach
void setUp() {

    economyFlight = new Flight("1","Economica"); // Tipo de vuelo a utilizar en la prueba
    checha = new Passenger("Checha", false); // Checha es un pasajero regular
    lore = new Passenger("Lore", true); // Lore es un pasajero vip

}
```
Dentro del test se abren dos casos más, si es que hay pasajeros vip o no (pasajero regular). En caso sean vip no podrán ser eliminados del vuelo a diferencia de los pasajeros regulares, los cuales si podran ser eliminados.
#### Pasajero Regular
- Verifica que el id coincida con el tipo de vuelo
- Se añade a Checha (pasajero regular)
- Verifica que se haya añadido correctamente
- Verifica que el nombre del pasajero coincida con Checha
- Se intenta eliminar a Checha del vuelo
- Verifica que SI se haya eliminado 
```Java
@Nested
    @DisplayName("Cuando tenemos un pasajero regular")
    class RegularPassenger {

        @Test
        @DisplayName("Luego puede agregarlo y eliminarlo de un vuelo economico")

        public void testEconomyFlightRegularPassenger() {

            assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                () -> assertEquals("1", economyFlight.getId()), 
                () -> assertEquals(true, economyFlight.addPassenger(checha)), 
                () -> assertEquals(1, economyFlight.getPassengersList().size()), 
                () -> assertEquals("Checha", economyFlight.getPassengersList().get(0).getName()), 
                () -> assertEquals(true, economyFlight.removePassenger(checha)), 
                () -> assertEquals(0, economyFlight.getPassengersList().size()) 
            );

        }
    }
```
#### Pasajero Vip
- Verifica que el id coincida con el tipo de vuelo
- Se añade a Lore (pasajero vip)
- Verifica que se haya añadido correctamente
- Verifica que el nombre del pasajero coincida con Lore
- Se intenta eliminar a Lore del vuelo
- Verifica que NO se haya eliminado 
```Java
@Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo economico")

            public void testEconomyFlightVipPassenger() {

                assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                    () -> assertEquals("1", economyFlight.getId()), 
                    () -> assertEquals(true, economyFlight.addPassenger(lore)),
                    () -> assertEquals(1, economyFlight.getPassengersList().size()),
                    () -> assertEquals("Lore", economyFlight.getPassengersList().get(0).getName()),
                    () -> assertEquals(false, economyFlight.removePassenger(lore)), 
                    () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

            }
        }
```
## ```BusinessFlightTest ```
Este es el caso en el que se de un vuelo económico. Definimos nuestro entorno para poder realizar las pruebas

```Java
private Flight businessFlight;
private Passenger checha;
private Passenger lore;

@BeforeEach        
void setUp() {

    businessFlight = new Flight("2","Negocios"); // Tipo de vuelo a utilizar en la prueba
    checha = new Passenger("Checha", false); // Checha es un pasajero regular
    lore = new Passenger("Lore", true); // Lore es un pasajero vip

}
```

### Resultado de las pruebas con cobertura obtenida

### Conclusiones