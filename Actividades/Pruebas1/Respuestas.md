## Ejercicio 1

Aquí hay un método con errores:

```Java
/**
 * @param bits un arreglo de 32 valores true/false
 * @retorna el Boleano AND de todos los valores en el arreglo
 */
boolean andAll(boolean[] bits) {
  boolean result = bits[0];
  for (int i = 1; i < 31; i++) {
    result = result && bits[i];
  }
  return result;
}

``` 
Abejita, quien escribió este método y cree que debería funcionar, lo prueba en un par de casos de prueba elegidos al azar que se muestran a continuación. ¿Cuál es el resultado de cada caso de prueba? 

- `andAll([true, true, true, ..., true, true]) // 32 valores true` 
- `andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true ` 
- Jessica dice que todo está OK. Pero desafortunadamente su código tiene un error off-by-one . ¿Qué expresión tiene el error? 
- ¿Cuál podría ser el número de casos de prueba requeridos para probar esta función exhaustivamente?

**Respuestas**

- El resultado es `true`
- El resultado es `false`
- El error off-by-one es que el ciclo for debe terminar cuando i sea menor a 31, en lugar de estrictamente menor que 32.
- El número de casos de prueba requeridos para probar esta función exhaustivamente es 2^32.

## Ejercicio 2

En la década de 1990, el vehículo de lanzamiento Ariane 5, diseñado y construido para la Agencia Espacial Europea, se autodestruyó 37 segundos después de su primer lanzamiento. El motivo fue un error del software de control que no se detectó. El software de guía del Ariane 5 se reutilizó del Ariane 4, que era un cohete más lento. Cuando el cálculo de la velocidad se convirtió de un número de coma flotante de 64 bits (el mismo que un número en TypeScript, aunque este software no se escribió en TypeScript) a un número entero con signo de 16 bits, desbordó el número entero pequeño y provocó una excepción. El controlador de excepciones se había deshabilitado por razones de eficiencia, por lo que el software de guía se bloqueó. Sin guía, el cohete también se estrelló. El costo de la falla fue de mil millones de dólares. 

 ¿Qué ideas demuestra esta historia? 

- Incluso el software crítico para la seguridad de alta calidad puede tener errores residuales.
- Probar todas las entradas posibles es la mejor solución a este problema. 
- El software exhibe un comportamiento discontinuo, a diferencia de muchos sistemas diseñados físicamente. 
- La verificación de tipos estáticos podría haber detectado este error.

**Respuestas**

- Aunque el software del Ariane 5 se diseñó con altos estándares de calidad y se probó rigurosamente, aún tenía un error que resultó en la pérdida del cohete.
- Si es la mejor solución, pero no siempre es posible o práctico de realizar.
- El error en el software del Ariane 5 se debió a un problema de desbordamiento que no se presentó en el diseño del Ariane 4. Este tipo de comportamiento discontinuo es difícil de detectar y puede llevar a errores inesperados.
- Es correcto afirmar que la verificación de tipos estáticos pudo haber detectado este error, pero esto no garantiza la ausencia de errores. El error se debió a la reutilización del software del Ariane 4, que no se probó exhaustivamente.

## Ejercicio 3

Un conjunto de pruebas es correcto si: 

- Todos sus casos de prueba fallan cuando se ejecutan en una implementación con errores 
- Algún caso de prueba falla cuando se ejecuta en una implementación con errores
- Todos sus casos de prueba pasan cuando se ejecutan en una implementación legal 
- Algunos casos de prueba pasan cuando se ejecutan en una implementación legal 

**Respuestas**

- Esto quiere decir que el conjunto de pruebas puede detectar errores en la implementación del software.
- Esto quiere decir que si todos los casos de prueba pasan, pero la implementación tiene errores, es posible que no se haya cubierto adecuadamente el conjunto de casos de prueba.
- Esto quiere decir que la implementación funciona correctamente en todos los casos.
- Esto quiere decir que la implementación es adecuada para algunos usos previstos.

