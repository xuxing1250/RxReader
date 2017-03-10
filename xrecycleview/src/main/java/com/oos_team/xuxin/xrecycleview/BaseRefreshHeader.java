package com.oos_team.xuxin.xrecycleview;

/**
 * Created by xuxin on 17-2-27.
 */

public interface BaseRefreshHeader {
    /**
     * 刷新的四种状态
     */

    int STATE_NORMAL = 0;
    int STATE_RELEASE_TO_FRESH = 1;
    int STATE_REFRESHING = 2;
    int STATE_DONE = 3;

    void onMove(float floa);
    boolean releaseAction();
    void refreshComplate();
    int getVisiableHeight();
}
