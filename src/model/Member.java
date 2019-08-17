/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Gitta Szabo
 */
public class Member {

    private int id;
    private String name;
    private String email;

    public Member() {
    }

    public Member(String nev, String email) {
        this.name = nev;
        this.email = email;
    }

    public Member(int id, String nev, String email) {
        this.id = id;
        this.name = nev;
        this.email = email;
    }

    @Override
    public String toString() {
        if (id == 0) {
            return name;
        } else {
            return name + " (" + email + ")";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
