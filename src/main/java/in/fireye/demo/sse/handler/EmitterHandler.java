package in.fireye.demo.sse.handler;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * sse
 * 发射器处理
 *
 * @author <a href="mailto:sby@servyou.com.cn">ben</a>
 * @date 2019-01-07 11:45
 **/
public class EmitterHandler {

  public static final ConcurrentMap<String, SseEmitter> EMITTER_MAP = new ConcurrentHashMap<String, SseEmitter>(16);


  public static <T> void send(String id,T msg) throws IOException {
    SseEmitter sseEmitter = EMITTER_MAP.get(id);
    if(null == sseEmitter){
      throw new NullPointerException("id为{"+id+"}的SseEmitter不存在");
    }
    sseEmitter.send(
      SseEmitter.event()
        .data(msg, MediaType.APPLICATION_JSON_UTF8)
        .build()
    );
  }

  public static void add(String id,SseEmitter sseEmitter){
    EMITTER_MAP.put(id,sseEmitter);
  }
}
