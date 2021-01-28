package com.doublelinked;
/**
 * 用java程序来实现一个双向链表
 * @author fmk
 * @date 2020/5/6
 **/
public class DoubleLinkList {
    private Node first;
    private Node last;
    private int size;
    private int modCount;

    /**
     * 通过下标来移除元素
     * @param index
     * @return
     */
    public Object remove(int index){
        modCount=0;
        for(Node node=first;node != null;node=node.next){
            if(index==(modCount++)){
                removeElement(node);
                return node.data;
            }
        }
        return null;
    }
    /**
     * 这个方法用来移除集合中的元素
     * @param obj
     * @return 返回要被删除的元素
     * @throws CannotFindElementException
     */
    public Object remove(Object obj) throws CannotFindElementException {
        // 这是遍历所有节点
        for(Node node=first;node != null;node=node.next){
            return findNode(node);
            /*final Node next=node.next;
            final Node previous=node.previous;
            if(node.previous == null && node.data.equals(obj)){
                // 说明删除元素是第一个节点
                next.previous=null;
                first=next;
                size--;
                return node.data;
            }else if(node.next==null && node.data.equals(obj)){
                // 说明是最后一个节点
                previous.next=null;
                last=previous;
                size--;
                return node.data;
            }else if(node.data.equals(obj)){
                // 将要删除元素节点保存上一个节点内存地址放在该删除节点下一个节点的previous属性上
                next.previous=previous;
                previous.next=next;
                size--;
                return node.data;
            }*/
        }
        throw new CannotFindElementException("对不起，找不到元素");
    }

    private Object findNode(Node node) {
        final Node next=node.next;
        final Node previous=node.previous;
        if(node.previous == null){
            next.previous=null;
            first=next;
            size--;
            return node.data;
        }else if(node.next==null ){
            // 说明是最后一个节点
            previous.next=null;
            last=previous;
            size--;
            return node.data;
        }else{
            // 将要删除元素节点保存上一个节点内存地址放在该删除节点下一个节点的previous属性上
            next.previous=previous;
            previous.next=next;
            size--;
            return node.data;
        }


    }

    public Object remove1(Object obj) {
        if (obj == null) {
            for (Node node = first; node != null; node = node.next) {
                if (node.data == null) {
                    removeElement(node);
                    return null;
                }
            }
        }else{
            for (Node node = first; node != null; node = node.next) {
                if (node.data.equals(obj)) {
                    removeElement(node);
                    return node.data;
                }
            }
        }
        return null;
    }
    /**
     * 这是一个添加方法
     * @param obj
     */
    public boolean add(Object obj){
        // 因为有两个指向节点，所以就不用找最后一个节点了
        // 创建的节点就变成新的最后一个节点，之前最后一个节点，应该在新节点上一个节点的位置
        Node l=last;
        Node newNode = new Node(last,obj,null);
        // 将此时这个节点作为最后一个节点即可
        last=newNode;
        if(l == null ){
            // 如果最后一个节点等于null,这就说明还没有元素，所以第一个节点也是该元素
            first=newNode;
        }else{
            // 原本最后一个节点的next属性为Null,但是现在应该为新节点的内存地址
            l.next=newNode;
        }
        size++;
        return true;
    }
    public int size() {
        return size;
    }
    /**
     * 这是一个get方法
     * @param index
     * @return 返回集合中的元素
     */
    public Object get(int index) {
        modCount=0;
        if(index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(Node node=first;node != null;node=node.next){
            if(modCount==index){
                return node.data;
            }
            modCount++;
        }
        return last.data;
    }
    private void removeElement(Node node) {
        final Node previous=node.previous;
        final Node next=node.next;

        if(previous==null){
            // 如果这个节点是第一个节点
            first=next;
        }else{
            previous.next=next;
            node.next=null;
        }
        if(next==null){
            //如果这个节点是最后一个节点
            last=previous;
        }else{
            next.previous=previous;
            node.previous=null;
        }
        size--;

    }
}
