package main.java.oneTomany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor

@ToString
public class OrderResponse {

    private String name;
    private String prodcutName;

    public OrderResponse(String name, String prodcutName) {
        this.name = name;
        this.prodcutName = prodcutName;
    }

}