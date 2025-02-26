package com.jean.naturaeco.service.upload;

import com.jean.naturaeco.exception.UploadErrorException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadServiceImpl implements IUploadService{


    @Override
    public String upload(MultipartFile arquivo) {

        try{
            String caminho = "C:\\Users\\jean\\Documents\\images";
            Path path = Paths.get(caminho + File.separator + arquivo.getOriginalFilename());
            Files.copy(arquivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return path.toString()
                    ;
        }catch (Exception e) {
            throw new  UploadErrorException(e.getMessage());
        }
    }
}
