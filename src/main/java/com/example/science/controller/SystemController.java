// package com.example.science.controller;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.core.io.InputStreamResource;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import java.io.*;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// @RestController
// @RequestMapping("/system-api")
// public class SystemController {


//     private static String userName="keshe";


//     private static String password="E5MXAT7rinSs3HdA";
//     //sql文件存储的路径
//     private static String savePath = "./data";
//     //sql文件存储名
//     //数据库名
//     private static String databaseName = "keshe";
//     private boolean executeTask=true;


//     @RequestMapping("/manual-backup")
//     public static ResponseEntity<InputStreamResource> dataBakExec() {
//         String sqlFilePath = "";
//         File saveFile = new File(savePath);
//         // 如果目录不存在
//         if (!saveFile.exists()) {
//             // 创建文件夹
//             saveFile.mkdirs();
//         }
//         if (!savePath.endsWith(File.separator)) {
//             savePath = savePath + File.separator;
//         }
//         PrintWriter printWriter = null;
//         BufferedReader bufferedReader = null;
//         HttpHeaders headers = null;
//         InputStreamResource resource = null;
//         try {
//             String fileName = "keshe" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".sql";
//             printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
//             sqlFilePath = savePath + fileName;
//             //导出指定数据库指定表的结构和数据
//             Process process = Runtime.getRuntime().exec("mysqldump " + " -u" + userName + " -p" + password + " --databases " + databaseName);
//             InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
//             bufferedReader = new BufferedReader(inputStreamReader);
//             String line;
//             while ((line = bufferedReader.readLine()) != null) {
//                 printWriter.println(line);
//             }
//             File file = new File(sqlFilePath);
//             // 设置响应头，提示浏览器进行文件下载
//             headers = new HttpHeaders();
//             headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//             headers.setContentDispositionFormData("attachment", file.getName());

//             // 将文件内容转换为输入流
//             FileInputStream fileInputStream = new FileInputStream(file);
//             resource = new InputStreamResource(fileInputStream);

//             printWriter.flush();
//             //0 表示线程正常终止。
//             if (process.waitFor() == 0) {
//                 //System.out.println("备份数据成功");
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (bufferedReader != null) {
//                     bufferedReader.close();
//                 }
//                 if (printWriter != null) {
//                     printWriter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//         // 返回响应实体
//         return new ResponseEntity<>(resource, headers, HttpStatus.OK);
//     }

//     @GetMapping("/check-backup")
//     public String checkBackup()
//     {
//         if(this.executeTask)
//             return "true";
//         else return "false";
//     }

//     @GetMapping("/change-backup")
//     public void changeBackup()
//     {
//         this.executeTask= !this.executeTask;
//         //System.out.println("自动备份:"+this.executeTask);
//     }

//     // 前端请求该接口来控制是否执行定时任务
// //    @GetMapping("/control-backup")
// //    public String controlTask(@RequestParam("execute") boolean execute) {
// //        this.executeTask = execute;
// //        return "Task execution control set to: " + execute;
// //    }
//     // 定时任务，根据 executeTask 变量决定是否执行
//     @Scheduled(fixedRate = 1000*60*60*24) // 每隔1天执行一次
//     public void scheduledTask() {
//         if (executeTask) {
//             saveData();
//         }
//     }

// //    @GetMapping("/download")
// //    public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
// //        // 指定要下载的文件路径
// //        String filePath = "D:\\backup\\test.txt";
// //
// //        // 创建文件对象
// //        File file = new File(filePath);
// //
// //        // 设置响应头，提示浏览器进行文件下载
// //        HttpHeaders headers = new HttpHeaders();
// //        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
// //        headers.setContentDispositionFormData("attachment", file.getName());
// //
// //        // 将文件内容转换为输入流
// //        FileInputStream fileInputStream = new FileInputStream(file);
// //        InputStreamResource resource = new InputStreamResource(fileInputStream);
// //
// //        // 返回响应实体
// //        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
// //    }
//     public static void saveData()
//     {
//         String sqlFilePath = "";
//         File saveFile = new File(savePath);
//         // 如果目录不存在
//         if (!saveFile.exists()) {
//             // 创建文件夹
//             saveFile.mkdirs();
//         }
//         if (!savePath.endsWith(File.separator)) {
//             savePath = savePath + File.separator;
//         }
//         PrintWriter printWriter = null;
//         BufferedReader bufferedReader = null;
//         try {
//             String fileName = "keshe" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".sql";
//             printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
//             sqlFilePath = savePath + fileName;
//             //导出指定数据库指定表的结构和数据
//             Process process = Runtime.getRuntime().exec("mysqldump " + " -u" + userName + " -p" + password + " --databases " + databaseName);
//             InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
//             bufferedReader = new BufferedReader(inputStreamReader);
//             String line;
//             while ((line = bufferedReader.readLine()) != null) {
//                 printWriter.println(line);
//             }
//             printWriter.flush();
//             //0 表示线程正常终止。
//             if (process.waitFor() == 0) {
//                 //System.out.println("备份数据成功");
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             try {
//                 if (bufferedReader != null) {
//                     bufferedReader.close();
//                 }
//                 if (printWriter != null) {
//                     printWriter.close();
//                 }
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
// }
