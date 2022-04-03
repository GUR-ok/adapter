package ru.gurok.adapter.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface ItemService {

    String addItem(String title, MultipartFile file) throws IOException;

    InputStream getItem(String id) throws IOException;

    void deleteData(String id);
}
