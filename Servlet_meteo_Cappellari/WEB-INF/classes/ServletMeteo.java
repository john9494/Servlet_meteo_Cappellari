import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletMeteo")
public class ServletMeteo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml; charset=UTF-8");
        PrintWriter r = response.getWriter();
        r.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        r.println("<meteo>");
        r.println("<posizione>" + request.getParameter("posizione") + "</posizione>");
        r.println("<meteoOdierno>" + meteo() + "</meteoOdierno>");
            int giorniDiPrevisione = Integer.parseInt(request.getParameter("numeroGiorniDiPrevisione"));
            if (giorniDiPrevisione > 0) {
                r.println("<previsioni>");
                for (int i = 0; i < giorniDiPrevisione; i++) {
                    r.println("<giorno" + i + ">" + meteo() + "</giorno" + i + ">");
                }
                r.println("</previsioni>");
            }
        r.println("</meteo>");
    }

    private String meteo(){
        int numero = (int)(Math.random()*10);
        if(numero == 1){
            return "temporale";
        }else if(numero == 2){
            return "pioggia";
        }else if(numero == 3){
            return "nebbia";
        }else if(numero == 4){
            return "sole";
        }else if(numero == 5){
            return "nuvoloso";
        }else if(numero == 6){
            return "molto nuvoloso";
        }else if(numero == 7){
            return "grandine";
        }else if(numero == 8){
            return "neve";
        }else if(numero == 9){
            return "poco nuvoloso";
        }else{
            return "nevischio";
        }
    }
}
