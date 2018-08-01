//import com.wang.model.Article;
//import com.wang.model.Message;
//import com.wang.model.Person;
//import com.wang.model.User;
//import com.wang.repository.ArticleRepository;
//import com.wang.repository.MessageRepository;
//import com.wang.repository.PersonRepository;
//import com.wang.repository.UserRepository;
//import com.wang.service.AdminService;
//import com.wang.service.ArticleService;
//import com.wang.service.MessageService;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.data.domain.PageRequest;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by hppc on 2017/1/17.
// */
//
//public class SpringdatajpaTest {
//
//    private ApplicationContext ctx=null;
//    PersonRepository personRepository=null;
//    ArticleRepository articleRepository=null;
//    UserRepository userRepository=null;
//    MessageRepository messageRepository=null;
//    AdminService adminService=null;
//    ArticleService articleService=null;
//    MessageService messageService=null;
//    {
//        ctx=new ClassPathXmlApplicationContext("spring-servlet.xml");
//        personRepository=ctx.getBean(PersonRepository.class);
//        articleRepository=ctx.getBean(ArticleRepository.class);
//        userRepository=ctx.getBean(UserRepository.class);
//        messageRepository=ctx.getBean(MessageRepository.class);
//        adminService=ctx.getBean(AdminService.class);
//        articleService=ctx.getBean(ArticleService.class);
//        messageService=ctx.getBean(MessageService.class);
//    }
//    @Test
//    public void testDataSource() throws SQLException{
//        DataSource dataSource=ctx.getBean(DataSource.class);
//        System.out.println(dataSource.getConnection());
//    }
//    @Test
//    public void testHibernate(){}
//    @Test
//    public void testRepository(){
//
//        Person person=personRepository.getByLastname("阳");
//        System.out.println(person);
//    }
//    @Test
//    public void testRepository_find(){
//        Person person=personRepository.findByLastname("阳");
//        System.out.println(person);
//    }
//    @Test
//    public void testRepository1(){
//        List<Person> persons=personRepository.getByLastnameStartingWithAndIdLessThan("阳",1000);
//        System.out.println(persons);
//    }
//    @Test
//    public void testRepository2(){
//        List<Person> persons=personRepository.getByLastnameEndingWithAndIdLessThan("阳",1000);
//        System.out.println(persons);
//    }
//    @Test
//    public void testRepository3(){
//        List<Map> list=personRepository.getfromquery(1000);
//        for(Map map:list){
//            Object lastname=map.get("lastname");
//            Object id=map.get("id");
//            System.out.println("lastname:"+lastname+""+"id:"+id);
//        }
//    }
//    @Test
//    public void testRepository4(){
//        int i=personRepository.updatepersonbyid(666);
//        System.out.println(i);
//    }
//    @Test
//    public void testRepository5(){
//        int i=personRepository.deleteById(667);
//        System.out.println(i);
//    }
//    @Test
//    public void testDeleteById(){
//        int i=personRepository.deletebyid(668);
//        System.out.println(i);
//    }
//    @Test
//    public void testRepository6(){
//        Person person=new Person();
//        person.setId(667);person.setEmail("123456789");
//        person.setLastname("阳阳阳");
//        Person person1=personRepository.saveAndFlush(person);
//        System.out.println("person:"+person);
//        System.out.println("person1:"+person1);
//        System.out.println(person==person1);
//    }
//
//
//
//
//
//    //博客代码重构的单元测试正式开始
//    @Test
//    public void testArticleRepository(){
//       // Article article = articleRepository.findByApkTitle("6号选手的第一篇博客");
//      //  System.out.println(article);
//    }
//    @Test
//    public void testUserRepository(){
//        User user = userRepository.findByName("2015号选手");
//        System.out.println(user);
//    }
//    @Test
//    public void testMessageRepository(){
//        List<Message> messages=messageRepository.findByCidOrder(10);
//        System.out.println(messages);
//    }
//    @Test
//    public void testSearchArticle(){
//        List<Article>articles=articleService.searcharticle(null,null);
//        System.out.println(articles);
//    }
//    @Test
//    public void testGetuserbyid(){
//        System.out.println(adminService.getuser("150"));
//    }
//    @Test
//    public void testUpdatetime(){
//        System.out.println(adminService.updatetime("2015060101006"));
//    }
//    @Test
//    public void testUpdatename(){System.out.println(adminService.updatename("阳阳哥","2015060101006"));}
//    @Test
//    public void testUpdatepassword(){System.out.println(adminService.updatepassword("fdsa951","fdsa951","Fdsa95123","2015060101006"));}
//    @Test
//    public void testDeleteaccount(){System.out.println(adminService.deleteaccount("2017","fdsa951"));}
//    @Test
//    public void testAddarticle(){System.out.println(articleService.addarticle("2015060101006","寒假作业的测试","今天刚跟老婆吵了一架",1));}
//    @Test
//    public void testAllarticlesByid(){System.out.println(articleService.allarticlesByid("2015060101006"));}
//    @Test
//    public void testAllmymessage(){System.out.println(messageService.allmessagesfrommyself("2015060101006"));}
//    @Test
//    public void testFindnamebycin(){System.out.println(articleRepository.findByCid(10));}
//    @Test
//    public void testDeletemessagebymid(){System.out.println(messageService.deletemessageBymid(5));}
//    @Test
//    public void testAddmessage(){System.out.println(messageService.addmessage("留言提醒测试","2015060101006",10));}
//    @Test
//    public void testUpdatearticlebycid(){System.out.println(articleService.updatearticlebycid("今天能完成吗",0,19));}
//    @Test
//    public void testDeletearticlebycid(){System.out.println(articleService.deletearticlebycid(19));}
//    @Test
//    public void testRegister(){
//        User user=new User();
//        user.setId("148");user.setName("吃午饭了");user.setPassword("fdsa951");
//      //  System.out.println(user);
//        System.out.println(adminService.register("148","吃晚饭吗","fdsa951"));}
//    @Test
//    public void testSearcharticle(){
//        List<Article> articles=articleService.searcharticle("","2015060101006");
//        for(Article article:articles){
//            System.out.println(article.name);
//        }
//    }
//    @Test
//    public void testMessageOrder(){
//        List<Message> messages=messageRepository.findByCidOrder(10);
//        System.out.println(messages);
//    }
//    @Test
//    public void testMessageOrder1(){
//        List<Message> messages=messageRepository.findByIdOrder("2015060101006");
//        System.out.println(messages);
//    }
//    @Test
//    public void testFindNotReadMessage(){
//        List<Message> messages=messageRepository.findnotReadMessage("2015060101006");
//        System.out.println(messages);
//    }
//    @Test
//    public void testFindNotRead(){
//        List<Message> messages=messageService.getnotreadmessages("2015060101006");
//        System.out.println(messages);
//    }
//
//
//}
