# Pregunta 1
Considera el siguiente código de cliente, que primero obtiene tres ángulos y llama a reportTriangle(a,b,c):
```Java
double a = ...;
double b = ...;
double c = ...;
TriangleType result = reportTriangle(a,b,c);
``` 
¿Cuáles son los resultados para (90, 45, 45), (120, 40, 20) y (50, 60, 70)= , ¿qué sucede con (90, -45, 135) ?. ¿Quién es el responsable de este fallo, el proveedor o el cliente?. Corrige este error.

## Respuesta

- (90, 45, 45): Resulta un triángulo recto
- (120, 40, 20): Resulta un triángulo obtuso
- (50, 70, 60): Resulta un triángulo agudo

Lo que pasa con (90, -45, 135) es que el ángulo -45 no cumple la precondición por ende el responsable de este fallo es el cliente. La correción sería la siguiente: (90, 45, 45)

# Pregunta 2
La violación de una precondición o postcondición en tiempo de ejecución indica la existencia de un error.
- La regla de violación de la precondición establece que ```una violación de la precondición es la manifestación de un error en el cliente```, independientemente de si la postcondición se cumple o no.
- La regla de violación de la postcondición establece que ```una violación de la postcondiciónes es la manifestación de un error en el proveedor porque el proveedor``` no cumplió con su contrato.

En el ejemplo anterior indica una violación de precondición.
## Respuesta
Al escribir un ángulo no positivo o escribir 3 angulos los cuales no sumen 180 se estaría violando la precondición. Ejemplo: (60, 90, 50) (la suma es mayor que 180)

# Pregunta 3
Considera ```sqrt(double x)```  que devuelve la raíz cuadrada de un valor doble no negativo.

La poscondición establece que la raíz cuadrada de x al cuadrado es aproximadamente igual a x.
Dos números de punto flotante son aproximadamente iguales si el valor absoluto de su diferencia es lo suficientemente pequeño.
```Java
Precondición: x >= 0 
Postcondición: abs(sqrt(x)* sqrt(x) - x) < epsilon
double sqrt (double x) 
```
El siguiente código de cliente se rompe cuando x es -1. Es defectuoso porque viola la precondición.
```Java
double x = ... ; 
double y = sqrt(x); 
assert abs(y*y -x) < épsilon 
```
El siguiente método ```isVowel``` verifica si una letra determinada es una vocal. "Y" a veces se considera una vocal cuando aparece en palabras como ```cry```, ```fly``` y ```sky```.
```Java
Precondition: letter ∈ {'a'-'z', 'A'-'Z'}   
Postcond: true if letter ∈ {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}; otherwise, false
boolean isVowel(char letter) { 
      String vowels = "aeiouy&@";
      char ch = Character.toLowerCase(letter);
returns vowels.indexOf(ch) >= 0;  
}
```
Como el parámetro ```letter``` es del tipo char, la precondición asume que es una letra mayúscula o minúscula. 
El siguiente código de cliente primero obtiene un carácter, no necesariamente una letra, y luego llama a ```isVowel(letter)```:
```Java
char letter = ...;
boolean result = isVowel(letter);
```
Si el carácter obtenido es 'A', es decir, ```letter = 'A'```, ```isVowel('A')``` devuelve ```true``` entonces ```result = true```.

Si el carácter es 'Z', entonces ```result = false```.

Para cada una de estas llamadas, se cumple la precondición.

¿Qué sucede cuando ```letter = '@'``` ?.

## Respuesta

# Pregunta 4
Considera ```int [ ] genRandomIntegers(int count)``` que devuelve una lista de enteros aleatorios. 
Su precondición y postcondición son ```count >0``` y ```list.length = count```, respectivamente (```list``` denota el valor devuelto). 
El código del cliente es el siguiente:
```Java
int count =2; // calculado
int[ ] list = var.genRandomIntegers(count);
for (int i = 0; i < count; i ++){
    process(list [i])
}
```
¿Qué sucede si modificamos ```genRandomIntegers```. mantenemos la precondición pero cambiamos la postcondición a ```list.length=count-1```?.

## Respuesta

# Pregunta 5

Considera el siguiente método ```getCell()``` en el programa TicTacToe.
```Java
public Cell getCell(int row, int column){
    return grid [row][column];
}
```
El código se crea para pasar la prueba del primer criterio de aceptación (tablero vacío AC 1.1).

La precondición y postcondición se dan a continuación:
```Java
Precondición: 0 <= row < 3 and 0 <= column < 3
Postcondición: return 0
```
Después de pasar las pruebas para AC 1.2 y AC 1.3, el código se cambia a lo siguiente:
```Java
public int getCell(int row, int column){
    if(row >= 0 && row < 3 && column >=0 && column < 3){
         return grid[row][column];
	} else{
                  return -1;
     }
}
```
¿Cómo cambia la precondición y la postcondición en el ejemplo anterior?.

## Respuesta


