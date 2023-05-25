## Curso de desarrollo de software

**Indicaciones**

Inicia un repositorio llamado CC-3S2 y dentro una carpeta llamada Actividades. Dentro de esta carpeta abre una carpeta llamada Pruebas1 y coloca todas tus respuestas.

Esta actividad es grupal.


### Pruebas en sotware - parte1

Una prueba es un ejemplo de un proceso más general llamado validación. El propósito de la validación es descubrir problemas en un programa y, por lo tanto, aumentar tu confianza en la corrección del programa.  
Aquí hay algunos enfoques que desafortunadamente no funcionan bien en el mundo del software. 

- Las pruebas exhaustivas son inviables. 
- Es menos probable que las pruebas aleatorias 
- Las pruebas aleatorias o estadísticas no funcionan bien para el software.

**Ejercicio 1**

Aquí hay un método con errores:

``` 
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

**Ejercicio 2** 

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


### Pruebas sistemáticas 

En lugar de pruebas exhaustivas, o aleatorias, queremos probar de manera sistemática. 
Las pruebas sistemáticas significan que estamos eligiendo casos de prueba de una manera basada en principios, con el objetivo de diseñar un conjunto de pruebas con tres propiedades deseables: 

- Correcto
- Exhaustivo
- Pequeño

**Ejercicio 3**

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

**Ejercicio 4**

Un conjunto de pruebas vacío no contiene casos de prueba. Suponiendo una especificación no trivial, un conjunto de pruebas vacío es: 

- Correcto 
- Exhaustivo 
- Pequeña

**Respuestas**

- Un conjunto de pruebas vacío no puede ser **exhaustivo** porque no cubre ningún caso. Además, no puede ser **pequeño** ya que no contiene ningún caso. Sin embargo, se puede considerar **correcto** ya que no debería haber errores en la implementación que no se cubran por el conjunto de pruebas vacío.


### Elección de casos de prueba mediante partición

Dividimos el espacio de entrada en **subdominios**, cada uno de los cuales consta de un conjunto de entradas. En conjunto, los **subdominios** forman una **partición**: una colección de conjuntos disjuntos que cubre completamente el espacio de entrada, de modo que cada la entrada se encuentra exactamente en un subdominio. Luego elegimos un caso de prueba de cada subdominio, y ese es nuestro conjunto de pruebas. 


**Ejemplo: abs()**

``` 
/**
 * ...
 * @param a  el argumento cuyo valor absoluto es determinado 
 * @returna el valor absoluto del argumento.
 */
public static int abs(int a)
``` 
Matemáticamente, este método es una función del siguiente tipo: 

```
abs : int -->  int 

``` 
La función tiene un espacio de entrada unidimensional, que consta de todos los valores posibles de `a`. Podemos dividir el espacio de entrada en estos dos subdominios: `{a | a ≥ 0 }` y `{ a | a < 0 }`. 

```
// particion: a >= 0; a < 0

``` 
Para elegir casos de prueba elegimos un valor arbitrario `a` de cada subdominio de la partición, por ejemplo: 

- a = 17 para cubrir el subdominio a ≥ 0 
- a = -3 para cubrir el subdominio a < 0 

**Ejemplo: máx()** 

Ahora veamos otro ejemplo de la biblioteca de Java: la función integer max(), que también se encuentra en Math. 

```
/**
 * ...
 * @param a  un argumento
 * @param b  otro argumento
 * @retorna el mayor de a y b.
 */

public static int max(int a, int b)

```
Matemáticamente, este método es una función de dos argumentos: 

```
máx : int × int --> int 

```
La forma compacta, la partición se ve así:

```
// particion: a < b; a > b; a = b

```
El conjunto de pruebas podría ser: 


- (a,b) = (1, 2) para cubrir a < b 
- (a,b) = (10, -8) para cubrir a > b
- (a,b) = (9, 9) para cubrir a = b

**Ejercicios 5**

Supongamos que deseas dividir el espacio de entrada de esta función de raíz cuadrada:

```
/**
 * @param x debe ser no negativo
 * @retorna la raiz cuadrada de x
 */
