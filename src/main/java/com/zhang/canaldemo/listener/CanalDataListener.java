package com.zhang.canaldemo.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.*;

/**
 * MySQL数据监听
 */
@CanalEventListener
public class CanalDataListener {

    /**
     * 增加监听 只有增加后的数据
     * @param eventType 当前操作的类型，增加数据
     * @param rowData 发送变更的一行数据
     */
    @InsertListenPoint
    public void onEventInsert(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            System.out.println("列名:" +column.getName() + "变更后的数据:"+column.getValue());
        }
    }

    /**
     * 修改监听
     */
    @UpdateListenPoint
    public void onEventUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getBeforeColumnsList()) {
            System.out.println("修改前列名:" +column.getName() + "修改前的数据:"+column.getValue());
        }
        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            System.out.println("修改后列名:" +column.getName() + "修改后的数据:"+column.getValue());
        }
    }
    /**
     * 删除监听
     */
    @DeleteListenPoint
    public void onEventDelete(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        for (CanalEntry.Column column : rowData.getBeforeColumnsList()) {
            System.out.println("删除前列名:" +column.getName() + "删除前的数据:"+column.getValue());
        }
    }

    /**
     * 自定义监听
     * @param eventType
     * @param rowData
     */
    @ListenPoint(destination = "example", schema = "test", table = {"tbl_label", "tb_content"}, eventType = CanalEntry.EventType.UPDATE)
    public void onEvent(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {

    }
}
