package in.fireye.demo.sse.controller;

import in.fireye.demo.sse.SseEmitterDestroyEvent;
import in.fireye.demo.sse.dto.SendReq;
import in.fireye.demo.sse.handler.EmitterHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

/**
 * sse
 * sse测试类
 *
 * @author <a href="mailto:sby@servyou.com.cn">ben</a>
 * @date 2019-01-03 18:29
 **/
@RestController
public class SseController {

  @RequestMapping("/register/{id}")
  public SseEmitter register(@PathVariable String id) throws IOException {
    SseEmitter sseEmitter = new SseEmitter(60000L);
    SseEmitterDestroyEvent destroyEvent = new SseEmitterDestroyEvent(id, sseEmitter);
    sseEmitter.onCompletion(destroyEvent);
    sseEmitter.onTimeout(destroyEvent);
    EmitterHandler.add(id,sseEmitter);
    return sseEmitter;
  }


  @RequestMapping("/send")
  public void send(@RequestBody SendReq req) throws IOException {
    EmitterHandler.send(req.getId(),req);
  }
}
