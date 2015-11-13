package com.zyq.imclient;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;


/**
 *      Smack4.1.4 demo
 *
 *    created by piyell   QQ锛�479683952
 *
 *              2015.11
 *
 */

public class MainActivity extends Activity {
	

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new Thread(){
			public void run() {

				boolean target=false; 
				XMPPTCPConnectionConfiguration config = XMPPTCPConnectionConfiguration.builder()  
						.setUsernameAndPassword("admin", "zyq1903")  
						.setServiceName("zyq-pc")  
						.setHost("192.168.2.102")  
						.setPort(5222)  
						.build(); 

				AbstractXMPPConnection conn = new XMPPTCPConnection(config);  
				try {  
					conn.connect();  
					target = conn.isConnected();  
					if(target){  
						System.out.println("XMPP 服务器连接成功"); 
						
						conn.login("zyq", "19931008");

						
					}else{  
						System.out.println("XMPP 服务器连接不成功");  
						
					}  
				} catch (SmackException | IOException | XMPPException e) {  
					System.out.println("XMPP 服务器连接不成功");   
					e.printStackTrace();  
				}  


			}

		}.start();


	}


}
