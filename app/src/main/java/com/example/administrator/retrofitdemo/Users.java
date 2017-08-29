package com.example.administrator.retrofitdemo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Users {

    /**
     * code : 1
     * message : success
     * result : {"items":[{"detail":"","href":"https://www.oschina.net/osc-aliyun-yunqi/?s=osc","id":0,"img":"https://static.oschina.net/uploads/space/2017/0828/170541_ttPr_2686220.jpg","name":"2017年杭州云栖大会","pubDate":"2017-08-28 17:06:49","type":0},{"detail":"","href":"https://www.oschina.net/event/2264168","id":2264168,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_69600bc5-c1b6-40de-9e61-8ad4e19d7907.jpg","name":"源创会 | 成都站开始报名啦！","pubDate":"2017-08-25 10:27:49","type":5},{"detail":"","href":"https://www.oschina.net/question/2720166_2264499","id":2264499,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_054b51e8-92da-4af1-b72d-d476be52f491.jpg","name":"高性能 RPC 开发框架 Tars","pubDate":"2017-08-25 10:19:01","type":2},{"detail":"","href":"https://my.oschina.net/gitosc/blog/1523633","id":1523633,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_edc29b65-379e-4f61-9fed-7028a009994e.jpg","name":"漫谈 6 款实用企业应用框架","pubDate":"2017-08-28 14:17:18","type":3},{"detail":"","href":"https://www.oschina.net/news/87686/programmer-clock","id":87686,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_3bd2c850-c8cb-4a35-9460-7dadac1f05a3.jpg","name":"只有程序员才能看懂的时钟","pubDate":"2017-08-17 10:44:40","type":6}],"nextPageToken":"61AF0C190D6BD629","prevPageToken":"3EA621243546C8A5","requestCount":5,"responseCount":5,"totalResults":5}
     * time : 2017-08-29 16:42:47
     */

    private int code;
    private String message;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static class ResultBean {
        /**
         * items : [{"detail":"","href":"https://www.oschina.net/osc-aliyun-yunqi/?s=osc","id":0,"img":"https://static.oschina.net/uploads/space/2017/0828/170541_ttPr_2686220.jpg","name":"2017年杭州云栖大会","pubDate":"2017-08-28 17:06:49","type":0},{"detail":"","href":"https://www.oschina.net/event/2264168","id":2264168,"img":"https://static.oschina.net/uploads/cooperation/75323/ubuntu-forum-black-sql_69600bc5-c1b6-40de-9e61-8ad4e19d7907.jpg","name":"源创会 | 成都站开始报名啦！","pubDate":"2017-08-25 10:27:49","type":5},{"detail":"","href":"https://www.oschina.net/question/2720166_2264499","id":2264499,"img":"https://static.oschina.net/uploads/cooperation/78083/chrome55-save-at-least-35-percent-memory_054b51e8-92da-4af1-b72d-d476be52f491.jpg","name":"高性能 RPC 开发框架 Tars","pubDate":"2017-08-25 10:19:01","type":2},{"detail":"","href":"https://my.oschina.net/gitosc/blog/1523633","id":1523633,"img":"https://static.oschina.net/uploads/cooperation/78455/intellij-idea-2016-3-public-preview_edc29b65-379e-4f61-9fed-7028a009994e.jpg","name":"漫谈 6 款实用企业应用框架","pubDate":"2017-08-28 14:17:18","type":3},{"detail":"","href":"https://www.oschina.net/news/87686/programmer-clock","id":87686,"img":"https://static.oschina.net/uploads/cooperation/75410/google-beta-natural-language-api_3bd2c850-c8cb-4a35-9460-7dadac1f05a3.jpg","name":"只有程序员才能看懂的时钟","pubDate":"2017-08-17 10:44:40","type":6}]
         * nextPageToken : 61AF0C190D6BD629
         * prevPageToken : 3EA621243546C8A5
         * requestCount : 5
         * responseCount : 5
         * totalResults : 5
         */

        private String nextPageToken;
        private String prevPageToken;
        private int requestCount;
        private int responseCount;
        private int totalResults;
        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * detail :
             * href : https://www.oschina.net/osc-aliyun-yunqi/?s=osc
             * id : 0
             * img : https://static.oschina.net/uploads/space/2017/0828/170541_ttPr_2686220.jpg
             * name : 2017年杭州云栖大会
             * pubDate : 2017-08-28 17:06:49
             * type : 0
             */

            private String detail;
            private String href;
            private int id;
            private String img;
            private String name;
            private String pubDate;
            private int type;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
