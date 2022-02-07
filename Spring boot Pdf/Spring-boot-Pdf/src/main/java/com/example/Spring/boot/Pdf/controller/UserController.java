package com.example.Spring.boot.Pdf.controller;

import com.example.Spring.boot.Pdf.entity.User;
import com.example.Spring.boot.Pdf.helper.UserExporter;
import com.example.Spring.boot.Pdf.service.UserService;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/export/pdf")
    public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException{
        response.setContentType("application/pdg");
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<User> userList = userService.listAll();

        UserExporter exporter = new UserExporter(userList);
        exporter.export(response);
    }

}
