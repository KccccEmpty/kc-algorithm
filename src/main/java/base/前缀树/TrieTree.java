package base.前缀树;

public class TrieTree {

    // 前缀树节点数据结构
    // 字符表示在路径上，而不是在节点上
    public static class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            // nexts[0] == null 表示没有走向 'a' 的路
            // nexts[0] != null 表示有走向 'a' 的路
            // ...
            // nexts[25] != null 表示有走向 'z' 的路
            // 此处只表示26个小写字母， 若要表示更多字符，可以采用哈希表 HashMap<Char, Node> nexts;
            nexts = new TrieNode[26];

        }
    }

    // 实现前缀树
    public static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 插入新的字符串
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            for (char ch : chars) {
                // 减去a的ASCII值得到相对大小
                int index = ch - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        // 删除字符串
        public void delete(String word) {
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                TrieNode node = root;
                int index;
                for (char ch : chars) {
                    index = ch - 'a';
                    node.pass--;
                    // 如果发现到某个节点的pass为0了，要置该节点为null，相当于把后续节点也删除
                    if (node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        // 查找word之前加入过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index;
            for (char ch : chars) {
                index = ch - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 所有加入的字符串中，有几个字符串是以 pre 为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char ch : chars) {
                index = ch - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

    }
}