public static int sqrt(int x)
```

Evalúe la calidad de cada una de las siguientes particiones candidatas. ¿Son los subdominios propuestos separados y completos, formando así una partición? ¿Son correctos, en el sentido de que cada subdominio puede ser cubierto por un caso de prueba legal? Para una buena partición debes marcar las tres alternativas.

```
// particion: x < 0; x >= 0
```

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

**Respuestas**

- Los subdominios son disjuntos: Si, ya que un número no puede ser negativo y no negativo al mismo tiempo.
- Los subdominios están completos: Si, ya que cubre todos los casos.
- Los subdominios son correctos: No, ya que no cubre todos los casos, en particular no es posible cubrir el subdominio x < 0 ya que el parametro de entrada debe ser no negativo.

```
// particion: x es un cuadrado perfecto; x es > 0 pero no es un cuadrado perfecto

```

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

**Respuestas**
- Los subdominios son disjuntos: Sí, ya que no hay ningún número que sea al mismo tiempo un cuadrado perfecto y un no cuadrado perfecto
- Los subdominios están completos: Sí, ya que cubre todos los casos.
- Los subdominios son correctos: Sí, los subdominios son correctos ya que cualquier número entero positivo es o bien un cuadrado perfecto o no lo es.

```
// particion: x=0, x=1, x=7, x=16
``` 

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

**Respuestas**
- Los subdominios son disjuntos: Si, los subdominios son disjuntos. 
- Los subdominios están completos: No, los subdominios no estan completos claramente faltan muchos valores posibles de x.
- Los subdominios son correctos: No, ya que algunos de los subdominios no pueden ser cubiertos por un caso de prueba legal.


**Ejercicio 6**

Ahora considera esta especificación:

```
/**
 * @param x un entero 
 * @param y un entero, donde x, y no son ambos 0
 * @retorna el GCD de x e y
 */
/
public static int gcd(int x, int y);
```

Evalúa cada una de las siguientes particiones candidatas para gcd.

```
// particion: x e y no son  0
``` 

- Los subdominios son disjuntos 
- Los subdominios están completos 
- Los subdominios son correctos

**Respuestas**

- Los subdominios son disjuntos: Sí, ya que cada posible combinación de valores para x e y representa un subdominio distinto.
- Los subdominios están completos: Sí, ya que podemos encontrar cualquier posible combinación de valores para x e y que cumpla con la restricción "x, y son distintos de 0".
- Los subdominios son correctos: Sí, ya que este subdominio representa todas las posibles entradas válidas para la función gcd.

```
// particion: x es divisible por y; y es divisible por x;
```

- Los subdominios son disjuntos: Si, los subconjuntos de los divisores comunes más grandes de "x" e "y" son disjuntos, ya que cualquier divisor que se comparta entre los dos números debe ser un divisor de "y".
- Los subdominios están completos: No, si "x" es 15 y "y" es 3, entonces el gcd es 3. Cuyos divisores son 1 y 3, faltaría el 2 para que sea completo.
- Los subdominios son correctos: Si, cualquier subconjunto de los divisores comunes de "x" e "y" que incluya todos los factores primos comunes será correcto.


```
// particion: x e y son primeros relativos;
```

- Los subdominios son disjuntos: Si, no tienen factores primos comunes excepto 1, entonces los subdominios de su GCD serán disjuntos.
- Los subdominios están completos: No, ya que el único divisor común de "x" e "y" es 1, que es el GCD de "x" e "y".
- Los subdominios son correctos: Si, cualquier subdominio de los divisores comunes de "x" e "y" que contenga únicamente el número 1 como divisor común será considerado correcto.


### Incluir límites en la partición 

Los errores a menudo ocurren en los límites entre los subdominios. Algunos ejemplos: 

- `0` es un límite entre números positivos y números negativos 
- Los valores máximo y mínimo de tipos numéricos, como `int` o `double` 
- El vacío para tipos de colección, como la cadena vacía, la lista vacía o el conjunto vacío el primer 
- El último elemento de una secuencia, como una cadena o lista

La función `abs()` en Java se comporta de una manera muy inesperada en uno de estos límites, que la especificación describe de la siguiente manera:

```
/**
 *
 * Ten en cuenta que si el argumento es igual al valor de Integer.MIN_VALUE, 
 * el valor int representable más negativo, el resultado es el mismo valor
 * negativo.
 * ...
 */

