package com.cap.admin.secondpractice.practice;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cap.admin.secondpractice.Entity.Financial;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/12/26.
 */
public class HttpConnectionTest {
    public static String re;
    public static String getHttpConnection(String channel){
        String result=null;

        try {
            //http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=您申请的KEY
//            URL url=new URL("http://v.juhe.cn/weather/index?format=2&cityname="+URLEncoder.encode(city,"utf-8")+"&key=210afebc3529a3a6b1ce29e0b93b6f23");
            //百度api 天气
//            URL url=new URL("http://apis.baidu.com/apistore/weatherservice/cityname?&cityname="+URLEncoder.encode(city,"utf-8"));
            //宅言api动漫台词
//            URL url=new URL("http://apis.baidu.com/acman/zhaiyanapi/tcrand?fangfa=json");
            //新闻
//            String path="http://apis.baidu.com/showapi_open_bus/channel_news/search_news"+"?channelName="+URLEncoder.encode(channel,"utf-8");
//            String path="http://route.showapi.com/109-35?showapi_appid=29832&showapi_sign=f9df5f855d944b969ac0ef1a7b795ac9&channelName="+ URLEncoder.encode(channel,"utf-8")
//                    ;
//            String path="http://v.juhe.cn/toutiao/index?type="+URLEncoder.encode(channel,"utf-8")+"&key=237658ec4e5e6854e4ef226aff7c7e85";
            //新闻列表
//            String path="http://apis.baidu.com/showapi_open_bus/channel_news/channel_news";
            //新闻 易源
//            String path="http://route.showapi.com/109-35?showapi_appid=29832&showapi_sign=f9df5f855d944b969ac0ef1a7b795ac9&channelName="+URLEncoder.encode(channel,"utf-8")
//                    +"&needAllList=0";
            String path="http://linglu.canyoutong.com/index.php/App/Cart/Index/lists?token=dc35cf880383d9044b830290f6973e59";
            URL url=new URL(path);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestProperty("apikey","226e7856df784206e204eb4a890fd2cd");
            //设置请求方式,默认为GET
            httpURLConnection.setRequestMethod("GET");
            //设置连接时间
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);

            if(httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){//即200
                InputStream is=httpURLConnection.getInputStream();
                byte[] bytes=new byte[1024];
                StringBuffer sb=new StringBuffer();
                int len=0;
                while ((len=is.read(bytes))!=-1){
                    sb.append(new String(bytes,0,len));
                }
                result=sb.toString();
                httpURLConnection.disconnect();//关闭

            }else {
                result="连接失败";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getHttpPost(){
        String result=null;
        try {
            URL url=new URL("http://v.juhe.cn/exp/index");
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            //post没有 "？"
            String str="key="+
                    URLEncoder.encode("7738f5f7ed2e9c8e72dc01f62e0e6b63","utf-8")
                    +"&com="+
                    URLEncoder.encode("sf","utf-8")
                    +"&no="
                    +URLEncoder.encode("2668580464124430","utf-8");
            OutputStream os=connection.getOutputStream();
            os.write(str.getBytes());

            if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){//即200
                InputStream is=connection.getInputStream();
                byte[] bytes=new byte[1024];
                StringBuffer sb=new StringBuffer();
                int len=0;
                while ((len=is.read(bytes))!=-1){
                    sb.append(new String(bytes,0,len));
                }
                result=sb.toString();
                connection.disconnect();//关闭

            }else {
                result="连接失败";
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getMesgByVolley(final String channel, Context context){

        //消息
        StringRequest str=new StringRequest(Request.Method.POST, "http://v.juhe.cn/toutiao/index", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("msg", "onResponse: "+s);
                re=s;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String ,String> map=new HashMap<>();
                map.put("type",channel);
                map.put("key","237658ec4e5e6854e4ef226aff7c7e85");
                return map;
            }
        };
        //队列
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(str);//加入队列
        requestQueue.start();//开启

        return re;
    }
    //拿数据
    public static void getDataFromInternet(Context c){
        StringRequest stringRequest=new StringRequest(StringRequest.Method.GET, "http://linglu.canyoutong.com/index.php/App/Cart/Index/lists", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.i("osu", "这是:"+s);
                Financial fc=new Gson().fromJson(s, Financial.class);//解析
                Log.i("osu", "onResponse: "+fc.getData().get(0).getGoods_price());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // TODO Auto-generated method stub
                Map<String,String> map=new HashMap<>();
                map.put("token","1c7baaea7c91f089d1c597b8fb3f5a1e");
                return map;
            }
        };
        //队列
        RequestQueue requestQueue= Volley.newRequestQueue(c);
        requestQueue.add(stringRequest);//加入队列
        requestQueue.start();//开启
    }

}
