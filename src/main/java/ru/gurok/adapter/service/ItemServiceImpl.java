package ru.gurok.adapter.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.gurok.adapter.domain.model.Item;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final GridFsTemplate gridFsTemplate;
    private final GridFsOperations operations;

    @Override
    public String addItem(final String title, final MultipartFile data) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "image");
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(
                data.getInputStream(), data.getName(), data.getContentType(), metaData);
        return id.toString();
    }

    @Override
    public InputStream getItem(final String id) throws IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        if (file == null) {
            throw new RuntimeException();
        }
        Item video = new Item();
        video.setTitle(file.getMetadata().get("title").toString());
        video.setData(operations.getResource(file).getInputStream());
        return video.getData();
    }

    @Override
    public void deleteData(final String id) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }
}
