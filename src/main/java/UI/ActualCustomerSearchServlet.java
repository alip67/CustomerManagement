package UI;

import business.ActualCustomerBusinessLogic;
import model.ActualCustomer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ActualCustomerSearchServlet extends HttpServlet {
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
                "    <title>Actual Customer Search</title>\n" +
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
                "            <div class=\"entry\">");
        ActualCustomer actualCustomer = new ActualCustomer();
        if (request.getParameter("CustomerId").length() != 0)
            actualCustomer.setId(request.getParameter("CustomerId"));
        if (request.getParameter("FirstName").length() != 0)
            actualCustomer.setFirstName(request.getParameter("FirstName"));
        if (request.getParameter("LastName").length() != 0)
            actualCustomer.setLastName(request.getParameter("LastName"));
        if (request.getParameter("NationalCode").length() != 0)
            actualCustomer.setNationalCode(request.getParameter("NationalCode"));
        List<ActualCustomer> actualCustomers = ActualCustomerBusinessLogic.searchActualCustomer(actualCustomer);
        if (actualCustomers.isEmpty()) {
            out.println("<div class=\"sidebar\">");
            out.println("<p class=\"textCenter\">موردی یافت نشد</p>");
            out.println("</div>");
        } else {
            out.println("<div class=\"table\">\n" +
                    "                    <div class=\"htr\">\n" +
                    "                        <div class=\"idtd\">ردیف</div>\n" +
                    "\n" +
                    "                        <div class=\"htd\"><p>شناسه</p></div>\n" +
                    "                        <div class=\"htd\"><p>نام</p></div>\n" +
                    "                        <div class=\"htd\"><p>نام خانوادگی</p></div>\n" +
                    "                        <div class=\"htd\"><p>نام پدر</p></div>\n" +
                    "                        <div class=\"htd\"><p>تاریخ تولد</p></div>\n" +
                    "                        <div class=\"htd\"><p>کد ملی</p></div>\n" +
                    "                        <div class=\"htd\"></div>\n" +
                    "                    </div>");
            int counter = 0;
            out.println("<script type=\"text/javascript\" src=\"ActualJavaScript.js\"></script>");
            for (ActualCustomer actualCustomer0 : actualCustomers) {
                counter++;
                actualCustomer = actualCustomer0;
                out.println("<div class=\"tr\" >\n" +
                        "<form method=\"get\" id=\"myForm" + counter + "\">" +
                        "                <input style=\"display:none\" type=\"text\" \" name=\"oldNationalCode\" size=\"8\" value=\"" + actualCustomer.getNationalCode() + "\">" +
                        "                        <div class=\"idtd\">" + counter + "</div>\n" +
                        "                        <div class=\"td\">" +
                        "                        <p id=\"idLabel" + counter + "\">" + actualCustomer.getId() + "</p>" +
                        "                        <input style=\"display:none\" type=\"text\" id=\"id" + counter + "\" name=\"id\" size=\"8\" value=\"" + actualCustomer.getId() + "\">" +
                        "                        </div>\n" +
                        "                        <div class=\"td\">" +
                        "                        <p id=\"firstNameLabel" + counter + "\">" + actualCustomer.getFirstName() + "</p>" +
                        "                        <input style=\"display:none\" type=\"text\" id=\"firstName" + counter + "\" name=\"firstName\" size=\"8\" value=\"" + actualCustomer.getFirstName() + "\">" +
                        "                        </div>\n" +
                        "                        <div class=\"td\">" +
                        "                        <p id=\"lastNameLabel" + counter + "\">" + actualCustomer.getLastName() + "</p>" +
                        "                        <input style=\"display:none\" type=\"text\" id=\"lastName" + counter + "\" name=\"lastName\" size=\"8\" value=\"" + actualCustomer.getLastName() + "\">" +
                        "                        </div>\n" +
                        "                        <div class=\"td\">" +
                        "                        <p id=\"fatherNameLabel" + counter + "\">" + actualCustomer.getFatherName() + "</p>" +
                        "                        <input style=\"display:none\" type=\"text\" id=\"fatherName" + counter + "\" name=\"fatherName\" size=\"8\" value=\"" + actualCustomer.getFatherName() + "\">" +
                        "                        </div>\n" +
                        "                        <div class=\"td\">" +
                        "                        <p id=\"birthdayDateLabel" + counter + "\">" + actualCustomer.getDateOfBirthday().substring(0, 10) + "</p>" +
                        "                        <input style=\"display:none\" type=\"text\" id=\"birthdayDate" + counter + "\" name=\"birthdayDate\" size=\"8\" value=\"" + actualCustomer.getDateOfBirthday().substring(0, 10) + "\">" +
                        "                        </div>\n" +
                        "                        <div class=\"td\">" +
                        "                        <p id=\"nationalCodeLabel" + counter + "\">" + actualCustomer.getNationalCode() + "</p>" +
                        "                        <input style=\"display:none\" type=\"text\" id=\"nationalCode" + counter + "\" name=\"nationalCode\" size=\"8\" value=\"" + actualCustomer.getNationalCode() + "\">" +
                        "                        </div>\n" +
                        "                        <div class=\"td\" id=\"choose" + counter + "\">\n" +
                        "                            <a href=\"#\" onclick=\"visible(" + counter + ")\"><img src=\"file_edit.png\" style=\"margin-left: 5px\"></a>\n" +
                        "                            <a  onclick=\"doDelete(" + counter + ")\"><img src=\"file_delete.png\"></a>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"td\" style=\"display:none\" id=\"send" + counter + "\">" +
                        "                           <div class=\"buttonDiv\">\n" +
                        "                        <input class=\"tinButton\" type=\"submit\" value=\"ذخیره\" onclick=\"doUpdate(" + counter + ")\">\n" +
                        "                   </div>" +
                        "                        </div>" +
                        "</form>" +
                        "                    </div>");
            }
            out.println("</div>");
        }
        out.println("</div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}
