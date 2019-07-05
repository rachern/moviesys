package team.csjr.moviesys.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.csjr.moviesys.service.FileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author ReMidDream
 * @date 2018-04-11 20:28
 **/
@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${serverIp}")
    private String serverIp;

    @Override
    public List<String> fileUpload(MultipartFile[] files, Predicate<MultipartFile> predicate) {

        List<String> filePath = new ArrayList<>();
        List<MultipartFile> uploadFile = new ArrayList<>();
        try {
            //对files 进行判断
            for (MultipartFile file : files) {
                if (predicate.test(file)) {
                    uploadFile.add(file);
                } else {
                    throw new RuntimeException("上传失败!");
                }
            }
            //上传
            for (MultipartFile multipartFile : uploadFile) {
                filePath.add(doUpload(multipartFile));
            }

        } catch (IOException e) {
            throw new RuntimeException("上传失败!");
        }
        return filePath;
    }

    @Override
    public ResponseEntity<byte[]> fileDownload(String path, String fileName) {
        try {
            File file = new File(path);
            HttpHeaders headers = new HttpHeaders();
            //少了这句，可能导致下载中文文件名的文档，只有后缀名的情况
            String downloadFileName=new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
            //告知浏览器以下载方式打开
            headers.setContentDispositionFormData("attachment", downloadFileName);
            //设置MIME类型
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //用FileUpload组件的FileUtils读取文件，并构建成ResponseEntity<byte[]>返回给浏览器
            //HttpStatus.CREATED是HTTP的状态码201
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);//
        } catch (IOException e) {
            throw new RuntimeException("下载失败!");
        }
    }


    public String doUpload(MultipartFile file) throws IOException {
        Random random = new Random();
        IntStream key = random.ints(10);
        String fileName =  key + "-" + file.getOriginalFilename();
        String uploadPath = "/movie/img";
        String serverUploadPath = "http://"+serverIp+"/icon/";
        File realFile = new File(uploadPath);
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realFile, fileName));
        return serverUploadPath + fileName;
    }
}
