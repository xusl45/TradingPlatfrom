package com.ssm.tradingPlatfrom.controller;


import com.ssm.tradingPlatfrom.utils.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class UploadController {


//    @ResponseBody
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public String testPicUpload(@RequestParam("file") MultipartFile[] file, String img) throws Exception {
//        System.out.println("长度" + file.length);
//
//        Boolean isTrue;
//        if (file.length != 0) {
//            try {
//                //图片命名
//                for (int i = 0; i < file.length; i++) {
////                    SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMddHHmmss");
////                    Calendar calendar = Calendar.getInstance();
//                    String newCompanyImageName = img;
////                            sFormat.format(calendar.getTime()) + ".jpg";
//                    String newCompanyImagepath = "C:\\Program Files\\images" + newCompanyImageName;
//                    File newFile = new File(newCompanyImagepath);
//                    if (!newFile.exists()) {
//                        newFile.createNewFile();
//                    }
//                    BufferedOutputStream out = new BufferedOutputStream(
//                            new FileOutputStream(newFile));
//                    out.write(file[i].getBytes());
//                    out.flush();
//                    out.close();
//
//                }
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return "图片上传失败！";
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "图片上传失败！";
//            }
//        }
//        return "test";
//    }


    @ResponseBody //发送过来的图片存后台
    @RequestMapping("/actiontUploadImage") //@RequestParam是新的写法，程序会自动转换掉这个参数
    public ServerResponse doPatientUploadImage(@RequestParam("file") CommonsMultipartFile image,
                                               HttpServletRequest request){

        String fileName = request.getParameter("fileName");
        String actionpart = request.getParameter("actionpart");
        System.out.println(image+fileName + actionpart);
//        //组装文件保存的父文件夹的路径
//        String parentPath = request.getServletContext().getRealPath("/UpImagePic/actionimg")+"/"+actionpart;
//        //调用文件上传的服务
//        if (!fileService.uploadFile(image,fileName,parentPath)) {
//            result = "fail";
//
//        }
        String filePath="C:\\images\\";
        String newFilePath=filePath+actionpart+"\\"+fileName; //新文件的路径
        String returnPath="/"+actionpart+"/"+fileName;//返回路径

        try {
            image.transferTo(new File(newFilePath));  //将传来的文件写入新建的文件

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        if (returnPath != null) {
            return  ServerResponse.createBySuccess("用户个人头像",returnPath);
        }else {
            return  ServerResponse.createByError("设置用户个人头像");
        }
    }
}





