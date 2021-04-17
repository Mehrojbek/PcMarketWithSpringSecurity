package uz.pdp.apppcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppcmarket.payload.ApiResponse;
import uz.pdp.apppcmarket.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> upload(MultipartHttpServletRequest request){
       ApiResponse apiResponse = attachmentService.uplaod(request);
       return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<?> download(@PathVariable Integer id, HttpServletResponse response){
        ApiResponse apiResponse = attachmentService.download(id, response);
        return  ResponseEntity.status(apiResponse.isSuccess()?200:404).body(apiResponse);
    }

}
