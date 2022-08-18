package item;

public abstract class Item
{
    private final float baseValue;

    protected Item(float baseValue)
    {
        this.baseValue = baseValue;
    }

    public float getBaseValue()
    {
        return baseValue;
    }
}