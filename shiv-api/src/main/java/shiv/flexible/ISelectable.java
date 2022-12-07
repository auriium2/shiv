package shiv.flexible;

/**
 * marker interface marking another interface as "selectable", or fit for use with TypedSelect.
 * TypedSelect will select only ISelectables who have a type parameter <T> matching the type parameter provided
 */
public interface ISelectable<T> {
}
