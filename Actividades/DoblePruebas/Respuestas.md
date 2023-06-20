# Pregunta 1
```Java
import java.util.random.RandomGenerator;
public class LanzamientoDados{
    private final int NUMERO_DE_LADOS = 6;
	private final RandomGenerator rnd =
                   	RandomGenerator.getDefault();
	public String asText() {
    	int lanzado = rnd.nextInt(NUMERO_DE_LADOS) + 1;
    	return String.format("Tu lanzamiento a %d", lanzado);
	}
}
```
¿Cómo escribiríamos una prueba para esto? Específicamente, ¿cómo escribiríamos la aseveración?
## Respuesta

# Pregunta 2
```Java
public class BatteryMonitor {
   public void warnWhenBatteryPowerLow() {
       if (DeviceApi.getBatteryPercentage() < 10) {
        	System.out.println("Advertencia - Bateria Baja");
    	   }
	}
}
```
Hay un problema al escribir esta prueba: ¿cómo podemos obligar al método ```getBatteryPercentage()``` a que devuelva un número inferior a 10 
como parte de el paso Arrange? ¿Descargaríamos la batería de alguna manera? ¿Cómo haríamos esto? .

## Respuesta

# Pregunta 3
```Java
public class MockMailServer implements MailServer {
     boolean fueLlamado;
     String actualRecipiente;
     String actualTema;
    String actualTexto;
    @Override
    public void sendEmail(String recipiente, String tema,
                      	String texto) {
        fueLlamado= true;
        actualRecipiente = recipiente;
        actualTema = tema;
        actualTexto = texto;
	}
}
```
El código de prueba puede usar los campos dados anteriormente para formar la aserción.
## Respuesta

# Pregunta 4
Los dobles de prueba solo se pueden usar donde podemos inyectarlos. Esto no siempre es posible. 
Si el código que queremos probar crea una clase concreta usando la palabra clave new entonces no podemos reemplazarlo con un doble:
```Java
public class UserGreeting {
     private final UserProfiles profiles
    	= new UserProfilesPostgres();
	
public String formatGreeting(UserId id) {
    	return String.format("Hola y bienvenido %s",
            	profiles.fetchNicknameFor(id));
	}
}
```
Hay una forma directa de inyectar un doble de prueba con este diseño?.
## Respuesta

