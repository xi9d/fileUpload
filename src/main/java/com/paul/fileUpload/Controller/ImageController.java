package com.paul.fileUpload.Controller;

import com.paul.fileUpload.Model.Image;
import com.paul.fileUpload.Service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/upload")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService service;
    @GetMapping
    public ResponseEntity<List<Image>> getAllImages(){
        return ResponseEntity.ok(service.getAllImages());
    }
    @PostMapping
    public ResponseEntity<Image> addImage(@RequestParam("image") MultipartFile image){
        try {
            Image _image = service.addImage(image);
            return ResponseEntity.ok(_image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
