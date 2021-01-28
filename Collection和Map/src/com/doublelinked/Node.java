package com.doublelinked;

/**
 * @author fmk
 * @date 2020/5/6
 **/
// 节点由三部分组成
public class Node {
    Node previous;
    Object data;
    Node next;

    public Node() {
    }

    public Node(Node previous, Object data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

}


