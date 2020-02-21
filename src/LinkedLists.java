/**
 * 类作用:
 * 类说明:
 *
 * @author 彭继工
 * @date 2020 - 02 - 21:12:09
 */
public class LinkedLists {
    public static void main(String[] args) {
        System.out.println("测试语句");
    }
}

class TreeNode<T> {
    /**
     * type 类型
     */
    public T type;
    /**
     * 二叉树左节点
     */
    private TreeNode leftNode;
    /**
     * 二叉树右节点
     */
    private TreeNode rightNode;


    @Override
    public String toString() {
        return "TreeNode{" +
                "type=" + type +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    public void add(T object) {
        if (null != this.type) {
            this.rightNode = new TreeNode();
            this.rightNode.type = object;
        } else {
            this.type = object;
        }
    }
}