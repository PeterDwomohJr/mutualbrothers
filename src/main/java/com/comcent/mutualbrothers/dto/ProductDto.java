package com.comcent.mutualbrothers.dto;

import com.comcent.mutualbrothers.valueObject.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductDto {

    private String id;
    private String name;
    private int quantity;
    private double price;
    private List<Message> messages;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
