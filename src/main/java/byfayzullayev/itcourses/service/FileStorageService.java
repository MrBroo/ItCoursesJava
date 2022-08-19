package byfayzullayev.itcourses.service;

import byfayzullayev.itcourses.entity.FileStorage;
import byfayzullayev.itcourses.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    private final FileStorageRepository fileStorageRepository;

    @Value("${upload.folder}")
    private String uploadFolder;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }
    public FileStorage store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileStorage fileStorage = new FileStorage(fileName, file.getContentType(), file.getBytes());
        return fileStorageRepository.save(fileStorage);
    }


    public FileStorage getFile(String id) {
        return fileStorageRepository.findById(id).get();
    }


    public Stream<FileStorage> getAllFiles() {
        return fileStorageRepository.findAll().stream();
    }

//    public void save(MultipartFile multipartFile){
//        FileStorage fileStorage = new FileStorage();
//        fileStorage.setName(multipartFile.getOriginalFilename());
//        fileStorage.setExtansion(getExt(multipartFile.getOriginalFilename()));
//        fileStorage.setFileSize(multipartFile.getSize());
//        fileStorage.setContentType(multipartFile.getContentType());
//        fileStorageRepository.save(fileStorage);
//
//        Date now = new Date();
//        File uploadFolder = new File(String.format("%s/upload_files/%d/%d/%d/", this.uploadFolder,
//                1900 + now.getYear(), 1 + now.getMonth(), now.getDate()));
//        if(!uploadFolder.exists() && uploadFolder.mkdirs()) {
//            System.out.println("success");
//        }
//
//        fileStorage.setUploadPath(String.format("upload_files/%d/%d/%d/%s.%s/",
//                1900 + now.getYear(),
//                1 + now.getMonth(),
//                now.getDate(),
//                fileStorage.getExtansion()));
//        fileStorageRepository.save(fileStorage);
//        uploadFolder = uploadFolder.getAbsoluteFile();
//        File file = new File(uploadFolder, String.format("%s.%s", fileStorage.getExtansion()));
//        try{
//            multipartFile.transferTo(file);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public FileStorage getFile(String id) {
//        return fileStorageRepository.findById(id).get();
//    }
//    private String getExt(String fileName){
//        String ext = null;
//        if(fileName != null && !fileName.isEmpty()){
//            int dot = fileName.lastIndexOf('.');
//            if(dot > 0 && dot <= fileName.length() -2){
//                ext = fileName.substring(dot +1);
//
//            }
//        }
//        return ext;
//    }

}
