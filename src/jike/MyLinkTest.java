package jike;

/**
 * MyLinkTest
 *
 * @author Jiantao Yan
 * @title: MyLinkTest
 * @date 2020/3/23 18:44
 */
public class MyLinkTest {

    public static void main(String[] args) {
        MyLink link = new MyLink();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);

        System.out.println("---------->" + link.toString());
    }
}
