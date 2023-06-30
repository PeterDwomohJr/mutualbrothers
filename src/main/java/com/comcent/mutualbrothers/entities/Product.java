package com.comcent.mutualbrothers.entities;

import com.comcent.mutualbrothers.valueObject.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
@Component
public class Product {

    @Id
    private String id;
    private String name;
    private int quantity;
    private double price;
    private List<Message> messages;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
