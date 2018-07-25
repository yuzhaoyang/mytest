package consistHash.noVirtual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.CRC32;

/**
 * 一致性hash实现（数据结构：list）（服务器没有虚拟化）
 * 一致性hash的真正数据结构是二叉树
 */
public class ConsistentHash {
    private List<ServerNode> servers = new ArrayList<ServerNode>();//存放服务器
    
    /** 计算服务器和存储的键的hash值 */
    public long hash(String str){
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }
    
    /**
     * 添加server到环上
     * @param serverName ip:port
     */
    public void addServer(String serverName){

        ServerNode node = new ServerNode();
        node.setServerName(serverName);
        node.setServerHash(hash(serverName));
        
        servers.add(node);
        Collections.sort(servers, new ServerComparator());
    }
    
    /**
     * 从环上删除server节点
     */
    public void deleteServer(String serverName){

        ServerNode node = new ServerNode();
        node.setServerName(serverName);
        
        servers.remove(node);
    }
    
    /**
     * 获取一个缓存key应该存放的位置
     * @param cachekey 缓存的key
     * @return 缓存的服务器节点
     */
    public ServerNode getServer(String cachekey){
        long keyHash = hash(cachekey);
        
        for(ServerNode node : servers){
            if(keyHash<=node.getServerHash()){
                return node;
            }
        }
        
        return servers.get(0);//如果node没有合适放置位置，放在第一台服务器上去
    }
    
    /****************测试*******************/
    public void printServers(){
        for(ServerNode server : servers){
            System.out.println(server.getServerName()+"-->"+server.getServerHash());
        }
    }
    
    public static void main(String[] args) {
        ConsistentHash ch = new ConsistentHash();
        ch.addServer("127.0.0.1:11211");
        ch.addServer("127.0.0.1:11212");
        ch.addServer("127.0.0.2:11211");
        ch.addServer("127.0.0.2:11212");
        
        ch.printServers();
        
        ServerNode node = ch.getServer("hello");
        System.out.println(ch.hash("hello")+"-->"+node.getServerName()+"-->"+node.getServerHash());
        
        ServerNode node2 = ch.getServer("name");
        System.out.println(ch.hash("name")+"-->"+node2.getServerName()+"-->"+node2.getServerHash());
        
        ServerNode node3 = ch.getServer("a");
        System.out.println(ch.hash("a")+"-->"+node3.getServerName()+"-->"+node3.getServerHash());
        
        /********************删除节点*********************/
        ch.deleteServer("127.0.0.1:11212");
        ch.printServers();
        
        ServerNode node0 = ch.getServer("hello");
        System.out.println(ch.hash("hello")+"-->"+node0.getServerName()+"-->"+node0.getServerHash());
        
        ServerNode node02 = ch.getServer("name");
        System.out.println(ch.hash("name")+"-->"+node02.getServerName()+"-->"+node02.getServerHash());
        
        ServerNode node03 = ch.getServer("a");
        System.out.println(ch.hash("a")+"-->"+node03.getServerName()+"-->"+node03.getServerHash());
        
    }
}