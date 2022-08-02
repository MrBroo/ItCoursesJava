package byfayzullayev.itcourses.controller;

import byfayzullayev.itcourses.entity.FileStorage;
import byfayzullayev.itcourses.model.response.ResponseMessage;
import byfayzullayev.itcourses.service.FileStorageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/itCourses/file")
public class FileStorageController {

    private final FileStorageService fileStorageService;

    public FileStorageController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity upload(@RequestParam ("file")MultipartFile multipartFile){
        String message = "";
        try {
            fileStorageService.save(multipartFile);
            message = "Uploaded the file successfully: " + multipartFile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + multipartFile.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }

    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        FileStorage fileStorage = fileStorageService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileStorage.getName() + "\"")
                .body(fileStorage.getData());
    }
}
