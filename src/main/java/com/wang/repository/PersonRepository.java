package com.wang.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.wang.model.Person;

/**
 * Created by hppc on 2017/1/18.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {


  Person getByLastname(String lastname);

  Person findByLastname(String lastname);


    /*jparepository是repository的子接口,后者是一个空接口，称为标志接口
    若定义的接口继承了repository，则该接口会被IOC容器识别为一个repository bean
    纳入到IOC容器中，进而可以在该接口中定义满足一定规范的方法
    可以通过注解来声明一个repository bean
    @RepositoryDefinition(domainClass = Person.class,idClass = Integer.class)
    这样就不用继承接口了

    声明方法的规范：
    1.查询方法以find read get 开头
    2.涉及条件查询时，条件的属性用条件关键字(and or ……)连接
    3.条件属性的首字母要大写

    */

  //where lastname like ?% and id < ?
  List<Person> getByLastnameStartingWithAndIdLessThan(String lastname, Integer id);

  List<Person> getByLastnameEndingWithAndIdLessThan(String lastname, Integer id);

  @Query("select new map(p.lastname as lastname,p.id as id) from Person p where p.id < ?1")
  List<Map> getfromquery(int id);

  @Transactional
  @Modifying
  @Query("update Person p set p.id=600 where p.id=?1")
    //为什么这里报错，但是却能正常执行
  int updatepersonbyid(int id);

  @Transactional
  @Modifying
  @Query("delete from Person p where p.id=?1")
  int deletebyid(int id);

  //注意上面与下面两个删除操作的区别        事实证明两种删除方法都能删除，但是网上的例子基本上都是自己用@Query写的删除语句
  @Transactional
  int deleteById(int id);

  //int save(Person person);   插入操作不用在这里面写，直接通过这个类调用就可以了
}
