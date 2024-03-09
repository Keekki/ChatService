package com.chatservice.springboot.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// THIS IS A PLACEHOLDER FOR A MEDIA CONTROLLER IF WE
// DECIDE TO ADD A MEDIA POST FEATURE TO THE APP
@RestController
@RequestMapping("/api/media")
public class MediaController {

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // Here you would handle the file upload and return the URL where the file is stored
        // For example, you could use Spring's FileSystemResource or a cloud storage service
        String fileUrl = "http://example.com/path/to/file";
        return ResponseEntity.ok(fileUrl);
    }
}
