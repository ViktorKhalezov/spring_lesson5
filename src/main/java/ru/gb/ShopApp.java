package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import ru.gb.config.DbConfig;
import ru.gb.config.HibernateConfig;
import ru.gb.dao.ManufacturerDao;
import ru.gb.dao.OldJdbcManufacturerDao;
import ru.gb.dao.product.OldJdbcProductDao;
import ru.gb.dao.product.ProductDao;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

public class ShopApp {

    public static void main(String[] args) {
//      OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//
//      for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//         System.out.println(manufacturer);
//      }

//       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
 //       ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        System.out.println(manufacturerDao.findById(3L));
//        System.out.println(manufacturerDao.findNameById(5L));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }


//      OldJdbcProductDao oldJdbcProductDao = new OldJdbcProductDao();
//       for(Product product : oldJdbcProductDao.findAll()) {
//         System.out.println(product);
//     }

       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        System.out.println(productDao.findById(19L));
        System.out.println(productDao.findTitleById(9L));
//     for (Product product : productDao.findAll()) {
//          System.out.println(product);
//       }

    }

}
