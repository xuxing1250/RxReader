package com.oos_team.xuxin.rxreader.bean;

import java.util.List;

/**
 * Created by xuxin on 17-2-28.
 */

public class ImageBean {

    /**
     * error : false
     * results : [{"_id":"58b4b764421aa90efc4fb61b","createdAt":"2017-02-28T07:33:56.976Z","desc":"2-28","publishedAt":"2017-02-28T11:45:44.815Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-tumblr_om1aowIoKa1qbw5qso1_540.jpg","used":true,"who":"daimajia"},{"_id":"58b372a7421aa90f033450e0","createdAt":"2017-02-27T08:28:23.976Z","desc":"2-27","publishedAt":"2017-02-27T11:31:40.141Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-002809.jpg","used":true,"who":"daimajia"},{"_id":"58af7dca421aa957f9dd6dcc","createdAt":"2017-02-24T08:26:50.512Z","desc":"2-24","publishedAt":"2017-02-24T11:47:11.416Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-24-16906635_1749384985376684_7563808952991875072_n.jpg","used":true,"who":"daimajia"},{"_id":"58ae32e1421aa957f9dd6dbe","createdAt":"2017-02-23T08:54:57.835Z","desc":"2-23","publishedAt":"2017-02-23T11:50:23.116Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-23-16906361_1846962082218545_7116720067412230144_n.jpg","used":true,"who":"daimajia"},{"_id":"58acdc37421aa93d376f74fd","createdAt":"2017-02-22T08:32:55.801Z","desc":"2-22","publishedAt":"2017-02-22T11:43:57.286Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-22-16789541_749566998525174_1194252851069583360_n.jpg","used":true,"who":"daimajia "},{"_id":"58ab0187421aa93d3d15aa3b","createdAt":"2017-02-20T22:47:35.276Z","desc":"2-21","publishedAt":"2017-02-21T11:14:09.564Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-20-16788512_385322578500460_8844315265740046336_n.jpg","used":true,"who":"daimajia"},{"_id":"58a9752b421aa93d3d15aa31","createdAt":"2017-02-19T18:36:27.16Z","desc":"2-20","publishedAt":"2017-02-20T11:56:22.616Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-19-16789884_666922016823652_4719569931841044480_n.jpg","used":true,"who":"daimajia"},{"_id":"58a641a4421aa9662f429734","createdAt":"2017-02-17T08:19:48.413Z","desc":"2-17","publishedAt":"2017-02-17T11:31:19.996Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-17-16464474_721724277990542_654863958657728512_n.jpg","used":true,"who":"daimajia"},{"_id":"58a504d1421aa966366d05ce","createdAt":"2017-02-16T09:48:01.526Z","desc":"2-16","publishedAt":"2017-02-16T10:07:37.13Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-16-16790004_607292222809583_5160406710837313536_n.jpg","used":true,"who":"daimajia"},{"_id":"58a39d1c421aa966366d05c0","createdAt":"2017-02-15T08:13:16.351Z","desc":"2-15","publishedAt":"2017-02-15T11:24:04.127Z","source":"chrome","type":"福利","url":"http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-15-16464434_414363458902323_3665858302006263808_n.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 58b4b764421aa90efc4fb61b
         * createdAt : 2017-02-28T07:33:56.976Z
         * desc : 2-28
         * publishedAt : 2017-02-28T11:45:44.815Z
         * source : chrome
         * type : 福利
         * url : http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-tumblr_om1aowIoKa1qbw5qso1_540.jpg
         * used : true
         * who : daimajia
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
