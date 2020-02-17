package com.java155.shop.controller.back;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

	static final String locaPath="d:/upload/";

	@RequestMapping("/pic")
	public String filePic(MultipartFile uploadFile){
		//1.将文件存储在某个地方
		String imageName= UUID.randomUUID().toString()+".png";

		File file=new File(locaPath, imageName);

		Map<String,Object> data=new HashMap<String,Object>();
		try{

			uploadFile.transferTo(file);
			String url="http://localhost:80/"+imageName;
			//获取返回url
			data.put("error", 0);
			data.put("url", url);

		}catch (Exception e){

			e.printStackTrace();
			data.put("error", 1);
			data.put("message", "上传失败");
		}

		return JSON.toJSONString(data);
	}
}
