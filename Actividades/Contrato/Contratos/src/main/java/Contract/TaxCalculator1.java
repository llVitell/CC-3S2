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
