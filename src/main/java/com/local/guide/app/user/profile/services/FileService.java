package com.local.guide.app.user.profile.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	public void imageUploadForWeb( String file) throws IOException {
		if (file != null) {
			String[] strArr = file.split(",");
			FileOutputStream fs = new FileOutputStream("/users/vvravikiran/downloads/demo3.png");
			byte[] byteArr = DatatypeConverter.parseBase64Binary(strArr[1]);
			fs.write(byteArr);
			fs.close();
		} else {
			System.out.println("file empty");
		}
	}
	
	public void imageUploadFromMobile(MultipartFile file) throws IOException {
		Path path = Paths.get("/users/vvravikiran/downloads/"+file.getOriginalFilename());
		Files.copy(file.getInputStream(), path);
	}
}
