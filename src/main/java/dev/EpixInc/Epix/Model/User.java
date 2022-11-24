package dev.EpixInc.Epix.Model;

import dev.EpixInc.Epix.Enums.TypeOfUserEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne
    @JoinColumn(name = "AccountID")
    private Account account;

    @Column(name = "User_Enum")
    private TypeOfUserEnum typeOfUserEnum;

    @Column(name = "Username")
    private String username;

    @Column(name = "ProfileImageURL")
    private String profileImageURL;

    @ElementCollection
    @JoinTable(name = "MyList")
    private Collection<MyList> myListCollection = new ArrayList<MyList>();

    @ElementCollection
    @JoinTable(name = "CurrentlyWatching")
    private Collection<CurrentlyWatching> currentlyWatchingCollection = new ArrayList<CurrentlyWatching>();

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    public Collection<MyList> getMyListCollection() {
        return myListCollection;
    }

    public void setMyListCollection(Collection<MyList> myListCollection) {
        this.myListCollection = myListCollection;
    }

    public Collection<CurrentlyWatching> getCurrentlyWatchingCollection() {
        return currentlyWatchingCollection;
    }

    public void setCurrentlyWatchingCollection(Collection<CurrentlyWatching> currentlyWatchingCollection) {
        this.currentlyWatchingCollection = currentlyWatchingCollection;
    }
}
