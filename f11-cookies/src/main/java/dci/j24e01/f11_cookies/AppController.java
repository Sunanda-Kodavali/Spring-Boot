package dci.j24e01.f11_cookies;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

@Controller
public class AppController {

    @GetMapping("/")
    public String index(HttpServletResponse response) {
        response.addHeader("name", "hey sunanda");
        response.addHeader("Set-Cookie","name = hey Sunanda; expires = "+ LocalDateTime.now()+";");
        Cookie cookie = new Cookie("name", "sunanda");
        cookie.setMaxAge(200);
        response.addCookie(cookie);
        return "index";
    }

    @GetMapping("/test")
    public String test(HttpServletRequest request) {

        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName());
        }
        return "index";

    }
}
