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
//        link.add(3);
//        link.add(4);
//        link.add(5);
//        link.add(6);
//        link.add(7);
//        link.add(8);
//        link.addRing(7);
        System.out.println("mid=" + link.findMid());


//        System.out.println("环的位置：" + link.checkRing());
        System.out.println("---------->" + link.toString());
//        MyLink link2 = new MyLink();
//        link2.add(7);
//        link2.add(8);
//        link2.add(9);
//        link2.add(10);
//
//        link.merge(link2);
//        link.deleteReciprocal(6);

//        link.delete(5);
//        link.add(0, 10);
//        link.reverseLink1();
        System.out.println("------>" + link.toString());
    }
}
