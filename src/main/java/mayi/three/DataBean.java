package mayi.three;/**
 * @Project:httpLearn
 * @PackageName:mayi
 * @Author: Sprite
 * @DateTime:2018/9/14 15:18.
 * @Description:
 */

/**
 * Sprite
 * 数据对象
 **/

public class DataBean {
    private String id;
    private long groupId;
    private float quota;

    public DataBean(){
        super();
    }
    public DataBean(String content) {
        this();
        String[] strings = content.split(",");
        setId(strings[0]);
        setGroupId(Long.parseLong(strings[1]));
        setQuota(Float.parseFloat(strings[2]));
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public float getQuota() {
        return quota;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        StringBuffer buffer=new StringBuffer();
        buffer.append(groupId).append(",").append(id).append(",").append(quota);
        return buffer.toString();
    }
}
