package ru.geekbrains;
//1. В базе данных необходимо реализовать возможность хранить информацию о покупателях (id, имя) и товарах
// (id, название, стоимость). У каждого покупателя свой набор купленных товаров;
//2. Для обеих сущностей создаете Dao классы. Работу с SessionFactory выносите во вспомогательный класс;
//3*. Создаете сервис, позволяющий по id покупателя узнать список купленных им товаров, и по id товара узнавать список
// покупателей этого товара;
//4**. Добавить детализацию по паре «покупатель — товар»: сколько стоил товар в момент покупки клиентом;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.daoConnection.SessionManager;
import ru.geekbrains.services.DAOService;




@Configuration
@ComponentScan("ru.geekbrains")

public class Main {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);

        DAOService daoService = applicationContext.getBean(DAOService.class);

        System.out.println("Проверяем покупателя с id #1");
        System.out.println("Покупатель с id #1 купил товары: \n" + daoService.getListProductByUserId(1L));
        System.out.println("Список покупателей, которые купили товар с id #3");
        System.out.println("Данный товар купили покупатели: \n" + daoService.getListUserByProductId(5L));
        System.out.println(daoService.getUserById(2L));
        System.out.println(daoService.getListProduct());
        System.out.println(daoService.getListUser());

        SessionManager.close();//нужно ли здесь это?

    }
}
