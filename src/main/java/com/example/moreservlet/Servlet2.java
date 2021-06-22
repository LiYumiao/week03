package com.example.moreservlet;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

@WebServlet(name = "Servlet2", value = "/Servlet2")
@MultipartConfig
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*FileInputStream fis = new FileInputStream("C:\\Users\\LiYumiao\\Desktop\\img.jpg");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        fis.close();*/

        File f = new File("C:\\Users\\LiYumiao\\Desktop\\img.jpg");
        if (!f.exists()) {
            f.mkdir();
        }
        BufferedImage image = ImageIO.read(f);
        ImageIO.write(image,"png",response.getOutputStream());

    }
}
