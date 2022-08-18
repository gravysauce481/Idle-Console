package producer;

import item.Item;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Producer
{
    protected ArrayList<Item> producingItems = new ArrayList<>();
    protected int itemSlots = 2;
    protected int maxItemSlots = 7;
    private final float price;

    protected Producer(float price)
    {
        this.price = price;
    }

    public float getPrice()
    {
        return price;
    }

    public void addProducingItem(Item item) throws IndexOutOfBoundsException
    {
        if (producingItems.size() + 1 > itemSlots)
        {
            throw new IndexOutOfBoundsException();
        }
        producingItems.add(item);
    }

    public void setProducingItems(int index, Item producingItem)
    {
        producingItems.set(index, producingItem);
    }

    public Item getProducingItem(int index)
    {
        return producingItems.get(index);
    }
}
