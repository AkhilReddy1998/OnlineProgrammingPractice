public class FindKthelement {
    public static void main(String[] args) {
        addLast(10);
        addLast(20);
        addLast(30);
        addLast(40);
        addLast(50);
        print();
        int k = 30;
        System.out.println(scan(first, 1, k));
    }

    static int length_of_list = 0;

    private static int scan(Node head, int counter, int k) {
        if (head != null)
            scan(head.next, counter + 1, k);
        else {
            length_of_list = counter;
        }
        if (k + counter + 1 == length_of_list)
            return head.value;
        return 0;
    }

    static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;

        }
    }

    public static Node first, last;

    public static void addLast(int item) {
        var new_node = new Node(item);

        if (first == null)
            first = last = new_node;
        else {
            last.next = new_node;
            last = new_node;
        }
    }

    public static void print() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
