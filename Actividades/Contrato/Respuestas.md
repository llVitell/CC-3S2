# Pregunta 1
Escribe el Javadoc del método ```calculateTax``` describiendo su contrato, en el código anterior. Revisa el archivo ```TaxCalculator.java```.
## Respuesta
```Java
package Contract;

public class TaxCalculator {
     /**
     *@param value
     *Precondición: El valor ingresado debe ser no negativo
     *Postcondición: El impuesto a regresar no puede ser negativo
     */
    public double calculateTax(double value) {
        if(value < 0) {
            throw new RuntimeException("El valor tiene que ser positivo");
        }

        double taxValue = 0;

        if(taxValue < 0) {
            throw new RuntimeException("El impuesto no puede ser negativo");
        }
        return taxValue;
    }
}
```

# Pregunta 2
Escribe una versión de ```TaxCalculator``` usando asserts para ello completa el archivo ```TaxCalculator1.java```.
## Respuesta
```Java
package Contract;

public class TaxCalculator1 {
    // TaxCalculator con pre- y post-conditions implementado via asserts
    /**
     *@param value
     *Precondición: El valor ingresado debe ser no negativo
     *Postcondición: El impuesto a regresar no puede ser negativo
     */
    public double calculateTax(double value) {
        assert value >= 0 : "Valor no puede ser negativo";

        double taxValue = 0;

        assert taxValue >= 0 : "El impuesto no puede ser negativo";

        return taxValue;
    }
}
```

# Pregunta 3
 ¿Puedes aplicar el mismo razonamiento a las postcondiciones? , ¿Como relacionas el siguiente listado que devuelve un código de error en lugar de una excepción?
```Java
public double calculateTax(double value) {
// verificación de la precondición
     if (value < 0) {
               return 0;
	}

  //...
}
```
## Respuesta
Sí, se puede aplicar un razonamiento similar a las postcondiciones. Al debilitar las postcondiciones, se permite que el método devuelva un código de error en lugar de lanzar una excepción lo cual sería lo ideal.

# Pregunta 4
```Java
public class Basket {
  private BigDecimal totalValue = BigDecimal.ZERO;
      private Map<Product, Integer> basket = new HashMap<>();
 
  public void add(Product product, int qtyToAdd) {

  }
public void remove(Product product) {

   }
}
```
Escribe para el método add() sus pre/postcondiciones.
## Respuesta
- Precondiciones: ```product != null && qtyToAdd > 0```
- Postcondiciones: ```totalValue``` actualizado con el valor de ```qtyToAdd``` algo como ```totalValue = totalValue + qtyToAdd```


# Pregunta 5
Modela otra postcondiciones aquí, como el nuevo valor total debe ser mayor que el valor total anterior. Usa la clase ```BigDecimal``` en lugar de un ```double```. ```BigDecimals``` se recomienda siempre que desees evitar problemas de redondeo que pueden ocurrir cuando usas ```doubles```.

## Respuesta
- Después de llamar al método ```add()```, el nuevo valor total, ```totalValue```, debe ser mayor que el valor total anterior.
- El nuevo valor total debe ser igual al valor total anterior más el valor del producto multiplicado por la cantidad agregada.
```Java
  public void add(Product product, int qtyToAdd) {
	// Precondiciones
	assert product != null : "El producto no existe";
	assert qtyToAdd > 0 : "La cantidad a agregar debe ser mayor que 0.";

	// Lógica del método
	if (basket.containsKey(product) {
	    int currentQty = basket.get(product);
	    basket.put(product, currentQty + qtyToAdd);
	} else {
	    basket.put(product, qtyToAdd);
	}
	
	totalValue += qtyToAdd;
	
	// Postcondiciones
	BigDecimal oldTotalValue = totalValue;
	assert basket.containsKey(product) : "...";
	assert totalValue.compareTo(oldTotalValue) == 1 : "...";
	assert totalValue.compareTo(BigDecimal.ZERO) >= 0 :"..."
}
	
```
# Pregunta 6
Escribe las pre/post condiciones del método ```remove()```.
## Respuesta
- Precondiciones:```product != null && basket.containsKey(product)``` 
- Postcondiciones: El valor total no puede ser negativo


# Pregunta 7
Explica y completa el siguiente listado de invariantes de la clase Basket:
```Java
public class Basket {
   private BigDecimal totalValue = BigDecimal.ZERO;
   private Map<Product, Integer> basket = new HashMap<>();
   

  public void add(Product product, int qtyToAdd) {
	assert product != null : "...";
	assert qtyToAdd > 0 : "...";
	  
	BigDecimal oldTotalValue = totalValue;
	
	assert basket.containsKey(product) : "...";
	assert totalValue.compareTo(oldTotalValue) == 1 : "...";
	assert totalValue.compareTo(BigDecimal.ZERO) >= 0 :"..."
     }

     public void remove(Product product) {
	assert product != null : "...";
	assert basket.containsKey(product) : "...";
	
	assert !basket.containsKey(product) : "...";
	assert totalValue.compareTo(BigDecimal.ZERO) >= 0 :"El valor total no puede ser negativo ."
     }
}
```
## Respuesta
```Java
public class Basket {
   private BigDecimal totalValue = BigDecimal.ZERO;
   private Map<Product, Integer> basket = new HashMap<>();
   

  public void add(Product product, int qtyToAdd) {
	assert product != null : "...";
	assert qtyToAdd > 0 : "...";
	  
	BigDecimal oldTotalValue = totalValue;
	
	assert basket.containsKey(product) : "...";
	assert totalValue.compareTo(oldTotalValue) == 1 : "...";
	assert invariant() : "...";
     }

     public void remove(Product product) {
	assert product != null : "...";
	assert basket.containsKey(product) : "...";
	     
	assert !basket.containsKey(product) : "...";
	assert invariant() : "...";
     }
	
     private boolean invariant() {
	return totalValue.compareTo(BigDecimal.ZERO) >= 0;
     }
}
```
# Pregunta 8
¿Qué función tiene el método invariant() en el siguiente listado?
```Java
 public void add(Product product, int qtyToAdd) {
	// ... metodos ...
	assert invariant() : "...";
 }
 public void remove(Product product) {
	// ... metosos ...
	assert invariant() : "...";
}
private boolean invariant() {
        return totalValue.compareTo(BigDecimal.ZERO) >= 0;
}

```
## Respuesta
Representar las condiciones que se supone que siempre deben ser verdaderas en diferentes puntos del código.



