package lk.ijse.dep12.shared.to;

import lk.ijse.dep12.shared.util.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable {
    private Type type;
    private Object body;
}
