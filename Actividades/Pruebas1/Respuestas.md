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