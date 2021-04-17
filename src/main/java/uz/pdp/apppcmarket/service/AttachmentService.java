package uz.pdp.apppcmarket.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppcmarket.entity.Attachment;
import uz.pdp.apppcmarket.payload.ApiResponse;
import uz.pdp.apppcmarket.repository.AttachmentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;

    final String DIRECTORY="uploads";
    @SneakyThrows
    public ApiResponse uplaod(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());

        if (file!=null){
            String[] split = file.getOriginalFilename().split("\\.");
            String name = UUID.randomUUID().toString()+"."+split[split.length-1];

            Attachment attachment=new Attachment();
            attachment.setName(name);
            attachment.setContentType(file.getContentType());
            attachment.setSize(file.getSize());
            attachment.setOriginalName(file.getOriginalFilename());

            Path path= Paths.get(DIRECTORY+"/"+name);
            Files.copy(file.getInputStream(),path);

            Attachment savedAttachment = attachmentRepository.save(attachment);
            return new ApiResponse("Saqlandi file ID : "+savedAttachment.getId(),true);
        }
        return new ApiResponse("Xatolik",false);
    }



    @SneakyThrows
    public ApiResponse download(Integer id, HttpServletResponse response){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent())
            return new ApiResponse("file not found",false);
        Attachment attachment = optionalAttachment.get();
        response.setHeader("Content-Disposition","attanchment; filename=\""+attachment.getOriginalName()+"\"");
        response.setContentType(attachment.getContentType());

        String name = attachment.getName();
        File file=new File(DIRECTORY+"/"+name);
        FileInputStream fileInputStream=new FileInputStream(file);
        FileCopyUtils.copy(fileInputStream,response.getOutputStream());
        return new ApiResponse("success",true);
    }

}
