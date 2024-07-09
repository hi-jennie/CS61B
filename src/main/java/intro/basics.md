## hashset and LinkedHashSet
difference between hashset and LinkedHashSet
- HashSet does not maintain any order of elements.
- LinkedHashSet maintains the insertion order of elements.

```java
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        // 遍历集合
        for (String fruit : set) {
            System.out.println(fruit);
        }
        // output:Banana
        //        Apple
        //        Orange
        
        set.remove("Apple");
    }
}
```
```java
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");

        // 遍历集合
        for (String fruit : set) {
            System.out.println(fruit);
        }
    }
}
```

## hashmap
* A Map cannot contain duplicate keys. If we try to add a key already in the map, the value is overwritten.
* Maps cannot directly be used with the ":"for loop. Typically, we call **keySet** to iterate over a set of the keys, and use those to retrieve the values. 
One may also iterate over the entrySet to get both the keys and values.
```java
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", "18");
        map.get("name");
        map.remove("name");
        map.size();
        // get all keys and judge if the key exists
        map.keySet().contains("name");
    }
}
```
## treeMap
```java

```