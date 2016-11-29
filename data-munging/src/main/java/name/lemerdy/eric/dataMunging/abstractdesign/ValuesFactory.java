package name.lemerdy.eric.dataMunging.abstractdesign;

import java.util.List;
import java.util.Optional;

interface ValuesFactory<T> {
    Optional<T> create(List<String> datas);
}