``` 

Incorporamos límites como subdominios de un solo elemento en la partición, de modo que el conjunto de pruebas incluya necesariamente el valor del límite como un caso de prueba. Para abs, agregaremos subdominios para cada uno de los límites relevantes: 

- `a = 0`, porque `abs` se comporta de manera diferente en números positivos y negativos
- `a = Integer.MIN_VALUE`, el valor int más negativo posible, porque la especificación indica un comportamiento inusual - 
- `a = Integer.MAX_VALUE`, el mayor valor int positivo, para simetría y completitud

Los dos subdominios originales se reducirían para excluir los valores límite: `{ a | 0 < a < Integer.MAX_VALUE }` y `{ a | Integer.MIN_VALUE < a < 0 }`. 

Esta es ahora una partición del espacio de entrada de `abs`: los cinco subdominios están separados y cubren completamente el espacio. 

```
// particion:
//     a = Integer.MIN_VALUE
//     Integer.MIN_VALUE < a < 0
//     a = 0
//     0 < a < Integer.MAX_VALUE
//     a = Integer.MAX_VALUE

```
El conjunto de pruebas podría ser: 

```
a = 0 
a = Integer.MIN_VALUE 
a = Integer.MAX_VALUE 
a = 17 para cubrir el subdominio 0 < a < Integer.MAX_VALUE 
a = -3 para cubrir el subdominio Integer.MIN_VALUE < a < 0 
```

**Ejercicio 7**

Para esta función: 

```
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


### Uso de varias particiones 

Un enfoque es tratar las características de cada entrada `a` y `b` como dos particiones separadas del espacio de entrada. Una partición solo considera el valor de `a`: 

`(a,b)` tal que `a = 0, 1`, pequeño positivo, pequeño negativo, grande positivo, grande negativo 

Y la otra partición solo considera el valor de `b`:

`(a,b)` tal que `b = 0, 1`, pequeño positivo, pequeño negativo, grande positivo, grande negativo 


Cada par de entradas `(a,b)` pertenece exactamente a un subdominio de cada partición. Podríamos escribir las dos particiones de forma compacta de la siguiente manera:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
//           
// particion en b:
//      b = 0
//      b = 1
//      b es un entero pequeño > 1
//      b es un entero pequeño < 0
//      b es un entero grande positivo
//      b es un entero grande negativo

```

Particionar `a` y `b` de forma independiente aumenta el riesgo de que ya no esté probando la interacción entre ellos.

```
// particion de signos de a y b:
//    a y b son ambos positivos
//    a y b son ambos negativos
//    a positivo y b negativo
//    a negativo y b positivo
//    uno o ambos son 0

```

Un conjunto de pruebas con 6 casos de prueba cuidadosamente elegidos puede cubrir los subdominios de las tres particiones. 


**Ejercicio 8**

Considera la partición de `a` anterior:

```
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

**Ejercicio 9**

Considera nuevamente esta partición `a` en un desde arriba:

```
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

```
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

**Ejercicio 10**

A veces es conveniente pensar y escribir una partición de espacio de entrada en términos de la salida de la función, porque las variaciones en el comportamiento pueden ser más visibles allí. Por ejemplo: 

```
// particion en a.multiply(b): 0, positivo, negativo

```
es la abreviatura de la partición de tres subdominios que consta de:

```
 { (a,b) | a.multiply(b) = 0 }
 { (a,b) | a.multiply(b) > 0 }
 { (a,b) | a.multiply(b) < 0 }

```
Con este enfoque, ¿cuántos casos de prueba se necesitan para cubrir las siguientes tres particiones? 

```
// particion en a: 0, positivo, negativo
// particion en b: 0, positive, negativo
// particion en a.multiply(b): 0, positivo, negativo
````

**Respuestas**

Para cada partición de a, debemos considerar todas las particiones posibles de b, y para cada una de esas combinaciones debemos considerar la partición correspondiente de a.multiply(b). Por lo tanto, necesitamos cubrir todas las combinaciones posibles de las particiones para a, b y a.multiply(b), por lo tanto se necesitarían 3x3x3 = 27 casos de prueba.

### Cobertura

Una forma de juzgar un conjunto de pruebas es preguntar cuán minuciosamente ejercita el programa. Esta noción se llama **cobertura**. Aquí hay tres tipos comunes de cobertura: 

* Cobertura de declaraciones: ¿cada declaración se ejecuta en algún caso de prueba?
* Cobertura de rama: para cada instrucción if o while en el programa, ¿se toman tanto la dirección verdadera como la falsa en algún caso de prueba? 
* Cobertura de ruta: ¿todas las posibles combinaciones de ramas, todas las rutas a través del programa, son tomadas por algún caso de prueba? 

 En la industria, la cobertura del 100% de las declaraciones es un objetivo común, pero incluso eso rara vez se logra debido al código defensivo 
 inalcanzable (como las aserciones de "nunca debería llegar aquí"). 
