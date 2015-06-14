package UI;

import BLL.ActualCustomerBusinessLogic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Maral Khojasteh
 */
public class ActualCustomerDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html >\n" +
                "<html lang=\"fa-IR\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Actual Customer Delete</title>\n" +
                "    <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n" +
                "</head>\n" +
                "<body dir=\"rtl\">\n" +
                "<div id=\"wrapper\">\n" +
                "    <div id=\"sidebar-wrapper\">\n" +
                "        <div id=\"header\" class=\"container\" >\n" +
                "            <div id=\"logo\">\n" +
                "                <h1><a href=\"#\">جستجوی مشتری حقیقی</a></h1>\n" +
                "            </div>\n" +
                "            <div id=\"menu\" dir=\"rtl\">\n" +
                "                <ul>\n" +
                "                    <li><a href=\"index.html\">خانه</a></li>\n" +
                "                    <li><a href=\"ActualCustomerRegistration.html\">ثبت مشتری حقیقی</a></li>\n" +
                "                    <li><a href=\"LegalCustomerRegistration.html\">ثبت مشتری حقوقی</a></li>\n" +
                "                    <li class=\"current_page_item\"><a href=\"ActualCustomerSearch.html\">جستجوی مشتری حقیقی</a></li>\n" +
                "                    <li><a href=\"LegalCustomerSearch.html\">جستجوی مشتری حقوقی</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div id=\"content\">\n" +
                "        <div class=\"post\">\n" +
                "\n" +
                "            <div class=\"entry\">\n" +
                "<div class=\"sidebar\">");
        if (ActualCustomerBusinessLogic.deleteActualCustomerById(request.getParameter("id"))) {
            out.println("مشتری از سیستم حذف شد");
        }
        out.println("</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
