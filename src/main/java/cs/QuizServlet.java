package cs;


import models.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuizServlet", urlPatterns = {"/start"})
public class QuizServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Quiz quiz;
        if(session.getAttribute("quiz") ==  null){
            quiz =  new Quiz();
            session.setAttribute("quiz",quiz);
        }else{
            String answer = req.getParameter("answer");
            quiz = (Quiz)session.getAttribute("quiz");
            quiz.checkAnswer(answer);
            session.setAttribute("quiz", quiz);
        }

        if(quiz.lastQuestion())
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
