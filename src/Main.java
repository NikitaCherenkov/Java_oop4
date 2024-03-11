import collections.GBList;
import collections.lists.GBLinkedList;

public class Main {
    public static void main(String[] args) {
        GBList<Integer> gbl = new GBLinkedList<>();
        gbl.add(15);
        gbl.add(155);
        gbl.add(1125);
        gbl.add(1, 80000);
        System.out.println(gbl.size());
        System.out.println(gbl);
        gbl.remove(1125);
        System.out.println(gbl.size());
        System.out.println(gbl);
        gbl.removeIndex(gbl.size() - 1);
        System.out.println(gbl);
    }
}
