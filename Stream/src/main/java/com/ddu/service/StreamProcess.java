package com.ddu.service;

import com.ddu.entity.Author;
import com.ddu.entity.Book;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ddu.service.StreamDemo.getAuthors;

/**
 * @Author Costar
 * @Date 周六 2024/2/24 14:30
 */
public class StreamProcess {
    public static void main(String[] args) {
        // 打印所有姓名长度大于1的作家的姓名
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));

        // map 可以把对流中的元素进行计算或转换
        // 打印所有作家的姓名
        authors.stream()
                .map(author -> author.getName())
                .forEach(name -> System.out.println(name));

        // 打印所有作家的姓名
        authors.stream()
                .map(Author::getName)
                .forEach(System.out::println);

        //
        authors.stream()
                .map(Author::getAge)
                .map(age -> age + 10)
                .forEach(System.out::println);

        // distinct 可以去除流中的重复元素。
        /**
         * 注意：distinct方法是依赖Object的equals方法来判断是否是相同对象的。所以需要注意重写equals方法。
         */
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));

        // sorted 可以对流中的元素进行排序
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
        authors.stream()
                .distinct()
                .sorted()
                .forEach(author -> System.out.println(author.getAge()));

        // limit 可以设置流的最大长度，超出的部分将被抛弃
        // 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家的姓名。
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));

        // skip 跳过流中的前n个元素，返回剩下的元素
        // 打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));

        // flatMap map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。
        // 打印所有书籍的名字。要求对重复的元素进行去重。
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));

        //打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(System.out::println);

        // forEach 对流中的元素进行遍历操作，我们通过传入的参数去指定对遍历到的元素进行什么具体操作。
        authors.stream()
                .map(Author::getName)
                .distinct()
                .forEach(System.out::println);

        // count 可以用来获取当前流中元素的个数。
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);

        //max&min 可以用来或者流中的最值。
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .max(Comparator.comparingInt(score -> score));

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(Book::getScore)
                .min(Comparator.comparingInt(score -> score));
        System.out.println(max.get());
        System.out.println(min.get());

        // collect 把当前流转换成一个集合。
        // 获取一个存放所有作者名字的List集合。
        List<String> nameList = authors.stream()
                .map(Author::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);

        //获取一个所有书名的Set集合。
        Set<Book> books = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(books);

        //获取一个Map集合，map的key为作者名，value为List<Book>
        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(Author::getName, Author::getBooks));
        System.out.println(map);
    }
}
