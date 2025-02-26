package com.jean.naturaeco.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    String upload(MultipartFile arquivo);
}
