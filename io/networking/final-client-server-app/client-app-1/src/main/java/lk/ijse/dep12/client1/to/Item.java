package lk.ijse.dep12.client1.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String barcode;
    private String description;
    private int qty;
    private BigDecimal price;
}
