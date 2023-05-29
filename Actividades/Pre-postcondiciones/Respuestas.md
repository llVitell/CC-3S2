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
- Precondición: list.length>0
- Postcondición: max>= list[i] for each i 
  (0 ≤ i< list.length), and there exists j 
  (0 ≤ j< list.length) such that max=list[j]

No cumple la post condición ya que no recorre todo el array, debería cambiarse a i < list.length
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
- Precondición: 
- Postcondición: 
```Java

```

# Pregunta 5
- Precondición: 
- Postcondición:
```Java
```
