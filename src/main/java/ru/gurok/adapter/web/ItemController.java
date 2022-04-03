package ru.gurok.adapter.web;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.gurok.adapter.web.response.InsertItemResponse;

import java.io.IOException;

public interface ItemController {

    @PostMapping("/item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "application/json")})}
    )
    InsertItemResponse insertItem(@RequestParam("title") String title,
                                  @RequestParam("data") MultipartFile data) throws IOException;

    @GetMapping(value = "/items/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(mediaType = "image/png")})}
    )
    Resource getItem(@PathVariable String id) throws IOException;

    @DeleteMapping("/items/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")}
    )
    void deleteItem(@PathVariable String id);
}
