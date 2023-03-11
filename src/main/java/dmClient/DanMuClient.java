package dmClient;

import java.net.InetSocketAddress;
import java.util.List;

import javax.swing.text.BadLocationException;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import com.alibaba.fastjson2.JSONObject;

public class DanMuClient extends WebSocketServer {

	public DanMuClient(int port) {
		// TODO Auto-generated constructor stub
		super(new InetSocketAddress(port));
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		//某鱼直播
		if (message.contains("type@=chatmsg")) {
			String name = message.split("nn@=")[1].split("/txt@=")[0];
			String content = message.split("txt@=")[1].split("/cid@=")[0];
			String s = "D站[" + name + "]说：" + content + "\n\n";
			body.textArea.append(s);
		}
		//某哩直播
		if (message.contains("\"DANMU_MSG\"")) {
			JSONObject parseObject = JSONObject.parseObject(message);
			@SuppressWarnings("unchecked")
			List<Object> li = (List<Object>) parseObject.get("info");
			@SuppressWarnings("unchecked")
			List<Object> li2 = (List<Object>) li.get(2);
			String name = (String) li2.get(1);
			String content = (String) li.get(1);
			String s = "B站[" + name + "]说：" + content + "\n\n";
			body.textArea.append(s);
			// 文本添加后，文本区域立即刷新
//			body.textArea.paintImmediately(body.textArea.getBounds());
		}
		/*推其直播，这是websock发送来的弹幕信息
		 * @badge-info=subscriber/10;badges=moderator/1,subscriber/9;client-nonce=f7f64d5c6f6db174beff55ff8e2993df;color=#8A2BE2;display-name=MaxiPoooh;emotes=;first-msg=0;flags=;id=db26b8a3-74f2-44a4-a2a9-be9f9cb7800e;mod=1;returning-chatter=0;room-id=554057125;subscriber=1;tmi-sent-ts=1678521982543;turbo=0;user-id=635253163;user-type=mod :maxipoooh!maxipoooh@maxipoooh.tmi.twitch.tv PRIVMSG #batmanbugha :u are so drone
		 */
		if (message.contains("@badge-info=")) {
			String name = message.split("display-name=")[1].split(";")[0];
			String[] sz = message.split(":");
			String content = sz[sz.length - 1].replace("\\r\\n", "");
			String s = "T站[" + name + "]说：" + content + "\n\n";
			body.textArea.append(s);
		}
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		System.out.println("已启动");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				opreate();
			}
		}).start();
	}
	
	//隔几秒去除掉文本框内容一半的长度，防止内存过度占用
	private void opreate()   {
		while(true) {
			//没有这个线程睡眠，似乎实际执行中 i的值有问题，似乎条件判断过不去
			//总之结果是，条件判断中的语句不执行。但是debug中就没有问题
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			body.i=body.textArea.getDocument().getLength();
			if(body.i>300) {	
				try {
					body.textArea.getDocument().remove(1,(body.i)/2);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
