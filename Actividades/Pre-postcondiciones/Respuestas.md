# Pregunta 1
- Precondición: none (tautología, siempre aplicable)
- Postcondición: return value is CELL.EMPTY, CELL.CROSS or CELL.NAUGHT
```Java
if row >= 0 && row < TOTAL.ROWS && column >= 0 && column < TOTAL_COLUMN
  otherwise null
```

# Pregunta 2
- Precondición: none
- Postcondición: return CELL.EMPTY, CELL.CROSS OR CELL.NAUGHT
```Java
if 0 <= row < TOTAL.ROWS and 0 <= column < TOTAL_COLUMNS
  otherwise throw new OutOfBoardException
```

# Pregunta 3
- Precondición: ```list.length>0```
- Postcondición: ```max>= list[i] for each i ```
  ```0 ≤ i< list.length```, and there exists j 
  ```0 ≤ j< list.length``` such that ```max=list[j]```

No cumple la post condición ya que no recorre todo el array, debería cambiarse a ```i < list.length```
```Java
int max(int[] list){
	int result=list[0];
	for (int i=0; i<list.length; i++){
	     if (result<list[i])
		result=list[i];
	}
	return result;
}
```

# Pregunta 4
- Precondición: none
- Postcondición: ```q.length = p.length``` y ```q[i] <= q[i +1]``` para cualquier i, ``` 0 <= i < q.length -1``` y para cualquier j ```0 <= j < p.length```, existe k ```0 <= k < q.length``` tal que ```p[j] = p[k]``` y para cualquier j ```0 <= j < q.length``` existe k ```0 <= k < p.length``` tal que ```q[j] = p[k]```
El siguiente ejemplo demuestra que la implementación es defectuosa
```Java
p = [1, 2, 3, 4]
q = [1, 3, 2, 4]
```
Aquí, ```p.length = q.length = 4```. Sin embargo, la condición ```q[i] <= q[i+1]``` para cualquier i,``` 0 <= i < q.length - 1``` no se cumple. Se observa que ```q[1] = 3``` es mayor que ```q[2] = 2```, lo cual viola la condición.

# Pregunta 5
Explica el código y ¿Qué se puede mejorar en el código dado?
```Java
public boolean purchase(String drink){
        if (drink.equalsIgnoreCase(COFFEE)){
            if (coffee.getCount()>0&&deposit>=coffee.getPrice()){
                coffee.sell();
                calculateChange(coffee.getPrice());
                return true;
            }
        } 
   ...
}
```


La función ```purchase()``` verifica si la bebida ingresada es igual a "COFFEE" (café). Si es así, comprueba si hay existencias de café ```coffee.getCount() > 0``` y si el depósito realizado por el cliente es mayor o igual al precio del café ```deposit >= coffee.getPrice()```. Si ambas condiciones se cumplen, se realiza la venta de una taza de café ```coffee.sell()```, se calcula el cambio y se devuelve true.

El código se puede mejorar de las siguientes maneras:
- Añadir verificaciones para otras bebidas ya que solo se analiza el caso de COFFEE y no se retorna nada en caso sea otra bebida.
- Especificar la cantidad de bebidas disponbiles, si bien se hace ```coffee.getCount() > 0``` no se podría asegurar la disponibilidad de bebidas requeridas. Ejemplo: Quiero 5 bebidas y el código verifica que haya más que 0 pero que pasa si solo hay 2 bebidas, ahí se estaría omitiendo un error.
- No se manejan los casos en que el pago sea menor al precio del café, simplemente terminaría la función sin retornar nada.

