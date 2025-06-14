package com.step05.problem08;

public class Node {
    private String date;
    private EnvironmentData data;
    private Node left;
    private Node right;

    public Node(EnvironmentData data) {
        this.date = data.getDateTime().split(" ")[0];
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(EnvironmentData data) {
        this.data = data;
    }

    public EnvironmentData getData() {
        return data;
    }

    public void updateEnvironmentData(EnvironmentData data) {
        this.data = data;
    }
}

