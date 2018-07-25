package consistHash.noVirtual;

/**
 * server节点
 */
public class ServerNode {
    private String serverName;
    private long serverHash;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public long getServerHash() {
        return serverHash;
    }

    public void setServerHash(long serverHash) {
        this.serverHash = serverHash;
    }

    /**
     * 下边重写hashcode()和equals()是为了在删除节点的时候只根据传入的serverName删除即可
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((serverName == null) ? 0 : serverName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ServerNode other = (ServerNode) obj;
        if (serverName == null) {
            if (other.serverName != null)
                return false;
        } else if (!serverName.equals(other.serverName))
            return false;
        return true;
    }
    
    
}