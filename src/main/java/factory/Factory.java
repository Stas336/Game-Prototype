package factory;

import item.types.Item;

public interface Factory<T extends Item>
{
    T newItem();
}