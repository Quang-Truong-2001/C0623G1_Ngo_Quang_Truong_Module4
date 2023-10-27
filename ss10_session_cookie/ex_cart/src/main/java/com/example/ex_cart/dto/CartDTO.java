package com.example.ex_cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ProductDTO, Integer> productMap = new HashMap<>();

    public CartDTO() {
    }

    public Map<ProductDTO, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDTO, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDTO productDTO){
        if(productMap.containsKey(productDTO)){
            Integer currentValue = productMap.get(productDTO);
            productMap.replace(productDTO,currentValue+1);
        } else {
            productMap.put(productDTO,1);
        }
    }
    public void deleteProduct(ProductDTO productDTO){
        productMap.remove(productDTO);
    }

    public void increaseProduct(ProductDTO productDTO){
        Integer currentValue = productMap.get(productDTO);
        productMap.replace(productDTO,currentValue+1);
    }
    public void descreaseProduct(ProductDTO productDTO){
        Integer currentValue = productMap.get(productDTO);
        if(currentValue>0){
            productMap.replace(productDTO,currentValue-1);
        }
    }
    public Double totalPrice(){
        Double total = 0.0;
        for (Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
            total=total+entry.getKey().getPrice()*entry.getValue();
        }
        return total;
    }
}
