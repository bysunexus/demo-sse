package in.fireye.demo.sse.dto;

import java.io.Serializable;

/**
 * sse
 * 发送请求
 *
 * @author <a href="mailto:sby@servyou.com.cn">ben</a>
 * @date 2019-01-10 11:36
 **/
public class SendReq implements Serializable {
  private static final long serialVersionUID = 2224730460619875130L;
  private String id;
  private String event;

  private String name;
  private String msg;

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
