package scontainers;

/**
 *
 * @author Patrik Faistaver
 */
public interface IContainer<T> {
    public int      getSize  ();
    public void     clear    ();
    public void     add      (T elem);
    public boolean  contains (T elem);
    public boolean  isEmpty  ();
}
