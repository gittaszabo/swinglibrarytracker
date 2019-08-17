/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gitta Szabo
 */
public class DBmodel implements IModel {

    private Connection conn;
    private PreparedStatement pstmtGetAllMember;
    private PreparedStatement pstmtRemoveMember;
    private PreparedStatement pstmtUpdateMember;
    private PreparedStatement pstmtAddMember;
    private PreparedStatement pstmtGetAllBook;
    private PreparedStatement pstmtRemoveBook;
    private PreparedStatement pstmtUpdateBook;
    private PreparedStatement pstmtAddBook;
    private PreparedStatement pstmtGetAllBookMember;

    public DBmodel(Connection conn) throws SQLException {
        this.conn = conn;
        pstmtGetAllMember = conn.prepareStatement("SELECT * FROM member ORDER BY name");
        pstmtRemoveMember = conn.prepareStatement("DELETE FROM member WHERE id =?");
        pstmtUpdateMember = conn.prepareCall("UPDATE member SET name=?, email=? WHERE id=?");
        pstmtAddMember = conn.prepareStatement("INSERT INTO member (name, email) VALUES (?,?)");
        pstmtGetAllBook = conn.prepareStatement("SELECT * FROM book");
        pstmtRemoveBook = conn.prepareStatement("DELETE FROM book WHERE id =?");
        pstmtUpdateBook = conn.prepareCall("UPDATE book SET author=?, title=?, pages=?, memberId=?, date=? WHERE id=?");
        pstmtAddBook = conn.prepareStatement("INSERT INTO book (author, title, pages, memberId, date) VALUES (?,?,?,?,?)");
        pstmtGetAllBookMember = conn.prepareStatement("SELECT * FROM book WHERE memberId=? ORDER BY author");
    }

    @Override
    public List<Member> getAllMember() throws SQLException {
        List<Member> members = new ArrayList<>();
        ResultSet rs = pstmtGetAllMember.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Member m = new Member(id, name, email);
            members.add(m);
        }
        rs.close();
        return members;
    }

    @Override
    public int removeMember(Member m) throws SQLException {
        pstmtRemoveMember.setInt(1, m.getId());
        return pstmtRemoveMember.executeUpdate();
    }

    @Override
    public int updateMember(Member m) throws SQLException {
        pstmtUpdateMember.setString(1, m.getName());
        pstmtUpdateMember.setString(2, m.getEmail());
        pstmtUpdateMember.setInt(3, m.getId());
        return pstmtUpdateMember.executeUpdate();
    }

    @Override
    public int addMember(Member m) throws SQLException {
        pstmtAddMember.setString(1, m.getName());
        pstmtAddMember.setString(2, m.getEmail());
        return pstmtAddMember.executeUpdate();
    }

    @Override
    public List<Book> getAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();

        ResultSet rs = pstmtGetAllBook.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            int pages = rs.getInt("pages");
            int memberId = rs.getInt("memberId");
            Date date = rs.getDate("date");

            Book b = new Book(id, author, title, pages, memberId, date);
            books.add(b);
        }
        rs.close();
        return books;
    }

    @Override
    public int removeBook(Book b) throws SQLException {
        pstmtRemoveBook.setInt(1, b.getId());
        return pstmtRemoveBook.executeUpdate();
    }

    @Override
    public int updateBook(Book b) throws SQLException {
        pstmtUpdateBook.setString(1, b.getAuthor());
        pstmtUpdateBook.setString(2, b.getTitle());
        pstmtUpdateBook.setInt(3, b.getPages());
        pstmtUpdateBook.setInt(4, b.getMemberId());
        if (b.getDate() != null) {
            pstmtUpdateBook.setDate(5, new java.sql.Date(b.getDate().getTime()));
        } else {
            pstmtUpdateBook.setDate(5, null);
        }
        pstmtUpdateBook.setInt(6, b.getId());
        return pstmtUpdateBook.executeUpdate();
    }

    @Override
    public int addBook(Book b) throws SQLException {
        pstmtAddBook.setString(1, b.getAuthor());
        pstmtAddBook.setString(2, b.getTitle());
        pstmtAddBook.setInt(3, b.getPages());
        pstmtAddBook.setInt(4, b.getMemberId());
        pstmtAddBook.setDate(5, (java.sql.Date) b.getDate());
        return pstmtAddBook.executeUpdate();
    }

    @Override
    public Map<Integer, Member> memberMap() throws SQLException {
        List<Member> members = getAllMember();
        Map<Integer, Member> tagMap = new HashMap<>();
        for (Member m : members) {
            tagMap.put(m.getId(), m);
        }
        return tagMap;
    }

    @Override
    public List<Book> getAllBook(Member m) throws SQLException {
        pstmtGetAllBookMember.setInt(1, m.getId());
        ResultSet rs = pstmtGetAllBookMember.executeQuery();

        List<Book> memberBooks = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String author = rs.getString("author");
            String title = rs.getString("title");
            int pages = rs.getInt("pages");
            int memberId = rs.getInt("memberId");
            Date date = rs.getDate("date");
            Book b = new Book(id, author, title, pages, memberId, date);
            memberBooks.add(b);
        }
        rs.close();
        return memberBooks;
    }

    @Override
    public void exportToFile(File f) throws Exception {
        PrintWriter pw = new PrintWriter(new FileWriter(f));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        List<Member> members = getAllMember();
        List<Book> books = getAllBook();

        pw.println("id;name;email");
        for (Member m : members) {
            pw.println(m.getId() + ";" + m.getName() + ";" + m.getEmail());
        }

        pw.println("id;author;title;pages;memberId;dueDate");
        for (Book b : books) {
            pw.println(b.getId() + ";" + b.getAuthor() + ";" + b.getTitle()
                    + ";" + b.getPages() + ";" + b.getMemberId() + ";" + (b.getDate() == null ? "" : sdf.format(b.getDate())));
        }
        pw.close();
    }

    @Override
    public Map<Integer, Book> bookMap() throws SQLException {
        List<Book> books = getAllBook();
        Map<Integer, Book> bookMap = new HashMap<>();
        for (Book b : books) {
            bookMap.put(b.getId(), b);
        }
        return bookMap;
    }
}
