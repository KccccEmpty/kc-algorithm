package betterBase.有序表和并查集;

import com.sun.xml.internal.ws.transport.http.HttpMetadataPublisher;

import java.util.*;

// 并查集基本数据结构
public class UnionFind {
    // 样本进来会包一层，称为元素
    public static class Element<V> {
        public V value;
        public Object object;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        // key 某个元素 value 该元素的父
        public HashMap<Element<V>, Element<V>> fatherMap;
        // key 某个集合的代表元素 value 该集合的大小
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public Element<V> findHead(Element<V> element) {
            // 记录向上找代表节点时 经过的所有节点
            Deque<Element<V>> path = new LinkedList<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            // 此时经过上面while循环，element已经是代表节点
            while (!path.isEmpty()) {
                fatherMap.put(path.poll(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return (findHead(elementMap.get(a)) == findHead(elementMap.get(b)));
            }
            return false;
        }

        public void unionSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                // 找到每个集合中的代表节点
                Element<V> aH = findHead(elementMap.get(a));
                Element<V> bH = findHead(elementMap.get(b));
                if (aH != bH) {
                    // 将集合元素少的加入到元素多的集合中
                    Element<V> big = sizeMap.get(aH) >= sizeMap.get(bH) ? aH : bH;
                    Element<V> small = big == aH ? bH : aH;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(aH) + sizeMap.get(bH));
                    sizeMap.remove(small);
                }
            }
        }
    }


}
