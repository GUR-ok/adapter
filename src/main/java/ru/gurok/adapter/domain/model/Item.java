package ru.gurok.adapter.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.InputStream;

@Data
@Document(collection = "Item")
public class Item {

    @Id
    private String id;

    @Field(value = "Data")
    private InputStream data;

    @Field(value = "Title")
    private String title;
}
