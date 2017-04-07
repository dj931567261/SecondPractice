package com.cap.admin.secondpractice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.cap.admin.secondpractice.Entity.BaiduTian;
import com.cap.admin.secondpractice.Entity.Financial;
import com.cap.admin.secondpractice.Entity.FinancialItem;
import com.cap.admin.secondpractice.Entity.TestNews;
import com.cap.admin.secondpractice.Entity.TianQI;
import com.cap.admin.secondpractice.Entity.XinWen;
import com.cap.admin.secondpractice.Entity.ZhaiYAn;
import com.cap.admin.secondpractice.practice.HttpConnectionTest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/1/2.
 */
public class HttpConnectTestActivity extends AppCompatActivity {
    public static String TAG="msg";
    TextView tv;
    Handler handler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_connect_test);
        tv= (TextView) findViewById(R.id.http_connection_test_tv);

        new Thread(new MyHttp()).start();

        handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                switch (msg.what){
                    case 0:
                        String b= (String) msg.obj;

                        tv.setText(b);
                        break;
                }
                return false;
            }
        });

    }


    class MyHttp implements Runnable{

        @Override
        public void run() {
//            String a= HttpConnectionTest.getHttpConnection();


            String a=HttpConnectionTest.getHttpConnection("游戏");

            Log.i("msg", "run: "+a);
            StringBuffer sb=new StringBuffer();
//            JSONObject js= null;
//            try {
//                js = new JSONObject(a);
//                JSONObject re=js.getJSONObject("result");
//                TestNews tn=new Gson().fromJson(re.toString(),TestNews.class);
//                List<TestNews.DataBean> list=tn.getData();
//                for (int i = 0; i < list.size(); i++) {
//                    String title=list.get(i).getTitle();
//                    sb.append(title);
//                }
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }





            //Volley
//            String a=HttpConnectionTest.getMesgByVolley("shehui",HttpConnectTestActivity.this);
            //易源新闻接口
//            try {
//                JSONObject js=new JSONObject(a);
//                JSONObject show= js.getJSONObject("showapi_res_body");
//                JSONObject pagebean=show.getJSONObject("pagebean");
//                XinWen xinWen=new Gson().fromJson(pagebean.toString(),XinWen.class);
//                List<XinWen.ContentlistBean> list=xinWen.getContentlist();
//
//                for (int i = 0; i <list.size() ; i++) {
////                    List<XinWen.ContentlistBean.ImageurlsBean> imglist=list.get(i).getImageurls();
////                    String url=imglist.get(0).getUrl();
//                    if(list.get(i).getImageurls().size()>0){
//                        String url=list.get(i).getImageurls().get(0).getUrl();
//                        sb.append(" "+url);
//                    }
//                    String tiltle=list.get(i).getTitle();
//                    sb.append(""+tiltle);
//
//                }
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }


            //宅言api
//            ZhaiYAn zhai=new Gson().fromJson(a,ZhaiYAn.class);

//            sb.append(a);
//            try {
//                JSONObject jj=new JSONObject(a);
//                JSONObject jo=jj.getJSONObject("showapi_res_body");
//                JSONArray ja=jo.getJSONArray("channelList");
//
//                if(ja.length()>0){
//                    for (int i = 0; i < ja.length(); i++) {
//                        JSONObject js=ja.getJSONObject(i);
//                        String b=js.getString("name");
//                        Log.i(TAG, "run: "+b);
//                        sb.append(b+"\t");
//                    }
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            sb.append(zhai.getId());
//            sb.append("\n");
//            sb.append(zhai.getTaici());
//            sb.append("\n");
//            sb.append(zhai.getCatcn());
//            sb.append("\n");
//            sb.append(zhai.getShow());
//            sb.append("\n");
//            sb.append(zhai.getSource());
//            try {
//                JSONObject js=new JSONObject("showapi_res_body");
//                XinWen xinWen=new Gson().fromJson(js.toString(),XinWen.class);
//                sb.append("\n"+xinWen.getAllPages());
//                Log.i("msg", "run: "+xinWen.getAllPages());
//
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

            Message msg=new Message();
            msg.what=0;
            msg.obj=sb.toString();
            handler.sendMessage(msg);


