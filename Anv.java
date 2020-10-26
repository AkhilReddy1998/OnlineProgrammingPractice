public class Anv {
    public static void main(String[] args) {
        print(23);
    }

    public int isSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null)
            return 1;

        if (root2 == null)
            return -1;

        if (areEqual(root1, root2))
            return 1;

        return Math.max(isSubtree(root2.left, root1), isSubtree(root2.right, root1));
    }

    boolean areEqual(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return root1.data == root2.data && root1.left != null && root2.left != null
                && root1.left.data == root2.left.data && root1.right != null && root2.right != null
                && root1.right.data == root2.right.data;
    }
}
