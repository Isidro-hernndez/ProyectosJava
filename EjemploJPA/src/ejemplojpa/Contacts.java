/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thank
 */
@Entity
@Table(name = "contacts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacts.findAll", query = "SELECT c FROM Contacts c"),
    @NamedQuery(name = "Contacts.findByIDContact", query = "SELECT c FROM Contacts c WHERE c.iDContact = :iDContact"),
    @NamedQuery(name = "Contacts.findByName", query = "SELECT c FROM Contacts c WHERE c.name = :name"),
    @NamedQuery(name = "Contacts.findByEmail", query = "SELECT c FROM Contacts c WHERE c.email = :email"),
    @NamedQuery(name = "Contacts.findByPhone", query = "SELECT c FROM Contacts c WHERE c.phone = :phone")})
public class Contacts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Contact")
    private Integer iDContact;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;

    public Contacts() {
    }

    public Contacts(Integer iDContact) {
        this.iDContact = iDContact;
    }

    public Contacts(Integer iDContact, String name, String email, String phone) {
        this.iDContact = iDContact;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getIDContact() {
        return iDContact;
    }

    public void setIDContact(Integer iDContact) {
        this.iDContact = iDContact;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDContact != null ? iDContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacts)) {
            return false;
        }
        Contacts other = (Contacts) object;
        if ((this.iDContact == null && other.iDContact != null) || (this.iDContact != null && !this.iDContact.equals(other.iDContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejemplojpa.Contacts[ iDContact=" + iDContact + " ]";
    }
    
}
