public class BST<E extends Comparable<E>> {
    //    left < root, right > root; 先定义该二分搜索树不包含重复元素
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
    //    向二分搜索树中添加新的元素
        public void add(E e){
            if(root == null){
                root = new Node(e);
                size++;
            }
            else
                add(root, e);
        }

    //    调用递归完成对二叉树插入元素， 以node为根的左右孩子插入元素e
        private void add(Node node, E e){
    //        递归终止条件；
            if(node.e == e)
                return ;
            else if(e.compareTo(node.e) < 0 && node.left == null){
                node.left = new Node(e);
                size++;
                return ;
            } else if (e.compareTo(node.e) > 0 && node.right == null) {
                node.right = new Node(e);
                size++;
                return ;
            }

            if(e.compareTo(node.e) < 0)
                add(node.left, e);
            else
                add(node.right, e);
        }*/
    public void add(E e) {
        root = add(root, e);
    }

    //    返回插入新节点后二分搜索树的根， 就是插在node这个根节点位置， 而不是其左右孩子
    private Node add(Node node, E e) {
        if (node == null) {
            ++size;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

/*
//   错误代码
    private void add(Node node, E e){
        if(node == null){
            size++;
            node = new Node(e);
            return ;
        }
        if(e.compareTo(node.e) < 0)
            add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            add(node.right, e);
    }
 */
    //查询二分搜索树中是否还有该元素
    public boolean contains(E e){
        return contains(root, e);
    }

    //看以node为根的二分搜索树中是否含有元素e，递归算法
    private boolean contains(Node node, E e){
        if(node == null)
            return false;
        if(e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }else
            return contains(node.right, e);
    }

    //二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    //前序  遍历以node为根的二分搜索树， 递归算法
    private void preOrder(Node node){
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
}
