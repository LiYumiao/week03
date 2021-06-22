package com.example.moreservlet;

import com.example.moreservlet.utils.AgentChecker;
import com.example.moreservlet.utils.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClientInfoServlet", value = "/ClientInfoServlet")
public class ClientInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("User-Agent");
        Client client = new Client(AgentChecker.getOS(agent), AgentChecker.getBrowser(agent));
        ObjectMapper objectMapper = new ObjectMapper();
        String clintJson = objectMapper.writeValueAsString(client);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(clintJson);
    }
}