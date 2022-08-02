package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.entity.FileStorage;
import byfayzullayev.itcourses.model.response.ApiResponse;
import byfayzullayev.itcourses.repository.FileStorageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private final FileStorageRepository fileStorageRepository;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    public void save(MultipartFile multipartFile){
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setExtansion(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorageRepository.save(fileStorage);
    }

    public FileStorage getFile(Long id) {
        return fileStorageRepository.findById(id).get();
    }
    private String getExt(String fileName){
        String ext = null;
        if(fileName != null && !fileName.isEmpty()){
            int dot = fileName.lastIndexOf('.');
            if(dot > 0 && dot <= fileName.length() -2){
                ext = fileName.substring(dot +1);

            }
        }
        return ext;
    }

}
