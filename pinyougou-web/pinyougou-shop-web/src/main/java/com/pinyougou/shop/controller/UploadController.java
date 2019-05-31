package com.pinyougou.shop.controller;

import com.pinyougou.common.utils.FastDFSClient;
import com.pinyougou.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kim on 2019/5/30.
 */
@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String file_server_url;

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){
        String originalFilename = file.getOriginalFilename();//获取文件名
        String extName=originalFilename.substring( originalFilename.lastIndexOf(".")+1);//得到扩展名

        try {
            FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
            String fileId = client.uploadFile(file.getBytes(), extName);
            String url=file_server_url+fileId;//图片完整地址
            System.out.println("file_server_url"+file_server_url);
            return new Result(true, url);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new Result(false, "上传失败");
    }
}
