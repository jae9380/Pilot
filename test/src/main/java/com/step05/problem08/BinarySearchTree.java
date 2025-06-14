package com.step05.problem08;

public class BinarySearchTree {

    private Node root;

    public void insert(EnvironmentData data) {
        root = insertRec(root, data);
    }

    public EnvironmentData getByDate(String date) {
        return search(date).getData();
    }

    public Node search(String date) {
        return searchRec(root, date);
    }

    public boolean update(String date, EnvironmentData newData) {
        Node node = search(date);
        if (node != null) {
            node.setData(newData); // 기존 노드에 새로운 데이터만 설정
            return true;
        }
        return false;
    }

    private Node insertRec(Node root, EnvironmentData data) {
        String date = data.getDate();
        if (root == null) {
            return new Node(data);
        }
        if (date.compareTo(root.getDate()) < 0) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else if (date.compareTo(root.getDate()) > 0) {
            root.setRight(insertRec(root.getRight(), data));
        }
        return root;
    }

    private Node searchRec(Node root, String date) {
        if (root == null || root.getDate().equals(date)) {
            return root;
        }
        if (date.compareTo(root.getDate()) < 0) {
            return searchRec(root.getLeft(), date);
        }
        return searchRec(root.getRight(), date);
    }
}
