package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item")
    private Order order;

    private int orderPrice;
    private int count;

    // business logic
    // cancel order
    public void cancel() {
        getItem().addStock(count);
    }

    // lookup logic
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
