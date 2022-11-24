package dev.EpixInc.Epix.Model;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MyList {

    @ManyToOne
    @JoinColumn(name = "item_ID")
    private Item items;

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }
}
