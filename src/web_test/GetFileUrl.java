package web_test;

import java.net.URL;
import java.util.Date;

import com.netease.cloud.ClientConfiguration;
import com.netease.cloud.Protocol;
import com.netease.cloud.auth.BasicCredentials;
import com.netease.cloud.auth.Credentials;
import com.netease.cloud.services.nos.NosClient;
import com.netease.cloud.services.nos.model.GeneratePresignedUrlRequest;

public class GetFileUrl {
	public URL getFileUrl(String bucketName,String key) {	
		String accessKey = "385d26b7f5c740fbbdd2501e18dd90f9";
		String secretKey = "d5254303e29b49ebaa05de2264658ece";
		Credentials credentials = new BasicCredentials(accessKey, secretKey);
		ClientConfiguration conf = new ClientConfiguration();
		// 设置 NosClient 使用的最大连接数
		conf.setMaxConnections(200);
		// 设置 socket 超时时间
		conf.setSocketTimeout(10000);
		// 设置失败请求重试次数
		conf.setMaxErrorRetry(2);
		// 如果要用 https 协议，请加上下面语句
		conf.setProtocol(Protocol.HTTPS);
		//实例化NosClient对象
	    NosClient nosClient=new NosClient(credentials,conf);
	    nosClient.setEndpoint("nos-eastchina1.126.net");
		GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, key);
		//setExpiration为当前时间点+过期时间，设置可下载URL的过期时间。默认过期时间为1天。
		generatePresignedUrlRequest.setExpiration(new Date(System.currentTimeMillis()+3600*1000*24));
		URL url = nosClient.generatePresignedUrl(generatePresignedUrlRequest);
		return url;
	}

}
