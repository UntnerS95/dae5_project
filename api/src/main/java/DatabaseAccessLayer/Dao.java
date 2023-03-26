package DatabaseAccessLayer;

import java.util.List;
import java.util.Optional;

/**
 * Interface for the default methods of a DAO implementation.
 *
 * @param <T> The model class for which the DAO should be implemented.
 * @author Stefan Untner (S2010306033)
 */
public interface Dao<T> {
  boolean delete(T t);

  Optional<List<T>> getAll();

  Optional<T> getById(int id);

  boolean save(T t);

  boolean update(T t);
}
