/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gitta Szabo
 */
public interface IModel {
    List<Member> getAllMember() throws SQLException;      
    int removeMember(Member t) throws SQLException;   
    int updateMember(Member t) throws SQLException;
    int addMember(Member t) throws SQLException;
    
    List<Book> getAllBook() throws SQLException;
    int removeBook(Book k) throws SQLException;
    int updateBook(Book k) throws SQLException;
    int addBook(Book k) throws SQLException;
    
    Map<Integer,Member> memberMap() throws SQLException;
    Map<Integer,Book> bookMap() throws SQLException;
    List<Book> getAllBook(Member t) throws SQLException;
    void exportToFile(File f) throws Exception;   
}
