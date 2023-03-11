# -
简单的websocket+swing界面 。代码在master分支中。

运行程序前，添加如下代码到相应js文件的某个位置。保存到本地，下次网站就加载修改后的js。
此代码创建了websocket，把弹幕信息发送到本地，可自动重连。

!function(){
                                            if(window.flag){
                                                window.ws1.send(JSON.stringify(ot))
                                                      if(ws1.readyState === WebSocket.CLOSED){
                                                var ws = new WebSocket("ws://127.0.0.1:8299");
                                                ws1 = ws;
                                                flaggg = true;
                                                ws.open = function(evt) {
                                                ws.send(JSON.stringify(ot));
                                            }
                                            }
                                            }else{
                                                var ws=new WebSocket("ws://127.0.0.1:8299");
                                                window.ws1=ws;
                                                window.flag=true;
                                                ws.open=function(evt){
                                                    ws.send(JSON.stringify(ot))
                                        		}
                                                }
                                            }();


