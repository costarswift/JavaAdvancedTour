package com.ddu.service;

import com.ddu.entity.Author;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.ddu.service.StreamDemo.getAuthors;

/**
 * @Author Costar
 * @Date 周六 2024/2/24 14:50
 */
public class StreamFindAndMatch {
    public static void main(String[] args) {
        // anyMatch
        // 判断是否有年龄在29以上的作家
        List<Author> authors = getAuthors();
        boolean flag = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(flag);

        // allMatch
        // 判断是否所有的作家都是成年人
        boolean flag1 = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(flag1);

        // noneMatch
        // 判断作家是否都没有超过100岁的。
        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b);

        // findAny
        // 获取任意一个年龄大于18的作家，如果存在就输出他的名字
        Optional<Author> optionalAuthor = authors.stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));

        // findFirst
        // 获取一个年龄最小的作家，并输出他的姓名。
        Optional<Author> first = authors.stream()
                .sorted(Comparator.comparingInt(Author::getAge))
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));

        // 获取一个年龄最小的作家，并输出他的姓名。
        Optional<Author> first2 = authors.stream().min(Comparator.comparingInt(Author::getAge));
        first2.ifPresent(author -> System.out.println(author.getName()));

        // reduce归并
        /**
         * 对流中的数据按照你指定的计算方式计算出一个结果。（缩减操作）
         reduce的作用是把stream中的元素给组合起来，我们可以传入一个初始值，它会按照我们的计算方式依次拿流中的元素和初始化值进行计算，
         计算结果再和后面的元素计算。
         reduce两个参数的重载形式内部的计算方式如下：
         T result = identity;
         for (T element : this stream)
             result = accumulator.apply(result, element)
         return result;
         其中identity就是我们可以通过方法参数传入的初始值，accumulator的apply具体进行什么计算也是我们通过方法参数来确定的。
         */
        // 使用reduce求所有作者年龄的和
        Integer sum = authors.stream()
                .distinct()
                .map(Author::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        // 使用reduce求所有作者中年龄的最大值
        Integer max = authors.stream()
                .map(Author::getAge)
                .reduce(Integer.MIN_VALUE, Math::max);
        System.out.println(max);

        // 使用reduce求所有作者中年龄的最小值
        Integer min = authors.stream()
                .map(Author::getAge)
                .reduce(Integer.MAX_VALUE, Math::min);
        System.out.println(min);

        // 使用reduce求所有作者中年龄的最小值
        Optional<Integer> minOptional = authors.stream()
                .map(Author::getAge)
                .reduce(Math::min);
        minOptional.ifPresent(System.out::println);
    }
}
