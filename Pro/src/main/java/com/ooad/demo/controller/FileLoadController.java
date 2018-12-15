package com.ooad.demo.controller;

import com.ooad.demo.utils.FileLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @Author: WinstonDeng
 * @Description: 文件上传和下载
 * @Date: Created in 8:34 2018/12/10
 * @Modified by:
 */
@RestController
@RequestMapping("/file")
public class FileLoadController {


    /**
     * Description: 单文件上传
     * @Author: WinstonDeng
     * @Date: 8:54 2018/12/10
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        FileLoadUtils fileLoadUtils=new FileLoadUtils();
        String filePath= "D://fileloadtest//";
        return fileLoadUtils.upload(file,filePath);
    }

    /**
     * Description: 多文件上传
     * @Author: WinstonDeng
     * @Date: 8:54 2018/12/10
     */
    @RequestMapping(value = "/uploadmore", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        FileLoadUtils fileLoadUtils=new FileLoadUtils();
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath= "D://fileloadtest//";
        return fileLoadUtils.handleFileUpload(files,filePath);
    }
    /**
     * Description: 文件下载相关代码
     * @Author: WinstonDeng
     * @Date: 8:53 2018/12/10
     */
    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        FileLoadUtils fileLoadUtils=new FileLoadUtils();
        String realPath="D://fileloadtest//";
        String fileName = "upload.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        return fileLoadUtils.downloadFile(request, response,realPath,fileName);
    }

}
