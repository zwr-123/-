# -
简单的websocket+swing界面

把如下代码添加到有直播弹幕信息的js中

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


