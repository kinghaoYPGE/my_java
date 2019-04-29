package com.myspring.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

@Controller
public class FileController {
  @RequestMapping(value="/upload", method=RequestMethod.GET)
  public String to_upload() {
    return "upload";
  }
  
  // 文件上传
  @RequestMapping(value="/upload", method=RequestMethod.POST)
  public String upload(HttpServletRequest request, @ModelAttribute MultipartFile file, Model model) throws Exception {
    if(file.isEmpty()) {
      throw new FileUploadException("please choose file first!");
    }
    String path = request.getServletContext().getRealPath("/upload/images/");
    String filename = file.getOriginalFilename();
    File filepath = new File(path, filename);
    if(!filepath.getParentFile().exists()) {
      filepath.getParentFile().mkdirs();
    }
    file.transferTo(filepath);
    model.addAttribute("file", file);
    return "download";
  }

   // 文件下载
    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename) throws Exception{
        // 下载路径
        String path = request.getServletContext().getRealPath("/upload/images/");
        File file = new File(path+File.separator+filename);
        HttpHeaders headers = new HttpHeaders();
        // 解决中文乱码
        String downloadfile =  new String(filename.getBytes("UTF-8"),"iso-8859-1");
        // 以下载方式打开文件
        headers.setContentDispositionFormData("attachment", downloadfile);
        // 二进制流
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);

    }

}