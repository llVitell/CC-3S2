package Contract;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Basket {
    private BigDecimal totalValue = BigDecimal.ZERO;
    private Map<Product, Integer> basket = new HashMap< >();

    public void add(Product product, int qtyToAdd) {
    	assert product != null : "...";
    	assert qtyToAdd > 0 : "...";
    	  
    	BigDecimal oldTotalValue = totalValue;
        if (basket.containsKey(product) {
    	    int currentQty = basket.get(product);
    	    basket.put(product, currentQty + qtyToAdd);
	    } else {
	        basket.put(product, qtyToAdd);
	    }
	
	    totalValue += qtyToAdd;
    	
    	assert basket.containsKey(product) : "...";
    	assert totalValue.compareTo(oldTotalValue) == 1 : "...";
    	assert invariant() : "...";
     }

     public void remove(Product product) {
    	assert product != null : "...";
    	assert basket.containsKey(product) : "...";

        basket.remove(product);
        
    	assert !basket.containsKey(product) : "...";
    	assert invariant() : "...";
     }
    private boolean invariant() {
        return totalValue.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public int quantityOf(Product product) {
        assert basket.containsKey(product);
        return basket.get(product);
    }

    public Set<Product> products() {
        return Collections.unmodifiableSet(basket.keySet());
    }
    @Override
    public String toString() {
        return "BasketCase{" +
                "totalValue=" + totalValue +
                ", basket=" + basket +
                '}';
    }
}
