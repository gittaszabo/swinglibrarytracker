/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Gitta Szabo
 */
public class Book {

    private int id;
    private String author;
    private String title;
    private int pages;
    private int memberId;
    private Date date;

    public Book() {
    }

    public Book(int id, String author, String title, int pages, int memberId, Date date) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.memberId = memberId;
        this.date = date;
    }

    public Book(String author, String title, int pages, int memberId, Date date) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.memberId = memberId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "id=" + id + "author=" + author + ", title=" + title + ", no of pages="
                + pages + ", memberId=" + memberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
