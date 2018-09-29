package com.example.lenovo.awersome_wanandroid_gys.bean;

import java.util.ArrayList;

public class HomeList {

    private int curPage;
    private ArrayList<Datas> datas;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;

    @Override
    public String toString() {
        return "HomeList{" +
                "curPage=" + curPage +
                ", datas=" + datas +
                ", offset=" + offset +
                ", over=" + over +
                ", pageCount=" + pageCount +
                ", size=" + size +
                ", total=" + total +
                '}';
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public ArrayList<Datas> getDatas() {
        return datas;
    }

    public void setDatas(ArrayList<Datas> datas) {
        this.datas = datas;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public HomeList(int curPage, ArrayList<Datas> datas, int offset, boolean over, int pageCount, int size, int total) {

        this.curPage = curPage;
        this.datas = datas;
        this.offset = offset;
        this.over = over;
        this.pageCount = pageCount;
        this.size = size;
        this.total = total;
    }
}
