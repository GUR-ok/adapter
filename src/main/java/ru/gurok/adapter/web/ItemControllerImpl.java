package ru.gurok.adapter.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.gurok.adapter.service.ItemService;
import ru.gurok.adapter.web.response.InsertItemResponse;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController {

    private final ItemService itemService;

    @Override
    public InsertItemResponse insertItem(final String title,
                                         final MultipartFile data) throws IOException {
        return InsertItemResponse.builder()
                .id(itemService.addItem(title, data))
                .build();
    }

    @Override
    public Resource getItem(final String id) throws IOException {
        return new InputStreamResource(
                itemService.getItem(id));
    }

    @Override
    public void deleteItem(final String id) {
        itemService.deleteData(id);
    }
}
