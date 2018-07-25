package consistHash.noVirtual;

import java.util.Comparator;

/**
 * 服务器排序比较器
 */
public class ServerComparator implements Comparator<ServerNode> {

    public int compare(ServerNode node1, ServerNode node2) {
        if(node1.getServerHash() <= node2.getServerHash()) {
            return -1;//node1<node2
        }
        return 1;//node1>node2
    }

}