## Ejercicio 4

Un conjunto de pruebas vacío no contiene casos de prueba. Suponiendo una especificación no trivial, un conjunto de pruebas vacío es: 

- Correcto 
- Exhaustivo 
- Pequeña

**Respuestas**

- Un conjunto de pruebas vacío no puede ser **exhaustivo** porque no cubre ningún caso. Además, no puede ser **pequeño** ya que no contiene ningún caso. Sin embargo, se puede considerar **correcto** ya que no debería haber errores en la implementación que no se cubran por el conjunto de pruebas vacío.

## Ejercicio 5

Supongamos que deseas dividir el espacio de entrada de esta función de raíz cuadrada:

```Java
/**
 * @param x debe ser no negativo
 * @retorna la raiz cuadrada de x
 */
public static int sqrt(int x)
```

Evalúe la calidad de cada una de las siguientes particiones candidatas. ¿Son los subdominios propuestos separados y completos, formando así una partición? ¿Son correctos, en el sentido de que cada subdominio puede ser cubierto por un caso de prueba legal? Para una buena partición debes marcar las tres alternativas.

```Java
// particion: x < 0; x >= 0
```

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

**Respuestas**

- Los subdominios son disjuntos: Si, ya que un número no puede ser negativo y no negativo al mismo tiempo.
- Los subdominios están completos: Si, ya que cubre todos los casos.
- Los subdominios son correctos: No, ya que no cubre todos los casos, en particular no es posible cubrir el subdominio x < 0 ya que el parametro de entrada debe ser no negativo.

```Java
// particion: x=0, x=1, x=7, x=16
``` 

- Los subdominios son disjuntos: Si, los subdominios son disjuntos. 
- Los subdominios están completos: No, los subdominios no estan completos claramente faltan muchos valores posibles de x.
- Los subdominios son correctos: No, ya que algunos de los subdominios no pueden ser cubiertos por un caso de prueba legal.

## Ejercicio 6

Ahora considera esta especificación:

```Java
/**
 * @param x un entero 
 * @param y un entero, donde x, y no son ambos 0
 * @retorna el GCD de x e y
 */
/
public static int gcd(int x, int y);
```

Evalúa cada una de las siguientes particiones candidatas para gcd.

```Java
// particion: x e y no son  0
``` 

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

**Respuestas**

- Los subdominios son disjuntos: Sí, ya que cada posible combinación de valores para x e y representa un subdominio distinto.
- Los subdominios están completos: Sí, ya que podemos encontrar cualquier posible combinación de valores para x e y que cumpla con la restricción "x, y son distintos de 0".
- Los subdominios son correctos: Sí, ya que este subdominio representa todas las posibles entradas válidas para la función gcd.

```Java
// particion: x es divisible por y; y es divisible por x;
```

- Los subdominios son disjuntos: Si, los subconjuntos de los divisores comunes más grandes de "x" e "y" son disjuntos, ya que cualquier divisor que se comparta entre los dos números debe ser un divisor de "y".
- Los subdominios están completos: No, si "x" es 15 y "y" es 3, entonces el gcd es 3. Cuyos divisores son 1 y 3, faltaría el 2 para que sea completo.
- Los subdominios son correctos: Si, cualquier subconjunto de los divisores comunes de "x" e "y" que incluya todos los factores primos comunes será correcto.


```Java
// particion: x e y son primeros relativos;
```

- Los subdominios son disjuntos: Si, no tienen factores primos comunes excepto 1, entonces los subdominios de su GCD serán disjuntos.
- Los subdominios están completos: No, ya que el único divisor común de "x" e "y" es 1, que es el GCD de "x" e "y".
- Los subdominios son correctos: Si, cualquier subdominio de los divisores comunes de "x" e "y" que contenga únicamente el número 1 como divisor común será considerado correcto.

## Ejercicio 7

