import by.epam.tr.myArrayList.MyArrayList;
import by.epam.tr.myLinkedList.MyLinkedList;
import by.epam.tr.myList;


public class main {
    public static void main(String... args) {
        MyArrayList<String> myArrayList = new MyArrayList<String>();
        myList list = new MyLinkedList();
        myArrayList.add("miracle");
        System.out.println(myArrayList);
        myArrayList.contains("miracle");
        System.out.println(myArrayList.indexOf("miracle"));
        myArrayList.remove(0);
        System.out.println(myArrayList);

        System.out.println();

        list.add("poshel naxyi");
        System.out.println(list);
        list.add(0,"axyel?");
        System.out.println(list);
        list.remove("axyel?");
        System.out.println(list);
    }
}
