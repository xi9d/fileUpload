package com.paul.fileUpload.Service;

import com.paul.fileUpload.Model.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    Image addImage(MultipartFile image) throws IOException;

    List<Image> getAllImages();
}
