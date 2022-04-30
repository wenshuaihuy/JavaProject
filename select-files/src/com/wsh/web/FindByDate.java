package com.wsh.web;

//import com.fs.domain.Fs;
//import com.fs.service.FsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author WS Hu
 * @date 2020/12/17 21:36
 */
@WebServlet("/findByDate")
public class FindByDate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //测试
//        System.out.println(44);
        //获取用户输入的查询时间
//        String date1 = request.getParameter("date1").replace("T"," ")+":00";
        String date1 = request.getParameter("date1");

//            String date2 = request.getParameter("date2").replace("T"," ")+":59";
            String date2 = request.getParameter("date2");
            //调用Service层方法
//            FsService fsService = new FsService();
//            List<Fs> list = fsService.findByDate(date1,date2);
            //将集合存到域对象
//            request.setAttribute("list", list);
            //将数据转发到
            request.getRequestDispatcher("/list-all.jsp").forward(request, response);

    }
}
