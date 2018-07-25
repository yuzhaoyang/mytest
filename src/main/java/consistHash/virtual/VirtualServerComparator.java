package consistHash.virtual;

import java.util.Comparator;

/**
 * 虚拟节点比较器
 */
public class VirtualServerComparator implements Comparator<VirtualServerNode> {

    public int compare(VirtualServerNode node1, VirtualServerNode node2) {
        if(node1.getVirtualServerHash() <= node2.getVirtualServerHash()) {
            return -1;
        }
        return 1;
    }

}