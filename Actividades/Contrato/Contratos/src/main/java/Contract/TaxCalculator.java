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
