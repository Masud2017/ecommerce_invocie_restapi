package com.ecommerce.invoice_restapi.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fname", nullable = false)
    private String firstName;
    @Column(name = "lname", nullable = false)
    private String lastName;
    // @JsonIgnore
    @Column(name = "password" , nullable = false)
    private String password;
    @Column(name = "email", nullable =  false)
    private String email;
    @Column(name = "verification_code")
    private String verificationCode;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    // one to one relation ship with userAddress model
    // @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    // @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private UserAddress userAddress;

    @OneToMany(mappedBy = "user")
    // @JsonManagedReference
    @JsonIgnore
    private Set<InvoiceInfo> invoiceInfo;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAddress getUserAddress() {
        return this.userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<InvoiceInfo> getInvoiceInfo() {
        return this.invoiceInfo;
    }

    public void setInvoiceInfo(Set<InvoiceInfo> invoiceInfo) {
        this.invoiceInfo = invoiceInfo;
    }


}
