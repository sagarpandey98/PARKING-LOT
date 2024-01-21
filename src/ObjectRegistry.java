import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectRegistry {
    private Map<String, Objects> objectsMap = new HashMap<>();
    public void register(String name, Object object) {
        objectsMap.put(name, (Objects) object);
    }

    public Objects get(String name){
        return objectsMap.get(name);
    }


}
