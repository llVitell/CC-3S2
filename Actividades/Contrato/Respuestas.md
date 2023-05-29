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


