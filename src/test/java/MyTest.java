import com.he.pojo.Books;
import com.he.service.BookService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("BookServiceImpl", BookService.class);
        for (Books books : bookService.queryAllBook()) {
            System.out.println(books);
        }
    }
}
