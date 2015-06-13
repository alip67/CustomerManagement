package UI;

import BLL.LegalCustomerBusinessLogic;
import DAL.LegalCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LegalCustomerRegistrationServlet extends HttpServlet {
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
                "    <title>Legal Customer Management</title>\n" +
                "    <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\" />\n" +
                "</head>\n" +
                "<body dir=\"rtl\">\n" +
                "<div id=\"wrapper\">\n" +
                "    <div id=\"sidebar-wrapper\">\n" +
                "        <div id=\"header\" class=\"container\" >\n" +
                "            <div id=\"logo\">\n" +
                "                <h1><a href=\"#\">ثبت مشتری حقوقی</a></h1>\n"+
                "            </div>\n" +
                "            <div id=\"menu\" dir=\"rtl\">\n" +
                "                <ul>\n" +
                "                    <li><a href=\"index.html\">خانه</a></li>\n" +
                "                    <li><a href=\"ActualCustomerRegistration.html\">ثبت مشتری حقیقی</a></li>\n" +
                "                    <li class=\"current_page_item\"><a href=\"LegalCustomerRegistration.html\">ثبت مشتری حقوقی</a></li>\n" +
                "                    <li><a href=\"ActualCustomerSearch.html\">جستجوی مشتری حقیقی</a></li>\n" +
                "                    <li><a href=\"LegalCustomerSearch.html\">جستجوی مشتری حقوقی</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div id=\"content\">\n" +
                "        <div class=\"post\">\n" +
                "\n" +
                "            <div class=\"entry\">\n" +
                "\n" +
                "                <div class=\"sidebar\">\n");
        LegalCustomer legalCustomer = new LegalCustomer(request.getParameter("CompanyName"), request.getParameter("RegisteringDate"),
                request.getParameter("EconomicCode"));
        int customerId = LegalCustomerBusinessLogic.registerCustomer(legalCustomer);
        if (customerId != -1) {
            out.println("<p class=\"textCenter\">مشتری با موفقیت ثبت شد</p>");
            out.println("<p class=\"textCenter\">شماره مشتری:" + customerId + "</p>");
        } else {
            out.println("<p class=\"textCenter\">کد اقتصادی تکراری است</p>");
            out.println("<p class=\"textCenter\">لطفا مجددا تلاش کنید</p>");
            out.println("                    <h2>ثبت مشتری حقیقی</h2>\n" +
                    "                    <form method=\"get\" action=\"http://localhost:8080/LegalCustomerRegistrationServlet\">\n" +
                    "                        <div class=\"inputRow\" >\n" +
                    "                            <div class=\"label\" >نام شرکت:</div>\n" +
                    "                            <div class=\"input\"><input class=\"input\" type=\"text\" name=\"CompanyName\" size=\"20\"></div>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"inputRow\" >\n" +
                    "                            <div class=\"label\" >تاریخ ثبت:</div>\n" +
                    "                            <div class=\"input\"><input class=\"input\" type=\"text\" name=\"RegisteringDate\" size=\"20\"></div>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"LastInputRow\" >\n" +
                    "                            <div class=\"label\">کد اقتصادی:</div>\n" +
                    "                            <div class=\"input\"><input class=\"input\" type=\"text\" name=\"EconomicCode\" size=\"20\"></div>\n" +
                    "                        </div>\n" +
                    "                        <div>\n" +
                    "                            <div class=\"buttonDiv\">\n" +
                    "                                <input class=\"button\" type=\"submit\" value=\"ثبت\" >\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </form>\n");
        }

        out.println("</div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        out.close();
    }

}