Para esta función: 

```Java
/**`
 * @param winsAndLosses una cadena de a lo más 5 de consistiendo de los caracteres 'W' o 'L'
 * @retorna la fraccion de caracteres en winsAndLosses que son 'W'
 */

double winLossRatio(String winsAndLosses);
```
¿Cuáles son los valores límite apropiados para probar esta función?

**Respuestas**

- `winsAndLosses = ""` (cadena vacía)
- `winsAndLosses = "W" o "L"` (cadena de un solo carácter)
- `winsAndLosses = "WWWWWW", "LLLLL", ...` (cadena de 5 caracteres)

## Ejercicio 8

Considera la partición de `a` anterior:

```Java
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición en realidad combina varios intereses distintos: el signo de `a`, la magnitud de `a` (pequeño o grande) y los valores límite 0 y 1. Podemos pensar en estos intereses como particiones independientes.
De entre las opciones a continuación, elija un subconjunto que serían particiones legales y que juntas captarían los mismos intereses.

- particion en a: `0, 1`
- particion en a: `0`
- particion en a: `1`
- particion en a: `0`, positivo, negativo
- particion en a: positivo, negativo
- particion en a: `1, !=1`
- particion en a: (donde "pequeño" encaja en long y "grande" no)

**Respuestas**

Una particion en a: a = 0, a = 1, a > 1, a < 0, a > Long.MAX_VALUE, a < Long.MIN_VALUE, 0 < a < 1, a != 0, a != 1, capturaría los mismos intereses

## Ejercicio 9

Considera nuevamente esta partición `a` en un desde arriba:

```Java
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//     a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición tiene 6 subdominios, por lo que pueden cubrirla 6 valores diferentes de `a`, uno elegido para cada subdominio. 

Supongamos que usamos estas tres particiones de a en su lugar:

```Java
// particion en a: 0, positivo, negativo
// particion en a: 1, !=1
// particion on a: donde "pequeño" encaja en long y "grande" no)
```

Si solo queremos cubrir cada subdominio de las tres particiones, ¿cuántos valores diferentes de a necesitaríamos?.

**Respuestas**

Evaluamos para cada caso

- a = 0, un valor positivo y un valor negativo distintos, por lo tanto necesitamos un minimo de 3 valores diferentes de a (subdominio 1)
- a = 1 y un valor distinto de 1, por lo tanto necesitamos 2 valores diferentes de a (subdominio 2)
- a = un valor pequeño positivo, un valor pequeño negativo, un valor grande positivo y un valor grande negativo, por lo tanto necesitamos 4 valores diferentes de a (subdominio 3)

En total necesitariamos 3 + 2 + 4 = 9 valores diferentes de a para cubrir cada subdominio de las tres particiones.

## Ejercicio 10

A veces es conveniente pensar y escribir una partición de espacio de entrada en términos de la salida de la función, porque las variaciones en el comportamiento pueden ser más visibles allí. Por ejemplo: 

```Java
// particion en a.multiply(b): 0, positivo, negativo

```
es la abreviatura de la partición de tres subdominios que consta de:

```Java
 { (a,b) | a.multiply(b) = 0 }
 { (a,b) | a.multiply(b) > 0 }
 { (a,b) | a.multiply(b) < 0 }

```
Con este enfoque, ¿cuántos casos de prueba se necesitan para cubrir las siguientes tres particiones? 

```Java
// particion en a: 0, positivo, negativo
// particion en b: 0, positive, negativo
// particion en a.multiply(b): 0, positivo, negativo
````

**Respuestas**

Para cada partición de a, debemos considerar todas las particiones posibles de b, y para cada una de esas combinaciones debemos considerar la partición correspondiente de a.multiply(b). Por lo tanto, necesitamos cubrir todas las combinaciones posibles de las particiones para a, b y a.multiply(b), por lo tanto se necesitarían 3x3x3 = 27 casos de prueba.