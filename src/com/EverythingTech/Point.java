package com.EverythingTech;

class Point {
    private int x;
    private int y;

    Point(){
    }

    boolean setX(int x) {
        if(x > 9 || x < 0){
            return false;
        }else {
            this.x = x;
            return true;
        }
    }

    boolean setY(int y) {
        if(y > 9 || y < 0){
            return false;
        }else {
            this.y = y;
            return true;
        }
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