////            String a="{\"resultcode\":\"200\",\"reason\":\"successed!\",\"result\":{\"sk\":{\"temp\":\"3\",\"wind_direction\":\"东南风\",\"wind_strength\":\"1级\",\"humidity\":\"52%\",\"time\":\"09:15\"},\"today\":{\"temperature\":\"3℃~11℃\",\"weather\":\"晴转多云\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"01\"},\"wind\":\"北风微风\",\"week\":\"星期二\",\"city\":\"成都\",\"date_y\":\"2016年12月27日\",\"dressing_index\":\"较冷\",\"dressing_advice\":\"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。\",\"uv_index\":\"中等\",\"comfort_index\":\"\",\"wash_index\":\"较适宜\",\"travel_index\":\"较不宜\",\"exercise_index\":\"较不宜\",\"drying_index\":\"\"},\"future\":[{\"temperature\":\"3℃~11℃\",\"weather\":\"晴转多云\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"01\"},\"wind\":\"北风微风\",\"week\":\"星期二\",\"date\":\"20161227\"},{\"temperature\":\"2℃~11℃\",\"weather\":\"晴转多云\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期三\",\"date\":\"20161228\"},{\"temperature\":\"4℃~11℃\",\"weather\":\"阴转多云\",\"weather_id\":{\"fa\":\"02\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期四\",\"date\":\"20161229\"},{\"temperature\":\"3℃~12℃\",\"weather\":\"晴转多云\",\"weather_id\":{\"fa\":\"00\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期五\",\"date\":\"20161230\"},{\"temperature\":\"4℃~10℃\",\"weather\":\"小雨\",\"weather_id\":{\"fa\":\"07\",\"fb\":\"07\"},\"wind\":\"北风微风\",\"week\":\"星期六\",\"date\":\"20161231\"},{\"temperature\":\"4℃~11℃\",\"weather\":\"阴转多云\",\"weather_id\":{\"fa\":\"02\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期日\",\"date\":\"20170101\"},{\"temperature\":\"4℃~11℃\",\"weather\":\"阴转多云\",\"weather_id\":{\"fa\":\"02\",\"fb\":\"01\"},\"wind\":\"南风微风\",\"week\":\"星期一\",\"date\":\"20170102\"}]},\"error_code\":0}\n";
//            Log.i("msg", "run: "+a);
//            try {
//                JSONObject js=new JSONObject(a);
////                String c=js.getString("resultcode");
//                String c=js.getString("errMsg");
////                JSONObject re=js.getJSONObject("result");
//                JSONObject re=js.getJSONObject("retData");
//                Log.i("msg", "c: "+c);
////                JSONObject today = re.getJSONObject("today");
////                String  city = today.getString("city");
//                String city=re.getString("city");
//                if(c.equals("success")){
//                    Log.i("msg", "city: "+city);
////                    TianQI.ResultBean t=new Gson().fromJson(a,TianQI.ResultBean.class);
//                    BaiduTian.RetDataBean t = new Gson().fromJson(re.toString(),BaiduTian.RetDataBean.class);//用result的那段来解析result的基类，一一对应
//
//                    String ab;
//                    if(t!=null){
//                        ab=t.getCity();
//                    }else {
//                        ab="t为null";
//                    }
//                    Message msg=new Message();
//                    msg.what=0;
//                    msg.obj=ab;
//                    handler.sendMessage(msg);
//
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }


//            TianQI t=new Gson().fromJson(a.toString(),TianQI.class);
//
//            String ab;
//            if(t!=null){
//                ab=t.getToday().getCity();
//            }else {
//                ab="t为null";
//            }
//            Message msg=new Message();
//            msg.what=0;
//            msg.obj=ab;
//            handler.sendMessage(msg);
        }
    }
}
