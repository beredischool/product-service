package org.redischool.product.services;

import org.redischool.product.model.Attributes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by ReDI on 02/12/2016.
 */
@Service
public class FileAttributeSearchService implements AttributesSearchService {


    public Attributes findById(String id) {
        try (Stream<String> stream = Files.lines(Paths.get(this.getClass().getResource("attributes.txt").getPath()))) {
            Iterator<String> it = stream.iterator();
            while (it.hasNext()) {
                String[] line = it.next().split(",");
                if (line[0].equals(id)) {
                    return Attributes.builder().id(line[0]).name(line[1]).build();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Attributes searchAttributeByName(String attName) {
        return null;
    }
}
