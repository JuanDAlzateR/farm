package abstracts;

import interfaces.SearchName;

public abstract class AbstractList implements SearchName {

    public AbstractList(){}

    public abstract int indexOfName(String name);

}