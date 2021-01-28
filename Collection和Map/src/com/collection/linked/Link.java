package com.collection.linked;

/**
 * 该程序用来用Java程序实现一个单向链表
 * 使用的主要算法：递归
 */
public class Link{
    //首先定义一个头节点
    private Node header=null;
    private int size;
    private int count;
    //向链表末端添加方法
    public void add(Object data){
        if(header==null){
            header=new Node(data,null);
            size++;
        }else{
            Node start=new Node(data,null);
            //首先找到最后一个节点
            Node lastNode=findLastNode(header);
            //找到最后一个节点，将start赋值给最后一个节点的Node属性
            lastNode.next=start;
            size++;
        }
    }
    //这也是删除方法，不过是不用递归去实现
    public void delete(Object data){
        for(Node node=header;node != null;node=node.next){
            if(node.data == null){
                if(node==header){
                    //如果是头节点
                    Node secondNode=node.next;
                    header=secondNode;
                    node.next=null;
                    size--;
                }else if(node.next==null){
                    //如果是尾节点，则应该将尾节点的上一个节点的next属性变为null
                    Node frontNode = findFrontNode(node, header);
                    frontNode.next=null;
                    size--;
                }else{
                    //如果既不是第一个节点又不是最后一个节点
                    Node frontNode = findFrontNode(node, header);
                    frontNode=node.next;
                    node.next=null;
                    size--;
                }
            }else{
                //不为null
                if(node.data.equals(data)){
                    if(node==header){
                        //如果是头节点
                        Node secondNode=node.next;
                        header=secondNode;
                        node.next=null;
                        size--;
                    }else if(node.next==null){
                        //如果是尾节点，则应该将尾节点的上一个节点的next属性变为null
                        Node frontNode = findFrontNode(node, header);
                        frontNode.next=null;
                        size--;
                    }else{
                        //如果既不是第一个节点又不是最后一个节点
                        Node frontNode = findFrontNode(node, header);
                        frontNode=node.next;
                        node.next=null;
                        size--;
                    }
                }
            }
        }
    }
    //删除方法
    public void remove(Object data) throws DataIsNotExits {
        //首先应该找到这个节点
        Node thisNode=findNode(data,header.data,header);
        if(thisNode.equals(header)) {
            //头节点需要更换
            header=header.next;
            size--;
        }else if(thisNode.next==null){
            //如果是最后一个节点，就应该把上一个节点中的node属性变为null
            //就应该找到该节点的上一个节点
            Node frontNode=findFrontNode(thisNode,header);
            //将其next中的内存地址变为null
            frontNode.next=null;
            size--;
        }else{
            //如果所删除的节点既不是第一个节点，也不是最后一个节点
            //那么首先还是要找出上一个节点，将上一个节点的next中保存的内存地址变为
            //当前所要删除节点next中保存的内存地址
            Node frontNode=findFrontNode(thisNode,header);
            frontNode.next=thisNode.next;
            thisNode.next=null;
            size--;
        }
   }
   //判断集合中是否有某个元素
   public boolean contains(Object data) throws DataIsNotExits {
        //创建一个方法
       return containData(data,header);
   }

    /**
     * 该方法用来寻找集合当中是否包含某个元素
     * @param data
     * @param node
     * @return
     */
    private boolean containData(Object data, Node node) throws DataIsNotExits {
        if(header.data.equals(data)){
            return true;
        }else{
            //调用异常的方法
            if(node.next==null) return false;
            return containData(data,node.next);
        }

    }

    //求集合中总数的方法
    public int size(){
        return size;
    }
    //根据元素所在集合的下标，取出相应的元素
    public Object get(int index){
        //调用方法去寻找,然后返回节点中保存的数据
        count=0;
        return findByIndex(index,header).data;
    }

    /**
     * 该方法用来查询元素所在集合的下标是哪个节点
     * @param index
     * @param node
     * @return 对应节点
     */

    private Node findByIndex(int index, Node node) {
        if(count==index){
            return node;
        }else{
            //该探针加1
            count++;
            return findByIndex(index,node.next);
        }
    }


    /**
     * 该方法用来寻找当前节点的前一个节点
     * @param thisNode
     * @return 前一个节点
     */

    private Node findFrontNode(Node thisNode, Node exitsNode) {
        if(exitsNode.next==thisNode){
            return exitsNode;
        }else{
            //如果当前节点的next中保存的内存地址不等于thisNode，那么就通过当前节点中的next
            //去判断下一个节点中的next中保存的内存地址是否和thisNode保存的内存地址相等
            return findFrontNode(thisNode,exitsNode.next);
        }
    }

    /**
     * 该方法用来寻找在集合中需要被删除的元素
     * @param data
     * @param existData
     * @param node
     * @return 被删除元素所在的节点
     */
    private Node findNode(Object data, Object existData, Node node) throws DataIsNotExits {
        if (data.equals(existData)) {
            return node;
        }else{
            //如果头节点不是当前需要删除的元素，我们应该通过头节点中
            //保存的内存地址，去检验下一个节点是否是我们想要删除的元素

            exception(node);
            return findNode(data,node.next.data,node.next);
        }

    }

    /**
     * 该方法用于来处理元素找不到的异常
     */

    private void exception(Node node) throws DataIsNotExits {
        if(node.next==null){
            //自定义异常
            throw new DataIsNotExits("对不起，集合当中不存在这个元素");
        }
    }

    /**
     * 该方法用来寻找单向链表中最后一个节点
     * @return 最后一个节点
     *
     */
    private Node findLastNode(Node lastNode) {
        if(lastNode.next==null){
            return lastNode;
        }else{
            //如果现在这个节点不是尾节点，那么这个节点中的node属性
            //保存了下一个节点的内存地址，这里就可以使用递归继续查找
            return findLastNode(lastNode.next);
        }
    }
}

class Node{
    Object data;
    Node next;

    public Node() {
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
