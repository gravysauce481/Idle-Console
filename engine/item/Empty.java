package item;

public class Empty extends Item
{
    private final Item old;

    public Empty(Item old)
    {
        super(old.getBaseValue());
        this.old = old;
    }

    public Item getOld()
    {
        return old;
    }
}