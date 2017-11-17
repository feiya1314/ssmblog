package core.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;


public class HttpClientHelper {

	public static String sendPost(String urlParam,Map<String,Object> params,String charset){
		StringBuffer resultBuffer=null;
		StringBuffer sbBuffer=new StringBuffer();
		
		if(params!=null&&params.size()>0){
			for(Entry<String, Object> e:params.entrySet()){
				sbBuffer.append(e.getKey());
				sbBuffer.append("=");
				sbBuffer.append(e.getValue());
				sbBuffer.append("&");
			}
		}
		HttpURLConnection httpURLConn=null;
		OutputStreamWriter outputStreamWriter=null;
		BufferedReader bufferedReader=null;
		try {
			URL url=new URL(urlParam);
			httpURLConn=(HttpURLConnection)url.openConnection();
			httpURLConn.setRequestMethod("POST");
			httpURLConn.setDoOutput(true);
			httpURLConn.setDoInput(true);
			httpURLConn.setUseCaches(false);
			httpURLConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			if(sbBuffer!=null&&sbBuffer.length()>0){
				outputStreamWriter=new OutputStreamWriter(httpURLConn.getOutputStream(),charset);
				outputStreamWriter.write(sbBuffer.substring(0,sbBuffer.length()-1));
				outputStreamWriter.flush();
			}
			
			resultBuffer=new StringBuffer();
			
			int contentLength=Integer.parseInt(httpURLConn.getHeaderField("Content-Length"));
			
			if(contentLength>0){
				bufferedReader=new BufferedReader(new InputStreamReader(httpURLConn.getInputStream(),charset));
				String temp;
				while ((temp=bufferedReader.readLine())!=null) {
					resultBuffer.append(temp);
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			if(outputStreamWriter!=null){
				try {
					outputStreamWriter.close();
				} catch (IOException exception) {
					outputStreamWriter=null;
					exception.printStackTrace();
				}finally{
					if(httpURLConn!=null){
						httpURLConn.disconnect();
						httpURLConn=null;
					}
				}
				
			}
			if(bufferedReader!=null){
				try {
					bufferedReader.close();
				} catch (IOException e2) {
					// TODO: handle exception
					bufferedReader=null;
					e2.printStackTrace();
				}finally{
					if(httpURLConn!=null){
						httpURLConn.disconnect();
						httpURLConn=null;
					}
				}
				
			}
		}
		return resultBuffer.toString();
	}
	
	public static String sendGet(String urlParam, Map<String, Object> params, String charset) {  
        StringBuffer resultBuffer = null;  
        // 构建请求参数  
        StringBuffer sbParams = new StringBuffer();  
        if (params != null && params.size() > 0) {  
            for (Entry<String, Object> entry : params.entrySet()) {  
                sbParams.append(entry.getKey());  
                sbParams.append("=");  
                sbParams.append(entry.getValue());  
                sbParams.append("&");  
            }  
        }  
        HttpURLConnection con = null;  
        BufferedReader br = null;  
        try {  
            URL url = null;  
            if (sbParams != null && sbParams.length() > 0) {  
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));  
            } else {  
                url = new URL(urlParam);  
            }  
            con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			/*con.setRequestProperty("Accept-Encoding","gzip, deflate");
			con.setRequestProperty("Referrer Policy","no-referrer-when-downgrade");
			con.setRequestProperty("Connection","keep-alive");
			con.setRequestProperty("Referer","http://news-at.zhihu.com/");
			// client.setRequestProperty("Accept-Language:","zh-CN,zh;q=0.8");
			con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
            con.setRequestProperty("Cookie","d_c0=\"ACACAnng7guPTk6mT5VC2ZeT3W-qNEssrMw=|1497789314\"; _zap=f46a5756-7bb4-43be-9385-156451c00ed0; r_cap_id=\"ZGJmOWFiZmFhZDZjNDIwYTgzNzk2MTVmY2M2MDAxOTM=|1508578867|f64bc0a2afa56f52c41db12dfe4165dc2123eb97\"; cap_id=\"NTJlNzkwMDg1MjcxNDdlN2JiYThmZjE5ZTg2MDMxMzI=|1508578867|502a85160d4382943d68328c2eacdc9e4e69922b\"; z_c0=Mi4xNk14bUFBQUFBQUFBSUFJQ2VlRHVDeGNBQUFCaEFsVk5QR1RZV2dBQUJBUmJsNDBnTFBTYUN3UTNvUWJSUXJzT29n|1508578876|46f1cb3a9d087d59e8beea3122c14e8be06ce0b4; q_c1=5ace386c06ff4f6fa3d7731c4d319f83|1508764547000|1497789314000; _ga=GA1.2.25468016.1509262488; __utma=51854390.25468016.1509262488.1510579531.1510750158.15; __utmz=51854390.1510750158.15.15.utmcsr=zhihu.com|utmccn=(referral)|utmcmd=referral|utmcct=/question/35600811; __utmv=51854390.100-1|2=registration_date=20140629=1^3=entry_date=20140629=1; aliyungf_tc=AQAAAKbRWAEemgwAquRx3GQnjkr7qEfH");
			*/
			con.connect();
            resultBuffer = new StringBuffer();  
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));  
            String temp;  
            while ((temp = br.readLine()) != null) {  
                resultBuffer.append(temp);  
            }  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        } finally {  
            if (br != null) {  
                try {  
                    br.close();  
                } catch (IOException e) {  
                    br = null;  
                    throw new RuntimeException(e);  
                } finally {  
                    if (con != null) {  
                        con.disconnect();  
                        con = null;  
                    }  
                }  
            }  
        }  
        return resultBuffer.toString();  
    }

	public static String[] sendGet(String[] urlParams, String charset) {
		StringBuffer resultBuffer = null;
		String[] jsonResults=null;
		// 构建请求参数
		/*StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}*/
		HttpURLConnection con = null;
		BufferedReader br = null;
		try {
			URL url = null;
			for(int i=0;i<urlParams.length;i++){
				url = new URL(urlParams[i]);
				con = (HttpURLConnection) url.openConnection();
				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				con.connect();
				resultBuffer = new StringBuffer();
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}

				jsonResults[i]=resultBuffer.toString();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}
		return jsonResults;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlParam="http://news-at.zhihu.com/api/4/news/latest";
		String result;
		result=HttpClientHelper.sendGet(urlParam, null, "utf-8");
		System.out.println(result);
	}

}
