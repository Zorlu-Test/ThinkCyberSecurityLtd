package com.ThinkCyberSecurity.pages;

public class Pages {


    private DashBoard dashBoard;
    private Methods methods;


    public DashBoard dashBoard() {
        if (dashBoard == null) {
            dashBoard = new DashBoard();
        }
        return dashBoard;
    }

    public Methods methods() {
        if (methods == null) {
            methods = new Methods();
        }
        return methods;
    }



}
