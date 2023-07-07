package com.paul.fileUpload.Service;

import com.paul.fileUpload.Model.Image;
import com.paul.fileUpload.Repository.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{
    private final ImageRepo repo;
    @Override
    public Image addImage(MultipartFile image) throws IOException {
        Image _image = new Image();
        _image.setName(image.getOriginalFilename());
        _image.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        repo.save(_image);
        return _image;

    }

    @Override
    public List<Image> getAllImages() {
        return repo.findAll();
    }
}
