package com.example.jimmy.mvpproject.page.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jimmy.mvpproject.R;
import com.example.jimmy.mvpproject.model.Person;
import com.example.jimmy.mvpproject.page.main.task.getPerson;
import com.squareup.okhttp.MediaType;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
{

    public static final MediaType type = MediaType.parse("application/json; charset=utf-8");

    @Bind(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        final Person person = new Person();
//        person.setName("Jimmy");
//        person.setAge(17);

//        new HttpUtil().doGet("http://192.168.19.86:8080/JavaWeb/HelloWorld", new HttpResponse()
//        {
//            @Override
//            public void error(String error)
//            {
//                Log.e("MainActivity", error);
//            }
//
//            @Override
//            public void success(Response response)
//            {
//                try
//                {
//                    Log.e("MainActitity", response.body().string());
//                } catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        });

//        Map<String,Object> map = new HashMap<>();
//        map.put("name","jimmy");
//        map.put("age",17);
//
//        new HttpUtil().doPost("test.test", map, new HttpResponse()
//        {
//            @Override
//            public void error(String error)
//            {
//                Log.e("MainActivity", error);
//            }
//
//            @Override
//            public void success(Response response) throws IOException
//            {
//                Log.e("MainActivity", response.body().string() + "");
//            }
//        });

        new getPerson(this)
        {
            @Override
            protected void onPostExecute(TaskResult result)
            {
                super.onPostExecute(result);
                if (result.getError() == null)
                {
                    Person person = (Person) result.getResultData();
                    tvTest.setText(person.getName());
                }
                else
                {

                }
            }
        }.execute();
    }

}
