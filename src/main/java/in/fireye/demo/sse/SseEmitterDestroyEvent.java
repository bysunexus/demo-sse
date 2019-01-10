package in.fireye.demo.sse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import static in.fireye.demo.sse.handler.EmitterHandler.EMITTER_MAP;

/**
 * sse
 * 发射器销毁事件
 *
 * @author <a href="mailto:sby@servyou.com.cn">ben</a>
 * @date 2019-01-10 11:20
 **/
public class SseEmitterDestroyEvent implements Runnable {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private String id;
  private SseEmitter emitter;

  public SseEmitterDestroyEvent(String id, SseEmitter emitter) {
    this.id = id;
    this.emitter = emitter;
  }

  @Override
  public void run() {
    logger.info("remove {} emitter",id);
    EMITTER_MAP.remove(id);
    emitter.complete();
  }
}
