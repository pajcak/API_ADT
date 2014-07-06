package scontainers.lists;
import scontainers.*;
/**
 *
 * @author Patrik Faistaver
 */
public interface IList<T> extends IContainer<T> {
    public T        remove  (int index);
    public boolean  remove  (T element);
    public void     replace (int index, T element);
    public IList<T> subList (int fromIndex, int toIndex);
    public T        get     (int index);
}
